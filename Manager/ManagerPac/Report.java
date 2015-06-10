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
import javafx.scene.control.cell.PropertyValueFactory;
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
        
        ObservableList<String> responseData = FXCollections.observableArrayList();
        ObservableList<ReportObj> data = FXCollections.observableArrayList();
        
        responseData.add("stu1::name1::85::96::45::78::12");
        responseData.add("stu2::name2::852::962::452::782::122");
        for(String str : responseData){
            String[] cols = str.split("::");
            ReportObj report = new ReportObj(cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], cols[6]);
            data.add(report);
        }
        
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
                
        TableColumn idCol=new TableColumn("Сурагчдын код");
        idCol.setCellValueFactory(new PropertyValueFactory("studId"));
        idCol.setMaxWidth(110);
        idCol.setMinWidth(110);
        idCol.setId("column");
        
        TableColumn nameCol = new TableColumn("Сурагчдын нэрс");
        nameCol.setCellValueFactory(new PropertyValueFactory("studName"));
        nameCol.setMaxWidth(110);
        nameCol.setMinWidth(110);
        
        TableColumn mondayCol = new TableColumn("Даваа");
        mondayCol.setCellValueFactory(new PropertyValueFactory("monday"));
        mondayCol.setMaxWidth(60);
        mondayCol.setMinWidth(60);
        mondayCol.setId("column");
        
        TableColumn tuesdayCol = new TableColumn("Мягмар");
        tuesdayCol.setCellValueFactory(new PropertyValueFactory("tuesday"));
        tuesdayCol.setMaxWidth(60);
        tuesdayCol.setMinWidth(60);
        tuesdayCol.setId("column");
        
        TableColumn wednesdayCol = new TableColumn("Лхагва");
        wednesdayCol.setCellValueFactory(new PropertyValueFactory("wednesday"));
        wednesdayCol.setMaxWidth(60);
        wednesdayCol.setMinWidth(60);
        wednesdayCol.setId("column");
        
        TableColumn thursdayCol = new TableColumn("Пүрэв");
        thursdayCol.setCellValueFactory(new PropertyValueFactory("thursday"));
        thursdayCol.setMaxWidth(60);
        thursdayCol.setMinWidth(60);
        thursdayCol.setId("column");
        
        TableColumn fridayCol = new TableColumn("Баасан");
        fridayCol.setCellValueFactory(new PropertyValueFactory("friday"));
        fridayCol.setMaxWidth(60);
        fridayCol.setMinWidth(60);
        fridayCol.setId("column");
        
        tableView.getColumns().addAll(idCol,nameCol, mondayCol, tuesdayCol, wednesdayCol,thursdayCol,fridayCol);
        tableView.setItems(data);
        
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
                tableView
        );
    }
}
