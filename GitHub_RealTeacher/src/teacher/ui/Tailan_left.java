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
                int index = tailanCm.getSelectionModel().getSelectedIndex();
                String str = tailanCm.getSelectionModel().getSelectedItem().toString();
                switch (index) {
                    case 0:
                        ArrayList<Columns> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable().getSelectedColumns();

                        for (Columns col : selected) {
                            Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(col);
                        }

                        myStage.close();
                        break;
                    case 1:
                        ArrayList<Columns> selected2 = Launcher.getTAILAN_LEFT_INNER().getCustomTable2().getSelectedColumns();

                        for (Columns col : selected2) {
                            Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(col);
                        }

                        myStage.close();
                        break;
                    case 2:
                        ArrayList<Columns> selected3 = Launcher.getTAILAN_LEFT_INNER().getCustomTable3().getSelectedColumns();

                        for (Columns col : selected3) {
                            Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(col);
                        }

                        myStage.close();
                        break;
                    case 3:
                        ArrayList<Columns> selected4 = Launcher.getTAILAN_LEFT_INNER().getCustomTable4().getSelectedColumns();

                        for (Columns col : selected4) {
                            Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(col);
                        }

                        myStage.close();
                        break;
                    case 4:
                        ArrayList<Columns> selected5 = Launcher.getTAILAN_LEFT_INNER().getCustomTable5().getSelectedColumns();

                        for (Columns col : selected5) {
                            Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(col);
                        }

                        myStage.close();
                        break;
                    case 5:

                        break;
                }

            });

            Button column = new Button("Мөр");
            column.setId("green");
            column.setOnAction(ae -> {

                int index = tailanCm.getSelectionModel().getSelectedIndex();
                String str = tailanCm.getSelectionModel().getSelectedItem().toString();
                switch (index) {
                    case 0:
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

                        break;

                    case 1:
                        ArrayList<ArrayList<Object>> selected2 = Launcher.getTAILAN_LEFT_INNER().getCustomTable2().getSelectedRows();
                        ArrayList<ArrayList<Object>> something2 = new ArrayList<>();
                        for (ArrayList<Object> list : selected2) {
                            ArrayList<Object> some = new ArrayList<>();
                            for (Object obj : list) {
                                CustomTable.CustomTableCell cell = (CustomTable.CustomTableCell) obj;
                                some.add(cell.getCellValue());
                            }
                            something2.add(some);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().addRows(something2);
                        myStage.close();

                        break;

                    case 2:
                        ArrayList<ArrayList<Object>> selected3 = Launcher.getTAILAN_LEFT_INNER().getCustomTable3().getSelectedRows();
                        ArrayList<ArrayList<Object>> something3 = new ArrayList<>();
                        for (ArrayList<Object> list : selected3) {
                            ArrayList<Object> some = new ArrayList<>();
                            for (Object obj : list) {
                                CustomTable.CustomTableCell cell = (CustomTable.CustomTableCell) obj;
                                some.add(cell.getCellValue());
                            }
                            something3.add(some);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().addRows(something3);
                        myStage.close();

                        break;
                    case 3:
                          ArrayList<ArrayList<Object>> selected4 = Launcher.getTAILAN_LEFT_INNER().getCustomTable4().getSelectedRows();
                        ArrayList<ArrayList<Object>> something4 = new ArrayList<>();
                        for (ArrayList<Object> list : selected4) {
                            ArrayList<Object> some = new ArrayList<>();
                            for (Object obj : list) {
                                CustomTable.CustomTableCell cell = (CustomTable.CustomTableCell) obj;
                                some.add(cell.getCellValue());
                            }
                            something4.add(some);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().addRows(something4);
                        myStage.close();
                        break;
                    case 4:
                          ArrayList<ArrayList<Object>> selected5 = Launcher.getTAILAN_LEFT_INNER().getCustomTable5().getSelectedRows();
                        ArrayList<ArrayList<Object>> something5 = new ArrayList<>();
                        for (ArrayList<Object> list : selected5) {
                            ArrayList<Object> some = new ArrayList<>();
                            for (Object obj : list) {
                                CustomTable.CustomTableCell cell = (CustomTable.CustomTableCell) obj;
                                some.add(cell.getCellValue());
                            }
                            something5.add(some);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().addRows(something5);
                        myStage.close();
                        break;

                    case 5:

                        break;
                }
            });
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
        tailanCm.setValue("Оюутны Мэдээллээр");
        tailanCm.getItems().addAll("Оюутны Мэдээллээр", "Ирцийн дүнгээр", "Идэвхийн дүнгээр", "Даалгаврийн дүнгээр", "Шалгалтийн дүнгээр");
        tailanCm.setOnAction((event) -> {
            int index = tailanCm.getSelectionModel().getSelectedIndex();
            String str = tailanCm.getSelectionModel().getSelectedItem().toString();
            switch (index) {
                case 0:
                    if (Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().size() > 0) {
                        Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().remove(0);
                    }
                    Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().add(Launcher.getTAILAN_LEFT_INNER().customTable());
                    break;
                case 1:
                    if (Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().size() > 0) {
                        Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().remove(0);
                    }
                    Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().add(Launcher.getTAILAN_LEFT_INNER().customTable2());
                    break;
                case 2:
                    if (Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().size() > 0) {
                        Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().remove(0);
                    }
                    Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().add(Launcher.getTAILAN_LEFT_INNER().customTable3());
                    break;
                case 3:
                    if (Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().size() > 0) {
                        Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().remove(0);
                    }
                    Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().add(Launcher.getTAILAN_LEFT_INNER().customTable4());
                    break;
                case 4:

                    if (Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().size() > 0) {
                        Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().remove(0);
                    }
                    Launcher.getTAILAN_LEFT_INNER().inner_.getChildren().add(Launcher.getTAILAN_LEFT_INNER().customTable5());

                    break;
                case 5:

                    break;
            }
        });

        Button btn = new Button("Нэмэх");
        btn.setPrefSize(100, 20);
        btn.setId("green");

        btn.setOnAction(ae -> {

            int index = tailanCm.getSelectionModel().getSelectedIndex();
            String str = tailanCm.getSelectionModel().getSelectedItem().toString();
            switch (index) {
                case 0:
                    if (Launcher.getTAILAN_LEFT_INNER().getCustomTable().isColumnSelected() && Launcher.getTAILAN_LEFT_INNER().getCustomTable().isRowSelected()) {
                        Stage myStage = new Stage();
                        Popupwindow asd = new Popupwindow();
                        asd.start(myStage);

                    } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable().isColumnSelected()) {
                        ArrayList<Columns> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable().getSelectedColumns();
                        ArrayList<Columns> cols = Launcher.getTAILAN_MEDEELEL().getTailanTable().getColumns();
                        for (Columns col : selected) {
                            cols.add(col);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().clearTable();
                        Columns[] cols1 = new Columns[cols.size()];
                        for (int i = 0; i < cols.size(); i++) {
                            cols1[i] = cols.get(i);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(cols1);
                    } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable().isRowSelected()) {

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

                    }
                    break;
                case 1:
                    if (Launcher.getTAILAN_LEFT_INNER().getCustomTable2().isColumnSelected() && Launcher.getTAILAN_LEFT_INNER().getCustomTable2().isRowSelected()) {
                        Stage myStage = new Stage();
                        Popupwindow asd = new Popupwindow();
                        asd.start(myStage);

                    } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable2().isColumnSelected()) {
                        ArrayList<Columns> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable2().getSelectedColumns();
                        ArrayList<Columns> cols = Launcher.getTAILAN_MEDEELEL().getTailanTable().getColumns();
                        for (Columns col : selected) {
                            cols.add(col);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().clearTable();
                        Columns[] cols2 = new Columns[cols.size()];
                        for (int i = 0; i < cols.size(); i++) {
                            cols2[i] = cols.get(i);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(cols2);
                    } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable2().isRowSelected()) {

                        ArrayList<ArrayList<Object>> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable2().getSelectedRows();
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

                    }
                    break;
                case 2:
                    if (Launcher.getTAILAN_LEFT_INNER().getCustomTable3().isColumnSelected() && Launcher.getTAILAN_LEFT_INNER().getCustomTable3().isRowSelected()) {
                        Stage myStage = new Stage();
                        Popupwindow asd = new Popupwindow();
                        asd.start(myStage);

                    } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable3().isColumnSelected()) {
                        ArrayList<Columns> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable3().getSelectedColumns();
                        ArrayList<Columns> cols = Launcher.getTAILAN_MEDEELEL().getTailanTable().getColumns();
                        for (Columns col : selected) {
                            cols.add(col);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().clearTable();
                        Columns[] cols3 = new Columns[cols.size()];
                        for (int i = 0; i < cols.size(); i++) {
                            cols3[i] = cols.get(i);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(cols3);
                    } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable3().isRowSelected()) {

                        ArrayList<ArrayList<Object>> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable3().getSelectedRows();
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

                    }
                    break;
                case 3:
                    if (Launcher.getTAILAN_LEFT_INNER().getCustomTable4().isColumnSelected() && Launcher.getTAILAN_LEFT_INNER().getCustomTable4().isRowSelected()) {
                        Stage myStage = new Stage();
                        Popupwindow asd = new Popupwindow();
                        asd.start(myStage);

                    } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable4().isColumnSelected()) {
                        ArrayList<Columns> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable4().getSelectedColumns();
                        ArrayList<Columns> cols = Launcher.getTAILAN_MEDEELEL().getTailanTable().getColumns();
                        for (Columns col : selected) {
                            cols.add(col);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().clearTable();
                        Columns[] cols4 = new Columns[cols.size()];
                        for (int i = 0; i < cols.size(); i++) {
                            cols4[i] = cols.get(i);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().clearTable();
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(cols4);
                    } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable4().isRowSelected()) {

                        ArrayList<ArrayList<Object>> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable4().getSelectedRows();
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

                    }
                    break;
                case 4:
                          if (Launcher.getTAILAN_LEFT_INNER().getCustomTable5().isColumnSelected() && Launcher.getTAILAN_LEFT_INNER().getCustomTable5().isRowSelected()) {
                        Stage myStage = new Stage();
                        Popupwindow asd = new Popupwindow();
                        asd.start(myStage);

                    } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable5().isColumnSelected()) {
                        ArrayList<Columns> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable5().getSelectedColumns();
                        ArrayList<Columns> cols = Launcher.getTAILAN_MEDEELEL().getTailanTable().getColumns();
                        for (Columns col : selected) {
                            cols.add(col);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().clearTable();
                        Columns[] cols5 = new Columns[cols.size()];
                        for (int i = 0; i < cols.size(); i++) {
                            cols5[i] = cols.get(i);
                        }
                        Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(cols5);
                    } else if (Launcher.getTAILAN_LEFT_INNER().getCustomTable5().isRowSelected()) {

                        ArrayList<ArrayList<Object>> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable5().getSelectedRows();
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

                    }
                    break;
                case 5:

                    break;
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

    public static ArrayList getStudentDatas() {
        return student;
    }

}
