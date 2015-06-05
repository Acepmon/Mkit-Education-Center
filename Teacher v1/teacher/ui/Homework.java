package teacher.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import teacher.launch.Launcher;

public class Homework {
    
    private FlowPane rightFp;
    
    public Homework(){
        
        rightFp = new FlowPane(20,20);
        rightFp.setPrefSize(250, 708);
        rightFp.setStyle("-fx-background-color: #F6F6F7");
        rightFp.setAlignment(Pos.CENTER);
         
        Label nameLbl = new Label("Ирсэн даалгавар");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(250, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setId("text");
  
        FlowPane textFp = new FlowPane(10,5);
        textFp.setPrefSize(200, 150);
        
        
        Label irtsLb = new Label("Даалгавар шалгах");
        irtsLb.setPrefSize(200, 20);
        irtsLb.setAlignment(Pos.CENTER);
        irtsLb.setId("btns");
        irtsLb.setOnMousePressed(ae -> {
            TeacherMain.changeLeft(null);
            TeacherMain.changeRight(null);
            TeacherMain.changeLeft(Launcher.getHOMEWORK().getContainer());
            TeacherMain.changeCenter(Launcher.getCENTER().getContainer());
        });
        
        Label dunLb = new Label("Даалгавар илгээх");
        dunLb.setPrefSize(200, 20);
        dunLb.setAlignment(Pos.CENTER);
        dunLb.setId("btns");
        dunLb.setOnMousePressed(ae -> {
            TeacherMain.changeLeft(Launcher.getHUVAARI().getContainer());
            TeacherMain.changeCenter(Launcher.getDAALGAVARSEND().getContainer());
            TeacherMain.changeRight(Launcher.getHOMEWORK().getContainer());
        });
        
        rightFp.setId("border");
        textFp.getChildren().addAll(irtsLb,dunLb);
        rightFp.getChildren().addAll(nameLbl, new Inner_homework().getContainer(), textFp);
    }
    public FlowPane getContainer() {
        return this.rightFp;
    }
}