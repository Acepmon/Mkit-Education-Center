package admin.ui;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
/**
 * @author JAVA M2
 */
public class CheckPermission extends Application{
    
    private TableView<Per> tableReport;
    private TableColumn<Per, String> name;
    private TableColumn<Per, Boolean> checkbox;
     
    
//    private Object getAdminContainer;
    private Zarlalt newadmin = new Zarlalt();
    private Zarlalt newmanager = new Zarlalt();
    
    @Override
    public void start(Stage checkStage){
        checkStage.setTitle("Permission засах");
        FlowPane rootPane = new FlowPane(10, 10);
        rootPane.setAlignment(Pos.CENTER);
        Scene checkScene = new Scene(rootPane, 300, 400);
        
        Label idlbl = new Label("");
        CheckBox checkBox = new CheckBox();
        TableView<Per> permissionTable = new TableView<Per>();
        ObservableList list = FXCollections.observableArrayList();
            
//            final TableColumn<Per, String> firstNameCol = new TableColumn<Person, String>("First Name");
//        final TableColumn<Per, String> lastNameCol = new TableColumn<Person, String>("Last Name");
//        final TableColumn<Per, Boolean> vegetarianCol = new TableColumn<Person, Boolean>("Vegetarian");
                    
            TableColumn<Per, String> permission_column =new TableColumn();
            permission_column.setText("Хэрэглэгчийн эрх");
            permission_column.setCellValueFactory(new PropertyValueFactory("permission"));
            permissionTable.getColumns().add(permission_column);
            permission_column.setPrefWidth(150);
            
            ObservableList<Per> row = FXCollections.observableArrayList(); 
            
            if(Admin.adminDuudsan){
                TableColumn<Per, Boolean> admin = new TableColumn();
                admin.setText("Админ");
                admin.setCellValueFactory(new PropertyValueFactory<Per, Boolean>("admin"));
                admin.setCellFactory(CheckBoxTableCell.forTableColumn(admin));
                admin.setEditable(true);
                permissionTable.getColumns().add(admin);
                admin.setPrefWidth(70);   
            
//            for (int i = 0; i < 1; i++) {
//                row.add(new Per("Дүн засах", true, false, false, false));
//                row.add(new Per("Дүн харах", true, false, false, false));
//                row.add(new Per("Дүн оруулах", true, false, false, false));
//                row.add(new Per("Ирц засах", true, false, false, false));
//                row.add(new Per("Мэдээлэл харах", true, false, false, false));
//            }
            }        
            
            if(Manager.managerDuudsan){
                TableColumn<Per, Boolean> manager = new TableColumn();
                manager.setText("Менежер");
                manager.setCellValueFactory(new PropertyValueFactory<Per, Boolean>("cell3"));
                manager.setCellFactory(CheckBoxTableCell.forTableColumn(manager));
                manager.setEditable(true);
                permissionTable.getColumns().add(manager);
                manager.setPrefWidth(70);      
                
//                row.add(new Per("Дүн засах", false, true, false, false));
//                row.add(new Per("Дүн харах", false, true, false, false));
//                row.add(new Per("Дүн оруулах", false, true, false, false));
//                row.add(new Per("Ирц засах", false, true, false, false));
//                row.add(new Per("Мэдээлэл харах", false, true, false, false));
            }

            if(Teacher.teacherDuudsan){
                TableColumn<Per, Boolean> teacher = new TableColumn();
                teacher.setText("Багш");
                teacher.setCellValueFactory(new PropertyValueFactory<Per, Boolean>("cell4"));
                teacher.setCellFactory(CheckBoxTableCell.forTableColumn(teacher));
                teacher.setEditable(true);
                permissionTable.getColumns().add(teacher);
                teacher.setPrefWidth(70);
                
//                row.add(new Per("Дүн засах", false, false, true, false));
//                row.add(new Per("Дүн харах", false, false, true, false));
//                row.add(new Per("Дүн оруулах", false, false, true, false));
//                row.add(new Per("Ирц засах", false, false, true, false));
//                row.add(new Per("Мэдээлэл харах", false, false, true, false));
            }
            
            if(Student.studentDuudsan){
                TableColumn<Per, Boolean> student = new TableColumn();
                student.setText("Оюутан");
                student.setCellValueFactory(new PropertyValueFactory<Per, Boolean>("cell5"));
                student.setCellFactory(CheckBoxTableCell.forTableColumn(student));
                student.setEditable(true);                
                permissionTable.getColumns().add(student);
                student.setPrefWidth(70);
                
//                row.add(new Per("Дүн засах", false, false, false, true));
//                row.add(new Per("Дүн харах", false, false, false, true));
//                row.add(new Per("Дүн оруулах", false, false, false, true));
//                row.add(new Per("Ирц засах", false, false, false, true));
//                row.add(new Per("Мэдээлэл харах", false, false, false, true));
            }
//            ObservableList<Per> row = FXCollections.observableArrayList(); 
            
//            for (int i = 0; i < 1; i++) {
                row.add(new Per("Дүн засах"));
			row.add(new Per("Дүн харах"));
			row.add(new Per("Дүн оруулах"));
			row.add(new Per("Ирц засах"));
			row.add(new Per("Мэдээлэл харах"));
                        
//                permissionTable.getItems().get(1).setAdmin(new SimpleBooleanProperty(true));
//                System.out.println();
//                permist
//                tableView.getItems().get(3).setVegetarian(true);                                
//            }
                
            permissionTable.setEditable(true);
            permissionTable.setItems(row);
            permissionTable.setPrefSize(230, 300);
            permissionTable.setVisible(true);
//        }
        
        Button confirmBtn = new Button("Батлах");
        confirmBtn.setPrefSize(180, 30);
//        confirmBtn.setOnAction(ae->{
//        end check boxii utguudiig awna   
//        });
        
        confirmBtn.setOnAction((ActionEvent event) -> {
            for (Per p : permissionTable.getItems()) {
                System.out.println(p.getAdmin());
                if(p.getAdmin()){
                    System.out.println(" Checked");
                } else {
                    System.out.println("Not Checked");
                }
//                    System.out.printf("(%s hasPermission) %n", p.getAdmin()? "" : "not ");
//                    System.out.println(permissionTable.getSelectionModel().getSelectedItems());
            }
//                System.out.println();
        });
        
        rootPane.getChildren().addAll(permissionTable, confirmBtn);
        checkStage.setScene(checkScene);
        checkStage.show();
    }
    
    
}
