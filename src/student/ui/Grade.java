package student.ui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import student.login.controller.ClientTest;
import student.model.Cdvn;
import student.model.Hicheel;
import student.model.Java;

public class Grade {

    private ObservableList<ObservableList> data;
    private TableView table = new TableView();
    private TableView Cchagt = new TableView();
    private FlowPane gradepane;

    public Grade() {
        
//        ArrayList<String> sp = (ArrayList<String>) ClientTest.RequestAjluulah("getStudentGrade", "student001");
//        System.out.println(sp);
//        sp.add("Java||2||2||22||22||22||22");
//        ObservableList<Object> row1 = FXCollections.observableArrayList();
//        for (int i = 0; i<sp.size(); i++){
//            String[] javalist = sp.get(i).split("\\|\\|");
//            row1.add(new Java(javalist[0], javalist[1], javalist[2], javalist[3]));
//        }
//        
//        ArrayList<String> a = (ArrayList<String>) ClientTest.RequestAjluulah("getStudentGrade", "student001");
////        a.add("Bataa||Boldoo||22||22");
//        ObservableList<Object> row2 = FXCollections.observableArrayList();
//        for(int i = 0; i<a.size(); i++){
//            String[] blist = a.get(i).split("\\|\\|");
//            row2.add(new Cdvn(blist[0], blist[1], blist[2], blist[3]));
//        }
        
        gradepane = new FlowPane();
        gradepane.setAlignment(Pos.TOP_LEFT);
        gradepane.setStyle("-fx-background-color: transparent;");
        gradepane.setPadding(new Insets(30, 20, 10, 50));
        Label homelbl = new Label("Дүнгийн жагсаалт");
        homelbl.setPrefSize(1300, 20);
        homelbl.setLayoutY(25);
        homelbl.setLayoutX(50);
        homelbl.setTextFill(Color.web("#009688"));
        homelbl.setFont(Font.font("Roboto-Regular", FontWeight.BOLD, 30));
        Label empty = new Label("");
        empty.setPrefSize(1300, 30);
        Label emptyjava = new Label("");
        emptyjava.setPrefSize(220, 30);
        Label Javalbl = new Label("JAVA");
        Javalbl.setStyle("-fx-font: 22 roboto; -fx-text-fill : black");
        Javalbl.setPrefSize(350, 30);
        Label cempty = new Label("");
        cempty.setPrefSize(330, 30);
        Label Clbl = new Label("C#");
        Clbl.setStyle("-fx-font: 22 roboto; -fx-text-fill : black");
        Clbl.setPrefSize(350, 30);
        Label emptyspace = new Label("");
        emptyspace.setPrefSize(1300, 20);

        TableColumn ovog = new TableColumn("Овог");
        ovog.setPrefWidth(120);
        ovog.setCellValueFactory(new PropertyValueFactory<>("ovog"));
        TableColumn name = new TableColumn("Нэр");
        name.setPrefWidth(120);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn month = new TableColumn("Өмнөх сарын үзүүлэлт");
        month.setPrefWidth(160);
        month.setCellValueFactory(new PropertyValueFactory<>("uzuulelt"));
        TableColumn rank = new TableColumn("Байр эзлүүлэлт");
        rank.setPrefWidth(160);
        rank.setCellValueFactory(new PropertyValueFactory<>("bair"));


        table.getColumns().addAll(ovog, name, month, rank);
//        table.setItems(row1);
        table.setEditable(false);

        Label empty1 = new Label("");
        empty1.setPrefSize(100, 500);

        TableColumn covog = new TableColumn("Овог");
        covog.setPrefWidth(120);
        covog.setCellValueFactory(new PropertyValueFactory<>("ovog"));
        TableColumn cname = new TableColumn("Нэр");
        cname.setPrefWidth(120);
        cname.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn cmonth = new TableColumn("Өмнөх сарын үзүүлэлт");
        cmonth.setPrefWidth(160);
        cmonth.setCellValueFactory(new PropertyValueFactory<>("uzuulelt"));
        TableColumn crank = new TableColumn("Байр эзлүүлэлт");
        crank.setPrefWidth(160);
        crank.setCellValueFactory(new PropertyValueFactory<>("bair"));
        

        Cchagt.getColumns().addAll(covog, cname, cmonth, crank);
//        Cchagt.setItems(row2);
        Cchagt.setEditable(false);

        gradepane.getChildren().addAll(homelbl, empty, emptyjava, Javalbl, cempty, Clbl, emptyspace, table, empty1, Cchagt);
    }

    public Pane getGradePane() {
        return this.gradepane;
    }
}
