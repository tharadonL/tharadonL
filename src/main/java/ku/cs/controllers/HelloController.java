package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void OnMaterialButton() {
        try {
            FXRouter.goTo("material");
        } catch (IOException e) {
            throw new RuntimeException(e);
        };
    }

    @FXML
    protected void OnBorrowButton() {
        try {
            FXRouter.goTo("assets-can-borrow");
        } catch (IOException e) {
            throw new RuntimeException(e);
        };
    }
}