package ku.cs;

import javafx.application.Application;
import javafx.stage.Stage;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "", 800, 600);
        configRoute();
        FXRouter.goTo("login");
    }

    private static void configRoute() {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
        FXRouter.when("material", viewPath + "material.fxml");
        FXRouter.when("material-info", viewPath + "material-info.fxml");
        FXRouter.when("material-manage", viewPath + "material-manage.fxml");
        FXRouter.when("material-add", viewPath + "material-add.fxml");
        FXRouter.when("material-lend", viewPath + "material-lend.fxml");
        FXRouter.when("assets-can-borrow", viewPath + "assets-can-borrow.fxml");
        FXRouter.when("assets-owned", viewPath + "assets-owned.fxml");
        FXRouter.when("user-history", viewPath + "user-history.fxml");
        FXRouter.when("staff0", viewPath + "staff0.fxml");
        FXRouter.when("staff1", viewPath + "staff1.fxml");
        FXRouter.when("staff2", viewPath + "staff2.fxml");
        FXRouter.when("staff3", viewPath + "staff3.fxml");
        FXRouter.when("staff4", viewPath + "staff4.fxml");
        FXRouter.when("staff5", viewPath + "staff5.fxml");
        FXRouter.when("login", viewPath + "login.fxml");
        FXRouter.when("register", viewPath + "register.fxml");
        FXRouter.when("organizers", viewPath + "organizers.fxml");
        FXRouter.when("how-to-use", viewPath + "how-to-use.fxml");
        FXRouter.when("home-admin", viewPath + "home-admin.fxml");
        FXRouter.when("home-user", viewPath + "home-user.fxml");
        FXRouter.when("home-staff", viewPath + "home-staff.fxml");
        FXRouter.when("staff-register", viewPath + "staff-register.fxml");
        FXRouter.when("change-pass", viewPath + "change-pass.fxml");
        FXRouter.when("list-system", viewPath + " list-system.fxml");
        FXRouter.when("officeAssets", viewPath + " officeAssets.fxml");
        FXRouter.when("kitchenAssets", viewPath + " kitchenAssets.fxml");
        FXRouter.when("computerAssets", viewPath + " computerAssets.fxml");
        FXRouter.when("user-main", viewPath + "user-main.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}