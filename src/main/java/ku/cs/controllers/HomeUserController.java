package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import ku.cs.models.Account;
import ku.cs.models.AccountList;
import ku.cs.services.DataSource;
import ku.cs.services.FXRouter;
import ku.cs.services.UserDataSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class HomeUserController {
    @FXML
    private Label UserLabel;
    @FXML
    private Label NameLabel;
    @FXML
    private Rectangle previewImage;
    private DataSource<AccountList> dataSource;
    private Account account;
    private AccountList accountList;
    private File imageFile;
    @FXML
    public void LoginBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void ChangeNextButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("change-pass");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void UserNextButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("user-main");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void initialize(){
        account = (Account) FXRouter.getData();
        dataSource = new UserDataSource();
        accountList = dataSource.readData();
        showUserData();
    }
    private void showUserData() {
        if (account != null) {
            UserLabel.setText(account.getDisplayname());
            File image = new File(account.getImagePath());
            previewImage.setFill(new ImagePattern(new Image(image.toURI().toString())));
            NameLabel.setText(account.getUsername());
        }
    }
    public void handleUploadImageButton(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        imageFile = fileChooser.showOpenDialog(null);
        if(imageFile != null){
            try {
                String imagePath = imageFile.getAbsolutePath();
                File tempImagePNG = new File("data/profileUsers"+ File.separator+ "temp.png");
                Path pathOut = (Path) Paths.get(tempImagePNG.getAbsolutePath());
                Files.copy(imageFile.toPath(), pathOut, StandardCopyOption.REPLACE_EXISTING);
                System.out.println(imagePath);
                previewImage.setFill(new ImagePattern(new Image(tempImagePNG.toURI().toString())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.err.println("Can't upload image");
        }
    }
}
