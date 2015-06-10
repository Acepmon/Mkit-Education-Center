package ManagerPac;

import java.awt.event.KeyEvent;
import java.util.Collections;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AddStudent extends Application {
    private Label pictureLbl;
    private Button browseBtn;
    
    private Label nameLbl;
    private TextField firstNameFld;
    private TextField lastNameFld;
    
    private Label genderLbl;
    private ComboBox<String> genderCmBox;
    
    private Label mobileLbl;
    private ComboBox<String> countryCmBox;
    private TextField mobileFld;
    
    private Label addressLbl;
    private TextArea addressArea;
    
    private Label birthLbl;
    private TextField ddFld;
    private Label slash1;
    private TextField mmFld;
    private Label slash2;
    private TextField yyyyFld;
    
    private Label classLbl;
    private ComboBox<String> classCmBox;
    private ComboBox<String> comCmBox;
    
    private Label emailLbl;
    private TextField emailFld;
    
    private Button registerBtn;
    private Button cancelBtn;
    
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String mobile;
    private String address;
    private String dd;
    private String mm;
    private String yyyy;
    private String dateOfBirth;
    private String className;
    private String computerNumber;
    
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
        
        genderLbl=new Label("Хүйс");
        genderLbl.setId("regLbl");
        genderLbl.setFont(Font.font("Verdana", 15));
        genderLbl.setPrefSize(50, 25);
        genderLbl.setLayoutX(25);
        genderLbl.setLayoutY(210);
        
        ObservableList<String> genders=FXCollections.observableArrayList("Эрэгтэй", "Эмэгтэй");
        genderCmBox=new ComboBox<String>(genders);
        genderCmBox.setValue("Би бол ......");
        genderCmBox.setPrefSize(255, 25);
        genderCmBox.setLayoutX(25);
        genderCmBox.setLayoutY(240);
        
        mobileLbl=new Label("Утасны дугаар");
        mobileLbl.setId("regLbl");
        mobileLbl.setFont(Font.font("Verdana", 15));
        mobileLbl.setPrefSize(150, 25);
        mobileLbl.setLayoutX(25);
        mobileLbl.setLayoutY(280);
        
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
        countryCmBox.setLayoutY(310);
        
        addressLbl=new Label("Гэрийн хаяг");
        addressLbl.setId("regLbl");
        addressLbl.setFont(Font.font("Verdana", 15));
        addressLbl.setPrefSize(140, 25);
        addressLbl.setLayoutX(25);
        addressLbl.setLayoutY(350);
        
        addressArea=new TextArea();
        addressArea.setPromptText("Одоо байрлаж буй хаяг");
        addressArea.setPrefSize(255, 50);
        addressArea.setLayoutX(25);
        addressArea.setLayoutY(380);
        
        birthLbl=new Label("Төрсөн өдөр");
        birthLbl.setId("regLbl");
        birthLbl.setFont(Font.font("Verdana", 15));
        birthLbl.setPrefSize(140, 25);
        birthLbl.setLayoutX(25);
        birthLbl.setLayoutY(450);
        
        ddFld=new TextField();
        DayField();
        
        slash1=new Label("/");
        slash1.setPrefSize(10, 25);
        slash1.setLayoutX(90);
        slash1.setLayoutY(480);
        
        mmFld=new TextField();
        MonthField();
        
        slash2=new Label("/");
        slash2.setPrefSize(10, 25);
        slash2.setLayoutX(180);
        slash2.setLayoutY(480);
        
        yyyyFld=new TextField();
        YearField();
        
        classLbl=new Label("Суралцах анги");
        classLbl.setId("regLbl");
        classLbl.setFont(Font.font("Verdana", 15));
        classLbl.setPrefSize(140, 25);
        classLbl.setLayoutX(25);
        classLbl.setLayoutY(530);
        
        ObservableList<String> classes=FXCollections.observableArrayList("Java", "C#", "Үндсэн хэрэглээ");
        classCmBox=new ComboBox<String>(classes);
        classCmBox.setValue("Анги сонгох");
        classCmBox.setPrefSize(135, 25);
        classCmBox.setLayoutX(25);
        classCmBox.setLayoutY(560);
        
        ObservableList<String> coms=FXCollections.observableArrayList("Com1", "Com2", "Com3");
        comCmBox=new ComboBox<String>(coms);
        comCmBox.setValue("Компьютер");
        comCmBox.setPrefSize(110, 25);
        comCmBox.setLayoutX(170);
        comCmBox.setLayoutY(560);
        
        emailLbl=new Label("И-мэйл хаяг");
        emailLbl.setId("regLbl");
        emailLbl.setFont(Font.font("Verdana", 15));
        emailLbl.setPrefSize(140, 25);
        emailLbl.setLayoutX(25);
        emailLbl.setLayoutY(610);
        
        emailFld=new TextField();
        EmailField();
        
        registerBtn=new Button("Бүртгүүлэх");
        registerBtn.setFont(Font.font("Verdana", 15));
        registerBtn.setPrefSize(120, 30);
        registerBtn.setLayoutX(25);
        registerBtn.setLayoutY(680);
        registerBtn.setOnAction(ae -> {
            
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
                nameLbl,
                firstNameFld,
                lastNameFld,
                genderLbl,
                genderCmBox,
                mobileLbl,
                countryCmBox,
                mobileFld,
                addressLbl,
                addressArea,
                birthLbl,
                ddFld,
                slash1,
                mmFld,
                slash2,
                yyyyFld,
                classLbl,
                classCmBox,
                comCmBox,
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
        mobileFld.setLayoutY(310);
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
    
    private void DayField() {
        final int limit=2;
        ddFld.setPrefSize(45, 25);
        ddFld.setLayoutX(25);
        ddFld.setLayoutY(480);
        ddFld.setPromptText("Өдөр");
        ddFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            if(!((c>='0')&&(c<='9') ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        ddFld.textProperty().addListener((Observable observable) -> {
            String value=((StringProperty)observable).get();
            if(value.length()>limit) {
                ddFld.textProperty().setValue(value.substring(0, limit));
            }
        });
        
        fieldValidate(ddFld);
    }
    
    private void MonthField() {
        final int limit=2;
        mmFld.setPrefSize(45, 25);
        mmFld.setLayoutX(115);
        mmFld.setLayoutY(480);
        mmFld.setPromptText("Сар");
        mmFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        mmFld.textProperty().addListener((Observable observable) -> {
            String value=((StringProperty)observable).get();
            if(value.length()>limit) {
                mmFld.textProperty().setValue(value.substring(0, limit));
            }
        });
        
        fieldValidate(mmFld);
    }
    
    private void YearField() {
        final int limit=4;
        yyyyFld.setPrefSize(75, 25);
        yyyyFld.setLayoutX(205);
        yyyyFld.setLayoutY(480);
        yyyyFld.setPromptText("Жил");
        yyyyFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        yyyyFld.textProperty().addListener((Observable observable) -> {
            String value=((StringProperty)observable).get();
            if(value.length()>limit) {
                yyyyFld.textProperty().setValue(value.substring(0, limit));
            }
        });
        
        fieldValidate(yyyyFld);
    }
    
    private void EmailField() {
        emailFld.setPrefSize(255, 25);
        emailFld.setLayoutX(25);
        emailFld.setLayoutY(640);
        emailFld.setPromptText("Жишээ нь: _____@_____.com");
        
        fieldValidate(emailFld);
    }
    
    public void GetUserInfo() {
        firstName=firstNameFld.getText();
        lastName=lastNameFld.getText();
        gender=genderCmBox.getValue();
        country=countryCmBox.getValue();
        mobile=mobileFld.getText();
        address=addressArea.getText();
        dd=ddFld.getText();
        mm=mmFld.getText();
        yyyy=yyyyFld.getText();
        dateOfBirth=yyyy+"/"+mm+"/"+dd;
        className=classCmBox.getValue();
        computerNumber=comCmBox.getValue();
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
}
