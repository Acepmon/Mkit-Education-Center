/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import teacher.launch.Launcher;
import teacher.login.ui.CustomerLogin;

/**
 *
 * @author JAVA M2
 */
public class Logout {
   
    
    public Logout(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Гарах"); 
        FlowPane flowPane = new FlowPane(10,10);
        Scene myScene = new Scene(flowPane);
        primaryStage.setMinHeight(150);
        primaryStage.setMinWidth(300);
        primaryStage.setMaxHeight(150);
        primaryStage.setMaxWidth(300);
        primaryStage.setScene(myScene);
        flowPane.setAlignment(Pos.CENTER);
         myScene.getStylesheets().add(getClass().getResource("style/mainStyle.css").toExternalForm());

        Label questionLb = new Label("Сургалтын албаны мэдээллээс гармаар байна уу?");
       
        
        Separator separator = new Separator();
        separator.setPrefWidth(200);
        
        
        Button yes = new Button("Тийм");
        yes.setPrefSize(100, 20);       
        yes.setAlignment(Pos.CENTER);
        yes.setFont(Font.font("Arial", 12));
        yes.setId("green");
        
        yes.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                primaryStage.close();
                Launcher.setLOGIN(new CustomerLogin(Launcher.getStage()));
                Launcher.setScene(Launcher.getLOGIN().getScene());
                teacher.login.ui.CustomerLogin.aa.setVisible(false);
                teacher.login.ui.CustomerLogin.bb.setVisible(false);
                teacher.login.ui.CustomerLogin.pnl.setVisible(false);
            }
        });
        
        Button no = new Button ("Буцах");
        no.setPrefSize(100, 20);
        no.setFont(Font.font("Arial",12));
        no.setAlignment(Pos.CENTER);
        no.setId("green");
        
        no.setOnAction(ae->{
            primaryStage.close();
         
        });
        flowPane.getChildren().addAll(questionLb,separator, yes, no);
       
        primaryStage.show();
    }
}
