
package teacher.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import teacher.model.DunOruulahModel;


public class DunOruulah {

    public static final ObservableList<FlowPane> oyutan = FXCollections.observableArrayList();
    private TableView table;
    private FlowPane irts;
    
    private ObservableList<DunOruulahModel> responseData ;
    Node getContainer;

    public DunOruulah() {
        ObservableList<String> responseData = FXCollections.observableArrayList();
        responseData.add("Болд||10||10||10||10||10||10||10||100");
        responseData.add("Бат||8||2||6||5||9||2||10||47");
        responseData.add("Цэцэг||7||3||8||4||3||7||10||25");
        responseData.add("Retard||0||0||0||0||0||0||10||10");
        responseData.add("Дэлгэр||8||3||8||4||3||7||10||55");
        responseData.add("Дорж||9||4||7||9||9||9||10||69");
        
        ObservableList<Object> row1 = FXCollections.observableArrayList();
        for (int i = 0; i<responseData.size(); i++) {
            String[] javalist = responseData.get(i).split("\\|\\|");
            row1.add(new DunOruulahModel(javalist[0],javalist[1],javalist[2],javalist[3],javalist[4],javalist[5],javalist[6],javalist[7],javalist[8]));
        }

        irts = new FlowPane();
        irts.setPrefSize(790, 700);
        irts.setStyle("-fx-background-color: #F6F6F7");

        BorderPane topBf = new BorderPane();
        topBf.setPrefSize(1050, 60);
        topBf.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        Label nameLbl = new Label("Дүн оруулах");
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(200, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));

        

        FlowPane btnFl = new FlowPane(10, 10);
        btnFl.setAlignment(Pos.CENTER);
        btnFl.setPrefSize(360, 60);
        
         Label dunOruulah = new Label("Дүн оруулах");
        dunOruulah.setAlignment(Pos.CENTER);
        dunOruulah.setPrefSize(100, 25);
        dunOruulah.setFont(javafx.scene.text.Font.font("Arial", 15));
        dunOruulah.setId("green");
                dunOruulah.setOnMousePressed(ae -> {
            Stage stage = new Stage();
            new IrtsZasah().start(stage);
        });

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

        btnFl.getChildren().addAll(dunOruulah,saveLb, editLb);

        topBf.setLeft(nameLbl);
        topBf.setRight(btnFl);

        //////////////////////////////// 
        table = new TableView();
        table.setEditable(false);
        table.setItems(row1);
        table.setStyle("-fx-alignment: CENTER;");
        table.setPrefSize(1020, 645);
        
        TableColumn IdCol = new TableColumn("Нэр");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("ner"));
        IdCol.setEditable(false);
        
        IdCol.setPrefWidth(120);
                

        TableColumn bd1 = new TableColumn("Бие даалт 1");
        bd1.setCellValueFactory(new PropertyValueFactory<>("bd1"));
                bd1.setPrefWidth(120);
                TableColumn bd2 = new TableColumn("Бие даалт 2");
        bd2.setCellValueFactory(new PropertyValueFactory<>("bd2"));
        bd2.setPrefWidth(120);
                        TableColumn bd3 = new TableColumn("Бие даалт 3");
        bd3.setCellValueFactory(new PropertyValueFactory<>("bd3"));
        bd3.setPrefWidth(120);
                        TableColumn bd4 = new TableColumn("Бие даалт 4");
        bd4.setCellValueFactory(new PropertyValueFactory<>("bd4"));
        bd4.setPrefWidth(120);
                        TableColumn bd5 = new TableColumn("Бие даалт 5");
        bd5.setCellValueFactory(new PropertyValueFactory<>("bd5"));
        bd5.setPrefWidth(120);
                        TableColumn bd6 = new TableColumn("Бие даалт 6");
        bd6.setCellValueFactory(new PropertyValueFactory<>("bd6"));
        bd6.setPrefWidth(120);
                        TableColumn bd7 = new TableColumn("Бие даалт 7");
        bd7.setCellValueFactory(new PropertyValueFactory<>("bd7"));
        bd7.setPrefWidth(120);
                                TableColumn niit = new TableColumn("Нийт");
        niit.setCellValueFactory(new PropertyValueFactory<>("niit"));
        niit.setPrefWidth(120);
    

        table.getColumns().addAll(IdCol, bd1,bd2,bd3,bd4,bd5,bd6,bd7,niit);


        irts.getChildren().addAll(topBf, table);
  
    }

    public FlowPane getContainer() {
        return this.irts;
    }

}
