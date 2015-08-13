package ManagerPac;

import Controller.ServerConnection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Teacher {

    private Pane teacherPane;

    public Pane getTeacherPane() {
        return teacherPane;
    }

    public void setTeacherPane(Pane teacherPane) {
        this.teacherPane = teacherPane;
    }

    public static TableView tableView;
    private ObservableList<TeacherObj> data = FXCollections.observableArrayList();

    private Label teacherLbl;
    private Label teacherInfoLbl;
    private ComboBox<String> searchByCmBox;
    private TextField searchFld;

    public static ImageView imageView;
    private Label browseLbl;

    private Label nameLbl;
    private Label classLbl;
    private Label statLbl;

    private Label registrationLbl;
    private Label lastNameLbl;
    private Label firstNameLbl;
    private Label statusLbl;
    private Label lessonLbl;
    private Label phoneLbl;
    private Label emailLbl;
    private Label socialLbl;
    private Label addressLbl;
    private Label pictureLbl;
    private Label userNameLbl;
    private Label passWordLbl;

    private TextField registrationFld;
    private TextField lastNameFld;
    private TextField firstNameFld;
    private ComboBox statusCmBox;
    private ComboBox lessonCmBox;
    private TextField phoneFld;
    private TextField emailFld;
    private TextArea socialArea;
    private TextArea addressArea;
    private TextField userNameFld;
    private PasswordField passWordFld;
    private TextField passWordShowFld;
    private Button showPassWordBtn;
    private Boolean toggle = false;
    private Boolean button = false;

    private Button searchBtn;
    private Button editBtn;
    private Button storeBtn;

    FileChooser fileChooser;
    File file;

    private String id;
    private String registration;
    private String lastName;
    private String firstName;
    private int status;
    private String lesson;
    private String phone;
    private String email;
    private String social;
    private String address;
    private String deleteFlag;
    private String picture;
    private String userName;
    private String passWord;

    private String update;

    public Teacher() {
        teacherPane = new Pane();

        TableRefresh();

        teacherLbl = new Label("Багш нар");
        teacherLbl.setPrefSize(150, 25);
        teacherLbl.setFont(Font.font("Verdana", 20));
        teacherLbl.setLayoutX(60);
        teacherLbl.setLayoutY(40);

        tableView = new TableView();
        tableView.setPrefSize(480, 450);
        tableView.setLayoutX(60);
        tableView.setLayoutY(80);
        tableColumns();
        tableView.setItems(data);

        ObservableList<String> types = FXCollections.observableArrayList(
                "Нийтээр нь хайх",
                "Peгистрээр",
                "Овогоор",
                "Нэрээр",
                "Cтатусаар",
                "Хичээлээр",
                "Утасны дугаараар",
                "Цахим шуудангаар",
                "Цахим хаягаар",
                "Гэрийн хаягаар"
        );
        searchByCmBox = new ComboBox<String>(types);
        searchByCmBox.setOnAction(ae -> {
            searchFilter();
        });
        searchByCmBox.setValue("Нийтээр нь хайх");
        searchByCmBox.setPrefSize(180, 25);
        searchByCmBox.setLayoutX(60);
        searchByCmBox.setLayoutY(560);
        searchByCmBox.setId("iphone");

        searchFld = new TextField();
        searchFld.setPrefSize(140, 25);
        searchFld.setLayoutX(290);
        searchFld.setLayoutY(560);
        searchFld.setId("info");
        searchFld.setPromptText("Хайх үгээ оруул ....");
        searchFld.setOnKeyReleased(ae -> {
            searchFilter();
        });

        Image searchImg = new Image("ManagerPac/search-icon.png");
        ImageView searchIcon = new ImageView();
        searchIcon.setImage(searchImg);
        searchIcon.setFitHeight(14);
        searchIcon.setFitWidth(14);

        searchBtn = new Button("", searchIcon);
        searchBtn.setOnAction(ae -> {
        });
        searchBtn.setPrefSize(25, 25);
        searchBtn.setLayoutX(430);
        searchBtn.setLayoutY(560);
        searchBtn.setId("search");

        teacherInfoLbl = new Label("Багшийн мэдээлэл");
        teacherInfoLbl.setPrefSize(200, 25);
        teacherInfoLbl.setFont(Font.font("Verdana", 20));
        teacherInfoLbl.setLayoutX(580);
        teacherInfoLbl.setLayoutY(40);

        Image image = new Image("ManagerPac/photo-not-available.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(90);
        imageView.setFitWidth(90);
        imageView.setLayoutX(580);
        imageView.setLayoutY(80);
        imageView.setId("image-view");

        browseLbl = new Label("Зураг сонгох");
        browseLbl.setFont(Font.font("Verdana", 10));
        browseLbl.setPrefSize(90, 25);
        browseLbl.setLayoutX(580);
        browseLbl.setLayoutY(170);
        browseLbl.setId("browseLbl");
        browseLbl.setVisible(false);
        browseLbl.setOnMouseClicked(ae -> {
            Stage stage = new Stage();
            UpdateTeacherImage update = new UpdateTeacherImage();
            update.start(stage);
        });

        nameLbl = new Label("Нэр");
        nameLbl.setFont(Font.font("Verdana", 14));
        nameLbl.setLayoutX(680);
        nameLbl.setLayoutY(85);

        Label dot = new Label(":");
        dot.setFont(Font.font("Verdana", 14));
        dot.setLayoutX(740);
        dot.setLayoutY(85);

        classLbl = new Label("Хичээл");
        classLbl.setFont(Font.font("Verdana", 14));
        classLbl.setLayoutX(680);
        classLbl.setLayoutY(115);

        Label dot1 = new Label(":");
        dot1.setFont(Font.font("Verdana", 14));
        dot1.setLayoutX(740);
        dot1.setLayoutY(115);

        statLbl = new Label("Статус");
        statLbl.setFont(Font.font("Verdana", 14));
        statLbl.setLayoutX(680);
        statLbl.setLayoutY(145);

        Label dot2 = new Label(":");
        dot2.setFont(Font.font("Verdana", 14));
        dot2.setLayoutX(740);
        dot2.setLayoutY(145);

        pictureLbl = new Label();
        pictureLbl.setPrefSize(150, 25);
        pictureLbl.setLayoutX(810);
        pictureLbl.setLayoutY(90);
        pictureLbl.setVisible(false);
        pictureLbl.setId("info");

        userNameLbl = new Label("Нэвтрэх нэр");
        userNameLbl.setFont(Font.font("Verdana", 14));
        userNameLbl.setLayoutX(580);
        userNameLbl.setLayoutY(210);

        userNameFld = new TextField();
        userNameFld.setPrefSize(150, 25);
        userNameFld.setLayoutX(710);
        userNameFld.setLayoutY(210);
        userNameFld.setPromptText("Username");
        userNameFld.setEditable(false);

        passWordLbl = new Label("Нууц үг");
        passWordLbl.setFont(Font.font("Verdana", 14));
        passWordLbl.setLayoutX(580);
        passWordLbl.setLayoutY(245);

        passWordFld = new PasswordField();
        passWordFld.setPrefSize(150, 25);
        passWordFld.setLayoutX(710);
        passWordFld.setLayoutY(245);
        passWordFld.setPromptText("Password");
        passWordFld.setEditable(false);

        passWordShowFld = new TextField();
        passWordShowFld.setPrefSize(150, 25);
        passWordShowFld.setLayoutX(710);
        passWordShowFld.setLayoutY(245);
        passWordShowFld.setVisible(false);
        passWordShowFld.setEditable(false);

        Image showIcon = new Image("ManagerPac/eye-icon.png");
        ImageView showView = new ImageView();
        showView.setImage(showIcon);
        showView.setFitHeight(20);
        showView.setFitWidth(20);
        showView.setLayoutX(860);
        showView.setLayoutY(245);

        showPassWordBtn = new Button("Show");
        showPassWordBtn.setLayoutX(860);
        showPassWordBtn.setLayoutY(245);
        showPassWordBtn.setId("search");
        showPassWordBtn.setOnAction(ae -> {
            if (!toggle) {
                passWordShowFld.setVisible(true);
                passWordFld.setVisible(false);
                toggle = true;
            } else {
                passWordShowFld.setVisible(false);
                passWordFld.setVisible(true);
                toggle = false;
            }
        });

        registrationLbl = new Label("Регистер");
        registrationLbl.setFont(Font.font("Verdana", 14));
        registrationLbl.setLayoutX(580);
        registrationLbl.setLayoutY(280);

        RegistrationField();

        lastNameLbl = new Label("Овог");
        lastNameLbl.setFont(Font.font("Verdana", 14));
        lastNameLbl.setLayoutX(580);
        lastNameLbl.setLayoutY(315);

        LastNameField();

        firstNameLbl = new Label("Нэр");
        firstNameLbl.setFont(Font.font("Verdana", 14));
        firstNameLbl.setLayoutX(580);
        firstNameLbl.setLayoutY(350);

        FirstNameField();

        statusLbl = new Label("Статус");
        statusLbl.setFont(Font.font("Verdana", 14));
        statusLbl.setLayoutX(580);
        statusLbl.setLayoutY(385);

        ObservableList<String> stat = FXCollections.observableArrayList(
                "ажиллаж байгаа",
                "ажиллахаа больсон"
        );
        statusCmBox = new ComboBox(stat);
        statusCmBox.setValue("Статус сонгох");
        statusCmBox.setPrefSize(160, 25);
        statusCmBox.setLayoutX(710);
        statusCmBox.setLayoutY(385);
        statusCmBox.setId("iphone");

        lessonLbl = new Label("Хичээл");
        lessonLbl.setFont(Font.font("Verdana", 14));
        lessonLbl.setLayoutX(580);
        lessonLbl.setLayoutY(420);

        ObservableList<String> classes = FXCollections.observableArrayList(
                "Java",
                "C#",
                "MS Office"
        );
        lessonCmBox = new ComboBox<String>(classes);
        lessonCmBox.setValue("Анги сонгох");
        lessonCmBox.setPrefSize(150, 25);
        lessonCmBox.setLayoutX(710);
        lessonCmBox.setLayoutY(420);
        lessonCmBox.setId("iphone");

        phoneLbl = new Label("Утас");
        phoneLbl.setFont(Font.font("Verdana", 14));
        phoneLbl.setLayoutX(580);
        phoneLbl.setLayoutY(455);

        MobileField();

        emailLbl = new Label("Цахим шуудан");
        emailLbl.setFont(Font.font("Verdana", 14));
        emailLbl.setLayoutX(580);
        emailLbl.setLayoutY(490);

        emailFld = new TextField();
        emailFld.setId("info");
        emailFld.setPrefSize(150, 25);
        emailFld.setLayoutX(710);
        emailFld.setLayoutY(490);
        emailFld.setPromptText("Цахим шуудангийн хаяг");
        emailFld.setEditable(false);

        socialLbl = new Label("Цахим хаяг");
        socialLbl.setFont(Font.font("Verdana", 14));
        socialLbl.setLayoutX(580);
        socialLbl.setLayoutY(525);

        socialArea = new TextArea();
        socialArea.setId("info");
        socialArea.setPrefSize(180, 55);
        socialArea.setLayoutX(710);
        socialArea.setLayoutY(525);
        socialArea.setPromptText("Цахим хаяг");
        socialArea.setEditable(false);

        addressLbl = new Label("Гэрийн хаяг");
        addressLbl.setFont(Font.font("Verdana", 14));
        addressLbl.setLayoutX(580);
        addressLbl.setLayoutY(590);

        addressArea = new TextArea();
        addressArea.setId("info");
        addressArea.setPrefSize(180, 55);
        addressArea.setLayoutX(710);
        addressArea.setLayoutY(590);
        addressArea.setPromptText("Одоо байрлаж буй хаяг");
        addressArea.setEditable(false);

        editBtn = new Button("Засах");
        editBtn.setPrefSize(100, 30);
        editBtn.setLayoutX(900);
        editBtn.setLayoutY(615);
        editBtn.setId("iphone");
        editBtn.setFont(Font.font("Verdana", 14));
        editBtn.setOnAction(ae -> {
            if (tableView.getSelectionModel().isEmpty()) {
                editBtn.setVisible(true);
                storeBtn.setVisible(false);
            } else {
                if (!button) {
                    browseLbl.setVisible(true);
                    editBtn.setVisible(false);
                    storeBtn.setVisible(true);
                    registrationFld.setEditable(true);
                    firstNameFld.setEditable(true);
                    lastNameFld.setEditable(true);
                    phoneFld.setEditable(true);
                    emailFld.setEditable(true);
                    socialArea.setEditable(true);
                    addressArea.setEditable(true);
                    userNameFld.setEditable(true);
                    passWordFld.setEditable(true);
                    passWordShowFld.setEditable(true);
                    button = true;
                } else {
                    editBtn.setVisible(true);
                    storeBtn.setVisible(false);
                    button = false;
                }
            }

        });

        storeBtn = new Button("Хадгалах");
        storeBtn.setPrefSize(100, 30);
        storeBtn.setLayoutX(900);
        storeBtn.setLayoutY(615);
        storeBtn.setId("iphone");
        storeBtn.setFont(Font.font("Verdana", 14));
        storeBtn.setVisible(false);
        storeBtn.setOnAction(ae -> {
            System.out.println(update);

            getTeacherInfo();
            System.out.println(update);
            ServerConnection.Request("updateTeacher", update);
            TableRefresh();
        });

        tableView.setOnMousePressed(ae -> {
            browseLbl.setVisible(false);
            editBtn.setVisible(true);
            storeBtn.setVisible(false);
            button = false;
            registrationFld.setEditable(false);
            firstNameFld.setEditable(false);
            lastNameFld.setEditable(false);
            phoneFld.setEditable(false);
            emailFld.setEditable(false);
            socialArea.setEditable(false);
            addressArea.setEditable(false);
            userNameFld.setEditable(false);
            passWordFld.setEditable(false);
            passWordShowFld.setEditable(false);

            if (tableView.getSelectionModel().getSelectedItem() != null) {
                TeacherObj teacher = (TeacherObj) tableView.getSelectionModel().getSelectedItem();
                dot.setText(": " + teacher.getFirstName());
                dot1.setText(": " + teacher.getLesson());
                dot2.setText(": " + teacher.getStatus());
                userNameFld.setText(teacher.getUsername());
                passWordFld.setText(teacher.getPassword());
                passWordShowFld.setText(teacher.getPassword());
                registrationFld.setText(teacher.getRegistration());
                lastNameFld.setText(teacher.getLastName());
                firstNameFld.setText(teacher.getFirstName());
                statusCmBox.getSelectionModel().select(teacher.getStatus());
                lessonCmBox.getSelectionModel().select(teacher.getLesson());
                phoneFld.setText(teacher.getPhone());
                emailFld.setText(teacher.getEmail());
                socialArea.setText(teacher.getSocial());
                addressArea.setText(teacher.getAddress());
                Image img = new Image("file:///" + System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images" + "\\" + ServerConnection.Request("getTeacherImage", teacher.getId()));
                imageView.setImage(img);
            }
        });

        teacherPane.getChildren().addAll(
                teacherLbl,
                teacherInfoLbl,
                tableView,
                searchByCmBox,
                searchFld,
                searchBtn,
                imageView,
                browseLbl,
                nameLbl,
                dot,
                classLbl,
                dot1,
                statLbl,
                dot2,
                pictureLbl,
                userNameLbl,
                userNameFld,
                passWordLbl,
                passWordFld,
                passWordShowFld,
                showPassWordBtn,
                registrationLbl,
                lastNameLbl,
                firstNameLbl,
                statusLbl,
                lessonLbl,
                phoneLbl,
                emailLbl,
                socialLbl,
                addressLbl,
                registrationFld,
                lastNameFld,
                firstNameFld,
                statusCmBox,
                lessonCmBox,
                phoneFld,
                emailFld,
                socialArea,
                addressArea,
                editBtn,
                storeBtn
        );
    }

    /**
     * Filling table with data
     */
    public void TableRefresh() {
        ArrayList<String> arrayData = (ArrayList<String>) ServerConnection.Request("getAllTeacherProfile", null);
        data.clear();
        System.out.println(arrayData);

        for (int i = 0; i < arrayData.size(); i++) {
            String str = (String) arrayData.get(i);
            ArrayList<String> cols = new ArrayList<>();
            for (String str1 : str.split("::")) {
                cols.add(str1);
            }
            System.out.println(str + " - printed.");
            if (cols.size() < 12) {
                for (int j = cols.size(); j < 12; j++) {
                    cols.add("");
                }
            }
            TeacherObj teacherObj = new TeacherObj(
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
                    cols.get(11),
                    cols.get(12),
                    cols.get(13)
            );
            data.add(teacherObj);
        }
    }

    /**
     * Adding table columns
     */
    public void tableColumns() {
        TableColumn lastNameCol = new TableColumn("Овог");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("lastName"));
        lastNameCol.setMaxWidth(100);
        lastNameCol.setMinWidth(100);
        lastNameCol.setId("column");

        TableColumn firstNameCol = new TableColumn("Нэр");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("firstName"));
        firstNameCol.setMaxWidth(98);
        firstNameCol.setMinWidth(98);
        firstNameCol.setId("column");

        TableColumn phoneCol = new TableColumn("Утасны дугаар");
        phoneCol.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("phone"));
        phoneCol.setMaxWidth(100);
        phoneCol.setMinWidth(100);
        phoneCol.setId("column");

        TableColumn statusCol = new TableColumn("Cтатус");
        statusCol.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("status"));
        statusCol.setMaxWidth(180);
        statusCol.setMinWidth(180);
        statusCol.setId("column");

        tableView.getColumns().addAll(lastNameCol, firstNameCol, phoneCol, statusCol);
    }

    /**
     * User input validation
     */
    private void RegistrationField() {
        final int limit = 10;
        registrationFld = new TextField();
        registrationFld.setId("info");
        registrationFld.setPrefSize(150, 25);
        registrationFld.setLayoutX(710);
        registrationFld.setLayoutY(280);
        registrationFld.setPromptText("Регистрийн дугаар");
        registrationFld.setEditable(false);
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
        phoneFld = new TextField();
        phoneFld.setId("info");
        phoneFld.setPrefSize(150, 25);
        phoneFld.setLayoutX(710);
        phoneFld.setLayoutY(455);
        phoneFld.setPromptText("Утасны дугаар");
        phoneFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            if (!((c >= '0') && (c <= '9') || (c == '+') || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });

        phoneFld.textProperty().addListener((Observable observable) -> {
            String value = ((StringProperty) observable).get();
            if (value.length() > limit) {
                phoneFld.textProperty().setValue(value.substring(0, limit));
            }
        });
    }

    /**
     * User input validation
     */
    private void LastNameField() {
        lastNameFld = new TextField();
        lastNameFld.setId("info");
        lastNameFld.setPrefSize(150, 25);
        lastNameFld.setLayoutX(710);
        lastNameFld.setLayoutY(315);
        lastNameFld.setPromptText("Эцэг эсвэл эхийн нэр");
        lastNameFld.setEditable(false);
        lastNameFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            String sag = lastNameFld.getText();
            if (!(((c >= 'a') || (c >= 'A')) && ((c <= 'z') || (c <= 'Z')) || ((c >= 'а') || (c >= 'А')) && ((c <= 'я') || (c <= 'Я')) || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
    }
    
    /**
     * User input validation
     */
    private void FirstNameField() {
        firstNameFld = new TextField();
        firstNameFld.setId("info");
        firstNameFld.setPrefSize(150, 25);
        firstNameFld.setLayoutX(710);
        firstNameFld.setLayoutY(350);
        firstNameFld.setPromptText("Багшийн нэр");
        firstNameFld.setEditable(false);
        firstNameFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            String sag = firstNameFld.getText();
            if (!(((c >= 'a') || (c >= 'A')) && ((c <= 'z') || (c <= 'Z')) || ((c >= 'а') || (c >= 'А')) && ((c <= 'я') || (c <= 'Я')) || (c == '-') || (c == ' ') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
    }
    
    /**
     * Searching data from table view
     */
    void searchFilter() {
        String cellValue = "";
        ObservableList<TeacherObj> tableItem = FXCollections.observableArrayList();
        for (int i = 0; i < data.size(); i++) {
            TeacherObj teacherObj = data.get(i);
            switch (searchByCmBox.getSelectionModel().getSelectedIndex()) {
                case 0:
                    cellValue = teacherObj.getRegistration().toLowerCase()
                            + teacherObj.getLastName().toLowerCase()
                            + teacherObj.getFirstName().toLowerCase()
                            + teacherObj.getStatus().toLowerCase()
                            + teacherObj.getLesson().toLowerCase()
                            + teacherObj.getPhone().toLowerCase()
                            + teacherObj.getEmail().toLowerCase()
                            + teacherObj.getSocial().toLowerCase()
                            + teacherObj.getAddress().toLowerCase();
                    break;
                case 1:
                    cellValue = teacherObj.getRegistration().toLowerCase();
                    break;
                case 2:
                    cellValue = teacherObj.getLastName().toLowerCase();
                    break;
                case 3:
                    cellValue = teacherObj.getFirstName().toLowerCase();
                    break;
                case 4:
                    cellValue = teacherObj.getStatus().toLowerCase();
                    break;
                case 5:
                    cellValue = teacherObj.getLesson().toLowerCase();
                    break;
                case 6:
                    cellValue = teacherObj.getPhone().toLowerCase();
                    break;
                case 7:
                    cellValue = teacherObj.getEmail().toLowerCase();
                    break;
                case 8:
                    cellValue = teacherObj.getSocial().toLowerCase();
                    break;
                case 9:
                    cellValue = teacherObj.getAddress().toLowerCase();
                    break;
                default:
                    cellValue = teacherObj.getRegistration().toLowerCase()
                            + teacherObj.getLastName().toLowerCase()
                            + teacherObj.getFirstName().toLowerCase()
                            + teacherObj.getStatus().toLowerCase()
                            + teacherObj.getLesson().toLowerCase()
                            + teacherObj.getPhone().toLowerCase()
                            + teacherObj.getEmail().toLowerCase()
                            + teacherObj.getSocial().toLowerCase()
                            + teacherObj.getAddress().toLowerCase();
                    break;
            }

            if (cellValue.contains(searchFld.getText().toLowerCase())) {
                tableItem.add(teacherObj);
            }

            tableView.setItems(tableItem);
        }
    }

    /**
     * Getting user input information
     */
    public void getTeacherInfo() {
        TeacherObj teacherObj = (TeacherObj) tableView.getSelectionModel().getSelectedItem();
        id = teacherObj.getId();
        registration = registrationFld.getText();
        lastName = lastNameFld.getText();
        firstName = firstNameFld.getText();
        status = statusCmBox.getSelectionModel().getSelectedIndex() + 8;
        lesson = lessonCmBox.getSelectionModel().getSelectedItem().toString();
        phone = phoneFld.getText();
        email = emailFld.getText();
        social = socialArea.getText();
        deleteFlag = teacherObj.getDeleteFlag();
        address = addressArea.getText();
        picture = pictureLbl.getText();
        userName = userNameFld.getText();
        passWord = passWordFld.getText();
        update = id + "::" + registration + "::" + lastName + "::" + firstName + "::" + status + "::" + lesson + "::" + phone + "::" + email + "::" + social + "::" + deleteFlag + "::" + address + "::" + UpdateTeacherImage.displayNameLbl.getText() + "::" + userName + "::" + passWord;
    }
}
