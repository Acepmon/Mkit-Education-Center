//package teacher.ui;
//
//import javafx.geometry.Pos;
//import javafx.scene.control.Label;
//import javafx.scene.layout.FlowPane;
//import teacher.launch.Launcher;
//
//public class Shalgalt_dun_left {
//    
//    private FlowPane leftFp;
//    
//    public Shalgalt_dun_left(){
//        
//        leftFp = new FlowPane(20,20);
//        leftFp.setPrefSize(250, 708);
//        leftFp.setStyle("-fx-background-color: #F6F6F7");
//        leftFp.setAlignment(Pos.CENTER);
//         
//        Label nameLbl = new Label("Шалгалтын дүн оруулах");
//        nameLbl.setAlignment(Pos.CENTER);
//        nameLbl.setPrefSize(250, 60);
//        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
//        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
//        nameLbl.setId("text");
//       
//        FlowPane huvaariFp = new FlowPane();
//        
//        huvaariFp.setPrefSize(220, 500);
//        huvaariFp.getChildren().add(new Label("adasd as"));       
//        huvaariFp.setId("panel");
//                
//        FlowPane textFp = new FlowPane(10,5);
//        textFp.setPrefSize(200, 180);
//       
//        
//        
//        
//        ///events
//        
//        textFp.getChildren().addAll();
//        leftFp.getChildren().addAll(nameLbl, Launcher.().getContainer(), textFp);
//        leftFp.setId("border");
//    }
//    public FlowPane getContainer() {
//        return this.leftFp;
//    }
//}