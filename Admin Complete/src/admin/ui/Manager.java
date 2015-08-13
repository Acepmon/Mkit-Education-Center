package admin.ui;

import static admin.ui.Admin.rowIndex;
import static admin.ui.Admin.table;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import login.ui.ServerConnection;
import org.omg.CORBA.DATA_CONVERSION;

public class Manager {
    private Pane pane;
    public static TableView table = new TableView();
    public static int rowIndex = -1;
    public static boolean managerDuudsan = false;
    
    private static ComboBox<String> cbSearch;    
    private static TextField filterField;
    
    static ObservableList<ManagerObj> data = FXCollections.observableArrayList();
    
    public Manager(){
        
        pane = new Pane();
        
        
        SplitPane centerPart = new SplitPane();
        centerPart.setPrefSize(824, 600);
        centerPart.setStyle("-fx-background-color: #E6FFFF");
        centerPart.setDividerPosition((int) 0.01f, 0.5f);
        centerPart.setMinSize(10, 10);
        
        BorderPane centerLeftPart = new BorderPane();
        centerLeftPart.setPrefSize(550, 600);
        centerLeftPart.setStyle("-fx-background-color: #E6FFFF");
        centerLeftPart.setMinWidth(0);
        Label label = new Label("МЕНЕЖЕР");
        label.setFont(Font.font(null, FontWeight.BOLD, 16));
        Button manager1 = new Button("Manager Example");
        
        GridPane header = new GridPane();
        header.setPrefHeight(100);
        header.setPadding(new Insets(15, 15, 15, 15));
        header.setStyle("-fx-background-color:#E6FFFF;");
        
        Label lbl1 = new Label("Товчхон харах");
        lbl1.setFont(Font.font(null, FontWeight.BOLD, 12));
        CheckBox cb1 = new CheckBox();
        cb1.setFont(Font.font(null, FontWeight.BOLD, 12));
        Label lbl2 = new Label("Хайлт хийх");
        lbl2.setFont(Font.font(null, FontWeight.BOLD, 12));
        ObservableList<String> searchtype = FXCollections.observableArrayList("нэрээр", "овогоор", "id", "утасаар", "статусаар");
        cbSearch = new ComboBox(searchtype);
        cbSearch.setValue("Сонго");
        
        cbSearch.setOnAction(ae->{
            searchFilter();
        });
        
        filterField = new TextField();
        filterField.setPromptText("хайх утга...");
        filterField.setOnKeyReleased(ae-> {
            searchFilter();
        });
        
        Button addBtn = new Button("Шинээр нэмэх");
        addBtn.setOnAction(ae -> {
            Stage AddStage = new Stage();
            try {
                new AddManager().start(AddStage);
            } catch (Exception ex) {
                Logger.getLogger(AllAdd.class.getName()).log(Level.SEVERE, null, ex);
            }           
        });
        addBtn.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");  
        
        
        header.getChildren().addAll(lbl1, cb1, lbl2, cbSearch,filterField, addBtn);
        
        header.setConstraints(lbl1, 0, 1);
        header.setConstraints(cb1, 1, 1);
        header.setConstraints(lbl2, 0, 2);
        header.setConstraints(cbSearch, 1, 2);
        header.setConstraints(filterField, 2, 2);
//        header.setConstraints(manager1, 3, 2);
        header.setConstraints(addBtn, 0, 3);
        
        header.setVgap(15);
        header.setHgap(10);        
        
        
        
        ArrayList<String> responseData = (ArrayList<String>) ServerConnection.RequestAjluulah("getManagers", null);        
        System.out.println("---- manager "+responseData);   
        
        
        for(String str : responseData){
            if (!str.equals("") && str != null) {
            String[] col = str.split("::");
            data.addAll(new ManagerObj(col[0], col[1], col[2], col[3], col[4], col[5], col[6], col[7], col[8], col[9], col[10],col[11], col[12]));
            }
        }
        
//        final ObservableList<ManagerObj> data = FXCollections.observableArrayList(
//                    new ManagerObj("1", "ia900301", "sads", "ds", "dsds", "dsds", "dsds", "dsds", "dss", "user", "pass", "ds"),
//                    new ManagerObj("2", "ia900301", "sads", "ds", "dsds", "dsds", "dsds", "dsds", "dss", "user", "pass", "ds")
//            );
        
        TableColumn idColumn = new TableColumn("Дугаар");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, Integer>("id"));
        table.getColumns().add(idColumn);
        
        TableColumn regColumn = new TableColumn("Регистер");
        regColumn.setMinWidth(100);
        regColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, String>("register"));
        table.getColumns().add(regColumn);
        
        TableColumn lastNameColumn = new TableColumn("Овог");
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, String>("lastName"));
        table.getColumns().add(lastNameColumn);
        
        TableColumn firstNameColumn = new TableColumn("Нэр");
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, String>("firstName"));
        table.getColumns().add(firstNameColumn);
        
        TableColumn statusColumn = new TableColumn("Статус");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, Integer>("status"));
        table.getColumns().add(statusColumn);
        
        TableColumn phoneNumColumn = new TableColumn("Утас");
        phoneNumColumn.setMinWidth(100);
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, Integer>("phoneNum"));
        table.getColumns().add(phoneNumColumn);
        
        TableColumn emailColumn = new TableColumn("Цахим шуудан");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, String>("email"));
        table.getColumns().add(emailColumn);
        
        TableColumn socialColumn = new TableColumn("Сошиал");
        socialColumn.setMinWidth(100);
        socialColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, String>("social"));
        table.getColumns().add(socialColumn);
        
        TableColumn addressColumn = new TableColumn("Гэрийн хаяг:");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, String>("address"));
        table.getColumns().add(addressColumn);
        
        TableColumn picColumn = new TableColumn("picture");
        picColumn.setMinWidth(100);
        picColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, String>("picture"));  
        table.getColumns().add(picColumn);
        
        TableColumn delColumn = new TableColumn("delete flag");
        delColumn.setMinWidth(100);
        delColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, Integer>("deleteFlag"));  
        table.getColumns().add(delColumn);
        
        TableColumn usernameColumn = new TableColumn("Нэвтрэх нэр:");
        usernameColumn.setMinWidth(100);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, String>("username"));
        table.getColumns().add(usernameColumn);
                
        TableColumn passwordColumn = new TableColumn("Нууц үг:");
        passwordColumn.setMinWidth(100);
        passwordColumn.setCellValueFactory(new PropertyValueFactory<ManagerObj, String>("password"));
        table.getColumns().add(passwordColumn);
            
        
                
//        table.getColumns().addAll(
//                idColumn,
//                regColumn,
//                lastNameColumn,
//                firstNameColumn,
//                phoneNumColumn, 
//                emailColumn,
//                socialColumn,
//                addressColumn,
//                picColumn,
//                usernameColumn,
//                passwordColumn,
//                delColumn,
//                statusColumn
//                            
//        );
        table.setPrefSize(400, 400);
        
        table.setItems(data);
        
        table.setOnMouseClicked(ae -> {
            int c = table.getSelectionModel().getSelectedIndex();
            System.out.println(c);
            rowIndex = c;  
        });
        
        cb1.setSelected(false);
        cb1.setOnAction(ae->{
            if(cb1.isSelected()){
                table.getColumns().clear();
                table.getColumns().addAll(idColumn,regColumn,lastNameColumn,firstNameColumn);
            }else{
                table.getColumns().clear();
                table.getColumns().addAll(
                        idColumn,
                        regColumn,
                        lastNameColumn,
                        firstNameColumn,
                        phoneNumColumn, 
                        emailColumn,
                        socialColumn,
                        addressColumn,
                        picColumn,                        
                        usernameColumn,
                        passwordColumn,
                        delColumn,
                        statusColumn                      
                        );}
        });
        
        Label east = new Label("     ");
        Label west = new Label("     ");
        Label bottom = new Label("     ");
        centerLeftPart.setLeft(east);
        centerLeftPart.setRight(west);
        centerLeftPart.setBottom(bottom);        
        
        
        header.getChildren().addAll(label,manager1);
        centerLeftPart.setTop(header);
        centerLeftPart.setCenter(table);
//        centerLeftPart.getChildren().addAll(label0,admin1,table);
        centerPart.getItems().addAll(centerLeftPart);
        
        pane.getChildren().addAll(centerPart);
        pane.setVisible(true);
        
//        ***********************************************************************************************
        
        Label tseejZurag = new Label("Зураг");
        tseejZurag.setPrefSize(180, 150);
        tseejZurag.setPadding(new Insets(20, 60, 0, 60));
        
        manager1.setOnAction(st -> {
            if (centerPart.getItems().size() > 1) {
                centerPart.getItems().remove(1);
            }
            centerPart.getItems().add(new Zarlalt().getManagerContainer());
            Admin.adminDuudsan = false;
            Teacher.teacherDuudsan = false;
            managerDuudsan = true;
            Student.studentDuudsan = false;
        });
        manager1.setVisible(false);
        
        table.setOnMousePressed(ae->{
            
            if (centerPart.getItems().size() > 1) {
                centerPart.getItems().remove(1);
            }
            centerPart.getItems().add(new Zarlalt().getManagerContainer());    
            Admin.adminDuudsan = false;
            Teacher.teacherDuudsan = false;
            managerDuudsan = true;
            Student.studentDuudsan = false;
        });        
    }
    
    public Pane getContainer() {
        return this.pane;
    }
    
    void searchFilter(){
        String cellValue = "";
        ObservableList<ManagerObj> tableItem = FXCollections.observableArrayList();
        
        for(int i=0; i<data.size(); i++){
            ManagerObj managerObj = data.get(i);
            switch(cbSearch.getValue()){
                case "нэрээр":
                    cellValue = managerObj.getFirstName().toLowerCase();
                    break;
                    
                case "овогоор":
                    cellValue = managerObj.getLastName().toLowerCase();
                    break;
                
                case "id":
                    cellValue = managerObj.getId().toLowerCase();
                    break;
                    
                case "утасаар":
                    cellValue = managerObj.getPhoneNum().toLowerCase();
                    break;
                    
                case "статусаар":
                    cellValue = managerObj.getStatus().toLowerCase();
                    break;
                
                default:
                    cellValue = managerObj.getFirstName().toLowerCase()+managerObj.getLastName().toLowerCase()+managerObj.getId().toLowerCase()+managerObj.getPhoneNum().toLowerCase()+managerObj.getStatus().toLowerCase();
            }
            
            if(cellValue.contains(filterField.getText().toLowerCase())){
                tableItem.add(managerObj);
            }
            table.setItems(tableItem);
        }
    }
    
}
