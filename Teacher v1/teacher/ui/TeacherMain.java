package teacher.ui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import teacher.launch.Launcher;

public class TeacherMain implements teacher.config.Config {
    
    private static BorderPane rootNode;
    private Scene scene;
    private TextArea txtarea;
    
    public TeacherMain(){
        rootNode = new BorderPane();        
        scene = new Scene(rootNode, STAGE_WIDTH, STAGE_HEIGHT);
        
        ///// menu bar
        
        FlowPane topFp = new FlowPane();
        scene.getStylesheets().add("teacher/ui/style/mainStyle.css");
        topFp.setStyle("-fx-background-color: #666666");
        topFp.setPrefHeight(60);
        
        ////*Top*/////
        Label mainBtn = new Label("Үндсэн");
        mainBtn.setPrefSize(120, 60);
        mainBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        mainBtn.setAlignment(Pos.CENTER);
        mainBtn.setId("btn");
        
        Label hwBtn = new Label("Даалгавар");
        hwBtn.setPrefSize(120, 60);
        hwBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        hwBtn.setAlignment(Pos.CENTER);
        hwBtn.setId("btn");
        
        Label examBtn = new Label("Шалгалт авах");
        examBtn.setPrefSize(120, 60);
        examBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        examBtn.setAlignment(Pos.CENTER);
        examBtn.setId("btn");
        
        Label scoreBtn = new Label("Дүн оруулах");
        scoreBtn.setPrefSize(120, 60);
        scoreBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        scoreBtn.setAlignment(Pos.CENTER);
        scoreBtn.setId("btn");
        
        Label tailanBtn = new Label("Тайлан гаргах");
        tailanBtn.setPrefSize(120, 60);
        tailanBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        tailanBtn.setAlignment(Pos.CENTER);
        tailanBtn.setId("btn");
        
        Image logo = new Image("teacher/resource/Logo.png");
        ImageView Logo = new ImageView(logo);
        Logo.setFitHeight(60);
        Logo.setFitWidth(200);
        Logo.setLayoutX(10);
        Logo.setEffect(null);
        
        topFp.getChildren().addAll(Logo,mainBtn, hwBtn, examBtn, scoreBtn, tailanBtn);

        rootNode.setTop(topFp);
        rootNode.setLeft(Launcher.getHOMEWORK().getContainer());
        rootNode.setRight(Launcher.getTREE().getContainer());
        rootNode.setCenter(Launcher.getMEDEELEL().getContainer());
    }
    
    public static void changeTop(Node node) {
        TeacherMain.rootNode.setTop(node);
    }
    public static void changeBottom(Node node) {
        TeacherMain.rootNode.setBottom(node);
    }
    public static void changeCenter(Node node) {
        TeacherMain.rootNode.setCenter(node);
    }
    public static void changeLeft(Node node) {
        TeacherMain.rootNode.setLeft(node);
    }
    public static void changeRight(Node node) {
        TeacherMain.rootNode.setRight(node);
    }
    
    
    public Scene getScene() {
        return this.scene;
    }
    
}