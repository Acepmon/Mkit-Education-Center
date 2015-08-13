package admin.ui;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Permission_UI extends Application {
    
    public void start(Stage myStage) {

        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setStyle("-fx-background-color: white");
        CheckBox checkBox = new CheckBox();
        TableView<Per> permissionTable = new TableView<Per>();
        ObservableList list = FXCollections.observableArrayList();
        
        TableColumn<Per, String> permission_column =new TableColumn();
        permission_column.setText("Хэрэглэгчийн эрх");
        permission_column.setCellValueFactory(new PropertyValueFactory("permission"));
        permissionTable.getColumns().add(permission_column);
        permission_column.setPrefWidth(150);
        
        TableColumn<Per, Boolean> admin = new TableColumn();
        admin.setText("Админ");
        admin.setCellValueFactory(new PropertyValueFactory("cell2"));
        permissionTable.getColumns().add(admin);
        admin.setPrefWidth(70);
        
        TableColumn<Per, Boolean> manager = new TableColumn();
        manager.setText("Менежер");
        manager.setCellValueFactory(new PropertyValueFactory("cell3"));
        permissionTable.getColumns().add(manager);
        manager.setPrefWidth(70);
        
        TableColumn<Per, Boolean> teacher = new TableColumn();
        teacher.setText("Багш");
        teacher.setCellValueFactory(new PropertyValueFactory("cell4"));
        permissionTable.getColumns().add(teacher);
        teacher.setPrefWidth(70);
        
        TableColumn<Per, Boolean> student = new TableColumn();
        student.setText("Оюутан");
        student.setCellValueFactory(new PropertyValueFactory("cell5"));
        permissionTable.getColumns().add(student);
        student.setPrefWidth(70);
        
        ObservableList<Per> row = FXCollections.observableArrayList(); 
        for (int i = 0; i < 1; i++) {
			row.add(new Per("Дүн засах"));
			row.add(new Per("Дүн харах"));
			row.add(new Per("Дүн оруулах"));
			row.add(new Per("Ирц засах"));
			row.add(new Per("Мэдээлэл харах"));
        }
        Button btn = new Button("Батлах");
        btn.setPrefSize(180, 30);
        
        permissionTable.setItems(row);
        permissionTable.setPrefSize(430, 300);
        rootNode.getChildren().addAll(permissionTable, btn);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 600, 500);
        
        myStage.setScene(scene);
        myStage.show();
    }
//    public static void main(String[] args) {
//        launch(args);
//    }
}


