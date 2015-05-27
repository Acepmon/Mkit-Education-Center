package ManagerPac;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Manager {
    
    private Scene scene;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    
    public Manager() {
        Pane pane=new Pane();
        scene=new Scene(pane, 1024, 768, Color.WHITE);
        HBox hbox=addHBox();
        hbox.setLayoutX(680);
        hbox.setLayoutY(5);
        
        TabPane tabPane=new TabPane();
        tabPane.setPrefSize(1024, 768);
        
        
        
        Tab tabProgram=new Tab("Хөтөлбөр");
        tabProgram.setId("program_tab");
        tabProgram.setOnSelectionChanged(ae-> {
            tabProgram.setContent(Launcher.getPROGRAM().getProgramPane());
        });
        
        Tab tabTeacher=new Tab("Багш");
        tabTeacher.setId("teacher_tab");
        tabTeacher.setOnSelectionChanged(ae-> {
            tabTeacher.setContent(Launcher.getTEACHER().getTeacherPane());
        });
        
        Tab tabStudent=new Tab("Оюутан");
        tabStudent.setId("student_tab");
        tabStudent.setOnSelectionChanged(ae-> {
            tabStudent.setContent(Launcher.getSTUDENT().getStudentPane());
        });
        
        Tab tabReport=new Tab("Тайлан");
        tabReport.setId("report_tab");
        tabReport.setOnSelectionChanged(ae-> {
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
        HBox hbox=new HBox();
        hbox.setPadding(new Insets(0, 5, 0, 3));
        
        Label managerNameLbl=new Label("Менежерийн нэр :");
        managerNameLbl.setPrefSize(120, 25);
        
        ObservableList<String> settings=FXCollections.observableArrayList("Хувийн мэдээлэл", "Тохиргоо", "Бусад", "Гарах");
        ComboBox settingsCmBox=new ComboBox<String>(settings);
        settingsCmBox.setValue("Профайл");
        settingsCmBox.setPrefSize(150, 25);
        settingsCmBox.setId("settings");
        
        hbox.getChildren().addAll(managerNameLbl, settingsCmBox);
        return hbox;
    }
}
