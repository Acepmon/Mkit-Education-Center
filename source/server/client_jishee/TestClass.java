package client_jishee;

import javafx.application.Application;
import javafx.stage.Stage;


public class TestClass extends Application{
    public static void main (String args[]){
        launch(args);
     }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setScene(new CustomerLogin().getScene());
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Login Test"); 
    }
}
