package teacher.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import teacher.model.Columns;
import teacher.model.CustomTable2;
import teacher.model.DunOruulahModel;

public class ShalgaltDunOruulah {

    public static final ObservableList<FlowPane> oyutan = FXCollections.observableArrayList();
    private TableView table;
    private FlowPane shalgaltDun, flow2;

    private DatePicker checkInDatePicker;
    private final String pattern = "yyyy-MM-dd";
    private ComboBox shalgalt1;
    GridPane gridPane1;
    private TextField txt;
    private Button add;
    private DatePicker checkInDatePicker1;
    private final String pattern1 = "yyyy-MM-dd";

    Node getContainer;

    private CustomTable2 ct;
    boolean betweenDaysValidate = false;

    public ShalgaltDunOruulah() {
        ct = new CustomTable2();
//        ArrayList<String> resd = (ArrayList<String>) ClientTest.RequestAjluulah("getClassIrts",CustomerLogin.getTmp_username());
        ObservableList<String> resd = FXCollections.observableArrayList();
//        ObservableList<String> responseData =(ObservableList<String>) ClientTest.RequestAjluulah("getClassIrts",CustomerLogin.getTmp_username());

//        System.out.println("a asd ="+resd);
//        if (!resd.equals("") && resd == null) {
//            for (String str : resd) {
//                System.out.println(str);
//            }
//        }
        resd.add("mongol::harisan::2015/05/01");
        resd.add("sugra::ovchtei::2015/04/01");
        resd.add("sugra::tasalsan::2015/04/02");
        resd.add("zorigo::irsen::2015/04/01");
        resd.add("bat::tasalsan::2015/01/12");
        resd.add("bold::irsen::2015/03/02");
        resd.add("bold::yavsan::2015/03/03");

//      
        ObservableList<Object> baganuud = FXCollections.observableArrayList();
        ObservableList<Object> baganuud1 = FXCollections.observableArrayList();
        ObservableList<Object> baganuud2 = FXCollections.observableArrayList();

        ObservableList<Object> row1 = FXCollections.observableArrayList();

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

        Label saveLb = new Label("Хадгалах");
        saveLb.setAlignment(Pos.CENTER);
        saveLb.setPrefSize(100, 25);
        saveLb.setFont(javafx.scene.text.Font.font("Arial", 15));
        saveLb.setId("red");

        Label editLb = new Label("Засах");
        editLb.setAlignment(Pos.CENTER);
        editLb.setPrefSize(80, 25);
        editLb.setFont(javafx.scene.text.Font.font("Arial", 15));
        editLb.setId("red");
       

        btnFl.getChildren().addAll(saveLb, editLb);

        topBf.setLeft(nameLbl);
        topBf.setRight(btnFl);

        //////////////////////////////// 
        table = new TableView();
        table.setEditable(true);
        table.setItems(row1);
        table.setStyle("-fx-alignment: CENTER;");
        table.setPrefSize(1020, 645);

        TableColumn IdCol = new TableColumn("Сурагчийн нэр");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("ner"));
        IdCol.setEditable(false);

        IdCol.setPrefWidth(200);

        TableColumn<DunOruulahModel, String> IdCol1
                = new TableColumn<>("Авсан оноо");
        IdCol1.setCellValueFactory(new PropertyValueFactory<>("ner"));
        IdCol1.setEditable(false);

        IdCol1.setPrefWidth(200);
        IdCol1.setCellFactory(TextFieldTableCell.<DunOruulahModel>forTableColumn());
        IdCol1.setOnEditCommit(
                (TableColumn.CellEditEvent<DunOruulahModel, String> t) -> {
                    ((DunOruulahModel) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setIdCol1(t.getNewValue());
                });

//        TableColumn IdCol2 = new TableColumn("Авах оноо");
//        IdCol2.setCellValueFactory(new PropertyValueFactory<>("ner"));
//        IdCol2.setEditable(false);
//
//        IdCol2.setPrefWidth(200);
//        TableColumn<DunOruulahModel, String> IdCol
//                = new TableColumn<>("Нэр");
//        IdCol.setMinWidth(100);
//        IdCol.setCellValueFactory(
//                new PropertyValueFactory<>("ner"));
//
//        IdCol.setCellFactory(TextFieldTableCell.<DunOruulahModel>forTableColumn());
//        IdCol.setOnEditCommit(
//                (TableColumn.CellEditEvent<DunOruulahModel, String> t) -> {
//                    ((DunOruulahModel) t.getTableView().getItems().get(
//                            t.getTablePosition().getRow())).setNer(t.getNewValue());
//                });
//        TableColumn bd1 = new TableColumn("Өвчтэй/Чөлөөтэй");
//        bd1.setCellValueFactory(new PropertyValueFactory<>("bd1"));
//                bd1.setPrefWidth(120);
        TableColumn<DunOruulahModel, String> bd1
                = new TableColumn<>("Шалгалтын нэр");
        bd1.setMinWidth(200);
        bd1.setCellValueFactory(
                new PropertyValueFactory<>("bd1"));

        bd1.setCellFactory(TextFieldTableCell.<DunOruulahModel>forTableColumn());
        bd1.setOnEditCommit(
                (TableColumn.CellEditEvent<DunOruulahModel, String> t) -> {
                    ((DunOruulahModel) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setBd1(t.getNewValue());
                });

//                TableColumn bd2 = new TableColumn("Он сар");
//        bd2.setCellValueFactory(new PropertyValueFactory<>("bd2"));
//        bd2.setPrefWidth(120);
        TableColumn<DunOruulahModel, String> bd2
                = new TableColumn<>("Он сар өдөр");
//                                for(int i = 0; )

        bd2.setMinWidth(200);
        bd2.setCellValueFactory(
                new PropertyValueFactory<>("bd2"));

        bd2.setCellFactory(TextFieldTableCell.<DunOruulahModel>forTableColumn());
        bd2.setOnEditCommit(
                (TableColumn.CellEditEvent<DunOruulahModel, String> t) -> {
                    ((DunOruulahModel) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setBd2(t.getNewValue());
                });

        ComboBox studens = new ComboBox();
        studens.setPrefSize(120, 20);
        studens.setValue("Оюутны нэрс");
        studens.getItems().addAll("Болд", "Бат");

        shalgalt1 = new ComboBox();
        shalgalt1.setPrefSize(130, 20);
        shalgalt1.setValue("Хичээлийн нэр");

        Button shalgaltadd = new Button("+");
        shalgaltadd.setId("green");
        shalgaltadd.setPrefSize(30, 20);
        shalgaltadd.setOnAction(ae -> {

//            Stage yourStage = new Stage();
//                 ShalgaltName asd = new ShalgaltName();
//                 asd.start(yourStage);
            start(new Stage());
        });

        FlowPane sum = new FlowPane(0, 0);
        sum.getChildren().addAll(shalgalt1, shalgaltadd);
        sum.setPrefSize(160, 20);

        TextField shalgalt = new TextField();
        shalgalt.setPromptText("Шалгалтын нэр");
        shalgalt.setPrefSize(120, 20);
        shalgalt.setAlignment(Pos.CENTER);
        shalgalt.setVisible(true);

        TextField dunTf = new TextField();
        dunTf.setPromptText("Дүн");
        dunTf.setPrefSize(60, 20);
        dunTf.setAlignment(Pos.CENTER);
        dunTf.setVisible(true);

//        Button calender =  new Button("Он сар өдөр");
//        calender.setAlignment(Pos.CENTER);
//        calender.setFont(javafx.scene.text.Font.font("Arial", FontWeight.EXTRA_LIGHT, 15));
//        calender.setPrefSize(120, 20);
//        calender.setId("green");
//        calender.setOnAction(ae->{
//            
//        });
        //?? ** ////////////////////////////////////////////////////////////////////////////////
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
        GridPane gridPane = new GridPane();
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

            String cb1 = studens.getValue().toString();
            String cb2 = shalgalt1.getValue().toString();
            String shalgaltTf = shalgalt.getText();
            String dunTxf = dunTf.getText();
            String onsarudur = checkInDatePicker.getValue().toString();

            String t = "" + cb1 + "::" + cb2 + "::" + shalgaltTf + "::" + dunTxf + "::" + onsarudur;

            System.out.println(t);

        });

        addBtn.setId("green");

        table.getColumns().addAll(IdCol, IdCol1, bd1, bd2);
        table.setPrefHeight(600);

        ScrollPane scrl = new ScrollPane(table);

        resd.sort(new Comparator<Object>() {

            @Override
            public int compare(Object date1, Object date2) {

                String[] row1 = date1.toString().split("::");
                String[] row2 = date2.toString().split("::");

                String[] day1split = row1[2].split("/");
                String[] day2split = row2[2].split("/");

                int year1int = Integer.parseInt(day1split[1]);
                int year2int = Integer.parseInt(day2split[1]);

                if (year1int > year2int) {
                    return 1;
                }
                if (year1int < year2int) {
                    return -1;
                }
                if (year1int == year2int) {
                    return 0;
                }

                int month1int = Integer.parseInt(day1split[1]);
                int month2int = Integer.parseInt(day2split[1]);

                if (month1int > month2int) {
                    return 1;
                }
                if (month1int < month2int) {
                    return -1;
                }
                if (month1int == month2int) {
                    return 0;
                }

                int day1int = Integer.parseInt(day1split[2]);
                int day2int = Integer.parseInt(day2split[2]);

                if (day1int > day2int) {
                    return 1;
                }
                if (day1int < day2int) {
                    return -1;
                }
                if (day1int == day2int) {
                    return 0;
                }

                return 0;
            }
        });

        for (int i = 0; i < resd.size(); i++) {
            String[] javalist = resd.get(i).split("::");
            baganuud.add(javalist[2]);
            baganuud1.add(javalist[1]);
            baganuud2.add(javalist[0]);
            for (int y = 0; y < javalist.length; y++) {
                boolean davhardsan = false;
                for (int j = 0; j < baganuud.size(); j++) {
                    if (javalist[y].equals(baganuud.get(j).toString())) {
                        davhardsan = true;
                    }
                }
                if (davhardsan) {
//                baganuud.add(javalist[y]);
                }
            }
            row1.add(new DunOruulahModel(javalist[0], javalist[1], javalist[2]));
        }

        ObservableList<Object> newList = FXCollections.observableArrayList();
        for (int i = 0; i < baganuud.size(); i++) {
            boolean davhardSanBainuu = false;
            for (int j = 0; j < newList.size(); j++) {
                if (baganuud.get(i).toString().equals(newList.get(j).toString())) {
                    davhardSanBainuu = true;
                }
            }
            if (!davhardSanBainuu) {
                newList.add(baganuud.get(i));
            }
        }
        ArrayList<Object> someData = new ArrayList<>();
        someData.add("");
        Columns nameCol = new Columns("Names", someData);
        Columns[] columnH = new Columns[newList.size() + 1];
        for (int i = 0; i < columnH.length; i++) {
            if (i == 0) {
                columnH[i] = nameCol;
            } else {
                Columns column = new Columns(newList.get(i - 1).toString(), someData);
                columnH[i] = column;
            }
        }
        ct.addColumns(columnH);
        for (Object obj : newList) {
            System.out.println(obj.toString());
        }

        ArrayList<ArrayList<Object>> tobe_rows = new ArrayList<>();
        for (int i = 0; i < newList.size(); i++) {
            ArrayList<Object> row_cells = new ArrayList<>();
            for (int j = 0; j < resd.size(); j++) {
                if (j == 0) {
                    row_cells.add("" + resd.get(j).split("::")[0]);
                }

                if (resd.get(j).split("::")[2].equals(newList.get(i))) {
                    row_cells.add("" + resd.get(j).split("::")[1]);
                }
            }
            tobe_rows.add(row_cells);
        }

        for (ArrayList<Object> objs : tobe_rows) {
            System.out.println("");
            for (Object obj : objs) {
                System.out.print(obj.toString() + " ");
            }
            System.out.println("");
        }

//        ct.addRows(tobe_rows);
//        for (int i = 0; i < newList.size(); i++) {
//            ArrayList<Object> data = new ArrayList<>();
//
//            data.add("");
//            Column column = new Column(newList.get(i).toString(), data);
//            ct.addColumns(column);
//        }
        flow2.getChildren().addAll(studens, sum, shalgalt, dunTf, gridPane, addBtn);

        shalgaltDun.getChildren().addAll(topBf, scrl, flow2);

    }

    public FlowPane getContainer() {
        return this.shalgaltDun;
    }

    private TableView getTable() {
        return ct.getTable();
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
                System.out.println(t2);

                shalgalt1.getItems().addAll(t1);
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
