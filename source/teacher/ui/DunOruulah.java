/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui;

import static java.util.Collections.addAll;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import sun.security.krb5.JavaxSecurityAuthKerberosAccess;
import teacher.model.DunOruulahModel;
import static teacher.ui.IdevhDun.oyutan;

/**
 *
 * @author JAVA M2
 */

public class DunOruulah {    
    private BorderPane centerFp;
    private TableView table;    
    private ObservableList<DunOruulahModel> data = FXCollections.observableArrayList();
  
   
    public DunOruulah(){        
//        final GridPane grid = new GridPane();
   
        centerFp = new BorderPane();
        centerFp.setPrefSize(524, 708);
        centerFp.setStyle("-fx-background-color: white");
        
        //////title 
        BorderPane topBf = new BorderPane();
        topBf.setPrefSize(524, 60);
        topBf.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        
        Label nameLbl = new Label("Хичээлээ сонгон уу!");
        nameLbl.setAlignment(Pos.CENTER_LEFT);
        nameLbl.setPrefSize(180, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setId("btns");        
        
        FlowPane btnFl = new FlowPane();
        btnFl.setPadding(new Insets(20, 0, 0, 25));
        btnFl.setAlignment(Pos.CENTER_RIGHT);
        btnFl.setPrefSize(340, 60);
        btnFl.setDisable(true);
        
        ToggleButton java = new ToggleButton("Java ");
        java.setAlignment(Pos.CENTER);
        java.setPrefSize(60,25);
        java.setDisable(false);
       
        
        ToggleButton c = new ToggleButton("C# "); 
        c.setAlignment(Pos.CENTER);
        c.setPrefSize(60,25);
        c.setDisable(false);
              
        ToggleButton korea = new ToggleButton("Korean languge");
        korea.setAlignment(Pos.CENTER);
        korea.setPrefSize(110 ,20);  
        korea.setDisable(false);                

        topBf.setLeft(nameLbl);
        topBf.setRight(btnFl);
        
        nameLbl.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {             
                if(btnFl.isDisabled()){
                    btnFl.setDisable(false);
                }
                  }
      });  

                btnFl.getChildren().addAll( java,c,korea);
        
         java.setOnMousePressed(ae-> {
            if(java.isDisabled());
            c.setDisable(true);
            korea.setDisable(true);                   
    });
         c.setOnMousePressed(ae -> {
             if(c.isDisabled());
             java.setDisable(true);
             korea.setDisable(true);
         });
         korea.setOnMousePressed(ae-> {
             if(korea.isDisable())
                 c.setDisable(true);
             java.setDisable(true);
         });
        
      ///////////////////////////////////////       
      ObservableList<String> responseData = FXCollections.observableArrayList();
      responseData.addAll("bold", "Bat", "Zulaa", "Mongol");
        
      TabPane tabPane = new TabPane(); 
      tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
      Tab tabA = new Tab("Шалгалт");
      tabA.setStyle("-fx-padding: 15px");        
      
      Tab tabB = new Tab("Итвэхи");
      tabB.setStyle("-fx-padding: 15px"); 
      
      Tab tabC = new Tab("Ирц");
      tabC.setStyle("-fx-padding: 15px");
      
      Tab tabD = new Tab("Даалгавар");
      tabD.setStyle("-fx-padding: 15px");
      
      TableView table = new TableView();
          
      
        ////////////////////////////////     

      HBox hbox = new HBox();
      hbox.setPrefSize(524, 60);
      hbox.setAlignment(Pos.BOTTOM_LEFT);
      hbox.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
      hbox.setId("panel");
      
      VBox vbox = new VBox();
      vbox.setPrefSize(524, 648);
      vbox.setAlignment(Pos.TOP_CENTER);
      vbox.setId("panel");
      
        table.setEditable(true);
        table.setPrefSize(524, 500);
        
        TableColumn idCol = new TableColumn("сар");
        idCol.setCellValueFactory(new PropertyValueFactory<>("Огноо"));
        idCol.setEditable(false);
        idCol.setPrefWidth(100);                

        TableColumn nameCol = new TableColumn("Project name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Бодлого"));
        nameCol.setEditable(true);
        nameCol.setPrefWidth(150);
        
        TableColumn timeCol = new TableColumn("Хугацаа");
        timeCol.setCellValueFactory(new PropertyValueFactory<>(" 7 "));
        timeCol.setEditable(false);
        timeCol.setPrefWidth(100); 
        
        TableColumn pointCol = new TableColumn("Дүн");
        pointCol.setCellValueFactory(new PropertyValueFactory<>(" 89 "));
        pointCol.setEditable(false);
        pointCol.setPrefWidth(100); 
    
        ListView listView = new ListView(oyutan);
        listView.setEditable(false);
        listView.setPrefSize(230, 400);

        for (String str : responseData) {
            FlowPane flowpane = new FlowPane();

            TextField textDun = new TextField();
            Label label = new Label("dfgh"+str);

            label.setOnMousePressed(ae -> {
                if (textDun.isEditable()) {
                    
                } else {
                    
                }
            });
            
            flowpane.getChildren().addAll(textDun, label);
            flowpane.setPrefWidth(20);
            flowpane.setAlignment(Pos.BOTTOM_LEFT);
            flowpane.setPadding(new Insets(3, 3, 3, 3));            

//            data.add(new DunOruulahModel(str, Flowpane,"",""));
            oyutan.add(flowpane);
        }
        Label newlb = new Label();
        newlb.setPrefSize(30, 10);
       
        Label newlb1 = new Label();
        newlb1.setPrefSize(30, 10);
        
        Label newlb2 = new Label();
        newlb2.setPrefSize(30, 10);
        
        Label all = new Label("Бүх оюутанд дүн нэмэх:"); 
        all.setPrefSize(140, 10);
        all.setId("btns");
        
        TextField allTf = new TextField();
        allTf.setPromptText("Дүн");
        allTf.setPrefSize(40, 20);
        
        Button addBtn = new Button("Нэмэх");
        addBtn.setAlignment(Pos.BOTTOM_CENTER);
        addBtn.setPrefSize(90, 20);
        addBtn.setFont(javafx.scene.text.Font.font("Arial", 15));
        addBtn.setId("green");
        
        Button saveBtn = new Button("Хадгалах");
        saveBtn.setAlignment(Pos.BOTTOM_CENTER);
        saveBtn.setPrefSize(100, 20);
        saveBtn.setFont(javafx.scene.text.Font.font("Arial", 15));
        saveBtn.setId("green");
        
        Button editBtn = new Button("Засах");
        editBtn.setAlignment(Pos.BOTTOM_CENTER);
        editBtn.setPrefSize(80, 20);
        editBtn.setFont(javafx.scene.text.Font.font("Arial", 15));
        editBtn.setId("green");
                        

        table.setItems(data);
        table.getColumns().addAll(idCol, nameCol,timeCol, pointCol);    
    
//      VBox tabC_vBox = new VBox();
//      tabC.setContent(tabC_vBox);
//      tabC_vBox.getChildren().addAll(new Button("Button 1@Tab C"),      
//              new Button("Button 4@Tab C"));
      
        hbox.getChildren().addAll(all,allTf, newlb1,addBtn, newlb ,saveBtn, newlb2,editBtn);
        vbox.getChildren().add(table);
        
        
        tabB.setContent(vbox);
        vbox.getChildren().add(hbox);
        
        tabPane.getTabs().addAll(tabA,tabB,tabC);  
        
        centerFp.setTop(topBf);     
        centerFp.setCenter (tabPane);           
       
        /////////////////////////////////        
    }
    public BorderPane getContainer() {
        return this.centerFp;
    }
}

