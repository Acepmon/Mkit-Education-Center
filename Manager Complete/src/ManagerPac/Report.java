package ManagerPac;

import Controller.ServerConnection;
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
import teacher.model.Columns;

public class Report {

    private Pane reportPane;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;

    private TableView tableView;
    ComboBox<String> reportCombo;
    String[] columns;
    String[] names;
    TableColumn columnName;
    TableColumn column;

    int reportIndex = 0;
    int nameCount = 0;
    int nameId = 0;
    ArrayList<Columns> reportData;
    ArrayList<Integer> idSorted = new ArrayList<>();

    private ObservableList<ReportObj> data = FXCollections.observableArrayList();
    private ObservableList<ReportRowObj> rowData = FXCollections.observableArrayList();

    public Pane getReportPane() {
        return reportPane;
    }

    public void setReportPane(Pane reportPane) {
        this.reportPane = reportPane;
    }

    /**
     * Filtering informations with date
     */
    public void dateFormat() {
        ObservableList<ReportObj> tableItem = FXCollections.observableArrayList();

        for (int i = 0; i < data.size(); i++) {
            ReportObj reportObj = data.get(i);

            LocalDate startDate = LocalDate.parse(reportObj.getFriday());
            LocalDate endDate = LocalDate.parse(reportObj.getFriday());

            if (startDatePicker.getValue().isBefore(startDate) || startDatePicker.getValue().equals(startDate)) {
                if (endDatePicker.getValue().isAfter(endDate) || endDatePicker.getValue().equals(endDate)) {
                    tableItem.add(reportObj);
                }
            }

            tableView.setItems(tableItem);
        }
    }

    public Report() {
        reportPane = new Pane();
        Label reportLabel = new Label("Тайлангийн хэлбэр");
        reportLabel.setLayoutX(55);
        reportLabel.setLayoutY(25);

//        ArrayList<Object> arrayData=(ArrayList<Object>) ServerConnection.Request("", null);
//        arrayData.add(ServerConnection.Request("", null));
        ObservableList<String> reportType = FXCollections.observableArrayList("Нийт", "Ирц", "Шалгалт", "Бие Даалт", "Даалгавар");
        reportCombo = new ComboBox<String>(reportType);
        reportCombo.getSelectionModel().select(0);
        reportCombo.setPrefSize(120, 25);
        reportCombo.setLayoutX(190);
        reportCombo.setLayoutY(20);
        reportCombo.setId("iphone");
        reportCombo.setOnAction(ae -> {
            reportIndex = reportCombo.getSelectionModel().getSelectedIndex();
//            Table(reportIndex);
            dataRefresh();
        });

        Label lessonLabel = new Label("Хичээл");
        lessonLabel.setLayoutX(55);
        lessonLabel.setLayoutY(65);

        ObservableList<String> lessonType = FXCollections.observableArrayList("Java", "C#", "Солонгос хэл");
        ComboBox lessonCombo = new ComboBox(lessonType);
        lessonCombo.setValue("Сонгох");
        lessonCombo.setPrefSize(120, 25);
        lessonCombo.setLayoutX(190);
        lessonCombo.setLayoutY(60);
        lessonCombo.setId("iphone");

        Label teacherLabel = new Label("Багш");
        teacherLabel.setLayoutX(55);
        teacherLabel.setLayoutY(105);

        ObservableList<String> teacherList = FXCollections.observableArrayList("Бат", "Дорж", "Ганаа", "Тулгаа");
        ComboBox teacherCombo = new ComboBox(teacherList);
        teacherCombo.setValue("Сонгох");
        teacherCombo.setPrefSize(120, 25);
        teacherCombo.setLayoutX(190);
        teacherCombo.setLayoutY(100);
        teacherCombo.setId("iphone");

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

        startDatePicker = new DatePicker(LocalDate.now());
        startDatePicker.setLayoutX(780);
        startDatePicker.setLayoutY(20);

        Label endLabel = new Label("Төгсгөлийн огноо :");
        endLabel.setLayoutX(650);
        endLabel.setLayoutY(65);

        endDatePicker = new DatePicker(LocalDate.now());
        endDatePicker.setLayoutX(780);
        endDatePicker.setLayoutY(60);

        tableView = new TableView();
        tableView.setEditable(false);
        tableView.setPrefSize(1018, 500);
        tableView.setLayoutY(190);
        tableView.setLayoutX(0);
//        Table(reportIndex);
        dataRefresh();

        Button searchBtn = new Button("Хайх");
        searchBtn.setPrefSize(100, 30);
        searchBtn.setTextAlignment(TextAlignment.CENTER);
        searchBtn.setLayoutX(855);
        searchBtn.setLayoutY(100);
        searchBtn.setId("iphone");

        Button printButton = new Button("Хэвлэх");
        printButton.setPrefSize(100, 30);
        printButton.setTextAlignment(TextAlignment.CENTER);
        printButton.setLayoutX(720);
        printButton.setLayoutY(100);
        printButton.setId("iphone");
        printButton.setOnAction(ae -> {
            ArrayList<Object> object = (ArrayList<Object>) ServerConnection.Request("tailanAvah", "-got it.");
            System.out.println(object + "-printed.");
        });

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
                searchBtn,
                printButton,
                tableView
        );
    }

    /**
     * Creating table columns and getting data from inputs
     */
//    public void Table(int select) {
//        tableView.getColumns().clear();
//        ArrayList<String> dateArray=new ArrayList<>();
//        ArrayList<Object> ResponseData=(ArrayList<Object>) ClientTest.RequestAjluulah("tailanAvah", 20);
//        
//        reportData = (ArrayList<Columns>)ResponseData.get(select);
//        
//        System.out.println(reportData.get(0).getData());
//        
//        for(int i=0; i<reportData.size(); i++) {
//            if(reportData.get(i).getColumnType().equals("names")){
//                columnName=new TableColumn(reportData.get(i).getColumnName());
//                columnName.setCellValueFactory(new PropertyValueFactory("row"));
//                nameCount=reportData.get(i).getData().size();
//                nameId=i;
//            } else dateArray.add(reportData.get(i).getColumnName());
//        }
//        
//        tableView.getColumns().add(columnName);
//        
//        Collections.sort(dateArray);
//               
//        for(int i=0; i<reportData.size()-1; i++) {
//            for(int j=0; j<reportData.size(); j++) {
//                if(dateArray.get(i).equals(reportData.get(j).getColumnName())) {
//                    idSorted.add(j);
//                }
//            }
//        }
//        
//        for(int i=0; i<idSorted.size(); i++) {
//            final int j=i;
//            
//            column=new TableColumn(reportData.get(idSorted.get(i)).getColumnName());
//            column.setCellValueFactory(new Callback<CellDataFeatures<ReportRowObj, String>, SimpleStringProperty>() {
//                public SimpleStringProperty call(CellDataFeatures<ReportRowObj, String> param) {
//                    return new SimpleStringProperty(param.getValue().getValue().get(j).toString());
//                }
//            });
//            
//            tableView.getColumns().add(column);
//        }        
//        tableView.setItems(rowData);
//    }
    /**
     * Filling table view with data
     */
    public void dataRefresh() {
        rowData.clear();
        for (int i = 0; i < nameCount; i++) {
            ArrayList tempValue = new ArrayList();

            for (Integer id : idSorted) {
                tempValue.add(reportData.get(id).getData().get(i).toString());
            }

            ReportRowObj row = new ReportRowObj(reportData.get(nameId).getData().get(i).toString(), tempValue);
            rowData.add(row);
        }
    }
}
