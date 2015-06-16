package teacher.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class Tree {

    private FlowPane root;
    private ScrollPane scp;
    
    public Tree() {
        
        FlowPane rightFp = new FlowPane();
        rightFp.setPrefWidth(250);
        Label testb = new Label("Ирсэн Файлууд");
        testb.setFont(new Font("Arial", 15));
        testb.setPadding(new Insets(10, 20, 10, 65));
        rightFp.getChildren().add(testb);
        rightFp.setStyle("-fx-background-color: #E6E6E6");
      
        TreeItem<String> rootItem = new TreeItem<>("Машины Бүртгэл");
        rootItem.setExpanded(true);

        TreeItem<String> item = new TreeItem<>("Main");
        rootItem.getChildren().add(item);

        item = new TreeItem<>("editWindow");
        rootItem.getChildren().add(item);

        item = new TreeItem<>("addWindow");
        rootItem.getChildren().add(item);

        item = new TreeItem<>("mySQL connector");
        rootItem.getChildren().add(item);

        item = new TreeItem<>("Login");
        rootItem.getChildren().add(item);

        item = new TreeItem<>("deleteWindows");
        rootItem.getChildren().add(item);
        
        

        TreeView<String> tree = new TreeView<>(rootItem);
        root = new FlowPane();
        root.getChildren().addAll(rightFp, tree);
        root.setPrefSize(250, 650);
        tree.setPrefSize(250, 700);
        
        scp = new ScrollPane(root);
        scp.setPrefSize(250, 600);
        
    }

    public ScrollPane getContainer() {
        return this.scp;
    }
}
