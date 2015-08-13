package admin.ui;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import login.ui.ServerConnection;

public class EditAdmin {
    
    private Desktop desktop = Desktop.getDesktop();

    private ComboBox<String> ClassBox;
//    FileChooser fileChooser;
//    Дээр FileChooser
    String statusId;
    ComboBox cbStatus;
   
    Label ProfileImage,
            adminID,
            adminReg,
            lastName,
            firstName,
            phoneNumber,
            homeAddress,
            emailAddress,
            socialAddress,
            className,
            comNum,
            studentRegDate,
            status,
            idLabel,
            username,
            password,
            delFlag,
            
            idError,
            regError,
            lastNameError,
            firstNameError,
            phoneNumberError,
            homeAddressError,
            emailAddressError,
            socialError,
            deleteError,
            userError,
            passError,
            statusError;

    TextField TextID,
            TextRegister,
            TextLastName,
            TextFirstName,
            TextPhoneNumber,
            TextHomeAddress,
            TextEmailAddress,
            TextDelFlag,
            TextClassName,
            TextComNum,
            TextStatus,
            TextUser,
            TextPass     
            ;
    PasswordField PassField;
    Button buttonEdit, buttonExit;
    Button browse;
    TextArea AreaHomeAddress, TextSocial;
    ImageView myImageView;
    Image topImage;
    private  EventHandler<ActionEvent> btnLoadEventListener;
    File file;
    
    public void start(Stage editAdminStage, AdminObj datas) throws Exception {
        
        editAdminStage.setTitle("Админ Засах");
        
        FlowPane editPane = new FlowPane(10, 10);
        editPane.setAlignment(Pos.CENTER);
        Scene addScene = new Scene(editPane, 400, 750);
        addScene.getStylesheets().add(getClass().getResource("style/css1.css").toExternalForm());
        
        AnchorPane anch = new AnchorPane();
        topImage = new Image("resource/images/images.png");
        ImageView topView = new ImageView(topImage);
        anch.getChildren().add(topView);

//        fileChooser = new FileChooser();        
//        if(datas != null){
//            System.out.println("baina");
//        }
//        else {
//            System.out.println("baihgui");
//        }
        
        String idt = datas.getId();
        String regt = datas.getRegister();
        String lastNamet = (datas).getLastName();
        String firstNamet = (datas).getFirstName();
        String statust = (datas).getStatus();
        String phoneNumt = (datas).getPhoneNum();
        String emailt = (datas).getEmail();
        String usert = datas.getUsername();
        String passt = datas.getPassword();
        String socialt = datas.getSocial();
        String addresst = (datas).getAddress();
        String delt = datas.getDeleteFlag();
            
             
        browse = new Button(" Зураг оруулах");
        browse.setPrefSize(150, 30);
        browse.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");
        browse.setOnAction(ae -> {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
              
            //Show opXZen file dialog
             file = fileChooser.showOpenDialog(null);
                       
            try {
                if (file != null) {
                    BufferedImage bufferedImage = ImageIO.read(file);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    myImageView.setImage(image);
                }
            } catch (IOException ex) {
                Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
                
        
        idLabel = new Label("");
        idLabel.setPrefSize(280, 10);
        idLabel.setAlignment(Pos.CENTER);
        
        idError = new Label("***");
        idError.setPrefSize(20, 20);
        idError.setStyle("-fx-text-fill: red"); 
        idError.setVisible(false);
        
        regError = new Label("***");
        regError.setPrefSize(20, 20);
        regError.setStyle("-fx-text-fill: red"); 
        regError.setVisible(false);
        
        lastNameError = new Label("***");
        lastNameError.setPrefSize(20, 20);
        lastNameError.setStyle("-fx-text-fill: red"); 
        lastNameError.setVisible(false);
        
        firstNameError = new Label("***");
        firstNameError.setPrefSize(20, 20);
        firstNameError.setStyle("-fx-text-fill: red"); 
        firstNameError.setVisible(false);
        
        phoneNumberError = new Label("***");
        phoneNumberError.setPrefSize(20, 20);
        phoneNumberError.setStyle("-fx-text-fill: red"); 
        phoneNumberError.setVisible(false);
        
        emailAddressError = new Label("***");
        emailAddressError.setPrefSize(20, 20);
        emailAddressError.setStyle("-fx-text-fill: red"); 
        emailAddressError.setVisible(false);
        
        socialError = new Label("***");
        socialError.setPrefSize(20, 20);
        socialError.setStyle("-fx-text-fill: red"); 
        socialError.setVisible(false);        
        
        homeAddressError = new Label("***");
        homeAddressError.setPrefSize(20, 20);
        homeAddressError.setStyle("-fx-text-fill: red"); 
        homeAddressError.setVisible(false);
        
        deleteError = new Label("***");
        deleteError.setPrefSize(20, 20);
        deleteError.setStyle("-fx-text-fill: red"); 
        deleteError.setVisible(false);
        
        statusError = new Label("***");
        statusError.setPrefSize(20, 20);
        statusError.setStyle("-fx-text-fill: red"); 
        statusError.setVisible(false);    
        
        userError = new Label("***");
        userError.setPrefSize(20, 20);
        userError.setStyle("-fx-text-fill: red"); 
        userError.setVisible(false);  
        
        passError = new Label("***");
        passError.setPrefSize(20, 20);
        passError.setStyle("-fx-text-fill: red"); 
        passError.setVisible(false);
        
        myImageView = new ImageView();
        myImageView.setPreserveRatio(false);
         
        myImageView.setFitHeight(180);
        myImageView.setFitWidth(150);
                 
        adminID = new Label("Админ дугаар: ");
        adminID.setFont(Font.font(null, FontWeight.BOLD, 12));
        adminID.setPrefSize(150, 20);

        TextID = new TextField();
        TextID.setPrefSize(150, 20);
        TextID.setText(idt);
        
        adminReg = new Label("Регистер: ");
        adminReg.setFont(Font.font(null, FontWeight.BOLD, 12));
        adminReg.setPrefSize(150, 20);
        
        TextRegister = new TextField();
        TextRegister.setPrefSize(150, 20);
        TextRegister.setText(regt);

        lastName = new Label("Овог: ");
        lastName.setFont(Font.font(null, FontWeight.BOLD, 12));
        lastName.setPrefSize(150, 20);

        TextLastName = new TextField();
        TextLastName.setPrefSize(150, 20);
        TextLastName.setText(lastNamet);

        firstName = new Label("Нэр: ");
        firstName.setFont(Font.font(null, FontWeight.BOLD, 12));
        firstName.setPrefSize(150, 20);
        
        TextFirstName = new TextField();
        TextFirstName.setPrefSize(150, 20);
        TextFirstName.setText(firstNamet);
        
        phoneNumber = new Label("Утасны дугаар: ");
        phoneNumber.setFont(Font.font(null, FontWeight.BOLD, 12));
        phoneNumber.setPrefSize(150, 20);
        
        TextPhoneNumber = new TextField();
        TextPhoneNumber.setPrefSize(150, 20);
        TextPhoneNumber.setText(phoneNumt);        
        
        homeAddress = new Label("Гэрийн хаяг: ");
        homeAddress.setFont(Font.font(null, FontWeight.BOLD, 12));
        homeAddress.setPrefSize(150, 20);        
        
        AreaHomeAddress = new TextArea();
        AreaHomeAddress.setPrefSize(150, 50);
        AreaHomeAddress.setText(addresst);
        
        socialAddress = new Label("Сошиал: ");
        socialAddress.setFont(Font.font(null, FontWeight.BOLD, 12));
        socialAddress.setPrefSize(150, 50);
        
        TextSocial = new TextArea();
        TextSocial.setPrefSize(150, 50);
        TextSocial.setText(socialt);
        
        PassField = new PasswordField();
        PassField.setPrefSize(150, 20);
        PassField.setText("8-character minimum");           
        
        emailAddress = new Label("Email Address:");
        emailAddress.setFont(Font.font(null, FontWeight.BOLD, 12));
        emailAddress.setPrefSize(150, 20);        
        
        TextEmailAddress = new TextField();
        TextEmailAddress.setPrefSize(150, 20);
        TextEmailAddress.setText(emailt);  
        
        username = new Label("Нэвтрэх нэр:");
        username.setFont(Font.font(null, FontWeight.BOLD, 12));
        username.setPrefSize(150, 20);
        
        TextUser = new TextField();
        TextUser.setPrefSize(150, 20);
        TextUser.setText(usert);
        
        password = new Label("Нууц үг:");
        password.setFont(Font.font(null, FontWeight.BOLD, 12));
        password.setPrefSize(150, 20);
        
        TextPass = new TextField();
        TextPass.setPrefSize(150, 20);
        TextPass.setText(passt);
        
        delFlag = new Label("Delete Flag");
        delFlag.setFont(Font.font(null, FontWeight.BOLD, 12));
        delFlag.setPrefSize(150, 20);
        
        TextDelFlag = new TextField();
        TextDelFlag.setPrefSize(150, 20);
        TextDelFlag.setText(delt);
        
        status = new Label("Статус");
        status.setFont(Font.font(null, FontWeight.BOLD, 12));
        status.setPrefSize(150, 20);
        
        ObservableList<String> statusTypes = FXCollections.observableArrayList("Суралцаж байгаа", "Төгссөн", "Хүлээгдэж байгаа", "Ажиллаж байгаа", "Ажиллахаа больсон");
        cbStatus = new ComboBox<String>(statusTypes);
        cbStatus.setPrefSize(150, 20);
        
        cbStatus.setValue("Суралцаж байгаа");
        cbStatus.setOnAction(ae->{            
            System.out.println("Selected status is " + cbStatus.getValue());
        });
        
        
        Pane img_cont = new Pane(myImageView);
        img_cont.setStyle("-fx-background-image: url('resource/images/no_photo.jpg');"
                + "-fx-background-size: 150 180;");
        img_cont.setPrefSize(150, 180);
        editPane.getChildren().add(img_cont);
        

        editPane.getChildren().addAll(
                browse,
                adminID,
                TextID,
                idError,
                
                adminReg,
                TextRegister,
                regError,
                
                lastName,
                TextLastName,
                lastNameError,
                
                firstName, 
                TextFirstName,
                firstNameError,
                
                status, 
                cbStatus,
                statusError,
                
                phoneNumber, 
                TextPhoneNumber,
                phoneNumberError,
                
                emailAddress,
                TextEmailAddress,
                emailAddressError,
                
                socialAddress,
                TextSocial,
                socialError,
                
                homeAddress, 
                AreaHomeAddress,
                homeAddressError,
                
                username,
                TextUser,
                userError,
                
                password,
                TextPass,
                passError,
                
                delFlag,
                TextDelFlag,
                deleteError,
                
                idLabel
        
        );

        buttonEdit = new Button("Хадгалах");
        buttonEdit.setPrefSize(120, 30);
        buttonEdit.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 14px;");

        editPane.getChildren().add(buttonEdit);        
        
        buttonEdit.setOnAction(ae-> {
            
                    if(cbStatus.getValue().equals("Суралцаж байгаа")){
                        statusId = "1";
                    }
                    else if(cbStatus.getValue().equals("Төгссөн")){
                        statusId = "2";
                    } 
                    else if(cbStatus.getValue().equals("Хүлээгдэж байгаа")){
                        statusId = "3";
                    } 
                    else if(cbStatus.getValue().equals("Ажиллаж байгаа")){
                        statusId = "4";
                    }
                    else if(cbStatus.getValue().equals("Ажиллахаа больсон")){
                        statusId = "5";
                    }                    
                    System.out.println(statusId);
                    
                    String Admin_id = ((AdminObj)Admin.table.getSelectionModel().getSelectedItem()).getId();
                    System.out.println("AdminID--->"+Admin_id);
                    
                    String idNew = TextID.getText();
                    String regNew = TextRegister.getText();
                    String lastNameNew = TextLastName.getText();
                    String firstNameNew = TextFirstName.getText();
//                    status
                    String phoneNumNew = TextPhoneNumber.getText();
                    String emailNew = TextEmailAddress.getText();
                    String socialNew = TextSocial.getText();
                    String addressNew = AreaHomeAddress.getText();                    
//                    picture
                    String delNew = TextDelFlag.getText();
                    String userNew = TextUser.getText();
                    String passNew = TextPass.getText(); 
                    
                    
                    ServerConnection.RequestAjluulah("updateAdmin", ""+idNew+"::"+regNew+"::"+lastNameNew+"::"+firstNameNew+"::"+statusId+"::"+phoneNumNew+"::"+emailNew+"::"+socialNew+"::"+addressNew+"::null::"+delNew+"::"+userNew+"::"+passNew+""+Admin_id+"");
                    
                    Admin.data.remove(Admin.rowIndex);
                    
                    Admin.data.add(new AdminObj(idNew, regNew, lastNameNew, firstNameNew, statusId, phoneNumNew, emailNew, socialNew, addressNew,  "null", delNew, userNew, passNew));
                   
                    if(file == null){
                        idLabel.setStyle("-fx-text-fill: blue");
                        idLabel.setText("Зураг оруулна уу!!!");
                        idLabel.setVisible(true);
                    }
                    else{
                        idLabel.setVisible(false);
                    }            
                    if(TextID.getText().equals("")){
                        idLabel.setStyle("-fx-text-fill: blue");    
                        idError.setVisible(true);
                    }
                    else{
                        idError.setVisible(false);
                    }
                    if(TextLastName.getText().equals("")){
                        idLabel.setStyle("-fx-text-fill: red");  
                        lastNameError.setVisible(true);
                    }
                    else{
                        lastNameError.setVisible(false);
                    }
                    if(TextFirstName.getText().equals("")){
                        idLabel.setStyle("-fx-text-fill: green");   
                        firstNameError.setVisible(true);
                    }
                    else{
                        firstNameError.setVisible(false);
                    }
                    if(TextPhoneNumber.getText().equals("")){
                        idLabel.setStyle("-fx-text-fill: yellow");   
                        phoneNumberError.setVisible(true);
                    }
                    else{
                        phoneNumberError.setVisible(false);
                    }
                    if(AreaHomeAddress.getText().equals("")){
                        idLabel.setStyle("-fx-text-fill: #990021");
                        homeAddressError.setVisible(true);
                    }
                    else{
                        homeAddressError.setVisible(false);
                    }
                    if(TextEmailAddress.getText().equals("")){
                        idLabel.setStyle("-fx-text-fill: black");
                        emailAddressError.setVisible(true);
                    }
                    else{
                        emailAddressError.setVisible(false);
                    }

                    if (!idLabel.isVisible() && !idError.isVisible() && !lastNameError.isVisible() && !firstNameError.isVisible() &&
                           !phoneNumberError.isVisible() && !homeAddressError.isVisible() && !emailAddressError.isVisible() && !homeAddressError.isVisible()) {
                        editAdminStage.close();
                    }
                    
                    editAdminStage.close();
                    
                });
        
        buttonExit = new Button("Буцах");
        buttonExit.setPrefSize(120, 30);
        buttonExit.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 14px;");

        editPane.getChildren().add(buttonExit);
        buttonExit.setOnAction(ae->{
            editAdminStage.close();
        });
        
        editAdminStage.setScene(addScene);
        editAdminStage.show();
//        editAdminStage.setResizable(false);

    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (Exception e) {
            Logger.getLogger(EditAdmin.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
