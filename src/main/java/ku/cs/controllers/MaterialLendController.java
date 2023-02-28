package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.models.LendMaterialList;
import ku.cs.models.Material;
import ku.cs.models.MaterialList;
import ku.cs.services.DataSource;
import ku.cs.services.FXRouter;
import ku.cs.services.LendMaterialListDataSource;
import ku.cs.services.MaterialListDataSource;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MaterialLendController {

    @FXML
    private TextField AmountBorrowTextField;

    @FXML
    private ListView LendMaterialListView;

    @FXML
    private Label AmountBorrowLabel;

    @FXML
    private ChoiceBox<String> UserChoiceBox;

    private String[] userChoices = {"user1","user2","user3","user4"};

    @FXML
    private Label AlertLabel;

    @FXML
    private Label UserBorrowLabel;

    @FXML
    private Label DateBorrowLabel;

    private String name;

    private String number;

    private String category;

    private String date;

    private String username;

    private MaterialList materialList;
    private DataSource<MaterialList> materialListDataSource;
    private LendMaterialList lendMaterialList;
    private DataSource<LendMaterialList> lendMaterialListDataSource;

    public void initialize(){
        materialListDataSource = new MaterialListDataSource("data/csv", "Materials.csv");
        materialList = materialListDataSource.readData();
        lendMaterialListDataSource = new LendMaterialListDataSource("data/csv", "requestMaterials.csv");
        lendMaterialList = lendMaterialListDataSource.readData();
        UserChoiceBox.setValue("เลือกผู้ใช้");
        UserChoiceBox.getItems().addAll(userChoices);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now);
        showMaterialListView();
        initialSetLabel();
        handleSelectMaterialListView();
    }

    private void initialSetLabel(){
        AmountBorrowLabel.setText("");
    }

    public void clear(){
        AmountBorrowTextField.clear();
        UserChoiceBox.valueProperty().set(null);
        AlertLabel.setText("");
    }

    private void showMaterialListView(){
        LendMaterialListView.getItems().addAll(lendMaterialList.getLendMaterialList());
        LendMaterialListView.refresh();
    }

    private void handleSelectMaterialListView() {
        LendMaterialListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Material>() {
                    @Override
                    public void changed(ObservableValue<? extends Material> observableValue,
                                        Material oldValue, Material newValue) {
                        System.out.println(newValue + " is selected");
                        UserBorrowLabel.setText(newValue.getName());
                        DateBorrowLabel.setText(newValue.getCategory());
                        AmountBorrowLabel.setText(newValue.getAmount());
                        String directoryName = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "images" + File.separator + "MaterialImages";
                        String filepath = directoryName + File.separator + newValue.getNumber() + ".png";
//                        if(newValue!=null)showSelectedAccount(newValue);
                    }
                });

    }
    @FXML
    public void OnLendMaterialButton(ActionEvent actionEvent) {

    }

    @FXML
    public void OnBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("material-manage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
