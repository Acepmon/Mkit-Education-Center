/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import teacher.controller.ServerConnection;
import teacher.launch.Launcher;
import teacher.login.ui.CustomerLogin;

public class DaalgavarShalgahDunOruulah {

    TextField tf2, tf3;
    Label label, label2, label3;

    public void start(Stage myStage) {
        ArrayList<String> resd = (ArrayList<String>) ServerConnection.RequestAjluulah("getDaalgavarStatus", CustomerLogin.getTmp_username());
        ArrayList<String> resdn = (ArrayList<String>) ServerConnection.RequestAjluulah("getTeacherStudentProfile", CustomerLogin.getTmp_username());
        myStage.setTitle("Дүн оруулах");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 270, 220);
        myScene.getStylesheets().add(getClass().getResource("style/mainStyle.css").toExternalForm());
        myStage.setScene(myScene);

        label = new Label(" Нэр             :  ");

        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Болд",
                        "bat",
                        "Бөгс",
                        "Бөгс2"
                );
        ComboBox comboBox = new ComboBox(options);
        ObservableList<String> nersn = FXCollections.observableArrayList();
        for (String str : resdneesNerSalgah(resdn)) {
            nersn.add(str);
        }
        comboBox.setItems(nersn);
        comboBox.setValue("lastname");
        comboBox.setMaxWidth(140);
        ObservableList<String> options2
                = FXCollections.observableArrayList();

        ComboBox comboBox2 = new ComboBox(options2);
        ObservableList<String> ners = FXCollections.observableArrayList();
        for (String str : resdeesNerSalgah(resd)) {
            ners.add(str);
        }
        comboBox2.setItems(ners);
        comboBox2.setMaxWidth(140);
        comboBox2.setValue("testingDaalgavar");
        comboBox2.setOnAction((event) -> {
            String songogdsonStatus = comboBox2.getSelectionModel().getSelectedItem().toString();
            for (int i = 0; i < resd.size(); i++) {
                if (songogdsonStatus.equals(resd.get(i).split("::")[1])) {
                    tf3.setText(resd.get(i).split("::")[2]);
                    break;
                }
            }

        });

        label2 = new Label("Даалгавар  :  ");
        tf2 = new TextField();
        tf2.setPromptText("Даалгаварын нэр:");
        tf2.setPrefColumnCount(12);
        label3 = new Label("Дүн             : ");
        tf3 = new TextField();
        tf3.setStyle("-fx-background-color: #8BC34A; -fx-text-fill: #FFFFFF; -fx-background-radius: 0.6em;");
        tf3.setPrefColumnCount(11);
        tf3.setEditable(false);

        ObservableList<String> onoos = FXCollections.observableArrayList();
        for (String str : resdeesNerSalgah(resd)) {
            onoos.add(str);
        }

        Button submit = new Button("Submit");
        submit.setId("green");
        submit.setOnAction((ActionEvent e) -> {
            String comboBoxValue = comboBox.getValue().toString();
            String comboBox2Value = comboBox2.getValue().toString();
            String tf3Value = tf3.getText().toString();
            String tot = "" + comboBoxValue + "::" + tf3Value + "::" + comboBox2Value;
            Launcher.getDAALGAVARSHALGAHDUN().resd.add(tot);
            Launcher.getDAALGAVARSHALGAHDUN().refreshTable();
            myStage.close();
        });

        Separator separator = new Separator();
        separator.setPrefWidth(250);
        rootNode.getChildren().addAll(label, comboBox, label2, comboBox2, label3, tf3, separator, submit);
        myStage.show();
    }

    private ArrayList<String> resdeesNerSalgah(ArrayList<String> resd) {
        ArrayList<String> ners = new ArrayList<>();
        for (String res : resd) {
            String[] split = res.split("::");
            boolean davhard = false;
            for (String ner : ners) {
                if (ner.equals(split[1])) {
                    davhard = true;
                }
            }
            if (davhard == false) {
                ners.add(split[1]);
            }
            System.out.print(ners);
        }
        return ners;
    }

    private ArrayList<String> resdeesOnooSalgah(ArrayList<String> resd) {
        ArrayList<String> onoos = new ArrayList<>();
        for (String res : resd) {
            String[] split = res.split("::");
            boolean davhard = false;
            for (String onoo : onoos) {
                if (onoo.equals(split[2])) {
                    davhard = true;
                }
            }
            if (davhard == false) {
                onoos.add(split[2]);
            }
            System.out.print(onoos);
        }
        return onoos;
    }

    private ArrayList<String> resdneesNerSalgah(ArrayList<String> resdn) {
        ArrayList<String> nersn = new ArrayList<>();
        for (String res : resdn) {
            String[] split = res.split("::");
            boolean davhard = false;
            for (String onoo : nersn) {
                if (onoo.equals(split[3])) {
                    davhard = true;
                }
            }
            if (davhard == false) {
                nersn.add(split[3]);
            }
            System.out.print(nersn);
        }
        return nersn;
    }
}
