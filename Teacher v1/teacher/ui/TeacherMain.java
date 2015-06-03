
package surgaltin.alba;

import java.awt.event.MouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import surgaltiin.alba.irts.irts;

public class teacherMain {
    
    private static BorderPane rootNode;
    private Scene scene;
    
    public static huvaari huvaari = new huvaari();
    public static homework homework = new homework();
    public static medeelel medeelel = new medeelel();
    public static irts irts = new irts();
    public static tailan_left tailan_left = new tailan_left();
    public static Tailan_medeelel Tailan_medeelel = new Tailan_medeelel();
    
    public teacherMain(){
        
        rootNode = new BorderPane();        
        scene = new Scene(rootNode, config.Config.STAGE_WIDTH, config.Config.STAGE_HEIGHT);
        
        ///// menu bar
        
        FlowPane topFp = new FlowPane();
        scene.getStylesheets().add(getClass().getResource("teacherUiStyle.css").toExternalForm());
        topFp.setStyle("-fx-background-color: #B3B3B3");
        topFp.setPrefHeight(60);
        
        
        
        
        ////Дээд талын хэсэг
        Label mainBtn = new Label("Үндсэн");
        mainBtn.setPrefSize(120, 60);
        mainBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        mainBtn.setAlignment(Pos.CENTER);
        mainBtn.setId("btn");
        mainBtn.setOnMousePressed(ae -> {
            teacherMain.changeLeft(huvaari.getContainer());
            teacherMain.changeRight(homework.getContainer());
            teacherMain.changeCenter(medeelel.getContainer());
        });
        
        Label hwBtn = new Label("Даалгавар");
        hwBtn.setPrefSize(120, 60);
        hwBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        hwBtn.setAlignment(Pos.CENTER);
        hwBtn.setId("btn");
        hwBtn.setOnMousePressed(ae -> {
//            teacherMain.changeLeft(huvaari.getContainer());
//            teacherMain.changeRight(homework.getContainer());
//            teacherMain.changeCenter(medeelel.getContainer());
        });
        
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
        
        ////events
        
        tailanBtn.setOnMousePressed(ae -> {
            teacherMain.changeLeft(teacherMain.tailan_left.getContainer());
            teacherMain.changeCenter(teacherMain.Tailan_medeelel.getContainer());
            teacherMain.changeRight(null);
        });
        
        
    
        
        topFp.getChildren().addAll(mainBtn, hwBtn, examBtn, scoreBtn, tailanBtn);
        

        rootNode.setTop(topFp);
        rootNode.setLeft(huvaari.getContainer());
        rootNode.setRight(homework.getContainer());
        rootNode.setCenter(medeelel.getContainer());
    }
    
    public static void changeTop(Node node) {
        teacherMain.rootNode.setTop(node);
    }
    public static void changeBottom(Node node) {
        teacherMain.rootNode.setBottom(node);
    }
    public static void changeCenter(Node node) {
        teacherMain.rootNode.setCenter(node);
    }
    public static void changeLeft(Node node) {
        teacherMain.rootNode.setLeft(node);
    }
    public static void changeRight(Node node) {
        teacherMain.rootNode.setRight(node);
    }
    
    public Scene getScene() {
        return this.scene;
    }
    
    
}
