package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import ku.cs.models.Asset;
import ku.cs.models.AssetList;
import ku.cs.services.AssetFileDataSource;
import ku.cs.services.DataSource;
import ku.cs.services.FXRouter;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class StaffAssetsAddController {

    @FXML private TextField addAssetID;

    @FXML private TextField addQuantityAsset;
    @FXML private ChoiceBox<String> assetNameChoiceBox;
    @FXML private ChoiceBox<String> assetstypeChoicebox ;

    private AssetFileDataSource dataSource;
    private AssetList assetList;
    @FXML private ImageView assetImageView;
    private Asset assetForSetImagePath;
    @FXML
    public void handleUploadImageButton(ActionEvent event) {
        FileChooser chooser = new FileChooser();

        // SET FILECHOOSER INITIAL DIRECTORY
        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));


        // DEFINE ACCEPTABLE FILE EXTENSION
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("images PNG JPG", "*.png", "*.jpg", "*.jpeg"));

        // GET FILE FROM FILECHOOSER WITH JAVAFX COMPONENT WINDOW
        Node source = (Node) event.getSource();
        File file = chooser.showOpenDialog(source.getScene().getWindow());

        if (file != null) {
            try {

                // CREATE FOLDER IF NOT EXIST
                File destDir = new File("images");

                if (!destDir.exists()) destDir.mkdirs();


                // RENAME FILE
                String[] fileSplit = file.getName().split("\\.");

                String filename = LocalDate.now() + "_" + System.currentTimeMillis() + "."
                        + fileSplit[fileSplit.length - 1];
                Path target = FileSystems.getDefault().getPath(
                        destDir.getAbsolutePath() + System.getProperty("file.separator") + filename
                );


                // COPY WITH FLAG REPLACE FILE IF FILE IS EXIST
                Files.copy(file.toPath(), target, StandardCopyOption.REPLACE_EXISTING);


                // SET NEW FILE PATH TO IMAGE
                assetImageView.setImage(new Image(target.toUri().toString()));

                //setImagePath
                Asset assetForSetImagePath = new Asset("serialNumberSetImage","nameSetImage","categorySetImage");
                assetForSetImagePath.setImagePath(destDir + "/" + filename);
                this.assetForSetImagePath = assetForSetImagePath; //พอ uplosd imsge จะมาเก็นน image path oี้
//                System.out.println("Upload: "+accountForSetImagePath.getImagePath())
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void BackStaff1Button(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("staff1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    public void initialize(){
        showAssetsTypeChoiceBox();
        showAssetsNameChoiceBox();

    }

    public void showAssetsNameChoiceBox(){
        dataSource = new AssetFileDataSource();
        dataSource.readData();
        assetList = dataSource.getAllAssetList();
        Collection<String> availableAssetType =  new HashSet<>();
        for(Asset assetFind : assetList.getAllAsset()){
            availableAssetType.add(String.valueOf(assetFind.getName()));
        }
        assetNameChoiceBox.getItems().addAll(availableAssetType);
    }
    public void showAssetsTypeChoiceBox() {
        dataSource = new AssetFileDataSource();
        dataSource.readData();
        assetList = dataSource.getAllAssetList();
        Collection<String> availableAssetType =  new HashSet<>();
        for(Asset assetFind : assetList.getAllAsset()){
            availableAssetType.add(String.valueOf(assetFind.getCategory()));
        }
        assetstypeChoicebox.getItems().addAll(availableAssetType);
    }

    public void handleConfirmButton(ActionEvent actionEvent){
        DataSource<AssetList> dataSource = new AssetFileDataSource();
        AssetList assetList = dataSource.readData();
        if(addAssetID.getText().equals("") || assetstypeChoicebox.getValue().equals("") || assetNameChoiceBox.getValue().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Information should not empty.");  //ถ้าค่าโล่ง มันก้จะขึ้นมาว่า ต้องใส่ข้มูล ค่ามันว่าง
            alert.showAndWait();
        }else{
            String idStr = addAssetID.getText();  //ดึง ข้อมูลจาก text field ,าเป็ย str
            String categoryStr = assetstypeChoicebox.getValue();
            String nameStr = assetNameChoiceBox.getValue(); //from choice box

            if (!(assetForSetImagePath==null)) { //ถ้าไม่เท่ากับ null เราจะเเอดใหม่
                assetList.addAsset(new Asset(idStr,nameStr,categoryStr,assetForSetImagePath.getImagePath(),"-","net lend"));

            }else{
                assetList.addAsset(new Asset(idStr,nameStr,categoryStr,"images/default.png","-","not lend"));
            } //null = default


            dataSource.writeData(assetList);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("COMPLETE");
            alert.setHeaderText(null);
            alert.setContentText("Add success.");
            alert.showAndWait(); //pop up
        }
    }


}
