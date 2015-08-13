package teacher.ui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import teacher.controller.ServerConnection;
import teacher.launch.Launcher;
import teacher.login.ui.CustomerLogin;
import teacher.model.Columns;
import teacher.model.CustomTable2;
import teacher.model.MedeelelTest;

/**
 *
 * @author JAVA M2
 */
public class Tailan_medeelel {
    
    class settpopupwindow {

    TextField fld;

    public void start(Stage yourStage) {
        
       
        
        yourStage.setTitle("");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 100, 100);
        yourStage.setScene(myScene);
        yourStage.setResizable(false);
        
     

        Button save = new Button("Илгээх");
        save.setOnAction(ae->{
            
            
            String tmp_userName = "CustomerLogin.getTmp_username()";
            ArrayList<Object> sendDatas = new ArrayList<>();
            
           ArrayList<Columns> tailan = getTableDatas(Launcher.getTAILAN_MEDEELEL().getTailanTable().getTable());
           
           sendDatas.add(tailan);
           sendDatas.add(CustomerLogin.getTmp_username());
           sendDatas.add(nameFld.getText());
           System.out.println(ServerConnection.RequestAjluulah("tailanIlgeeh", sendDatas));
           
           // System.out.println(ServerConnection.RequestAjluulah("getAllStudents", null));
            
            System.out.println("taujd"+Launcher.getTAILAN_MEDEELEL().getTailanTable().getSelectedColumns());
            yourStage.close();
            
        });
        Button exit = new Button("Болих");
        exit.setOnAction(ae->{
            yourStage.close();
        });
      
      

        rootNode.getChildren().setAll(save, exit);
        yourStage.show();

    }
    
    public ArrayList<Columns> getTableDatas(TableView table) {
        int row_count = table.getItems().size();
        ArrayList<Columns> tailan = new ArrayList<>();
        for (TableColumn tcol : (ObservableList<TableColumn>) table.getColumns()){
            ArrayList<Object> datas = new ArrayList<>();
            for(int index = 0; index<row_count; index++){
                datas.add(tcol.getCellData(index));
            }
            Columns column = new Columns(tcol.getText(), "names", datas);
            tailan.add(column);
        }
        return tailan;
    }
  
}
     
     private TableView table = new TableView();
     private FlowPane pane = new FlowPane(new CheckBox(), new Label("asdasd"));
     private VBox irts;
     private Button send, clear;
     private TextField nameFld;
     
     private ObservableList<MedeelelTest> tailanData;
     
     private CustomTable2 tailanTable;
    
    public Tailan_medeelel(){
        
        tailanTable = new CustomTable2();
        tailanTable.addCheckBox = true;
        tailanTable.getTable().setPadding(Insets.EMPTY);
        tailanTable.getTable().setMinSize(778, 640);
        tailanTable.getTable().setMinSize(778, 640);
        
        tailanData = FXCollections.observableArrayList();
        for(int i=0; i< tailanData.size(); i++){
            
        }
        
        irts = new VBox();
        irts.setPrefSize(778, 700);
        irts.setStyle("-fx-background-color: #F6F6F7");
        irts.setId("border");
        irts.setPadding(Insets.EMPTY);
        
        BorderPane topBf = new BorderPane();
        topBf.setPrefSize(782, 60);
        topBf.setStyle("-fx-background-color: #E6E6E6;");
        
        
        nameFld = new TextField();
        nameFld.setPromptText("Тайлангийн нэр...");
        nameFld.setAlignment(Pos.CENTER);
        nameFld.setPrefSize(400, 35);
        nameFld.setFont(javafx.scene.text.Font.font("Arial", 18));
        HBox nameBox = new HBox(nameFld);
        nameBox.setAlignment(Pos.CENTER);
        nameBox.setPrefSize(420, 60);
        
             
        FlowPane btnFl = new FlowPane(10,10);
        btnFl.setAlignment(Pos.CENTER);
        btnFl.setPrefSize(350, 60);
        
        send = new Button("Илгээх");
        send.setAlignment(Pos.TOP_CENTER);
        send.setPrefSize(100, 25);
        send.setId("green");
        send.setOnMouseClicked(ae->{
            Stage yourStage = new Stage();
            settpopupwindow asd = new settpopupwindow();
            asd.start(yourStage);
        });
        
        clear = new Button("Цэвэрлэх");
        clear.setAlignment(Pos.CENTER);
        clear.setPrefSize(100, 25);
        clear.setId("green");
        clear.setOnAction((event) -> {
            tailanTable.clearTable();
        });
      
        
        ComboBox tailanCm = new ComboBox();
        tailanCm.setPrefSize(100, 20);
        tailanCm.setValue("Highest");
        tailanCm.getItems().addAll(
            "Highest",
            "High",
            "Normal",
            "Low",
            "Lowest" 
        );
        
       
        btnFl.getChildren().addAll(clear, send, tailanCm);
        
        topBf.setLeft(nameBox);
        topBf.setRight(btnFl);
     
  
        
        irts.getChildren().addAll(topBf, tailanTable.getTable());
            //irts.setRight(udur1View);
    }
    
    public VBox getContainer() {
        return this.irts;
    }

    public CustomTable2 getTailanTable() {
        return tailanTable;
    }
    
    public ArrayList<Columns> getTableDatas(TableView table) {
        int row_count = table.getItems().size();
        ArrayList<Columns> tailan = new ArrayList<>();
        for (TableColumn tcol : (ObservableList<TableColumn>) table.getColumns()){
            ArrayList<Object> datas = new ArrayList<>();
            for(int index = 0; index<row_count; index++){
                datas.add(tcol.getCellData(index));
            }
            Columns column = new Columns(tcol.getText(), "names", datas);
            tailan.add(column);
        }
        return tailan;
    }
   
    
}