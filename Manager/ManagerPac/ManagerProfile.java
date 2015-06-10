package ManagerPac;

import Controller.ClientTest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ManagerProfile {
    
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
    
    private TextField idFld;
    private TextField lastNameFld;
    private TextField firstNameFld;
    private TextField mobileFld;
    private TextField emailFld;
    private TextField addressFld;
    private TextField joinedFld;
    private TextField passwordFld;
    
    private Button editIdBtn;
    private Button editLastBtn;
    private Button editFirstBtn;
    private Button editMobiBtn;
    private Button editEmailBtn;
    private Button editAddressBtn;
    private Button editJoinBtn;
    private Button editPassBtn;
    
    private ManagerObj manager;
    
    public void start(Stage managerStage) {
        managerPane=new Pane();
        Scene managerScene=new Scene(managerPane, 590, 510);
        String responseData = (String) ClientTest.RequestAjluulah("getManProfile", Launcher.getMANAGER().getUserName());
//        String responseData=("manager001::Suns::Chotgor::88998899::shulam@gmail.com::alialagch::Saran deer amidragch::2015-04-01");
//                
//        for(String str: responseData){
//            String[] cols = str.split("::");
//            manager = new ManagerObj(cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], cols[6], cols[7]);
//        }
        
        String[] cols = responseData.split("::");
        manager = new ManagerObj(cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], "", "");
        
        
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
        
        lastNameLbl=new Label("Овог");
        lastNameLbl.setFont(Font.font("Verdana", 14));
        lastNameLbl.setPrefSize(150, 25);
        lastNameLbl.setLayoutX(25);
        lastNameLbl.setLayoutY(230);
        
        firstNameLbl=new Label("Нэр");
        firstNameLbl.setFont(Font.font("Verdana", 14));
        firstNameLbl.setPrefSize(150, 25);
        firstNameLbl.setLayoutX(25);
        firstNameLbl.setLayoutY(270);
        
        mobileLbl=new Label("Утасны дугаар");
        mobileLbl.setFont(Font.font("Verdana", 14));
        mobileLbl.setPrefSize(150, 25);
        mobileLbl.setLayoutX(25);
        mobileLbl.setLayoutY(310);
        
        emailLbl=new Label("И-мэйл хаяг");
        emailLbl.setFont(Font.font("Verdana", 14));
        emailLbl.setPrefSize(150, 25);
        emailLbl.setLayoutX(25);
        emailLbl.setLayoutY(350);
        
        addressLbl=new Label("Гэрийн хаяг");
        addressLbl.setFont(Font.font("Verdana", 14));
        addressLbl.setPrefSize(150, 25);
        addressLbl.setLayoutX(25);
        addressLbl.setLayoutY(390);
        
        joinedLbl=new Label("Элссэн огноо");
        joinedLbl.setFont(Font.font("Verdana", 14));
        joinedLbl.setPrefSize(150, 25);
        joinedLbl.setLayoutX(25);
        joinedLbl.setLayoutY(430);
        
        passwordLbl=new Label("Нууц үг");
        passwordLbl.setFont(Font.font("Verdana", 14));
        passwordLbl.setPrefSize(150, 25);
        passwordLbl.setLayoutX(25);
        passwordLbl.setLayoutY(470);
        
        
        idFld=new TextField();
        idFld.setId("info");
        idFld.setPrefSize(300, 25);
        idFld.setLayoutX(185);
        idFld.setLayoutY(190);
        idFld.setText(manager.getId());
        
        lastNameFld=new TextField();
        lastNameFld.setId("info");
        lastNameFld.setPrefSize(300, 25);
        lastNameFld.setLayoutX(185);
        lastNameFld.setLayoutY(230);
        lastNameFld.setText(manager.getSurname());
        
        firstNameFld=new TextField();
        firstNameFld.setId("info");
        firstNameFld.setPrefSize(300, 25);
        firstNameFld.setLayoutX(185);
        firstNameFld.setLayoutY(270);
        firstNameFld.setText(manager.getName());
        
        mobileFld=new TextField();
        mobileFld.setId("info");
        mobileFld.setPrefSize(300, 25);
        mobileFld.setLayoutX(185);
        mobileFld.setLayoutY(310);
        mobileFld.setText(manager.getPhone());
        
        emailFld=new TextField();
        emailFld.setId("info");
        emailFld.setPrefSize(300, 25);
        emailFld.setLayoutX(185);
        emailFld.setLayoutY(350);
        emailFld.setText(manager.getEmail());
        
        addressFld=new TextField();
        addressFld.setId("info");
        addressFld.setPrefSize(300, 25);
        addressFld.setLayoutX(185);
        addressFld.setLayoutY(390);
        addressFld.setText(manager.getAddress());
        
        joinedFld=new TextField();
        joinedFld.setId("info");
        joinedFld.setPrefSize(300, 25);
        joinedFld.setLayoutX(185);
        joinedFld.setLayoutY(430);
        joinedFld.setText(manager.getJoinedDate());
        
        passwordFld=new TextField();
        passwordFld.setId("info");
        passwordFld.setPrefSize(300, 25);
        passwordFld.setLayoutX(185);
        passwordFld.setLayoutY(470);
        passwordFld.setText(manager.getPassword());
        
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
                lastNameLbl,
                firstNameLbl,
                mobileLbl,
                emailLbl,
                addressLbl,
                joinedLbl,
                passwordLbl,
                idFld,
                lastNameFld,
                firstNameFld,
                mobileFld,
                emailFld,
                addressFld,
                joinedFld,
                passwordFld,
                editIdBtn,
                editLastBtn,
                editFirstBtn,
                editMobiBtn,
                editEmailBtn,
                editAddressBtn,
                editJoinBtn,
                editPassBtn
        );
        
        managerScene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
        
        managerStage.setResizable(false);
        managerStage.setScene(managerScene);
        managerStage.show();
    }
}
