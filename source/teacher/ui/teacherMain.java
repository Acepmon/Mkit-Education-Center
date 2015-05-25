package homeworkcheckview;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import teacherMain.homework;


public class teacherMain {
    
    private BorderPane rootNode;
    private Scene scene;
    private TextArea txtarea;
    
    
    public teacherMain(){
        rootNode = new BorderPane();        
        scene = new Scene(rootNode, config.Config.STAGE_WIDTH, config.Config.STAGE_HEIGHT);
        
        ///// menu bar
        
        FlowPane topFp = new FlowPane();
        scene.getStylesheets().add(getClass().getResource("teacherUiStyle.css").toExternalForm());
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
        
        Image logo = new Image("Logo.png");
        ImageView Logo = new ImageView(logo);
        Logo.setFitHeight(60);
        Logo.setFitWidth(200);
        Logo.setLayoutX(10);
        Logo.setEffect(null);
        
        
    
        
        topFp.getChildren().addAll(Logo,mainBtn, hwBtn, examBtn, scoreBtn, tailanBtn);
 
        
       
        

        rootNode.setTop(topFp);
        rootNode.setLeft(new homework().getContainer());
       //rootNode.setRight(new Tree().getContainer());
        rootNode.setCenter(new Center().getContainer());
        
        
    }
    
    public Scene getScene() {
        return this.scene;
    }
    
    
}