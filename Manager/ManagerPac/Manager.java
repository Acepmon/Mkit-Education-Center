package ManagerPac;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    private String username;

    private Scene scene;
    
    private MenuBar menuBar;
    private Menu managerMenu;

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
        hbox.setLayoutX(730);
        hbox.setLayoutY(5);

        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(1024, 768);

        Tab tabProgram = new Tab("Хөтөлбөр");
        tabProgram.setId("program_tab");
        tabProgram.setOnSelectionChanged(ae -> {
            tabProgram.setContent(Launcher.getPROGRAM().getProgramPane());
        });

        Tab tabTeacher = new Tab("Багш");
        tabTeacher.setId("teacher_tab");
        tabTeacher.setOnSelectionChanged(ae -> {
            tabTeacher.setContent(Launcher.getTEACHER().getTeacherPane());
        });

        Tab tabStudent = new Tab("Оюутан");
        tabStudent.setId("student_tab");
        tabStudent.setOnSelectionChanged(ae -> {
            tabStudent.setContent(Launcher.getSTUDENT().getStudentPane());
        });

        Tab tabReport = new Tab("Тайлан");
        tabReport.setId("report_tab");
        tabReport.setOnSelectionChanged(ae -> {
            tabReport.setContent(Launcher.getREPORT().getReportPane());
        });

        tabProgram.setClosable(false);
        tabTeacher.setClosable(false);
        tabStudent.setClosable(false);
        tabReport.setClosable(false);

        tabPane.getTabs().addAll(tabProgram, tabTeacher, tabStudent, tabReport);

        pane.getChildren().addAll(tabPane, hbox);

        scene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(0, 5, 0, 3));
        
        Label managerNameLbl = new Label("Менежерийн нэр :");
        managerNameLbl.setPrefSize(120, 25);
        
        menuBar=new MenuBar();
        menuBar.setPrefSize(100, 25);
        
        managerMenu=new Menu();
        managerMenu.setText("");
        
        MenuItem settings=new MenuItem("Хувийн мэдээлэл");
        settings.setOnAction(ae-> {
            Stage managerStage=new Stage();
            ManagerProfile managerProfile=new ManagerProfile();
            managerProfile.start(managerStage);
        });
        
        MenuItem other=new MenuItem("Бусад");
        other.setOnAction(ae-> {
            
        });
        
        MenuItem exit=new MenuItem("Гарах");
        exit.setOnAction(ae-> {
            int answer=JOptionPane.showConfirmDialog(null, "Гарах уу?");
            if(answer==JOptionPane.YES_OPTION) {
                Launcher.getStage().close();
            }
        });
        
        managerMenu.getItems().addAll(settings, other, exit);
        
        menuBar.getMenus().add(managerMenu);
        
        hbox.getChildren().addAll(managerNameLbl, menuBar);
        return hbox;
    }
    
    public void setUserName(String str) {
        this.username=str;
    }
    
    public String getUserName() {
        return this.username;
    }
    
    public void changeUsernameOfMenu(String str) {
        this.managerMenu.setText(str);
    }
}
