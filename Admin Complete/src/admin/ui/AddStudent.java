package admin.ui;

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

public class AddStudent extends Application {

    private Desktop desktop = Desktop.getDesktop();
    
    String statusId;
    String classNew;
    ComboBox cbStatus, teacherBox;   
    Label ProfileImage,
            id,idError,    
            numberList, numberError,
            lastName,lastNameError,
            firstName, firstNameError,
            phoneNumber,phoneNumberError,
            computerNumber, comError,
            teacher,
            studentRegDate,
            EmailAddress,emailAddressError,
            social, socialError,
            register,regError,
            LabelPasswordField, 
            homeAddress,homeAddressError,
            numberStart, numError,
            idLabel, 
            reason,reasonError,
            status,  
            studentRegDateError,
            PassError, 
            deleteFlag, deleteFlagError,
            statusError, myImageViewError,
            username, password, spaceClass,
            userError, passError;
    TextField TextAddID,
            TextNumber,
            TextLastName,
            TextFirstName,
            TextPhoneNumber,
            TextReg,
            TextComputerNumber,
            TextNumStart,
            TextStudentRegDate,
            TextEmailAddress, userTxt, TextDeleteFlag;
    PasswordField PassField, pass;
    Button buttonAdd;
    Button browse;
    TextArea AreaHomeAddress, socialArea, TextReason;
    ImageView myImageView;
    Image topImage;
    private  EventHandler<ActionEvent> btnLoadEventListener;
    
    File file;
    
    public void start(Stage AddStage) throws Exception {
        AddStage.setTitle("Оюутан нэмэх");
        FlowPane AddPane = new FlowPane(10, 10);
        AddPane.setAlignment(Pos.CENTER);
        Scene addScene = new Scene(AddPane, 800, 550);
        
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
                Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        idLabel = new Label("");
        idLabel.setPrefSize(280, 10);
        idLabel.setAlignment(Pos.CENTER);
        
        idError = new Label("***");
        idError.setPrefSize(20, 20);
        idError.setStyle("-fx-text-fill: red"); 
        idError.setVisible(false);
        
        numberError = new Label("***");
        numberError.setPrefSize(20, 20);
        numberError.setStyle("-fx-text-fill: red");
        numberError.setVisible(false);      
                
        lastNameError = new Label("***");
        lastNameError.setPrefSize(20, 20);
        lastNameError.setStyle("-fx-text-fill: red"); 
        lastNameError.setVisible(false);
        
        firstNameError = new Label("***");
        firstNameError.setPrefSize(20, 20);
        firstNameError.setStyle("-fx-text-fill: red"); 
        firstNameError.setVisible(false);
        
        statusError = new Label("***");
        statusError.setPrefSize(20, 20);
        statusError.setStyle("-fx-text-fill: red");
        statusError.setVisible(false);
        
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
        
        regError = new Label("***");
        regError.setPrefSize(20, 20);
        regError.setStyle("-fx-text-fill: red");
        regError.setVisible(false);
        
        reasonError = new Label("***");
        reasonError.setPrefSize(20, 20);
        reasonError.setStyle("-fx-text-fill: red");
        reasonError.setVisible(false);        
       
        comError = new Label("***");
        comError.setPrefSize(20, 20);
        comError.setStyle("-fx-text-fill: red"); 
        comError.setVisible(false);
        
        spaceClass = new Label("   ");
        spaceClass.setPrefSize(20, 20);
        spaceClass.setVisible(false);
               
        homeAddressError = new Label("***");
        homeAddressError.setPrefSize(20, 20);
        homeAddressError.setStyle("-fx-text-fill: red"); 
        homeAddressError.setVisible(false);
        
        numError = new Label("***");
        numError.setPrefSize(20, 20);
        numError.setStyle("-fx-text-fill: red");
        numError.setVisible(false);
                
        myImageViewError = new Label("***");
        myImageViewError.setPrefSize(5, 5);
        myImageViewError.setStyle("-fx-text-fill: red"); 
        myImageViewError.setVisible(false);   
        
        userError = new Label("***");
        userError.setPrefSize(20, 20);
        userError.setStyle("-fx-text-fill: red");
        userError.setVisible(false);
        
        passError = new Label("***");
        passError.setPrefSize(20, 20);
        passError.setStyle("-fx-text-fill: red");
        passError.setVisible(false);  
        
        deleteFlagError = new Label("***");
        deleteFlagError.setPrefSize(20, 20);
        deleteFlagError.setStyle("-fx-text-fill: red");
        deleteFlagError.setVisible(false);   
        
        myImageView = new ImageView();
        myImageView.setPreserveRatio(false);
         
        myImageView.setFitHeight(180);
        myImageView.setFitWidth(150);       
        
        id = new Label("Дугаар:");
        id.setFont(Font.font(null, FontWeight.BOLD, 12));
        id.setPrefSize(150, 20);

        TextAddID = new TextField();
        TextAddID.setPrefSize(150, 20);
        TextAddID.setPromptText("123");
        
        numberList = new Label("Бүртгэлийн дугаар:");
        numberList.setFont(Font.font(null, FontWeight.BOLD, 12));
        numberList.setPrefSize(150, 20);
        
        TextNumber = new TextField();
        TextNumber.setPrefSize(150, 20);
        TextNumber.setPromptText("");
        
        status = new Label("Статус:");
        status.setFont(Font.font(null, FontWeight.BOLD, 12));
        status.setPrefSize(150, 20);
        
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
        
        ObservableList<String> statusTypes = FXCollections.observableArrayList("Суралцаж байгаа", "Төгссөн", "Хүлээгдэж байгаа", "Ажиллаж байгаа", "Ажиллахаа больсон");
        cbStatus = new ComboBox<String>(statusTypes);
        cbStatus.setPrefSize(150, 20);
        
        cbStatus.setValue("Суралцаж байгаа");
        cbStatus.setOnAction(ae->{            
            System.out.println("Selected status is " + cbStatus.getValue());
        });
        
        phoneNumber = new Label("Утасны дугаар: ");
        phoneNumber.setFont(Font.font(null, FontWeight.BOLD, 12));
        phoneNumber.setPrefSize(150, 20);
        
        TextPhoneNumber = new TextField();
        TextPhoneNumber.setPrefSize(150, 20);
        TextPhoneNumber.setPromptText("+976");
        
        EmailAddress = new Label("Email Address:");
        EmailAddress.setFont(Font.font(null, FontWeight.BOLD, 12));
        EmailAddress.setPrefSize(150, 20);
        
        social = new Label("Social Хаяг:");
        social.setFont(Font.font(null, FontWeight.BOLD, 12));
        social.setPrefSize(150, 20);
        
        socialArea = new TextArea();
        socialArea.setPrefSize(150, 50);
        socialArea.setPromptText("Facebook etc");    
        
        reason = new Label("reason:");
        reason.setFont(Font.font(null, FontWeight.BOLD, 12));
        reason.setPrefSize(150, 20);
        
        TextReason = new TextArea();
        TextReason.setPrefSize(150, 50);
        TextReason.setPromptText("Reason");   
        
        register = new Label("Регистр:");
        register.setFont(Font.font(null, FontWeight.BOLD, 12));
        register.setPrefSize(150, 20);
        
        TextReg = new TextField();
        TextReg.setPrefSize(150, 20);
        TextReg.setPromptText("ЦБ90101011");        
        
        TextEmailAddress = new TextField();
        TextEmailAddress.setPrefSize(150, 20);
        TextEmailAddress.setPromptText("@example.com");
        
        computerNumber = new Label("Компьютерийн дугаар: ");
        computerNumber.setFont(Font.font(null, FontWeight.BOLD, 12));
        computerNumber.setPrefSize(150, 20);
        
        TextComputerNumber = new TextField();
        TextComputerNumber.setPrefSize(150, 20);
        TextComputerNumber.setPromptText("Computer ID");
        
        TextDeleteFlag = new TextField();
        TextDeleteFlag.setPrefSize(150, 20);
        TextDeleteFlag.setPromptText("delete flag");

        teacher = new Label("Багш сонголт: ");
        teacher.setFont(Font.font(null, FontWeight.BOLD, 12));
        teacher.setPrefSize(150, 20);
        
        ObservableList<String> songohtorol = FXCollections.observableArrayList("Java", "C#", "Korean");
        teacherBox = new ComboBox<String>(songohtorol);
        teacherBox.setPrefSize(150, 20);
        
        teacherBox.setValue("Java");
        teacherBox.setOnAction(ae->{            
            System.out.println("Selected class is " + teacherBox.getValue());
        });                      
       
        homeAddress = new Label("Гэрийн хаяг: ");
        homeAddress.setFont(Font.font(null, FontWeight.BOLD, 12));
        homeAddress.setPrefSize(150, 20);
        
        AreaHomeAddress = new TextArea();
        AreaHomeAddress.setPrefSize(150, 50);
        AreaHomeAddress.setPromptText("Оршин суугаа хаяг");
        
        numberStart = new Label("Элсэлтийн дугаар: ");
        numberStart.setPrefSize(150, 20);
        numberStart.setFont(Font.font(null, FontWeight.BOLD, 12));
        
        TextNumStart = new TextField();
        TextNumStart.setPrefSize(150, 20);
        TextNumStart.setPromptText("дугаар");
                   
             
        Pane img_cont = new Pane(myImageView);
        img_cont.setStyle("-fx-background-image: url('resource/images/no_photo.jpg');"
                + "-fx-background-size: 150 180;");
        img_cont.setPrefSize(150, 180);
        AddPane.getChildren().add(img_cont);

        AddPane.getChildren().addAll(
                browse, 
//                id, TextAddID, idError,
                numberList, TextNumber, numberError,
                lastName, TextLastName, lastNameError,
                firstName, TextFirstName, firstNameError,
                status, cbStatus, statusError,
                phoneNumber, TextPhoneNumber, phoneNumberError,
                EmailAddress, TextEmailAddress, emailAddressError,
                social, socialArea, socialError,
                register, TextReg, regError,
                homeAddress, AreaHomeAddress, homeAddressError,              
                teacher, teacherBox, spaceClass,
                computerNumber, TextComputerNumber, comError,
                numberStart, TextNumStart, numError,
                idLabel
        );

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
        
            buttonAdd.setOnAction((ActionEvent ae)->{
                
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
                    
                    if(teacherBox.getValue().equals("Java")){
                        classNew = "1";                        
                    }
                    else if(teacherBox.getValue().equals("C#")){
                        classNew = "2";
                    }
                    else if(teacherBox.getValue().equals("Korean")){
                        classNew = "3";
                    }
                    System.out.println(classNew);    
                                
            
                if(file == null){
                     idLabel.setStyle("-fx-text-fill: blue");
                     idLabel.setText("Зураг оруулна уу!!!");
                     idLabel.setVisible(true);
                }
                else{
                    idLabel.setVisible(false);
                }               
                if(TextNumber.getText().equals("")){                
                    idLabel.setStyle("-fx-text-fill: blue");    
                    numberError.setVisible(true);
                }
                else{
                    numberError.setVisible(false);
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
                if(statusId.equals("")){
                    idLabel.setStyle("-fx-text-fill: blue");    
                    statusError.setVisible(true);
                }
                else{
                    emailAddressError.setVisible(false);
                }  
                if(TextEmailAddress.getText().equals("")){
                    idLabel.setStyle("-fx-text-fill: blue");    
                    emailAddressError.setVisible(true);
                }
                else{
                    emailAddressError.setVisible(false);
                }                                     
                if(socialArea.getText().equals("")){
                    idLabel.setStyle("-fx-text-fill: blue");    
                    socialError.setVisible(true);
                }
                else{
                    socialError.setVisible(false);
                }    
                if(TextReg.getText().equals("")){

                    idLabel.setStyle("-fx-text-fill: blue");    
                    regError.setVisible(true);
                }
                    else{
                    regError.setVisible(false);
                }

                if(AreaHomeAddress.getText().equals("")){
                    idLabel.setStyle("-fx-text-fill: blue");    
                    homeAddressError.setVisible(true);
                }
                else{
                    homeAddressError.setVisible(false);
                }                    
                if(classNew.equals("")){
                    idLabel.setStyle("-fx-text-fill: blue");    
                    spaceClass.setVisible(true);
                }
                else{
                    spaceClass.setVisible(false);
                }  
                if(TextComputerNumber.getText().equals("")){
                    idLabel.setStyle("-fx-text-fill: blue");    
                    comError.setVisible(true);
                }
                else{
                    comError.setVisible(false);
                    }
                if(TextNumStart.getText().equals("")){
                    idLabel.setStyle("-fx-text-fill: blue");    
                    numError.setVisible(true);
                }
                else{
                    numError.setVisible(false);
                }
                    
//                AddStage.close();
                  
            String bkodNew = TextReason.getText();
            String lastNameNew = TextLastName.getText();
            String firstNameNew = TextFirstName.getText();
            String phoneNumNew = TextPhoneNumber.getText();
            String emailNew = TextEmailAddress.getText();
            String socialNew = socialArea.getText();
            String regNew = TextReg.getText();
            String addressNew = AreaHomeAddress.getText();
            String classNewt = classNew;
            String conmunNew = TextComputerNumber.getText();
//            String numListNew = TextNumber.getText();
            String numStart = TextNumStart.getText();
            String comNumNew = TextComputerNumber.getText();
            String delNew = TextDeleteFlag.getText();
//            String userNew = userTxt.getText();
//            String passNew = pass.getText();
            String reasonNew = TextReason.getText();                

            
            if (!idLabel.isVisible() && 
                    !numberError.isVisible() && 
                    !lastNameError.isVisible() && 
                    !firstNameError.isVisible() &&
                    !statusError.isVisible() &&                     
                    !phoneNumberError.isVisible() &&
                    !socialError.isVisible() && 
                    !regError.isVisible() &&
                    !emailAddressError.isVisible() && 
                    !spaceClass.isVisible() &&
                    !comError.isVisible() &&
                    !numError.isVisible() &&
                    !homeAddressError.isVisible()) {
                
                        String IDstr = "" + ServerConnection.RequestAjluulah("insertStudent", 
                            "uh8989::"
                            +lastNameNew+"::"
                            +firstNameNew+"::"
                            
                            +phoneNumNew+"::"
                            +emailNew+"::"
                            +socialNew+"::"
                            +regNew+"::"
                            +addressNew+"::"
                            +conmunNew+"::1::0::reason::pic::50::1::"
                            +statusId+"::"
                            +classNewt+"");
            
                        System.out.println("id is ---> " + IDstr);

                        Student.data.add(new StudentObj(IDstr, 
                            bkodNew, 
                            lastNameNew, 
                            firstNameNew, 
                            statusId, 
                            phoneNumNew, 
                            emailNew, 
                            socialNew, 
                            regNew, 
                            addressNew, 
                            classNewt, 
                            comNumNew, 
                            numStart, 
                            delNew, 
                            reasonNew, 
                            "null"));
                
                        AddStage.close();
                    }
                                
    });

        AddStage.setScene(addScene);
        AddStage.setResizable(false);
        AddStage.show();

    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (Exception e) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
