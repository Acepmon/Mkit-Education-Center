//package teacher.ui;
//
//import java.util.ArrayList;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.FlowPane;
//import teacher.controller.ClientTest;
//import teacher.launch.Launcher;
//import teacher.login.ui.CustomerLogin;
//
//public class Shalgat_dun_center {
//
//    private BorderPane centerFp;
//
//    public Shalgat_dun_center() {
//
//        ArrayList<String> admingetall = (ArrayList<String>) (ClientTest.RequestAjluulah("adminGetAllStudents", null));
//        System.out.println("askljdfbdfbjasdbfjsadbf"+admingetall);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
//        
//        for(int i = 0; i<admingetall.size(); i++){
//            
//            String[] arr = admingetall.get(i).split("::");
//            Launcher.getSHALGALT_DUN_LEFT_INNER().colorPane.getChildren().add(new ImageView());
//            Launcher.getSHALGALT_DUN_LEFT_INNER().oyutan.getChildren().add(new Label(arr[1]));
//            
//        }
//        
//        centerFp = new BorderPane();
//        centerFp.setPrefSize(774, 688);
//        centerFp.setStyle("-fx-background-color: white");
//
//        //centerFp.setAlignment(Pos.CENTER);
//        //////title 
//        Label nameLbl = new Label("Оруулж буй оюутны нэр");
//        nameLbl.setAlignment(Pos.CENTER);
//        nameLbl.setPrefSize(774, 60);
//        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
//        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
//        nameLbl.setId("text");
//
//        ///////////////////////////////////////
//        FlowPane newsFp = new FlowPane(20,20);
//        newsFp.setPrefSize(30, 50);
//        newsFp.setAlignment(Pos.CENTER);
//        newsFp.setId("panel");
//        
//        FlowPane newsFp2 = new FlowPane(20,20);
//        newsFp2.setPrefSize(30, 50);
//        newsFp2.setAlignment(Pos.CENTER);
//        newsFp2.setId("panel");
//        
//        FlowPane newsFp3 = new FlowPane(20,20);
//        newsFp3.setPrefSize(30, 30);
//        newsFp3.setPadding(new Insets(50, 20, 20, 20 ));
//        newsFp3.setAlignment(Pos.TOP_CENTER);
//        newsFp3.setId("panel");
//        
//        Label shalgaltLb = new Label("Шалгалтын нэр:");
//        shalgaltLb.setPrefSize(100, 20);
//        ComboBox ShalgaltCm = new ComboBox();
//        ShalgaltCm.setPrefSize(200, 20);
//        ShalgaltCm.getItems().addAll(
//                "Ирцээр",
//                "Дүнгээр",
//                "Явцын дүнгээр",
//                "Оюутны нэрээр",
//                "Ангиар"
//        );
//        Label enterLb = new Label("Оруулах дүн:");
//        enterLb.setPrefSize(100, 20);
//        
//        TextField enterDun = new TextField();
//        enterDun.setPrefSize(200, 20);
//        
//        Button enterBtn = new Button("Оруулах");
//        enterBtn.setPrefSize(200, 20);
//        enterBtn.setId("green");
//
//        newsFp.getChildren().addAll(shalgaltLb,ShalgaltCm);
//        newsFp2.getChildren().addAll(enterLb,enterDun);
//        newsFp3.getChildren().addAll(newsFp,newsFp2,enterBtn);
//
//        centerFp.setTop(nameLbl);
//        centerFp.setCenter(newsFp3);
//
//        centerFp.setId("border");
//        
//    }
//
//    public BorderPane getContainer() {
//        return this.centerFp;
//    }
//}
