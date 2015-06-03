/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author JAVA M2
 */
public class CenterPro {
    
    
    private ScrollPane scp;
    private static Stage CenterProStage;
//    private Button edit;
    public CenterPro(){
        
        CenterProStage = new Stage();
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(25,20,50,20));
        gridPane.setHgap(15); gridPane.setVgap(15);
        Scene scene = new Scene(gridPane, 480, 708);
        gridPane.setStyle("-fx-background-color: skyblue, derive(skyblue, 10%)");
        
        FlowPane text = new FlowPane();
        text.setPrefSize(400, 658);
        
        
        
        
        Label nameLbl = new Label("Багшын мэдлээл");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(200, 60);
        
        nameLbl.setFont(javafx.scene.text.Font.font("Arial",FontWeight.BOLD, 20));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        gridPane.add(nameLbl, 1,0, 2,1);
       
        
        Label labelClass = new Label("Class:");
        labelClass.setPrefWidth(80);
        
        
        ComboBox comboClass = new ComboBox();
        comboClass.setPrefSize(120,10);
        comboClass.getItems().addAll("JAVA","C#", "GENRAL LEVEL");
        comboClass.setValue("JAVA");
        comboClass.setId("content_label");
        comboClass.setEditable(false);
        comboClass.getSelectionModel().select(0);
        comboClass.setDisable(true);
       
        gridPane.add(labelClass, 1, 1);
        gridPane.add(comboClass, 2, 1);    
       
       
        Label comboText = new Label("Зэрэг");
        comboText.setPrefWidth(80);
                        
        final ComboBox comboBox = new ComboBox();
        comboBox.setPrefSize(120, 10);
        comboBox.getItems().addAll("Баклафар","Магистер" ,"Доктор");
        comboBox.getSelectionModel().select(1);
        comboBox.setEditable(false);
        comboBox.setDisable(true);
        gridPane.add(comboText, 1, 2);
        gridPane.add(comboBox, 2, 2);
        
        Label techID =new Label("БАГШ ID:");
        techID.setPrefWidth(80);
        
        TextField  techTx = new TextField();
        techTx.setPrefWidth(100);
        techTx.setEditable(false);
        techTx.setText("HGH90956asd");
        gridPane.add( techID, 3, 5,1,1);
        gridPane.add( techTx, 4,5,2,1);
          
        Label user = new Label("First name:");
        user.setPrefWidth(80);
        
        TextField userField = new TextField("");
        userField.setPrefWidth(100);
        userField.setEditable(false);
        userField.setText("Bataaa");
        gridPane.add(user, 1, 5);
        gridPane.add(userField, 2,5);
           
        Label lastName = new Label("Last name");
        lastName.setPrefWidth(80);
              
        TextField lastText =new TextField("");
        lastText.setPrefWidth(100);
        lastText.setEditable(false);
        lastText.setText("Тайван");
        gridPane.add(lastName, 1,6);   
        gridPane.add(lastText, 2, 6);
        
        Label genderText = new Label("Gender:");
        genderText.setPrefHeight(80);
            
        final ComboBox priorityComboBox = new ComboBox();
        priorityComboBox.setPrefSize(120, 10);
        priorityComboBox.getItems().addAll(
            "Man","Woman"
        );   
        priorityComboBox.setEditable(false); 
        priorityComboBox.getSelectionModel().select(0);
        priorityComboBox.setDisable(true);
        gridPane.add(genderText, 1, 7);
        gridPane.add(priorityComboBox, 2, 7);
        
        
        Label registerCode = new Label("Register code");
        registerCode.setPrefWidth(80);
      
        TextField codeText= new TextField ("");
        codeText.setPromptText("Input code");
        codeText.setPrefWidth(100);
        codeText.setEditable(false);
        codeText.setText("HE81011010");
        gridPane.add(registerCode, 1, 8);
        gridPane.add(codeText, 2, 8);
        
        Label address =new Label("Address");
        address.setPrefSize(80,10);
            
        TextField addressTxt = new TextField();
        addressTxt.setPrefWidth(100);
        addressTxt.setEditable(false);
        addressTxt.setText("Баянгол дүүрэг 16 хороо");
        gridPane.add(address, 1, 9);
        gridPane.add(addressTxt, 2, 9);
        
        Label email = new Label("E-mail address");
        email.setPrefWidth(80);
         
        TextField emailText = new TextField("");
        emailText.setPrefWidth(100);
        emailText.setEditable(false);
        emailText.setText("Bolboo99@yahoo.com");
        gridPane.add(email, 1, 10);
        gridPane.add(emailText, 2, 10);
   
        
        Label conn = new Label("Mobile Number");
        conn.setPrefWidth(80);    
        
        TextField connTxt = new TextField();
        connTxt.setPrefWidth(80);
        connTxt.setEditable(false);
        connTxt.setText("96030303");
        gridPane.add(conn, 1, 11);
        gridPane.add(connTxt, 2, 11);
                           
       
        ImageView image = new ImageView();
        image.setFitHeight(120);
        image.setFitWidth(150);
        
        Image image_1 =new Image(CenterPro.class.getResourceAsStream("images.jpg"));
        image.setImage(image_1);
        gridPane.add(image, 4, 1,1,4);
        
//        text.getChildren().addAll(gridPane);
//        text.setId("panel");
        
   
        Button edit = new Button("Засах");
        edit.setVisible(false);
        edit.setPrefSize(100 , 60);
        edit.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(edit, 4,15);
        edit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (edit.isVisible()) {
                    edit.setVisible(true);
                    
                } 
                else { 
                    
                    edit.setVisible(false);
                }
            }
        });
        
 
        scp = new ScrollPane(gridPane);
//        gridPane.getChildren().addAll( edit, cancel);
    }
    public ScrollPane getContainer() {
        return this.scp;
    }
      
    
    
    public static Stage getLogoutStage() {
        return CenterProStage;
    }
}
