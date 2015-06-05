package teacher.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
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
        rigthFp.setStyle("-fx-background-color: #A3A9AD; -fx-border-style: none; -fx-border-color: transparent; -fx-outline: none;");

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
        listname.setStyle("-fx-background-insets: 0; -fx-border-style: none; -fx-border-color: transparent; -fx-outline: none;");

        ListView listView = new ListView(outan);
        listView.setEditable(false);
        listView.setPrefSize(230, 500);

        Label ners = new Label("Нэрс");
        ners.setPrefSize(100, 20);
        ners.setPadding(new Insets(5, 5, 10, 5));
        ners.setAlignment(Pos.CENTER);

        FlowPane[] rows = new FlowPane[21];
        for (int i = 0; i < rows.length; i++) {
            CheckBox cbtn = new CheckBox();

            Label outan1 = new Label((i+1) + " Оюутан ");
            outan1.setOnMousePressed(ae -> {

                if (cbtn.isSelected()) {
                    cbtn.setSelected(false);
                } else {
                    cbtn.setSelected(true);
                }
            });

            rows[i] = new FlowPane();
            rows[i].getChildren().addAll(cbtn, outan1);
            rows[i].setPrefWidth(40);
            rows[i].setAlignment(Pos.CENTER_LEFT);
            rows[i].setPadding(new Insets(3, 3, 3, 3));
            rows[i].setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 0px");

            outan.add(rows[i]);

        }
        Label all = new Label("Бүгдийг идэвхжүүлэх");
        all.setPrefSize(150, 20);

        CheckBox c = new CheckBox();
        c.setOnAction(ae -> {

            for (int i = 0; i < rows.length; i++) {

                if (c.isSelected()) {
                    ((CheckBox) rows[i].getChildren().get(0)).setSelected(true);
                } else {
                    ((CheckBox) rows[i].getChildren().get(0)).setSelected(false);
                }
            }

        });

        listname.getChildren().add(ners);
        listname.getChildren().addAll(listView, c, all);

        rigthFp.getChildren().add(send);
        rigthFp.getChildren().add(edit);
        rigthFp.getChildren().add(listname);

    }

    public FlowPane getContainer() {
        return this.rigthFp;
    }

}
