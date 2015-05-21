package StudentUI;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HomePage {

    private Pane homepagepane;
    private TableView table = new TableView();

    public HomePage() {
        homepagepane = new Pane();
        homepagepane.setStyle("-fx-background-color: transparent;");
        Label lbl1 = new Label("Таны дүн");
        lbl1.setPrefSize(100, 100);
        lbl1.setLayoutX(400);
        lbl1.setLayoutY(15);
        lbl1.setStyle("-fx-font: 22 roboto; -fx-text-fill : black");
        Label homelbl = new Label("Тавтай морил!");
        homelbl.setPrefSize(250, 20);
        homelbl.setPrefHeight(80);
        homelbl.setLayoutY(15);
        homelbl.setLayoutX(50);
        homelbl.setTextFill(Color.web("#009688"));
        homelbl.setFont(Font.font("Roboto-Regular", FontWeight.BOLD, 30));
        //                                                         ICON PHASE STARTS HERE
        Image icon1 = new Image("iconuser.png");                          //inserting jp image just for now
        ImageView iconuserview = new ImageView(icon1);
        iconuserview.setFitHeight(32);                                                //logo height size
        iconuserview.setFitWidth(32);                                              //logo width size
        iconuserview.setLayoutX(30);
        iconuserview.setLayoutY(350);

        Label ovoglbl = new Label("Овог Нэр");
        ovoglbl.setLayoutX(100);
        ovoglbl.setLayoutY(360);

        Image icon2 = new Image("iconcheck.png");
        ImageView iconcheckview = new ImageView(icon2);
        iconcheckview.setFitHeight(32);
        iconcheckview.setFitWidth(32);
        iconcheckview.setLayoutX(30);
        iconcheckview.setLayoutY(400);
        Label dugarlbl = new Label("Оюутны дугаар");
        dugarlbl.setLayoutX(100);
        dugarlbl.setLayoutY(410);

        Image icon3 = new Image("iconphone.png");
        ImageView iconphoneview = new ImageView(icon3);
        iconphoneview.setFitHeight(32);
        iconphoneview.setFitWidth(32);
        iconphoneview.setLayoutX(30);
        iconphoneview.setLayoutY(450);
        Label utaslbl = new Label("Утасны дугаар");
        utaslbl.setLayoutX(100);
        utaslbl.setLayoutY(460);

        Image icon4 = new Image("iconlocation.png");
        ImageView addressview = new ImageView(icon4);
        addressview.setFitHeight(32);
        addressview.setFitWidth(32);
        addressview.setLayoutX(30);
        addressview.setLayoutY(500);
        Label hayglbl = new Label("Гэрийн хаяг");
        hayglbl.setLayoutX(100);
        hayglbl.setLayoutY(510);

        Image icon5 = new Image("iconpc.png");
        ImageView pcview = new ImageView(icon5);
        pcview.setFitHeight(32);
        pcview.setFitWidth(32);
        pcview.setLayoutX(30);
        pcview.setLayoutY(550);
        Label comlbl = new Label("PC-ны дугаар");
        comlbl.setLayoutX(100);
        comlbl.setLayoutY(560);

        Image logo = new Image("iconavatar.png");                          //inserting jp image just for now
        ImageView Logo = new ImageView(logo);
        Logo.setFitHeight(200);                                                //logo height size
        Logo.setFitWidth(230);                                              //logo width size
        Logo.setLayoutX(40);
        Logo.setLayoutY(100);
        Path path = new Path();
        path.getElements().add(new MoveTo(310.0f, 20.0f));
        path.getElements().add(new VLineTo(700.0f));
        path.setStroke(Color.WHITE);
        path.setStrokeWidth(10);
        path.setStyle("-fx-effect: dropshadow(three-pass-box,#BDBDBD, 10,0,7, 10);");

        TableColumn hicheelclmn = new TableColumn("Хичээлийн нэр");
        hicheelclmn.setPrefWidth(130);
        TableColumn irts = new TableColumn("Ирц");
        TableColumn idewxi = new TableColumn("Идэвхи");
        TableColumn biedaalt = new TableColumn("Бие даалт");
        biedaalt.setPrefWidth(100);
        TableColumn daalgawar = new TableColumn("Даалгавар");
        daalgawar.setPrefWidth(100);
        TableColumn shalgalt = new TableColumn("Шалгалт");
        TableColumn total = new TableColumn("Дундаж оноо");
        total.setPrefWidth(120);
        table.getColumns().addAll(hicheelclmn, irts, idewxi, biedaalt, daalgawar, shalgalt, total);
        table.setLayoutX(400);
        table.setLayoutY(100);
        table.setPrefSize(680, 200);
        table.setEditable(false);

        Label huwaari = new Label("Хөтөлбөрийн хуваарь");
        huwaari.setLayoutX(400);
        huwaari.setLayoutY(320);
        huwaari.setStyle("-fx-font: 22 roboto; -fx-text-fill : black");

        Image huwaari1 = new Image("huwaari.png");                          //inserting jp image just for now
        ImageView huwaariview = new ImageView(huwaari1);
        huwaariview.setFitHeight(320);                                                //logo height size
        huwaariview.setFitWidth(700);                                              //logo width size
        huwaariview.setLayoutX(400);
        huwaariview.setLayoutY(360);

        homepagepane.getChildren().addAll(homelbl, Logo, iconuserview, ovoglbl, iconcheckview, dugarlbl, iconphoneview, utaslbl, addressview, hayglbl, pcview, comlbl, lbl1, path, table, huwaari, huwaariview);
        Scene myScene = new Scene(homepagepane, 1366, 688);

    }

    public Pane getHomePagePane() {
        return this.homepagepane;
    }
}
