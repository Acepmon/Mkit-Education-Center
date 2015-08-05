/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import teacher.launch.Launcher;

/**
 *
 * @author JAVA M2
 */
public class Duntoosoolol {

    FlowPane flow;
    Label totaldun, irts, idewhi, shalgalt, daalgawar;
    TextField irtstxf, idewhitxf, shalgalttxf, daalgawartxf;
    Button edit, edit1, edit2, edit3;
    
    public Dunright dunright;

    public Duntoosoolol() {
        dunright = new Dunright();
        flow = new FlowPane(40, 15);
        flow.setPrefSize(512, 708);
        totaldun = new Label("Нэгтгэл дүн");
        totaldun.setPrefSize(512, 40);
        totaldun.setId("-fx-font-size: 15pt;");
        totaldun.setPadding(new Insets(0, 0, 0, 100));

        irts = new Label("Ирц: ");
        irts.setPrefSize(200, 20);
        irts.setPadding(new Insets(0, 0, 0, 50));
        irts.setId("label");
        

        idewhi = new Label("Идэвхи: ");
        idewhi.setPrefSize(200, 20);
        idewhi.setPadding(new Insets(0, 0, 0, 50));
        idewhi.setId("label");

        shalgalt = new Label("Шалгалт: ");
        shalgalt.setPrefSize(200, 20);
        shalgalt.setPadding(new Insets(0, 0, 0, 50));
        shalgalt.setId("label");

        daalgawar = new Label("Даалгавар: ");
        daalgawar.setPrefSize(200, 20);
        daalgawar.setPadding(new Insets(0, 0, 0, 50));
        daalgawar.setId("label");

        irtstxf = new TextField();
        irtstxf.setPrefSize(100, 20);

        idewhitxf = new TextField();
        idewhitxf.setPrefSize(100, 20);

        shalgalttxf = new TextField();
        shalgalttxf.setPrefSize(100, 20);

        daalgawartxf = new TextField();
        daalgawartxf.setPrefSize(100, 20);
        
        edit = new Button("Засах");
        edit.setPrefSize(100, 20);
        edit.setId("green");
        edit.setOnAction(ae->{
            
            start(new Stage());
            
        });
        
        edit1 = new Button("Засах");
        edit1.setPrefSize(100, 20);
        edit1.setId("green");
        edit1.setOnAction(ae->{
        
            start1(new Stage());
        });
        
        edit2 = new Button("Засах");
        edit2.setPrefSize(100, 20);
        edit2.setId("green");
        edit2.setOnAction(ae->{
        
            start2(new Stage());
        });
        
        edit3 = new Button("Засах");
        edit3.setPrefSize(100, 20);
        edit3.setId("green");
        edit3.setOnAction(ae->{
        
            start3(new Stage());
        });

        flow.getChildren().addAll(totaldun, irts, irtstxf, edit, idewhi, idewhitxf, edit1, shalgalt, shalgalttxf, edit2, daalgawar, daalgawartxf, edit3);

    }

    public FlowPane getContainer() {
        return this.flow;
    }
    
    public class Dunright {
        
        private FlowPane flow2;
        
        public Dunright() {
        
        flow2 = new FlowPane(0, 20);
        flow2.setMaxSize(512, 708);
        flow2.setStyle("-fx-background-color: #FFFFFF");
        flow2.setAlignment(Pos.TOP_CENTER);
        
        Label negtgel = new Label("Нэгтгэл дүн");
        negtgel.setPrefSize(250, 30);
        negtgel.setPadding(new Insets(5, 0, 0, 10));
        negtgel.setId("panel_header_left_right");
        negtgel.setStyle("-fx-background-color: #99CC66; -fx-padding: 10px;");
        negtgel.setFont(javafx.scene.text.Font.font("Arial", 12));
        negtgel.setOnMousePressed(ae->{
        
          
            
        });
        
        Label irtsr = new Label("Ирц");
        irtsr.setPrefSize(250, 30);
        irtsr.setPadding(new Insets(5, 0, 0, 10));
        irtsr.setId("panel_header_left_right");
        irtsr.setStyle("-fx-background-color: #99CC66; -fx-padding: 10px;");
        irtsr.setFont(javafx.scene.text.Font.font("Arial", 12));
        irtsr.setOnMousePressed(ae->{
        
            TeacherMain.changeCenter(Launcher.getIDEVHI().getContainer());
            TeacherMain.changeRight(null);
            
        });
        
        Label idewhir = new Label("Идэвхи");
        idewhir.setPrefSize(250, 30);
        idewhir.setPadding(new Insets(5, 0, 0, 10));
        idewhir.setId("panel_header_left_right");
        idewhir.setStyle("-fx-background-color: #99CC66; -fx-padding: 10px;");
        idewhir.setFont(javafx.scene.text.Font.font("Arial", 12));
        idewhir.setOnMousePressed(ae->{
        
            TeacherMain.changeCenter(Launcher.getIDEVHI().getContainer());
            TeacherMain.changeRight(null);
            
        });
        
        Label shalgaltr = new Label("Шалгалт");
        shalgaltr.setPrefSize(250, 30);
        shalgaltr.setPadding(new Insets(5, 0, 0, 10));
        shalgaltr.setId("panel_header_left_right");
        shalgaltr.setStyle("-fx-background-color: #99CC66; -fx-padding: 10px;");
        shalgaltr.setFont(javafx.scene.text.Font.font("Arial", 12));
        shalgaltr.setOnMousePressed(ae->{
        
            
           
        });
        
        Label daalgawarr = new Label("Даалгавар");
        daalgawarr.setPrefSize(250, 30);
        daalgawarr.setPadding(new Insets(5, 0, 0, 10));
        daalgawarr.setId("panel_header_left_right");
        daalgawarr.setStyle("-fx-background-color: #99CC66; -fx-padding: 10px;");
        daalgawarr.setFont(javafx.scene.text.Font.font("Arial", 12));
        daalgawarr.setOnMousePressed(ae->{
        
            
        });
        
        flow2.getChildren().addAll(negtgel, irtsr, idewhir, shalgaltr, daalgawarr);
        }
        
        public FlowPane getContainer() {
            return this.flow2;
        }
    }
    
    
    public void start(Stage yourStage) {

        yourStage.setTitle("Засвар хийх цонх");
        FlowPane rootNode = new FlowPane(10, 20);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 500, 40);
        yourStage.setScene(myScene);
        yourStage.setResizable(false);

        Label irts1 = new Label("Ирц: ");
        irts1.setPadding(new Insets(0, 0, 0, 20));
        irts1.setPrefSize(120, 20);
        
        TextField irts1txf = new TextField();
        irts1txf.setPrefSize(80, 20);
        
        Button save = new Button("Хадгалах");
        save.setId("green");
        save.setPrefSize(100, 20);
        
        Button cancel = new Button("Болих");
        cancel.setId("green");
        cancel.setPrefSize(100, 20);
        
        rootNode.getChildren().addAll(irts1, irts1txf, save, cancel);
        
        yourStage.show();
    }
    
    public void start1 (Stage yourStage) {

        yourStage.setTitle("Засвар хийх цонх");
        FlowPane rootNode = new FlowPane(10, 20);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 500, 40);
        yourStage.setScene(myScene);
        yourStage.setResizable(false);

        Label irts1 = new Label("Ирц: ");
        irts1.setPadding(new Insets(0, 0, 0, 20));
        irts1.setPrefSize(120, 20);
        
        TextField irts1txf = new TextField();
        irts1txf.setPrefSize(80, 20);
        
        Button save = new Button("Хадгалах");
        save.setId("green");
        save.setPrefSize(100, 20);
        
        Button cancel = new Button("Болих");
        cancel.setId("green");
        cancel.setPrefSize(100, 20);
        
        rootNode.getChildren().addAll(irts1, irts1txf, save, cancel);
        
        yourStage.show();
    }
    
    public void start2 (Stage yourStage) {

        yourStage.setTitle("Засвар хийх цонх");
        FlowPane rootNode = new FlowPane(10, 20);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 500, 40);
        yourStage.setScene(myScene);
        yourStage.setResizable(false);

        Label irts1 = new Label("Ирц: ");
        irts1.setPadding(new Insets(0, 0, 0, 20));
        irts1.setPrefSize(120, 20);
        
        TextField irts1txf = new TextField();
        irts1txf.setPrefSize(80, 20);
        
        Button save = new Button("Хадгалах");
        save.setId("green");
        save.setPrefSize(100, 20);
        
        Button cancel = new Button("Болих");
        cancel.setId("green");
        cancel.setPrefSize(100, 20);
        
        rootNode.getChildren().addAll(irts1, irts1txf, save, cancel);
        
        yourStage.show();
    }
    
    public void start3 (Stage yourStage) {
    
        yourStage.setTitle("Засвар хийх цонх");
        FlowPane rootNode = new FlowPane(10, 20);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 500, 40);
        yourStage.setScene(myScene);
        yourStage.setResizable(false);
        
        Label irts1 = new Label("Ирц: ");
        irts1.setPadding(new Insets(0, 0, 0, 20));
        irts1.setPrefSize(120, 20);
            
        TextField irts1txf = new TextField();
        irts1txf.setPrefSize(80, 20);
            
        Button save = new Button("Хадгалах");
        save.setId("green");
        save.setPrefSize(100, 20);
            
        Button cancel = new Button("Болих");
        cancel.setId("green");
        cancel.setPrefSize(100, 20);
            
        rootNode.getChildren().addAll(irts1, irts1txf, save, cancel);
            
        yourStage.show();
    }
    
    
}
    