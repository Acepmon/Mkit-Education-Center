package ManagerPac;

import Controller.ClientTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

public class Report{
    private Pane reportPane;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    
    private TableView tableView;
    String[] columns;
    String[] names;
    TableColumn columnName;
    TableColumn column;
    
    private ObservableList<ReportObj> data=FXCollections.observableArrayList();
    private ObservableList<ReportRowObj> rowData=FXCollections.observableArrayList();
    
    public Pane getReportPane() {
        return reportPane;
    }

    public void setReportPane(Pane reportPane) {
        this.reportPane = reportPane;
    }
    
    public void dateFormat() {
        ObservableList<ReportObj> tableItem=FXCollections.observableArrayList();
        
        for(int i=0; i<data.size(); i++) {
            ReportObj reportObj=data.get(i);
            
            LocalDate startDate=LocalDate.parse(reportObj.getFriday());
            LocalDate endDate=LocalDate.parse(reportObj.getFriday());
            
            if(startDatePicker.getValue().isBefore(startDate)||startDatePicker.getValue().equals(startDate)) {
                if(endDatePicker.getValue().isAfter(endDate)||endDatePicker.getValue().equals(endDate)) {
                    tableItem.add(reportObj);
                }
            }
            
            tableView.setItems(tableItem);
        }
    }
    
    public Report() {
        reportPane = new Pane();
        Label reportLabel =  new Label("Тайлангийн хэлбэр");
        reportLabel.setLayoutX(55);
        reportLabel.setLayoutY(25);
        
        ArrayList<Object> arrayData=(ArrayList<Object>) ClientTest.RequestAjluulah("getSubjectNames", null);
        arrayData.add(ClientTest.RequestAjluulah("getSubjectNames", null));
        
        ObservableList<String> reportType = FXCollections.observableArrayList("Нийт", "Ирц", "Шалгалт", "Бие Даалт", "Даалгавар");
        ComboBox<String> reportCombo = new ComboBox<String>(reportType);
        reportCombo.setValue("Сонгох");
        reportCombo.setPrefSize(120, 25);
        reportCombo.setLayoutX(190);
        reportCombo.setLayoutY(20);
        
        Label lessonLabel = new Label("Хичээл");
        lessonLabel.setLayoutX(55);
        lessonLabel.setLayoutY(65);
        
        ObservableList<String> lessonType = FXCollections.observableArrayList("Java", "C#", "Солонгос хэл");
        ComboBox lessonCombo = new ComboBox(lessonType);
        lessonCombo.setValue("Сонгох");
        lessonCombo.setPrefSize(120, 25);
        lessonCombo.setLayoutX(190);
        lessonCombo.setLayoutY(60);
        
        Label teacherLabel = new Label("Багш");
        teacherLabel.setLayoutX(55);
        teacherLabel.setLayoutY(105);
        
        ObservableList<String> teacherList = FXCollections.observableArrayList("Бат", "Дорж", "Ганаа", "Тулгаа");
        ComboBox teacherCombo = new ComboBox(teacherList);
        teacherCombo.setValue("Сонгох");
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
        
        Label startLabel=new Label("Эхлэлийн огноо :");
        startLabel.setLayoutX(650);
        startLabel.setLayoutY(25);
        
        startDatePicker=new DatePicker(LocalDate.now());
        startDatePicker.setLayoutX(780);
        startDatePicker.setLayoutY(20);
        
        Label endLabel=new Label("Төгсгөлийн огноо :");
        endLabel.setLayoutX(650);
        endLabel.setLayoutY(65);
        
        endDatePicker=new DatePicker(LocalDate.now());
        endDatePicker.setLayoutX(780);
        endDatePicker.setLayoutY(60);
        
        tableView=new TableView();
        tableView.setEditable(false);
        tableView.setPrefSize(900,500);
        tableView.setLayoutY(150);
        tableView.setLayoutX(55);
        Table();
                
        
        
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
    
    public void Table() {
        ArrayList<String> dateArray=new ArrayList<>();
        ArrayList<ReportColumnObj> values=new ArrayList<>();
        ArrayList<Object> names=new ArrayList<>();
        names.add("adasdas");
        names.add("sdfsdf");
        names.add("adafghfghsdas");
        names.add("rtterte");
        
        ArrayList<Object> names2=new ArrayList<>();
        names2.add("1d");
        names2.add("2d");
        names2.add("3d");
        names2.add("4d");
        
        ArrayList<Object> names3=new ArrayList<>();
        names3.add("123");
        names3.add("1456");
        names3.add("123131");
        names3.add("234243");
        
        ArrayList<Object> names4=new ArrayList<>();
        names4.add("adasdas23");
        names4.add("sdfsdf32323");
        names4.add("adafghfghsdas3434");
        names4.add("rtterte232");
        
        values.add(new ReportColumnObj("3", "day", names3));
        values.add(new ReportColumnObj("232", "day", names2));
        values.add(new ReportColumnObj("Names", "names", names));
        values.add(new ReportColumnObj("21", "day", names4));
        
        
        int nameCount=0;
        int nameId=0;
        
        for(int i=0; i<values.size(); i++) {
            switch(values.get(i).getType()) {
                case "names":
                    columnName=new TableColumn(values.get(i).getColumn());
                    columnName.setCellValueFactory(new PropertyValueFactory("row"));
                    nameCount=values.get(i).getValue().size();
                    nameId=i;
                    break;
                    
                case "day":
                    dateArray.add(values.get(i).getColumn());
                    break;
            }
        }
        
        tableView.getColumns().add(columnName);
        
        Collections.sort(dateArray);
        
        ArrayList<Integer> idSorted=new ArrayList<>();
        
        for(int i=0; i<values.size()-1; i++) {
            for(int j=0; j<values.size(); j++) {
                if(dateArray.get(i).equals(values.get(j).getColumn())) {
                    idSorted.add(j);
                }
            }
        }
        
        for(int i=0; i<idSorted.size(); i++) {
            final int j=i;
            
            column=new TableColumn(values.get(idSorted.get(i)).getColumn());
            column.setCellValueFactory(new Callback<CellDataFeatures<ReportRowObj, String>, SimpleStringProperty>() {
                public SimpleStringProperty call(CellDataFeatures<ReportRowObj, String> param) {
                    return new SimpleStringProperty(param.getValue().getValue().get(j).toString());
                }
            });
            
            tableView.getColumns().add(column);
        }
        
        for(int i=0; i<nameCount; i++) {
            ArrayList tempValue=new ArrayList();
            
            for(Integer id:idSorted) {
                tempValue.add(values.get(id).getValue().get(i).toString());
            }
            
            ReportRowObj row=new ReportRowObj(values.get(nameId).getValue().get(i).toString(), tempValue);
            rowData.add(row);
        }
        
        tableView.setItems(rowData);
    }
}
