package teacher.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;

public class Shalgah_left {

    private ScrollPane scroll;

    private FlowPane leftFp;
    private ScrollPane scroll1;
    private FlowPane inner_;

    public Shalgah_left() {

        leftFp = new FlowPane(20, 20);
        leftFp.setMaxSize(250, 708);
        leftFp.setStyle("-fx-background-color: #F6F6F7");
        leftFp.setAlignment(Pos.CENTER);

        Label nameLbl = new Label("Авсан шалгалтууд");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(250, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setId("text");

        FlowPane huvaariFp = new FlowPane();

        Button arrowToLeft = new Button("<");
        arrowToLeft.setPrefSize(30, 30);
        arrowToLeft.setId("green");

        Button arrowToRight = new Button(">");
        arrowToRight.setPrefSize(30, 30);
        arrowToRight.setId("green");

        /////
        inner_ = new FlowPane(10, 10);
        inner_.setPrefSize(220, 500);

        inner_.setId("panel");
        inner_.setAlignment(Pos.TOP_CENTER);
        inner_.setPadding(new Insets(20, 0, 0, 0));

        Label label_one = new Label("Шалгалтын нэр");
        Label label_two = new Label("Шалгалтын нэр");
        Label label_three = new Label("Шалгалтын нэр");
        Label label_four = new Label("Шалгалтын нэр");

        label_one.setId("btns");
        label_two.setId("btns");
        label_three.setId("btns");

        Separator sep_one = new Separator();
        sep_one.setPrefWidth(180);

        Separator sep_two = new Separator();
        sep_two.setPrefWidth(180);

        Separator sep_three = new Separator();
        sep_three.setPrefWidth(180);

        inner_.getChildren().addAll(label_one, sep_one, label_two, sep_two, label_three, sep_three, label_four);
        scroll1 = new ScrollPane(inner_);
        ////

        leftFp.setAlignment(Pos.TOP_CENTER);

        leftFp.getChildren().addAll(nameLbl, scroll1, arrowToLeft, arrowToRight);
        leftFp.setId("border");
    }

    public FlowPane getContainer() {
        return this.leftFp;
    }
}
