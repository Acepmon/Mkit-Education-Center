/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class Inner_homework {
private ScrollPane scroll;
    private FlowPane inner_;

    public Inner_homework() {

        inner_ = new FlowPane(10, 10);
        inner_.setPrefSize(220, 500);

        inner_.setId("panel");
        inner_.setAlignment(Pos.TOP_CENTER);
        inner_.setPadding(new Insets(10, 0, 0, 0));

        FlowPane oyutan = new FlowPane(10,10);        
        oyutan.setPrefSize(200, 40);
        oyutan.setId("panel_header_left_right");
        FlowPane oyutan1 = new FlowPane(10,10);        
        oyutan1.setPrefSize(200, 40);
        oyutan1.setId("panel_header_left_right");
        FlowPane oyutan2 = new FlowPane(10,10);        
        oyutan2.setPrefSize(200, 40);
        oyutan2.setId("panel_header_left_right");
        FlowPane oyutan3 = new FlowPane(10,10);        
        oyutan3.setPrefSize(200, 40);
        oyutan3.setId("panel_header_left_right");
        FlowPane oyutan4 = new FlowPane(10,10);
        oyutan4.setPrefSize(200, 40);
        oyutan4.setId("panel_header_left_right");
        
        Pane colorPane = new Pane();
        colorPane.setStyle("-fx-background-color: #99CC66; -fx-padding: 10px;");
        colorPane.setPrefSize(35, 35);
        Label nameLbl = new Label("Оюутны нэр");
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 12));
        
        Pane colorPane1 = new Pane();
        colorPane1.setStyle("-fx-background-color: #99CC66; -fx-padding: 10px;");
        colorPane1.setPrefSize(35, 35);
        Label nameLbl1 = new Label("Оюутны нэр");
        nameLbl1.setFont(javafx.scene.text.Font.font("Arial", 12));
        
        Pane colorPane2 = new Pane();
        colorPane2.setStyle("-fx-background-color: #99CC66; -fx-padding: 10px;");
        colorPane2.setPrefSize(35, 35);
        Label nameLbl2 = new Label("Оюутны нэр");
        nameLbl2.setFont(javafx.scene.text.Font.font("Arial", 12));
        
        Pane colorPane3 = new Pane();
        colorPane3.setStyle("-fx-background-color: #99CC66; -fx-padding: 10px;");
        colorPane3.setPrefSize(35, 35);
        Label nameLbl3 = new Label("Оюутны нэр");
        nameLbl3.setFont(javafx.scene.text.Font.font("Arial", 12));
        
        Pane colorPane4 = new Pane();
        colorPane4.setStyle("-fx-background-color: #99CC66; -fx-padding: 10px;");
        colorPane4.setPrefSize(35, 35);
        Label nameLbl4 = new Label("Оюутны нэр");
        nameLbl4.setFont(javafx.scene.text.Font.font("Arial", 12));
            
        oyutan.getChildren().addAll(colorPane,nameLbl);
        oyutan1.getChildren().addAll(colorPane1,nameLbl1);
        oyutan2.getChildren().addAll(colorPane2,nameLbl2);
        oyutan3.getChildren().addAll(colorPane3,nameLbl3);
        oyutan4.getChildren().addAll(colorPane4,nameLbl4);
        
        inner_.getChildren().addAll(oyutan, oyutan1,oyutan2, oyutan3,oyutan4);
        scroll = new ScrollPane(inner_);
    }

    public ScrollPane getContainer() {
        return this.scroll;
    }
}
