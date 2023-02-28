package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import ku.cs.models.Account;
import ku.cs.models.AccountList;
import ku.cs.services.UserDataSource;
import ku.cs.services.DataSource;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class ListSystemController {
    private DataSource<AccountList> dataSource;
    private AccountList accountList;
    @FXML private ListView<Account> showAccListView;
    public void initialize() {
        dataSource = new UserDataSource("data/csv/", "userData.csv");
        accountList = dataSource.readData();
        accountList.sortByTime();
        showAccListView();
    }
    private void showAccListView() {
        showAccListView.getItems().addAll(accountList.getAllAccount());
        showAccListView.refresh();
    }
    @FXML
    public void HomeAdminButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("home-admin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
