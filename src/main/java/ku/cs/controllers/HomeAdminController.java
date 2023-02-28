package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class HomeAdminController {
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
    public void AddStaffButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("staff-register");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void ListNextButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("list-system");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
