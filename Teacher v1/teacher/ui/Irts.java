/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surgaltiin.alba.irts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author JAVA M2
 */
public class irts {
     public static ObservableList<tables> oyutan = FXCollections.observableArrayList();
     private TableView table = new TableView();
     private FlowPane pane = new FlowPane(new CheckBox(), new Label("asdasd"));
     private FlowPane irts;
    
    public irts(){
        
        
        irts = new FlowPane();
        irts.setPrefSize(778, 700);
        irts.setStyle("-fx-background-color: #F6F6F7");

        
        BorderPane topBf = new BorderPane();
        topBf.setPrefSize(782, 60);
        topBf.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        Label nameLbl = new Label("Хичээлийн ирц");
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(200, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        
        nameLbl.setId("text");
             
        FlowPane btnFl = new FlowPane(10,10);
        btnFl.setAlignment(Pos.CENTER);
        btnFl.setPrefSize(240, 60);
        
        Label saveLb = new Label("Илгээх");
        saveLb.setAlignment(Pos.CENTER);
        saveLb.setPrefSize(100, 25);
        saveLb.setFont(javafx.scene.text.Font.font("Arial", 15));
        saveLb.setId("green");
        
        
        
        
        Label editLb = new Label("Засах");
        editLb.setAlignment(Pos.CENTER);
        editLb.setPrefSize(80, 25);
        editLb.setFont(javafx.scene.text.Font.font("Arial", 15));
        editLb.setId("green");
        
       
        btnFl.getChildren().addAll(saveLb, editLb);
        
        topBf.setLeft(nameLbl);
        topBf.setRight(btnFl);
        
       //////////////////////////////// 
        TableView table = new TableView();
        table.setEditable(false);
        table.setPrefSize(774, 648);
        
        TableColumn nersCol = new TableColumn("Нэрс");
        nersCol.setCellValueFactory(new PropertyValueFactory<>("ners"));
        nersCol.setEditable(false);
        
       
        
     
        TableColumn paneCol = new TableColumn("Өдөр");
        paneCol.setCellValueFactory(new PropertyValueFactory<>("pane"));
        paneCol.setPrefWidth(50);
        
        
        
        TableColumn nameCol = new TableColumn("Өдөр");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("pane"));
        nameCol.setPrefWidth(50);
        
        
        TableColumn genderCol = new TableColumn("Өдөр");
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        
        
        TableColumn numberCol = new TableColumn("Өдөр");
        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        
        
        TableColumn typeCol = new TableColumn("Өдөр");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
       
        
        TableColumn paymentCol = new TableColumn("Өдөр");
        paymentCol.setCellValueFactory(new PropertyValueFactory<>("payment"));
        
        TableColumn allPaymentCol = new TableColumn("Өдөр");
        allPaymentCol.setCellValueFactory(new PropertyValueFactory<>("pane"));
       
        
        TableColumn dateCol = new TableColumn("Өдөр");
        
        dateCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        table.setItems(oyutan);
        table.getColumns().addAll(nersCol,paneCol);
        oyutan.add(new tables("q", "w"));
        
        
        
        irts.getChildren().addAll(topBf, table);
            //irts.setRight(udur1View);
    }
    
    public FlowPane getContainer() {
        return this.irts;
    }
    
}
