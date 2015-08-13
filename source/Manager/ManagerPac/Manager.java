package ManagerPac;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Manager {

    File myFiles;
    Socket sock = null;

    private Scene scene;
    ObjectOutputStream out;
    static String filename;

    private MenuBar menuBar;
    public static Menu managerMenu;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Manager() {
        Pane pane = new Pane();
        scene = new Scene(pane, 1024, 768, Color.WHITE);
        HBox hbox = addHBox();
        hbox.setLayoutX(700);
        hbox.setLayoutY(10);

        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(1024, 768);

        Tab tabAdmissions = new Tab("Элсэлт");
        tabAdmissions.setId("tab");
        tabAdmissions.setOnSelectionChanged(ae -> {
            if (tabAdmissions.isSelected()) {
                tabAdmissions.setStyle("-fx-background-color:#3e5577");
            } else {
                tabAdmissions.setStyle("-fx-background-color:#486a9a");
            }
            tabAdmissions.setContent(Launcher.getADMISSIONS().getPane());
        });

        Tab tabTeacher = new Tab("Багш");
        tabTeacher.setId("tab");
        tabTeacher.setOnSelectionChanged(ae -> {
            if (tabTeacher.isSelected()) {
                tabTeacher.setStyle("-fx-background-color:#3e5577");
            } else {
                tabTeacher.setStyle("-fx-background-color:#486a9a");
            }
            tabTeacher.setContent(Launcher.getTEACHER().getTeacherPane());
        });

        Tab tabStudent = new Tab("Оюутан");
        tabStudent.setId("tab");
        tabStudent.setOnSelectionChanged(ae -> {
            if (tabStudent.isSelected()) {
                tabStudent.setStyle("-fx-background-color:#3e5577");
            } else {
                tabStudent.setStyle("-fx-background-color:#486a9a");
            }
            tabStudent.setContent(Launcher.getSTUDENT().getStudentPane());
        });

        Tab tabReport = new Tab("Тайлан");
        tabReport.setId("tab");
        tabReport.setOnSelectionChanged(ae -> {
            if (tabReport.isSelected()) {
                tabReport.setStyle("-fx-background-color:#3e5577");
            } else {
                tabReport.setStyle("-fx-background-color:#486a9a");
            }
            tabReport.setContent(Launcher.getREPORT().getReportPane());
        });

        tabAdmissions.setClosable(false);
        tabTeacher.setClosable(false);
        tabStudent.setClosable(false);
        tabReport.setClosable(false);

        tabPane.getTabs().addAll(
                tabAdmissions,
                tabTeacher,
                tabStudent,
                tabReport
        );

        pane.getChildren().addAll(tabPane, hbox);

        scene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(0, 5, 0, 3));

        Label managerNameLbl = new Label("Менежерийн нэр :");
        managerNameLbl.setPrefSize(120, 25);

        menuBar = new MenuBar();
        menuBar.setId("menuBar");
        menuBar.setPrefSize(130, 25);

        managerMenu = new Menu();
        managerMenu.setText("");
        managerMenu.setId("menu");

        MenuItem settings = new MenuItem("Хувийн мэдээлэл");
        settings.setId("menuItem");
        settings.setOnAction(ae -> {
            Stage managerStage = new Stage();
            ManagerProfile managerProfile = new ManagerProfile();
            managerProfile.start(managerStage);
        });

        MenuItem other = new MenuItem("Бусад");
        other.setId("menuItem");
        other.setOnAction(ae -> {

        });

        MenuItem exit = new MenuItem("Гарах");
        exit.setId("menuItem");
        exit.setOnAction(ae -> {
            int answer = JOptionPane.showConfirmDialog(null, "Гарах уу?");
            if (answer == JOptionPane.YES_OPTION) {
                Launcher.getStage().close();
            }
        });

        managerMenu.getItems().addAll(settings, other, exit);

        menuBar.getMenus().add(managerMenu);

        hbox.getChildren().addAll(managerNameLbl, menuBar);
        return hbox;
    }

    public void changeUsernameOfMenu(String str) {
        this.managerMenu.setText(str);
    }
}
