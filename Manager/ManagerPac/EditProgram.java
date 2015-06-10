package ManagerPac;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class EditProgram extends Application {
    private Label proNameLbl;
    private Label descLbl;
    private Label startDateLbl;
    private Label endDateLbl;
    
    private TextField proNameFld;
    private TextArea descArea;
    private TextField startFld;
    private TextField endFld;
    
    private Button editBtn;
    private Button cancelBtn;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane=new Pane();
        
        proNameLbl=new Label("Хөтөлбөрийн нэр");
        proNameLbl.setPrefSize(150, 25);
        proNameLbl.setFont(Font.font("Verdana", 14));
        proNameLbl.setLayoutX(25);
        proNameLbl.setLayoutY(30);
        
        descLbl=new Label("Тайлбар");
        descLbl.setPrefSize(150, 25);
        descLbl.setFont(Font.font("Verdana", 14));
        descLbl.setLayoutX(25);
        descLbl.setLayoutY(80);
        
        startDateLbl=new Label("Эхлэх огноо");
        startDateLbl.setPrefSize(150, 25);
        startDateLbl.setFont(Font.font("Verdana", 14));
        startDateLbl.setLayoutX(25);
        startDateLbl.setLayoutY(150);
        
        endDateLbl=new Label("Дуусах огноо");
        endDateLbl.setPrefSize(150, 25);
        endDateLbl.setFont(Font.font("Verdana", 14));
        endDateLbl.setLayoutX(25);
        endDateLbl.setLayoutY(200);
        
        proNameFld=new TextField();
        proNameFld.setPrefSize(150, 25);
        proNameFld.setLayoutX(200);
        proNameFld.setLayoutY(30);
        
        descArea=new TextArea();
        descArea.setPrefSize(150, 50);
        descArea.setLayoutX(200);
        descArea.setLayoutY(80);
        
        startFld=new TextField();
        startFld.setPrefSize(150, 25);
        startFld.setLayoutX(200);
        startFld.setLayoutY(150);
        
        endFld=new TextField();
        endFld.setPrefSize(150, 25);
        endFld.setLayoutX(200);
        endFld.setLayoutY(200);
        
        editBtn=new Button("Засах");
        editBtn.setPrefSize(150, 30);
        editBtn.setLayoutX(25);
        editBtn.setLayoutY(260);
        
        cancelBtn=new Button("Болих");
        cancelBtn.setOnAction(ae-> {
            int answer=JOptionPane.showConfirmDialog(null, "Гарах уу?");
            if(answer==JOptionPane.YES_OPTION) {
                primaryStage.close();
            }
        });
        cancelBtn.setPrefSize(150, 30);
        cancelBtn.setLayoutX(200);
        cancelBtn.setLayoutY(260);
        
        pane.getChildren().addAll(
                proNameLbl, 
                descLbl, 
                startDateLbl, 
                endDateLbl,
                proNameFld,
                descArea,
                startFld,
                endFld,
                editBtn,
                cancelBtn
        );
        
        Scene scene=new Scene(pane, 380, 320);
        primaryStage.setTitle("Хөтөлбөр засах");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
