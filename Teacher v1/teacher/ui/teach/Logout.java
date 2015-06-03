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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import teacher.launch.Launcher;
import teacher.ui.CenterPro;

/**
 *
 * @author JAVA M2
 */
public class Logout {

    public Logout(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 5, 10, 5));
        Scene scene = new Scene(grid, Color.WHITESMOKE);
        primaryStage.setMinHeight(120);
        primaryStage.setMaxWidth(300);
        primaryStage.setMaxHeight(120);
        primaryStage.setMinWidth(300);
        Group root = new Group();
        
        
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5,5,5,10));
  
        
        Button yeas = new Button("Тийм");
        yeas.setPrefSize(120, 15);
        grid.add(yeas,2,3);
        yeas.setAlignment(Pos.CENTER);
        yeas.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        yeas.setId("btn");
        
        yeas.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                primaryStage.close();
                Launcher.setScene(Launcher.getDefaultScene());
            }
        });
        
        Button no =new Button ("Буцах");
        no.setPrefSize(120, 15);
        grid.add(no,3,3);
        no.setFont(Font.font("Arial", FontWeight.BOLD,14));
        no.setAlignment(Pos.CENTER);
        no.setId("btn");
        no.setOnAction(ae->{
            primaryStage.close();
         
        });
        root.getChildren().add(gridpane);   
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
