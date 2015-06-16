package teacher.launch;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teacher.login.ui.CustomerLogin;
import teacher.ui.*;

public class Launcher extends Application implements teacher.config.Config {

    private static Scene defaultScene;
    private static Stage stage;

    private static TeacherMain TEACHER;
    private static Shalgah_left_inner SHALGAH_LEFT_INNER;
    private static Shalgah_left SHALGAH_LEFT;
    private static Shalgah_right_inner SHALGAH_RIGHT_INNER;
    private static Shalgah_right SHALGAH_RIGHT;
    private static Shalgah_Center SHALGAH_CENTER;
    private static Popupwindow popupwindow;
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
    private static Tailan_left TAILAN_LEFT;
    private static Tailan_left_inner TAILAN_LEFT_INNER;
    private static Tailan_medeelel TAILAN_MEDEELEL;
    private static Daalgavarshalgah DAALGAVARSHALGAH;
    private static DunOruulah DUNORUULAH;
    private static Stage logoutStage;
    public static Node getDUNORUULAH;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        logoutStage = new Stage();

        LOGIN = new CustomerLogin(Launcher.getStage());
        defaultScene = LOGIN.getScene();

        stage.setTitle(STAGE_TITLE);
        stage.setResizable(RESIZABLE);
        stage.setMaximized(MAXIMIZABLE);
        stage.setScene(defaultScene);
        stage.show();
        SHALGAH_LEFT_INNER = new Shalgah_left_inner();
        SHALGAH_LEFT = new Shalgah_left();
        SHALGAH_RIGHT_INNER = new Shalgah_right_inner();
        SHALGAH_RIGHT = new Shalgah_right();
        SHALGAH_CENTER= new Shalgah_Center();
        DAALGAVARSHALGAH = new Daalgavarshalgah();
        popupwindow = new Popupwindow();
        DUNORUULAH = new DunOruulah();
        TAILAN_MEDEELEL = new Tailan_medeelel();
        TAILAN_LEFT_INNER = new Tailan_left_inner();
        TAILAN_LEFT = new Tailan_left();
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

    public static Shalgah_right_inner getSHALGAH_RIGHT_INNER() {
        return SHALGAH_RIGHT_INNER;
    }

    public static Shalgah_right getSHALGAH_RIGHT() {
        return SHALGAH_RIGHT;
    }

    public static Shalgah_Center getSHALGAH_CENTER() {
        return SHALGAH_CENTER;
    }

    public static Shalgah_left_inner getSHALGAH_LEFT_INNER() {
        return SHALGAH_LEFT_INNER;
    }

    public static Shalgah_left getSHALGAH_LEFT() {
        return SHALGAH_LEFT;
    }

    public static Stage getLogoutStage() {
        return logoutStage;
    }

    public static void setScene(Scene scene) {
        if (scene != null) {
            stage.setScene(scene);
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {

        launch(args);
        /*        Homework client = new Homework();
         try {
         client.receiveFileFromServer();
         } catch(UnknownHostException e) {
         e.printStackTrace();
         } catch(ClassNotFoundException e) {
         e.printStackTrace();
         } catch (Exception e) {
         e.printStackTrace();
         }*/
    }

    public static Popupwindow getPopupwindow() {
        return popupwindow;
    }

    public static void setPopupwindow(Popupwindow popupwindow) {
        Launcher.popupwindow = popupwindow;
    }

    public static Scene getDefaultScene() {
        return defaultScene;
    }

    public static Daalgavarshalgah getDAALGAVARSHALGAH() {
        return DAALGAVARSHALGAH;
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

    public static DunOruulah getDUNORUULAH() {
        return DUNORUULAH;
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

    public static Tailan_left getTAILAN_LEFT() {
        return TAILAN_LEFT;
    }

    public static Tailan_left_inner getTAILAN_LEFT_INNER() {
        return TAILAN_LEFT_INNER;
    }

    public static Tailan_medeelel getTAILAN_MEDEELEL() {
        return TAILAN_MEDEELEL;
    }

}
