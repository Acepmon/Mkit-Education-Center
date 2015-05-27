package ManagerPac;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;

public class Report{
    private Pane reportPane;

    public Pane getReportPane() {
        return reportPane;
    }

    public void setReportPane(Pane reportPane) {
        this.reportPane = reportPane;
    }
    
    public Report() {
        reportPane = new Pane();
        Label reportLabel =  new Label("Тайлангийн хэлбэр");
        reportLabel.setLayoutX(55);
        reportLabel.setLayoutY(25);

        
        ObservableList<String> reportType = FXCollections.observableArrayList("Нийт","Ирц","Шалгалт","Бие Даалт","Даалгавар");
        ComboBox<String> reportCombo = new ComboBox<String>(reportType);
        reportCombo.setValue("Нийт");
        reportCombo.setPrefSize(120, 25);
        reportCombo.setLayoutX(190);
        reportCombo.setLayoutY(20);
        
        Label lessonLabel = new Label("Хичээл");
        lessonLabel.setLayoutX(55);
        lessonLabel.setLayoutY(65);
        
        ObservableList<String> lessonType = FXCollections.observableArrayList("Java","C#","Солонгос хэл");
        ComboBox lessonCombo = new ComboBox(lessonType);
        lessonCombo.setValue("Нийт");
        lessonCombo.setPrefSize(120, 25);
        lessonCombo.setLayoutX(190);
        lessonCombo.setLayoutY(60);
        
        Label teacherLabel = new Label("Багш");
        teacherLabel.setLayoutX(55);
        teacherLabel.setLayoutY(105);
        
        ObservableList<String> teacherList = FXCollections.observableArrayList("Бат","Дорж","Ганаа","Тулгаа");
        ComboBox teacherCombo = new ComboBox(teacherList);
        teacherCombo.setValue("Нийт");
        teacherCombo.setPrefSize(120, 25);
        teacherCombo.setLayoutX(190);
        teacherCombo.setLayoutY(100);
        
        ToggleGroup group = new ToggleGroup();
        
        RadioButton weekRadio = new RadioButton("Долоо хоног");
        weekRadio.setLayoutX(480);
        weekRadio.setLayoutY(23);
        weekRadio.setToggleGroup(group);
        weekRadio.setSelected(true);
        
        RadioButton monthRadio = new RadioButton("Сар");
        monthRadio.setLayoutX(480);
        monthRadio.setLayoutY(63);
        monthRadio.setToggleGroup(group);
        
        RadioButton allRadio = new RadioButton("Нийт дүн");
        allRadio.setLayoutX(480);
        allRadio.setLayoutY(103);
        allRadio.setToggleGroup(group);
        
        Label startLabel = new Label("Эхлэлийн огноо :");
        startLabel.setLayoutX(650);
        startLabel.setLayoutY(25);
        
        DatePicker startDatePicker = new DatePicker(LocalDate.now());
        startDatePicker.setLayoutX(780);
        startDatePicker.setLayoutY(20);
        
        Label endLabel = new Label("Төгсгөлийн огноо :");
        endLabel.setLayoutX(650);
        endLabel.setLayoutY(65);
        
        DatePicker endDatePicker = new DatePicker(LocalDate.now());
        endDatePicker.setLayoutX(780);
        endDatePicker.setLayoutY(60);
        
        TableView tableView = new TableView();
        tableView.setEditable(false);
        tableView.setPrefSize(900,500);
        tableView.setLayoutY(150);
        tableView.setLayoutX(55);
                
        TableColumn nameCol = new TableColumn("Сурагчдын нэрс");
        nameCol.setMaxWidth(150);
        nameCol.setMinWidth(150);
        
        TableColumn mondayCol = new TableColumn("Даваа");
        mondayCol.setMaxWidth(100);
        mondayCol.setMinWidth(100);
        
        TableColumn tuesdayCol = new TableColumn("Мягмар");
        tuesdayCol.setMaxWidth(100);
        tuesdayCol.setMinWidth(100);
        
        TableColumn wednesdayCol = new TableColumn("Лхагва");
        wednesdayCol.setMaxWidth(100);
        wednesdayCol.setMinWidth(100);
        
        TableColumn thursdayCol = new TableColumn("Пүрэв");
        thursdayCol.setMaxWidth(100);
        thursdayCol.setMinWidth(100);
        
        TableColumn fridayCol = new TableColumn("Баасан");
        fridayCol.setMaxWidth(100);
        fridayCol.setMinWidth(100);
        
        tableView.getColumns().addAll(nameCol, mondayCol, tuesdayCol, wednesdayCol,thursdayCol,fridayCol);
     
        
        Button printButton = new Button("Хэвлэх");
        printButton.setPrefSize(100, 30);
        printButton.setTextAlignment(TextAlignment.CENTER);
        printButton.setLayoutX(855);
        printButton.setLayoutY(100);
        
        reportPane.getChildren().addAll(
                reportLabel,
                reportCombo,
                lessonLabel,
                lessonCombo,
                teacherLabel,
                teacherCombo, 
                weekRadio, 
                monthRadio, 
                allRadio,
                startLabel, 
                startDatePicker, 
                endLabel, 
                endDatePicker,
                printButton,
                tableView);
    }
    
}
