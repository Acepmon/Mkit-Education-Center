package teacher.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import teacher.controller.ServerConnection;
import teacher.login.ui.CustomerLogin;
import teacher.model.CustomTable2;
import teacher.model.ShalgaltDunModel;

public class ShalgaltDunOruulah {

    private class ShalgaltComboModel {

        private String id, status, point;

        public ShalgaltComboModel(String id, String status, String point) {
            this.id = id;
            this.status = status;
            this.point = point;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }
    }

    public static final ObservableList<FlowPane> oyutan = FXCollections.observableArrayList();
    private TableView table;
    private FlowPane shalgaltDun, flow2;

    private DatePicker checkInDatePicker;
    private final String pattern = "yyyy-MM-dd";
    private ComboBox shalgalt1, students, shalgaltCombo;
    private GridPane gridPane;
    GridPane gridPane1;
    private TextField txt;
    private Button add;
    private DatePicker checkInDatePicker1;
    private final String pattern1 = "yyyy-MM-dd";

    Node getContainer;

    private CustomTable2 ct;
    boolean betweenDaysValidate = false;
    private ObservableList<String> shalgalt1Items;
    private ObservableList<ShalgaltDunModel> row1;

    private ObservableList<String> adding_students = FXCollections.observableArrayList();
    private ObservableList<String> adding_subjects = FXCollections.observableArrayList();
    private ObservableList<String> adding_shalgalt = FXCollections.observableArrayList();

    public ShalgaltDunOruulah() {
        shalgalt1Items = FXCollections.observableArrayList();
        ct = new CustomTable2();

        row1 = FXCollections.observableArrayList();

        shalgaltDun = new FlowPane();
        shalgaltDun.setPrefSize(1100, 700);
        shalgaltDun.setStyle("-fx-background-color: #F6F6F7");

        flow2 = new FlowPane(40, 0);
        flow2.setPrefSize(1100, 50);
        flow2.setStyle("-fx-background-color: #F6F6F7");
        flow2.setPadding(new Insets(0, 0, 0, 20));
        BorderPane topBf = new BorderPane();
        topBf.setPrefSize(1100, 0);
        topBf.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        Label nameLbl = new Label("Шалгалт дүн оруулах");
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(200, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));

        FlowPane btnFl = new FlowPane(10, 10);
        btnFl.setAlignment(Pos.CENTER);
        btnFl.setPrefSize(465, 60);

        Label dunOruulah = new Label("Ирц");
        dunOruulah.setAlignment(Pos.CENTER);
        dunOruulah.setPrefSize(100, 25);
        dunOruulah.setFont(javafx.scene.text.Font.font("Arial", 15));
        dunOruulah.setId("green");
        dunOruulah.setOnMousePressed(ae -> {
            Stage stage = new Stage();
//            new DunOruulah_Zasah().start(stage);
        });

        Button delB = new Button("Устгах");
        delB.setAlignment(Pos.CENTER);
        delB.setPrefSize(100, 25);
        delB.setId("btns1");
        delB.setFont(javafx.scene.text.Font.font("Arial", 15));
        delB.setOnMousePressed((event) -> {
            if (table.getSelectionModel().getSelectedIndex() > 0) {
                ShalgaltDunModel model = (ShalgaltDunModel) table.getSelectionModel().getSelectedItem();
                String id = model.getId();
                System.out.println("IDDDD: " + id);
                ServerConnection.RequestAjluulah("deleteDunShalgalt", id);
                refreshTable();
            }
        });

        Button editB = new Button("Засах");
        editB.setAlignment(Pos.CENTER);
        editB.setPrefSize(80, 25);
        editB.setFont(javafx.scene.text.Font.font("Arial", 15));
        editB.setId("btns1");
        editB.setOnAction((event) -> {
            if (table.getSelectionModel().getSelectedIndex() >= 0) {
                ShalgaltDunModel selected = (ShalgaltDunModel) table.getSelectionModel().getSelectedItem();
                Stage stage = new Stage();
                GridPane grid = new GridPane();
                grid.setVgap(10);
                grid.setHgap(5);
                grid.setPadding(new Insets(10));

                Label nameStuL = new Label("Сурагчийн нэр: ");
                nameStuL.setPrefSize(100, 20);
                Label pointL = new Label("Авсан оноо: ");
                pointL.setPrefSize(100, 20);
                Label nameExaL = new Label("Шалгалтын нэр: ");
                nameExaL.setPrefSize(100, 20);
                Label onSarL = new Label("Он сар өдөр: ");
                onSarL.setPrefSize(100, 20);
                Button saveB = new Button("Хадгалах");
                saveB.setId("green");
                saveB.setPrefSize(120, 20);

                ObservableList<String> editstuc_items = FXCollections.observableArrayList();
                ObservableList<String> editsubc_items = FXCollections.observableArrayList();
                ObservableList<String> editshac_items = FXCollections.observableArrayList();



                ComboBox edit_student_combo = new ComboBox();
                ComboBox edit_subject_combo = new ComboBox();
                ComboBox edit_shalgalt_combo = new ComboBox();

                DatePicker edit_date = new DatePicker();

                StringConverter converter = new StringConverter<LocalDate>() {
                    DateTimeFormatter dateFormatter
                            = DateTimeFormatter.ofPattern(pattern);

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
                };

                edit_date.setConverter(converter);
                edit_date.setPromptText(pattern.toLowerCase());

                ////...........>>>>>>>>>>>>>>>>>>>>>>>>>


                for (String asd : adding_students) {
                    String[] spl = asd.split("::");
                    edit_student_combo.getItems().add(spl[3]);
                }
                
                
                for (String str : adding_subjects) {
                    String[] spl = str.split("::");
                    String id = spl[0];
                    String status = spl[1];
                    String pointx = spl[2];

                    edit_subject_combo.getItems().add(status);
                }
                
                for (String str : adding_shalgalt) {
                    String[] spl = str.split("::");
                    String id = spl[0];
                    String status = spl[1];
                    String pointx = spl[2];

                    edit_shalgalt_combo.getItems().add(status);
                }
                

                ////...........>>>>>>>>>>>>>>>>>>>>>>>>>

                grid.add(nameStuL, 1, 1);
                grid.add(edit_student_combo, 2, 1);
                grid.add(pointL, 1, 2);
                grid.add(edit_subject_combo, 2, 2);
                grid.add(nameExaL, 1, 3);
                grid.add(edit_shalgalt_combo, 2, 3);
                grid.add(onSarL, 1, 4);
                grid.add(edit_date, 2, 4);
                grid.add(saveB, 2, 5);

                stage.setScene(new Scene(grid));
                stage.show();
            }
        });

        btnFl.getChildren().addAll(delB, editB);

        topBf.setLeft(nameLbl);
        topBf.setRight(btnFl);

        //////////////////////////////// 
        table = new TableView();
        table.setEditable(true);
        table.setItems(row1);
        table.setStyle("-fx-alignment: CENTER;");
        table.setPrefSize(1020, 645);

        TableColumn name = new TableColumn("Сурагчийн нэр");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(200);
        TableColumn point = new TableColumn("Авсан оноо");
        point.setCellValueFactory(new PropertyValueFactory<>("point"));
        point.setMinWidth(200);
        TableColumn exam = new TableColumn("Шалгалтын нэр");
        exam.setCellValueFactory(new PropertyValueFactory<>("exam"));
        exam.setMinWidth(200);
        TableColumn date = new TableColumn("Огноо");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        date.setMinWidth(200);

        table.getColumns().addAll(name, point, exam, date);

        table.setPrefHeight(600);
        ScrollPane scrl = new ScrollPane(table);
        refreshTable();

        students = new ComboBox();
        students.setPrefSize(120, 20);
        students.setValue("Оюутны нэрс");

        ArrayList<String> nersArray = (ArrayList<String>) ServerConnection.RequestAjluulah("getTeacherStudentProfile", CustomerLogin.getTmp_username());

        for (String asd : nersArray) {
            String[] spl = asd.split("::");
            students.getItems().add(spl[3]);
            adding_students.add(asd);
        }

        ObservableList<String> shalgaltComboItems = FXCollections.observableArrayList();
        ArrayList<String> shalgalt_status = (ArrayList<String>) ServerConnection.RequestAjluulah("getShalgaltStatus", CustomerLogin.getTmp_username());
        for (String str : shalgalt_status) {
            String[] spl = str.split("::");
            String id = spl[0];
            String status = spl[1];
            String pointx = spl[2];

            shalgaltComboItems.add(status);
            adding_shalgalt.add(str);
        }
        shalgaltCombo = new ComboBox(shalgaltComboItems);
        shalgaltCombo.setPrefSize(200, 30);

        ArrayList<String> shalgalts = (ArrayList<String>) ServerConnection.RequestAjluulah("getSubject", null);
        for (String str : shalgalts) {
            String[] spl = str.split("::");
            Label idl = new Label(spl[0]);
            idl.setVisible(false);
            idl.setPrefSize(0, 0);
            Label namel = new Label(spl[1]);
            shalgalt1Items.add(spl[1]);
            adding_subjects.add(str);
        }

        shalgalt1 = new ComboBox(shalgalt1Items);
        shalgalt1.setPrefSize(130, 20);
//        shalgalt1.setValue("Хичээлийн нэр");

        Button shalgaltadd = new Button("+");
        shalgaltadd.setId("green");
        shalgaltadd.setPrefSize(30, 20);
        shalgaltadd.setOnAction(ae -> {

//            Stage yourStage = new Stage();
//                 ShalgaltName asd = new ShalgaltName();
//                 asd.start(yourStage);
            start(new Stage());
        });

        Button shalgaltdelete = new Button("-");
        shalgaltdelete.setId("green");
        shalgaltdelete.setPrefSize(30, 20);
        shalgaltdelete.setOnAction(ae -> {

            if (shalgalt1.getSelectionModel().getSelectedIndex() > 0) {

                HBox box = (HBox) shalgalt1.getSelectionModel().getSelectedItem();
                String id = ((Label) box.getChildren().get(0)).getText();
                String msg = ServerConnection.RequestAjluulah("deleteSubject", id).toString();
                if (msg.equals("error")) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Алдаа гарлаа");
                    alert.setHeaderText("Ашиглаж буй сурагч байна");
                    alert.setContentText("Энэ мэдээллийг сурагч ашиглаж байгаа тул та засах юм уу шинээр оруулна уу!");

                    alert.showAndWait();

                } else {
                    shalgalt1.getItems().remove(shalgalt1.getSelectionModel().getSelectedIndex());
                }
            } else {

            }
        });

        FlowPane sum = new FlowPane(0, 0);
        sum.getChildren().addAll(shalgalt1, shalgaltadd, shalgaltdelete);
        sum.setPrefSize(190, 20);

//        Button calender =  new Button("Он сар өдөр");
//        calender.setAlignment(Pos.CENTER);
//        calender.setFont(javafx.scene.text.Font.font("Arial", FontWeight.EXTRA_LIGHT, 15));
//        calender.setPrefSize(120, 20);
//        calender.setId("green");
//        calender.setOnAction(ae->{
//            
//        });
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        checkInDatePicker = new DatePicker();

        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter
                    = DateTimeFormatter.ofPattern(pattern);

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
        };

        checkInDatePicker.setConverter(converter);
        checkInDatePicker.setPromptText(pattern.toLowerCase());
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
//        Label checkInlabel = new Label("Check-In Date:");
//        gridPane.add(checkInlabel, 0, 0);
//        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane.add(checkInDatePicker, 0, 0);
        vbox.getChildren().add(gridPane);
        checkInDatePicker.requestFocus();
        gridPane.setId("green");

        //?? ** //////////////////////////////////////////////////////////////////////////////////////////////
        Button addBtn = new Button("Батлах");
        addBtn.setAlignment(Pos.CENTER);
        addBtn.setFont(javafx.scene.text.Font.font("Arial", FontWeight.EXTRA_LIGHT, 15));
        addBtn.setPrefSize(100, 20);
        addBtn.setOnAction(ae -> {
//        String send = dunTf.getText();
//        ClientTest.RequestAjluulah("insertDunDaalgavar", send);
//        System.out.println(ClientTest.RequestAjluulah("insertDunDaalgavar", send));

            String student_name = students.getValue().toString();
            String subject_name = shalgalt1.getSelectionModel().getSelectedItem().toString();
            String shalgalt_name = shalgaltCombo.getSelectionModel().getSelectedItem().toString();
            String onsarudur = checkInDatePicker.getValue().toString();

            String student_id = "";
            for (String str : adding_students) {
                String[] spl = str.split("::");
                if (student_name.equals(spl[3])) {
                    student_id = spl[0];
                    break;
                }
            }

            String subject_id = "";
            for (String str : adding_subjects) {
                String[] spl = str.split("::");
                if (subject_name.equals(spl[1])) {
                    subject_id = spl[0];
                    break;
                }
            }

            String shalgalt_id = "";
            for (String str : adding_shalgalt) {
                String[] spl = str.split("::");
                if (shalgalt_name.equals(spl[1])) {
                    shalgalt_id = spl[0];
                    break;
                }
            }

            String t = "" + student_id + "::" + subject_id + "::" + shalgalt_name + "::" + shalgalt_id + "::" + onsarudur;
            System.out.println(t);
            ServerConnection.RequestAjluulah("insertDunShalgalt", t);
            refreshTable();

        });

        addBtn.setId("green");

//        ct.addRows(tobe_rows);
//        for (int i = 0; i < newList.size(); i++) {
//            ArrayList<Object> data = new ArrayList<>();
//
//            data.add("");
//            Column column = new Column(newList.get(i).toString(), data);
//            ct.addColumns(column);
//        }
        flow2.getChildren().addAll(students, sum, shalgaltCombo, gridPane, addBtn);

        shalgaltDun.getChildren().addAll(topBf, scrl, flow2);

    }

    private void shalgaltRefresh() {
        shalgalt1Items.clear();
        ArrayList<String> shalgalts = (ArrayList<String>) ServerConnection.RequestAjluulah("getSubject", null);
        for (String str : shalgalts) {
            String[] spl = str.split("::");
            Label idl = new Label(spl[0]);
            idl.setVisible(false);
            idl.setPrefSize(0, 0);
            Label namel = new Label(spl[1]);
            shalgalt1Items.add(spl[1]);
        }
    }

    public FlowPane getContainer() {
        return this.shalgaltDun;
    }

    private TableView getTable() {
        return ct.getTable();
    }

    private void refreshTable() {
        row1.clear();
        ArrayList<String> resd = (ArrayList<String>) ServerConnection.RequestAjluulah("getSuraltsajBaigaaStudentShalgalt", null);
        for (String str : resd) {
            String name = "";
            String point = "";
            String exam = "";
            String date = "";
            String id = "";

            String[] spl = str.split("::");
            name = spl[0];
            point = spl[2];
            exam = spl[1];
            date = spl[3];
            id = spl[4];

            row1.add(new ShalgaltDunModel(id, name, point, exam, date));
        }
    }

    public void start(Stage yourStage) {
        yourStage.setTitle("Хичээлийн нэр оруулах");
        FlowPane rootNode = new FlowPane(30, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 1000, 80);
        yourStage.setScene(myScene);
        yourStage.setResizable(false);

        txt = new TextField();
        txt.setId("green");
        txt.setPromptText("Тооны машин");
        txt.setPrefSize(150, 20);
        add = new Button("Оруулах");
        add.setId("green");
        add.setPrefSize(150, 20);

        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        checkInDatePicker1 = new DatePicker();

        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter
                    = DateTimeFormatter.ofPattern(pattern1);

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
        };

        checkInDatePicker1.setConverter(converter);
        checkInDatePicker1.setPromptText(pattern1.toLowerCase());
        gridPane1 = new GridPane();
        gridPane1.setHgap(10);
        gridPane1.setVgap(10);
//        Label checkInlabel = new Label("Check-In Date:");
//        gridPane.add(checkInlabel, 0, 0);
//        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane1.add(checkInDatePicker1, 0, 0);
        vbox.getChildren().add(gridPane1);
        checkInDatePicker1.requestFocus();
//        gridPane1.setId("green");

        VBox vbox1 = new VBox(20);
        vbox1.setStyle("-fx-padding: 10;");
        DatePicker checkInDatePicker2 = new DatePicker();

        StringConverter converter1 = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter
                    = DateTimeFormatter.ofPattern(pattern1);

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
        };

        checkInDatePicker2.setConverter(converter1);
        checkInDatePicker2.setPromptText(pattern1.toLowerCase());
        GridPane gridPane2 = new GridPane();
        gridPane2.setHgap(10);
        gridPane2.setVgap(10);
//        Label checkInlabel = new Label("Check-In Date:");
//        gridPane.add(checkInlabel, 0, 0);
//        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane2.add(checkInDatePicker2, 0, 0);
        vbox.getChildren().add(gridPane2);
        checkInDatePicker2.requestFocus();
//        gridPane1.setId("green");

        Label lab = new Label("Хичээлийн нэр");
        lab.setPrefSize(250, 20);
        lab.setPadding(new Insets(0, 0, 0, 150));
        Label lab1 = new Label("Эхэлсэн өдөр");
        lab1.setPrefSize(150, 20);
        lab1.setPadding(new Insets(0, 0, 0, 20));
        Label lab2 = new Label("Дууссан өдөр");
        lab2.setPrefSize(150, 20);
        lab2.setPadding(new Insets(0, 0, 0, 15));

        FlowPane asd = new FlowPane(60, 10);
        asd.getChildren().addAll(lab, lab1, lab2);
        asd.setPrefSize(1000, 20);
        asd.setAlignment(Pos.BASELINE_LEFT);

        add.setOnAction(ae -> {

            String t1 = txt.getText();
            String ehlehDate = checkInDatePicker1.getValue().toString();

            String duusahDate = checkInDatePicker2.getValue().toString();

            String ehlehYear = ehlehDate.split("-")[0];
            String ehlehMonth = ehlehDate.split("-")[1];
            String ehlehDay = ehlehDate.split("-")[2];

            String duusahYear = duusahDate.split("-")[0];
            String duusahMonth = duusahDate.split("-")[1];
            String duusahDay = duusahDate.split("-")[2];

            if (Integer.parseInt(ehlehYear) <= Integer.parseInt(duusahYear)) {
                if (Integer.parseInt(ehlehMonth) <= Integer.parseInt(duusahMonth)) {
                    if (Integer.parseInt(ehlehDay) <= Integer.parseInt(duusahDay)) {
                        betweenDaysValidate = true;
                    } else {
                        betweenDaysValidate = false;
                    }
                } else {
                    betweenDaysValidate = false;
                }
            } else {
                betweenDaysValidate = false;
            }

            if (betweenDaysValidate) {

                String t2 = "" + t1 + "::" + ehlehDate + "::" + duusahDate;
                ServerConnection.RequestAjluulah("insertSubject", t2);

                System.out.println(t2);
                shalgaltRefresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Та дуусах өдрөө буруу оруулсан байна!!!");
                alert.show();
            }

            yourStage.close();

        });

        rootNode.getChildren().addAll(asd, txt, gridPane1, gridPane2, add);

        yourStage.show();
    }

}
