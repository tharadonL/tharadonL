package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class StaffMaterialAssetsController {
    @FXML
    public void Staff1Button(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("staff1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void MaterialButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("material");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void StaffBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("home-staff");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
