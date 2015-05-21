package surgaltin.alba;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import static surgaltin.alba.teacherMain.homework;
import static surgaltin.alba.teacherMain.huvaari;
import static surgaltin.alba.teacherMain.medeelel;

public class huvaari {
    
    private FlowPane leftFp;
    
    public huvaari(){
        
        leftFp = new FlowPane(20,20);
        leftFp.setPrefSize(250, 708);
        leftFp.setStyle("-fx-background-color: #F6F6F7");
        leftFp.setAlignment(Pos.CENTER);
         
        Label nameLbl = new Label("Хичээлийн хуваарь");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(250, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setId("text");
       
        FlowPane huvaariFp = new FlowPane();
        
        huvaariFp.setPrefSize(220, 500);
        huvaariFp.getChildren().add(new Label("adasd as"));       
        huvaariFp.setId("panel");
                
        FlowPane textFp = new FlowPane(10,5);
        textFp.setPrefSize(200, 150);
       
        
        Label irtsLb = new Label("Ирц бүртгэх");
        irtsLb.setPrefSize(200, 20);
        irtsLb.setId("btns");
        irtsLb.setOnMousePressed(boov -> {
            teacherMain.changeRight(null);
            teacherMain.changeCenter(teacherMain.irts.getContainer());
        });
        
        irtsLb.setAlignment(Pos.CENTER);
        Label dunLb = new Label("Явцын дүн оруулах");
        dunLb.setPrefSize(200, 20);
        dunLb.setId("btns");
        
        dunLb.setAlignment(Pos.CENTER);
        Label idevhLb = new Label("Идэвхийн дүн оруулах");
        idevhLb.setPrefSize(200, 20);
        idevhLb.setId("btns");
        
        idevhLb.setAlignment(Pos.CENTER);
        Label allLb = new Label("Нийт ирц");
        allLb.setPrefSize(200, 20);
        allLb.setAlignment(Pos.CENTER);
        allLb.setId("btns");
        
        ///events
        

        
        
        
        
        
        textFp.getChildren().addAll(irtsLb,dunLb,idevhLb,allLb);
        leftFp.getChildren().addAll(nameLbl, new inner_huvaari().getContainer(), textFp);
        leftFp.setId("border");
    }
    public FlowPane getContainer() {
        return this.leftFp;
    }
}