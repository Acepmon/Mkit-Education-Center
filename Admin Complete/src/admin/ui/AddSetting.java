package admin.ui;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;
import login.ui.ServerConnection;


public class AddSetting extends Application{
    
    private DatePicker checkInDatePicker;
    private DatePicker checkOutDatePicker;
    static ObservableList<String> dataNew = FXCollections.observableArrayList();
    
    public void start(Stage AddSetStage){
        
        AddSetStage.setTitle("Элсэлт нэмэх");
        FlowPane AddSetPane = new FlowPane(10, 10);
        AddSetPane.setAlignment(Pos.CENTER);
        Scene addScene = new Scene(AddSetPane, 350, 300);
        
        ComboBox<String> orderSel;
        
        Label name = new Label("Элсэлтийн Тохиргоо Нэмэх");
        name.setFont(Font.font(null, FontWeight.BOLD, 16));
        name.setAlignment(Pos.CENTER);
        name.setPrefSize(250, 20);
        
        Label nameSet = new Label("Нэр");
        nameSet.setFont(Font.font(null, FontWeight.BOLD, 12));
        nameSet.setPrefSize(150, 20);   
        
        TextField nameSetTxt = new TextField();
        nameSetTxt.setPrefSize(170, 20);
                
        Label desc = new Label("Тайлбар");
        desc.setFont(Font.font(null, FontWeight.BOLD, 12));
        desc.setPrefSize(150, 20);
        
        TextField descTxt = new TextField();
        descTxt.setPrefSize(170, 20);
        
        
        Label sdate = new Label("Эхлэх огноо");
        sdate.setFont(Font.font(null, FontWeight.BOLD, 12));
        sdate.setPrefSize(150, 20);          

        checkInDatePicker = new DatePicker();        
        checkOutDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                    checkInDatePicker.getValue().plusDays(1))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
        checkOutDatePicker.setDayCellFactory(dayCellFactory);
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));  
        
        Label fdate = new Label("Дуусах огноо");
        fdate.setFont(Font.font(null, FontWeight.BOLD, 12));
        fdate.setPrefSize(150, 20);     
                                                     
        Button addButton = new Button("Хадгалах");
        addButton.setPrefSize(120, 20);
        addButton.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");
        addButton.setOnAction(ae ->{
//            dataNew.add(new SettingObj("jska", "sja", "2015-05-01", "2015-04-08"));
            
            String nameNew = nameSetTxt.getText();
            String descNew = descTxt.getText();
            String sdateNew = checkInDatePicker.getValue().toString();
            String fdateNew = checkOutDatePicker.getValue().toString();
            
            String IDstr = ""+  ServerConnection.RequestAjluulah("insertElseltPlan", ""+nameNew+"::"+descNew+"::"+sdateNew+"::"+fdateNew+"");
            
            System.out.println("elset id ---> " + IDstr);
            
            Setting.dataNew.add(new SettingObj(IDstr, nameNew, descNew, sdateNew, fdateNew));
            
            AddSetStage.close();
            
            
        });
        
//        final Button addButton = new Button("Add");
//        addButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override public void handle(ActionEvent e) {
//                data.add(new Person("new","new","new"));
//            }
//        });
        
        Button exitBtn = new Button("Буцах");
        exitBtn.setPrefSize(120, 20);
        exitBtn.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");
         exitBtn.setOnAction(ae->{
         AddSetStage.close();
        });
        
        
        AddSetPane.getChildren().addAll(name, nameSet, nameSetTxt, desc, descTxt, sdate, checkInDatePicker, fdate, checkOutDatePicker, addButton, exitBtn);
        
        AddSetStage.setScene(addScene);
        AddSetStage.setResizable(false);
        AddSetStage.show();
    
    }
    
}
