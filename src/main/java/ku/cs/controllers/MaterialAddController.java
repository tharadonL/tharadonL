package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.models.AddMaterialList;
import ku.cs.models.Material;
import ku.cs.models.MaterialList;
import ku.cs.services.DataSource;
import ku.cs.services.FXRouter;
import ku.cs.services.AddMaterialListDataSource;
import ku.cs.services.MaterialListDataSource;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MaterialAddController {

    @FXML
    private TextField CategoryTextField;

    @FXML
    private TextField NameTextField;

    @FXML
    private TextField AmountAddTextField;

    @FXML
    private ListView MaterialListView;

    @FXML
    private Label AmountAddLabel;

    @FXML
    private Label DateAddLabel;

    @FXML
    private Label AlertLabel;

    private String name;

    private String number;

    private String category;

    private String date;

    private String username;

    private MaterialList materialList;
    private DataSource<MaterialList> materialListDataSource;
    private AddMaterialList addMaterialList;
    private DataSource<AddMaterialList> addMaterialListDataSource;

    public void initialize(){
        materialListDataSource = new MaterialListDataSource("data/csv", "Materials.csv");
        materialList = materialListDataSource.readData();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now);
        showMaterialListView();
        initialSetLabel();
        handleSelectMaterialListView();
    }

    private void showMaterialListView() {
        MaterialListView.getItems().addAll(materialList.getMaterialList());
        MaterialListView.refresh();
    }

    @FXML
    void OnAddButton(ActionEvent event) {
        if(NameTextField.getText() != "" &&  AmountAddTextField.getText() != ""&& CategoryTextField.getText()!= "") {
            String name = NameTextField.getText();
            String amount = AmountAddTextField.getText();
            String category = CategoryTextField.getText();
            materialList.addMaterial(new Material(name,category,amount,date));
            materialListDataSource.writeData(materialList);
            clear();

        }
        else {
            AlertLabel.setText("โปรดกรอกรายละเอียดให้ครบ");
            AlertLabel.setStyle("-fx-text-fill: #f61e1e");
        }
    }

    private void handleSelectMaterialListView() {
        MaterialListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Material>() {
                    @Override
                    public void changed(ObservableValue<? extends Material> observableValue,
                                        Material oldValue, Material newValue) {
                        System.out.println(newValue + " is selected");
                        DateAddLabel.setText(newValue.getDate());
                        AmountAddLabel.setText(newValue.getAmount());
                        String directoryName = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "images" + File.separator + "MaterialImages";
                        String filepath = directoryName + File.separator + newValue.getNumber() + ".png";
//                        if(newValue!=null)showSelectedAccount(newValue);
                    }
                });
    }

    public void clear(){
        NameTextField.clear();
        AmountAddTextField.clear();
        CategoryTextField.clear();
        AlertLabel.setText("");
    }

    private void initialSetLabel(){
        AmountAddLabel.setText("");
        DateAddLabel.setText("");
    }

    @FXML
    public void BackMaterialButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("material-manage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
