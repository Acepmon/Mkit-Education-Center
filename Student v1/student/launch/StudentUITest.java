package student.launch;

import student.login.CustomerLogin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentUITest extends Application {
    private static Stage stage;
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setScene(new CustomerLogin(stage).getScene());
        stage.setTitle("Logged in as Student");
        stage.show();
    }
    public static void main(String args[]) {
        launch(args);
    }
    public static void setScene(Scene scene) {
        stage.setScene(scene);
    }
    public static Stage getStage() {
        return StudentUITest.stage;
    }
}
