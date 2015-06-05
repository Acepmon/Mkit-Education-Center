package ManagerPac;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ManagerProfile extends Application {
    
    private Pane managerPane;

    public Pane getManagerPane() {
        return managerPane;
    }

    public void setManagerPane(Pane managerPane) {
        this.managerPane = managerPane;
    }

    
    private Button browseBtn;
    
    private Label managerInfoLbl;
    private Label pictureLbl;
    
    private Label nameLbl;
    private Label classLbl;
    private Label joinDateLbl;
    
    private Label idLbl;
    private Label lastNameLbl;
    private Label firstNameLbl;
    private Label mobileLbl;
    private Label emailLbl;
    private Label addressLbl;
    private Label joinedLbl;
    private Label passwordLbl;
    
    private Label idInfoLbl;
    private Label lastInfoLbl;
    private Label firstInfoLbl;
    private Label mobileInfoLbl;
    private Label emailInfoLbl;
    private Label addressInfoLbl;
    private Label joinedInfoLbl;
    private Label passwordInfoLbl;
    
    private Button editIdBtn;
    private Button editLastBtn;
    private Button editFirstBtn;
    private Button editMobiBtn;
    private Button editEmailBtn;
    private Button editAddressBtn;
    private Button editJoinBtn;
    private Button editPassBtn;
    
    @Override
    public void start(Stage managerStage) {
        managerPane=new Pane();
        Scene managerScene=new Scene(managerPane, 590, 510);
        
        managerInfoLbl=new Label("Менежерийн мэдээлэл");
        managerInfoLbl.setPrefSize(300, 25);
        managerInfoLbl.setFont(Font.font("Verdana", 20));
        managerInfoLbl.setLayoutX(25);
        managerInfoLbl.setLayoutY(25);
        
        pictureLbl=new Label("Pic");
        pictureLbl.setPrefSize(80, 90);
        pictureLbl.setStyle("-fx-border-color:black");
        pictureLbl.setLayoutX(25);
        pictureLbl.setLayoutY(80);
        
        nameLbl=new Label("Нэр");
        nameLbl.setFont(Font.font("Verdana", 14));
        nameLbl.setPrefSize(50, 25);
        nameLbl.setLayoutX(125);
        nameLbl.setLayoutY(80);
        
        classLbl=new Label("Анги");
        classLbl.setFont(Font.font("Verdana", 14));
        classLbl.setPrefSize(50, 25);
        classLbl.setLayoutX(125);
        classLbl.setLayoutY(110);
        
        joinDateLbl=new Label("Элссэн огноо");
        joinDateLbl.setFont(Font.font("Verdana", 14));
        joinDateLbl.setPrefSize(120, 25);
        joinDateLbl.setLayoutX(125);
        joinDateLbl.setLayoutY(140);
        
        browseBtn=new Button("Зураг оруулах");
        browseBtn.setFont(Font.font("Verdana", 14));
        browseBtn.setPrefSize(150, 30);
        browseBtn.setLayoutX(425);
        browseBtn.setLayoutY(140);
        
        idLbl=new Label("Код");
        idLbl.setFont(Font.font("Verdana", 14));
        idLbl.setPrefSize(150, 25);
        idLbl.setLayoutX(25);
        idLbl.setLayoutY(190);
        
        idInfoLbl=new Label("Description");
        idInfoLbl.setId("info");
        idInfoLbl.setFont(Font.font("Verdana", 14));
        idInfoLbl.setPrefSize(300, 25);
        idInfoLbl.setLayoutX(185);
        idInfoLbl.setLayoutY(190);
        
        lastNameLbl=new Label("Овог");
        lastNameLbl.setFont(Font.font("Verdana", 14));
        lastNameLbl.setPrefSize(150, 25);
        lastNameLbl.setLayoutX(25);
        lastNameLbl.setLayoutY(230);
        
        lastInfoLbl=new Label("Description");
        lastInfoLbl.setId("info");
        lastInfoLbl.setFont(Font.font("Verdana", 14));
        lastInfoLbl.setPrefSize(300, 25);
        lastInfoLbl.setLayoutX(185);
        lastInfoLbl.setLayoutY(230);
        
        firstNameLbl=new Label("Нэр");
        firstNameLbl.setFont(Font.font("Verdana", 14));
        firstNameLbl.setPrefSize(150, 25);
        firstNameLbl.setLayoutX(25);
        firstNameLbl.setLayoutY(270);
        
        firstInfoLbl=new Label("Description");
        firstInfoLbl.setId("info");
        firstInfoLbl.setFont(Font.font("Verdana", 14));
        firstInfoLbl.setPrefSize(300, 25);
        firstInfoLbl.setLayoutX(185);
        firstInfoLbl.setLayoutY(270);
        
        mobileLbl=new Label("Утасны дугаар");
        mobileLbl.setFont(Font.font("Verdana", 14));
        mobileLbl.setPrefSize(150, 25);
        mobileLbl.setLayoutX(25);
        mobileLbl.setLayoutY(310);
        
        mobileInfoLbl=new Label("Description");
        mobileInfoLbl.setId("info");
        mobileInfoLbl.setFont(Font.font("Verdana", 14));
        mobileInfoLbl.setPrefSize(300, 25);
        mobileInfoLbl.setLayoutX(185);
        mobileInfoLbl.setLayoutY(310);
        
        emailLbl=new Label("И-мэйл хаяг");
        emailLbl.setFont(Font.font("Verdana", 14));
        emailLbl.setPrefSize(150, 25);
        emailLbl.setLayoutX(25);
        emailLbl.setLayoutY(350);
        
        emailInfoLbl=new Label("Description");
        emailInfoLbl.setId("info");
        emailInfoLbl.setFont(Font.font("Verdana", 14));
        emailInfoLbl.setPrefSize(300, 25);
        emailInfoLbl.setLayoutX(185);
        emailInfoLbl.setLayoutY(350);
        
        addressLbl=new Label("Гэрийн хаяг");
        addressLbl.setFont(Font.font("Verdana", 14));
        addressLbl.setPrefSize(150, 25);
        addressLbl.setLayoutX(25);
        addressLbl.setLayoutY(390);
        
        addressInfoLbl=new Label("Description");
        addressInfoLbl.setId("info");
        addressInfoLbl.setFont(Font.font("Verdana", 14));
        addressInfoLbl.setPrefSize(300, 25);
        addressInfoLbl.setLayoutX(185);
        addressInfoLbl.setLayoutY(390);
        
        joinedLbl=new Label("Элссэн огноо");
        joinedLbl.setFont(Font.font("Verdana", 14));
        joinedLbl.setPrefSize(150, 25);
        joinedLbl.setLayoutX(25);
        joinedLbl.setLayoutY(430);
        
        joinedInfoLbl=new Label("Description");
        joinedInfoLbl.setId("info");
        joinedInfoLbl.setFont(Font.font("Verdana", 14));
        joinedInfoLbl.setPrefSize(300, 25);
        joinedInfoLbl.setLayoutX(185);
        joinedInfoLbl.setLayoutY(430);
        
        passwordLbl=new Label("Нууц үг");
        passwordLbl.setFont(Font.font("Verdana", 14));
        passwordLbl.setPrefSize(150, 25);
        passwordLbl.setLayoutX(25);
        passwordLbl.setLayoutY(470);
        
        passwordInfoLbl=new Label("Description");
        passwordInfoLbl.setId("info");
        passwordInfoLbl.setFont(Font.font("Verdana", 14));
        passwordInfoLbl.setPrefSize(300, 25);
        passwordInfoLbl.setLayoutX(185);
        passwordInfoLbl.setLayoutY(470);
        
        editIdBtn=new Button("Засах");
        editIdBtn.setFont(Font.font("Verdana", 14));
        editIdBtn.setPrefSize(80, 25);
        editIdBtn.setLayoutX(495);
        editIdBtn.setLayoutY(188);
        
        editLastBtn=new Button("Засах");
        editLastBtn.setFont(Font.font("Verdana", 14));
        editLastBtn.setPrefSize(80, 25);
        editLastBtn.setLayoutX(495);
        editLastBtn.setLayoutY(228);
        
        editFirstBtn=new Button("Засах");
        editFirstBtn.setFont(Font.font("Verdana", 14));
        editFirstBtn.setPrefSize(80, 25);
        editFirstBtn.setLayoutX(495);
        editFirstBtn.setLayoutY(268);
        
        editMobiBtn=new Button("Засах");
        editMobiBtn.setFont(Font.font("Verdana", 14));
        editMobiBtn.setPrefSize(80, 25);
        editMobiBtn.setLayoutX(495);
        editMobiBtn.setLayoutY(308);
        
        editEmailBtn=new Button("Засах");
        editEmailBtn.setFont(Font.font("Verdana", 14));
        editEmailBtn.setPrefSize(80, 25);
        editEmailBtn.setLayoutX(495);
        editEmailBtn.setLayoutY(348);
        
        editAddressBtn=new Button("Засах");
        editAddressBtn.setFont(Font.font("Verdana", 14));
        editAddressBtn.setPrefSize(80, 25);
        editAddressBtn.setLayoutX(495);
        editAddressBtn.setLayoutY(388);
        
        editJoinBtn=new Button("Засах");
        editJoinBtn.setFont(Font.font("Verdana", 14));
        editJoinBtn.setPrefSize(80, 25);
        editJoinBtn.setLayoutX(495);
        editJoinBtn.setLayoutY(428);
        
        editPassBtn=new Button("Засах");
        editPassBtn.setFont(Font.font("Verdana", 14));
        editPassBtn.setPrefSize(80, 25);
        editPassBtn.setLayoutX(495);
        editPassBtn.setLayoutY(468);
        
        managerPane.getChildren().addAll(
                managerInfoLbl,
                pictureLbl, 
                nameLbl, 
                classLbl,
                joinDateLbl,
                browseBtn,
                idLbl,
                idInfoLbl,
                lastNameLbl,
                lastInfoLbl,
                firstNameLbl,
                firstInfoLbl,
                mobileLbl,
                mobileInfoLbl,
                emailLbl,
                emailInfoLbl,
                addressLbl,
                addressInfoLbl,
                joinedLbl,
                joinedInfoLbl,
                passwordLbl,
                passwordInfoLbl,
                editIdBtn,
                editLastBtn,
                editFirstBtn,
                editMobiBtn,
                editEmailBtn,
                editAddressBtn,
                editJoinBtn,
                editPassBtn
        );
        
        managerStage.setResizable(false);
        managerStage.setScene(managerScene);
        managerStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
