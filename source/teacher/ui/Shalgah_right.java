package teacher.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import teacher.launch.Launcher;

public class Shalgah_right {

    private ScrollPane scroll;
    private FlowPane inner_;

    private FlowPane leftFp;

    public Shalgah_right() {

        leftFp = new FlowPane(20, 20);
        leftFp.setMaxSize(250, 708);
        leftFp.setStyle("-fx-background-color: #F6F6F7");
        leftFp.setAlignment(Pos.CENTER);

        Label nameLbl = new Label("Шалгалт");
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
        

        leftFp.setAlignment(Pos.TOP_CENTER);

        leftFp.getChildren().addAll(nameLbl,Launcher.getSHALGAH_RIGHT_INNER().getContainer(),arrowToLeft,arrowToRight);
        leftFp.setId("border");
    }

    public FlowPane getContainer() {
        return this.leftFp;
    }
}
