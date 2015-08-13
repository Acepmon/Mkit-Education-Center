/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import teacher.launch.Launcher;

/**
 *
 * @author JAVA M2
 */
public class Duntoosoolol {

    FlowPane flow;
    Label totaldun, irts, idewhi, shalgalt, daalgawar;
    TextField irtstxf, idewhitxf, shalgalttxf, daalgawartxf;
    Button edit, edit1, edit2, edit3, save, save1, save2, save3, cancel, cancel1, cancel2, cancel3;
    public int label_width = 300;
    public Dunright dunright;

    private ObservableList<HBox> dunt_list_items;
    private ListView<HBox> duntoosoolol_list;
    private String tur_backup;

    public Duntoosoolol() {
        dunt_list_items = FXCollections.observableArrayList();

        HBox hbox = new HBox();
        hbox.setPrefWidth(750);

        HBox hbox1 = new HBox();
        hbox1.setPrefWidth(750);

        HBox hbox2 = new HBox();
        hbox2.setPrefWidth(750);

        HBox hbox3 = new HBox();
        hbox3.setPrefWidth(750);

        HBox hbox4 = new HBox();
        hbox4.setPrefWidth(750);

        flow = new FlowPane(40, 15);
        flow.setPadding(new Insets(10, 10, 10, 10));

        totaldun = new Label("Нэгтгэл дүн");
        totaldun.setPrefSize(750, 40);
        totaldun.setId("text");
        totaldun.setFont(javafx.scene.text.Font.font("Arial", 18));
        totaldun.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 5px;");
        totaldun.setAlignment(Pos.CENTER);

        irts = new Label("Ирц: ");
        irts.setPrefSize(250, 20);
        irts.setPadding(new Insets(0, 0, 0, 50));
        irts.setId("label");

        idewhi = new Label("Идэвхи: ");
        idewhi.setPrefSize(250, 20);
        idewhi.setPadding(new Insets(0, 0, 0, 50));
        idewhi.setId("label");

        shalgalt = new Label("Шалгалт: ");
        shalgalt.setPrefSize(250, 20);
        shalgalt.setPadding(new Insets(0, 0, 0, 50));
        shalgalt.setId("label");

        daalgawar = new Label("Даалгавар: ");
        daalgawar.setPrefSize(250, 20);
        daalgawar.setPadding(new Insets(0, 0, 0, 50));
        daalgawar.setId("label");

        irtstxf = new TextField("20");
        irtstxf.setPrefSize(70, 20);
        irtstxf.setEditable(false);
        tur_backup = irtstxf.getText();

        idewhitxf = new TextField("20");
        idewhitxf.setPrefSize(70, 20);
        tur_backup = idewhitxf.getText();

        shalgalttxf = new TextField("20");
        shalgalttxf.setPrefSize(70, 20);
        tur_backup = shalgalttxf.getText();

        daalgawartxf = new TextField("20");
        daalgawartxf.setPrefSize(70, 20);
        tur_backup = daalgawartxf.getText();

        save = new Button("Хадгалах");
        save.setVisible(false);
        save.setId("green");
        cancel = new Button("Болих");
        cancel.setVisible(false);
        cancel.setId("green");

        edit = new Button("Засах");
        edit.setPrefSize(100, 20);
        edit.setId("green");

        save1 = new Button("Хадгалах");
        save1.setVisible(false);
        save1.setId("green");
        cancel1 = new Button("Болих");
        cancel1.setVisible(false);
        cancel1.setId("green");

        edit1 = new Button("Засах");
        edit1.setPrefSize(100, 20);
        edit1.setId("green");

        save2 = new Button("Хадгалах");
        save2.setVisible(false);
        save2.setId("green");
        cancel2 = new Button("Болих");
        cancel2.setVisible(false);
        cancel2.setId("green");

        edit2 = new Button("Засах");
        edit2.setPrefSize(100, 20);
        edit2.setId("green");

        save3 = new Button("Хадгалах");
        save3.setVisible(false);
        save3.setId("green");
        cancel3 = new Button("Болих");
        cancel3.setVisible(false);
        cancel3.setId("green");

        edit3 = new Button("Засах");
        edit3.setPrefSize(100, 20);
        edit3.setId("green");

        TextField namef = new TextField();
        namef.setPrefSize(0, 0);
        namef.setVisible(false);
        namef.setEditable(false);

        TextField namef1 = new TextField();
        namef1.setPrefSize(0, 0);
        namef1.setVisible(false);
        namef1.setEditable(false);

        TextField namef2 = new TextField();
        namef2.setPrefSize(0, 0);
        namef2.setVisible(false);
        namef2.setEditable(false);

        TextField namef3 = new TextField();
        namef3.setPrefSize(0, 0);
        namef3.setVisible(false);
        namef3.setEditable(false);

        edit.setOnAction(ae -> {

            tur_backup = irtstxf.getText();
            irtstxf.setEditable(true);
            edit.setVisible(false);
            save.setVisible(true);
            cancel.setVisible(true);

            String nameTf = irts.getText();
            namef.setText(nameTf);
            namef.setPrefSize(250, 20);
            namef.setVisible(true);
            namef.setEditable(true);
            irts.setPrefSize(0, 0);
            irts.setVisible(false);

        });

        save.setOnAction((event) -> {
            irtstxf.setEditable(false);
            save.setVisible(false);
            edit.setVisible(true);
            cancel.setVisible(false);

            String nameLb = namef.getText();
            irts.setText(nameLb);
            irts.setPrefSize(250, 20);
            irts.setVisible(true);
            namef.setPrefSize(0, 0);
            namef.setVisible(false);

        });

        cancel.setOnAction((event) -> {
            irtstxf.setText(tur_backup);
            save.setVisible(false);
            cancel.setVisible(false);
            edit.setVisible(true);
            irtstxf.setEditable(false);

            namef.setPrefSize(0, 0);
            namef.setVisible(false);
            String backup = irts.getText();
            irts.setText(backup);
            irts.setPrefSize(250, 20);
            irts.setVisible(true);
        });

        edit1.setOnAction(ae -> {

            tur_backup = idewhitxf.getText();
            idewhitxf.setEditable(true);
            edit1.setVisible(false);
            save1.setVisible(true);
            cancel1.setVisible(true);

            String nameTf = idewhi.getText();
            namef1.setText(nameTf);
            namef1.setPrefSize(250, 20);
            namef1.setVisible(true);
            namef1.setEditable(true);
            idewhi.setPrefSize(0, 0);
            idewhi.setVisible(false);

        });

        save1.setOnAction((event) -> {
            idewhitxf.setEditable(false);
            save1.setVisible(false);
            edit1.setVisible(true);
            cancel1.setVisible(false);

            String nameLb = namef1.getText();
            idewhi.setText(nameLb);
            idewhi.setPrefSize(250, 20);
            idewhi.setVisible(true);
            namef1.setPrefSize(0, 0);
            namef1.setVisible(false);
        });

        cancel1.setOnAction((event) -> {
            idewhitxf.setText(tur_backup);
            save1.setVisible(false);
            cancel1.setVisible(false);
            edit1.setVisible(true);
            idewhitxf.setEditable(false);

            namef1.setPrefSize(0, 0);
            namef1.setVisible(false);
            String backup = idewhi.getText();
            idewhi.setText(backup);
            idewhi.setPrefSize(250, 20);
            idewhi.setVisible(true);
        });

        edit2.setOnAction(ae -> {

            tur_backup = shalgalttxf.getText();
            shalgalttxf.setEditable(true);
            edit2.setVisible(false);
            save2.setVisible(true);
            cancel2.setVisible(true);

            String nameTf = shalgalt.getText();
            namef2.setText(nameTf);
            namef2.setPrefSize(250, 20);
            namef2.setVisible(true);
            namef2.setEditable(true);
            shalgalt.setPrefSize(0, 0);
            shalgalt.setVisible(false);

        });

        save2.setOnAction((event) -> {
            shalgalttxf.setEditable(false);
            save2.setVisible(false);
            edit2.setVisible(true);
            cancel2.setVisible(false);

            String nameLb = namef2.getText();
            shalgalt.setText(nameLb);
            shalgalt.setPrefSize(250, 20);
            shalgalt.setVisible(true);
            namef2.setPrefSize(0, 0);
            namef2.setVisible(false);
        });

        cancel2.setOnAction((event) -> {
            shalgalttxf.setText(tur_backup);
            save2.setVisible(false);
            cancel2.setVisible(false);
            edit2.setVisible(true);
            shalgalttxf.setEditable(false);

            namef2.setPrefSize(0, 0);
            namef2.setVisible(false);
            String backup = shalgalt.getText();
            shalgalt.setText(backup);
            shalgalt.setPrefSize(250, 20);
            shalgalt.setVisible(true);

        });

        edit3.setOnAction(ae -> {

            tur_backup = daalgawartxf.getText();
            daalgawartxf.setEditable(true);
            edit3.setVisible(false);
            save3.setVisible(true);
            cancel3.setVisible(true);

            String nameTf = daalgawar.getText();
            namef3.setText(nameTf);
            namef3.setPrefSize(250, 20);
            namef3.setVisible(true);
            namef3.setEditable(true);
            daalgawar.setPrefSize(0, 0);
            daalgawar.setVisible(false);

        });

        save3.setOnAction((event) -> {
            daalgawartxf.setEditable(false);
            save3.setVisible(false);
            edit3.setVisible(true);
            cancel3.setVisible(false);

            String nameLb = namef3.getText();
            daalgawar.setText(nameLb);
            daalgawar.setPrefSize(250, 20);
            daalgawar.setVisible(true);
            namef3.setPrefSize(0, 0);
            namef3.setVisible(false);
        });

        cancel3.setOnAction((event) -> {
            daalgawartxf.setText(tur_backup);
            save3.setVisible(false);
            cancel3.setVisible(false);
            edit3.setVisible(true);
            daalgawartxf.setEditable(false);

            namef3.setPrefSize(0, 0);
            namef3.setVisible(false);
            String backup = daalgawar.getText();
            daalgawar.setText(backup);
            daalgawar.setPrefSize(250, 20);
            daalgawar.setVisible(true);
        });

        hbox.getChildren().addAll(totaldun);

        hbox1.getChildren().addAll(namef, irts, irtstxf, edit, save, cancel);
        hbox1.setSpacing(10);

        hbox2.getChildren().addAll(namef1, idewhi, idewhitxf, edit1, save1, cancel1);
        hbox2.setSpacing(10);

        hbox3.getChildren().addAll(namef2, shalgalt, shalgalttxf, edit2, save2, cancel2);
        hbox3.setSpacing(10);

        hbox4.getChildren().addAll(namef3, daalgawar, daalgawartxf, edit3, save3, cancel3);
        hbox4.setSpacing(10);

        dunt_list_items.addAll(hbox, hbox1, hbox2, hbox3, hbox4);
        duntoosoolol_list = new ListView<>(dunt_list_items);
        duntoosoolol_list.setPrefWidth(750);

        dunright = new Dunright();

        flow.getChildren().add(duntoosoolol_list);

    }

    public FlowPane getContainer() {
        return this.flow;
    }

    public class Dunright {

        private FlowPane flow2;

        public Dunright() {

            flow2 = new FlowPane(0, 2);
            flow2.setMaxSize(250, 708);
            flow2.setStyle("-fx-background-color: #FFFFFF");
            flow2.setAlignment(Pos.TOP_CENTER);

            Label negtgel = new Label("Нэгтгэл дүн");
            negtgel.setPrefSize(label_width, 80);
            negtgel.setPadding(new Insets(5, 0, 0, 10));
            negtgel.setId("lols");

            negtgel.setFont(javafx.scene.text.Font.font("Arial", 12));
            negtgel.setOnMousePressed(ae -> {

                TeacherMain.changeCenter(Launcher.getDUNTOOSOOLOL().getContainer());
                TeacherMain.changeRight(Launcher.getDUNRIGHT().getContainer());

            });

            Label irtsr = new Label("Ирц");
            irtsr.setPrefSize(label_width, 80);
            irtsr.setPadding(new Insets(5, 0, 0, 10));
            irtsr.setId("lols");
            irtsr.setFont(javafx.scene.text.Font.font("Arial", 12));
            irtsr.setOnMousePressed(ae -> {

                TeacherMain.changeCenter(Launcher.getDUNTOOTSOO_IRTS().getContainer());
                TeacherMain.changeRight(Launcher.getDUNRIGHT().getContainer());

            });

            Label idewhir = new Label("Идэвхи");
            idewhir.setPrefSize(label_width, 80);
            idewhir.setPadding(new Insets(5, 0, 0, 10));
            idewhir.setId("lols");
            idewhir.setFont(javafx.scene.text.Font.font("Arial", 12));
            idewhir.setOnMousePressed(ae -> {

                TeacherMain.changeCenter(Launcher.getDUNTOOTSOO_IDEWHI().getContainer());
                TeacherMain.changeRight(Launcher.getDUNRIGHT().getContainer());

            });

            Label shalgaltr = new Label("Шалгалт");
            shalgaltr.setPrefSize(label_width, 80);
            shalgaltr.setPadding(new Insets(5, 0, 0, 10));
            shalgaltr.setId("lols");
            shalgaltr.setFont(javafx.scene.text.Font.font("Arial", 12));
            shalgaltr.setOnMousePressed(ae -> {

                TeacherMain.changeCenter(Launcher.getDUNTOOTSOO_SHALGALT().getContainer());
                TeacherMain.changeRight(Launcher.getDUNRIGHT().getContainer());
            });

            Label daalgawarr = new Label("Даалгавар");
            daalgawarr.setPrefSize(label_width, 80);
            daalgawarr.setPadding(new Insets(5, 0, 0, 10));
            daalgawarr.setId("lols");
            daalgawarr.setFont(javafx.scene.text.Font.font("Arial", 12));
            daalgawarr.setOnMousePressed(ae -> {

                TeacherMain.changeCenter(Launcher.getDUNTOOTSOO_DAALGAWAR().getContainer());
                TeacherMain.changeRight(Launcher.getDUNRIGHT().getContainer());

            });

            flow2.getChildren().addAll(negtgel, irtsr, idewhir, shalgaltr, daalgawarr);
        }

        public FlowPane getContainer() {
            return this.flow2;
        }
    }

}
