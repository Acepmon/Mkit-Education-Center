package student.ui;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Grade {

    private ObservableList<ObservableList> data;
    private TableView table = new TableView();
    private TableView Cchagt = new TableView();
    private FlowPane gradepane;

    public Grade() {
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
        TableColumn name = new TableColumn("Нэр");
        name.setPrefWidth(120);
        TableColumn month = new TableColumn("Өмнөх сарын үзүүлэлт");
        month.setPrefWidth(160);
        TableColumn rank = new TableColumn("Байр эзлүүлэлт");
        rank.setPrefWidth(160);


        table.getColumns().addAll(ovog, name, month, rank);
        table.setEditable(false);

        Label empty1 = new Label("");
        empty1.setPrefSize(100, 500);

        TableColumn covog = new TableColumn("Овог");
        covog.setPrefWidth(120);
        TableColumn cname = new TableColumn("Нэр");
        cname.setPrefWidth(120);
        TableColumn cmonth = new TableColumn("Өмнөх сарын үзүүлэлт");
        cmonth.setPrefWidth(160);
        TableColumn crank = new TableColumn("Байр эзлүүлэлт");
        crank.setPrefWidth(160);
        

        Cchagt.getColumns().addAll(covog, cname, cmonth, crank);
        Cchagt.setEditable(false);

        gradepane.getChildren().addAll(homelbl, empty, emptyjava, Javalbl, cempty, Clbl, emptyspace, table, empty1, Cchagt);
    }

    public Pane getGradePane() {
        return this.gradepane;
    }
}
