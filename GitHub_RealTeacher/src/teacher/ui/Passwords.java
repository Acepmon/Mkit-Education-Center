/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui;

/**
 *
 * @author JAVA M2
 */
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import teacher.login.ui.CustomerLogin;

public class Passwords {

   
    public Passwords(Stage primaryStage) {
        primaryStage.setTitle("Тохиргоо");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 25, 25, 25));
        Scene scene = new Scene(grid, Color.WHITESMOKE);
        primaryStage.setMinHeight(250);
        primaryStage.setMinWidth(360);
        primaryStage.setMaxHeight(250);
        primaryStage.setMaxWidth(360);
//        scene.getStylesheets().add(getClass().getResource("style/mainStyle.css").toExternalForm());
        
        Text actiontarget = new Text();
        Text actiontargets = new Text();
        Text actiontarget1 = new Text();        
        Text actiontarget2 = new Text();             
        
        grid.add(actiontarget2, 0, 0);
        actiontarget2.setVisible(false);
        
        grid.add(actiontargets, 0, 0);
        actiontargets.setVisible(false);

        grid.add(actiontarget, 0, 5);
        actiontarget.setVisible(false);
        
        grid.add(actiontarget1, 0, 5);
        actiontarget1.setVisible(false);
//               
//     
//        Text scenetitle = new Text("Паспортоо солих");
//        scenetitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
//        grid.add(scenetitle, 0, 0, 2, 1);
//        scenetitle.setId("text");
//        
        
        Label current = new Label("  Хуучин паспорт: ");
        current.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        current.setPrefWidth(120);
        grid.add(current, 0, 1);

        PasswordField oldPass = new PasswordField();
        oldPass.setPrefWidth(180);
        oldPass.setPromptText("Хуучин паспортаа хийнэ үү");
        grid.add(oldPass, 1, 1, 2, 1);                

        Label newP = new Label("  Шинэ паспорт: ");
        newP.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        newP.setPrefWidth(120);
        grid.add(newP, 0, 2);     

        PasswordField newPas = new PasswordField();
        newPas.setPrefWidth(180);
        newPas.setPromptText("Шинэ паспортаа хийнэ үү");
        newPas.setText(null);
        grid.add(newPas, 1, 2, 2, 1);

        Label again = new Label("  Шинэ паспорт: ");
        again.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        again.setPrefWidth(120);
        grid.add(again, 0, 3);

        PasswordField pwBox = new PasswordField();
        pwBox.setPrefWidth(180);
        pwBox.setPromptText("паспортаа дахин хийнэ үү");
        pwBox.setText(null);
        grid.add(pwBox, 1, 3, 2, 1);

        Button btn = new Button("Хадгалах");
        btn.setPrefWidth(70);
        btn.setId("green");
        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);
        
          btn.setOnAction(ae -> {
            if (oldPass.getText().equals(CustomerLogin.getTmp_password())) {

                oldPass.setVisible(true);
                actiontarget2.setText("Паспорт зөв байна");
                actiontarget2.setFill(Color.GREEN);
                actiontarget2.setVisible(true);
                actiontargets.setText("");
                
                if (pwBox.getText() != null && newPas.getText() != null) {
                    if (pwBox.getText().equals(newPas.getText())) {
                        
//                        actiontarget2.setVisible(false);                        
                        pwBox.setVisible(true);
                        actiontarget1.setText("Амжилттай боллоо.");
                        actiontarget1.setFill(Color.GREEN);
                        actiontarget1.setVisible(true);
                        actiontarget.setText("");
                    } else {
//                        actiontarget2.setVisible(false);
                        actiontarget.setText("Дахин оролдоно уу.");
                        actiontarget1.setText("");
                        actiontarget.setFill(Color.FIREBRICK);
                        actiontarget.setVisible(true);

                    }
                }
                actiontargets.setVisible(false);
                
            } else {
                actiontargets.setText("");
                actiontargets.setVisible(true);
                actiontarget2.setVisible(false);
                actiontarget1.setVisible(false);
                actiontargets.setText("Паспорт буруу байна.");
                actiontargets.setFill(Color.FIREBRICK);
            }
            oldPass.clear();
            newPas.clear();
            pwBox.clear();
//            });
        });

        Button closed = new Button("Гарах");
        closed.setPrefWidth(70);
        closed.setId("green");        
      
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(closed);
        grid.add(hbBtn1, 2, 5);
        
        closed.setOnAction(ae -> {
            primaryStage.close();
           
        });       
         
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}