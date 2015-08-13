package ManagerPac;

import Controller.ServerConnection;
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
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AddStudent {

    private Label browseLbl;
    private Label picturePathLbl;
    private Label dot1;
    private Label displayPicPathLbl;
    private Label pictureNameLbl;
    private Label dot2;
    private Label displayPicNameLbl;

    private Label codeLbl;
    private TextField codeFld;

    private Label registrationLbl;
    private TextField registrationFld;

    private Label nameLbl;
    private TextField firstNameFld;
    private TextField lastNameFld;

    private Label statusLbl;
    private ComboBox<String> statusCmBox;

    private Label mobileLbl;
    private TextField mobileFld;

    private Label addressLbl;
    private TextArea addressArea;

    private Label teachersLbl;
    private ListView teachersList;

    private Label computerLbl;
    private TextField comNumFld;

    private Label emailLbl;
    private TextField emailFld;

    private Label socialLbl;
    private TextArea socialArea;

    private Label admissionLbl;
    private TextField admissionFld;

    private Button registerBtn;
    private Button cancelBtn;

    private String code;
    private String lastName;
    private String firstName;
    private int status;
    private String mobile;
    private String email;
    private String social;
    private String registration;
    private String address;
    private String teachers = "";
    private String computerNumber;
    private String admission;
    private int drop;
    private String reason;
    private String picture;
    private String insert = "";
    public static ImageView imageView;

    public static TextField uploadfld;
    public static File file;

    public void start(Stage addStudentStage) {
        Pane pane = new Pane();

        Image image = new Image("ManagerPac/photo-not-available.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(90);
        imageView.setFitWidth(90);
        imageView.setLayoutX(25);
        imageView.setLayoutY(25);

        browseLbl = new Label("Зураг сонгох");
        browseLbl.setFont(Font.font("Verdana", 10));
        browseLbl.setPrefSize(90, 25);
        browseLbl.setLayoutX(25);
        browseLbl.setLayoutY(115);
        browseLbl.setId("browseLbl");
        browseLbl.setOnMouseClicked(ae -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All files", "*.*");
            fileChooser.getExtensionFilters().addAll(allFilter);
            file = fileChooser.showOpenDialog(null);
            displayPicPathLbl.setText("" + file.toString());
            String stfile = "file:///" + file.toString();
            displayPicNameLbl.setText(file.getName());
            imageView.setImage(new Image(stfile));
        });

        picturePathLbl = new Label("Зургийн зам");
        picturePathLbl.setFont(Font.font("Verdana", 15));
        picturePathLbl.setLayoutX(140);
        picturePathLbl.setLayoutY(35);

        dot1 = new Label(":");
        dot1.setFont(Font.font("Verdana", 15));
        dot1.setLayoutX(240);
        dot1.setLayoutY(35);

        displayPicPathLbl = new Label();
        displayPicPathLbl.setLayoutX(255);
        displayPicPathLbl.setLayoutY(37);

        pictureNameLbl = new Label("Зургийн нэр");
        pictureNameLbl.setFont(Font.font("Verdana", 15));
        pictureNameLbl.setLayoutX(140);
        pictureNameLbl.setLayoutY(100);

        dot2 = new Label(":");
        dot2.setFont(Font.font("Verdana", 15));
        dot2.setLayoutX(240);
        dot2.setLayoutY(100);

        displayPicNameLbl = new Label();
        displayPicNameLbl.setLayoutX(255);
        displayPicNameLbl.setLayoutY(102);

        codeLbl = new Label("Код");
        codeLbl.setFont(Font.font("Verdana", 15));
        codeLbl.setLayoutX(25);
        codeLbl.setLayoutY(160);

        CodeField();

        registrationLbl = new Label("Регистер");
        registrationLbl.setFont(Font.font("Verdana", 15));
        registrationLbl.setLayoutX(160);
        registrationLbl.setLayoutY(160);

        registrationFld = new TextField();
        registrationFld.setPrefSize(120, 25);
        registrationFld.setLayoutX(160);
        registrationFld.setLayoutY(190);
        registrationFld.setPromptText("Регистер №");

        nameLbl = new Label("Нэр");
        nameLbl.setId("regLbl");
        nameLbl.setFont(Font.font("Verdana", 15));
        nameLbl.setLayoutX(300);
        nameLbl.setLayoutY(160);

        LastNameField();

        FirstNameField();

        statusLbl = new Label("Статус");
        statusLbl.setId("regLbl");
        statusLbl.setFont(Font.font("Verdana", 15));
        statusLbl.setLayoutX(25);
        statusLbl.setLayoutY(240);

        ObservableList<String> stat = FXCollections.observableArrayList(
                "суралцаж байгаа",
                "хүлээгдэж байгаа"
        );
        statusCmBox = new ComboBox<String>(stat);
        statusCmBox.setValue("Статус сонгох");
        statusCmBox.setId("iphone");
        statusCmBox.setPrefSize(255, 25);
        statusCmBox.setLayoutX(25);
        statusCmBox.setLayoutY(270);
        Validation.comboBoxFocus(statusCmBox);

        admissionLbl = new Label("Элсэлт");
        admissionLbl.setFont(Font.font("Verdana", 15));
        admissionLbl.setLayoutX(300);
        admissionLbl.setLayoutY(240);

        AdmissionField();

        mobileLbl = new Label("Утасны дугаар");
        mobileLbl.setId("regLbl");
        mobileLbl.setFont(Font.font("Verdana", 15));
        mobileLbl.setLayoutX(25);
        mobileLbl.setLayoutY(320);

        MobileField();

        addressLbl = new Label("Гэрийн хаяг");
        addressLbl.setId("regLbl");
        addressLbl.setFont(Font.font("Verdana", 15));
        addressLbl.setLayoutX(25);
        addressLbl.setLayoutY(400);

        addressArea = new TextArea();
        addressArea.setPromptText("Одоо байрлаж буй хаяг");
        addressArea.setPrefSize(255, 50);
        addressArea.setLayoutX(25);
        addressArea.setLayoutY(430);
        addressArea.setWrapText(true);
        addressArea.setId("info");
        Validation.textAreaFocus(addressArea);

        computerLbl = new Label("Компьютер дугаар");
        computerLbl.setId("regLbl");
        computerLbl.setFont(Font.font("Verdana", 15));
        computerLbl.setLayoutX(435);
        computerLbl.setLayoutY(240);

        ComputerField();

        teachersLbl = new Label("Багш нар");
        teachersLbl.setFont(Font.font("Verdana", 15));
        teachersLbl.setLayoutX(25);
        teachersLbl.setLayoutY(500);

        getListInfo();

        emailLbl = new Label("Цахим шуудан");
        emailLbl.setId("regLbl");
        emailLbl.setFont(Font.font("Verdana", 15));
        emailLbl.setLayoutX(300);
        emailLbl.setLayoutY(320);

        emailFld = new TextField();
        emailFld.setPrefSize(255, 25);
        emailFld.setLayoutX(300);
        emailFld.setLayoutY(350);
        emailFld.setId("info");
        emailFld.setPromptText("Жишээ нь: _____@_____.com");
        Validation.textFieldFocus(emailFld);

        socialLbl = new Label("Цахим хаяг");
        socialLbl.setFont(Font.font("Verdana", 15));
        socialLbl.setLayoutX(300);
        socialLbl.setLayoutY(400);

        socialArea = new TextArea();
        socialArea.setPrefSize(255, 50);
        socialArea.setLayoutX(300);
        socialArea.setLayoutY(430);
        socialArea.setPromptText("Цахим хаяг: Facebook, Twitter ... гэх мэт");
        socialArea.setWrapText(true);

        registerBtn = new Button("Бүртгүүлэх");
        registerBtn.setFont(Font.font("Verdana", 15));
        registerBtn.setPrefSize(120, 30);
        registerBtn.setLayoutX(300);
        registerBtn.setLayoutY(600);
        registerBtn.setId("iphone");
        registerBtn.setOnAction(ae -> {
            if (codeFld.getText().isEmpty()
                    || lastNameFld.getText().isEmpty()
                    || firstNameFld.getText().isEmpty()
                    || mobileFld.getText().isEmpty()
                    || emailFld.getText().isEmpty()
                    || socialArea.getText().isEmpty()
                    || registrationFld.getText().isEmpty()
                    || addressArea.getText().isEmpty()
                    || comNumFld.getText().isEmpty()
                    || admissionFld.getText().isEmpty()
                    || statusCmBox.getSelectionModel().getSelectedIndex() < 0) {
                Validation.textFieldValidation(codeFld);
                Validation.textFieldValidation(lastNameFld);
                Validation.textFieldValidation(firstNameFld);
                Validation.textFieldValidation(mobileFld);
                Validation.textFieldValidation(emailFld);
                Validation.areaValidation(socialArea);
                Validation.textFieldValidation(registrationFld);
                Validation.areaValidation(addressArea);
                Validation.textFieldValidation(comNumFld);
                Validation.textFieldValidation(admissionFld);
                Validation.comboValidation(statusCmBox);
            } else {
                int answer = JOptionPane.showConfirmDialog(null, "Нэмэх үү?");
                if (answer == JOptionPane.YES_OPTION) {
                    GetUserInfo();

                    try {
                        Socket sk = new Socket(IPFeature.ip, 4040);
                        OutputStream output = sk.getOutputStream();
                        OutputStreamWriter outputStream = new OutputStreamWriter(sk.getOutputStream());
                        outputStream.write(file.getName() + "\n");
                        outputStream.flush();
                        BufferedReader inReader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                        String serverStatus = inReader.readLine(); // Read the first line  
                        if (serverStatus.equals("READY")) {
                            FileInputStream files = new FileInputStream(file);
                            byte[] buffer = new byte[sk.getSendBufferSize()];
                            int bytesRead = 0;
                            while ((bytesRead = files.read(buffer)) > 0) {
                                output.write(buffer, 0, bytesRead);
                            }
                            output.close();
                            files.close();
                            sk.close();

                        }
                    } catch (IOException | HeadlessException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        Launcher.receiveFiles();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println(insert + " - insert student printed.");
                    ServerConnection.Request("insertStudent", "" + insert + "");

                    codeFld.setText("");
                    lastNameFld.setText("");
                    firstNameFld.setText("");
                    mobileFld.setText("");
                    emailFld.setText("");
                    socialArea.setText("");
                    registrationFld.setText("");
                    addressArea.setText("");
                    comNumFld.setText("");
                    admissionFld.setText("");
                    statusCmBox.setValue("Статус сонгох");
                    addStudentStage.close();

                    Launcher.getSTUDENT().TableRefresh();
                }
            }
        });

        cancelBtn = new Button("Болих");
        cancelBtn.setFont(Font.font("Verdana", 15));
        cancelBtn.setPrefSize(120, 30);
        cancelBtn.setLayoutX(435);
        cancelBtn.setLayoutY(600);
        cancelBtn.setId("iphone");
        cancelBtn.setOnAction(ae -> {
            addStudentStage.close();
        });

        pane.getChildren().addAll(
                imageView,
                browseLbl,
                picturePathLbl,
                dot1,
                displayPicPathLbl,
                pictureNameLbl,
                dot2,
                displayPicNameLbl,
                codeLbl,
                registrationLbl,
                nameLbl,
                statusLbl,
                admissionLbl,
                mobileLbl,
                addressLbl,
                teachersLbl,
                computerLbl,
                emailLbl,
                socialLbl,
                codeFld,
                registrationFld,
                lastNameFld,
                firstNameFld,
                statusCmBox,
                admissionFld,
                comNumFld,
                mobileFld,
                emailFld,
                addressArea,
                socialArea,
                teachersList,
                cancelBtn,
                registerBtn
        );

        Image anotherIcon = new Image("ManagerPac/manager_32x32_white.png");
        addStudentStage.getIcons().add(anotherIcon);

        Scene scene = new Scene(pane, 570, 650);
        scene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
        addStudentStage.setTitle("Оюутан нэмэх");
        addStudentStage.setScene(scene);
        addStudentStage.setResizable(false);
        addStudentStage.show();
    }

    /**
     * User input validation
     */
    private void CodeField() {
        codeFld = new TextField();
        codeFld.setPrefSize(120, 25);
        codeFld.setLayoutX(25);
        codeFld.setLayoutY(190);
        codeFld.setPromptText("Бүртгэлийн код");
        codeFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            if (!(((c >= 'a') || (c >= 'A')) && ((c <= 'z') || (c <= 'Z')) || (c >= '0') && (c <= '9') || (c == '+') || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
    }

    /**
     * User input validation
     */
    private void LastNameField() {
        lastNameFld = new TextField();
        lastNameFld.setPrefSize(120, 25);
        lastNameFld.setLayoutX(300);
        lastNameFld.setLayoutY(190);
        lastNameFld.setPromptText("Овог");
        lastNameFld.setId("info");
        lastNameFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            String sag = lastNameFld.getText();
            if (!(((c >= 'a') || (c >= 'A')) && ((c <= 'z') || (c <= 'Z')) || ((c >= 'а') || (c >= 'А')) && ((c <= 'я') || (c <= 'Я')) || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        Validation.textFieldFocus(lastNameFld);
    }

    /**
     * User input validation
     */
    private void FirstNameField() {
        firstNameFld = new TextField();
        firstNameFld.setPrefSize(120, 25);
        firstNameFld.setLayoutX(435);
        firstNameFld.setLayoutY(190);
        firstNameFld.setPromptText("Өөрийн нэр");
        firstNameFld.setId("info");
        firstNameFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            String sag = firstNameFld.getText();
            if (!(((c >= 'a') || (c >= 'A')) && ((c <= 'z') || (c <= 'Z')) || ((c >= 'а') || (c >= 'А')) && ((c <= 'я') || (c <= 'Я')) || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        Validation.textFieldFocus(firstNameFld);
    }

    /**
     * User input validation
     */
    private void MobileField() {
        final int limit = 12;
        mobileFld = new TextField();
        mobileFld.setPrefSize(255, 25);
        mobileFld.setLayoutX(25);
        mobileFld.setLayoutY(350);
        mobileFld.setPromptText("Утасны дугаар");
        mobileFld.setId("info");
        mobileFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            if (!((c >= '0') && (c <= '9') || (c == '+') || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });

        mobileFld.textProperty().addListener((Observable observable) -> {
            String value = ((StringProperty) observable).get();
            if (value.length() > limit) {
                mobileFld.textProperty().setValue(value.substring(0, limit));
            }
        });

        Validation.textFieldFocus(mobileFld);
    }

    /**
     * User input validation
     */
    private void AdmissionField() {
        final int limit = 4;
        admissionFld = new TextField();
        admissionFld.setPrefSize(120, 25);
        admissionFld.setLayoutX(300);
        admissionFld.setLayoutY(270);
        admissionFld.setPromptText("Элсэлт №");
        admissionFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            if (!((c >= '0') && (c <= '9') || (c == '+') || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });

        admissionFld.textProperty().addListener((Observable observable) -> {
            String value = ((StringProperty) observable).get();
            if (value.length() > limit) {
                admissionFld.textProperty().setValue(value.substring(0, limit));
            }
        });

        Validation.textFieldFocus(admissionFld);
    }

    /**
     * User input validation
     */
    private void ComputerField() {
        final int limit = 6;
        comNumFld = new TextField();
        comNumFld.setPrefSize(130, 25);
        comNumFld.setLayoutX(435);
        comNumFld.setLayoutY(270);
        comNumFld.setPromptText("Компьютер №");
        comNumFld.setId("info");
        comNumFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            if (!(((c >= 'a') || (c >= 'A')) && ((c <= 'z') || (c <= 'Z')) || (c >= '0') && (c <= '9') || (c == '+') || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });

        comNumFld.textProperty().addListener((Observable observable) -> {
            String value = ((StringProperty) observable).get();
            if (value.length() > limit) {
                comNumFld.textProperty().setValue(value.substring(0, limit));
            }
        });

        Validation.textFieldFocus(comNumFld);
    }

    public void getListInfo() {
        ObservableList<HBox> items = FXCollections.observableArrayList();
        ArrayList<String> arrayData = (ArrayList<String>) ServerConnection.Request("getAllTeacherProfile", null);
        teachersList = new ListView(items);
        teachersList.setPrefSize(255, 100);
        teachersList.setLayoutX(25);
        teachersList.setLayoutY(530);
        for (int i = 0; i < arrayData.size(); i++) {
            String str = (String) arrayData.get(i);
            ArrayList<String> cols = new ArrayList<String>();
            for (String str1 : str.split("::")) {
                cols.add(str1);
            }

            HBox hbox = new HBox();
            Label indexLbl = new Label(cols.get(0));
            indexLbl.setVisible(false);

            CheckBox checkBox = new CheckBox(cols.get(3) + " - " + cols.get(1));
            checkBox.setOnAction(ae -> {
                if (checkBox.isSelected()) {
                    teachers += indexLbl.getText() + ",";
                } else {
                    teachers = teachers.substring(0, teachers.lastIndexOf(indexLbl.getText()));
                }

                System.out.println(teachers + "teachers printed.");
            });
            hbox.getChildren().addAll(indexLbl, checkBox);
            items.add(hbox);
        }
    }

    /**
     * Getting user input information and returning it with string
     */
    public void GetUserInfo() {
        code = codeFld.getText();
        lastName = lastNameFld.getText();
        firstName = firstNameFld.getText();
        mobile = mobileFld.getText();
        email = emailFld.getText();
        social = socialArea.getText();
        registration = registrationFld.getText();
        address = addressArea.getText();
        computerNumber = comNumFld.getText();
        admission = admissionFld.getText();
        drop = 0;
        reason = "reason";
        picture = displayPicNameLbl.getText();
        status = statusCmBox.getSelectionModel().getSelectedIndex() + 2;
        insert = code + "::" + lastName + "::" + firstName + "::" + mobile + "::" + email + "::" + social + "::" + registration + "::" + address + "::" + computerNumber + "::" + admission + "::" + drop + "::" + reason + "::" + picture + "::0::0::" + status + "::" + teachers;
//        insert="code0015::lastname::firstname::8888::example@gmail.com::facebook::register::address::userd5::4::0::reason::pic1.png::0::0::3::1,3";
    }

}
