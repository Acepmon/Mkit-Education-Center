/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author JAVA M2
 */
public class Irts {
    
     private BorderPane irts;
    
    public Irts(){
        irts = new BorderPane();
        irts.setPrefSize(782, 708);
        irts.setStyle("-fx-background-color: #F6F6F7");
//        irts.setAlignment(Pos.CENTER);
        
        BorderPane topBf = new BorderPane();
        topBf.setPrefSize(782, 60);
        topBf.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        Label nameLbl = new Label("Хичээлийн ирц");
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(200, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        
        nameLbl.setId("text");
        
        
        
        FlowPane btnFl = new FlowPane(10,10);
        btnFl.setAlignment(Pos.CENTER);
        btnFl.setPrefSize(240, 60);
        
        Label saveLb = new Label("Хадгалах");
        saveLb.setAlignment(Pos.CENTER);
        saveLb.setPrefSize(100, 30);
        saveLb.setFont(javafx.scene.text.Font.font("Arial", 15));
        saveLb.setStyle("-fx-background-color: #99cc66;-fx-padding: 2px");
        saveLb.setId("btn");
        saveLb.setId("green");
        
        Label editLb = new Label("Засах");
        editLb.setAlignment(Pos.CENTER);
        editLb.setPrefSize(100, 30);
        editLb.setFont(javafx.scene.text.Font.font("Arial", 15));
        editLb.setId("green");
        
       
        btnFl.getChildren().addAll(saveLb, editLb);
        
        topBf.setLeft(nameLbl);
        topBf.setRight(btnFl);
        
        irts.setTop(topBf);
        irts.setId("border");
    }
    
    public BorderPane getContainer() {
        return this.irts;
    }
    
}
