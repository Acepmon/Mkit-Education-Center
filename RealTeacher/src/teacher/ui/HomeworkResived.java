package teacher.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

public class HomeworkResived {

    public static final ObservableList<FlowPane> oyutan = FXCollections.observableArrayList();
    public static final ObservableList<FlowPane> daalgavar = FXCollections.observableArrayList();
    public static final ObservableList<FlowPane> hugatsaa = FXCollections.observableArrayList();

    private FlowPane root;

    public HomeworkResived() {
        
////////////////////////////ObservableList oruulsan
        
        ObservableList<String> ners = FXCollections.observableArrayList();
        ners.addAll("Ц.Сугар-Од", "Ц.Сугар-Од", "Ц.Сугар-Од", "Ц.Сугар-Од", "Ц.Сугар-Од", "Ц.Сугар-Од", "Ц.Сугар-Од", "Ц.Сугар-Од" );
        
        ObservableList<String> hicheel = FXCollections.observableArrayList();
        hicheel.addAll("Тооны машин", "Тооны машин", "Тооны машин", "Тооны машин", "Тооны машин", "Тооны машин", "Тооны машин", "Тооны машин" );
        
        ObservableList<String> time = FXCollections.observableArrayList();
        time.addAll("2015-03-01", "2015-03-02", "2015-03-03", "2015-03-04", "2015-03-04", "2015-03-05", "2015-03-06", "2015-03-07" );
        
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
        
        FlowPane rows2 = new FlowPane();
        rows2.setPrefSize(30, 30);
        rows2.getChildren().addAll(new Label("ДААЛГАВАР"));
        rows2.setPrefWidth(50);
        rows2.setAlignment(Pos.CENTER);
        rows2.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 3px");
        daalgavar.add(rows2);
        
        FlowPane rows3 = new FlowPane();
        rows3.setPrefSize(30, 30);
        rows3.getChildren().addAll(new Label("ХУГАЦАА"));
        rows3.setPrefWidth(50);
        rows3.setAlignment(Pos.CENTER);
        rows3.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 3px");
        hugatsaa.add(rows3);
        
        for (int i = 0; i < ners.size(); i++) {
            
            FlowPane flowpane = new FlowPane();
            
            Label label = new Label(""+ (i+1) + ". " + ners.get(i));
             
            flowpane.getChildren().addAll(label);
            flowpane.setPrefWidth(40);
            flowpane.setAlignment(Pos.CENTER_LEFT);
            flowpane.setPadding(new Insets(3, 3, 3, 3));
            flowpane.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 0px");
            
            oyutan.add(flowpane);
        }
        
        for (String str : hicheel) {
            FlowPane flowpane = new FlowPane();
            
            Label label = new Label(str);
            
            flowpane.getChildren().addAll(label);
            flowpane.setPrefWidth(40);
            flowpane.setAlignment(Pos.CENTER_LEFT);
            flowpane.setPadding(new Insets(3, 3, 3, 3));
            flowpane.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 0px");
            
            daalgavar.add(flowpane);
        }
        
        for (String str : time) {
            FlowPane flowpane = new FlowPane();
            
            Label label = new Label(str);
            
            flowpane.getChildren().addAll(label);
            flowpane.setPrefWidth(40);
            flowpane.setAlignment(Pos.CENTER_LEFT);
            flowpane.setPadding(new Insets(3, 3, 3, 3));
            flowpane.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 0px");
            
            hugatsaa.add(flowpane);
        }
        
        
        
///////////////////////////ObservableList oruulsan
        

        root = new FlowPane();
        
        Label gap1 = new Label("");
        gap1.setPrefSize(15, 15);
        
        root.setPadding(new Insets(30, 0, 0, 0));
        root.getChildren().addAll(listView, listView2, listView3);
        root.setStyle("-fx-background-color: white;");        
    }

    public FlowPane getContainer() {
        return this.root;
    }
}
