package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class MaterialManageController {
    @FXML
    public void OnBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("material");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void OnAddMaterialButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("material-add");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void OnLendMaterialButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("material-lend");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
