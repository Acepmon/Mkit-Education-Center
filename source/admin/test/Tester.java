package test;

import javafx.application.Application;
import javafx.stage.Stage;

public class Tester extends Application {
    
    public static double stage_x;
    public static double stage_y;

    @Override
    public void start(Stage stage) throws Exception {
        
        stage_x = stage.getX();
        stage_y = stage.getY();
        
        stage.setScene(new admin.ui.AdminUI().getScene());
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
