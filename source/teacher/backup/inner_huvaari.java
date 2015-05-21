package surgaltin.alba;

import java.awt.FlowLayout;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;

public class inner_huvaari {

    private ScrollPane scroll;
    private FlowPane inner_;

    public inner_huvaari() {

        inner_ = new FlowPane(10, 10);
        inner_.setPrefSize(220, 500);

        inner_.setId("panel");
        inner_.setAlignment(Pos.TOP_CENTER);
        inner_.setPadding(new Insets(20, 0, 0, 0));

        Label label_one = new Label("10:00-11:20 цагт “Java” Лекц");
        Label label_two = new Label("12:00-17:00 цагт “Java” Ceминар");
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
