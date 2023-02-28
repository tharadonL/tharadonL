package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import ku.cs.models.LendAsset;
import ku.cs.models.LendAssetList;
import ku.cs.services.FXRouter;
import ku.cs.services.LendAssetFileDataSource;

import java.io.IOException;

public class StaffLendBorrowAssetsController {
    @FXML private ListView<LendAsset> lendAssetListView ;
    private LendAssetFileDataSource LendAssetFileDataSource;
    private LendAssetList lendAssetList;

    @FXML
    public void initialize(){
        LendAssetFileDataSource = new LendAssetFileDataSource();
        LendAssetFileDataSource.readData();
        lendAssetList = LendAssetFileDataSource.getAllLendAssetList();
        showListView();
    }

    private void showListView() {
        lendAssetListView.getItems().clear();
        lendAssetListView.getItems().addAll(lendAssetList.getAllAsset());
        lendAssetListView.refresh();
    }

    @FXML
    public void OnBackStaff1Button(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("staff1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}