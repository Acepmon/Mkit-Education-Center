package ManagerPac;

import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    
    private static Scene defaultScene;
    private static Stage stage;
    
    private static AddStudent ADDSTUDENT;
    private static CustomerLogin LOGIN;
    private static Manager MANAGER;
    private static Program PROGRAM;
    private static Report REPORT;
    private static Student STUDENT;
    private static Teacher TEACHER;
    private static PasswordReset RESET;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;
        
        LOGIN=new CustomerLogin(Launcher.getStage());
        defaultScene=LOGIN.getScene();
        
        stage.setScene(defaultScene);
        stage.setResizable(false);
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setTitle("Менежер");
        stage.show();
        
        ADDSTUDENT=new AddStudent();
        STUDENT=new Student();
        REPORT=new Report();
        TEACHER=new Teacher();
        PROGRAM=new Program();
        MANAGER=new Manager();
    }
    
    public static void setScene(Scene scene) {
        if(scene!=null) {
            stage.setScene(scene);
        }
    }

    public static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args) {
//        Manager client = new Manager();
//                launch(args);
//        try {
//            client.receiveFileFromServer();
//        } catch(UnknownHostException e) {
//         e.printStackTrace();
//        } catch(ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        launch(args);
    }
    
    public static Scene getDefaultScene() {
        return defaultScene;
    }

    public static Manager getMANAGER() {
        return MANAGER;
    }
    
    public static CustomerLogin getLOGIN() {
        return LOGIN;
    }
    
    public static PasswordReset getRESET() {
        return RESET;
    }
    
    public static Program getPROGRAM() {
        return PROGRAM;
    }

    public static Teacher getTEACHER() {
        return TEACHER;
    }
    
    public static Student getSTUDENT() {
        return STUDENT;
    }
    
    public static AddStudent getADDSTUDENT() {
        return ADDSTUDENT;
    }
    
    public static Report getREPORT() {
        return REPORT;
    }
    
}


