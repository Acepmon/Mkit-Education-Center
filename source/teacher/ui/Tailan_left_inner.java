package teacher.ui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import teacher.launch.Launcher;
import teacher.model.SearchModel;
import teacher.model.StudentGrade;

public class Tailan_left_inner {

    private ScrollPane scroll;
    private FlowPane inner_;
    private TableView table;
    private static ObservableList<SearchModel> searchData = FXCollections.observableArrayList();

    public Tailan_left_inner() {

        inner_ = new FlowPane();
        inner_.setPrefSize(220, 500);

        inner_.setId("panel");
        inner_.setAlignment(Pos.TOP_CENTER);

        Label label_one = new Label("BLANK");
        Label label_two = new Label("BLANK");
        label_one.setId("btns");
        label_two.setId("btns");

        table = new TableView(searchData);
        table.setEditable(false);
        table.setPrefSize(220, 500);

        TableColumn nersCol = new TableColumn("Нэрс");
        nersCol.setCellValueFactory(new PropertyValueFactory<>("ners"));
        nersCol.setEditable(false);

        TableColumn paneCol = new TableColumn("Ирц");
        paneCol.setCellValueFactory(new PropertyValueFactory<>("pane"));
        paneCol.setPrefWidth(50);

        TableColumn dateCol = new TableColumn("Өдөр");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateCol.setPrefWidth(100);
        table.getColumns().addAll(nersCol, paneCol, dateCol);

        Separator sep_one = new Separator();
        sep_one.setPrefWidth(180);

        Separator sep_two = new Separator();
        sep_two.setPrefWidth(180);

        inner_.getChildren().addAll(table);
        scroll = new ScrollPane(inner_);

    }

    public ScrollPane getContainer() {
        return this.scroll;
    }

    public static void setDatas() {
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
}
