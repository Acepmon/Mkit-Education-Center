package StudentUI;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainFrame {
private Scene myScene;
    public static Pane panel1;
public MainFrame(Stage myStage) {
        myStage.setTitle("Logged in as Student");
        BorderPane rootNode = new BorderPane();
        myScene = new Scene(rootNode, 1366, 768);      //this is a frame size
        rootNode.setStyle("-fx-background-color: #FAFAFA");
        rootNode.setAlignment(rootNode, Pos.TOP_CENTER);
        myStage.setResizable(false); // Disabling resize for frame
        //Settings for top of the border pane
        panel1 = new Pane();
        panel1.setPrefSize(1366, 80);
        panel1.setStyle("-fx-background-color:#009688; -fx-effect: dropshadow(three-pass-box, black, 15,0, 0, 0);");
        //  
        Image logo = new Image("logo.png");                          //inserting png logo
        ImageView Logo = new ImageView(logo);
        Logo.setFitHeight(75);                                                //logo height size
        Logo.setFitWidth(230);                                              //logo width size
        Logo.setLayoutX(10);
        //logo spacing from border
        Logo.setOnMousePressed(ae -> {
            Logo.setEffect(null);
            rootNode.setCenter(new HomePage().getHomePagePane());

        });
        Logo.setOnMouseReleased(ae -> {

        });
        Logo.setOnMouseMoved(ae -> {                                  //Setting glow effect on mouseover
            myScene.setCursor(Cursor.HAND);
            final Effect glow = new Glow(2.6);
            Logo.setEffect(glow);
        });
        Logo.setOnMouseExited(ae -> {
            myScene.setCursor(Cursor.DEFAULT);
            Logo.setEffect(null);
        });

        Label gradelbl = new Label("Дүнгийн жагсаалт");
        gradelbl.setPrefSize(250, 20);
        gradelbl.setPrefHeight(80);
        gradelbl.setLayoutX(800);
        gradelbl.setTextFill(Color.web("#FAFAFA"));                           //setting label color 
        gradelbl.setFont(Font.font("Roboto", 20));
        gradelbl.setOnMousePressed(ae -> {
            rootNode.setCenter(null);
            rootNode.setCenter(new Grade().getGradePane());
            gradelbl.setTextFill(Color.web("#757575"));
        });
        gradelbl.setOnMouseReleased(ae -> {
            gradelbl.setTextFill(Color.web("#FAFAFA"));
        });//setting label font and size

        gradelbl.setOnMouseEntered(ae -> {                                                 //Setting glow effect on mouseover
            myScene.setCursor(Cursor.HAND);
            final Effect glow = new Glow(2.6);
            gradelbl.setEffect(glow);
        });
        gradelbl.setOnMouseExited(ae -> {
            myScene.setCursor(Cursor.DEFAULT);
            gradelbl.setEffect(null);
        });

        Label homeworkbl = new Label("Файл илгээх");
        homeworkbl.setPrefSize(250, 20);
        homeworkbl.setPrefHeight(80);
        homeworkbl.setLayoutX(1000);
        homeworkbl.setTextFill(Color.web("#FAFAFA"));
        homeworkbl.setFont(Font.font("Roboto", 20));
        homeworkbl.setOnMousePressed(ae -> {
            rootNode.setCenter(null);
            rootNode.setCenter(new Homework().getHomeworkGridPane());
            homeworkbl.setTextFill(Color.web("#757575"));
        });
        homeworkbl.setOnMouseReleased(ae -> {
            homeworkbl.setTextFill(Color.web("#FAFAFA"));
        });

        homeworkbl.setOnMouseEntered(ae -> {
            myScene.setCursor(Cursor.HAND);
            final Effect glow = new Glow(2.6);
            homeworkbl.setEffect(glow);
        });
        homeworkbl.setOnMouseExited(ae -> {
            myScene.setCursor(Cursor.DEFAULT);
            homeworkbl.setEffect(null);
        });

        Label examlbl = new Label("Шалгалт");
        examlbl.setPrefSize(250, 20);
        examlbl.setPrefHeight(80);
        examlbl.setLayoutX(1140);
        examlbl.setTextFill(Color.web("#FAFAFA"));
        examlbl.setFont(Font.font("Roboto", 20));
        examlbl.setOnMousePressed(ae -> {
            examlbl.setTextFill(Color.web("#757575"));
            rootNode.setCenter(null);
            rootNode.setCenter(new Exam().getExamGridPane());

        });
        examlbl.setOnMouseReleased(ae -> {
            examlbl.setTextFill(Color.web("#FAFAFA"));
        });

        examlbl.setOnMouseEntered(ae -> {
            myScene.setCursor(Cursor.HAND);
            final Effect glow = new Glow(2.6);
            examlbl.setEffect(glow);
        });
        examlbl.setOnMouseExited(ae -> {
            myScene.setCursor(Cursor.DEFAULT);
            examlbl.setEffect(null);
        });

        Label exitlbl = new Label("Гарах");
        exitlbl.setPrefSize(250, 20);
        exitlbl.setPrefHeight(80);
        exitlbl.setLayoutX(1250);
        exitlbl.setTextFill(Color.web("#FAFAFA"));
        exitlbl.setFont(Font.font("Roboto", 20));
        exitlbl.setOnMousePressed(ae -> {
            myStage.close();
        });

        exitlbl.setOnMouseEntered(ae -> {
            myScene.setCursor(Cursor.HAND);
            final Effect glow = new Glow(2.6);
            exitlbl.setEffect(glow);
        });
        exitlbl.setOnMouseExited(ae -> {
            myScene.setCursor(Cursor.DEFAULT);
            exitlbl.setEffect(null);
        });

        panel1.getChildren().addAll(Logo, gradelbl, homeworkbl, examlbl, exitlbl); // Getting Items for Panel
        rootNode.setCenter(null);
        rootNode.setCenter(new HomePage().getHomePagePane());
        myStage.setScene(myScene);
        rootNode.setTop(panel1); // Setting top of the borderpane by panel1
        rootNode.getChildren().addAll();
        myStage.show();
    }
public Scene getScene() {
    return this.myScene;
}
}
