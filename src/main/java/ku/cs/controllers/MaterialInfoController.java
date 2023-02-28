package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class MaterialInfoController {
    @FXML
    public void OnBackButton (ActionEvent actionEvent) {
        try {
            FXRouter.goTo("material");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
