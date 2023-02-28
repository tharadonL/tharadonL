package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import ku.cs.models.Material;
import ku.cs.models.MaterialList;
import ku.cs.services.DataSource;
import ku.cs.services.FXRouter;
import ku.cs.services.MaterialListDataSource;

import java.io.File;
import java.io.IOException;

public class MaterialController {
    @FXML
    private ObservableList<Material> material = FXCollections.observableArrayList();

    @FXML
    private ListView MaterialListView;

    @FXML
    private ListView AddListView;

    @FXML
    private ListView BorrowListView;

    @FXML
    private Label AmountLabel;

    @FXML
    private TableView<?> BorrowTable;

    @FXML
    private Label CategoryLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private Circle circle;

    @FXML
    private ImageView MaterialImageView;

    @FXML
    private Label StaffNameLabel;

    @FXML
    private AnchorPane parent;

    @FXML
    private ComboBox<?> sortByCategoryBox;

    @FXML
    private TableView<?> table;

    private MaterialList materialList;

    public void initialize(){
        initialSetLabel();
        DataSource<MaterialList> materialListDataSource = new MaterialListDataSource();
        materialList = materialListDataSource.readData();
        showMaterialListView();
        handleSelectMaterialListView();
//        File file = new File("src/main/resources/");
//        Image image = new Image(file.toURI().toString());
    }

    private void showMaterialListView(){
        MaterialListView.getItems().addAll(materialList.getMaterialList());
        MaterialListView.refresh();
//        AddListView.getItems().addAll(material.toStringAdd());
//        AddListView.refresh();
//        BorrowListView.getItems().addAll(material.toStringBorrow());
//        BorrowListView.refresh();
    }

    private void handleSelectMaterialListView() {
        MaterialListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Material>() {
                    @Override
                    public void changed(ObservableValue<? extends Material> observableValue,
                                        Material oldValue, Material newValue) {
                        System.out.println(newValue + " is selected");
                        NameLabel.setText(newValue.getName());
                        CategoryLabel.setText(newValue.getCategory());
                        AmountLabel.setText(newValue.getAmount());
                        String directoryName = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "images" + File.separator + "MaterialImages";
                        String filepath = directoryName + File.separator + newValue.getNumber() + ".png";
//                        if(newValue!=null)showSelectedAccount(newValue);
                    }
                });

    }


    private void initialSetLabel(){
        AmountLabel.setText("");
        CategoryLabel.setText("");
        NameLabel.setText("");
        StaffNameLabel.setText("");
    }

    @FXML
    void OnLogOutButton(ActionEvent event) {
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
        }
    }

    @FXML
    void OnManageButton(ActionEvent event) {
        try {
            FXRouter.goTo("material-manage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void OnEditButton(ActionEvent event) {
        try {
            FXRouter.goTo("home-staff");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void AddButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("material-add");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void OnBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("staff0");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void OnInfoButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("material-info");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
