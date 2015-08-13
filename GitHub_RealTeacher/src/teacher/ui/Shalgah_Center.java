package teacher.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class Shalgah_Center {
    
    private BorderPane centerFp;
    
    public Shalgah_Center(){
        
        centerFp = new BorderPane();
        centerFp.setPrefSize(524, 688);
        centerFp.setStyle("-fx-background-color: white");
        
        //centerFp.setAlignment(Pos.CENTER);
        //////title 
        Label nameLbl = new Label("Гарчиг");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(524, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setId("text");
        
        ///////////////////////////////////////
        FlowPane newsFp = new FlowPane(15,15);
        newsFp.setPrefSize(30, 50);
        newsFp.setId("panel");
        
        
        FlowPane btns = new FlowPane(10,20);
        btns.setAlignment(Pos.CENTER);
        Button clearBtn = new Button("Цэвэрлэх");
        clearBtn.setPrefSize(100, 20);
        clearBtn.setId("green");
        
        Button resetBtn = new Button("Цэгцлэх");
        resetBtn.setPrefSize(100, 20);
        resetBtn.setId("green");
        Button saveBtn = new Button("Хадгалах");
        saveBtn.setPrefSize(100, 20);
        saveBtn.setId("green");
        btns.getChildren().addAll(clearBtn,resetBtn,saveBtn);
        btns.setPrefSize(600, 50);
        
        
        
        
        
        
        newsFp.getChildren().addAll();
        centerFp.setTop(nameLbl);
        centerFp.setCenter(newsFp);
        centerFp.setBottom(btns);
        centerFp.setId("border");
        /////////////////////////////////
    }
    public BorderPane getContainer() {
        return this.centerFp;
    }
}
