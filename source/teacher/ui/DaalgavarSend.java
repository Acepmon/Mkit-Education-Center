package ui;

import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;



public class DaalgavarSend {

    private GridPane pnl;
    private Label daalgavarname, zamzaah, tailbarbichih, svvliint, daalgavaryaw;
    private TextField toonii, zamfld, svvliinfld;
    private TextArea tailbararea;
    private BorderPane rootNode;
    private Button zaah, onsar;

    public DaalgavarSend() {

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
        daalgavaryaw.setFont(new Font("Arial", 30));
        daalgavaryaw.setStyle("-fx-background-color: #54B1EB; -fx-padding: 14px 20px 10px 20px;");
  
        
//        svvliint.setOnMouseEntered(new EventHandler<MouseEvent>() {
//    @Override public void handle(MouseEvent e) {
//        svvliint.setScaleX(1.5);
//        svvliint.setScaleY(1.5);
//    }});
//        svvliint.setOnMouseExited(new EventHandler<MouseEvent>() {
//    @Override public void handle(MouseEvent e) {
//        svvliint.setScaleX(1);
//        svvliint.setScaleY(1);
//    }
//});
        toonii = new TextField();
        toonii.setPromptText("Тооны машин");
        toonii.setId("daalgavar_send_textf");
        toonii.setMaxHeight(20);
        zamfld = new TextField();
        zamfld.setPromptText("E: Lesson01_Test_MKiT");
        zamfld.setId("daalgavar_send_textf");
//        zamfld.setPrefWidth(100);
        tailbararea = new TextArea();
        tailbararea.setPrefHeight(20);
        tailbararea.setPrefWidth(150);
        tailbararea.setId("daalgavar_send_textf");
        svvliinfld = new TextField();
        svvliinfld.setPromptText("---- оны -- сарын -- өдөр дуусна.");
        svvliinfld.setId("daalgavar_send_textf");

        Image img = new Image("ui/true.png", true);
        ImageView image = new ImageView();
        image.setImage(img);
        image.setSmooth(true);
        image.setPreserveRatio(true);
        image.setFitHeight(25);

        HBox pictureRegion = new HBox(image);
        pictureRegion.setId("daalgavar_send_image");

        Image img1 = new Image("ui/true.png", true);
        ImageView image1 = new ImageView();
        image1.setImage(img1);
        image1.setSmooth(true);
        image1.setPreserveRatio(true);
        image1.setFitHeight(25);

        HBox pictureRegion1 = new HBox();
        pictureRegion1.getChildren().add(image1);
        pictureRegion1.setId("daalgavar_send_image");

        Image img2 = new Image("ui/false.png", true);
        ImageView image2 = new ImageView();
        image2.setImage(img2);
        image2.setSmooth(true);
        image2.setPreserveRatio(true);
        image2.setFitHeight(25);

        HBox pictureRegion2 = new HBox();
        pictureRegion2.getChildren().add(image2);
        pictureRegion2.setId("daalgavar_send_image");

        Image img3 = new Image("ui/true.png", true);
        ImageView image3 = new ImageView();
        image3.setImage(img3);
        image3.setSmooth(true);
        image3.setPreserveRatio(true);
        image3.setFitHeight(25);

        HBox pictureRegion3 = new HBox();
        pictureRegion3.getChildren().add(image3);
        pictureRegion3.setId("daalgavar_send_image");
        
        pnl.add(daalgavarname, 0, 0);
        pnl.add(toonii, 0, 1);
        pnl.add(zamzaah, 0, 2);
        pnl.add(zamfld, 0, 3);
        pnl.add(tailbarbichih, 0, 4);
        pnl.add(tailbararea, 0, 5);
        pnl.add(svvliint, 0, 6);
        pnl.add(svvliinfld, 0, 7);
        pnl.add(pictureRegion, 2, 1);
        pnl.add(pictureRegion1, 2, 3);
        pnl.add(pictureRegion2, 2, 5);
        pnl.add(pictureRegion3, 2, 7);

        zaah = new Button("Заах");
        zaah.setPrefSize(60, 20);
        zaah.setStyle("-fx-background-color: #0574B0");

        pnl.add(zaah, 1, 3);
        
        onsar = new Button(null, new ImageView(new Image("ui/qwerty.png", true)));
        onsar.setPrefSize(60, 20);
        onsar.setStyle("-fx-background-color: #0574B0");
        
        pnl.add(onsar, 1, 7);
        
        pnl.setPadding(new Insets(25, 10, 10, 30));

        tailbararea.setWrapText(true);
        
        rootNode.setTop(daalgavaryaw);
        rootNode.setCenter(pnl);
        pnl.setStyle("-fx-background-color: #B8DFF5;");
    }

    public BorderPane getContainer() {
        return this.rootNode;
    }

}
