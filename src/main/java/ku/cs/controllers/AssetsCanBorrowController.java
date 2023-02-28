package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class AssetsCanBorrowController {
    @FXML
    public void OnBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("home-user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void OnOwnedButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("assets-owned");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void OnHistoryButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("user-history");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
