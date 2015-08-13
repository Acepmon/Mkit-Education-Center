package ManagerPac;

import Controller.ServerConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

public class Admissions {

    Pane pane;
    private Button editBtn;
    private Button addBtn;
    private Button deleteBtn;
    private Button searchBtn;
    private Label infoLbl;
    private AdmissionsObj select;

    private DatePicker startDatePicker;
    private DatePicker endDatePicker;

    private Label todayLbl;
    private Label startLbl;
    private Label endLbl;

    private String currentDate;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private Date date = Calendar.getInstance().getTime();

    private ObservableList<AdmissionsObj> data = FXCollections.observableArrayList();

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public AdmissionsObj getSelect() {
        return select;
    }

    public void setSelect(AdmissionsObj select) {
        this.select = select;
    }

    private TableView tableView;

    public Admissions() {
        pane = new Pane();
        String pattern = "yyyy-MM-dd";

        TableRefresh();

        currentDate = dateFormat.format(date);

        todayLbl = new Label("Өнөөдөр :  " + currentDate);
        todayLbl.setLayoutX(55);
        todayLbl.setLayoutY(130);

        startLbl = new Label("Эхлэлийн огноо :");
        startLbl.setLayoutX(650);
        startLbl.setLayoutY(25);

        endLbl = new Label("Төгсгөлийн огноо :");
        endLbl.setLayoutX(650);
        endLbl.setLayoutY(75);

        /**
         * Creating date picker and converting date format "MM/DD/YYYY" to
         * "YYYY-MM-DD"
         */
        startDatePicker = new DatePicker(LocalDate.now());
        startDatePicker.setLayoutX(780);
        startDatePicker.setEditable(false);
        startDatePicker.setLayoutY(20);
        startDatePicker.setPromptText(pattern.toLowerCase());
        startDatePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });

        /**
         * Creating date picker and converting date format "MM/DD/YYYY" to
         * "YYYY-MM-DD"
         */
        endDatePicker = new DatePicker(LocalDate.now());
        endDatePicker.setLayoutX(780);
        endDatePicker.setLayoutY(70);
        endDatePicker.setEditable(false);
        endDatePicker.setPromptText(pattern.toLowerCase());
        endDatePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });

        searchBtn = new Button("Хайлт хийх");
        searchBtn.setPrefSize(100, 30);
        searchBtn.setOnAction(ae -> {
            dateFormat();
        });
        searchBtn.setLayoutX(855);
        searchBtn.setLayoutY(120);
        searchBtn.setId("iphone");

        tableView = new TableView();
        tableView.setEditable(false);
        tableView.setPrefWidth(900);
        tableView.setPrefHeight(430);
        tableView.setLayoutX(55);
        tableView.setLayoutY(180);

        TableColumn nameCol = new TableColumn("Нэр");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setMaxWidth(200);
        nameCol.setMinWidth(200);

        TableColumn descriptionCol = new TableColumn("Тайлбар");
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        descriptionCol.setMaxWidth(398);
        descriptionCol.setMinWidth(398);

        TableColumn startCol = new TableColumn("Эхлэх огноо");
        startCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        startCol.setMaxWidth(150);
        startCol.setMinWidth(150);

        TableColumn endCol = new TableColumn("Дуусах огноо");
        endCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        endCol.setMaxWidth(150);
        endCol.setMinWidth(150);

        infoLbl = new Label("Элсэлтийн мэдээлэл засах бол дээрх мэдээллүүдээс сонгоод засах товч дарна уу!!");
        infoLbl.setPrefSize(500, 25);
        infoLbl.setStyle("-fx-text-fill:red;");
        infoLbl.setLayoutX(55);
        infoLbl.setLayoutY(630);
        infoLbl.setVisible(false);

        addBtn = new Button("Нэмэх");
        addBtn.setOnAction(ae -> {
            Stage stage = new Stage();
            AddAdmissions add = new AddAdmissions();
            add.start(stage);
        });
        addBtn.setPrefSize(100, 30);
        addBtn.setLayoutX(603);
        addBtn.setLayoutY(630);
        addBtn.setId("iphone");

        editBtn = new Button("Засах");
        editBtn.setOnAction(ae -> {
            if (tableView.getSelectionModel().getSelectedIndex() < 0) {
                infoLbl.setVisible(true);
                System.out.println("Unselected");
            } else {
                infoLbl.setVisible(false);
                int choose = tableView.getSelectionModel().getSelectedIndex();
                select = data.get(choose);
                Stage stage = new Stage();
                EditAdmissions edit = new EditAdmissions();
                edit.start(stage);
            }
        });
        editBtn.setPrefSize(100, 30);
        editBtn.setLayoutX(730);
        editBtn.setLayoutY(630);
        editBtn.setId("iphone");

        deleteBtn = new Button("Хасах");
        deleteBtn.setPrefSize(100, 30);
        deleteBtn.setLayoutX(855);
        deleteBtn.setLayoutY(630);
        deleteBtn.setId("iphone");
        deleteBtn.setOnAction(ae -> {
            int answer = JOptionPane.showConfirmDialog(null, "Хасах уу?");
            if (answer == JOptionPane.YES_OPTION) {
                int delete = Integer.parseInt(((AdmissionsObj) Launcher.getADMISSIONS().tableView.getSelectionModel().getSelectedItem()).getId());
                System.out.println(delete + "-delete.");
                ServerConnection.Request("deleteElseltPlan", delete);
            }

            TableRefresh();
        });

        tableView.getColumns().addAll(
                nameCol,
                descriptionCol,
                startCol,
                endCol
        );
        tableView.setItems(data);
        pane.getChildren().addAll(
                todayLbl,
                startLbl,
                endLbl,
                startDatePicker,
                endDatePicker,
                searchBtn,
                tableView,
                infoLbl,
                addBtn,
                editBtn,
                deleteBtn
        );
    }

    public void TableRefresh() {
        ArrayList<String> arrayData = (ArrayList<String>) ServerConnection.Request("getElseltPlan", null);
        System.out.println(arrayData + " - Admissions TableRefresh printed.");
        data.clear();

        for (int i = 0; i < arrayData.size(); i++) {
            String str = (String) arrayData.get(i);
            ArrayList<String> cols = new ArrayList<>();
            for (String str1 : str.split("::")) {
                cols.add(str1);
            }

            if (cols.size() < 16) {
                for (int j = cols.size(); j < 16; j++) {
                    cols.add("");
                }
            }

            AdmissionsObj admissionObj = new AdmissionsObj(
                    cols.get(0),
                    cols.get(1),
                    cols.get(2),
                    cols.get(3),
                    cols.get(4)
            );

            data.add(admissionObj);
        }
    }

    /**
     * Filtering informations with date
     */
    public void dateFormat() {
        ObservableList<AdmissionsObj> tableItem = FXCollections.observableArrayList();

        for (int i = 0; i < data.size(); i++) {
            AdmissionsObj obj = data.get(i);

            LocalDate startDate = LocalDate.parse(obj.getStartDate());
            LocalDate endDate = LocalDate.parse(obj.getEndDate());

            if (startDatePicker.getValue().isBefore(startDate) || startDatePicker.getValue().equals(startDate)) {

                if (endDatePicker.getValue().isAfter(endDate) || endDatePicker.getValue().equals(endDate)) {
                    tableItem.add(obj);
                }
            }

            tableView.setItems(tableItem);
        }
    }
}
