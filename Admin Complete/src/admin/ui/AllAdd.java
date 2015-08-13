package admin.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class AllAdd extends Application{
    Button AdminOne , ManagerOne , TeacherOne ,StudentOne;

    public void start(Stage AllStage) throws Exception {
        AllStage.setTitle("Бүртгэлийн цонх");
        FlowPane AllPane = new FlowPane(20,20);
        AllPane.setAlignment(Pos.CENTER);
        AllPane.setStyle("-fx-background-color:#69BCE6;");
        AdminOne = new Button();
        AdminOne.setPrefSize(200, 200);
//        AdminOne.setStyle("-fx-background-image: url('/admin/ui/admin.png');"
        AdminOne.setStyle("-fx-background-image: url('/resource/images/admin.png');"
                + "-fx-background-repeat: stretch;"
                + "-fx-background-size: 200 200;"
                + "-fx-background-position: center center;"
                + "-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);");
        
        ManagerOne = new Button();
        ManagerOne.setPrefSize(200, 200);
        ManagerOne.setStyle("-fx-background-image: url('/resource/images/manager.png');"
                + "-fx-background-repeat: stretch;"
                + "-fx-background-size: 200 200;"
                + "-fx-background-position: center center;"
                + "-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);");
        TeacherOne = new Button();
        TeacherOne.setPrefSize(200, 200);
        TeacherOne.setStyle("-fx-background-image: url('/resource/images/teacher.png');"
                + "-fx-background-repeat: stretch;"
                + "-fx-background-size: 200 200;"
                + "-fx-background-position: center center;"
                + "-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);");
        StudentOne = new Button();
        StudentOne.setPrefSize(200, 200);
        StudentOne.setStyle("-fx-background-image: url('/resource/images/student.png');"
                + "-fx-background-repeat: stretch;"
                + "-fx-background-size: 200 200;"
                + "-fx-background-position: center center;"
                + "-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);");

        
        AllPane.getChildren().addAll(AdminOne,ManagerOne,TeacherOne,StudentOne);
        
        AdminOne.setOnAction(ae->{
            Stage stage = new Stage();
            try {
                new AddAdmin().start(stage);
            } catch (Exception ex) {
                Logger.getLogger(AllAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
            AllStage.close();
        });
        ManagerOne.setOnAction(ae->{
            Stage stage = new Stage();
            try {
                new AddManager().start(stage);
            } catch (Exception ex) {
                Logger.getLogger(AllAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
            AllStage.close();
        });
        TeacherOne.setOnAction(ae->{
            Stage stage = new Stage();
            try {
                new AddTeacher().start(stage);
            } catch (Exception ex) {
                Logger.getLogger(AllAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
            AllStage.close();
        });
        StudentOne.setOnAction(ae->{
            Stage stage = new Stage();
            try {
                new AddStudent().start(stage);
            } catch (Exception ex) {
                Logger.getLogger(AllAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
            AllStage.close();
        });
        
        Scene AllScene = new Scene(AllPane,600,600);
        AllStage.setScene(AllScene);
        AllStage.show();
    }
       
}
