package teacher.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import teacher.controller.ServerConnection;

public class Daalgavarshalgah {

    private FlowPane rootNode;
    TextArea txtarea;

    public Daalgavarshalgah() {
        rootNode = new FlowPane();

        FlowPane centerFp = new FlowPane();
        centerFp.setPrefSize(524, 648);
        ComboBox<String> myComboBox = new ComboBox<String>();
        myComboBox.setPrefSize(100, 60);
        myComboBox.setValue("Value1");
         myComboBox.getItems().addAll("Value1", "Value2", "Value3");
                 Label dun2 = new Label("");
        dun2.setPrefSize(40, 20);
        
        
        Label tessb = new Label("Оюутан 1-ын Гэрийн Даалгавар");
        tessb.setAlignment(Pos.CENTER);
        tessb.setFont(new Font("Arial", 14));
        tessb.setPrefSize(750, 60);
        tessb.setFont(javafx.scene.text.Font.font("Arial", 18));
        tessb.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        tessb.setId("text");

        VBox vbox = new VBox();

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20, 20, 20, 20));
        hbox.setPrefSize(524, 60);

        Label dun = new Label("");
        dun.setPrefSize(40, 20);

        TextField dunTf = new TextField();
        dunTf.setPromptText(" Дүн");
        dunTf.setPrefSize(100, 20);
        dunTf.setAlignment(Pos.BOTTOM_CENTER);

        Button addBtn = new Button("Батлах");
        addBtn.setAlignment(Pos.BOTTOM_CENTER);
        addBtn.setFont(javafx.scene.text.Font.font("Arial", FontWeight.EXTRA_LIGHT, 15));
        addBtn.setPrefSize(120, 20);
        addBtn.setOnAction(ae -> {
            String send = dunTf.getText();
            ServerConnection.RequestAjluulah("insertDunDaalgavar", send);
            System.out.println(ServerConnection.RequestAjluulah("insertDunDaalgavar", send));
        });

        addBtn.setId("green");



        centerFp.getChildren().add(tessb);
        centerFp.setStyle("-fx-background-color: white");

        txtarea = new TextArea();
        txtarea.setPrefSize(750, 588);

        centerFp.getChildren().add(txtarea);

        hbox.getChildren().addAll(myComboBox,dun2, dunTf, dun, addBtn);
        vbox.getChildren().addAll(centerFp);

        rootNode.getChildren().addAll(vbox, hbox);
        rootNode.setId("border");
    }

    public FlowPane getContainer() {
        return this.rootNode;
    }
}
