package teacher.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;

public class Ners {
    
    private FlowPane rigthFp, listname;
    private Button send, edit;
    
     public static final ObservableList<FlowPane> outan = FXCollections.observableArrayList();
    
    public Ners() {
        
        rigthFp = new FlowPane();
        rigthFp.setPrefSize(270, 708);
        rigthFp.setHgap(20);
        rigthFp.setAlignment(Pos.TOP_CENTER);
        rigthFp.setPadding(new Insets(10, 10, 10, 10));
        rigthFp.setStyle("-fx-background-color: #A3A9AD");
        rigthFp.setStyle("-fx-focus-color: transparent;");
        rigthFp.setStyle("-fx-background-insets: 0;");
        
        send = new Button("Илгээх");
        send.setPrefSize(80, 20);
        send.setFont(javafx.scene.text.Font.font("Arial", 12));
        send.setId("btns1");
       
        edit = new Button("Засах");
        edit.setPrefSize(80, 20);
        edit.setFont(javafx.scene.text.Font.font("Arial", 12));
        edit.setId("btns1");
        
        listname = new FlowPane();
        listname.setPrefSize(250, 600);
        listname.setId("panel");
        listname.setAlignment(Pos.CENTER);
        listname.setMargin(edit, new Insets(10, 10, 10, 10));
        listname.setStyle("-fx-background-insets: 0;");
        
        ListView listView = new ListView(outan);
        listView.setEditable(false);
        listView.setPrefSize(230, 500);
        listView.setId("list-view");
        
        Label ners = new Label("Нэрс");
        ners.setPrefSize(60, 30);
        ners.setPadding(new Insets(5, 5, 10, 5));
        ners.setStyle("daalgavar_send_label");
        
        FlowPane[] rows = new FlowPane[21];
        for (int i = 1; i < rows.length; i++) {
            rows[i] = new FlowPane();
            rows[i].getChildren().add(new Label(""+i+" Оюутан"));
            rows[i].setPrefWidth(40);
            rows[i].setAlignment(Pos.CENTER);
            rows[i].setPadding(new Insets(3, 3, 3, 3));
            rows[i].setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: E6E6E6; -fx-border-radius: 1px;");
            outan.add(rows[i]);
        }
        
        listname.getChildren().add(ners);
        listname.getChildren().add(listView);
        
       
        rigthFp.getChildren().add(send);
        rigthFp.getChildren().add(edit);
        rigthFp.getChildren().add(listname);
        
    }
    
    public FlowPane getContainer() {
        return this.rigthFp;
    }
    
}
