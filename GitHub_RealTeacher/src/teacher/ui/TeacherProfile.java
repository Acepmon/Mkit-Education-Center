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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import teacher.controller.ServerConnection;
import teacher.launch.Launcher;
import teacher.login.ui.CustomerLogin;

/**
 *
 * @author JAVA M2
 */
public class TeacherProfile {

    private GridPane gridPane;
    private String imageName;
    private VBox text;
//    private Button edit;

    public TeacherProfile() {

        gridPane = new GridPane();
        gridPane.setPadding(new Insets(0, 0, 26, 0));

        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setStyle("-fx-background-color: white;");
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setMaxWidth(600);

        text = new VBox();
        text.setPadding(Insets.EMPTY);
        text.setAlignment(Pos.TOP_CENTER);
        text.setStyle("-fx-background-color: white");
        text.setMinSize(teacher.config.Config.STAGE_WIDTH, teacher.config.Config.STAGE_HEIGHT);

        Label nameLbl = new Label("Багшын мэдээлэл");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(teacher.config.Config.STAGE_WIDTH, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");

        Label labelClass = new Label("Class:");
        labelClass.setPrefWidth(80);

        ComboBox comboClass = new ComboBox();
        comboClass.setPrefSize(120, 10);
        comboClass.getItems().addAll("JAVA", "C#", "GENRAL LEVEL");
        comboClass.setValue("JAVA");
        comboClass.setEditable(false);
        comboClass.getSelectionModel().select(0);
        comboClass.setDisable(true);

        gridPane.add(labelClass, 1, 1);
        gridPane.add(comboClass, 2, 1);

        Label comboText = new Label("Зэрэг:");
        comboText.setPrefWidth(80);

        ComboBox comboBox = new ComboBox();
        comboBox.setPrefSize(120, 10);
        comboBox.getItems().addAll("Баклафар", "Магистер", "Доктор");
        comboBox.getSelectionModel().select(1);
        comboBox.setDisable(true);
        comboBox.setEditable(false);
        gridPane.add(comboText, 1, 2);
        gridPane.add(comboBox, 2, 2);

        Separator separator = new Separator();
        separator.setMaxWidth(120);
        separator.setMinWidth(120);
        Label questionLb = new Label("Хувийн мэдээлэл");
        questionLb.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        questionLb.setId("text");
        gridPane.add(questionLb, 1, 5, 2, 1);
        gridPane.add(separator, 1, 5, 1, 2);

        Label user = new Label("Овог:");
        user.setPrefWidth(80);

        TextField userField = new TextField("");
        userField.setPrefWidth(100);
        userField.setEditable(false);
        userField.setText("Bataaa");
        gridPane.add(user, 1, 6);
        gridPane.add(userField, 2, 6);

        Label lastName = new Label("Нэр:");
        lastName.setPrefWidth(80);

        TextField lastText = new TextField("");
        lastText.setPrefWidth(100);
        lastText.setEditable(false);
        lastText.setText("Тайван");
        gridPane.add(lastName, 1, 7);
        gridPane.add(lastText, 2, 7);

        Label registerCode = new Label("Регистерийн дугаар:");
        registerCode.setPrefWidth(150);

        TextField codeText = new TextField("");
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
                "Эр ", "Эм"
        );
        priorityComboBox.setEditable(false);
        priorityComboBox.getSelectionModel().select(0);
        priorityComboBox.setDisable(true);
        gridPane.add(genderText, 1, 9);
        gridPane.add(priorityComboBox, 2, 9);

        Label question1 = new Label("Холбоо барих:");
        question1.setId("text");
        question1.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Separator separator1 = new Separator();
        separator.setMaxWidth(120);
        separator.setMinWidth(120);
        gridPane.add(question1, 1, 10, 2, 1);
        gridPane.add(separator1, 1, 10, 1, 2);

        Label address = new Label("Гэрийн хаяг:");
        address.setPrefSize(100, 10);

        TextField addressTxt = new TextField();
        addressTxt.setEditable(false);
        addressTxt.setText("Баянгол дүүрэг 16 хороо");
        gridPane.add(address, 1, 11, 3, 1);
        gridPane.add(addressTxt, 2, 11, 3, 1);

        Label email = new Label("Е.майл хаяг:");
        email.setPrefWidth(100);

        TextField emailText = new TextField("");
        emailText.setEditable(false);
        emailText.setText("Bolboo99@yahoo.com");
        gridPane.add(email, 1, 12, 3, 1);
        gridPane.add(emailText, 2, 12, 3, 1);

        Label conn = new Label("Утасны дугаар:");
        conn.setPrefWidth(100);

        TextField connTxt = new TextField();
        connTxt.setEditable(false);
        connTxt.setText("96030303");
        gridPane.add(conn, 1, 13);
        gridPane.add(connTxt, 2, 13, 3, 1);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);

        Image imageChooser = new Image("teacher/resource/nobody.png");

        gridPane.add(imageView, 4, 1, 1, 6);

        Label techID = new Label("Багш ID:");
        techID.setPrefWidth(80);

        TextField techTx = new TextField();
        techTx.setPrefWidth(100);
        techTx.setEditable(false);
        techTx.setText("HGH90956asd");
        gridPane.add(techID, 3, 6, 1, 1);
        gridPane.add(techTx, 4, 6, 1, 1);

        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                imageView.setStyle("-fx-image-color:snow , derive(snow, 10%)");

            }
        });
        text.getChildren().addAll(nameLbl, gridPane);

        Button edit = new Button("Засах");
        edit.setVisible(false);
        edit.setPrefSize(100, 60);
        edit.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(edit, 3, 15, 2, 1);
        edit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (edit.isVisible()) {
                    edit.setVisible(true);
                } else {
                    edit.setVisible(false);
                }
            }
        });

        String profile = (String) ServerConnection.RequestAjluulah("getTeacherProfile", CustomerLogin.getTmp_username());
        System.out.println(profile);
        String id = "";
        for (int i = 0; i < profile.length(); i++) {
            String[] arr = profile.split("::");
            userField.setText(arr[1]);
            lastText.setText(arr[2]);
            addressTxt.setText(arr[4]);
            connTxt.setText(arr[6]);
            techTx.setText(arr[0]);
            emailText.setText(arr[5]);
            codeText.setText(arr[3]);
            id = arr[0];
        }
        imageView.setImage(new Image("file:\\\\\\" + Launcher.dirPath + "\\" + ServerConnection.RequestAjluulah("getTeacherImage", id).toString()));

    }

    public VBox getContainer() {
        return this.text;
    }
}
