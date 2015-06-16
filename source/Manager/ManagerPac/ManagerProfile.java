package ManagerPac;

import Controller.ClientTest;
import java.awt.event.KeyEvent;
import java.io.File;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ManagerProfile {
    
    private Pane managerPane;

    public Pane getManagerPane() {
        return managerPane;
    }

    public void setManagerPane(Pane managerPane) {
        this.managerPane=managerPane;
    }

    
    private Button browseBtn;
    
    private Label managerInfoLbl;
    private Label pictureLbl;
    
    private Label nameLbl;
    private Label idLbl;
    
    private Label codeLbl;
    private Label lastNameLbl;
    private Label firstNameLbl;
    private Label mobileLbl;
    private Label emailLbl;
    private Label addressLbl;
    private Label statusLbl;
    
    private TextField pictureFld;
    
    private TextField idFld;
    private TextField lastNameFld;
    private TextField firstNameFld;
    private TextField mobileFld;
    private TextField emailFld;
    private TextField addressFld;
    
    private ComboBox statusCmBox;
    
    private Button editBtn;
    
    private ManagerObj manager;
    
    private String id;
    private String idOld;
    private String lastName;
    private String firstName;
    private String mobile;
    private String email;
    private String address;
    private int status;
    private String update="";
    
    FileChooser fileChooser;
    File file;
    
    public void start(Stage managerStage) {
        managerPane=new Pane();
        Scene managerScene=new Scene(managerPane, 505, 470);
        String responseData=(String) ClientTest.RequestAjluulah("getManProfile", Launcher.getMANAGER().managerMenu.getText());
        
        String[] cols=responseData.split("::");
        manager=new ManagerObj(cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], cols[6], cols[7]);
        
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
        
        nameLbl=new Label();
        nameLbl.setFont(Font.font("Verdana", 14));
        nameLbl.setPrefSize(150, 25);
        nameLbl.setLayoutX(125);
        nameLbl.setLayoutY(80);
        nameLbl.setText(manager.getName());
        
        codeLbl=new Label();
        codeLbl.setFont(Font.font("Verdana", 14));
        codeLbl.setPrefSize(150, 25);
        codeLbl.setLayoutX(125);
        codeLbl.setLayoutY(110);
        codeLbl.setText(manager.getId());
        
        pictureFld=new TextField();
        pictureFld.setPrefSize(150, 25);
        pictureFld.setLayoutX(335);
        pictureFld.setLayoutY(90);
        pictureFld.setPromptText("Зурагийн нэр");
        
        browseBtn=new Button("Зураг оруулах");
        browseBtn.setFont(Font.font("Verdana", 14));
        browseBtn.setPrefSize(150, 30);
        browseBtn.setLayoutX(335);
        browseBtn.setLayoutY(140);
        browseBtn.setOnAction(ae-> {
            fileChooser=new FileChooser();
            FileChooser.ExtensionFilter allFilter=new FileChooser.ExtensionFilter("All files", "*.*");
            fileChooser.getExtensionFilters().addAll(allFilter);
            file=fileChooser.showOpenDialog(null);
            pictureFld.setText(""+file.getName());
        });
        
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
        
        statusLbl=new Label("Статус");
        statusLbl.setFont(Font.font("Verdana", 14));
        statusLbl.setPrefSize(150, 25);
        statusLbl.setLayoutX(25);
        statusLbl.setLayoutY(430);
        
        idFld=new TextField();
        idFld.setId("info");
        idFld.setPrefSize(300, 25);
        idFld.setLayoutX(185);
        idFld.setLayoutY(190);
        idFld.setText(manager.getId());
        idFld.setEditable(false);
        
        lastNameFld=new TextField();
        lastNameFld.setId("info");
        lastNameFld.setPrefSize(300, 25);
        lastNameFld.setLayoutX(185);
        lastNameFld.setLayoutY(230);
        lastNameFld.setText(manager.getSurname());
        lastNameFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            String sag=firstNameFld.getText();
            if(!(((c>='a')||(c>='A'))&&((c<='z')||(c<='Z'))||((c>='a')||(c>='A'))&&((c<='я')||(c<='Я'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        firstNameFld=new TextField();
        firstNameFld.setId("info");
        firstNameFld.setPrefSize(300, 25);
        firstNameFld.setLayoutX(185);
        firstNameFld.setLayoutY(270);
        firstNameFld.setText(manager.getName());
        firstNameFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            String sag=firstNameFld.getText();
            if(!(((c>='a')||(c>='A'))&&((c<='z')||(c<='Z'))||((c>='a')||(c>='A'))&&((c<='я')||(c<='Я'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        mobileFld=new TextField();
        MobileField();
        
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
        
        ObservableList<String> stat=FXCollections.observableArrayList(
                "Суралцаж байгаа", 
                "Төгссөн", 
                "Хүлээгдэж байгаа", 
                "Ажиллаж байгаа", 
                "Ажиллахаа больсон"
        );
        statusCmBox=new ComboBox<String>(stat);
        statusCmBox.setPrefSize(170, 25);
        statusCmBox.setLayoutX(185);
        statusCmBox.setLayoutY(430);
        statusCmBox.getSelectionModel().select(Integer.parseInt(manager.getStatus()));
        
        editBtn=new Button("Засах");
        editBtn.setPrefSize(100, 25);
        editBtn.setLayoutX(385);
        editBtn.setLayoutY(430);
        editBtn.setOnAction(ae-> {
            int answer=JOptionPane.showConfirmDialog(null, "Засах уу?");
            if(answer==JOptionPane.YES_OPTION) {
                getManagerInfo();
                ClientTest.RequestAjluulah("updateManager", ""+update+"");
            }
        });
        
        managerPane.getChildren().addAll(
                managerInfoLbl,
                pictureLbl, 
                nameLbl,
                codeLbl,
                pictureFld,
                browseBtn,
                idLbl,
                lastNameLbl,
                firstNameLbl,
                mobileLbl,
                emailLbl,
                addressLbl,
                statusLbl,
                idFld,
                lastNameFld,
                firstNameFld,
                mobileFld,
                emailFld,
                addressFld,
                statusCmBox,
                editBtn
        );
        
        managerScene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
        
        managerStage.setResizable(false);
        managerStage.setScene(managerScene);
        managerStage.show();
    }
    
    private void MobileField() {
        final int limit=8;
        mobileFld.setId("info");
        mobileFld.setPrefSize(300, 25);
        mobileFld.setLayoutX(185);
        mobileFld.setLayoutY(310);
        mobileFld.setText(manager.getPhone());
        mobileFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            if(!((c>='0')&&(c<='9')|| (c == '+') ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        mobileFld.textProperty().addListener((Observable observable) -> {
            String value=((StringProperty)observable).get();
            if(value.length()>limit) {
                mobileFld.textProperty().setValue(value.substring(0, limit));
            }
        });
    }
    
    public void getManagerInfo() {
        id=idFld.getText();
        idOld=manager.getId();
        lastName=lastNameFld.getText();
        firstName=firstNameFld.getText();
        mobile=mobileFld.getText();
        email=emailFld.getText();
        address=addressFld.getText();
        status=statusCmBox.getSelectionModel().getSelectedIndex()+1;
        update=id+"::"+lastName+"::"+firstName+"::"+mobile+"::"+address+"::"+email+"::"+status+"::"+"Picture123"+"::"+idOld;
    }
}
