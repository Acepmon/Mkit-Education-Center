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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Passwords {

   
    public Passwords(Stage primaryStage) {
        primaryStage.setTitle("Тохиргоо");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, Color.WHITESMOKE);
        primaryStage.setMinHeight(220);
        primaryStage.setMinWidth(320);
        primaryStage.setMaxHeight(220);
        primaryStage.setMaxWidth(320);
        Group root = new Group();
        
        
        GridPane gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        
     
        Text scenetitle = new Text("Change Password");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("New Password:");
        grid.add(userName, 0, 1);

        PasswordField newPas = new PasswordField();
        newPas .setPromptText("Input new password");
        grid.add(newPas , 1, 1);

        Label pw = new Label("Again Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        pwBox.setPromptText("Input again password");
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Save");
        btn.setPrefWidth(70);
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
             
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
            }
        });
        
        Button closed = new Button("Close");
        closed.setPrefWidth(70);
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(closed);
        grid.add(hbBtn1, 1, 4);
        closed.setOnAction(ae -> {
            primaryStage.close();
           
        });

        
        root.getChildren().add(gridpane);   
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}