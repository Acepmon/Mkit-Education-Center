package teacher.ui;



import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import teacher.launch.Launcher;
import teacher.model.Column;

public class Popupwindow {

 

    void  start(Stage myStage) {
        
       
        
        myStage.setTitle("");
        FlowPane rootNode = new FlowPane(30, 20);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 250, 100);
        myStage.setScene(myScene);
        myStage.setResizable(false);
        
        Label lbl = new Label("Та мөр эсвэл баганын аль нэгийг сонгоно уу?");

        Button row = new Button("Багана");
        row.setOnAction(ae->{
            ArrayList<Column> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable().getSelectedColumns();
         
                for (Column col : selected) {
                    Launcher.getTAILAN_MEDEELEL().getTailanTable().addColumns(col);
                }
                
                myStage.close();
               
        });
      
        Button column = new Button("Мөр");
        column.setOnAction(ae->{
            
                ArrayList<ArrayList<Object>> selected = Launcher.getTAILAN_LEFT_INNER().getCustomTable().getSelectedRows();
                Launcher.getTAILAN_MEDEELEL().getTailanTable().addRows(selected);
                myStage.close();
            
        }
        );
  
      

        rootNode.getChildren().setAll(lbl, row, column);
        myStage.show();

    }

}