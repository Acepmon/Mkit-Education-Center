/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui; 
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.*;

// Java 8 code
public class IrtsZasah extends Application {

    private static final int shadowSize = 50;

    @Override public void start(final Stage stage) {

        stage.initStyle(StageStyle.TRANSPARENT);

        StackPane stackPane = new StackPane(createShadowPane());
        stackPane.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.9);" +
                "-fx-background-insets: " + shadowSize + ";"
        );

        Scene scene = new Scene(stackPane, 600, 600);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
                    
//                    Button btn = new Button("Sign in");
//        HBox hbBtn = new HBox(10);
//        btn.setId("button");
//
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//
//
//
//        final Text actiontarget = new Text();
//
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent e) {
//                actiontarget.setFill(Color.FIREBRICK);
//                actiontarget.setText("Sign in button pressed");
//            }
//        });
Button btn = new Button();
        btn.setText("Гарах");
        btn.setStyle("-fx-text-fill: #FFFFFF;"+"-fx-background-color:#99CC66");
                final Text actiontarget = new Text();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                         stage.close();
            }
        });
//            Group g = new Group();
//
//
//    TitledPane t1 = new TitledPane("T1", new Button("B1"));
//    TitledPane t2 = new TitledPane("T2", new Button("B2"));
//    TitledPane t3 = new TitledPane("T3", new Button("B3"));
//    Accordion accordion = new Accordion();
//    accordion.getPanes().addAll(t1, t2, t3);


        
//                stackPane.getChildren().addAll(btn,hbBtn,actiontarget);
                                stackPane.getChildren().addAll(btn,actiontarget);
        stage.show();
        stage.setResizable(true);

    }

    private Pane createShadowPane() {
        Pane shadowPane = new Pane();
        shadowPane.setStyle(
                "-fx-background-color: white;" +
                "-fx-effect: dropshadow(gaussian, black, " + shadowSize + ", 0, 0, 0);" +
                "-fx-background-insets: " + shadowSize + ";"
        );

        Rectangle innerRect = new Rectangle();
        Rectangle outerRect = new Rectangle();
        shadowPane.layoutBoundsProperty().addListener(
                (observable, oldBounds, newBounds) -> {
                    innerRect.relocate(
                            newBounds.getMinX() + shadowSize,
                            newBounds.getMinY() + shadowSize
                    );
                    innerRect.setWidth(newBounds.getWidth() - shadowSize * 2);
                    innerRect.setHeight(newBounds.getHeight() - shadowSize * 2);

                    outerRect.setWidth(newBounds.getWidth());
                    outerRect.setHeight(newBounds.getHeight());

                    Shape clip = Shape.subtract(outerRect, innerRect);
                    shadowPane.setClip(clip);
                }
        );

        return shadowPane;
        
    }

}