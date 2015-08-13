package ManagerPac;

import Controller.ServerConnection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ManagerProfile {

    private Pane managerPane;

    public Pane getManagerPane() {
        return managerPane;
    }

    public void setManagerPane(Pane managerPane) {
        this.managerPane = managerPane;
    }

    private Label managerInfoLbl;

    public static ImageView managerView;
    private Label browseLbl;
    FileChooser fileChooser;
    File file;

    private Label userNameLbl;
    private Label passWordLbl;
    private Label registrationLbl;
    private Label lastNameLbl;
    private Label firstNameLbl;
    private Label statusLbl;
    private Label phoneLbl;
    private Label emailLbl;
    private Label socialLbl;
    private Label addressLbl;

    private TextField userNameFld;
    private TextField passWordFld;
    private TextField registrationFld;
    private TextField lastNameFld;
    private TextField firstNameFld;
    private ComboBox statusCmBox;
    private TextField phoneFld;
    private TextField emailFld;
    private TextArea socialArea;
    private TextArea addressArea;

    private Button editBtn;
    private Button cancelBtn;

    private ManagerObj manager;

    private String id;
    private String registration;
    private String lastName;
    private String firstName;
    private int status;
    private String phone;
    private String email;
    private String social;
    private String address;
    private String username;
    private String password;
    private String update = "";

    public void start(Stage managerStage) {
        managerPane = new Pane();
        Scene managerScene = new Scene(managerPane, 350, 700);
        String responseData = (String) ServerConnection.Request("getManagerProfile", Launcher.getMANAGER().managerMenu.getText());

        System.out.println(responseData + " - manager printed");
        ArrayList<String> cols = new ArrayList<>();
        for (String str1 : responseData.split("::")) {
            cols.add(str1);
        }
        System.out.println(responseData + " - manager printed.");
        if (cols.size() < 10) {
            for (int j = cols.size(); j < 10; j++) {
                cols.add("");
            }
        }
        manager = new ManagerObj(
                cols.get(0),
                cols.get(1),
                cols.get(2),
                cols.get(3),
                cols.get(4),
                cols.get(5),
                cols.get(6),
                cols.get(7),
                cols.get(8),
                cols.get(9),
                cols.get(10),
                cols.get(12),
                cols.get(11)
        );
        if (manager.getStatus().equals("")) {
            manager.setStatus("0");
        }

        managerInfoLbl = new Label("Менежерийн мэдээлэл");
        managerInfoLbl.setPrefSize(300, 25);
        managerInfoLbl.setFont(Font.font("Verdana", 20));
        managerInfoLbl.setLayoutX(25);
        managerInfoLbl.setLayoutY(25);

        managerView = new ImageView();
        managerView.setFitHeight(90);
        managerView.setFitWidth(90);
        managerView.setLayoutX(25);
        managerView.setLayoutY(65);
        managerView.setId("image-view");
        Image img = new Image("file:///" + System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images" + "\\" + ServerConnection.Request("getManagerImage", manager.getId()));
        managerView.setImage(img);

        browseLbl = new Label("Зураг сонгох");
        browseLbl.setFont(Font.font("Verdana", 10));
        browseLbl.setPrefSize(90, 25);
        browseLbl.setLayoutX(25);
        browseLbl.setLayoutY(155);
        browseLbl.setId("browseLbl");
        browseLbl.setOnMouseClicked(ae -> {
            Stage stage = new Stage();
            UpdateManagerImage update = new UpdateManagerImage();
            update.start(stage);
        });

        userNameLbl = new Label("Нэвтрэх нэр");
        userNameLbl.setFont(Font.font("Verdana", 14));
        userNameLbl.setLayoutX(25);
        userNameLbl.setLayoutY(200);

        userNameFld = new TextField();
        userNameFld.setPrefSize(150, 25);
        userNameFld.setLayoutX(185);
        userNameFld.setLayoutY(195);
        userNameFld.setText(manager.getUsername());
        userNameFld.setPromptText("Username");
        userNameFld.setId("info");

        passWordLbl = new Label("Нууц үг");
        passWordLbl.setFont(Font.font("Verdana", 14));
        passWordLbl.setLayoutX(25);
        passWordLbl.setLayoutY(240);

        passWordFld = new TextField();
        passWordFld.setPrefSize(150, 25);
        passWordFld.setLayoutX(185);
        passWordFld.setLayoutY(235);
        passWordFld.setText(manager.getPassword());
        passWordFld.setPromptText("Password");
        passWordFld.setId("info");

        registrationLbl = new Label("Регистер");
        registrationLbl.setFont(Font.font("Verdana", 14));
        registrationLbl.setLayoutX(25);
        registrationLbl.setLayoutY(280);

        RegistrationField();

        lastNameLbl = new Label("Овог");
        lastNameLbl.setFont(Font.font("Verdana", 14));
        lastNameLbl.setLayoutX(25);
        lastNameLbl.setLayoutY(320);

        LastNameField();

        firstNameLbl = new Label("Нэр");
        firstNameLbl.setFont(Font.font("Verdana", 14));
        firstNameLbl.setLayoutX(25);
        firstNameLbl.setLayoutY(360);

        FirstNameField();

        statusLbl = new Label("Статус");
        statusLbl.setFont(Font.font("Verdana", 14));
        statusLbl.setLayoutX(25);
        statusLbl.setLayoutY(400);

        ObservableList<String> stat = FXCollections.observableArrayList(
                "ажиллаж байгаа",
                "ажиллахаа больсон"
        );
        statusCmBox = new ComboBox<String>(stat);
        statusCmBox.setPrefSize(150, 25);
        statusCmBox.setLayoutX(185);
        statusCmBox.setLayoutY(395);
        statusCmBox.getSelectionModel().select(manager.getStatus());
        statusCmBox.setId("iphone");

        phoneLbl = new Label("Утас");
        phoneLbl.setFont(Font.font("Verdana", 14));
        phoneLbl.setLayoutX(25);
        phoneLbl.setLayoutY(440);

        phoneFld = new TextField();
        MobileField();

        emailLbl = new Label("Цахим шуудан");
        emailLbl.setFont(Font.font("Verdana", 14));
        emailLbl.setLayoutX(25);
        emailLbl.setLayoutY(480);

        emailFld = new TextField();
        emailFld.setId("info");
        emailFld.setPrefSize(150, 25);
        emailFld.setLayoutX(185);
        emailFld.setLayoutY(475);
        emailFld.setText(manager.getEmail());
        emailFld.setPromptText("E-Mail Address");

        socialLbl = new Label("Цахим хаяг");
        socialLbl.setFont(Font.font("Verdana", 14));
        socialLbl.setLayoutX(25);
        socialLbl.setLayoutY(520);

        socialArea = new TextArea();
        socialArea.setId("info");
        socialArea.setPrefSize(150, 55);
        socialArea.setLayoutX(185);
        socialArea.setLayoutY(515);
        socialArea.setText(manager.getSocial());
        socialArea.setPromptText("Social Address");

        addressLbl = new Label("Гэрийн хаяг");
        addressLbl.setFont(Font.font("Verdana", 14));
        addressLbl.setLayoutX(25);
        addressLbl.setLayoutY(590);

        addressArea = new TextArea();
        addressArea.setId("info");
        addressArea.setPrefSize(150, 55);
        addressArea.setLayoutX(185);
        addressArea.setLayoutY(585);
        addressArea.setText(manager.getAddress());
        addressArea.setPromptText("Home Address");
        addressArea.setWrapText(true);

        editBtn = new Button("Засах");
        editBtn.setPrefSize(145, 30);
        editBtn.setLayoutX(25);
        editBtn.setLayoutY(660);
        editBtn.setFont(Font.font("Verdana", 14));
        editBtn.setId("iphone");
        editBtn.setOnAction(ae -> {
            if (userNameFld.getText().isEmpty()
                    || passWordFld.getText().isEmpty()
                    || registrationFld.getText().isEmpty()
                    || lastNameFld.getText().isEmpty()
                    || firstNameFld.getText().isEmpty()
                    || statusCmBox.getSelectionModel().getSelectedIndex() < 0
                    || phoneFld.getText().isEmpty()
                    || emailFld.getText().isEmpty()
                    || socialArea.getText().isEmpty()
                    || addressArea.getText().isEmpty()) {
                Validation.textFieldValidation(userNameFld);
                Validation.textFieldValidation(passWordFld);
                Validation.textFieldValidation(registrationFld);
                Validation.textFieldValidation(lastNameFld);
                Validation.textFieldValidation(firstNameFld);
                Validation.comboValidation(statusCmBox);
                Validation.textFieldValidation(phoneFld);
                Validation.textFieldValidation(emailFld);
                Validation.areaValidation(socialArea);
                Validation.areaValidation(addressArea);
            } else {
                int answer = JOptionPane.showConfirmDialog(null, "Засах уу?");
                if (answer == JOptionPane.YES_OPTION) {
                    getManagerInfo();
                    System.out.println(update + " - manager profile update printed.");
                    ServerConnection.Request("updateManager", "" + update + "");
                    managerStage.close();
                }
            }
        });

        cancelBtn = new Button("Гарах");
        cancelBtn.setPrefSize(145, 30);
        cancelBtn.setLayoutX(190);
        cancelBtn.setLayoutY(660);
        cancelBtn.setFont(Font.font("Verdana", 14));
        cancelBtn.setId("iphone");
        cancelBtn.setOnAction(ae -> {
            managerStage.close();
        });

        managerPane.getChildren().addAll(
                managerInfoLbl,
                managerView,
                browseLbl,
                userNameLbl,
                passWordLbl,
                registrationLbl,
                lastNameLbl,
                firstNameLbl,
                statusLbl,
                phoneLbl,
                emailLbl,
                socialLbl,
                addressLbl,
                userNameFld,
                passWordFld,
                registrationFld,
                lastNameFld,
                firstNameFld,
                statusCmBox,
                phoneFld,
                emailFld,
                socialArea,
                addressArea,
                editBtn,
                cancelBtn
        );

        Image anotherIcon = new Image("ManagerPac/manager_32x32_white.png");
        managerStage.getIcons().add(anotherIcon);

        managerScene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
        managerStage.setResizable(false);
        managerStage.setScene(managerScene);
        managerStage.show();
    }

    /**
     * User input validation
     */
    private void LastNameField() {
        lastNameFld = new TextField();
        lastNameFld.setId("info");
        lastNameFld.setPrefSize(150, 25);
        lastNameFld.setLayoutX(185);
        lastNameFld.setLayoutY(315);
        lastNameFld.setText(manager.getLastName());
        lastNameFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            String sag = firstNameFld.getText();
            if (!(((c >= 'a') || (c >= 'A')) && ((c <= 'z') || (c <= 'Z')) || ((c >= 'a') || (c >= 'A')) && ((c <= 'я') || (c <= 'Я')) || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        lastNameFld.setPromptText("Last Name");
    }

    /**
     * User input validation
     */
    private void FirstNameField() {
        firstNameFld = new TextField();
        firstNameFld.setId("info");
        firstNameFld.setPrefSize(150, 25);
        firstNameFld.setLayoutX(185);
        firstNameFld.setLayoutY(355);
        firstNameFld.setText(manager.getFirstName());

        firstNameFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            String sag = firstNameFld.getText();
            if (!(((c >= 'a') || (c >= 'A')) && ((c <= 'z') || (c <= 'Z')) || ((c >= 'a') || (c >= 'A')) && ((c <= 'я') || (c <= 'Я')) || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        firstNameFld.setPromptText("First Name");
    }

    /**
     * User input validation
     */
    private void RegistrationField() {
        final int limit = 10;
        registrationFld = new TextField();
        registrationFld.setId("info");
        registrationFld.setPrefSize(150, 25);
        registrationFld.setLayoutX(185);
        registrationFld.setLayoutY(275);
        registrationFld.setText(manager.getRegistration());
        registrationFld.setPromptText("Registration Number");
        registrationFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            if (!(((c >= '0') && (c <= '9')) || ((c >= 'а') || (c >= 'А')) && ((c <= 'я') || (c <= 'Я')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });

        registrationFld.textProperty().addListener((Observable observable) -> {
            String value = ((StringProperty) observable).get();
            if (value.length() > limit) {
                registrationFld.textProperty().setValue(value.substring(0, limit));
            }
        });
    }

    /**
     * User input validation
     */
    private void MobileField() {
        final int limit = 12;
        phoneFld.setId("info");
        phoneFld.setPrefSize(150, 25);
        phoneFld.setLayoutX(185);
        phoneFld.setLayoutY(435);
        phoneFld.setText(manager.getPhone());
        phoneFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            if (!((c >= '0') && (c <= '9') || (c == '+') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });

        phoneFld.textProperty().addListener((Observable observable) -> {
            String value = ((StringProperty) observable).get();
            if (value.length() > limit) {
                phoneFld.textProperty().setValue(value.substring(0, limit));
            }
        });
        phoneFld.setPromptText("Mobile Number");
    }

    /**
     * Getting user information
     */
    public void getManagerInfo() {
        id = manager.getId();
        registration = registrationFld.getText();
        lastName = lastNameFld.getText();
        firstName = firstNameFld.getText();
        status = statusCmBox.getSelectionModel().getSelectedIndex() + 6;
        phone = phoneFld.getText();
        email = emailFld.getText();
        social = socialArea.getText();
        address = addressArea.getText();
        username = userNameFld.getText();
        password = passWordFld.getText();
//        update=id+"::"+registration+"::"+lastName+"::"+firstName+"::"+status+"::"+phone+"::"+email+"::"+social+"::"+address+"::"+"Picture"+"::"+manager.getDrop()+"::"+password+"::"+username;
        update = id + "::" + registration + "::" + lastName + "::" + firstName + "::" + status + "::" + phone + "::" + email + "::" + social + "::" + address + "::" + "Picture" + "::" + manager.getDrop() + "::" + password + "::" + username;
    }
}
