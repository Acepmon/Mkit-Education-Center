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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Student {

    private Pane studentPane;

    public Pane getStudentPane() {
        return studentPane;
    }

    public void setStudentPane(Pane studentPane) {
        this.studentPane = studentPane;
    }

    public static TableView tableView;
    public static ImageView studentView;
    private Image studentImage;
    private Label studentLbl;
    private Label studentInfoLbl;

    private Label browseLbl;
    private Label studentCodeLbl;
    private Label studentNameLbl;
    private Label studentClassLbl;
    private Label pictureLbl;
    public static File file = null;

    private ComboBox<String> searchByCmBox;
    private TextField searchFld;
    private Button searchBtn;

    private Button addBtn;
    private Button dropBtn;
    private Button deleteBtn;

    private Label codeLbl;
    private Label lastNameLbl;
    private Label firstNameLbl;
    private Label statusLbl;
    private Label phoneLbl;
    private Label emailLbl;
    private Label socialLbl;
    private Label registrationLbl;
    private Label addressLbl;
    private Label teachersLbl;
    private Label comNumLbl;
    private Label admissionLbl;
    private Label reasonLbl;

    private TextField codeFld;
    private TextField lastNameFld;
    private TextField firstNameFld;
    private ComboBox statusCmBox;
    private TextField phoneFld;
    private TextField emailFld;
    private TextArea socialArea;
    private TextField registrationFld;
    private TextArea addressArea;
    private ListView<CheckBox> teachersList;
    private TextField comNumFld;
    private TextField admissionFld;
    private TextArea reasonArea;
    private Button editBtn;
    private Button storeBtn;
    private Boolean button;

    ObservableList<StudentObj> data = FXCollections.observableArrayList();

    private String id;
    private String code;
    private String lastName;
    private String firstName;
    private int status;
    private String phone;
    private String email;
    private String social;
    private String registration;
    private String address;
    private String teachers = "";
    private String computer;
    private String admission;
    private String drop;
    private String reason;
    private String update = "";
    public static String pics = "";

    public Student() {
        studentPane = new Pane();
        TableRefresh();

        studentLbl = new Label("Оюутнууд");
        studentLbl.setPrefSize(150, 25);
        studentLbl.setFont(Font.font("Verdana", 20));
        studentLbl.setLayoutX(60);
        studentLbl.setLayoutY(40);

        tableView = new TableView();
        tableView.setPrefSize(370, 400);
        tableView.setLayoutX(60);
        tableView.setLayoutY(80);
        StudentData();
        tableView.setItems(data);

        ObservableList<String> types = FXCollections.observableArrayList(
                "Нийтээр нь хайх",
                "Кодоор",
                "Нэрээр",
                "Овгоор",
                "Утасны дугаараар",
                "Статусаар",
                "Цахим шуудангаар",
                "Цахим хаягаар",
                "Регистрээр",
                "Гэрийн хаягаар",
                "Компьютерийн №",
                "Хичээлээр",
                "Элсэлтээр"
        );
        searchByCmBox = new ComboBox<String>(types);
        searchByCmBox.setOnAction(ae -> {
            SearchFilter();
        });
        searchByCmBox.setValue("Нийтээр нь хайх");
        searchByCmBox.setPrefSize(170, 25);
        searchByCmBox.setLayoutX(60);
        searchByCmBox.setLayoutY(510);
        searchByCmBox.setId("iphone");

        searchFld = new TextField();
        searchFld.setPrefSize(140, 25);
        searchFld.setLayoutX(260);
        searchFld.setLayoutY(510);
        searchFld.setPromptText("Хайх үгээ оруул ....");
        searchFld.setId("info");
        searchFld.setOnKeyReleased(ae -> {
            SearchFilter();
        });

        Image searchImg = new Image("ManagerPac/search-icon.png");
        ImageView searchIcon = new ImageView();
        searchIcon.setImage(searchImg);
        searchIcon.setFitHeight(14);
        searchIcon.setFitWidth(14);

        searchBtn = new Button("", searchIcon);
        searchBtn.setPrefSize(25, 25);
        searchBtn.setLayoutX(400);
        searchBtn.setLayoutY(510);
        searchBtn.setId("search");

        addBtn = new Button("Оюутан нэмэх");
        addBtn.setOnAction(ae -> {
            Stage addStudentStage = new Stage();
            AddStudent addStudent = new AddStudent();
            addStudent.start(addStudentStage);
        });
        addBtn.setPrefSize(160, 30);
        addBtn.setLayoutX(60);
        addBtn.setLayoutY(565);
        addBtn.setFont(Font.font("Verdana", 15));
        addBtn.setId("iphone");

        dropBtn = new Button("");
        dropBtn.setPrefSize(160, 30);
        dropBtn.setLayoutX(270);
        dropBtn.setLayoutY(595);
        dropBtn.setFont(Font.font("Verdana", 15));
        dropBtn.setId("iphone");
        dropBtn.setOnAction(ae -> {

        });

        deleteBtn = new Button("Оюутан хасах");
        deleteBtn.setOnAction(ae -> {
            int delete = Integer.parseInt(((StudentObj) Launcher.getSTUDENT().tableView.getSelectionModel().getSelectedItem()).getId());
            System.out.println(delete + "-delete.");
            ServerConnection.Request("flagStudent", "" + delete + "::1");
            TableRefresh();
        });
        deleteBtn.setPrefSize(160, 30);
        deleteBtn.setLayoutX(270);
        deleteBtn.setLayoutY(565);
        deleteBtn.setFont(Font.font("Verdana", 15));
        deleteBtn.setId("iphone");

        studentInfoLbl = new Label("Оюутны мэдээлэл");
        studentInfoLbl.setPrefSize(200, 25);
        studentInfoLbl.setFont(Font.font("Verdana", 20));
        studentInfoLbl.setLayoutX(470);
        studentInfoLbl.setLayoutY(40);

        studentImage = new Image("ManagerPac/photo-not-available.png");
        studentView = new ImageView(studentImage);
        studentView.setFitHeight(90);
        studentView.setFitWidth(90);
        studentView.setLayoutX(470);
        studentView.setLayoutY(80);
        studentView.setId("image-view");

        browseLbl = new Label("Зураг оруулах");
        browseLbl.setFont(Font.font("Verdana", 10));
        browseLbl.setPrefSize(90, 25);
        browseLbl.setLayoutX(470);
        browseLbl.setLayoutY(170);
        browseLbl.setId("browseLbl");
        browseLbl.setVisible(false);
        browseLbl.setOnMouseClicked(ae -> {
            Stage stage = new Stage();
            UpdateStudentImage update = new UpdateStudentImage();
            update.start(stage);
        });

        studentCodeLbl = new Label("Код");
        studentCodeLbl.setFont(Font.font("Verdana", 14));
        studentCodeLbl.setLayoutX(570);
        studentCodeLbl.setLayoutY(85);

        Label dot = new Label(":");
        dot.setFont(Font.font("Verdana", 14));
        dot.setLayoutX(610);
        dot.setLayoutY(85);

        studentNameLbl = new Label("Нэр");
        studentNameLbl.setFont(Font.font("Verdana", 14));
        studentNameLbl.setLayoutX(570);
        studentNameLbl.setLayoutY(115);

        Label dot1 = new Label(":");
        dot1.setFont(Font.font("Verdana", 14));
        dot1.setLayoutX(610);
        dot1.setLayoutY(115);

        studentClassLbl = new Label("Анги");
        studentClassLbl.setFont(Font.font("Verdana", 14));
        studentClassLbl.setLayoutX(570);
        studentClassLbl.setLayoutY(145);

        Label dot2 = new Label(":");
        dot2.setFont(Font.font("Verdana", 14));
        dot2.setLayoutX(610);
        dot2.setLayoutY(145);

        pictureLbl = new Label("Зурагийн зам");
        pictureLbl.setLayoutX(780);
        pictureLbl.setLayoutY(90);
        pictureLbl.setId("info");
        pictureLbl.setVisible(false);

        codeLbl = new Label("Код");
        codeLbl.setFont(Font.font("Verdana", 14));
        codeLbl.setLayoutX(470);
        codeLbl.setLayoutY(210);

        CodeField();
        
        

        registrationLbl = new Label("Регистер");
        registrationLbl.setFont(Font.font("Verdana", 14));
        registrationLbl.setLayoutX(630);
        registrationLbl.setLayoutY(210);

        RegistrationField();

        comNumLbl = new Label("Компьютер №");
        comNumLbl.setFont(Font.font("Verdana", 14));
        comNumLbl.setLayoutX(790);
        comNumLbl.setLayoutY(210);

        ComputerField();

        lastNameLbl = new Label("Овог");
        lastNameLbl.setFont(Font.font("Verdana", 14));
        lastNameLbl.setLayoutX(470);
        lastNameLbl.setLayoutY(280);

        LastNameField();

        firstNameLbl = new Label("Нэр");
        firstNameLbl.setFont(Font.font("Verdana", 14));
        firstNameLbl.setLayoutX(630);
        firstNameLbl.setLayoutY(280);

        FirstNameField();

        statusLbl = new Label("Статус");
        statusLbl.setFont(Font.font("Verdana", 14));
        statusLbl.setLayoutX(790);
        statusLbl.setLayoutY(280);

        ObservableList<String> statusList = FXCollections.observableArrayList(
                "хүлээгдэж байгаа",
                "суралцаж байгаа"
        );
        statusCmBox = new ComboBox(statusList);
        statusCmBox.setValue("Статус сонгох");
        statusCmBox.setPrefSize(160, 25);
        statusCmBox.setLayoutX(790);
        statusCmBox.setLayoutY(310);
        statusCmBox.setId("iphone");
        statusCmBox.setEditable(false);

        emailLbl = new Label("Цахим шуудан");
        emailLbl.setFont(Font.font("Verdana", 14));
        emailLbl.setLayoutX(470);
        emailLbl.setLayoutY(350);

        emailFld = new TextField();
        emailFld.setId("info");
        emailFld.setPrefSize(150, 25);
        emailFld.setLayoutX(470);
        emailFld.setLayoutY(380);
        emailFld.setPromptText("E-Mail");
        emailFld.setEditable(false);

        phoneLbl = new Label("Утас");
        phoneLbl.setFont(Font.font("Verdana", 14));
        phoneLbl.setLayoutX(650);
        phoneLbl.setLayoutY(350);

        MobileField();

        admissionLbl = new Label("Элсэлт");
        admissionLbl.setFont(Font.font("Verdana", 14));
        admissionLbl.setLayoutX(790);
        admissionLbl.setLayoutY(350);

        AdmissionField();

        socialLbl = new Label("Цахим хаяг");
        socialLbl.setFont(Font.font("Verdana", 14));
        socialLbl.setLayoutX(470);
        socialLbl.setLayoutY(420);

        socialArea = new TextArea();
        socialArea.setId("info");
        socialArea.setPrefSize(150, 55);
        socialArea.setLayoutX(470);
        socialArea.setLayoutY(450);
        socialArea.setWrapText(true);
        socialArea.setPromptText("Social Address");
        socialArea.setEditable(false);

        addressLbl = new Label("Гэрийн хаяг");
        addressLbl.setFont(Font.font("Verdana", 14));
        addressLbl.setLayoutX(650);
        addressLbl.setLayoutY(420);

        addressArea = new TextArea();
        addressArea.setId("info");
        addressArea.setPrefSize(150, 55);
        addressArea.setLayoutX(650);
        addressArea.setLayoutY(450);
        addressArea.setWrapText(true);
        addressArea.setPromptText("Home Address");
        addressArea.setEditable(false);

        teachersLbl = new Label("Багш нар");
        teachersLbl.setFont(Font.font("Verdana", 14));
        teachersLbl.setLayoutX(830);
        teachersLbl.setLayoutY(420);

        ObservableList<HBox> items = FXCollections.observableArrayList();
        ArrayList<String> arrayData = (ArrayList<String>) ServerConnection.Request("getAllTeacherProfile", null);
        teachersList = new ListView(items);
        teachersList.setPrefSize(160, 165);
        teachersList.setLayoutX(830);
        teachersList.setLayoutY(450);
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

        reasonLbl = new Label("Шалтгаан");
        reasonLbl.setFont(Font.font("Verdana", 14));
        reasonLbl.setLayoutX(470);
        reasonLbl.setLayoutY(520);

        reasonArea = new TextArea();
        reasonArea.setId("info");
        reasonArea.setPrefSize(330, 65);
        reasonArea.setLayoutX(470);
        reasonArea.setLayoutY(550);
        reasonArea.setWrapText(true);
        reasonArea.setPromptText("Reason");
        reasonArea.setEditable(false);

        editBtn = new Button("Засах");
        editBtn.setPrefSize(100, 30);
        editBtn.setFont(Font.font("Verdana", 14));
        editBtn.setLayoutX(890);
        editBtn.setLayoutY(630);
        editBtn.setId("iphone");
        editBtn.setOnAction(ae -> {
            if (tableView.getSelectionModel().isEmpty()) {
                editBtn.setVisible(true);
                storeBtn.setVisible(false);
            } else {
                if (!button) {
                    browseLbl.setVisible(true);
                    editBtn.setVisible(false);
                    storeBtn.setVisible(true);
                    codeFld.setEditable(true);
                    firstNameFld.setEditable(true);
                    lastNameFld.setEditable(true);
                    phoneFld.setEditable(true);
                    emailFld.setEditable(true);
                    socialArea.setEditable(true);
                    registrationFld.setEditable(true);
                    addressArea.setEditable(true);
                    comNumFld.setEditable(true);
                    admissionFld.setEditable(true);
                    reasonArea.setEditable(true);
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
        storeBtn.setLayoutX(890);
        storeBtn.setLayoutY(630);
        storeBtn.setId("iphone");
        storeBtn.setFont(Font.font("Verdana", 14));
        storeBtn.setVisible(false);
        storeBtn.setOnAction(ae -> {
            StudentObj object = (StudentObj) tableView.getSelectionModel().getSelectedItem();
            System.out.println(update);
            GetStudentInfo();
            System.out.println(update);
            if (object.getPicture().equals(ServerConnection.Request("getStudentImage", "" + object.getId()))) {
                pics = ServerConnection.Request("getStudentImage", "" + object.getId()).toString();
                System.out.println(pics);
                ServerConnection.Request("updateStudent", "" + update + "");
                TableRefresh();
            } else {
                System.out.println(file.getName());
                pics = file.getName();
                System.out.println(pics);
                ServerConnection.Request("updateStudent", "" + update + "");
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
                TableRefresh();
            }

        });

        tableView.setOnMousePressed(ae -> {
            browseLbl.setVisible(false);
            editBtn.setVisible(true);
            storeBtn.setVisible(false);
            button = false;
            codeFld.setEditable(false);
            lastNameFld.setEditable(false);
            firstNameFld.setEditable(false);
            phoneFld.setEditable(false);
            emailFld.setEditable(false);
            socialArea.setEditable(false);
            registrationFld.setEditable(false);
            addressArea.setEditable(false);
            comNumFld.setEditable(false);
            admissionFld.setEditable(false);
            reasonArea.setEditable(false);

            if (tableView.getSelectionModel().getSelectedItem() != null) {
                StudentObj student = (StudentObj) tableView.getSelectionModel().getSelectedItem();
                dot.setText(": " + student.getCode());
                dot1.setText(": " + student.getFirstName());
                codeFld.setText(student.getCode());
                lastNameFld.setText(student.getLastName());
                firstNameFld.setText(student.getFirstName());
                statusCmBox.getSelectionModel().select(student.getStatus());
                phoneFld.setText(student.getPhone());
                emailFld.setText(student.getEmail());
                socialArea.setText(student.getSocial());
                registrationFld.setText(student.getRegistration());
                addressArea.setText(student.getAddress());
                comNumFld.setText(student.getComNum());
                admissionFld.setText(student.getAdmission());
                reasonArea.setText(student.getReason());

                ArrayList index = new ArrayList<>();
                for (String split : student.getTeachers().split(",")) {
                    index.add(split);
                }

                for (int i = 0; i < items.size(); i++) {
                    ((CheckBox) items.get(i).getChildren().get(1)).setSelected(false);
                }

                for (int j = 0; j < index.size(); j++) {
                    for (int a = 0; a < items.size(); a++) {
                        if (index.get(j).equals(((Label) items.get(a).getChildren().get(0)).getText())) {
                            ((CheckBox) items.get(a).getChildren().get(1)).setSelected(true);
                        }
                    }
                }

                Image img = new Image("file:///" + System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images" + "\\" + ServerConnection.Request("getStudentImage", student.getId()));
                studentView.setImage(img);
            }
        });

        studentPane.getChildren().addAll(
                tableView,
                studentView,
                browseLbl,
                studentLbl,
                studentInfoLbl,
                studentCodeLbl,
                dot,
                studentNameLbl,
                dot1,
                studentClassLbl,
                dot2,
                pictureLbl,
                searchByCmBox,
                searchFld,
                searchBtn,
                addBtn,
                deleteBtn,
                codeLbl,
                lastNameLbl,
                firstNameLbl,
                statusLbl,
                phoneLbl,
                emailLbl,
                socialLbl,
                registrationLbl,
                addressLbl,
                teachersLbl,
                comNumLbl,
                admissionLbl,
                reasonLbl,
                codeFld,
                registrationFld,
                comNumFld,
                lastNameFld,
                firstNameFld,
                statusCmBox,
                emailFld,
                phoneFld,
                admissionFld,
                socialArea,
                addressArea,
                teachersList,
                reasonArea,
                editBtn,
                storeBtn
        );
    }

    public void TableRefresh() {
        ArrayList<String> arrayData = (ArrayList<String>) ServerConnection.Request("getAllStudentProfile", null);
        data.clear();
        for (int i = 0; i < arrayData.size(); i++) {
            String str = (String) arrayData.get(i);
            System.out.println(str + " - printed.");
            ArrayList<String> cols = new ArrayList<>();
            for (String str1 : str.split("::")) {
                cols.add(str1);
            }

            if (cols.size() < 16) {
                for (int j = cols.size(); j < 16; j++) {
                    cols.add("");
                }
            }
            StudentObj studentObj = new StudentObj(
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
                    cols.get(13),
                    cols.get(14),
                    cols.get(15)
            );
            data.add(studentObj);
        }
    }

    /**
     * Adding table columns
     */
    public void StudentData() {
        TableColumn idCol = new TableColumn("Код");
        idCol.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("code"));
        idCol.setMaxWidth(70);
        idCol.setMinWidth(70);
        idCol.setId("column");

        TableColumn nameCol = new TableColumn("Нэр");
        nameCol.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("firstName"));
        nameCol.setMaxWidth(90);
        nameCol.setMinWidth(90);
        nameCol.setId("column");

        TableColumn classCol = new TableColumn("Анги");
        classCol.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("className"));
        classCol.setMaxWidth(108);
        classCol.setMinWidth(108);
        classCol.setId("column");

        TableColumn computerCol = new TableColumn("Компьютер №");
        computerCol.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("comNum"));
        computerCol.setMaxWidth(100);
        computerCol.setMinWidth(100);
        computerCol.setId("column");

        tableView.getColumns().addAll(idCol, nameCol, classCol, computerCol);
    }

    /**
     * User input validation
     */
    private void CodeField() {
        codeFld = new TextField();
        codeFld.setId("info");
        codeFld.setPrefSize(120, 25);
        codeFld.setLayoutX(470);
        codeFld.setLayoutY(240);
        codeFld.setPromptText("Student Code");
        codeFld.setEditable(false);
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
    private void FirstNameField() {
        firstNameFld = new TextField();
        firstNameFld.setId("info");
        firstNameFld.setPrefSize(120, 25);
        firstNameFld.setLayoutX(630);
        firstNameFld.setLayoutY(310);
        firstNameFld.setPromptText("First Name");
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
     * User input validation
     */
    private void LastNameField() {
        lastNameFld = new TextField();
        lastNameFld.setId("info");
        lastNameFld.setPrefSize(120, 25);
        lastNameFld.setLayoutX(470);
        lastNameFld.setLayoutY(310);
        lastNameFld.setPromptText("Last Name");
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
    private void ComputerField() {
        final int limit = 6;
        comNumFld = new TextField();
        comNumFld.setId("info");
        comNumFld.setPrefSize(120, 25);
        comNumFld.setLayoutX(790);
        comNumFld.setLayoutY(240);
        comNumFld.setPromptText("Computer ID");
        comNumFld.setEditable(false);
        comNumFld.setOnKeyTyped(ae -> {
            char c = new Character(ae.getCharacter().toCharArray()[0]);
            if (!(((c >= '0') && (c <= '9')) || ((c >= 'a') || (c >= 'A')) && ((c <= 'z') || (c <= 'Z')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });

        comNumFld.textProperty().addListener((Observable observable) -> {
            String value = ((StringProperty) observable).get();
            if (value.length() > limit) {
                comNumFld.textProperty().setValue(value.substring(0, limit));
            }
        });
    }

    /**
     * User input validation
     */
    private void RegistrationField() {
        final int limit = 10;
        registrationFld = new TextField();
        registrationFld.setId("info");
        registrationFld.setPrefSize(130, 25);
        registrationFld.setLayoutX(630);
        registrationFld.setLayoutY(240);
        registrationFld.setPromptText("Registration Number");
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
    public void MobileField() {
        final int limit = 12;
        phoneFld = new TextField();
        phoneFld.setId("info");
        phoneFld.setPrefSize(100, 25);
        phoneFld.setLayoutX(650);
        phoneFld.setLayoutY(380);
        phoneFld.setPromptText("Mobile Number");
        phoneFld.setEditable(false);
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
    private void AdmissionField() {
        final int limit = 4;
        admissionFld = new TextField();
        admissionFld.setId("info");
        admissionFld.setPrefSize(120, 25);
        admissionFld.setLayoutX(790);
        admissionFld.setLayoutY(380);
        admissionFld.setPromptText("Admission");
        admissionFld.setEditable(false);
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
    }

    /**
     * Search data from table view
     */
    void SearchFilter() {
        String cellValue = "";
        ObservableList<StudentObj> tableItem = FXCollections.observableArrayList();
        for (int i = 0; i < data.size(); i++) {
            StudentObj studentObj = data.get(i);
            switch (searchByCmBox.getSelectionModel().getSelectedIndex()) {
                case 0:
                    cellValue = studentObj.getId().toLowerCase() + studentObj.getFirstName().toLowerCase() + studentObj.getLastName().toLowerCase() + studentObj.getPhone().toLowerCase();
                    break;

                case 1:
                    cellValue = studentObj.getCode().toLowerCase();
                    break;

                case 2:
                    cellValue = studentObj.getFirstName().toLowerCase();
                    break;

                case 3:
                    cellValue = studentObj.getLastName().toLowerCase();
                    break;

                case 4:
                    cellValue = studentObj.getPhone().toLowerCase();
                    break;

                case 5:
                    cellValue = studentObj.getStatus().toLowerCase();
                    break;

                case 6:
                    cellValue = studentObj.getEmail().toLowerCase();
                    break;

                case 7:
                    cellValue = studentObj.getSocial().toLowerCase();
                    break;

                case 8:
                    cellValue = studentObj.getRegistration().toLowerCase();
                    break;

                case 9:
                    cellValue = studentObj.getAddress().toLowerCase();
                    break;

                case 10:
                    cellValue = studentObj.getComNum().toLowerCase();
                    break;

                case 11:

                    break;

                case 12:
                    cellValue = studentObj.getAdmission().toLowerCase();
                    break;

                default:
                    cellValue = studentObj.getId().toLowerCase() + studentObj.getFirstName().toLowerCase() + studentObj.getLastName().toLowerCase() + studentObj.getPhone().toLowerCase();
                    break;
            }

            if (cellValue.contains(searchFld.getText().toLowerCase())) {
                tableItem.add(studentObj);
            }

            tableView.setItems(tableItem);
        }
    }

    /**
     * Getting user input information
     */
    public void GetStudentInfo() {
        StudentObj object = (StudentObj) tableView.getSelectionModel().getSelectedItem();
        id = object.getId();
        code = codeFld.getText();
        lastName = lastNameFld.getText();
        firstName = firstNameFld.getText();
        status = statusCmBox.getSelectionModel().getSelectedIndex() + 2;
        phone = phoneFld.getText();
        email = emailFld.getText();
        social = socialArea.getText();
        registration = registrationFld.getText();
        address = addressArea.getText();
        computer = comNumFld.getText();
        admission = admissionFld.getText();
        drop = object.getDeleteFlag();
        reason = reasonArea.getText();
        update = id + "::" + code + "::" + lastName + "::" + firstName + "::" + status + "::" + phone + "::" + email + "::" + social + "::" + registration + "::" + address + "::" + teachers + "::" + computer + "::" + admission + "::" + drop + "::" + reason + "::" + UpdateStudentImage.displayNameLbl.getText();
    }
}
