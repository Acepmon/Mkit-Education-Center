
package teacher.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import teacher.model.IrtsModel;


public class Irts {

    public static final ObservableList<FlowPane> oyutan = FXCollections.observableArrayList();
    private TableView table;
    private FlowPane pane = new FlowPane(new CheckBox(), new Label("asdasd"));
    private FlowPane irts;
    
    private ObservableList<IrtsModel> data = FXCollections.observableArrayList();

    public Irts() {
        //Observablelist<String>
        ObservableList<String> responseData = FXCollections.observableArrayList();
        responseData.addAll("bold", "Bat", "Zulaa", "Mongol");

        irts = new FlowPane();
        irts.setPrefSize(790, 700);
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

        FlowPane btnFl = new FlowPane(10, 10);
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
        table = new TableView();
        table.setEditable(false);
        table.setPrefSize(774, 648);
        
        TableColumn IdCol = new TableColumn("Нэрс");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        IdCol.setEditable(false);
        IdCol.setPrefWidth(120);
        IdCol.setId("tablecolor");

        TableColumn lastNameCol = new TableColumn("Өдөр");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        lastNameCol.setId("table_color");

        TableColumn nameCol = new TableColumn("Өдөр");
        nameCol.setCellValueFactory(new PropertyValueFactory<>(""));

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

        ListView listView = new ListView(oyutan);
        listView.setEditable(false);
        listView.setPrefSize(230, 500);

        for (String str : responseData) {
            FlowPane flowpane = new FlowPane();

            CheckBox check = new CheckBox();
            Label label = new Label(str);

            label.setOnMousePressed(ae -> {
                if (check.isSelected()) {
                    check.setSelected(false);
                } else {
                    check.setSelected(true);
                }
            });

            flowpane.getChildren().addAll(check, label);
            flowpane.setPrefWidth(40);
            flowpane.setAlignment(Pos.CENTER_LEFT);
            flowpane.setPadding(new Insets(3, 3, 3, 3));
            flowpane.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 0px");

            data.add(new IrtsModel(str, "2015-04-01"));
            oyutan.add(flowpane);
        }
        Label all = new Label("Бүгдийг идэвхжүүлэх");
        all.setPrefSize(150, 20);

        CheckBox c = new CheckBox();
        c.setOnAction(ae -> {

            for (int i = 0; i < oyutan.size(); i++) {

                if (c.isSelected()) {
                    ((CheckBox) oyutan.get(i).getChildren().get(0)).setSelected(true);
                } else {
                    ((CheckBox) oyutan.get(i).getChildren().get(0)).setSelected(false);
                }
            }

        });
        
        
        
        

        table.setItems(data);
        table.getColumns().addAll(IdCol, lastNameCol, nameCol, genderCol, numberCol, typeCol, paymentCol, allPaymentCol, dateCol);
        //oyutan.add(new tables("010809", "Pruis", "Toyota", "2009", "vafvawf","fawfawf","fawfaw","fawfaw","fawfaw"));

        irts.getChildren().addAll(topBf, table);
        //irts.setRight(udur1View);
    }

    public FlowPane getContainer() {
        return this.irts;
    }
    
    public static void tdDatas(String tdDatas){
        
         ObservableList<String> responseData = FXCollections.observableArrayList();
         responseData.addAll("bold", "Bat", "Zulaa", "Mongol");
        
        
        
    }

}
