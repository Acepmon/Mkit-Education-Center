/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teacher.login.ui.CustomerLogin;
import teacher.ui.Center;
import teacher.ui.DaalgavarSend;
import teacher.ui.Homework;
import teacher.ui.Huvaari;
import teacher.ui.Inner_homework;
import teacher.ui.Inner_huvaari;
import teacher.ui.Irts;
import teacher.ui.Medeelel;
import teacher.ui.Ners;
import teacher.ui.TeacherMain;
import teacher.ui.Tree;

/**
 *
 * @author JAVA M2
 */
public class Launcher extends Application implements teacher.config.Config {
    
    private static Scene defaultScene;
    private static Stage stage;
    
    private static TeacherMain TEACHER;
    private static CustomerLogin LOGIN;
    private static Center CENTER;
    private static DaalgavarSend DAALGAVARSEND;
    private static Homework HOMEWORK;
    private static Huvaari HUVAARI;
    private static Inner_homework INNER_HOMEWORK;
    private static Inner_huvaari INNER_HUVAARI;
    private static Irts IRTS;
    private static Medeelel MEDEELEL;
    private static Ners NERS;
    private static Tree TREE;
    
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
                
        LOGIN = new CustomerLogin(Launcher.getStage());
        defaultScene = LOGIN.getScene();
        
        stage.setTitle(STAGE_TITLE);
        stage.setResizable(RESIZABLE);
        stage.setMaximized(MAXIMIZABLE);
        stage.setScene(defaultScene);
        stage.show();
        
        INNER_HOMEWORK = new Inner_homework();
        INNER_HUVAARI = new Inner_huvaari();
        CENTER = new Center();
        DAALGAVARSEND = new DaalgavarSend();
        HOMEWORK = new Homework();
        HUVAARI = new Huvaari();
        IRTS = new Irts();
        MEDEELEL = new Medeelel();
        NERS = new Ners();
        TREE = new Tree();
        TEACHER = new TeacherMain();
    }
    
    public static void setScene(Scene scene) {
        if (scene != null)
            stage.setScene(scene);
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static Scene getDefaultScene() {
        return defaultScene;
    }

    public static TeacherMain getTEACHER() {
        return TEACHER;
    }

    public static CustomerLogin getLOGIN() {
        return LOGIN;
    }

    public static Center getCENTER() {
        return CENTER;
    }

    public static DaalgavarSend getDAALGAVARSEND() {
        return DAALGAVARSEND;
    }

    public static Homework getHOMEWORK() {
        return HOMEWORK;
    }

    public static Huvaari getHUVAARI() {
        return HUVAARI;
    }

    public static Inner_homework getINNER_HOMEWORK() {
        return INNER_HOMEWORK;
    }

    public static Inner_huvaari getINNER_HUVAARI() {
        return INNER_HUVAARI;
    }

    public static Irts getIRTS() {
        return IRTS;
    }

    public static Medeelel getMEDEELEL() {
        return MEDEELEL;
    }

    public static Ners getNERS() {
        return NERS;
    }

    public static Tree getTREE() {
        return TREE;
    }
    
}
