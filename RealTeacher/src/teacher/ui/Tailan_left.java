package teacher.ui;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import teacher.launch.Launcher;
import teacher.model.Columns;
import teacher.model.CustomTable;
import teacher.model.StudentGrade;

public class Tailan_left {

    class Popupwindow {

        void start(Stage myStage) {

            myStage.setTitle("");
            FlowPane rootNode = new FlowPane(30, 20);
            rootNode.setAlignment(Pos.CENTER);
            Scene myScene = new Scene(rootNode, 250, 100);
            myStage.setScene(myScene);
            myStage.setResizable(false);
            myScene.getStylesheets().add(getClass().getResource("style/mainStyle.css").toExternalForm());
            Label lbl = new Label("Та мөр эсвэл баганын аль нэгийг сонгоно уу?");

            Button row = new Button("Багана");
            row.setId("green");
            row.setOnAction(ae -> {
                ArrayList<Columns> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable().getSelectedColumns();

                for (Columns col : selected) {
                    Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(col);
                }

                myStage.close();

            });

            Button column = new Button("Мөр");
            column.setId("green");
            column.setOnAction(ae -> {

                ArrayList<ArrayList<Object>> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable().getSelectedRows();
                ArrayList<ArrayList<Object>> something = new ArrayList<>();
                for (ArrayList<Object> list : selected) {
                    ArrayList<Object> some = new ArrayList<>();
                    for (Object obj : list) {
                        CustomTable.CustomTableCell cell = (CustomTable.CustomTableCell) obj;
                        some.add(cell.getCellValue());
                    }
                    something.add(some);
                }
                Launcher.getTAILAN_MEDEELEL().getTailanTable().addRows(something);
                myStage.close();

            }
            );

            rootNode.getChildren().setAll(lbl, row, column);
            myStage.show();

        }

    }

    private FlowPane leftFp, medeelelfp;
    private static ArrayList<StudentGrade> student;
    ComboBox tailanCm;
    static TextField searchTf;
    GridPane gp;
    Button btn, btn2, btn3;
    Label lbl;
    Stage myStage;

    public Tailan_left() {
        student = new ArrayList<>();
//        AddJisheeMedeelel();
//        ReadingJisheeMedeelel();

        leftFp = new FlowPane(20, 20);
        leftFp.setPrefSize(250, 708);
        leftFp.setStyle("-fx-background-color: #F6F6F7");
        leftFp.setAlignment(Pos.CENTER);

        Label nameLbl = new Label("Тайлан гаргах");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(250, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setId("text");

        FlowPane huvaariFp = new FlowPane();

        searchTf = new TextField();
        searchTf.setPrefSize(140, 20);

        Button searchBtn = new Button("Search");
        searchBtn.setPrefSize(60, 20);
        searchBtn.setId("green");
        searchBtn.setOnAction(ae -> {
            Launcher.getTAILAN_LEFT_INNER().searchFilter();
        });

        FlowPane searchFp = new FlowPane(0, 10);
        searchFp.setPrefSize(200, 80);

        tailanCm = new ComboBox();
        tailanCm.setPrefSize(200, 20);
        tailanCm.setValue("Оюутны нэрээр");
        tailanCm.getItems().addAll("Оюутны нэрээр");

        Button btn = new Button("Нэмэх");
        btn.setPrefSize(100, 20);
        btn.setId("green");

//        ArrayList<Object> asa = new ArrayList<>();
//        asa.add("as nagn s s");
//        Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(new Column("asd", asa));
        btn.setOnAction(ae -> {

            if (Launcher.getTAILAN_LEFT_INNER().getCustomTable().isColumnSelected() && Launcher.getTAILAN_LEFT_INNER().getCustomTable().isRowSelected()) {
                Stage myStage = new Stage();
                Popupwindow asd = new Popupwindow();
                asd.start(myStage);

            } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable().isColumnSelected()) {
                ArrayList<Columns> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable().getSelectedColumns();

                for (Columns col : selected) {
                    Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(col);
                }
            } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable().isRowSelected()) {

                ArrayList<ArrayList<Object>> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable().getSelectedRows();
                Launcher.getTAILAN_MEDEELEL().getTailanTable().addRows(selected);
            }

        });

        leftFp.setAlignment(Pos.TOP_CENTER);
        searchFp.getChildren().addAll(searchTf, searchBtn, tailanCm);
        leftFp.getChildren().addAll(nameLbl, searchFp, Launcher.getTAILAN_LEFT_INNER().getContainer(), btn);
        leftFp.setId("border");

    }

    public FlowPane getContainer() {
        return this.leftFp;
    }
//
//    private void AddJisheeMedeelel() {
//
//        ArrayList<Object> dunColumn = new ArrayList<>();
//        dunColumn.add("50");
//        dunColumn.add("85");
//        dunColumn.add("71");
//        dunColumn.add("65");
//        dunColumn.add("77");
//        ArrayList<Object> dateColumn = new ArrayList<>();
//        dateColumn.add("2015-04-01");
//        dateColumn.add("2015-04-02");
//        dateColumn.add("2015-04-03");
//        dateColumn.add("2015-04-04");
//        dateColumn.add("2015-04-05");
//        teacher.model.Irts irts = new teacher.model.Irts(new Column("dun", dunColumn), new Column("date", dateColumn));
//        teacher.model.Idevhi idevhi = new teacher.model.Idevhi(new Column("dun", dunColumn), new Column("date", dateColumn));
//        teacher.model.Daalgavar daalgavar = new teacher.model.Daalgavar(new Column("dun", dunColumn), new Column("date", dateColumn));
//        teacher.model.Shalgalt shalgalt = new teacher.model.Shalgalt(new Column("dun", dunColumn), new Column("date", dateColumn));
//        teacher.model.BieDaalt biedaalt = new teacher.model.BieDaalt(new Column("dun", dunColumn), new Column("date", dateColumn));
//        teacher.model.TosolDun tosoldun = new teacher.model.TosolDun(new Column("dun", dunColumn), new Column("date", dateColumn));
//
//        student.add(new StudentGrade("bold", irts, idevhi, daalgavar, shalgalt, biedaalt, tosoldun));
//        student.add(new StudentGrade("bat", irts, idevhi, daalgavar, shalgalt, biedaalt, tosoldun));
//        student.add(new StudentGrade("suh", irts, idevhi, daalgavar, shalgalt, biedaalt, tosoldun));
//        student.add(new StudentGrade("tulga", irts, idevhi, daalgavar, shalgalt, biedaalt, tosoldun));
//        student.add(new StudentGrade("suld", irts, idevhi, daalgavar, shalgalt, biedaalt, tosoldun));
//
//    }
//
//    private void ReadingJisheeMedeelel() {
//        for (StudentGrade stu : student) {
//            System.out.println("Student name: " + stu.getName());
//            teacher.model.Irts irts = stu.getIrts();
//            teacher.model.Idevhi idevhi = stu.getIdevhi();
//            teacher.model.Daalgavar daalgavar = stu.getDaalgavar();
//            teacher.model.Shalgalt shalgalt = stu.getShalgalt();
//            teacher.model.BieDaalt biedaalt = stu.getBiedaalt();
//            teacher.model.TosolDun tosoldun = stu.getTosoldun();
//
//            System.out.println("  Irts" + "\t\t\t" + " Idevhi" + "\t\t\t" + " Daalgavar" + "\t\t\t" + " Shalgalt" + "\t\t" + " BieDaalt" + "\t\t" + " TosolDun");
//            System.out.println("" + irts.getDun().getColumnName() + "\t" + " " + irts.getDate().getColumnName() + "\t" + "\t" + idevhi.getDun().getColumnName() + "\t" + idevhi.getDate().getColumnName() + "\t\t" + daalgavar.getDun().getColumnName() + "\t" + daalgavar.getDate().getColumnName() + "\t\t" + shalgalt.getDun().getColumnName() + "\t" + shalgalt.getDate().getColumnName() + "\t\t" + biedaalt.getDun().getColumnName() + "\t" + biedaalt.getDate().getColumnName() + "\t\t" + tosoldun.getDun().getColumnName() + "\t" + tosoldun.getDate().getColumnName());
//            for (int i = 0; i < idevhi.getDun().getData().size(); i++) {
//                System.out.println(irts.getDun().getData().get(i) + "\t" + irts.getDate().getData().get(i) + "\t" + idevhi.getDun().getData().get(i) + "\t" + idevhi.getDate().getData().get(i) + "\t" + daalgavar.getDun().getData().get(i) + "\t" + daalgavar.getDate().getData().get(i) + "\t" + shalgalt.getDun().getData().get(i) + "\t" + shalgalt.getDate().getData().get(i) + "\t" + biedaalt.getDun().getData().get(i) + "\t" + biedaalt.getDate().getData().get(i) + "\t" + tosoldun.getDun().getData().get(i) + "\t" + tosoldun.getDate().getData().get(i));
//
//            }
//
//        }
//    }

    public static ArrayList getStudentDatas() {
        return student;
    }

}
