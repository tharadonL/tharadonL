package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class AssetsOwnedController {
    @FXML
    public void OnBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("assets-can-borrow");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void OnConfirmButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("assets-can-borrow");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
