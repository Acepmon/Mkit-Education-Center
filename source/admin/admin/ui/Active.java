package admin.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Active{
    private Pane pane;
    
    public Active(){
        
        pane = new Pane();
        
        Label label0 = new Label("Active");
        Button admin1 = new Button("Active Example");
        pane.getChildren().add(admin1);
        
        SplitPane centerPart = new SplitPane();
        centerPart.setPrefSize(824, 600);
        centerPart.setStyle("-fx-background-color: #E6FFFF");
        centerPart.setDividerPosition((int) 0.01f, 0.7f);
        centerPart.setMinSize(10, 10);

        FlowPane centerLeftPart = new FlowPane();
        centerLeftPart.setAlignment(Pos.CENTER);
        centerLeftPart.setPrefSize(550, 600);
        centerLeftPart.setStyle("-fx-background-color: #E6FFFF");
        centerLeftPart.setMinWidth(0);

        centerPart.getItems().addAll(centerLeftPart);
        
        centerLeftPart.getChildren().addAll(label0,admin1);
        
        pane.getChildren().addAll(centerPart);
        pane.setVisible(true);
        
//        ***********************************************************************************************
        
        Label tseejZurag = new Label("Зураг");
        tseejZurag.setPrefSize(180, 150);
        tseejZurag.setPadding(new Insets(20, 60, 0, 60));
        
        admin1.setOnAction(st -> {
            if (centerPart.getItems().size() > 1) {
                centerPart.getItems().remove(1);
            }
//            centerPart.getItems().add(new Zarlalt().getActiveContainer());
        });
        
    }
    
    public Pane getContainer() {
        return this.pane;
    }
    
}
