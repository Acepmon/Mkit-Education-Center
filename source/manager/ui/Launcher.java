package ManagerPac;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Manager manager=new Manager();
        primaryStage.setScene(manager.getScene());
        primaryStage.setResizable(false);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);
        primaryStage.setTitle("Менежер");
        primaryStage.show();
    }
}
