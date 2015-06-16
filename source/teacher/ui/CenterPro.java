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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author JAVA M2
 */
public class CenterPro {
    
    
    private GridPane gridPane;
//    private Button edit;
    public CenterPro(){
        
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(0,0,26,0));
       
        gridPane.setHgap(15); gridPane.setVgap(15);
        gridPane.setPrefSize(524, 800);
        gridPane.setStyle("-fx-background-color: snow;");
        
        FlowPane text = new FlowPane();
//        text.setPrefSize(250, 500);
        
        Label nameLbl = new Label("Багшын мэдээлэл");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(524, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        gridPane.add(nameLbl, 0,0, 8,1);
              
        Label labelClass = new Label("Class:");
        labelClass.setPrefWidth(80);
                
        ComboBox comboClass = new ComboBox();
        comboClass.setPrefSize(120,10);
        comboClass.getItems().addAll("JAVA","C#", "GENRAL LEVEL");
        comboClass.setValue("JAVA");
//        comboClass.setId("content_label");
        comboClass.setEditable(false);
        comboClass.getSelectionModel().select(0);
        comboClass.setDisable(true);
       
        gridPane.add(labelClass, 1, 1);
        gridPane.add(comboClass, 2, 1);    
       
        Label comboText = new Label("Зэрэг:");
        comboText.setPrefWidth(80);
                        
        ComboBox comboBox = new ComboBox();
        comboBox.setPrefSize(120, 10);
        comboBox.getItems().addAll("Баклафар","Магистер" ,"Доктор");
        comboBox.getSelectionModel().select(1);
        comboBox.setDisable(true);
        comboBox.setEditable(false);
        gridPane.add(comboText, 1, 2);
        gridPane.add(comboBox, 2, 2);    
                            
        Separator separator = new Separator();
        separator.setMaxWidth(120);
        separator.setMinWidth(120);
        Label questionLb = new Label("Хувийн мэдээлэл"); 
        questionLb.setFont(Font.font("Arial",FontWeight.BOLD,14));
        questionLb.setId("text");
        gridPane.add(questionLb , 1,5,2,1);
        gridPane.add(separator , 1,5,1,2);
       
          
        Label user = new Label("Овог:");
        user.setPrefWidth(80);
        
        TextField userField = new TextField("");
        userField.setPrefWidth(100);
        userField.setEditable(false);
        userField.setText("Bataaa");
        gridPane.add(user, 1, 6);
        gridPane.add(userField, 2,6);
           
        Label lastName = new Label("Нэр:");
        lastName.setPrefWidth(80);
              
        TextField lastText =new TextField("");
        lastText.setPrefWidth(100);
        lastText.setEditable(false);
        lastText.setText("Тайван");
        gridPane.add(lastName, 1,7);   
        gridPane.add(lastText, 2, 7);
        
        Label registerCode = new Label("Регистерийн дугаар:");
        registerCode.setPrefWidth(150);
      
        TextField codeText= new TextField ("");
        codeText.setPromptText("Дугаараа хийнэ үү");
        codeText.setPrefWidth(100);
        codeText.setEditable(false);
        codeText.setText("HE81011010");
        gridPane.add(registerCode, 1, 8);
        gridPane.add(codeText, 2, 8);
        
        Label genderText = new Label("Хүйс:");
        genderText.setPrefHeight(80);
            
        ComboBox priorityComboBox = new ComboBox();
        priorityComboBox.setPrefSize(120, 10);
        priorityComboBox.getItems().addAll(
            "Эр ","Эм"
        );   
        priorityComboBox.setEditable(false); 
        priorityComboBox.getSelectionModel().select(0);
        priorityComboBox.setDisable(true);
        gridPane.add(genderText, 1, 9);
        gridPane.add(priorityComboBox, 2, 9);
        
        
        
        
        Label question1 = new Label("Холобоо барих:"); 
        question1.setId("text");
        question1.setFont(Font.font("Arial",FontWeight.BOLD,14));
        
        
        Separator separator1 = new Separator();
        separator.setMaxWidth(120);
        separator.setMinWidth(120);
        gridPane.add(question1 , 1,10,2,1);
        gridPane.add(separator1 , 1,10,1,2);
        
        Label address =new Label("Гэрийн хаяг:");
        address.setPrefSize(100,10);
            
        TextField addressTxt = new TextField();
        addressTxt.setEditable(false);
        addressTxt.setText("Баянгол дүүрэг 16 хороо");
        gridPane.add(address, 1, 11,3,1);
        gridPane.add(addressTxt, 2, 11,3,1);
        
        Label email = new Label("Е.майл хаяг:");
        email.setPrefWidth(100);
         
        TextField emailText = new TextField("");
        emailText.setEditable(false);
        emailText.setText("Bolboo99@yahoo.com");
        gridPane.add(email, 1, 12,3,1);
        gridPane.add(emailText, 2, 12,3,1);
   
        
        Label conn = new Label("Утасны дугаар:");
        conn.setPrefWidth(100);    
        
        TextField connTxt = new TextField();
        connTxt.setEditable(false);
        connTxt.setText("96030303");
        gridPane.add(conn, 1, 13);
        gridPane.add(connTxt, 2, 13,3,1);
                           
       
        ImageView image = new ImageView();
        image.setFitHeight(120);
        image.setFitWidth(120);
        
        Image image_1 =new Image("teacher/resource/images.jpg");
        image.setImage(image_1);
        gridPane.add(image, 4, 1,1,6);
        
          
        Label techID =new Label("Багш ID:");
        techID.setPrefWidth(80);
        
        TextField  techTx = new TextField();
        techTx.setPrefWidth(100);
        techTx.setEditable(false);
        techTx.setText("HGH90956asd");
        gridPane.add( techID, 3, 6,1,1);
        gridPane.add( techTx, 4,6,1,1);
        
        image.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                image.setStyle("-fx-image-color:snow , derive(snow, 10%)");
            }
        });
        text.getChildren().addAll(gridPane);
        text.setId("panel");
        
   
        Button edit = new Button("Засах");
        edit.setVisible(false);
        edit.setPrefSize(100 , 60);
        edit.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(edit, 3,15,2,1);
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
        
        
       
    }
    public GridPane getContainer() {
        return this.gridPane;
    }
}
