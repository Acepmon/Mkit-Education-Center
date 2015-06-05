package teacher.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class Medeelel {
    
    private BorderPane centerFp;
    
    public Medeelel(){
        
        centerFp = new BorderPane();
        centerFp.setPrefSize(528, 708);
        centerFp.setStyle("-fx-background-color: white");
        
        //centerFp.setAlignment(Pos.CENTER);
        //////title 
        Label nameLbl = new Label("Мэдээлэл");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(535, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setId("text");
        
        ///////////////////////////////////////
        FlowPane newsFp = new FlowPane(0,15);
        
        newsFp.setAlignment(Pos.TOP_CENTER);
        newsFp.setPadding(new Insets(20, 0, 0, 0));
        FlowPane medeelelFp = new FlowPane(0,10);
        Label garchiLb = new Label("Баасан гаригийн орой 5н цагт хуралтай");
        garchiLb.setFont(javafx.scene.text.Font.font("Arial", 20));
        Label MedeeLb = new Label("5 дугаар сарын 30ны баасан гаригт шинэ оюутан"
                + "элсүүлэх тухай хуралтай тул 205 \nөрөөнд 18 цагт цугална уу.");
        MedeeLb.setPrefSize(480, 35);
        Label dateLb = new Label("2015-05-20");
        dateLb.setFont(javafx.scene.text.Font.font("Arial", 10));
        
        medeelelFp.getChildren().addAll(garchiLb, MedeeLb,dateLb);
        medeelelFp.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        medeelelFp.setPrefSize(500, 100);
        medeelelFp.setId("panel_header_left_right");
        centerFp.setId("border");
       
        
        FlowPane medeelelFp1 = new FlowPane(0,10);
        Label garchiLb1 = new Label("Баасан гаригийн орой 5н цагт хуралтай");
        garchiLb1.setFont(javafx.scene.text.Font.font("Arial", 20));
        Label MedeeLb1 = new Label("5 дугаар сарын 30ны баасан гаригт шинэ оюутан"
                + "элсүүлэх тухай хуралтай тул 205 \nөрөөнд 18 цагт цугална уу.");
        MedeeLb1.setPrefSize(480, 35);
        Label dateLb1 = new Label("2015-05-20");
        dateLb1.setFont(javafx.scene.text.Font.font("Arial", 10));
        
        medeelelFp1.getChildren().addAll(garchiLb1, MedeeLb1,dateLb1);
        medeelelFp1.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        medeelelFp1.setPrefSize(500, 100);
        
        
        FlowPane medeelelFp2 = new FlowPane(0,10);
        Label garchiLb2 = new Label("Баасан гаригийн орой 5н цагт хуралтай");
        garchiLb2.setFont(javafx.scene.text.Font.font("Arial", 20));
        Label MedeeLb2 = new Label("5 дугаар сарын 30ны баасан гаригт шинэ оюутан"
                + "элсүүлэх тухай хуралтай тул 205 \nөрөөнд 18 цагт цугална уу.");
        MedeeLb2.setPrefSize(480, 35);
        Label dateLb2 = new Label("2015-05-20");
        dateLb2.setFont(javafx.scene.text.Font.font("Arial", 10));
        
        medeelelFp1.getChildren().addAll(garchiLb2, MedeeLb2,dateLb2);
        medeelelFp1.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        medeelelFp1.setPrefSize(500, 100);
        medeelelFp1.setId("panel_header_left_right");
        
        
        
        
        
        medeelelFp2.getChildren().addAll(garchiLb1, MedeeLb1,dateLb1);
        medeelelFp2.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        medeelelFp2.setPrefSize(500, 100);
        medeelelFp2.setId("panel_header_left_right");
        
        
        
        
        
        
        
        newsFp.getChildren().addAll(medeelelFp, medeelelFp1, medeelelFp2);
        centerFp.setTop(nameLbl);
        centerFp.setCenter(newsFp);
        
        /////////////////////////////////
    }
    public BorderPane getContainer() {
        return this.centerFp;
    }
}
