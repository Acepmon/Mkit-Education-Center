package admin.ui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
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

public class AddTeacher extends Application {

    private Desktop desktop = Desktop.getDesktop();

    private ComboBox<String> ClassBox;    
    String statusId, className;
    ComboBox cbStatus;
   
    Label ProfileImage,
            AddID,
            register,
            lastName,
            firstName,
            status,
            subject,
            phoneNumber,
            EmailAddress,
            social,            
            homeAddress,
            username,
            password,
            deleteFlag,
            picture,
            
            idLabel,            
            idError,
            regError,
            lastNameError,
            firstNameError,
            subjectError,
            phoneNumberError,
            homeAddressError,
            emailAddressError,
            socialError,
            deleteFlagError,
            usernameError,
            passError,
            statusError;

    TextField TextAddID,
            TextRegister,
            TextLastName,
            TextFirstName,
            TextSubject,
            TextPhoneNumber,
            TextComputerNumber,
            TextTeacherRegDate,
            TextEmailAddress,
            TextDeleteFlag,
            TextUser,
            TextPass 
            ;
    PasswordField PassField;
    Button buttonAdd;
    Button browse;
    TextArea AreaHomeAddress, TextSocial;
    ImageView myImageView;
    Image topImage;
    private  EventHandler<ActionEvent> btnLoadEventListener;
    File file;
    
    public void start(Stage AddStage) throws Exception {
        AddStage.setTitle("Багш нэмэх");
        FlowPane AddPane = new FlowPane(10, 10);
        AddPane.setAlignment(Pos.CENTER);
        Scene addScene = new Scene(AddPane, 400, 750);
        
        AnchorPane anch = new AnchorPane();
        topImage = new Image("resource/images/images.png");
        ImageView topView = new ImageView(topImage);
        anch.getChildren().add(topView);

        browse = new Button(" Зураг оруулах");
        browse.setPrefSize(150, 20);
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
                Logger.getLogger(AddTeacher.class.getName()).log(Level.SEVERE, null, ex);
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

        deleteFlagError = new Label("***");
        deleteFlagError.setPrefSize(20, 20);
        deleteFlagError.setStyle("-fx-text-fill: red"); 
        deleteFlagError.setVisible(false);
        
        usernameError = new Label("***");
        usernameError.setPrefSize(20, 20);
        usernameError.setStyle("-fx-text-fill: red"); 
        usernameError.setVisible(false);  
        
        passError = new Label("***");
        passError.setPrefSize(20, 20);
        passError.setStyle("-fx-text-fill: red"); 
        passError.setVisible(false);
        
        statusError = new Label("***");
        statusError.setPrefSize(20, 20);
        statusError.setStyle("-fx-text-fill: red");
        statusError.setVisible(false);
        
        subjectError = new Label("***");
        subjectError.setPrefSize(20, 20);
        subjectError.setStyle("-fx-text-fill: red"); 
        subjectError.setVisible(false);
        
        
        myImageView = new ImageView();
        myImageView.setPreserveRatio(false);         
        myImageView.setFitHeight(180);
        myImageView.setFitWidth(150);
        
        AddID = new Label("Суралцагчийн дугаар: ");
        AddID.setPrefSize(150, 20);

        TextAddID = new TextField();
        TextAddID.setPrefSize(150, 20);
        TextAddID.setPromptText("MKiT-123");
        
        register = new Label("Регистер: ");
        register.setFont(Font.font(null, FontWeight.BOLD, 12));
        register.setPrefSize(150, 20);

        TextRegister = new TextField();
        TextRegister.setPrefSize(150, 20);
//        TextRegister.setText(regt);

        lastName = new Label("Овог: ");
        lastName.setFont(Font.font(null, FontWeight.BOLD, 12));
        lastName.setPrefSize(150, 20);

        TextLastName = new TextField();
        TextLastName.setPrefSize(150, 20);
        TextLastName.setPromptText("А-Я");

        firstName = new Label("Нэр: ");
        firstName.setFont(Font.font(null, FontWeight.BOLD, 12));
        firstName.setPrefSize(150, 20);
        
        TextFirstName = new TextField();
        TextFirstName.setPrefSize(150, 20);
        TextFirstName.setPromptText("А-Я");
        
        phoneNumber = new Label("Утасны дугаар: ");
        phoneNumber.setFont(Font.font(null, FontWeight.BOLD, 12));
        phoneNumber.setPrefSize(150, 20);
        
        TextPhoneNumber = new TextField();
        TextPhoneNumber.setPrefSize(150, 20);
        TextPhoneNumber.setPromptText("+976");
                

        subject = new Label("subject: ");
        subject.setFont(Font.font(null, FontWeight.BOLD, 12));
        subject.setPrefSize(150, 20);
        
        ObservableList<String> songohtorol = FXCollections.observableArrayList("Java",  "Солонгос хэл", "C #");
        ClassBox = new ComboBox<String>(songohtorol);
        ClassBox.setPrefSize(150, 20);
        ClassBox.setPromptText("Java");
        
                
        EmailAddress = new Label("Email Address:");
        EmailAddress.setFont(Font.font(null, FontWeight.BOLD, 12));
        EmailAddress.setPrefSize(150, 20);
        
        TextEmailAddress = new TextField();
        TextEmailAddress.setPrefSize(150, 20);
        TextEmailAddress.setPromptText("@example.com");
        
        social = new Label("Social:");
        social.setFont(Font.font(null, FontWeight.BOLD, 12));
        social.setPrefSize(150, 20);
        
        TextSocial = new TextArea();
        TextSocial.setPrefSize(150, 50);
//        TextSocial.setText(socialt);

        deleteFlag = new Label("delete Flag:");
        deleteFlag.setFont(Font.font(null, FontWeight.BOLD, 12));
        deleteFlag.setPrefSize(150, 20);
        
        TextDeleteFlag = new TextField();
        TextDeleteFlag.setPrefSize(150, 20);
//        TextDeleteFlag.setText(deletet);
        
        username = new Label("Нэвтрэх нэр:");
        username.setFont(Font.font(null, FontWeight.BOLD, 12));
        username.setPrefSize(150, 20);
        
        TextUser = new TextField();
        TextUser.setPrefSize(150, 20);
//        TextUser.setText(usert);
        
        password = new Label("Нууц үг:");
        password.setFont(Font.font(null, FontWeight.BOLD, 12));
        password.setPrefSize(150, 20);
        
        TextPass = new TextField();
        TextPass.setPrefSize(150, 20);
//        TextPass.setText(passt);
               
        
        homeAddress = new Label("Гэрийн хаяг: ");
        homeAddress.setFont(Font.font(null, FontWeight.BOLD, 12));
        homeAddress.setPrefSize(150, 20);
        
        AreaHomeAddress = new TextArea();
        AreaHomeAddress.setPrefSize(150, 50);
        AreaHomeAddress.setPromptText("Оршин суугаа хаяг");
        
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
        AddPane.getChildren().add(img_cont);

        AddPane.getChildren().addAll(
                browse,   
                
                register,
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
                
                subject,
                ClassBox,
                subjectError,
                
                phoneNumber, 
                TextPhoneNumber,
                phoneNumberError,
                
                EmailAddress,
                TextEmailAddress,
                emailAddressError,
                
                social,
                TextSocial,
                socialError,
                
                homeAddress, 
                AreaHomeAddress,
                homeAddressError,                
                
                username,
                TextUser,
                usernameError,   
                
                password,
                TextPass,
                passError,
                
                deleteFlag,
                TextDeleteFlag,
                deleteFlagError,
                
                idLabel);

        buttonAdd = new Button("Нэмэх");
        buttonAdd.setPrefWidth(150);
        buttonAdd.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");         
        AddPane.getChildren().add(buttonAdd);
        
            buttonAdd.setOnAction(ae->{
                
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
                    
                    
                    if(ClassBox.getValue().equals("Java")){
                        className = "1";
                    }
                    else if(ClassBox.getValue().equals("Солонгос хэл")){
                        className = "2";
                    } 
                    else if(ClassBox.getValue().equals("C #")){
                        className = "3";
                    }                   
                    System.out.println(className);
                    
                    
                    
                if(file == null){
                  idLabel.setStyle("-fx-text-fill: blue");
                  idLabel.setText("Зураг оруулна уу!!!");
                  idLabel.setVisible(true);
                }
                else{
                    idLabel.setVisible(false);
                }
                if(TextAddID.getText().equals("")){
                
                idLabel.setStyle("-fx-text-fill: blue");    
                idError.setVisible(true);
                }
                    else{
                    idError.setVisible(false);
                }                
                    if(TextLastName.getText().equals("")){                
                    idLabel.setStyle("-fx-text-fill: blue");    
                    lastNameError.setVisible(true);
                }
                    else{
                    lastNameError.setVisible(false);
                }                
                    if(TextFirstName.getText().equals("")){                
                    idLabel.setStyle("-fx-text-fill: blue");    
                    firstNameError.setVisible(true);
                }
                    else{
                    firstNameError.setVisible(false);
                }                
                    if(TextPhoneNumber.getText().equals("")){                
                    idLabel.setStyle("-fx-text-fill: blue");    
                    phoneNumberError.setVisible(true);
                }
                    else{
                    phoneNumberError.setVisible(false);
                }
                    if(TextEmailAddress.getText().equals("")){                
                    idLabel.setStyle("-fx-text-fill: blue");    
                    emailAddressError.setVisible(true);
                }
                    else{
                    emailAddressError.setVisible(false);
                }                
                             
                    if(AreaHomeAddress.getText().equals("")){                
                    idLabel.setStyle("-fx-text-fill: blue");    
                    homeAddressError.setVisible(true);
                }
                    else{
                    homeAddressError.setVisible(false);
                }
              
                String registerNew = TextRegister.getText();
                String lastNameNew = TextLastName.getText();
                String firstNameNew = TextFirstName.getText();
                String phoneNumNew = TextPhoneNumber.getText();
                String subjectNew = className;
                String emailNew = TextEmailAddress.getText();
                String socialNew = TextSocial.getText();
                String addressNew = AreaHomeAddress.getText();
                String userNew = TextUser.getText();
                String passNew = TextPass.getText();
                String delNew = TextDeleteFlag.getText();                

                String IDstr = "" + ServerConnection.RequestAjluulah("insertTeacher", ""+registerNew+"::"+lastNameNew+"::"+firstNameNew+"::"+phoneNumNew+"::"+emailNew+"::"+socialNew+"::"+addressNew+"::image::"+userNew+"::"+passNew+"::0::"+subjectNew+"::"+statusId+"");
                System.out.println("taecher IDSSTr-->"+IDstr);       

                Teacher.data.add(new TeacherObj(IDstr, registerNew, lastNameNew, firstNameNew, statusId, phoneNumNew, emailNew, addressNew, "image",userNew, passNew, "0", socialNew, subjectNew));
                
                AddStage.close();
            });

            AddStage.setScene(addScene);
            AddStage.setResizable(false);
            AddStage.show();
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (Exception e) {
            Logger.getLogger(AddTeacher.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
