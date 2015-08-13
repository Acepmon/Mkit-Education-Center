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
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import teacher.controller.ServerConnection;
import teacher.login.ui.CustomerLogin;

/**
 *
 * @author JAVA M2
 */
public class DunTootsooIrts {

    FlowPane flow;
    Label totaldun, irts, idewhi, shalgalt, daalgawar;
    TextField irtstxf, idewhitxf, shalgalttxf, daalgawartxf;
    Button edit, edit1, edit2, edit3, save, save1, save2, save3, cancel, cancel1, cancel2, cancel3, add;
    public int label_width = 300;

    private ObservableList<HBox> dunt_list_items;
    private ListView<HBox> duntoosoolol_list;
    private String tur_backup;
    
    private HBox hbox, hbox5;

    public DunTootsooIrts() {
        dunt_list_items = FXCollections.observableArrayList();

        hbox = new HBox();
        hbox.setPrefWidth(750);

        hbox5 = new HBox();
        hbox5.setPrefWidth(750);

        flow = new FlowPane(40, 15);
        flow.setPadding(new Insets(10, 10, 10, 10));

        totaldun = new Label("Ирцийн дүн");
        totaldun.setPrefSize(750, 40);
        totaldun.setId("text");
        totaldun.setFont(javafx.scene.text.Font.font("Arial", 18));
        totaldun.setStyle("-fx-background-color: #E6E6E6; -fx-padding:6px;");
        totaldun.setAlignment(Pos.CENTER);

        add = new Button("Нэмэх");
        add.setPrefSize(100, 20);
        add.setId("green");
        add.setOnAction(ae -> {

            start1(new Stage());
        });

        hbox.getChildren().add(totaldun);

        hbox5.getChildren().add(add);

        dunt_list_items.addAll(hbox, hbox5);
        duntoosoolol_list = new ListView<>(dunt_list_items);
        duntoosoolol_list.setPrefWidth(750);

        refreshList();

        flow.getChildren().add(duntoosoolol_list);

    }
    
    private void refreshList() {
        dunt_list_items.clear();
        dunt_list_items.addAll(hbox, hbox5);
        ArrayList<String> irtsArray = (ArrayList<String>) ServerConnection.RequestAjluulah("getIrtsStatus", CustomerLogin.getTmp_username());
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        for (String asd : irtsArray) {

            HBox splitHb = new HBox();
            splitHb.setPrefWidth(750);

            String[] split = asd.split("::");
            String id = split[0];
            String status = split[1];
            String point = split[2];

            Label splitL = new Label(status);
            splitL.setPrefSize(250, 20);
            splitL.setPadding(new Insets(0, 0, 0, 50));
            splitL.setId("label");

            TextField splitTf = new TextField(point);
            splitTf.setPrefSize(70, 20);
            splitTf.setEditable(false);

            Button splitBsave = new Button("Хадгалах");
            splitBsave.setVisible(false);
            splitBsave.setId("green");
            Button splitBcancel = new Button("Болих");
            splitBcancel.setVisible(false);
            splitBcancel.setId("green");

            Button splitBedit = new Button("Засах");
            splitBedit.setPrefSize(100, 20);
            splitBedit.setId("green");

            TextField splitnamef = new TextField(status);
            splitnamef.setPrefSize(0, 0);
            splitnamef.setVisible(false);
            splitnamef.setEditable(false);

            splitBedit.setOnAction((event) -> {

                String split_backUp = splitTf.getText();
                split_backUp = splitTf.getText();
                splitTf.setEditable(true);
                splitBedit.setVisible(false);
                splitBsave.setVisible(true);
                splitBcancel.setVisible(true);

                String nameTf = splitnamef.getText();
                splitnamef.setText(nameTf);
                splitnamef.setPrefSize(250, 20);
                splitnamef.setVisible(true);
                splitnamef.setEditable(true);
                splitL.setPrefSize(0, 0);
                splitL.setVisible(false);
                
                

            });

            splitBsave.setOnAction((event) -> {
                splitTf.setEditable(false);
                splitBsave.setVisible(false);
                splitBedit.setVisible(true);
                splitBcancel.setVisible(false);

                String nameLb = splitnamef.getText();
                splitL.setText(nameLb);
                splitL.setPrefSize(250, 20);
                splitL.setVisible(true);
                splitnamef.setPrefSize(0, 0);
                splitnamef.setVisible(false);

                System.out.println("sadfasdlkgbashdvgjdsagnkjsabdgkjashbgjnfsabgkljbavvbsgbjkasfdg");
                System.out.println(id);
                System.out.println(nameLb);
                System.out.println(splitTf.getText());
                System.out.println("IDDDD:: "+id);
                
                ServerConnection.RequestAjluulah("updateIrtsStatus", id + "::" + nameLb + "::" + splitTf.getText() + "::" + CustomerLogin.getTmp_username());
                refreshList();
            });

            String split_backUp = splitTf.getText();
            splitBcancel.setOnAction((event) -> {

                splitTf.setText(split_backUp);
                splitBsave.setVisible(false);
                splitBcancel.setVisible(false);
                splitBedit.setVisible(true);
                splitTf.setEditable(false);

                splitnamef.setPrefSize(0, 0);
                splitnamef.setVisible(false);
                String backup = splitL.getText();
                splitnamef.setText(backup);
                splitL.setPrefSize(250, 20);
                splitL.setVisible(true);
            });

            Button deleteB = new Button("Устгах");
            deleteB.setPrefSize(80, 20);
            deleteB.setId("green");
            deleteB.setOnAction((event) -> {
                String error = ServerConnection.RequestAjluulah("deleteIrtsStatus", id).toString();
                System.out.println(error);
                if (error != null) {
                    if (error.equals("error")) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Алдаа гарлаа");
                        alert.setHeaderText("Ашиглаж буй сурагч байна");
                        alert.setContentText("Энэ мэдээллийг сурагч ашиглаж байгаа тул та засах юм уу шинээр оруулна уу!");

                        alert.showAndWait();
                    }
                }
                refreshList();
            });

            splitHb.setSpacing(10);
            splitHb.getChildren().addAll(deleteB, splitnamef, splitL, splitTf, splitBedit, splitBsave, splitBcancel);

            dunt_list_items.add(splitHb);

        }
    }

    public FlowPane getContainer() {
        return this.flow;
    }

    public void start1(Stage yourStage) {

        yourStage.setTitle("Ирц оруулах");
        FlowPane rootNode = new FlowPane(30, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 1000, 80);
        yourStage.setScene(myScene);
        yourStage.setResizable(false);

        TextField txt = new TextField();
        txt.setPromptText("Ирсэн");
        txt.setPrefSize(150, 20);
        TextField txt1 = new TextField();
        txt1.setPromptText("5");
        txt1.setPrefSize(150, 20);
        Button add1 = new Button("Оруулах");
        add1.setPrefSize(150, 20);
        Button cancel = new Button("Болих");
        cancel.setPrefSize(150, 20);

        Label lab = new Label("Ирц");
        lab.setPrefSize(250, 20);
        lab.setAlignment(Pos.BASELINE_LEFT);
        lab.setPadding(new Insets(0, 0, 0, 160));
        Label lab1 = new Label("Дүгнэх байдал");
        lab1.setPrefSize(150, 20);
        lab1.setPadding(new Insets(0, 0, 0, 35));
        lab1.setAlignment(Pos.BASELINE_LEFT);

        FlowPane asd = new FlowPane(60, 10);
        asd.getChildren().addAll(lab, lab1);
        asd.setPrefSize(1000, 20);
        asd.setAlignment(Pos.BASELINE_LEFT);

        add1.setOnAction(ae -> {
            
            String id = "" + (Integer.parseInt((String) ServerConnection.RequestAjluulah("getLatestIrtsId", null)) + 1);
            String name = txt.getText();
            String onoo = txt1.getText();

            Label namel = new Label(name);
            namel.setPrefSize(250, 20);
            namel.setPadding(new Insets(0, 0, 0, 50));
            namel.setId("label");

            TextField onool = new TextField(onoo);
            onool.setPrefSize(70, 20);
            onool.setEditable(false);
            tur_backup = onool.getText();

            Button editB = new Button("Засах");
            Button saveB = new Button("Хадгалах");
            Button cancelB = new Button("Болих");

            cancelB.setVisible(false);

            saveB.setVisible(false);
            saveB.setId("green");

            cancelB.setId("green");

            editB.setPrefSize(100, 20);
            editB.setId("green");

            TextField namef = new TextField();
            namef.setPrefSize(0, 0);
            namef.setVisible(false);
            namef.setEditable(false);

            ServerConnection.RequestAjluulah("insertIrtsStatus", txt.getText() + "::" + txt1.getText() + "::" + CustomerLogin.getTmp_username());

            yourStage.close();
            refreshList();
        });

        cancel.setOnAction(ae -> {

            yourStage.close();
        });

        rootNode.getChildren().addAll(asd, txt, txt1, add1, cancel);

        yourStage.show();
    }
}
