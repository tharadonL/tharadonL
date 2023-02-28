package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ku.cs.models.Account;
import ku.cs.models.Asset;
import ku.cs.models.AssetList;
import ku.cs.services.AssetFileDataSource;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class UserMainController {
    private Asset selectedAsset;

    @FXML
    private AssetFileDataSource assetFileDataSource;

    @FXML private ListView<Asset> assetsListView;
    @FXML private Label statusLabel;
    @FXML private Label SerialNumberLabel;
    @FXML private Label NameLabel;
    @FXML private Label CategoryLabel;
    @FXML private ImageView userImageView;
    private AssetList assetList;

    public Account loginAccount;
    @FXML
    public void initialize(){
        loginAccount = (Account) ku.cs.services.FXRouter.getData();
        assetFileDataSource = new AssetFileDataSource();
        assetFileDataSource.readData();
        assetList = assetFileDataSource.getAllAssetList();
        showListView();
        handleSelectedListView();
    }
    private void showListView() {
        assetsListView.getItems().clear();
        assetsListView.getItems().addAll(assetList.getAllAsset());
        assetsListView.refresh();
    }
    private void showSelectedAsset(Asset asset) {
        NameLabel.setText(asset.getName());
        CategoryLabel.setText(asset.getCategory());
        SerialNumberLabel.setText(asset.getSerialNumber());
        statusLabel.setText(asset.getStatus());
        userImageView.setImage(new Image("file:"+selectedAsset.getImagePath(), true));
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

    @FXML
    public void onBackUserMainButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("user-main");
        } catch (IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onHistoryButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("user-history");
        } catch (IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }

}
