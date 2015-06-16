package student.launch;

import java.net.UnknownHostException;
import student.login.CustomerLogin;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import student.ui.Homework;
import student.ui.MainFrame;
public class StudentUITest extends Application {
    private static Stage stage;
    private CustomerLogin login;
    public static MainFrame mainFrame;
    public void start(Stage primaryStage) {
        stage = primaryStage;
        login = new CustomerLogin(stage);
        stage.setScene(login.getScene());
        stage.setTitle("Logged in as Student");
        stage.show();
    }
    public static void Initialize() {
        mainFrame = new MainFrame();
    }
    public static void main(String args[]) {
                Homework client = new Homework();
                launch(args);
        try {
            client.receiveFileFromServer();
        } catch(UnknownHostException e) {
         e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void setScene(Scene scene) {
        stage.setScene(scene);
    }
    public static Stage getStage() {
        return StudentUITest.stage;
  }
    
}