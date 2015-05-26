package teacher.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import teacher.launch.Launcher;

public class Homework {

    private FlowPane leftFp;
    private ScrollPane scp;

    public Homework() {

        leftFp = new FlowPane(20, 20);
        leftFp.setPrefSize(250, 708);
        leftFp.setStyle("-fx-background-color: #E6E6E6");
        leftFp.setAlignment(Pos.CENTER);

        Label nameLbl = new Label("Ирсэн Даалгаврууд");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(250, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");

        FlowPane homeworkFp = new FlowPane();

        homeworkFp.setPrefSize(220, 500);
        Label lbl = new Label("Зураг Зурдаг Программ");
        lbl.setFont(new Font("Arial", 13));
        lbl.setPadding(new Insets(20, 20, 0, 40));
        lbl.setOnMouseExited(ae -> {
            leftFp.setCursor(Cursor.DEFAULT);
            lbl.setStyle("-fx-text-fill:black;");
        });
        lbl.setOnMouseMoved(ae -> {
            lbl.setStyle("-fx-text-fill:Green;");
            leftFp.setCursor(Cursor.HAND);
        });

        Label lbl1 = new Label("Машин Бүртэглийн Программ");
        lbl1.setFont(new Font("Arial", 13));
        lbl1.setPadding(new Insets(20, 20, 0, 20));
        lbl1.setOnMouseExited(ae -> {
            leftFp.setCursor(Cursor.DEFAULT);
            lbl1.setStyle("-fx-text-fill:black;");
        });
        lbl1.setOnMouseMoved(ae -> {
            lbl1.setStyle("-fx-text-fill:Green;");
            leftFp.setCursor(Cursor.HAND);
        });

        Label lbl2 = new Label("Фитнэс Бүртэглийн Программ");
        lbl2.setFont(new Font("Arial", 13));
        lbl2.setPadding(new Insets(20, 20, 0, 20));
        lbl2.setOnMouseExited(ae -> {
            leftFp.setCursor(Cursor.DEFAULT);
            lbl2.setStyle("-fx-text-fill:black;");
        });
        lbl2.setOnMouseMoved(ae -> {
            lbl2.setStyle("-fx-text-fill:Green;");
            leftFp.setCursor(Cursor.HAND);
        });
        homeworkFp.getChildren().addAll(lbl, lbl1, lbl2);
        homeworkFp.setId("panel");

        FlowPane textFp = new FlowPane(5, 5);
        textFp.setPrefSize(200, 150);
        Label irtsLb = new Label("Даалгавар Илгээх");
        irtsLb.setPrefSize(200, 20);
        irtsLb.setAlignment(Pos.CENTER);
        irtsLb.setOnMouseExited(ae -> {
            leftFp.setCursor(Cursor.DEFAULT);
            irtsLb.setStyle("-fx-text-fill:black;");
        });
        irtsLb.setOnMouseMoved(ae -> {
            irtsLb.setStyle("-fx-text-fill:Green;");
            leftFp.setCursor(Cursor.HAND);
        });
        Label dunLb = new Label("Даалгавар Шалгах");
        dunLb.setPrefSize(200, 20);
        dunLb.setAlignment(Pos.CENTER);
        dunLb.setOnMouseExited(ae -> {
            leftFp.setCursor(Cursor.DEFAULT);
            dunLb.setStyle("-fx-text-fill:black;");
        });
        dunLb.setOnMouseMoved(ae -> {
            dunLb.setStyle("-fx-text-fill:Green;");
            leftFp.setCursor(Cursor.HAND);
        });
        dunLb.setOnMousePressed(ae -> {
            TeacherMain.changeCenter(Launcher.getCENTER().getContainer());
            TeacherMain.changeRight(Launcher.getTREE().getContainer());
            TeacherMain.changeLeft(Launcher.getHUVAARI().getContainer());
        });
        Label idevhLb = new Label("Бүх Даалгавар Харах");
        idevhLb.setPrefSize(200, 20);
        idevhLb.setAlignment(Pos.CENTER);
        idevhLb.setOnMouseExited(ae -> {
            leftFp.setCursor(Cursor.DEFAULT);
            idevhLb.setStyle("-fx-text-fill:black;");
        });
        idevhLb.setOnMouseMoved(ae -> {
            idevhLb.setStyle("-fx-text-fill:Green;");
            leftFp.setCursor(Cursor.HAND);
        });
        Label allLb = new Label("Даалгаврийн оноо");
        allLb.setPrefSize(200, 20);
        allLb.setAlignment(Pos.CENTER);
        allLb.setOnMouseExited(ae -> {
            leftFp.setCursor(Cursor.DEFAULT);
            allLb.setStyle("-fx-text-fill:black;");
        });
        allLb.setOnMouseMoved(ae -> {
            allLb.setStyle("-fx-text-fill:Green;");
            leftFp.setCursor(Cursor.HAND);
        });

        textFp.getChildren().addAll(irtsLb, dunLb, idevhLb, allLb);
        leftFp.getChildren().addAll(nameLbl, homeworkFp, textFp);

        scp = new ScrollPane(leftFp);
    }

    public ScrollPane getContainer() {
        return this.scp;
    }

}
