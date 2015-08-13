package admin.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
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

public class Teacher {
    private Pane pane;
    public static TableView table = new TableView();
    public static int rowIndex = -1;
    public static boolean teacherDuudsan = false;
    
    private static ComboBox<String> cbSearch;    
    private static TextField filterField;
    
    static ObservableList<TeacherObj> data = FXCollections.observableArrayList();
    Socket sock=null;
    File myfiles;
    
    public Teacher(){
                
        pane = new Pane();
        
        SplitPane centerPart = new SplitPane();
        centerPart.setPrefSize(824, 600);
        centerPart.setStyle("-fx-background-color: #E6FFFF");
        centerPart.setMinSize(10, 10);
        
        BorderPane centerLeftPart = new BorderPane();
        centerLeftPart.setPrefSize(550, 600);
        centerLeftPart.setStyle("-fx-background-color: #E6FFFF");
        centerLeftPart.setMinWidth(0);
        Label label = new Label("БАГШ");
        label.setFont(Font.font(null, FontWeight.BOLD, 16));
        Button teacher1 = new Button("Teacher Example");
        
        GridPane header = new GridPane();
        header.setPadding(new Insets(15, 15, 15, 15));
        header.setPrefHeight(100);
        header.setStyle("-fx-background-color:#E6FFFF;");
        
        Label lbl1 = new Label("Товчхон харах");
        CheckBox cb1 = new CheckBox();
        Label lbl2 = new Label("Хайлт хийх");
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
                new AddTeacher().start(AddStage);
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
//        header.setConstraints(teacher1, 3, 2);
        header.setConstraints(addBtn, 0, 3);
        
        header.setVgap(15);
        header.setHgap(10);
        
        
        TableColumn idColumn = new TableColumn("Дугаар");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("id"));
        
        TableColumn regColumn = new TableColumn("Register");
        regColumn.setMinWidth(100);
        regColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("register"));

        TableColumn lastNameColumn = new TableColumn("Овог");
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("lastName"));

        TableColumn firstNameColumn = new TableColumn("Нэр");
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("firstName"));
        
        TableColumn statusColumn = new TableColumn("Статус");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("status"));
        
        TableColumn subjectColumn = new TableColumn("Хичээл");
        subjectColumn.setMinWidth(100);
        subjectColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("subject"));

        TableColumn phoneNumColumn = new TableColumn("Утас");
        phoneNumColumn.setMinWidth(100);
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("phoneNum"));
        
        TableColumn emailColumn = new TableColumn("Цахим шуудан");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("email"));
        
        TableColumn socialColumn = new TableColumn("Social");
        socialColumn.setMinWidth(100);
        socialColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("social"));

        TableColumn addressColumn = new TableColumn("Хаяг");
        addressColumn.setMinWidth(100);
        addressColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("address"));
        
        TableColumn usernameColumn = new TableColumn("Username");
        usernameColumn.setMinWidth(100);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("username"));
        
        TableColumn passwordColumn = new TableColumn("Password");
        passwordColumn.setMinWidth(100);
        passwordColumn.setCellValueFactory(new PropertyValueFactory<AdminObj, String>("password"));
        
        TableColumn delColumn = new TableColumn("deleteFlag");
        delColumn.setMinWidth(100);
        delColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("deleteFlag"));
        
        TableColumn picColumn = new TableColumn("picture");
        delColumn.setMinWidth(100);
        delColumn.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("picture"));

        

        table.getColumns().addAll(
                idColumn,
                regColumn,
                lastNameColumn,
                firstNameColumn,
                statusColumn,
                subjectColumn,
                phoneNumColumn,
                emailColumn,
                socialColumn,
                addressColumn,
                delColumn,
                picColumn,
                usernameColumn,
                passwordColumn
                
                
        );

        ArrayList<String> responseData = (ArrayList<String>) ServerConnection.RequestAjluulah("getAllTeacherProfile", null);
        System.out.print("teacher---> " + responseData);
        
        for(String str : responseData) {
            if (!str.equals("") && str != null) {
                String[] col = str.split("::");
                data.add(new TeacherObj(col[0], col[1], col[2], col[3], col[4], col[5], col[6], col[7], col[8], col[9], col[10], col[11], col[12], col[13]));
            }
        }
        
//        final ObservableList<TeacherObj> data = FXCollections.observableArrayList(
//                    new TeacherObj("1", "ia900301", "owog", "ner", "status", "hicheel", "utas", "mail", "social", "address", "user", "pass", "delete"),
//                    new TeacherObj("2", "ia900301", "sads", "ds", "dsds", "dsds", "dsds", "dsds", "dss", "ds", "user", "pass", "del")
//            );
        
        
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
                        statusColumn,
                        subjectColumn,
                        phoneNumColumn,
                        emailColumn,
                        socialColumn,
                        addressColumn,
                        usernameColumn,
                        passwordColumn,
                        delColumn     
                        );}
        });
        
        Label east = new Label("     ");
        Label west = new Label("     ");
        Label bottom = new Label("     ");
        centerLeftPart.setLeft(east);
        centerLeftPart.setRight(west);
        centerLeftPart.setBottom(bottom);        
        
        header.getChildren().addAll(label,teacher1);
        centerLeftPart.setTop(header);
        centerLeftPart.setCenter(table);
        centerPart.getItems().addAll(centerLeftPart);
        
        pane.getChildren().addAll(centerPart);
        pane.setVisible(true);
        
//        ***********************************************************************************************
        
        Label tseejZurag = new Label("Зураг");
        tseejZurag.setPrefSize(180, 150);
        tseejZurag.setPadding(new Insets(20, 60, 0, 60));
        
        teacher1.setOnAction(st -> {
            if (centerPart.getItems().size() > 1) {
                centerPart.getItems().remove(1);
            }
            centerPart.getItems().add(new Zarlalt().getTeacherContainer());
            Admin.adminDuudsan = false;
            Manager.managerDuudsan = false;
            Student.studentDuudsan = false;
            teacherDuudsan = true;
        });
        teacher1.setVisible(false);
        
        table.setOnMousePressed(ae->{
            if (centerPart.getItems().size() > 1) { 
                centerPart.getItems().remove(1);
            }
            centerPart.getItems().add(new Zarlalt().getTeacherContainer());
            Admin.adminDuudsan = false;
            Manager.managerDuudsan = false;
            Student.studentDuudsan = false;
            teacherDuudsan = true;
        });
        
    }
    
    public Pane getContainer() {
        return this.pane;
    }
        public void receiveFileFromServer() throws ClassNotFoundException, IOException {
        String host = "192.168.0.189";
        int port = 5050;
        try {
            sock = new Socket(host, port);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Connection made (clientSide)");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(sock.getInputStream());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        myfiles = (File) ois.readObject();
        System.out.println("AbsolutePath: " + myfiles.getAbsolutePath());
        System.out.println("FileName: " + myfiles.getName());
        System.out.println("length: " + myfiles.length());
        String targetFileName = "C:\\Users\\JAVA M2\\Desktop\\"+myfiles.getName();
        System.out.println(targetFileName);
        System.out.println("File will be saved to: " + targetFileName);
        copyBytes(myfiles, targetFileName);
        
    }
    private void copyBytes(File originalFile, String targetFileName) throws IOException {
        InputStream in;
        FileOutputStream out;
        in = sock.getInputStream();
        out = new FileOutputStream(targetFileName);
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        out.close();
        in.close();

    }
    
    void searchFilter(){
        String cellValue = "";
        ObservableList<TeacherObj> tableItem = FXCollections.observableArrayList();
        
        for(int i=0; i<data.size(); i++){
            TeacherObj teacherObj = data.get(i);
            switch(cbSearch.getValue()){
                case "нэрээр":
                    cellValue = teacherObj.getFirstName().toLowerCase();
                    break;
                    
                case "овогоор":
                    cellValue = teacherObj.getLastName().toLowerCase();
                    break;
                
                case "id":
                    cellValue = teacherObj.getId().toLowerCase();
                    break;
                    
                case "утасаар":
                    cellValue = teacherObj.getPhoneNum().toLowerCase();
                    break;
                    
                case "статусаар":
                    cellValue = teacherObj.getStatus().toLowerCase();
                    break;
                
                default:
                    cellValue = teacherObj.getFirstName().toLowerCase()+teacherObj.getLastName().toLowerCase()+teacherObj.getId().toLowerCase()+teacherObj.getPhoneNum().toLowerCase()+teacherObj.getStatus().toLowerCase();
            }
            
            if(cellValue.contains(filterField.getText().toLowerCase())){
                tableItem.add(teacherObj);
            }
            table.setItems(tableItem);
        }
    }
    
}
