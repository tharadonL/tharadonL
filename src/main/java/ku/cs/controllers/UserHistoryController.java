package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.services.BorrowFileDataSource;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class UserHistoryController {
    @FXML
    public void OnBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("user-main");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private BorrowFileDataSource borrowFileDataSource;
}
