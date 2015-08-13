package admin.ui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import login.ui.ServerConnection;

// ene class ni buh oyutnuudiin medeeliig table-eer haruulah zorilgotoi ba 
//tuhain neg oyutan der darah uyd tuunii delgerengui medeeliig baruun taliin tsomhod haruulj baina

public class Student {
    private Pane pane;
    public static TableView table = new TableView();
    public static int rowIndex = -1;
    public static boolean studentDuudsan = false;
    
    private static ComboBox<String> cbSearch;    
    private static TextField filterField;
    
    static ObservableList<StudentObj> data = FXCollections.observableArrayList();
    
    public Student(){
        
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
        Label label = new Label("ОЮУТАН");
        label.setFont(Font.font(null, FontWeight.BOLD, 16));
        Button student1 = new Button("Student Example");
        
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
        
        Button addBtn = new Button("Шинээр нэмэх");
        addBtn.setOnAction(ae -> {
            Stage AddStage = new Stage();
            try {
                new AddStudent().start(AddStage);
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
        
        header.getChildren().addAll(lbl1,cb1,lbl2,cbSearch,filterField, addBtn);
        
        header.setConstraints(lbl1, 0, 1);
        header.setConstraints(cb1, 1, 1);
        header.setConstraints(lbl2, 0, 2);
        header.setConstraints(cbSearch, 1, 2);
        header.setConstraints(filterField, 2, 2);
//        header.setConstraints(student1, 3, 2);
        header.setConstraints(addBtn, 0, 3);
        
        header.setVgap(15);
        header.setHgap(10);        
        
        TableColumn idColumn = new TableColumn("Дугаар");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("id"));
//        table.getColumns().add(idColumn);
        
        TableColumn numberColumn = new TableColumn("Бүртгэлийн дугаар");
        numberColumn.setMinWidth(100);
        numberColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("bcode"));
//        table.getColumns().add(numberColumn);

        TableColumn lastNameColumn = new TableColumn("Овог");
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("lastname"));
//        table.getColumns().add(lastNameColumn);

        TableColumn firstNameColumn = new TableColumn("Нэр");
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("firstname"));
//        table.getColumns().add(firstNameColumn);

        TableColumn statusColumn = new TableColumn("Статус");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("status"));
//        table.getColumns().add(statusColumn);
        
        TableColumn phoneNumColumn = new TableColumn("Утас");
        phoneNumColumn.setMinWidth(100);
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("phonenum"));
//        table.getColumns().add(phoneNumColumn);

        TableColumn emailColumn = new TableColumn("Цахим шуудан");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("email"));
//        table.getColumns().add(emailColumn);
        
        TableColumn socialColumn = new TableColumn("Сошиал хаяг");
        socialColumn.setMinWidth(100);
        socialColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("social"));
//        table.getColumns().add(socialColumn);
        
        TableColumn registerColumn = new TableColumn("Регистер");
        registerColumn.setMinWidth(100);
        registerColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("register"));
//        table.getColumns().add(registerColumn);
        
        TableColumn addressColumn = new TableColumn("Хаяг");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("address"));
//        table.getColumns().add(addressColumn);

        TableColumn classColumn = new TableColumn("Багш сонголт");
        classColumn.setMinWidth(100);
        classColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("classname"));
//        table.getColumns().add(classColumn);

        TableColumn comNumColumn = new TableColumn("Комны дугаар");
        comNumColumn.setMinWidth(100);
        comNumColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("comnum"));
//        table.getColumns().add(comNumColumn);
        
        TableColumn numberStartColumn = new TableColumn("Элсэлтийн дугаар");
        numberStartColumn.setMinWidth(100);
        numberStartColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("numstart"));
//        table.getColumns().add(numberStartColumn);
        
        TableColumn delColumn = new TableColumn("Delete Flag");
        delColumn.setMinWidth(100);
        delColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("deleteFlag"));
//        table.getColumns().add(delColumn);
        
        TableColumn reasonColumn = new TableColumn("Шалтгаан");
        reasonColumn.setMinWidth(100);
        reasonColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("reason"));
//        table.getColumns().add(delColumn);
        
//        TableColumn usernameColumn = new TableColumn("Нэвтрэх нэр");
//        usernameColumn.setMinWidth(100);
//        usernameColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("username"));
//        table.getColumns().add(usernameColumn);
        
//        TableColumn passColumn = new TableColumn("Нууц үг");
//        passColumn.setMinWidth(100);
//        passColumn.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("password"));
//        table.getColumns().add(passColumn);
        
        
        table.getColumns().clear();
        table.getColumns().addAll(
                
                idColumn,
                numberColumn,
                lastNameColumn,
                firstNameColumn,                
                phoneNumColumn,
                emailColumn,
                socialColumn,
                registerColumn,
                addressColumn,
                classColumn,
                comNumColumn,
                numberStartColumn,                
//                imgColumn,
                delColumn,
                reasonColumn
//                usernameColumn,
//                passColumn
                
        );

        ArrayList<Object> responseData = (ArrayList<Object>) ServerConnection.RequestAjluulah("getAllStudentProfile", null);
              
        System.out.println("---- student "+responseData);
        data.clear();
        
//        final ObservableList<StudentObj> data = FXCollections.observableArrayList(
//                new StudentObj("id", "burtgel", "lastname", "firstname", "status", "phone", "email", "social", "register", "addres", "basgh", "kom", "elseltid", "user", "pass","delete")
//        );
        
        for(Object str : responseData) {
            if (!str.equals("") && str != null) {
            String[] col = str.toString().split("::");
                System.out.println("SIZE::::"+col.length);
            data.add(new StudentObj(col[0], col[1], col[2], col[3], col[4], col[5], col[6], col[7], col[8], col[9], col[10], col[11], col[12], col[13], col[14], col[15]));
            }
        }
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
                table.getColumns().addAll(
                        idColumn,
                        numberColumn,
                        lastNameColumn,
                        firstNameColumn,                
                        phoneNumColumn,
                        emailColumn
                       
                );
            }else{
                table.getColumns().clear();
                table.getColumns().addAll(
                            idColumn,
                            numberColumn,
                            lastNameColumn,
                            firstNameColumn,                
                            phoneNumColumn,
                            emailColumn,
                            socialColumn,
                            registerColumn,
                            addressColumn,
                            classColumn,
                            comNumColumn,
                            numberStartColumn,   
                            delColumn,
                            reasonColumn
                            );}
        });
        
        Label east = new Label("     ");
        Label west = new Label("     ");
        Label bottom = new Label("     ");
        centerLeftPart.setLeft(east);
        centerLeftPart.setRight(west);
        centerLeftPart.setBottom(bottom);
        
        
        header.getChildren().addAll(label,student1);
        centerLeftPart.setTop(header);
        centerLeftPart.setCenter(table);
//        centerLeftPart.getChildren().addAll(label0,admin1,table);
        centerPart.getItems().addAll(centerLeftPart);
        
        pane.getChildren().addAll(centerPart);
        pane.setVisible(true);
        
//        **************************************************************
        
        Label tseejZurag = new Label("Зураг");
        tseejZurag.setPrefSize(180, 150);
        tseejZurag.setPadding(new Insets(20, 60, 0, 60));
        
        student1.setOnAction(st -> {
            if (centerPart.getItems().size() > 1) {
                centerPart.getItems().remove(1);
            }
            centerPart.getItems().add(new Zarlalt().getStudentContainer());
            Admin.adminDuudsan = false;
            Manager.managerDuudsan = false;
            studentDuudsan = true;
            Teacher.teacherDuudsan = false;
        });
        student1.setVisible(false);

        table.setOnMousePressed(ae->{
            if (centerPart.getItems().size() > 1) {
                centerPart.getItems().remove(1);
            }
            centerPart.getItems().add(new Zarlalt().getStudentContainer());
            Admin.adminDuudsan = false;
            Manager.managerDuudsan = false;
            studentDuudsan = true;
            Teacher.teacherDuudsan = false;
        });
    }
    
    public Pane getContainer() {
        return this.pane;
    }
    
    void searchFilter(){
        String cellValue = "";
        ObservableList<StudentObj> tableItem = FXCollections.observableArrayList();
        
        for(int i=0; i<data.size(); i++){
            StudentObj studentObj = data.get(i);
            switch(cbSearch.getValue()){
                case "нэрээр":
                    cellValue = studentObj.getFirstname().toLowerCase();
                    break;
                    
                case "овогоор":
                    cellValue = studentObj.getLastname().toLowerCase();
                    break;
                
                case "id":
                    cellValue = studentObj.getId().toLowerCase();
                    break;
                    
                case "утасаар":
                    cellValue = studentObj.getPhonenum().toLowerCase();
                    break;
                    
                case "статусаар":
                    cellValue = studentObj.getStatus().toLowerCase();
                    break;
                
                default:
                    cellValue = studentObj.getFirstname().toLowerCase()+studentObj.getLastname().toLowerCase()+studentObj.getId().toLowerCase()+studentObj.getPhonenum().toLowerCase()+studentObj.getStatus().toLowerCase();
            }
            
            if(cellValue.contains(filterField.getText().toLowerCase())){
                tableItem.add(studentObj);
            }
            table.setItems(tableItem);
        }
    }
    
}
