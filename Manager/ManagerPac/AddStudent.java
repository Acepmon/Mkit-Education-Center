package ManagerPac;

import Controller.ClientTest;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Collections;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AddStudent extends Application {
    private Label pictureLbl;
    private Button browseBtn;
    
    private TextField pictureFld;
    
    private Label nameLbl;
    private TextField firstNameFld;
    private TextField lastNameFld;
    
    private Label statusLbl;
    private ComboBox<String> statusCmBox;
    
    private Label mobileLbl;
    private ComboBox<String> countryCmBox;
    private TextField mobileFld;
    
    private Label addressLbl;
    private TextArea addressArea;
    
    private Label classLbl;
    private ComboBox<String> classCmBox;
    private TextField comNumFld;
    
    private Label emailLbl;
    private TextField emailFld;
    
    private Button registerBtn;
    private Button cancelBtn;
    
    private String firstName;
    private String lastName;
    private String country;
    private String mobile;
    private String address;
    private int className;
    private String computerNumber;
    private int status;
    private String email;
    private String insert="";
    FileChooser fileChooser;
    File file;
    
    @Override
    public void start(Stage addStudentStage) {
        Pane pane=new Pane();
        
        pictureLbl=new Label("Зураг оруулах");
        pictureLbl.setPrefSize(80, 90);
        pictureLbl.setStyle("-fx-border-color:black");
        pictureLbl.setLayoutX(25);
        pictureLbl.setLayoutY(25);
        
        browseBtn=new Button("Зураг сонгох");
        browseBtn.setFont(Font.font("Verdana", 14));
        browseBtn.setPrefSize(120, 30);
        browseBtn.setLayoutX(160);
        browseBtn.setLayoutY(85);
        browseBtn.setOnAction(ae-> {
            fileChooser = new FileChooser();
            FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All files", "*.*");
            fileChooser.getExtensionFilters().addAll(allFilter);
            file = fileChooser.showOpenDialog(null);
            pictureFld.setText("" + file.getName());
        });
        
        pictureFld=new TextField();
        pictureFld.setPrefSize(120, 25);
        pictureFld.setLayoutX(160);
        pictureFld.setLayoutY(40);
        pictureFld.setPromptText("Зурагийн нэр");
        
        nameLbl=new Label("Нэр");
        nameLbl.setId("regLbl");
        nameLbl.setFont(Font.font("Verdana", 15));
        nameLbl.setPrefSize(50, 25);
        nameLbl.setLayoutX(25);
        nameLbl.setLayoutY(140);
        
        firstNameFld=new TextField();
        firstNameFld.setPrefSize(120, 25);
        firstNameFld.setLayoutX(25);
        firstNameFld.setLayoutY(170);
        firstNameFld.setPromptText("Өөрийн нэр");
        firstNameFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            String sag=firstNameFld.getText();
            if(!(((c >= 'a')||(c >= 'A')) && ((c <= 'z')||(c <= 'Z')) || ((c>='а') || (c>='А')) && ((c<='я') || (c<='Я')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        fieldValidate(firstNameFld);
        
        lastNameFld=new TextField();
        lastNameFld.setPrefSize(120, 25);
        lastNameFld.setLayoutX(160);
        lastNameFld.setLayoutY(170);
        lastNameFld.setPromptText("Овог");
        lastNameFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            String sag=lastNameFld.getText();
            if(!(((c >= 'a')||(c >= 'A')) && ((c <= 'z')||(c <= 'Z')) || ((c>='а') || (c>='А')) && ((c<='я') || (c<='Я')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        fieldValidate(lastNameFld);
        
        statusLbl=new Label("Статус");
        statusLbl.setId("regLbl");
        statusLbl.setFont(Font.font("Verdana", 15));
        statusLbl.setPrefSize(50, 25);
        statusLbl.setLayoutX(25);
        statusLbl.setLayoutY(220);
        
        ObservableList<String> stat=FXCollections.observableArrayList(
                "Суралцаж байгаа", 
                "Төгссөн", 
                "Хүлээгдэж байгаа", 
                "Ажиллаж байгаа", 
                "Ажиллахаа больсон"
        );
        statusCmBox=new ComboBox<String>(stat);
        statusCmBox.setValue("Статус сонгох");
        statusCmBox.setPrefSize(255, 25);
        statusCmBox.setLayoutX(25);
        statusCmBox.setLayoutY(250);
        
        mobileLbl=new Label("Утасны дугаар");
        mobileLbl.setId("regLbl");
        mobileLbl.setFont(Font.font("Verdana", 15));
        mobileLbl.setPrefSize(150, 25);
        mobileLbl.setLayoutX(25);
        mobileLbl.setLayoutY(300);
        
        mobileFld=new TextField();
        MobileField();
        
        ObservableList<ImageView> countries=FXCollections.observableArrayList();
        ImageView mongol = new ImageView(new Image("ManagerPac/Mongolian-Flag.png"));
        mongol.setFitHeight(18);
        mongol.setFitWidth(30);
        
        ImageView korea=new ImageView(new Image("ManagerPac/Korean-Flag.png"));
        korea.setFitHeight(18);
        korea.setFitWidth(30);
        countries.addAll(mongol, korea);
        
        countryCmBox=new ComboBox(countries);
        countryCmBox.setValue("Улс");
        countryCmBox.setPrefSize(80, 25);
        countryCmBox.setLayoutX(25);
        countryCmBox.setLayoutY(330);
        
        addressLbl=new Label("Гэрийн хаяг");
        addressLbl.setId("regLbl");
        addressLbl.setFont(Font.font("Verdana", 15));
        addressLbl.setPrefSize(140, 25);
        addressLbl.setLayoutX(25);
        addressLbl.setLayoutY(380);
        
        addressArea=new TextArea();
        addressArea.setPromptText("Одоо байрлаж буй хаяг");
        addressArea.setPrefSize(255, 50);
        addressArea.setLayoutX(25);
        addressArea.setLayoutY(410);
        addressArea.setWrapText(true);
        areaValidate(addressArea);
        
        classLbl=new Label("Суралцах анги");
        classLbl.setId("regLbl");
        classLbl.setFont(Font.font("Verdana", 15));
        classLbl.setPrefSize(140, 25);
        classLbl.setLayoutX(25);
        classLbl.setLayoutY(480);
        
        ObservableList<String> classes=FXCollections.observableArrayList(
                "Java", 
                "C#", 
                "Үндсэн хэрэглээ"
        );
        classCmBox=new ComboBox<String>(classes);
        classCmBox.setValue("Анги сонгох");
        classCmBox.setPrefSize(115, 25);
        classCmBox.setLayoutX(25);
        classCmBox.setLayoutY(510);
        
        comNumFld=new TextField();
        ComputerField();
        
        emailLbl=new Label("И-мэйл хаяг");
        emailLbl.setId("regLbl");
        emailLbl.setFont(Font.font("Verdana", 15));
        emailLbl.setPrefSize(140, 25);
        emailLbl.setLayoutX(25);
        emailLbl.setLayoutY(560);
        
        emailFld=new TextField();
        EmailField();
        
        registerBtn=new Button("Бүртгүүлэх");
        registerBtn.setFont(Font.font("Verdana", 15));
        registerBtn.setPrefSize(120, 30);
        registerBtn.setLayoutX(25);
        registerBtn.setLayoutY(680);
        registerBtn.setOnAction(ae -> {
            
            
            if(firstNameFld.getText().isEmpty()||lastNameFld.getText().isEmpty()||mobileFld.getText().isEmpty()||comNumFld.getText().isEmpty()||emailFld.getText().isEmpty()) {
                fieldValidation(firstNameFld);
                fieldValidation(lastNameFld);
                fieldValidation(mobileFld);
                fieldValidation(comNumFld);
                fieldValidation(emailFld);
            }
            
            else {
                int answer=JOptionPane.showConfirmDialog(null, "Нэмэх үү?");
                if(answer==JOptionPane.YES_OPTION) {
                    GetUserInfo();
                    ClientTest.RequestAjluulah("insertIntoStudent", ""+insert+"");

                    firstNameFld.setText("");
                    lastNameFld.setText("");
                    statusCmBox.setValue("Статус сонгох");
                    countryCmBox.setValue("Улс");
                    mobileFld.setText("");
                    addressArea.setText("");
                    classCmBox.setValue("Анги сонгох");
                    comNumFld.setText("");
                    emailFld.setText("");
                    
                    Launcher.getSTUDENT().TableRefresh();
                }
            }
            
            
            
//            try {
//                Socket sk = new Socket("192.168.0.189", 4040);
//                OutputStream output = sk.getOutputStream();
//                OutputStreamWriter outputStream = new OutputStreamWriter(sk.getOutputStream());
//                outputStream.write(file.getName() + "\n");
//                outputStream.flush();
//                BufferedReader inReader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
//                String serverStatus = inReader.readLine(); // Read the first line  
//                if (serverStatus.equals("READY")) {
//                    FileInputStream files = new FileInputStream(file);
//                    byte[] buffer = new byte[sk.getSendBufferSize()];
//                    int bytesRead = 0;
//                    while ((bytesRead = files.read(buffer)) > 0) {
//                        output.write(buffer, 0, bytesRead);
//                    }
//                    output.close();
//                    files.close();
//                    sk.close();
//                    JOptionPane.showMessageDialog(null, "Transfer complete");
//                }
//            } catch (IOException | HeadlessException ex) {
//                ex.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Error");
//            }
        });
        
        cancelBtn=new Button("Болих");
        cancelBtn.setFont(Font.font("Verdana", 15));
        cancelBtn.setOnAction(ae-> {
            int answer=JOptionPane.showConfirmDialog(null, "Гарах уу?");
            if(answer==JOptionPane.YES_OPTION) {
                addStudentStage.close();
            }
        });
        cancelBtn.setPrefSize(120, 30);
        cancelBtn.setLayoutX(160);
        cancelBtn.setLayoutY(680);
        
        
        pane.getChildren().addAll(
                pictureLbl,
                browseBtn,
                pictureFld,
                nameLbl,
                firstNameFld,
                lastNameFld,
                statusLbl,
                statusCmBox,
                mobileLbl,
                countryCmBox,
                mobileFld,
                addressLbl,
                addressArea,
                classLbl,
                classCmBox,
                comNumFld,
                emailLbl,
                emailFld,
                cancelBtn,
                registerBtn
        );
        
        Scene scene=new Scene(pane, 305, 730);
        scene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
        addStudentStage.setTitle("Оюутан нэмэх");
        addStudentStage.setScene(scene);
        addStudentStage.setResizable(false);
        addStudentStage.show();
    }

    private void MobileField() {
        final int limit=8;
        mobileFld.setPrefSize(170, 25);
        mobileFld.setLayoutX(110);
        mobileFld.setLayoutY(330);
        mobileFld.setPromptText("Утасны дугаар");
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
        
        fieldValidate(mobileFld);
    }
    
    private void EmailField() {
        emailFld.setPrefSize(255, 25);
        emailFld.setLayoutX(25);
        emailFld.setLayoutY(590);
        emailFld.setPromptText("Жишээ нь: _____@_____.com");
        
        fieldValidate(emailFld);
    }
    
    private void ComputerField() {
        final int limit=2;
        comNumFld.setPrefSize(130, 25);
        comNumFld.setLayoutX(150);
        comNumFld.setLayoutY(510);
        comNumFld.setPromptText("Компьютер №");
        comNumFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            if(!((c>='0')&&(c<='9')|| (c == '+') ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        comNumFld.textProperty().addListener((Observable observable) -> {
            String value=((StringProperty)observable).get();
            if(value.length()>limit) {
                comNumFld.textProperty().setValue(value.substring(0, limit));
            }
        });
        
        fieldValidate(comNumFld);
    }
    
    public void GetUserInfo() {
        firstName=firstNameFld.getText();
        lastName=lastNameFld.getText();
        mobile=mobileFld.getText();
        email=emailFld.getText();
        address=addressArea.getText();
        className=classCmBox.getSelectionModel().getSelectedIndex()+1;
        computerNumber=comNumFld.getText();
        status=statusCmBox.getSelectionModel().getSelectedIndex()+1;
        insert=lastName+"::"+firstName+"::"+mobile+"::"+address+"::"+email+"::"+computerNumber+"::"+className+"::"+status+"::"+"'"+pictureFld.getText()+"'";
    }
        
    private void fieldValidate(TextField textField) {
        textField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(oldValue) {
                textFieldValidate(textField);
            }
        });
    }
    
    private void textFieldValidate(final TextField textField) {
        textField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            fieldValidation(textField);
        });
        
        fieldValidation(textField);
    }
    
    public void fieldValidation(TextField textField) {
        ObservableList<String> styleClass=textField.getStyleClass();
        if(textField.getText().trim().length()==0) {
            if(! styleClass.contains("error")) {
                styleClass.add("error");
            }
        }
        
        else {
            styleClass.removeAll(Collections.singleton("error"));
        }
    }
    
    private void areaValidate(TextArea textArea) {
        textArea.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(oldValue) {
                textAreaValidate(textArea);
            }
        });
    }
    
    private void textAreaValidate(final TextArea textArea) {
        textArea.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            textAreaValidation(textArea);
        });
        
        textAreaValidation(textArea);
    }
    
    public void textAreaValidation(TextArea textArea) {
        ObservableList<String> styleClass=textArea.getStyleClass();
        if(textArea.getText().trim().length()==0) {
            if(! styleClass.contains("error")) {
                styleClass.add("error");
            }
        }
        
        else {
            styleClass.removeAll(Collections.singleton("error"));
        }
    }
}
