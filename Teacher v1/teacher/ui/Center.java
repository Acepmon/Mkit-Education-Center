package teacher.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class Center {

    public static final ObservableList<FlowPane> oyutan = FXCollections.observableArrayList();
    public static final ObservableList<FlowPane> daalgavar = FXCollections.observableArrayList();
    public static final ObservableList<FlowPane> hugatsaa = FXCollections.observableArrayList();
    public static final ObservableList<FlowPane> test = FXCollections.observableArrayList();

    private FlowPane root;

    public Center() {
        ListView listView = new ListView(oyutan);
        listView.setEditable(false);
        listView.setPrefSize(250, 700);
        listView.setId("list-view");

        ListView listView2 = new ListView(daalgavar);
        listView2.setEditable(false);
        listView2.setPrefSize(250, 700);
        listView2.setId("list-view");

        ListView listView3 = new ListView(hugatsaa);
        listView3.setEditable(false);
        listView3.setPrefSize(250, 700);
        listView3.setId("list-view");
        
        FlowPane rows1 = new FlowPane();
        rows1.setPrefSize(30, 30);
        rows1.getChildren().addAll(new Label("НЭРС"));
        rows1.setPrefWidth(50);
        rows1.setAlignment(Pos.CENTER);
        rows1.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 3px");
        oyutan.add(rows1);
        
        FlowPane[] rows = new FlowPane[21];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new FlowPane();
            rows[i].getChildren().add(new Label(""+i+" Оюутан"));
            rows[i].setPrefWidth(50);
            rows[i].setAlignment(Pos.CENTER);
            rows[i].setPadding(new Insets(3, 3, 3, 3));
            rows[i].setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 3px;");
            oyutan.add(rows[i]);
        }
        
        FlowPane spice1 = new FlowPane();
        spice1.setPrefSize(30, 30);
        spice1.getChildren().addAll(new Label("ДААЛГАВАР"));
        spice1.setAlignment(Pos.CENTER);
        spice1.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 3px;");
        daalgavar.add(spice1);
        
        FlowPane[] spice = new FlowPane[21];
        for (int i = 0; i < spice.length; i++) {
            
            ImageView img1 = new ImageView(new Image("teacher/resource/icon.jpg"));
            img1.setFitWidth(15);
            img1.setFitHeight(15);
            
            spice[i] = new FlowPane();
            spice[i].getChildren().addAll(new Label("Тооны машин"), img1);
            spice[i].setPrefWidth(50);
            spice[i].setAlignment(Pos.CENTER);
            spice[i].setPadding(new Insets(3, 3, 3, 3));
            spice[i].setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 3px;");
            daalgavar.add(spice[i]);
        }
        
        FlowPane row1 = new FlowPane();
        row1.setPrefSize(30, 30);
        row1.getChildren().addAll(new Label("ХУГАЦАА"));
        row1.setAlignment(Pos.CENTER);
        row1.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66;");
        hugatsaa.add(row1);
         
        FlowPane[] row = new FlowPane[21];
        for (int i = 0; i < row.length; i++) {
            row[i] = new FlowPane();
            row[i].getChildren().add(new Label("2015-05-15"));
            row[i].setPrefWidth(50);
            row[i].setAlignment(Pos.CENTER);
            row[i].setPadding(new Insets(3, 3, 3, 3));
            row[i].setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 3px;");
            hugatsaa.add(row[i]);
        }
        
  
        root = new FlowPane();
        
        Label gap1 = new Label("");
        gap1.setPrefSize(15, 15);
        
        root.setPadding(new Insets(30, 0, 0, 0));
        root.getChildren().addAll(listView, gap1, listView2, listView3);
        root.setPrefSize(300, 708);
        root.setStyle("-fx-background-color: white;");        
    }

    public FlowPane getContainer() {
        return this.root;
    }
}
