
package surgaltin.alba;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import static surgaltin.alba.teacherMain.homework;
import static surgaltin.alba.teacherMain.huvaari;
import static surgaltin.alba.teacherMain.medeelel;

public class tailan_left {
    
    private FlowPane leftFp;
    
    public tailan_left(){
        
        leftFp = new FlowPane(20,20);
        leftFp.setPrefSize(250, 708);
        leftFp.setStyle("-fx-background-color: #F6F6F7");
        leftFp.setAlignment(Pos.CENTER);
         
        Label nameLbl = new Label("Тайлан гаргах");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(250, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setId("text");
       
        FlowPane huvaariFp = new FlowPane();
        
        
        
        TextField searchTf = new TextField();
        searchTf.setPrefSize(140, 20);
        
        
        Button searchBtn = new Button("Search");
        searchBtn.setPrefSize(60, 20);
        searchBtn.setId("green");
        
        
        
        FlowPane searchFp = new FlowPane(0,10);
        searchFp.setPrefSize(200, 80);
       
        ComboBox tailanCm = new ComboBox();
        tailanCm.setPrefSize(200, 20);
        tailanCm.getItems().addAll(
            "Ирцээр",
            "Дүнгээр",
            "Явцын дүнгээр",
            "Low",
            "Lowest" 
        );
        ///events
        

        
        
        
        
        leftFp.setAlignment(Pos.TOP_CENTER);
        searchFp.getChildren().addAll(searchTf,searchBtn, tailanCm );
        leftFp.getChildren().addAll(nameLbl, searchFp,new Tailan_left_inner().getContainer());
        leftFp.setId("border");
    }
    public FlowPane getContainer() {
        return this.leftFp;
    }
}