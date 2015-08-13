package admin.ui;

import static admin.ui.Account.rowIndex;
import static admin.ui.Account.tableAcc;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import login.ui.ServerConnection;
/**
 *
 * @author JAVA M2
 */
public class Setting {
    
    private Pane pane;
    public static TableView tableSet = new TableView();
    public static int rowIndex = -1;
    static ObservableList<SettingObj> dataNew = FXCollections.observableArrayList();
    
    public Setting(){
        
        pane = new Pane();        
        
        //        *********** table ***********
        Label tablename = new Label("Элсэлтийн тохиргоо");
        tablename.setFont(Font.font(null, FontWeight.BOLD, 16));
        tablename.setAlignment(Pos.CENTER);
        tablename.setPrefSize(200, 30);
        
        TableColumn nameColumn = new TableColumn("Нэр");
        nameColumn.setMinWidth(180);
        nameColumn.setCellValueFactory(new PropertyValueFactory<AccountObj, String>("name"));

        TableColumn descColumn = new TableColumn("Тайлбар");
        descColumn.setMinWidth(180);
        descColumn.setCellValueFactory(new PropertyValueFactory<AccountObj, String>("desc"));

        TableColumn sdateColumn = new TableColumn("Эхлэх огноо");
        sdateColumn.setMinWidth(120);
        sdateColumn.setCellValueFactory(new PropertyValueFactory<AccountObj, String>("sdate"));


        TableColumn fdateColumn = new TableColumn("Дуусах огноо");
        fdateColumn.setMinWidth(120);
        fdateColumn.setCellValueFactory(new PropertyValueFactory<AccountObj, String>("fdate"));

        
        tableSet.getColumns().addAll(
                nameColumn,
                descColumn,
                sdateColumn,
                fdateColumn
        );
        tableSet.setPrefSize(600, 400);
        
        
//        final ObservableList<SettingObj> data = FXCollections.observableArrayList(
//                new SettingObj("ner", "tailbar", "2015/01/04", "2015/04/05"),
//                new SettingObj("bat", "garsan", "2015/01/02", "2015/05/01")
//        );
//        
        
        ArrayList<String> responseData = (ArrayList<String>) ServerConnection.RequestAjluulah("getElseltPlan", null);        
            System.out.println("---- elselt "+responseData);  
            
            for (String str : responseData) {
                if (!str.equals("") && str != null) {
                String[] col = str.split("::");
                dataNew.add(new SettingObj(col[0], col[1], col[2], col[3], col[4]));
                }
            }   
        
        tableSet.setItems(dataNew);
        
        tableSet.setOnMouseClicked(ae -> {
            int c = tableSet.getSelectionModel().getSelectedIndex();
            System.out.println(c);
            rowIndex = c;  
        });
        
        
        
        Button addBtn = new Button("Нэмэх");
        addBtn.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 14px;");
        addBtn.setPrefSize(120, 20);        
        addBtn.setOnAction(ae -> {
            Stage AddSetStage = new Stage();               
                try {
                    new AddSetting().start(AddSetStage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }    
        });
        
        
        Button editBtn = new Button("Засах");
        editBtn.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 14px;");
        editBtn.setPrefSize(120, 20);        
        editBtn.setOnAction(ae -> {
            Stage EditSetStage = new Stage();               
                try {
                    new EditSetting().start(EditSetStage, (SettingObj)Setting.tableSet.getSelectionModel().getSelectedItem());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }    
        });
        
        
        Button deleteBtn = new Button("Устгах");
        deleteBtn.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 14px;");
        deleteBtn.setPrefSize(120, 20);
        deleteBtn.setOnAction(ae -> {
            
            
            int elselt_id = Integer.parseInt(((SettingObj)Setting.tableSet.getSelectionModel().getSelectedItem()).getId());
            System.out.println("id is" + elselt_id);
            System.out.println("elselt delete request -->"+ServerConnection.RequestAjluulah("deleteElseltPlan", elselt_id));                        
                    
            Setting.dataNew.remove(Setting.rowIndex);  
            
        });
        
        
        GridPane centerPart = new GridPane();
        centerPart.setPrefSize(824, 600);
        centerPart.setStyle("-fx-background-color: #E6FFFF");
        centerPart.setMinSize(10, 10);

        FlowPane centerLeftPart = new FlowPane();
        centerLeftPart.setAlignment(Pos.CENTER);
        centerLeftPart.setPrefSize(550, 600);
        centerLeftPart.setStyle("-fx-background-color: #E6FFFF");
        centerLeftPart.setMinWidth(0);

                
        FlowPane rootFlow = new FlowPane(20, 20);
        rootFlow.setAlignment(Pos.CENTER);
        rootFlow.setPrefWidth(720);
        
        
        
        centerPart.setVgap(25);
        
        
        centerPart.getChildren().addAll(rootFlow);
        centerPart.setConstraints(rootFlow, 0, 0);
//        centerPart.setConstraints(rootFlow2, 1, 0);
        rootFlow.getChildren().addAll(tablename, tableSet, addBtn,editBtn, deleteBtn);
        
        pane.getChildren().addAll(centerPart);
        pane.setVisible(true);
        
//        *************************************************************************
              
    }
    
    public Pane getContainer() {
        return this.pane;
    }
    
}
