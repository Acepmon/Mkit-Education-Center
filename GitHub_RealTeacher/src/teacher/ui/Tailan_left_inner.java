package teacher.ui;

import java.util.ArrayList;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import teacher.controller.ServerConnection;
import teacher.launch.Launcher;
import teacher.login.ui.CustomerLogin;
import teacher.model.Columns;
import teacher.model.CustomTable;
import teacher.model.SearchModel;
import teacher.model.StudentGrade;

public class Tailan_left_inner {

    class Nerniid {

        String ner;
        ArrayList<String> data = new ArrayList<>();
    }

    private ScrollPane scroll;
    public FlowPane inner_;
    private TableView table;
    private static ObservableList<SearchModel> searchData = FXCollections.observableArrayList();

    private CustomTable ct;
    private CustomTable ct2;
    private CustomTable ct3;
    private CustomTable ct4;
    private CustomTable ct5;
    private ArrayList<String> resd;

    public Tailan_left_inner() {
        ct = new CustomTable();
        ct2 = new CustomTable();
        ct3 = new CustomTable();
        ct4 = new CustomTable();
        ct5 = new CustomTable();

        inner_ = new FlowPane();
        inner_.setPrefSize(220, 450);

        inner_.setId("panel");
        inner_.setAlignment(Pos.TOP_CENTER);

        Label label_one = new Label("BLANK");
        Label label_two = new Label("BLANK");
        label_one.setId("btns");
        label_two.setId("btns");

        table = new TableView(searchData);
        table.setEditable(false);
        table.setPrefSize(220, 900);

        TableColumn nersCol = new TableColumn("Нэрс");
        nersCol.setSortable(false);
        nersCol.setEditable(false);
        nersCol.setGraphic(new CheckBox());
        nersCol.setMinWidth(100);
        nersCol.setCellValueFactory(new PropertyValueFactory<>("ners"));

        TableColumn paneCol = new TableColumn("Ирц");
        paneCol.setSortable(false);
        paneCol.setEditable(false);
        paneCol.setGraphic(new CheckBox());
        paneCol.setMinWidth(100);
        paneCol.setCellValueFactory(new PropertyValueFactory<>("pane"));

        TableColumn dateCol = new TableColumn("Өдөр");
        dateCol.setSortable(false);
        dateCol.setEditable(false);
        dateCol.setGraphic(new CheckBox());
        dateCol.setMinWidth(100);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.getColumns().addAll(nersCol, paneCol, dateCol);

        Separator sep_one = new Separator();
        sep_one.setPrefWidth(180);

        Separator sep_two = new Separator();
        sep_two.setPrefWidth(180);

        inner_.getChildren().add(customTable());
        scroll = new ScrollPane(inner_);

    }

    public ScrollPane getContainer() {
        return this.scroll;
    }

    public static void setDatas(String... datas) {
        for (StudentGrade stu : (ArrayList<StudentGrade>) Tailan_left.getStudentDatas()) {
            SearchModel sm = new SearchModel();
            sm.setNers(stu.getName());
            for (Object obj : stu.getIrts().getDun().getData()) {
                sm.setPane(obj.toString());
            }
            for (Object obj2 : stu.getIrts().getDate().getData()) {
                sm.setDate(obj2.toString());
            }
            searchData.add(sm);
        }
    }

    public void searchFilter() {
        String cellValue = "";
        ObservableList<SearchModel> tableItem = FXCollections.observableArrayList();
        for (int i = 0; i < searchData.size(); i++) {
            SearchModel searchModel = searchData.get(i);
            switch (Launcher.getTAILAN_LEFT().tailanCm.getValue().toString()) {
                case "Оюутны нэрээр":
                    cellValue = searchModel.getNers().toLowerCase();
                    break;

            }

            if (cellValue.contains(teacher.ui.Tailan_left.searchTf.getText().toLowerCase())) {
                tableItem.add(searchModel);
            }

            table.setItems(tableItem);
        }
    }

    public TableView customTable5() {

        ct5.clearTable();
        resd = (ArrayList<String>) ServerConnection.RequestAjluulah("getSuraltsajBaigaaStudentShalgalt", CustomerLogin.getTmp_username());
        ObservableList<String> resdn = FXCollections.observableArrayList();
        resd.stream().forEach((str) -> resdn.add(str));
        ArrayList<ArrayList<String>> tableMedeelel = tableMedeelel(resdn);
        ArrayList<Columns> customTableData = new ArrayList<>();

        for (int j = 0; j < tableMedeelel.get(0).size(); j++) {
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
        ct5.addColumns(columns);

        return ct5.getTable();

    }

    public TableView customTable4() {
        ct4.clearTable();
        resd = (ArrayList<String>) ServerConnection.RequestAjluulah("getSuraltsajBaigaaStudentDaalgavar", CustomerLogin.getTmp_username());
        ObservableList<String> resdn = FXCollections.observableArrayList();
        resd.stream().forEach((str) -> resdn.add(str));
        ArrayList<ArrayList<String>> tableMedeelel = tableMedeelel(resdn);
        ArrayList<Columns> customTableData = new ArrayList<>();

        for (int j = 0; j < tableMedeelel.get(0).size(); j++) {
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
        ct4.addColumns(columns);

        return ct4.getTable();

    }

    public TableView customTable3() {
        ct3.clearTable();
        resd = (ArrayList<String>) ServerConnection.RequestAjluulah("getSuraltsajBaigaaStudentIdevh", CustomerLogin.getTmp_username());
//        ArrayList<String> IdevhStatus = (ArrayList<String>) ServerConnection.RequestAjluulah("getIdevhStatus ", CustomerLogin.getTmp_username());
//        ArrayList<String> StudentName = (ArrayList<String>) ServerConnection.RequestAjluulah("getAllStudentProfile", CustomerLogin.getTmp_username());
//        ObservableList<Idevhi.Row> datas = FXCollections.observableArrayList();
        resd.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String[] day1split = o1.split("::");
                String[] day2split = o2.split("::");

                int year1int = Integer.parseInt(day1split[2].split("-")[0]);
                int year2int = Integer.parseInt(day2split[2].split("-")[0]);

                int month1int = Integer.parseInt(day1split[2].split("-")[1]);
                int month2int = Integer.parseInt(day2split[2].split("-")[1]);

                int day1int = Integer.parseInt(day1split[2].split("-")[2]);
                int day2int = Integer.parseInt(day2split[2].split("-")[2]);

                if (year1int == year2int) {
                    if (month1int == month2int) {
                        if (day1int == day2int) {
                            return 0;
                        } else if (day1int > day2int) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else if (month1int > month2int) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (year1int > year2int) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        ObservableList<String> resdn = FXCollections.observableArrayList();
        resd.stream().forEach((str) -> resdn.add(str));
        ArrayList<ArrayList<String>> tableMedeelel = tableMedeelel(resdn);
        ArrayList<Columns> customTableData = new ArrayList<>();

        for (int j = 0; j < tableMedeelel.get(0).size(); j++) {
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
        ct3.addColumns(columns);
        return ct3.getTable();

    }

    public TableView customTable2() {
        ct2.clearTable();
        resd = (ArrayList<String>) ServerConnection.RequestAjluulah("getSuraltsajBaigaaStudentIrts", CustomerLogin.getTmp_username());
        ArrayList<String> IrtsStatus = (ArrayList<String>) ServerConnection.RequestAjluulah("getIrtsStatus ", CustomerLogin.getTmp_username());
        ArrayList<String> StudentName = (ArrayList<String>) ServerConnection.RequestAjluulah("getTeacherStudentProfile", CustomerLogin.getTmp_username());
        ObservableList<IrtsBurtgel.Row> datas = FXCollections.observableArrayList();
        resd.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String[] day1split = o1.split("::");
                String[] day2split = o2.split("::");

                int year1int = Integer.parseInt(day1split[2].split("-")[0]);
                int year2int = Integer.parseInt(day2split[2].split("-")[0]);

                int month1int = Integer.parseInt(day1split[2].split("-")[1]);
                int month2int = Integer.parseInt(day2split[2].split("-")[1]);

                int day1int = Integer.parseInt(day1split[2].split("-")[2]);
                int day2int = Integer.parseInt(day2split[2].split("-")[2]);

                if (year1int == year2int) {
                    if (month1int == month2int) {
                        if (day1int == day2int) {
                            return 0;
                        } else if (day1int > day2int) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else if (month1int > month2int) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (year1int > year2int) {
                    return 1;
                } else {
                    return -1;
                }

            }
        });
        ObservableList<String> resdn = FXCollections.observableArrayList();
        resd.stream().forEach((str) -> resdn.add(str));
        ArrayList<ArrayList<String>> tableMedeelel = tableMedeelel(resdn);
//        System.out.println(tableMedeelel);
        ArrayList<Columns> customTableData = new ArrayList<>();

        for (int j = 0; j < tableMedeelel.get(0).size(); j++) {
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
        ct2.addColumns(columns);
        return ct2.getTable();
    }

    public TableView customTable() {
        ct.clearTable();
        ArrayList<Columns> cols = new ArrayList<Columns>();
        ArrayList<String> students = (ArrayList<String>) ServerConnection.RequestAjluulah("getTeacherStudentProfile", CustomerLogin.getTmp_username());

        ArrayList<Object> datas1 = new ArrayList<>();
        ArrayList<Object> datas2 = new ArrayList<>();
        ArrayList<Object> datas3 = new ArrayList<>();
        ArrayList<Object> datas4 = new ArrayList<>();
        ArrayList<Object> datas5 = new ArrayList<>();
        ArrayList<Object> datas6 = new ArrayList<>();
        ArrayList<Object> datas7 = new ArrayList<>();
        ArrayList<Object> datas8 = new ArrayList<>();
        ArrayList<Object> datas9 = new ArrayList<>();
        ArrayList<Object> datas10 = new ArrayList<>();
        ArrayList<Object> datas11 = new ArrayList<>();
        ArrayList<Object> datas12 = new ArrayList<>();
        for (String student : students) {
            System.out.println(student);
            String[] spl = student.split("::");
            String ovog = spl[2];
            String ner = spl[3];
            String name = ovog + " " + ner;
            String medeelel2 = spl[4];
            String medeelel3 = spl[5];
            String medeelel4 = spl[6];
            String medeelel5 = spl[7];
            String medeelel6 = spl[8];
            String medeelel7 = spl[9];
            String medeelel8 = spl[10];
            String medeelel9 = spl[11];
            String medeelel10 = spl[12];
            String medeelel11 = spl[13];
            datas1.add(name);
            datas2.add(medeelel2);
            datas3.add(medeelel3);
            datas4.add(medeelel4);
            datas5.add(medeelel5);
            datas6.add(medeelel6);
            datas7.add(medeelel7);
            datas8.add(medeelel8);
            datas9.add(medeelel9);
            datas10.add(medeelel10);
            datas11.add(medeelel11);
        }

        Columns names = new Columns("Нэрс", datas1);
        cols.add(names);

        Columns column2 = new Columns("Status", datas2);
        cols.add(column2);

        Columns column3 = new Columns("Utasnii dugaar", datas3);
        cols.add(column3);

        Columns column4 = new Columns("Mail Hayg", datas4);
        cols.add(column4);

        Columns column5 = new Columns("Social", datas5);
        cols.add(column5);

        Columns column6 = new Columns("regstriin hayg", datas6);
        cols.add(column6);

        Columns column7 = new Columns("geriin hayg", datas7);
        cols.add(column7);

        Columns column8 = new Columns("Mail Hayg", datas8);
        cols.add(column8);

        Columns column9 = new Columns("comnii dugaar", datas9);
        cols.add(column9);

        Columns column10 = new Columns("medhgui", datas10);
        cols.add(column10);

        Columns column11 = new Columns("Zurag", datas11);
        cols.add(column11);

        Columns[] columns = new Columns[cols.size()];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = cols.get(i);
        }
        ct.addColumns(columns);

        return ct.getTable();
    }

    public CustomTable getCustomTable() {
        return this.ct;
    }

    public CustomTable getCustomTable2() {
        return this.ct2;
    }

    public CustomTable getCustomTable3() {
        return this.ct3;
    }
    
     public CustomTable getCustomTable4() {
        return this.ct4;
    }
     
      public CustomTable getCustomTable5() {
        return this.ct5;
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
//            System.out.print(ners);
        }
        return ners;
    }

    private ArrayList<String> IrtsStatusSalgah(ObservableList<String> IrtsStatus) {
        ArrayList<String> ners = new ArrayList<>();
        for (String res : IrtsStatus) {
            String[] split = res.split("::");
            boolean davhard = false;
            for (String ner : ners) {
                if (ner.equals(split[1])) {
                    davhard = true;
                }
            }
            if (davhard == false) {
                ners.add(split[1]);
            }
//            System.out.print(ners);
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

    private ArrayList<String> resdneesNerSalgah(ArrayList<String> StudentName) {
        ArrayList<String> nersn = new ArrayList<>();
        for (String res : StudentName) {
            String[] split = res.split("::");
            boolean davhard = false;
            for (String onoo : nersn) {
                if (onoo.equals(split[3])) {
                    davhard = true;
                }
            }
            if (davhard == false) {
                nersn.add(split[3]);
            }
            System.out.print(nersn);
        }
        return nersn;
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
}
