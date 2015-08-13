package admin.ui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import login.ui.ServerConnection;

public class Admin {
    private Pane pane;
    public static TableView table = new TableView();
    public static int rowIndex = -1;
    public static boolean adminDuudsan = false;
    
    private static ComboBox<String> cbSearch;    
    private static TextField filterField;

    static ObservableList<AdminObj> data = FXCollections.observableArrayList();
    public Admin() {
       
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
        Label label = new Label("АДМИН");
        label.setFont(Font.font(null, FontWeight.BOLD, 16));
        Button admin1 = new Button("Admin Example");

        GridPane header = new GridPane();
        header.setPrefHeight(100);
        header.setPadding(new Insets(15, 15, 15, 15));
        header.setStyle("-fx-background-color:#E6FFFF;");

        Label lbl1 = new Label("Товчхон харах");
        lbl1.setFont(Font.font(null, FontWeight.BOLD, 12));
        CheckBox cb1 = new CheckBox();
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
        
        Button searchBtn = new Button("Хайлт хийх");
        
        Button addBtn = new Button("Шинээр нэмэх");
        addBtn.setOnAction(ae -> {
            Stage AddStage = new Stage();
            try {
                new AddAdmin().start(AddStage);
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
        
        header.getChildren().addAll(lbl1, cb1, lbl2, cbSearch, filterField, addBtn);

        header.setConstraints(lbl1, 0, 1);
        header.setConstraints(cb1, 1, 1);
        header.setConstraints(lbl2, 0, 2);
        header.setConstraints(cbSearch, 1, 2);
        header.setConstraints(filterField, 2, 2);
//        header.setConstraints(searchBtn, 3, 2);
        header.setConstraints(addBtn, 0, 3);

        header.setVgap(15);
        header.setHgap(10);

//        **********Table*****************************************
        TableColumn idColumn = new TableColumn("Дугаар");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("id"));
        
        TableColumn regColumn = new TableColumn("Регистер");
        regColumn.setMinWidth(100);
        regColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("register"));

        TableColumn lastNameColumn = new TableColumn("Овог");
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("lastName"));

        TableColumn firstNameColumn = new TableColumn("Нэр");
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("firstName"));
        
        TableColumn statusColumn = new TableColumn("Статус");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("status"));

        TableColumn phoneNumColumn = new TableColumn("Утас");
        phoneNumColumn.setMinWidth(100);
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("phoneNum"));
        
        TableColumn emailColumn = new TableColumn("Цахим шуудан");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("email"));
        
        TableColumn socialColumn = new TableColumn("Сошиал");
        socialColumn.setMinWidth(100);
        socialColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("social"));

        TableColumn addressColumn = new TableColumn("Хаяг");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("address"));
        
        TableColumn usernameColumn = new TableColumn("Username");
        usernameColumn.setMinWidth(100);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("username"));
        
        TableColumn passwordColumn = new TableColumn("Password");
        passwordColumn.setMinWidth(100);
        passwordColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("password"));

        TableColumn delColumn = new TableColumn("DeleteFlag");
        delColumn.setMinWidth(100);
        delColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("deleteFlag"));
        
        TableColumn picColumn = new TableColumn("picture");
        picColumn.setMinWidth(100);
        picColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("picture"));

        

        table.getColumns().addAll(
                idColumn,
                regColumn,
                lastNameColumn,
                firstNameColumn,
                statusColumn,
                phoneNumColumn,
                emailColumn,
                socialColumn,
                addressColumn,
                picColumn,
                delColumn,
                usernameColumn,
                passwordColumn                
        );
        // table доторх мэдээллийг энэ функц дотор хийж өгсөн. 
        DataSet();
     
        table.setOnMouseClicked(ae -> {
            int c = table.getSelectionModel().getSelectedIndex();
            System.out.println(c);
            rowIndex = c;  
        });
        
        cb1.setSelected(true);
        cb1.setOnAction(ae -> {
            if (cb1.isSelected()) {
                table.getColumns().clear();
                table.getColumns().addAll(idColumn, lastNameColumn, firstNameColumn);
            } else {
                table.getColumns().clear();
                table.getColumns().addAll(
                        idColumn, 
                        regColumn,
                        lastNameColumn, 
                        firstNameColumn,
                        statusColumn,
                        phoneNumColumn,                         
                        emailColumn,
                        socialColumn,
                        addressColumn,
                        picColumn,
                        delColumn,
                        usernameColumn,
                        passwordColumn                        
                        );
            }
        });

        Label east = new Label("     ");
        Label west = new Label("     ");
        Label bottom = new Label("     ");
        centerLeftPart.setLeft(east);
        centerLeftPart.setRight(west);
        centerLeftPart.setBottom(bottom);

        header.getChildren().addAll(label, admin1);
        centerLeftPart.setTop(header);
        centerLeftPart.setCenter(table);
        centerPart.getItems().addAll(centerLeftPart);

        pane.getChildren().addAll(centerPart);
        pane.setVisible(true);

//        *********************************************************
        Label tseejZurag = new Label("Зураг");
        tseejZurag.setPrefSize(180, 150);
        tseejZurag.setPadding(new Insets(20, 60, 0, 60));

        admin1.setOnAction(st -> {
            double a = Zarlalt.centerRightPart.getWidth();
            System.out.println(a);
            if (a < 330) {

                new Timeline(
                        new KeyFrame(Duration.seconds(0), new KeyValue(Zarlalt.centerRightPart.opacityProperty(), 0.1)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(Zarlalt.centerRightPart.minWidthProperty(), 330)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(Zarlalt.centerRightPart.opacityProperty(), 1))).play();
                Zarlalt.centerRightPart.setMinWidth(330);
            } else if (a >= 330) {
                System.out.println("asdasds");
                new Timeline(
                        new KeyFrame(Duration.seconds(0), new KeyValue(Zarlalt.centerRightPart.opacityProperty(), 0.1)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(Zarlalt.centerRightPart.prefWidthProperty(), 0)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(Zarlalt.centerRightPart.opacityProperty(), 1))).play();
            }

        });
        admin1.setVisible(false);

        table.setOnMousePressed(ae -> {
            if (centerPart.getItems().size() > 1) { 
                centerPart.getItems().remove(1);
            }
            centerPart.getItems().add(new Zarlalt().getAdminContainer());
            adminDuudsan = true;
            Manager.managerDuudsan = false;
            Student.studentDuudsan = false;
            Teacher.teacherDuudsan = false;                    
        });
        
    }
        
    private void initialize(){   
    }
    public Pane getContainer() {
        return this.pane;
    }
    
    public  static void DataSet(){
            data.clear();
            
                   
            ArrayList<String> responseData = (ArrayList<String>) ServerConnection.RequestAjluulah("getAllAdminProfile", null);        
            System.out.println("---- admin "+responseData);  
            
            for (String str : responseData) {
                if (!str.equals("") && str != null) {
                String[] col = str.split("::");
                data.add(new AdminObj(col[0], col[1], col[2], col[3], col[4], col[5], col[6], col[7], col[8], col[9], col[10], col[11], col[12]));
                }
            }            
//            final ObservableList<AdminObj> data = FXCollections.observableArrayList(
//                    new AdminObj("1", "ia900301", "sads", "ds", "dsds", "dsds", "dsds", "dsds", "dss","user","pass", "ds"),
//                    new AdminObj("2", "ia900301", "sads", "ds", "dsds", "dsds", "dsds", "dsds", "dss","user","pass", "ds")
//            );
            
            
            table.setItems(data);

            table.setOnMouseClicked(ae -> {
                int c = table.getSelectionModel().getSelectedIndex();
                System.out.println(c);
                rowIndex = c;  
            });     
            
    }
    
    void searchFilter(){
        String cellValue = "";
        ObservableList<AdminObj> tableItem = FXCollections.observableArrayList();
        
        for(int i=0; i<data.size(); i++){
            AdminObj adminObj = data.get(i);
            switch(cbSearch.getValue()){
                case "нэрээр":
                    cellValue = adminObj.getFirstName().toLowerCase();
                    break;
                    
                case "овогоор":
                    cellValue = adminObj.getLastName().toLowerCase();
                    break;
                
                case "id":
                    cellValue = adminObj.getId().toLowerCase();
                    break;
                    
                case "утасаар":
                    cellValue = adminObj.getPhoneNum().toLowerCase();
                    break;
                    
                case "статусаар":
                    cellValue = adminObj.getStatus().toLowerCase();
                    break;
                
                default:
                    cellValue = adminObj.getFirstName().toLowerCase()+adminObj.getLastName().toLowerCase()+adminObj.getId().toLowerCase()+adminObj.getPhoneNum().toLowerCase()+adminObj.getStatus().toLowerCase();
            }
            
            if(cellValue.contains(filterField.getText().toLowerCase())){
                tableItem.add(adminObj);
            }
            table.setItems(tableItem);
        }
    }
    
}
