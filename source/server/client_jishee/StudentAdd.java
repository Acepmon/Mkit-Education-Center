package client_jishee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class StudentAdd {
   static Label lb1, lb2, lb3 , lb4 , lb5, lb6 , lb7 , lb8, lb9;
   static TextField ovog , ner , utas , toloh, tolson , ehleh, duusah;
   static  ComboBox<String> cmbsex;
   static  ComboBox<String> cmb;
    
    public static void studentnemeh(){
        Stage stage = new Stage();
        stage.setTitle("Оюутан нэмэх");
        FlowPane root = new FlowPane(100,10);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,350,410);
        stage.setScene(scene);

        lb1 = new Label ("Овог:           ");
        lb2 = new Label ("Нэр:            ");
        lb3 = new Label ("Хүйс            ");
        lb4 = new Label ("Утас:           ");
        lb5 = new Label ("Сурах төрөл:    ");
        lb6 = new Label ("Төлөх төлбөр:   ");
        lb7 = new Label ("Төлсөн төлбөр:  ");
        lb8 = new Label ("Эхлэх хугацаа:  ");
        lb9 = new Label ("Дуусах хугацаа: ");
        
        ovog = new TextField();
        ner = new TextField();
        utas = new TextField();
        toloh = new TextField();
        tolson = new TextField();
        ehleh = new TextField();
        duusah = new TextField();
        ObservableList<String> huisuud = FXCollections.observableArrayList("eregtei", "emegtei");
        ObservableList<String> torluud = FXCollections.observableArrayList("aerobic","bodybuilding","fitness");
        cmbsex = new ComboBox<>(huisuud);
        cmbsex.setPrefWidth(150);
        cmb = new ComboBox<>(torluud);
        cmb.setPrefWidth(150);
        
        Button btn = new Button("Нэмэх");
        btn.setOnAction((ActionEvent ae)->{
            String ovogutga = ovog.getText();
            String nerutga =  ner.getText();
            int huisutga = cmbsex.getSelectionModel().getSelectedIndex()+1;
            String utasutga = utas.getText();
            int torolutga = cmb.getSelectionModel().getSelectedIndex()+1;
            String tolohutga = toloh.getText();
            String tolsonutga = tolson.getText();
            String ehlehutga = ehleh.getText();
            String duusahutga = duusah.getText();
            String query ="insert into user values ("+null+",'"+ovogutga+"','"+nerutga+"','"+huisutga+"','"+utasutga+"','"+torolutga+"','"+tolohutga+"','"+tolsonutga+"','"+ehlehutga+"','"+duusahutga+"')";
           // ResultSet result = DatabaseTools.runQuery(query);
            query = "select * from fitness.user order by id desc limit 1";
         //   result = DatabaseTools.runQuery(query);

            JOptionPane.showMessageDialog(null, "Амжилттай нэмэгдлээ");
            
//            ObservableList<String> row = FXCollections.observableArrayList();
//            try {
//                while (result.next()) {
//                    row.add(result.getString(1));
//                    row.add(result.getString(2));
//                    row.add(result.getString(3));
//                    row.add(result.getString(4));
//                    row.add(result.getString(5));
//                    row.add(result.getString(6));
//                    row.add(result.getString(7));
//                    row.add(result.getString(8));
//                    row.add(result.getString(9));
//                    row.add(result.getString(10));
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(StudentAdd.class.getName()).log(Level.SEVERE, null, ex);
//            }
//               // BodyFX.data.add(row);
//                stage.close();
        });
        btn.setPrefSize(100, 30);
        root.getChildren().addAll(lb1,ovog,lb2,ner,lb3,cmbsex,lb4,utas,lb5,cmb,lb6,toloh,lb7, tolson, lb8, ehleh,lb9,duusah, btn);
        stage.show();
    }
}

