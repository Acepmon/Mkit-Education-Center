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
    
public class EditStudent {
    
    private Desktop desktop = Desktop.getDesktop();

    private ComboBox<String> ClassBox, teacherBox;
//    FileChooser fileChooser;
//    Дээр FileChooser
    
    String statusId;
    String classNew;
    ComboBox cbStatus;   
   
    Label ProfileImage,
            adminID,
            numberList,            
            lastName,
            teacher,
            firstName,
            phoneNumber,
            homeAddress,
            emailAddress,
            comNum,
            reasonL,reasonError,
            status,
            className,
            idLabel,
            social,
            username, password,
            deleteFlag,deleteFlagError,
            userError, passError,
            socialError,
            idError,
            register, regError,
            numberStart, 
            numberError,
            numError,
            lastNameError,
            firstNameError,
            phoneNumberError,
            homeAddressError,
            emailAddressError,
            comNumError,
            studentRegDateError,
            PassError,
            comError,
            
            statusError,
            spaceClass;

    TextField TextID,
            TextNumber,
            TextLastName,
            TextFirstName,
            TextPhoneNumber,
            TextNumStart,
            TextReg,
            TextHomeAddress,
            TextEmailAddress,
            TextComNum, TextDeleteFlag,
            reasonText, userTxt            
            ;
    PasswordField PassField, pass;
    Button buttonEdit, buttonExit;
    Button browse;
    TextArea AreaHomeAddress, socialArea;
    ImageView myImageView;
    Image topImage;
    private  EventHandler<ActionEvent> btnLoadEventListener;
    File file;
    
    public void start(Stage editStudentStage, StudentObj datas) throws Exception {
        
        editStudentStage.setTitle("Оюутан Засах");
        FlowPane editPane = new FlowPane(10, 10);
        editPane.setAlignment(Pos.CENTER);
        Scene addScene = new Scene(editPane, 800, 550);
        
        AnchorPane anch = new AnchorPane();
        topImage = new Image("resource/images/images.png");
        ImageView topView = new ImageView(topImage);
        anch.getChildren().add(topView);

//        fileChooser = new FileChooser();
        
        if(datas != null){
            System.out.println("baina");
        }
        else {
            System.out.println("baihgui");
        }
        
            String idt = datas.getId();
            String kode = datas.getBcode();
            String lastNamet = (datas).getLastname();
            String firstNamet = (datas).getFirstname();
            String phoneNumt = (datas).getPhonenum();
            String addresst = (datas).getAddress();
            String emailt = (datas).getEmail();
            String classNamet = (datas).getClassname();
            String comNumt = (datas).getComnum();
//            String statust = (datas).getStatus(); 
            String deletet = datas.getDeleteFlag();
             

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
        
        regError = new Label("***");
        regError.setPrefSize(20, 20);
        regError.setStyle("-fx-text-fill: red");
        regError.setVisible(false);
        
        reasonError = new Label("***");
        reasonError.setPrefSize(20, 20);
        reasonError.setStyle("-fx-text-fill: red");
        reasonError.setVisible(false);
        
        numError = new Label("***");
        numError.setPrefSize(20, 20);
        numError.setStyle("-fx-text-fill: red");
        numError.setVisible(false);
        
        phoneNumberError = new Label("***");
        phoneNumberError.setPrefSize(20, 20);
        phoneNumberError.setStyle("-fx-text-fill: red"); 
        phoneNumberError.setVisible(false);
        
        emailAddressError = new Label("***");
        emailAddressError.setPrefSize(20, 20);
        emailAddressError.setStyle("-fx-text-fill: red"); 
        emailAddressError.setVisible(false);
        
        comNumError = new Label("***");
        comNumError.setPrefSize(20, 20);
        comNumError.setStyle("-fx-text-fill: red"); 
        comNumError.setVisible(false);
        
        spaceClass = new Label("   ");
        spaceClass.setPrefSize(20, 20);
        spaceClass.setVisible(false);
        
        PassError = new Label("***");
        PassError.setPrefSize(20, 20);
        PassError.setStyle("-fx-text-fill: red"); 
        PassError.setVisible(false);
        
        deleteFlagError = new Label("***");
        deleteFlagError.setPrefSize(20, 20);
        deleteFlagError.setStyle("-fx-text-fill: red"); 
        deleteFlagError.setVisible(false);
        
        socialError = new Label("***");
        socialError.setPrefSize(20, 20);
        socialError.setStyle("-fx-text-fill: red");
        socialError.setVisible(false);
        
        
        homeAddressError = new Label("***");
        homeAddressError.setPrefSize(20, 20);
        homeAddressError.setStyle("-fx-text-fill: red"); 
        homeAddressError.setVisible(false);
        
        studentRegDateError = new Label("***");
        studentRegDateError.setPrefSize(20, 20);
        studentRegDateError.setStyle("-fx-text-fill: red"); 
        studentRegDateError.setVisible(false);
        
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
        
        spaceClass = new Label("***");
        spaceClass.setPrefSize(20, 20);
        spaceClass.setVisible(false);
        
        deleteFlagError = new Label("***");
        deleteFlagError.setPrefSize(20, 20);
        deleteFlagError.setVisible(false);
        
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
        
        numberList = new Label("Бүртгэлийн дугаар:");
        numberList.setFont(Font.font(null, FontWeight.BOLD, 12));
        numberList.setPrefSize(150, 20);
        
        TextNumber = new TextField();
        TextNumber.setPrefSize(150, 20);
        TextNumber.setPromptText(kode);        
        

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
        
        register = new Label("Регистр:");
        register.setFont(Font.font(null, FontWeight.BOLD, 12));
        register.setPrefSize(150, 20);
        
        TextReg = new TextField();
        TextReg.setPrefSize(150, 20);
        TextReg.setPromptText("ЦБ90101011");  
        
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
        
        PassField = new PasswordField();
        PassField.setPrefSize(150, 20);
        PassField.setText("8-character minimum");
        
        emailAddress = new Label("Email Address:");
        emailAddress.setFont(Font.font(null, FontWeight.BOLD, 12));
        emailAddress.setPrefSize(150, 20);
        
        TextEmailAddress = new TextField();
        TextEmailAddress.setPrefSize(150, 20);
        TextEmailAddress.setText(emailt);    
        
        deleteFlag = new Label("DeleteFlag:");
        deleteFlag.setFont(Font.font(null, FontWeight.BOLD, 12));
        deleteFlag.setPrefSize(150, 20);
        
        TextDeleteFlag = new TextField();
        TextDeleteFlag.setPrefSize(150, 20);
        TextDeleteFlag.setText(deletet);
        
        social = new Label("Social Хаяг:");
        social.setFont(Font.font(null, FontWeight.BOLD, 12));
        social.setPrefSize(150, 20);
        
        socialArea = new TextArea();
        socialArea.setPrefSize(150, 50);
        socialArea.setPromptText("Facebook etc");
        
        numberStart = new Label("Элсэлтийн дугаар: ");
        numberStart.setPrefSize(150, 20);
        numberStart.setFont(Font.font(null, FontWeight.BOLD, 12));
        
        TextNumStart = new TextField();
        TextNumStart.setPrefSize(150, 20);
        TextNumStart.setPromptText("дугаар");
        
        comNum = new Label("Компютер дугаар");
        comNum.setFont(Font.font(null, FontWeight.BOLD, 12));
        comNum.setPrefSize(150, 20);
        
        TextComNum = new TextField();
        TextComNum.setPrefSize(150, 20);
        TextComNum.setText(comNumt);
        
        username = new Label("Хэрэглэгчийн нэр: ");
        username.setPrefSize(150, 20);
        username.setFont(Font.font(null, FontWeight.BOLD, 12));
        
        userTxt = new TextField();
        userTxt.setPrefSize(150, 20);
        userTxt.setPromptText("username...");
        
        password = new Label("Нууц үг: ");
        password.setPrefSize(150, 20);
        password.setFont(Font.font(null, FontWeight.BOLD, 12));
        
        pass = new PasswordField();
        pass.setPrefSize(150, 20);
        pass.setPromptText("password...");   
        
        teacher = new Label("Багш сонголт: ");
        teacher.setFont(Font.font(null, FontWeight.BOLD, 12));
        teacher.setPrefSize(150, 20);
        
        ObservableList<String> songohtorolnew = FXCollections.observableArrayList("Java", "C#", "Korean");
        teacherBox = new ComboBox<String>(songohtorolnew);
        teacherBox.setPrefSize(150, 20);
        
        teacherBox.setValue("Java");
        teacherBox.setOnAction(ae->{            
            System.out.println("Selected class is " + teacherBox.getValue());
        }); 
        
        className = new Label("Анги: ");
        className.setFont(Font.font(null, FontWeight.BOLD, 12));
        className.setPrefSize(150, 20);
        
        ObservableList<String> songohtorol = FXCollections.observableArrayList("Java", "C#", "Undsen Hereglee");
        ClassBox = new ComboBox<String>(songohtorol);
        ClassBox.setPrefSize(150, 20);
        
        ClassBox.setValue("Java");
        ClassBox.setOnAction(ae->{            
            System.out.println("Selected class is " + ClassBox.getValue());
        });
        
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
        
        reasonL = new Label("Шалтгаан: ");
        reasonL.setFont(Font.font(null, FontWeight.BOLD, 12));
        reasonL.setPrefSize(150, 20);
        
        reasonText = new TextField();
        reasonText.setPrefSize(150, 20);
        reasonText.setText("YYYY/MM/DD");        
        
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
                
                numberList, TextNumber, numberError,
                
                lastName,
                TextLastName,
                lastNameError,
                
                firstName, 
                TextFirstName,
                firstNameError,
                
                status, cbStatus, statusError,
                
                phoneNumber, 
                TextPhoneNumber,
                phoneNumberError,
                
                emailAddress,
                TextEmailAddress,
                emailAddressError,
                
                social, socialArea, socialError,
                register, TextReg, regError,
                
                homeAddress, 
                AreaHomeAddress,
                homeAddressError,
                
                teacher, teacherBox, spaceClass,
                numberStart, TextNumStart, numError,
                
                comNum,
                TextComNum,
                comNumError,                
                
                reasonL, reasonText, reasonError, 
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
        
        buttonEdit.setOnAction(ae->{
            
            if(cbStatus.getValue().equals("суралцаж байгаа")){
                        statusId = "1";
                    }
                    else if(cbStatus.getValue().equals("т?гсс?н")){
                        statusId = "2";
                    } 
                    else if(cbStatus.getValue().equals("х?лээгдэж байгаа")){
                        statusId = "3";
                    } 
                    else if(cbStatus.getValue().equals("ажиллаж байгаа")){
                        statusId = "4";
                    }
                    else if(cbStatus.getValue().equals("ажиллахаа больсон")){
                        statusId = "5";
                    }                    
                    System.out.println(statusId);
                    
                    if(ClassBox.getValue().equals("Java")){
                        classNew = "1";                        
                    }
                    else if(ClassBox.getValue().equals("C#")){
                        classNew = "2";
                    }
                    else if(ClassBox.getValue().equals("Undsen Hereglee")){
                        classNew = "3";
                    }
                    System.out.println(classNew);
                    
                    
                    if(teacherBox.getValue().equals("")){
                        
                    }
                    
                    String Student_id = ((StudentObj)Student.table.getSelectionModel().getSelectedItem()).getId();
                    System.out.println("Student_id--->"+Student_id);
                    
                    String idNew = TextID.getText();
                    String numberB = TextNumber.getText();
                    String lastNameNew = TextLastName.getText();
                    String firstNameNew = TextFirstName.getText();
                    String phoneNumNew = TextPhoneNumber.getText();
                    String addressNew = AreaHomeAddress.getText();       
                    String emailNew = TextEmailAddress.getText();
                    String socialNew = socialArea.getText();
                    String registerNew = TextReg.getText();
                    String comNumNew = TextComNum.getText();
                    String classNewid = classNew;
                    String startNew = TextNumStart.getText();
//                    String userNew = userTxt.getText();
//                    String passNew = pass.getText();
                    String reasonNew = reasonText.getText();
                    String delNew = TextDeleteFlag.getText();
                    
                    
                    ServerConnection.RequestAjluulah("updateStudent", ""+idNew+"::"+numberB+"::"+lastNameNew+"::"+firstNameNew+"::"+statusId+"::"+phoneNumNew+"::"+emailNew+"::"+socialNew+"::"+registerNew+"::"+addressNew+"::"+classNewid+"::"+comNumNew+"::"+startNew+"::"+delNew+"::"+reasonNew+"::null::"+Student_id+"");

                    Student.data.remove(Student.rowIndex);                      
                                        
                    Student.data.add(new StudentObj(
                            idNew, 
                            numberB, 
                            lastNameNew, 
                            firstNameNew, 
                            statusId, 
                            phoneNumNew, 
                            emailNew, 
                            socialNew, 
                            registerNew, 
                            addressNew, 
                            classNewid, 
                            comNumNew, 
                            startNew, 
                            delNew, 
                            reasonNew, 
                            "null"));
                    
                    
             
                        
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
                } else {
                    idError.setVisible(false);
                }                                
                if(TextNumber.getText().equals("")){                
                    numberList.setStyle("-fx-text-fill: blue");    
                    numberError.setVisible(true);
                } else {
                    numberError.setVisible(false);
                }                
                if(TextLastName.getText().equals("")){                
                    idLabel.setStyle("-fx-text-fill: blue");    
                    lastNameError.setVisible(true);
                }else {
                    lastNameError.setVisible(false);
                }
                
                if(TextFirstName.getText().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");                  
                firstNameError.setVisible(true);
                }else {
                    firstNameError.setVisible(false);
                }
                                
                if(cbStatus.getValue().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");
                statusError.setVisible(true);
                }else {
                    statusError.setVisible(false);
                }
                
                if(TextPhoneNumber.getText().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");    
                phoneNumberError.setVisible(true);
                }else {
                    phoneNumberError.setVisible(false);
                }
                
                if(socialArea.getText().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");    
                socialError.setVisible(true);
                }else {
                    socialError.setVisible(false);
                }                
                
                if(TextEmailAddress.getText().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");    
                emailAddressError.setVisible(true);
                }else {
                    emailAddressError.setVisible(false);
                }
                
                if(AreaHomeAddress.getText().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");    
                homeAddressError.setVisible(true);
                }else {
                    homeAddressError.setVisible(false);
                }
                  
                if(TextReg.getText().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");    
                regError.setVisible(true);
                }else {
                    regError.setVisible(false);
                }
                
                if(teacherBox.getValue().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");    
                spaceClass.setVisible(true);
                }else {
                    spaceClass.setVisible(false);
                }
                
                if(TextNumStart.getText().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");    
                numError.setVisible(true);
                }else {
                    numError.setVisible(false);
                }
                
                if(reasonText.getText().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");    
                reasonError.setVisible(true);
                }else {
                    reasonError.setVisible(false);
                }
                 
                if(TextComNum.getText().equals("")){                
                idLabel.setStyle("-fx-text-fill: blue");    
                comNumError.setVisible(true);
                }else {
                    comNumError.setVisible(false);
                } 
                if(!idLabel.isVisible() && 
                        !idError.isVisible() && 
                        !numberError.isVisible() &&
                        !lastNameError.isVisible() && 
                        !firstNameError.isVisible() && 
                        !statusError.isVisible() &&
                        !phoneNumberError.isVisible() && 
                        !homeAddressError.isVisible() && 
                        !socialError.isVisible() &&
                        !regError.isVisible() &&
                        !spaceClass.isVisible() &&
                        !numError.isVisible() &&
                        !reasonError.isVisible() &&
                        !comNumError.isVisible() &&
                        !emailAddressError.isVisible()                        
                        )
                {
                    editStudentStage.close();
                }      
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
            editStudentStage.close();
        });        
        
        editStudentStage.setScene(addScene);
        editStudentStage.show();
//        editStudentStage.setResizable(true);

    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (Exception e) {
            Logger.getLogger(EditAdmin.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
