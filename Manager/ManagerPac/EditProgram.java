package ManagerPac;

import Controller.ClientTest;
import java.awt.event.KeyEvent;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
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
    private Label dayLbl;
    private Label monthLbl;
    private Label yearLbl;
    
    private TextField proNameFld;
    private TextArea descArea;
    
    private Label endSlash1;
    private Label endSlash2;
    private TextField ddFldEnd;
    private TextField mmFldEnd;
    private TextField yyyyFldEnd;
    
    private Label startSlash1;
    private Label startSlash2;
    private TextField ddFldStart;
    private TextField mmFldStart;
    private TextField yyyyFldStart;
    
    private Button editBtn;
    private Button cancelBtn;
    
    private String proName;
    private String desc;
    private String endDay;
    private String endMonth;
    private String endYear;
    private String end;
    private String startDay;
    private String startMonth;
    private String startYear;
    private String start;
    private String update;
    
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
        proNameFld.setText(Launcher.getPROGRAM().getSelectProgram().getName());
        
        descArea=new TextArea();
        descArea.setPrefSize(150, 50);
        descArea.setLayoutX(200);
        descArea.setLayoutY(80);
        descArea.setWrapText(true);
        descArea.setText(Launcher.getPROGRAM().getSelectProgram().getDescription());
        
        ddFldStart=new TextField();
        ddFldStart.setPrefSize(30, 25);
        ddFldStart.setLayoutX(200);
        ddFldStart.setLayoutY(150);
        DayField(ddFldStart);
        
        startSlash1=new Label("/");
        startSlash1.setPrefSize(10, 25);
        startSlash1.setLayoutX(240);
        startSlash1.setLayoutY(150);
        
        mmFldStart=new TextField();
        mmFldStart.setPrefSize(30, 25);
        mmFldStart.setLayoutX(253);
        mmFldStart.setLayoutY(150);
        MonthField(mmFldStart);
        
        startSlash2=new Label("/");
        startSlash2.setPrefSize(10, 25);
        startSlash2.setLayoutX(293);
        startSlash2.setLayoutY(150);
        
        yyyyFldStart=new TextField();
        yyyyFldStart.setPrefSize(45, 25);
        yyyyFldStart.setLayoutX(305);
        yyyyFldStart.setLayoutY(150);
        YearField(yyyyFldStart);
        
        dayLbl=new Label("Өдөр");
        dayLbl.setPrefSize(40, 25);
        dayLbl.setLayoutX(200);
        dayLbl.setLayoutY(175);
        
        monthLbl=new Label("Сар");
        monthLbl.setPrefSize(40, 25);
        monthLbl.setLayoutX(258);
        monthLbl.setLayoutY(175);
        
        yearLbl=new Label("Жил");
        yearLbl.setPrefSize(40, 25);
        yearLbl.setLayoutX(315);
        yearLbl.setLayoutY(175);
        
        ddFldEnd=new TextField();
        ddFldEnd.setPrefSize(30, 25);
        ddFldEnd.setLayoutX(200);
        ddFldEnd.setLayoutY(200);
        DayField(ddFldEnd);
        
        endSlash1=new Label("/");
        endSlash1.setPrefSize(10, 25);
        endSlash1.setLayoutX(240);
        endSlash1.setLayoutY(200);
        
        mmFldEnd=new TextField();
        mmFldEnd.setPrefSize(30, 25);
        mmFldEnd.setLayoutX(253);
        mmFldEnd.setLayoutY(200);
        MonthField(mmFldEnd);
        
        endSlash2=new Label("/");
        endSlash2.setPrefSize(10, 25);
        endSlash2.setLayoutX(293);
        endSlash2.setLayoutY(200);
        
        yyyyFldEnd=new TextField();
        yyyyFldEnd.setPrefSize(45, 25);
        yyyyFldEnd.setLayoutX(305);
        yyyyFldEnd.setLayoutY(200);
        YearField(yyyyFldEnd);
        
        editBtn=new Button("Засах");
        editBtn.setOnAction(ae-> {
            
            int answer=JOptionPane.showConfirmDialog(null, "Засах уу?");
            if(answer==JOptionPane.YES_OPTION) {
                getEditInfo();
                ClientTest.RequestAjluulah("", ""+update+"");
                ae.consume();
                primaryStage.close();
            }
        });
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
                ddFldStart,
                startSlash1,
                mmFldStart,
                startSlash2,
                yyyyFldStart,
                dayLbl,
                monthLbl,
                yearLbl,
                ddFldEnd,
                endSlash1,
                mmFldEnd,
                endSlash2,
                yyyyFldEnd,
                editBtn,
                cancelBtn
        );
        
        Scene scene=new Scene(pane, 380, 320);
        primaryStage.setTitle("Хөтөлбөр засах");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void DayField(TextField textField) {
        final int limit=2;
        
        textField.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        textField.textProperty().addListener((Observable observable) -> {
            String value=((StringProperty)observable).get();
            if(value.length()>limit) {
                textField.textProperty().setValue(value.substring(0, limit));
            }
        });
    }
    
    private void MonthField(TextField textField) {
        final int limit=2;
        textField.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        textField.textProperty().addListener((Observable observable) -> {
            String value=((StringProperty)observable).get();
            if(value.length()>limit) {
                textField.textProperty().setValue(value.substring(0, limit));
            }
        });
    }
    
    private void YearField(TextField textField) {
        final int limit=4;
        textField.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        textField.textProperty().addListener((Observable observable) -> {
            String value=((StringProperty)observable).get();
            if(value.length()>limit) {
                textField.textProperty().setValue(value.substring(0, limit));
            }
        });
    }
    
    public void getEditInfo() {
        proName=proNameFld.getText();
        desc=descArea.getText();
        startDay=ddFldStart.getText();
        startMonth=mmFldStart.getText();
        startYear=yyyyFldStart.getText();
        start=startYear+"/"+startMonth+"/"+startDay;
        endDay=ddFldEnd.getText();
        endMonth=mmFldEnd.getText();
        endYear=yyyyFldEnd.getText();
        end=endYear+"/"+endMonth+"/"+endDay;
        update=proName+"::"+desc+"::"+end+"::"+start;
    }
}
