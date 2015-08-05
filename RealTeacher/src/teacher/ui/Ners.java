package teacher.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;

public class Ners {

    private FlowPane rigthFp, listname;
    private Button send, edit;

    public static final ObservableList<FlowPane> outan = FXCollections.observableArrayList();

    public Ners() {
        
////////////////////////////ObservableList oruulsan
        
        ObservableList<String> responseData = FXCollections.observableArrayList();
        responseData.addAll("bold", "Bat", "Zulaa", "Mongol", "bat", "purew", "ganbold", "ganaa" );
        
        rigthFp = new FlowPane();
        rigthFp.setPrefSize(270, 708);
        rigthFp.setHgap(20);
        rigthFp.setAlignment(Pos.TOP_CENTER);
        rigthFp.setStyle("-fx-background-color: white; -fx-border-color: #B3B3B3; -fx-border-image-width: 2px;");
        rigthFp.setPadding(new Insets(0, 10, 10, 0));
        
        send = new Button("Илгээх");
        send.setPrefSize(80, 20);
        send.setFont(javafx.scene.text.Font.font("Arial", 12));
        send.setId("btns1");

        edit = new Button("Засах");
        edit.setPrefSize(80, 20);
        edit.setFont(javafx.scene.text.Font.font("Arial", 12));
        edit.setId("btns1");

        FlowPane hoyr = new FlowPane(send);
        hoyr.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 5px;");
        hoyr.setPrefSize(300, 60);
        hoyr.setAlignment(Pos.TOP_CENTER);
        hoyr.setId("text");
        
        listname = new FlowPane();
        listname.setPrefSize(250, 600);
        listname.setId("panel");
        listname.setAlignment(Pos.CENTER);
        listname.setMargin(edit, new Insets(10, 10, 10, 10));
        listname.setStyle("-fx-background-insets: 0; -fx-border-style: none; -fx-border-color: transparent; -fx-outline: none;");
        listname.setPadding(new Insets(0, 10, 10, 10));
        
        ListView listView = new ListView(outan);
        listView.setEditable(false);
        listView.setPrefSize(230, 500);

        Label ners = new Label("Нэрс");
        ners.setFont(javafx.scene.text.Font.font("Arial", 14));
        ners.setStyle("-fx-text-fill: black");
        ners.setPrefSize(120, 20);
        ners.setPadding(new Insets(5, 5, 10, 5));
        ners.setAlignment(Pos.CENTER);
        
        for (int i = 0; i < responseData.size(); i++) {
            FlowPane flowpane = new FlowPane();
            
            
            
            CheckBox check = new CheckBox();
            Label label = new Label(""+ (i+1) + ". " + responseData.get(i));
            
            label.setOnMousePressed(ae -> {
                if (check.isSelected()) {
                    check.setSelected(false);
                } else {
                    check.setSelected(true);
                }
            });
            
            flowpane.getChildren().addAll(check, label);
            flowpane.setPrefWidth(40);
            flowpane.setAlignment(Pos.CENTER_LEFT);
            flowpane.setPadding(new Insets(3, 3, 3, 3));
            flowpane.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 0px");
            
            outan.add(flowpane);
        }
        
        Label all = new Label("Бүгдийг идэвхжүүлэх");
        all.setPrefSize(150, 20);

        CheckBox c = new CheckBox();
        c.setOnAction(ae -> {

            for (int i = 0; i < outan.size(); i++) {

                if (c.isSelected()) {
                    ((CheckBox) outan.get(i).getChildren().get(0)).setSelected(true);
                } else {
                    ((CheckBox) outan.get(i).getChildren().get(0)).setSelected(false);
                }
            }

        });

///////////////////////////////ObservableList oruulsan
        
        listname.getChildren().add(ners);
        listname.getChildren().addAll(listView, c, all);

        rigthFp.getChildren().add(hoyr);
        rigthFp.getChildren().add(listname);

    }

    public FlowPane getContainer() {
        return this.rigthFp;
    }

}
