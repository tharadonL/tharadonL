package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Account;
import ku.cs.models.AccountList;
import ku.cs.services.DataSource;
import ku.cs.services.FXRouter;

import java.io.IOException;

import javafx.scene.control.TextField;
import ku.cs.services.UserDataSource;

public class LoginController {
    @FXML private TextField PasswordTextField;
    @FXML private TextField UsernameTextField;
    @FXML private Label FailedLabel;
    private DataSource<AccountList> dataSource = new UserDataSource();
    private AccountList accountList = dataSource.readData();
    private Account loginAccount;

    @FXML
    public void RegisterNextButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("register");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void OrganizersButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("organizers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void HowToButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("how-to-use");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void LoginUserButton(ActionEvent actionEvent){
        String username = UsernameTextField.getText();
        String password = PasswordTextField.getText();
        Account user = accountList.searchAccountByUsername(username);
        if(username == "" && password == ""){
            FailedLabel.setText("โปรดกรอกข้อมูลให้ครบ");
            FailedLabel.setStyle("-fx-text-fill: #f61e1e");

        } else if (!accountList.loginSuccess(username,password)){
            FailedLabel.setText("ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง");
            FailedLabel.setStyle("-fx-text-fill: #f61e1e");
        } else {
            try {
                user.initialLoginTime();
                if (user.isStudent())
                    FXRouter.goTo("home-user", loginAccount);
                else if (user.isStaff())
                    FXRouter.goTo("home-staff", loginAccount);
                else if (user.isAdmin())
                    FXRouter.goTo("home-admin", loginAccount);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
