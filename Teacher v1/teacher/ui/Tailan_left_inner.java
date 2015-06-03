package surgaltin.alba;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;

public class Tailan_left_inner {

    private ScrollPane scroll;
    private FlowPane inner_;

    public Tailan_left_inner() {

        inner_ = new FlowPane(10, 10);
        inner_.setPrefSize(220, 500);

        inner_.setId("panel");
        inner_.setAlignment(Pos.TOP_CENTER);
        inner_.setPadding(new Insets(20, 0, 0, 0));

        Label label_one = new Label("BLANK");
        Label label_two = new Label("BLANK");
        label_one.setId("btns");
        label_two.setId("btns");
        Separator sep_one = new Separator();
        sep_one.setPrefWidth(180);

        Separator sep_two = new Separator();
        sep_two.setPrefWidth(180);

        inner_.getChildren().addAll(label_one, sep_one, label_two, sep_two);
        scroll = new ScrollPane(inner_);
      
    }

    public ScrollPane getContainer() {
        return this.scroll;
    }
}