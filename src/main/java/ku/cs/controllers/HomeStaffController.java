package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class HomeStaffController {

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
    public void StaffNextButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("staff0");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
