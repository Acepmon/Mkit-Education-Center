package teacher.ui;

import java.util.ArrayList;
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
import teacher.model.Columns;
import teacher.model.CustomTable;
import teacher.model.SearchModel;
import teacher.model.StudentGrade;

public class Tailan_left_inner {

    private ScrollPane scroll;
    private FlowPane inner_;
    private TableView table;
    private static ObservableList<SearchModel> searchData = FXCollections.observableArrayList();

    private CustomTable ct;

    public Tailan_left_inner() {
        ct = new CustomTable();

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

        inner_.getChildren().addAll(customTable());
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

    private TableView customTable() {
        ArrayList<Columns> cols = new ArrayList<Columns>();
        ArrayList<String> students = (ArrayList<String>) ServerConnection.RequestAjluulah("getAllStudentProfile", null);
        ArrayList<Object> datas = new ArrayList<>();
        
        for (String student : students) {
            String[] spl = student.split("::");
            String ovog = spl[2];
            String ner = spl[3];
            String name = ovog + " " + ner;
            datas.add(name);
        }
        
        Columns names = new Columns("Нэрс", datas);
        cols.add(names);
        
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
}
