package ui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class teacherMain {
    
    private BorderPane rootNode;
    private Scene scene;
    private TextArea txtarea;
    
    
    public teacherMain(){
        Pane root = new Pane();
        rootNode = new BorderPane();        
        scene = new Scene(root, config.Config.STAGE_WIDTH, config.Config.STAGE_HEIGHT);
        
        ///// menu bar
        StackPane main = new StackPane();
        scene.getStylesheets().add(getClass().getResource("teacherUiStyle.css").toExternalForm());
        main.setStyle("-fx-background-color: #666666");
        main.setPrefHeight(60);
        
        
        FlowPane topFp = new FlowPane();
        topFp.setPrefSize(1024, 60);
        
        
        VBox s = new VBox();
        s.setAlignment(Pos.BASELINE_RIGHT);
        s.setPrefSize(120, 150);
        s.setVisible(false);
        s.setLayoutX(config.Config.STAGE_WIDTH-164);
        s.setLayoutY(62);
        s.setStyle("-fx-background-color: blue");
      
        
              
        
        main.getChildren().addAll(topFp);
        
           ////*Top*/////
        Label mainBtn = new Label("Үндсэн");
        mainBtn.setPrefSize(120, 60);
        mainBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        mainBtn.setAlignment(Pos.CENTER);
        mainBtn.setId("btn");
        
        Label hwBtn = new Label("Даалгавар");
        hwBtn.setPrefSize(120, 60);
        hwBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
//        hwBtn.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        hwBtn.setAlignment(Pos.CENTER);
        hwBtn.setId("btn");
        
        
        Label examBtn = new Label("Шалгалт авах");
        examBtn.setPrefSize(120, 90);
        examBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        examBtn.setAlignment(Pos.CENTER);
        examBtn.setId("btn");
        
        Label scoreBtn = new Label("Дүн оруулах");
        scoreBtn.setPrefSize(120, 90);
        scoreBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        scoreBtn.setAlignment(Pos.CENTER);
        scoreBtn.setId("btn");
        
        Label tailanBtn = new Label("Тайлан гаргах");
        tailanBtn.setPrefSize(120, 90);
        tailanBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        tailanBtn.setAlignment(Pos.CENTER);
        tailanBtn.setId("btn");
        
        FlowPane t = new FlowPane();
        t.setPrefSize(120, 90);
        
        
        Label teach = new Label("Багш ");
        teach.setPrefSize(120, 60);
        teach.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        teach.setAlignment(Pos.BASELINE_CENTER);
        teach.setId("btn");
        t.getChildren().add(teach);
        

        t.setPadding(new Insets(0, 0, 0, 260));
        
     

        Label other = new Label(" Бусад");
        other.setPrefSize(120, 60);
        other.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));
        other.setAlignment(Pos.CENTER_LEFT);
        other.setId("btn");
        other.setOnMousePressed(null);
       

        Label profile =new Label(" Мэдээлэл");
        profile.setPrefSize(120, 20);
        profile.setAlignment(Pos.BOTTOM_LEFT);
        profile.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));
        profile.setId("btn");
        profile.setOnMousePressed(null);
        
        Label set = new Label(" Тохиргоо");
        set.setPrefSize(120, 20);
        set.setAlignment(Pos.CENTER_LEFT);
        set.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));
        set.setId("btn");
        set.setOnMousePressed(null);
        
        Label log = new Label(" Гарах");
        log.setPrefSize(120, 20);
        log.setAlignment(Pos.CENTER_LEFT);
        log.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));
        log.setId("btn");
     

                
                     
         
        
        
                
        
        s.getChildren().addAll(other, profile, set, log);

        
        teach.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {  
                if (s.isVisible()) {
                    s.setVisible(false);
                } 
                else { 
                    s.setVisible(true);
                }
            }
        });
      

//        Image logo = new Image("Logo.png");
//        ImageView Logo = new ImageView(logo);
//        Logo.setFitHeight(60);
//        Logo.setFitWidth(200);
//        Logo.setLayoutX(10);
//        Logo.setEffect(null);
              
        
        topFp.getChildren().addAll(mainBtn, hwBtn, examBtn, scoreBtn, tailanBtn, t);
       
        
        
        ////Center////
        
        
        FlowPane centerFp = new FlowPane();
        centerFp.setPrefSize(524, 708);
        Label tessb = new Label("Оюутан 1-ын Гэрийн Даалгавар");
        tessb.setFont(new Font("Arial", 30));
        tessb.setPadding(new Insets(15, 10, 15, 30));
        centerFp.getChildren().add(tessb);
        centerFp.setStyle("-fx-background-color: white");
        txtarea = new TextArea();
        txtarea.setPrefSize(524, 643);
        centerFp.getChildren().add(txtarea);
       
        
  
        rootNode.setTop(main);
        rootNode.setLeft(new homework().getContainer());
        rootNode.setRight(new Tree().getContainer());
        rootNode.setCenter(new FlowPane(centerFp));
        
        root.getChildren().addAll(rootNode, s);
        
        
    }
    
    public Scene getScene() {
        return this.scene;
    }
    
        
}