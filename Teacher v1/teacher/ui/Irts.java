/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Irts {
     public static final ObservableList<FlowPane> oyutan = FXCollections.observableArrayList();
     private TableView table = new TableView();
     private FlowPane pane = new FlowPane(new CheckBox(), new Label("asdasd"));
     private FlowPane irts;
    
    public Irts(){
        
        
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
        
        Label saveLb = new Label("Хадгалах");
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
        
        TableColumn IdCol = new TableColumn("Нэрс");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        IdCol.setEditable(false);
        
        IdCol.setPrefWidth(120);
        
        IdCol.setId("tablecolor");
        
        TableColumn lastNameCol = new TableColumn("Өдөр");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("ovog"));
        lastNameCol.setId("green");
        
        TableColumn nameCol = new TableColumn("Өдөр");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        
        TableColumn genderCol = new TableColumn("Өдөр");
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        genderCol.setId("green");
        
        TableColumn numberCol = new TableColumn("Өдөр");
        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        genderCol.setId("green");
        
        TableColumn typeCol = new TableColumn("Өдөр");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeCol.setId("green");
        
        TableColumn paymentCol = new TableColumn("Өдөр");
        paymentCol.setCellValueFactory(new PropertyValueFactory<>("payment"));
        
        TableColumn allPaymentCol = new TableColumn("Өдөр");
        allPaymentCol.setCellValueFactory(new PropertyValueFactory<>("pane"));
        allPaymentCol.setId("green");
        
        TableColumn dateCol = new TableColumn("Өдөр");
        
        dateCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        table.setItems(oyutan);
        table.getColumns().addAll(IdCol,lastNameCol, nameCol, genderCol, numberCol,typeCol,paymentCol,allPaymentCol,dateCol);
        //oyutan.add(new tables("010809", "Pruis", "Toyota", "2009", "vafvawf","fawfawf","fawfaw","fawfaw","fawfaw"));
        
        
        
        irts.getChildren().addAll(topBf, table);
            //irts.setRight(udur1View);
    }
    
    public FlowPane getContainer() {
        return this.irts;
    }
    
}
