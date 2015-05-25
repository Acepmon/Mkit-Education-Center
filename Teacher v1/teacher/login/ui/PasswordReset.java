package teacher.login.ui;
//Bold-Erdene//

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import javafx.scene.layout.Pane;

public class PasswordReset extends Application {

    @Override
    public void start(Stage myStage) {
        FlowPane rootNode = new FlowPane(20, 20);
        rootNode.setAlignment(Pos.TOP_CENTER);
        rootNode.setPadding(new Insets(10.20));
        Scene myScene = new Scene(rootNode, 400, 250);
        myStage.setScene(myScene);

        /*Та хэрэглэгчийн нэр, E-mail хаягаа оруулна уу гэсэн бичгийг ногоон харуулж буй код*/
        Pane pnl = new Pane();
        pnl.setPrefSize(285, 50);
        pnl.setStyle("-fx-background-color: #99FF99;" + "-fx-border-color: green;");

        /*Гарчиг*/
        Label lbl = new Label("Та хэрэглэгчийн нэр, E-mail хаягаа оруулна уу.");
        lbl.setPrefSize(280, 30);
        lbl.setStyle("-fx-text-fill: green;");
        lbl.setPadding(new Insets(10.20));

        /*Хэрэглэгчийн нэр гэсэн бичгийн код*/
        Label lbl2 = new Label("Хэрэглэгчийн нэр:");
        lbl2.setPrefSize(150, 30);

        /*Хэрэглэгчийн нэрээ бичэх талбарийн код*/
        TextField fld = new TextField();
        fld.setPromptText("Username");
        fld.setPrefSize(150, 30);

        /*Хэрэглэгчийн Email хаягийн код*/
        Label lbl3 = new Label("E-mail хаяг:");
        lbl3.setPrefSize(150, 30);

        /*Хэрэглэгчийн Email хаягаа оруулах талбарийн код*/
        TextField fld2 = new TextField();
        fld2.setPromptText("E-mail");
        fld2.setPrefSize(150, 30);

        /*Нууц үг илгээх button*/
        Button btn = new Button("Нууц үг илгээх");
        btn.setPrefSize(150, 25);
        btn.setStyle("-fx-background-color: white;" + "-fx-border-color:green;");

        pnl.getChildren().addAll(lbl);
        rootNode.getChildren().addAll(pnl, lbl2, fld, lbl3, fld2, btn);
        myStage.show();
    }
}
