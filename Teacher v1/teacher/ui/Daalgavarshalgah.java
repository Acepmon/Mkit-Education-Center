package teacher.ui;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class Daalgavarshalgah {
    
    private FlowPane rootNode;
    
    public Daalgavarshalgah(){
        rootNode = new FlowPane();
        
        FlowPane centerFp = new FlowPane();
        centerFp.setPrefSize(524, 708);
        Label tessb = new Label("Оюутан 1-ын Гэрийн Даалгавар");
        tessb.setFont(new Font("Arial", 30));
        tessb.setPadding(new Insets(15, 10, 15, 30));
        centerFp.getChildren().add(tessb);
        centerFp.setStyle("-fx-background-color: white");
        TextArea txtarea = new TextArea();
        txtarea.setPrefSize(524, 643);
        centerFp.getChildren().add(txtarea);
        
        rootNode.getChildren().add(centerFp);
    }
    
    public FlowPane getContainer() {
        return this.rootNode;
    }
}