package teacher.ui;

import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class DaalgavarSend1 {

    private GridPane pnl;
    private Label daalgavarname, zamzaah, tailbarbichih, svvliint, daalgavaryaw;
    private TextField toonii, zamfld, svvliinfld;
    private TextArea tailbararea;
    private BorderPane rootNode;
    private Button zaah, onsar;
    private DatePicker time1;

    public DaalgavarSend1() {

        rootNode = new BorderPane();
        pnl = new GridPane();

        daalgavarname = new Label("Даалгаврын нэр:");
        daalgavarname.setFont(new Font("Arial", 15));
        daalgavarname.setId("daalgavar_send_label");
        zamzaah = new Label("Даалгаврын замыг зааж өгөх:");
        zamzaah.setFont(new Font("Arial", 15));
        zamzaah.setId("daalgavar_send_label");
        tailbarbichih = new Label("Тайлбар бичих:");
        tailbarbichih.setFont(new Font("Arial", 15));
        tailbarbichih.setId("daalgavar_send_label");
        svvliint = new Label("Сүүлийн хугацаа:");
        svvliint.setFont(new Font("Arial", 15));
        svvliint.setId("daalgavar_send_label");
        daalgavaryaw = new Label("Даалгавар явуулах");
        daalgavaryaw.setPrefWidth(525);
        daalgavaryaw.setFont(new Font("Cambria", 30));
        daalgavaryaw.setStyle("-fx-background-color: #A1ABA1; -fx-padding: 14px 20px 14px 0px;");
        daalgavaryaw.setAlignment(Pos.CENTER);

        toonii = new TextField();
        toonii.setPromptText("Тооны машин");
        toonii.setId("daalgavar_send_textf");
        toonii.setMaxHeight(20);
        toonii.setMaxWidth(240);
        toonii.setStyle("-fx-background-insets: 0;");

        zamfld = new TextField();
        zamfld.setPromptText("E: Lesson01_Test_MKiT");
        zamfld.setId("daalgavar_send_textf");
        zamfld.setStyle("-fx-background-insets: 0;");

//        zamfld.setPrefWidth(100);
        tailbararea = new TextArea();
        tailbararea.setPrefHeight(20);
        tailbararea.setId("daalgavar_send_textf");
        tailbararea.setMaxWidth(240);
        tailbararea.setStyle("-fx-background-insets: 0;");
        svvliinfld = new TextField();
        svvliinfld.setPromptText("---- оны -- сарын -- өдөр дуусна.");
        svvliinfld.setId("daalgavar_send_textf");
        svvliinfld.setStyle("-fx-background-insets: 0;");
        
        Image img = new Image("teacher/resource/true.png", true);
        ImageView image = new ImageView();
        image.setImage(img);
        image.setSmooth(true);
        image.setPreserveRatio(true);
        image.setFitHeight(25);

        HBox pictureRegion = new HBox(image);
        pictureRegion.setId("daalgavar_send_image");

        Image img1 = new Image("teacher/resource/true.png", true);
        ImageView image1 = new ImageView();
        image1.setImage(img1);
        image1.setSmooth(true);
        image1.setPreserveRatio(true);
        image1.setFitHeight(25);

        HBox pictureRegion1 = new HBox();
        pictureRegion1.getChildren().add(image1);
        pictureRegion1.setId("daalgavar_send_image");

        Image img2 = new Image("teacher/resource/false.png", true);
        ImageView image2 = new ImageView();
        image2.setImage(img2);
        image2.setSmooth(true);
        image2.setPreserveRatio(true);
        image2.setFitHeight(25);

        HBox pictureRegion2 = new HBox();
        pictureRegion2.getChildren().add(image2);
        pictureRegion2.setId("daalgavar_send_image");

        Image img3 = new Image("teacher/resource/true.png", true);
        ImageView image3 = new ImageView();
        image3.setImage(img3);
        image3.setSmooth(true);
        image3.setPreserveRatio(true);
        image3.setFitHeight(25);
        
        HBox pictureRegion3 = new HBox();
        pictureRegion3.getChildren().add(image3);
        pictureRegion3.setId("daalgavar_send_image");

        time1 = new DatePicker();
        time1.setValue(LocalDate.now());
        
        zaah = new Button("Заах");
        zaah.setPrefSize(80, 20);
        zaah.setId("btns1");

        onsar = new Button("Он сар өдөр");
        onsar.setId("btns1");
        onsar.setOnMousePressed(ae->{
            
            LocalDate date = time1.getValue();
            LocalDate time = time1.getValue();
            Alert time1 = new Alert(Alert.AlertType.INFORMATION);
            time1.setTitle("Он сар өдөр");
            time1.setHeaderText("Улаанбаатар");
            time1.setContentText("Өнөөдөр" +date);
            time1.showAndWait();
            
            
        });

        FlowPane zam = new FlowPane(zamfld, zaah);
        zam.setMaxWidth(250);
        FlowPane onsar1 = new FlowPane(svvliinfld, onsar);
        onsar1.setMaxWidth(250);

        pnl.add(daalgavarname, 0, 0);
        pnl.add(toonii, 0, 1);
        pnl.add(zamzaah, 0, 2);
//        pnl.add(zamfld, 0, 3);
        pnl.add(zam, 0, 3);
        pnl.add(tailbarbichih, 0, 4);
        pnl.add(tailbararea, 0, 5);
        pnl.add(svvliint, 0, 6);
//        pnl.add(svvliinfld, 0, 7);
        pnl.add(onsar1, 0, 7);
        pnl.add(pictureRegion, 2, 1);
        pnl.add(pictureRegion1, 2, 3);
        pnl.add(pictureRegion2, 2, 5);
        pnl.add(pictureRegion3, 2, 7);

//        pnl.add(zaah, 1, 3);
//        pnl.add(onsar, 1, 7);
        pnl.setPadding(new Insets(25, 10, 10, 30));

        tailbararea.setWrapText(true);

        rootNode.setTop(daalgavaryaw);
        rootNode.setCenter(pnl);
        pnl.setStyle("-fx-background-color: #727C82;");
    }

    public BorderPane getContainer() {
        return this.rootNode;
    }

}
