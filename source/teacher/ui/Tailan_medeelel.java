package teacher.ui;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
public class Tailan_medeelel {
     
     private TableView table = new TableView();
     private FlowPane pane = new FlowPane(new CheckBox(), new Label("asdasd"));
     private FlowPane irts;
    
    public Tailan_medeelel(){
        
        
        irts = new FlowPane();
        irts.setPrefSize(778, 700);
        irts.setStyle("-fx-background-color: #F6F6F7");

        
        BorderPane topBf = new BorderPane();
        topBf.setPrefSize(782, 60);
        topBf.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        Label nameLbl = new Label("Гаргаж буй тайлангийн нэр");
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
        
        ComboBox tailanCm = new ComboBox();
        tailanCm.setPrefSize(100, 20);
        tailanCm.getItems().addAll(
            "Highest",
            "High",
            "Normal",
            "Low",
            "Lowest" 
        );
        
       
        btnFl.getChildren().addAll(saveLb, tailanCm);
        
        topBf.setLeft(nameLbl);
        topBf.setRight(btnFl);
        
       //////////////////////////////// 
        TableView table = new TableView();
        table.setEditable(false);
        table.setPrefSize(774, 648);
        
        TableColumn nersCol = new TableColumn("Нэрс");
        nersCol.setCellValueFactory(new PropertyValueFactory<>("ners"));
        nersCol.setEditable(false);
        
        nersCol.setPrefWidth(120);
        
        nersCol.setId("tablecolor");
        
        TableColumn paneCol = new TableColumn("Өдөр");
        paneCol.setCellValueFactory(new PropertyValueFactory<>("pane"));
        paneCol.setId("green");
        
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
        
        
        table.getColumns().addAll(nersCol,paneCol);
        //oyutan.add(new tables(fawfaw, gawgaw));
        
        
        
        irts.getChildren().addAll(topBf, table);
            //irts.setRight(udur1View);
    }
    
    public FlowPane getContainer() {
        return this.irts;
    }
    
}