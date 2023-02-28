package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import ku.cs.models.Asset;
import ku.cs.models.AssetList;
import ku.cs.services.AssetFileDataSource;
import ku.cs.services.FXRouter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;


public class StaffAssetsMainController {

    private Asset selectedAsset;

    @FXML private AssetFileDataSource assetFileDataSource;

    @FXML private ListView<Asset> assetsListView;

    @FXML private Label SerialNumberLabel;
    @FXML private Label NameLabel;
    @FXML private Label CategoryLabel;
    @FXML private ImageView userImageView;



    private AssetList assetList;
    @FXML
    public void initialize(){
        assetFileDataSource = new AssetFileDataSource();
        assetFileDataSource.readData();
        assetList = assetFileDataSource.getAllAssetList();
        showListView();
        handleSelectedListView();
    }

    private void showListView() {
        assetsListView.getItems().clear();
        assetsListView.getItems().addAll(assetList.getAllAsset());  //show list view from all assets
        assetsListView.refresh();
    }
    @FXML
    public void onHelloBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("staff0");
        } catch (IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onStaff2NextButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("staff2");
        } catch (IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void Staff5Button(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("staff5");
        } catch (IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void Staff3Button(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("staff3");
        } catch (IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }




    private void handleSelectedListView() {
        assetsListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Asset>() {
                    @Override
                    public void changed(ObservableValue<? extends Asset> observable,
                                        Asset oldValue, Asset newValue) {
                        if (newValue != null) {
                            //System.out.println(newValue + " is selected");
                            selectedAsset = newValue;
                            showSelectedAsset(newValue);
                        }
                    }
                });
    }
    private void showSelectedAsset(Asset asset) {
        NameLabel.setText(asset.getName());
        CategoryLabel.setText(asset.getCategory());
        SerialNumberLabel.setText(asset.getSerialNumber());
        userImageView.setImage(new Image("file:"+selectedAsset.getImagePath(), true));
    }





}
