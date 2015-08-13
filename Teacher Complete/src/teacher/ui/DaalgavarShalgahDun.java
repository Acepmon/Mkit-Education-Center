package teacher.ui;

import java.util.ArrayList;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import teacher.controller.ServerConnection;
import teacher.launch.Launcher;
import teacher.login.ui.CustomerLogin;
import teacher.model.Columns;
import teacher.model.CustomTable;
import teacher.model.CustomTable2;
import teacher.model.DunOruulahModel;
import teacher.model.DunOruulahModelNew;

public class DaalgavarShalgahDun {

    private FlowPane rootNode;

    ObservableList<DunOruulahModelNew.Record> data = FXCollections.observableArrayList();
    public static final ObservableList<FlowPane> oyutan = FXCollections.observableArrayList();
    private ObservableList<DunOruulahModel> responseData;
    private FlowPane dunOruulah;
    private TableView table;
    private CustomTable2 customT;
    Node getContainer;
    private CustomTable ct;
    public ArrayList<String> resd;

    class Nerniid {

        String ner;
        ArrayList<String> data = new ArrayList<>();
    }

    static class Row {

        private String[] data1;

        private String name;
        static int index = 0;

        public Row(String name, String[] data1) {
            this.data1 = data1;
        }

        public String getData1(int index) {
            return data1[index];
        }

        public void setData1(String[] data1) {
            this.data1 = data1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
    
    private String idIndex = "";
    
    public DaalgavarShalgahDun() {
        
        resd = (ArrayList<String>) ServerConnection.RequestAjluulah("getSuraltsajBaigaaStudentDaalgavar", CustomerLogin.getTmp_username());
        
        rootNode = new FlowPane();
        ct = new CustomTable();
//        resd.add("mongol::irsen::Даалгавар1");
//        resd.add("sugra::ovchtei::Даалгавар2");
//        resd.add("sugra::tasalsan::Даалгавар3");
//        resd.add("zorigo::irsen::Даалгавар4");
//        resd.add("bat::tasalsan::Даалгавар5");
//        resd.add("bat::tasalsan::Даалгавар7");
//        resd.add("bold::irsen::Даалгавар6");
//        resd.add("bold::irsen::Даалгавар7");

        ObservableList<Row> datas = FXCollections.observableArrayList();

        ObservableList<Object> baganuud = FXCollections.observableArrayList();

        ObservableList<Object> row1 = FXCollections.observableArrayList();

        for (int i = 0; i < resd.size(); i++) {
            String[] javalist = resd.get(i).split("::");
            baganuud.add(javalist[2]);
            idIndex = javalist[3];
            row1.add(new DunOruulahModel(javalist[0], javalist[1], javalist[2]));
        }
         System.out.println(idIndex);
        FlowPane topFp = new FlowPane();
        topFp.setPrefSize(1024, 60);
        topFp.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 0px;");

        FlowPane centerFp = new FlowPane();
        centerFp.setPrefSize(900, 644);
        centerFp.setStyle("-fx-background-color: white");

        FlowPane nersFp = new FlowPane();
        nersFp.setPrefSize(230, 644);
        nersFp.setStyle("-fx-background-color: white");
        nersFp.setHgap(20);
        nersFp.setAlignment(Pos.TOP_CENTER);
        nersFp.setPadding(new Insets(0, 3, 3, 0));

        Label titles = new Label("Даалгаврын дүн оруулах");

        titles.setAlignment(Pos.CENTER_LEFT);
        titles.setPrefSize(650, 60);
        titles.setFont(javafx.scene.text.Font.font("Arial", 20));
        titles.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        titles.setId("text");

        Button edit = new Button("Дүн оруулах");
        edit.setOnAction((event) -> {
            Launcher.DAALGAVARSHALGAHDUNORUULAH().start(new Stage());
        });
        edit.setPrefSize(105, 20);
        edit.setAlignment(Pos.CENTER);
        edit.setFont(Font.font("Arial", 14));
        edit.setId("green");
        Label free = new Label("");

        free.setPrefSize(15, 60);
        free.setId("text");

        Button fix = new Button("Засах");
        fix.setPrefSize(100, 20);
        fix.setFont(Font.font("Arial", 14));
        fix.setAlignment(Pos.CENTER);
                fix.setOnAction((event) -> {
            Launcher.DAALGAVARSHALGAHDUNORUULAH().start(new Stage());
        });

        fix.setId("green");
        Label free1 = new Label("");

        free1.setPrefSize(15, 60);
        free1.setId("text");

        Button delete = new Button("Устгах");
        delete.setOnAction(ae -> {
            ServerConnection.RequestAjluulah("deleteDunDaalgavar", idIndex);

            ArrayList<ArrayList<Object>> rowustgah = customT.getSelectedRows();
            if (rowustgah.size() > 0) {
                ArrayList<Object> rowdel = rowustgah.get(0);
                ArrayList<CustomTable2.CustomTableCell> rowhuvirsan = new ArrayList<>();
                for (int i = 0; i < rowdel.size(); i++) {
                    rowhuvirsan.add((CustomTable2.CustomTableCell) rowdel.get(i));
                    System.out.println(rowhuvirsan.get(i).getCellValue());
                }
                int index = customT.getTable().getSelectionModel().getSelectedIndex();
                String name = ((Label) oyutan.get(index).getChildren().get(0)).getText();
                ArrayList<Integer> hosomuusuga = new ArrayList<>();
                for (int i = 0; i < resd.size(); i++) {
                    String[] hososuga = resd.get(i).split("::");
                    if (name.equals(hososuga[0])) {
                        for (int j = 0; j < rowhuvirsan.size(); j++) {
                            if (hososuga[1].trim().equals(rowhuvirsan.get(j).getCellValue().toString().trim())) {
                                System.out.println(i);
                                hosomuusuga.add(i);
                                break;
                            }
                        }
                    }
                }
                hosomuusuga.sort(new Comparator<Integer>() {

                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o1 < o2) {
                            return 1;
                        } else if (o1 > o2) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
                for (int i = 0; i < hosomuusuga.size(); i++) {
                    resd.remove(hosomuusuga.get(i).intValue());
                }
                refreshTable();

            } else {
                System.out.println("Ta mur songogui bna");
            }

        });
        delete.setPrefSize(100, 20);
        delete.setAlignment(Pos.CENTER);

        delete.setFont(Font.font("Arial", 14));
        delete.setId("green");

        topFp.getChildren().addAll(titles, edit, free, fix, free1, delete);

        //****************************
        VBox topBox = new VBox();
        topBox.setPrefSize(1024, 60);
        VBox nersBox = new VBox();

        nersBox.setPrefSize(1024, 644);
        nersBox.setPadding(new Insets(0, 25, 50, 3));

        System.out.println("DAAAAAAAAAAAAAAAA");
        for (String str : resd) {
            System.out.println(str);
        }
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSS");

        //******************************   
        customT = new CustomTable2();
        customT.setCol_width(100);
        customT.getTable().setPrefSize(800, 645);
//        table = new TableView();
//        table.setEditable(true);
////        table.setItems(row1);
//        table.setStyle("-fx-alignment: CENTER;");
//        table.setPrefSize(400, 645);

        TableColumn<DunOruulahModel, String> IdCol
                = new TableColumn<>("Column1");
        IdCol.setMinWidth(250);
        IdCol.setCellValueFactory(
                new PropertyValueFactory<>("ner"));

        IdCol.setCellFactory(TextFieldTableCell.<DunOruulahModel>forTableColumn());
        IdCol.setOnEditCommit(
                (TableColumn.CellEditEvent<DunOruulahModel, String> t) -> {
                    ((DunOruulahModel) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setNer(t.getNewValue());
                });

//        TableColumn bd1 = new TableColumn("УЁРІС‡С‚СЌР№/Р§У©Р»У©У©С‚СЌР№");
//        bd1.setCellValueFactory(new PropertyValueFactory<>("bd1"));
//                bd1.setPrefWidth(120);
        TableColumn<DunOruulahModel, String> bd1
                = new TableColumn<>("Column2");
        bd1.setMinWidth(250);
        bd1.setCellValueFactory(
                new PropertyValueFactory<>("bd1"));

        bd1.setCellFactory(TextFieldTableCell.<DunOruulahModel>forTableColumn());
        bd1.setOnEditCommit(
                (TableColumn.CellEditEvent<DunOruulahModel, String> t) -> {
                    ((DunOruulahModel) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setBd1(t.getNewValue());
                });

//                TableColumn bd2 = new TableColumn("РћРЅ СЃР°СЂ");
//        bd2.setCellValueFactory(new PropertyValueFactory<>("bd2"));
//        bd2.setPrefWidth(120);
        TableColumn<DunOruulahModel, String> bd2
                = new TableColumn<>("Column3");
//                                for(int i = 0; )

        bd2.setMinWidth(250);
        bd2.setCellValueFactory(
                new PropertyValueFactory<>("bd2"));

        bd2.setCellFactory(TextFieldTableCell.<DunOruulahModel>forTableColumn());
        bd2.setOnEditCommit(
                (TableColumn.CellEditEvent<DunOruulahModel, String> t) -> {
                    ((DunOruulahModel) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setBd2(t.getNewValue());
                });

//        table.getColumns().addAll(IdCol, bd1,bd2);
        ObservableList<String> resdn = FXCollections.observableArrayList();
        resd.stream().forEach((str) -> resdn.add(str));
        ListView listView = new ListView(oyutan);
        listView.setEditable(false);
        listView.setPrefSize(170, 575);

        ArrayList<String> names = resdeesNerSalgah(resdn);

        for (int i = 0; i < names.size(); i++) {

            FlowPane flowpane = new FlowPane();
//            CheckBox check = new CheckBox();
            Label label = new Label(names.get(i));

            flowpane.getChildren().addAll(label);
            flowpane.setPrefWidth(200);
            flowpane.setAlignment(Pos.CENTER_LEFT);
            flowpane.setPadding(new Insets(3, 3, 3, 3));
            flowpane.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: "
                    + "0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 0px");

            oyutan.add(flowpane);
        }
        refreshTable();

//*********************  All select hiideg heseg
//        Label all = new Label("Бүгдийг нь сонгох");
//        all.setPrefSize(150, 20);
//        CheckBox c = new CheckBox();
//        c.setOnAction(ae
//                -> {
//
//                    for (int i = 0; i < outan.size(); i++) {
//
//                        if (c.isSelected()) {
//                            ((CheckBox) outan.get(i).getChildren().get(0)).setSelected(true);
//                        } else {
//                            ((CheckBox) outan.get(i).getChildren().get(0)).setSelected(false);
//                        }
//                    }
//
//                }
//        );
//        table.setItems(responseData);
//        table.getColumns().add(ners1);
//      nersFp.getChildren().addAll(listView, c, all);
        //**********************************************
//        ListView listView1 = new ListView(data);
//        listView1.setEditable(false);
//        listView1.setPrefSize(230, 575); 
//        for (int i = 0; i < responseData.size(); i++) {
//            
//            FlowPane flowpane1 = new FlowPane();
//            Label label = new Label("" + (i + 1) + ". " + responseData.get(i));
//
//            flowpane1.getChildren().addAll(grade, listView1);
//            flowpane1.setPrefWidth(200);
//            flowpane1.setAlignment(Pos.CENTER_LEFT);
//            flowpane1.setPadding(new Insets(3, 3, 3, 3));
//            flowpane1.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: "
//                    + "0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 0px");
//            data.add(null);
//        }
        TableView tableView3 = new TableView();
        tableView3.setPrefSize(600, 644);
        tableView3.setEditable(true);

        TableColumn grade0 = new TableColumn("grade1");
        TableColumn grade2 = new TableColumn("grade2");
        TableColumn grade3 = new TableColumn("grade3");
        TableColumn grade4 = new TableColumn("grade4");
        TableColumn grade5 = new TableColumn("grade5");
        tableView3.getColumns().addAll(grade0, grade2, grade3, grade4, grade5);

        nersFp.getChildren().addAll(listView, customT.getTable());
//        centerFp.getChildren().addAll(listView1);

        topBox.getChildren().add(topFp);
        nersBox.getChildren().addAll(nersFp, centerFp);

        rootNode.getChildren().addAll(topBox, nersBox);
        rootNode.setId("border");
    }

    public FlowPane getContainer() {
        return this.rootNode;
    }

    private ArrayList<String> resdeesNerSalgah(ObservableList<String> resd) {
        ArrayList<String> ners = new ArrayList<>();
        for (String res : resd) {
            String[] split = res.split("::");
            boolean davhard = false;
            for (String ner : ners) {
                if (ner.equals(split[0])) {
                    davhard = true;
                }
            }
            if (davhard == false) {
                ners.add(split[0]);
            }
            System.out.print(ners);
        }
        return ners;
    }

    private ArrayList<String> resdeesOgnooSalgah(ObservableList<String> resd) {
        ArrayList<String> ognoo = new ArrayList<>();
        for (String res1 : resd) {
            String[] split = res1.split("::");
            boolean davhard = false;
            for (String ognoo1 : ognoo) {
                if (ognoo1.equals(split[2])) {
                    davhard = true;
                }
            }
            if (davhard == false) {
                ognoo.add(split[2]);
            }
        }
        return ognoo;
    }

    private ArrayList<Nerniid> nereesUtgaSalgah(ObservableList<String> resd) {
        ArrayList<Nerniid> nerniiduud = new ArrayList<>();
        ArrayList<String> ners = resdeesNerSalgah(resd);
        for (String ner : ners) {
            Nerniid nerniid = new Nerniid();
            nerniid.ner = ner;
            for (String orig : resd) {
                String[] split = orig.split("::");
                if (ner.equals(split[0])) {
                    String data = split[1] + "::" + split[2];
                    nerniid.data.add(data);
                }
            }
            nerniiduud.add(nerniid);
        }
        return nerniiduud;
    }

    private ArrayList<ArrayList<String>> tableMedeelel(ObservableList<String> resd) {
        ArrayList<ArrayList<String>> medeelelList = new ArrayList<>();

        ArrayList<Nerniid> nerniid = nereesUtgaSalgah(resd);
        ArrayList<String> ognoo = resdeesOgnooSalgah(resd);

//        medeelelList.get(0).add("Ners");
//        for (String ogn : ognoo) {
//            medeelelList.get(0).add(ogn);
//        }
        ArrayList<String> medeelel0 = new ArrayList<>();
        medeelel0.add("Нэрс");
        for (String ogn : ognoo) {
            medeelel0.add(ogn);
        }
        medeelelList.add(medeelel0);

        for (Nerniid nern : nerniid) {

            ArrayList<String> medeelel = new ArrayList<>();
            medeelel.add(nern.ner);
            // Hooson utga medeeld oruulah
            for (String ogn : ognoo) {
                medeelel.add("-");
            }
            // ************************

            for (String data : nern.data) {
                String[] split = data.split("::");
                String status = split[0];
                String on = split[1];

                for (int i = 0; i < ognoo.size(); i++) {
                    if (ognoo.get(i).equals(on)) {
                        medeelel.set(i + 1, status);
                    }
                }
            }

            medeelelList.add(medeelel);
        }

        return medeelelList;
    }

    public void refreshTable() {
        customT.clearTable();

        oyutan.clear();
        ObservableList<String> resdn = FXCollections.observableArrayList();
        resd.stream().forEach((str) -> resdn.add(str));
        ArrayList<String> names = resdeesNerSalgah(resdn);

        for (int i = 0; i < names.size(); i++) {

            FlowPane flowpane = new FlowPane();
//            CheckBox check = new CheckBox();
            Label label = new Label(names.get(i));

            flowpane.getChildren().addAll(label);
            flowpane.setPrefWidth(200);
            flowpane.setAlignment(Pos.CENTER_LEFT);
            flowpane.setPadding(new Insets(3, 3, 3, 3));
            flowpane.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: "
                    + "0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 0px");

            oyutan.add(flowpane);
        }

//        resd.sort(new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                String[] day1split = o1.split("::");
//                String[] day2split = o2.split("::");
//                
//                int year1int = Integer.parseInt(day1split[2].split("/")[0]);
//                int year2int = Integer.parseInt(day2split[2].split("/")[0]);
//
//                int month1int = Integer.parseInt(day1split[2].split("/")[1]);
//                int month2int = Integer.parseInt(day2split[2].split("/")[1]);
//                
//                int day1int = Integer.parseInt(day1split[2].split("/")[2]);
//                int day2int = Integer.parseInt(day2split[2].split("/")[2]);
//                
//                if (year1int == year2int) {
//                    if (month1int == month2int) {
//                        if (day1int == day2int) {
//                            return 0;
//                        } else if (day1int > day2int) {
//                            return 1;
//                        } else {
//                            return -1;
//                        }
//                    } else if (month1int > month2int) {
//                        return 1;
//                    } else {
//                        return -1;
//                    }
//                } else if (year1int > year2int) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        });
        ArrayList<ArrayList<String>> tableMedeelel = tableMedeelel(resdn);
        System.out.println(tableMedeelel);
        ArrayList<Columns> customTableData = new ArrayList<>();
        for (int j = 1; j < tableMedeelel.get(0).size(); j++) {
            String colName = tableMedeelel.get(0).get(j);

            ArrayList<Object> colDatas = new ArrayList<>();
            for (int i = 1; i < tableMedeelel.size(); i++) {
                colDatas.add(tableMedeelel.get(i).get(j));
            }

            customTableData.add(new Columns(colName, colDatas));
        }
        Columns[] columns = new Columns[customTableData.size()];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = customTableData.get(i);
        }
        customT.addColumns(columns);
    }

}
