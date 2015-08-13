package admin.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import login.ui.ServerConnection;

public class Zarlalt {

    private Label tseejZurag = new Label("Зураг");
    private Label userId = new Label("Хэрэглэгчийн дугаар:");
    private Label userIdTxt = new Label();
    private Label register = new Label("Регистер:");
    private Label registerText = new Label();
    private Label lastName = new Label("Овог:");
    private Label lastNameTxt = new Label();
    private Label name = new Label("Нэр:");
    private Label nameTxt = new Label();
    private Label status = new Label("Статус:");
    private Label statusTxt = new Label();
    private Label subject = new Label("Хичээл:");
    private Label subjectTxt = new Label();
    private Label phoneNumber = new Label("Утасны дугаар:");
    private Label phoneNumberTxt = new Label();
    private Label email = new Label("И-мэйл хаяг:");
    private Label emailTxt = new Label();
    private Label social = new Label("Сошиал:");
    private Label socialText = new Label();
    private Label address = new Label("Гэрийн хаяг:");
    private Label addressTxt = new Label();
    private Label classId = new Label("Анги:");
    private Label classTxt = new Label();
    private Label computerId = new Label("Компьютерийн дугаар:");
    private Label computerTxt = new Label();
    private Label username = new Label("Username:");
    private Label userText = new Label();
    private Label password = new Label("Password:");
    private Label passText = new Label();
    private Label deleteFlag = new Label("Delete Flag:");
    private Label deleteFlagText = new Label();

    private Button edit = new Button("Edit");
    private Button delete = new Button("Delete");

    public static VBox centerRightPart;
    private VBox centerRightPart1;

    private VBox imageBox;
    private Image propic;
    private ImageView imgview, imgview1, imgview2,imgview3, imgview4;
    private VBox btnBox;
    private GridPane adminContainer;
    private GridPane managerContainer;
    private GridPane teacherContainer;
    private GridPane studentContainer;

    HBox hbox = new HBox();

    public Zarlalt() {

        centerRightPart = new VBox();
        centerRightPart.setAlignment(Pos.CENTER);
        centerRightPart.setPrefSize(274, 600);
        centerRightPart.setStyle("-fx-background-color: #69BCE6");
        centerRightPart.setMinWidth(0);
        centerRightPart.setMinWidth(0);
        centerRightPart.setMaxWidth(330);

        centerRightPart1 = new VBox();
        centerRightPart1.setAlignment(Pos.CENTER);
        centerRightPart1.setPrefSize(274, 600);
        centerRightPart1.setStyle("-fx-background-color: #E6FFFF");
        centerRightPart1.setMinWidth(0);

        tseejZurag.setPrefSize(180, 150);
        tseejZurag.setPadding(new Insets(0, 0, 0, 0));
        tseejZurag.setLayoutX(50);
        tseejZurag.setStyle("-fx-border-color:red");
        tseejZurag.setAlignment(Pos.CENTER);

        propic = new Image("resource/images/2.png");
        imgview = new ImageView(propic);
        imgview.setVisible(true);
        imgview.setPreserveRatio(true);
        imgview.setFitWidth(200);


        btnBox = new VBox();
        btnBox.setAlignment(Pos.CENTER);
        btnBox.setPrefSize(270, 100);
        btnBox.setStyle("-fx-background-color:transparent;");

        adminContainer = new GridPane();
        adminContainer.setVgap(15);
        adminContainer.setHgap(10);
        adminContainer.setAlignment(Pos.CENTER);

        managerContainer = new GridPane();
        managerContainer.setVgap(15);
        managerContainer.setHgap(10);
        managerContainer.setAlignment(Pos.CENTER);

        teacherContainer = new GridPane();
        teacherContainer.setVgap(15);
        teacherContainer.setHgap(10);
        teacherContainer.setAlignment(Pos.CENTER);

        studentContainer = new GridPane();
        studentContainer.setVgap(15);
        studentContainer.setHgap(10);
        studentContainer.setAlignment(Pos.CENTER);

        edit.setPrefSize(100, 30);
        delete.setPrefSize(100, 30);
        edit.setId("btn");
        delete.setId("btn");
    }

    public VBox getAdminContainer() {

        adminContainer.getChildren().clear();
        adminContainer.getChildren().addAll(userId,
                userIdTxt,
                register,
                registerText,
                lastName,
                lastNameTxt,
                name,
                nameTxt,
                status,
                statusTxt,
                phoneNumber,
                phoneNumberTxt,
                email,
                emailTxt,
                social,
                socialText,
                address,
                addressTxt,
                username,
                userText,
                password,
                passText,
                deleteFlag,
                deleteFlagText,
                edit,
                delete);
        
        propic = new Image("resource/images/2.png");
        imgview1 = new ImageView(propic);
        imgview1.setVisible(true);
        imgview1.setPreserveRatio(true);
        imgview1.setFitWidth(150);
        imgview1.setFitHeight(150);
        
        imageBox = new VBox();
        imageBox.setAlignment(Pos.CENTER);
        imageBox.getChildren().add(imgview1);

        adminContainer.setConstraints(userId, 0, 0);
        adminContainer.setConstraints(userIdTxt, 1, 0);
        adminContainer.setConstraints(register, 0, 1);
        adminContainer.setConstraints(registerText, 1, 1);
        adminContainer.setConstraints(lastName, 0, 2);
        adminContainer.setConstraints(lastNameTxt, 1, 2);
        adminContainer.setConstraints(name, 0, 3);
        adminContainer.setConstraints(nameTxt, 1, 3);
        adminContainer.setConstraints(status, 0, 4);
        adminContainer.setConstraints(statusTxt, 1, 4);
        adminContainer.setConstraints(phoneNumber, 0, 5);
        adminContainer.setConstraints(phoneNumberTxt, 1, 5);
        adminContainer.setConstraints(email, 0, 6);
        adminContainer.setConstraints(emailTxt, 1, 6);
        adminContainer.setConstraints(social, 0, 7);
        adminContainer.setConstraints(socialText, 1, 7);
        adminContainer.setConstraints(address, 0, 8);
        adminContainer.setConstraints(addressTxt, 1, 8);
        adminContainer.setConstraints(username, 0, 9);
        adminContainer.setConstraints(userText, 1, 9);
        adminContainer.setConstraints(password, 0, 10);
        adminContainer.setConstraints(passText, 1, 10);
        adminContainer.setConstraints(deleteFlag, 0, 11);
        adminContainer.setConstraints(deleteFlagText, 1, 11);
        adminContainer.setConstraints(edit, 0, 12);
        adminContainer.setConstraints(delete, 1, 12);
        centerRightPart.getChildren().clear();
        centerRightPart.getChildren().addAll(imageBox, adminContainer, btnBox);

        if (Admin.table.getSelectionModel().getSelectedItem() != null) {
            AdminObj admint = (AdminObj) Admin.table.getSelectionModel().getSelectedItem();
            userIdTxt.setText(admint.getId());
            registerText.setText(admint.getRegister());
            lastNameTxt.setText(admint.getLastName());
            nameTxt.setText(admint.getFirstName());
            phoneNumberTxt.setText(admint.getPhoneNum());
            addressTxt.setText(admint.getAddress());
            emailTxt.setText(admint.getEmail());
            socialText.setText(admint.getSocial());
            statusTxt.setText(admint.getStatus());
            userText.setText(admint.getUsername());
            passText.setText(admint.getPassword());
            deleteFlagText.setText(admint.getDeleteFlag());
        } else {
            System.out.println("hooson baina");
        }
        Image img3 = new Image("file:///" + System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images" + "\\" + ServerConnection.RequestAjluulah("getAdminImage", ((AdminObj)Admin.table.getSelectionModel().getSelectedItem()).getId()));
        imgview1.setImage(img3);

        edit.setOnAction(ae -> {
            Stage editAdminStage = new Stage();
            try {
                new EditAdmin().start(editAdminStage, (AdminObj) Admin.table.getSelectionModel().getSelectedItem());
            } catch (Exception ex) {
                Logger.getLogger(Zarlalt.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        delete.setOnAction(ae -> {

            int Admin_id = Integer.parseInt(((AdminObj) Admin.table.getSelectionModel().getSelectedItem()).getId());
            System.out.println("id is" + Admin_id + "::1");
            System.out.println("Admin delete request -->" + ServerConnection.RequestAjluulah("flagAdmin", "" + Admin_id + "::1"));

            Admin.data.remove(Admin.rowIndex);

        });

        return this.centerRightPart;
    }

    public VBox getManagerContainer() {

        managerContainer.getChildren().clear();
        managerContainer.getChildren().addAll(
                userId,
                userIdTxt,
                register,
                registerText,
                lastName,
                lastNameTxt,
                name,
                nameTxt,
                status,
                statusTxt,
                phoneNumber,
                phoneNumberTxt,
                email,
                emailTxt,
                social,
                socialText,
                address,
                addressTxt,
                username,
                userText,
                password,
                passText,
                //                deleteFlag,
                //                deleteFlagText,
                edit,
                delete);
        
        propic = new Image("resource/images/2.png");
        imgview2 = new ImageView(propic);
        imgview2.setVisible(true);
        imgview2.setPreserveRatio(true);
        imgview2.setFitWidth(150);
        imgview2.setFitHeight(150);
        
        
        imageBox = new VBox();
        imageBox.setAlignment(Pos.CENTER);
        imageBox.getChildren().add(imgview2);

        managerContainer.setConstraints(userId, 0, 0);
        managerContainer.setConstraints(userIdTxt, 1, 0);
        managerContainer.setConstraints(register, 0, 1);
        managerContainer.setConstraints(registerText, 1, 1);
        managerContainer.setConstraints(lastName, 0, 2);
        managerContainer.setConstraints(lastNameTxt, 1, 2);
        managerContainer.setConstraints(name, 0, 3);
        managerContainer.setConstraints(nameTxt, 1, 3);
        managerContainer.setConstraints(status, 0, 4);
        managerContainer.setConstraints(statusTxt, 1, 4);
        managerContainer.setConstraints(phoneNumber, 0, 5);
        managerContainer.setConstraints(phoneNumberTxt, 1, 5);
        managerContainer.setConstraints(email, 0, 6);
        managerContainer.setConstraints(emailTxt, 1, 6);
        managerContainer.setConstraints(social, 0, 7);
        managerContainer.setConstraints(socialText, 1, 7);
        managerContainer.setConstraints(address, 0, 8);
        managerContainer.setConstraints(addressTxt, 1, 8);
        managerContainer.setConstraints(username, 0, 9);
        managerContainer.setConstraints(userText, 1, 9);
        managerContainer.setConstraints(password, 0, 10);
        managerContainer.setConstraints(passText, 1, 10);
//        managerContainer.setConstraints(deleteFlag, 0, 11);
//        managerContainer.setConstraints(deleteFlagText, 1, 11);

        managerContainer.setConstraints(edit, 0, 12);
        managerContainer.setConstraints(delete, 1, 12);
        centerRightPart.getChildren().clear();
        centerRightPart.getChildren().addAll(imageBox, managerContainer, btnBox);

        if (Manager.table.getSelectionModel().getSelectedItem() != null) {
            ManagerObj manager = (ManagerObj) Manager.table.getSelectionModel().getSelectedItem();
            userIdTxt.setText(manager.getId());
            registerText.setText(manager.getRegister());
            lastNameTxt.setText(manager.getLastName());
            nameTxt.setText(manager.getFirstName());
            phoneNumberTxt.setText(manager.getPhoneNum());
            addressTxt.setText(manager.getAddress());
            socialText.setText(manager.getSocial());
            emailTxt.setText(manager.getEmail());
            statusTxt.setText(manager.getStatus());
//            deleteFlagText.setText(manager.getDeleteFlag());
            userText.setText(manager.getUsername());
            passText.setText(manager.getPassword());

        } else {
            System.out.println("hooson baina");
        }
//        
        Image img2 = new Image("file:///" + System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images" + "\\" + ServerConnection.RequestAjluulah("getManagerImage", ((ManagerObj)Manager.table.getSelectionModel().getSelectedItem()).getId()));
        imgview2.setImage(img2);
        
        edit.setOnAction(ae -> {
            Stage editManagerStage = new Stage();
            try {
                new EditManager().start(editManagerStage, (ManagerObj) Manager.table.getSelectionModel().getSelectedItem());
            } catch (Exception ex) {
                Logger.getLogger(Zarlalt.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        delete.setOnAction(ae -> {

            int Manager_id = Integer.parseInt(((ManagerObj) Manager.table.getSelectionModel().getSelectedItem()).getId());
            System.out.println("reqyest -->" + ServerConnection.RequestAjluulah("flagManager", "" + Manager_id + "::1"));
            Manager.data.remove(Manager.rowIndex);
//            System.out.println(ServerConnection.RequestAjluulah("getAllManagerProfile" , null));
        });

        return this.centerRightPart;
    }

    public VBox getTeacherContainer() {

        adminContainer.getChildren().clear();
        adminContainer.getChildren().addAll(
                userId,
                userIdTxt,
                register,
                registerText,
                lastName,
                lastNameTxt,
                name,
                nameTxt,
                status,
                statusTxt,
                subject,
                subjectTxt,
                phoneNumber,
                phoneNumberTxt,
                email,
                emailTxt,
                social,
                socialText,
                address,
                addressTxt,
                username,
                userText,
                password,
                passText,
                deleteFlag,
                deleteFlagText,
                edit,
                delete);
        
        
        propic = new Image("resource/images/2.png");
        imgview3 = new ImageView(propic);
        imgview3.setVisible(true);
        imgview3.setPreserveRatio(true);
        imgview3.setFitWidth(150);
        imgview3.setFitHeight(150);
        
        imageBox = new VBox();
        imageBox.setAlignment(Pos.CENTER);
        imageBox.getChildren().add(imgview3);

        adminContainer.setConstraints(userId, 0, 0);
        adminContainer.setConstraints(userIdTxt, 1, 0);
        adminContainer.setConstraints(register, 0, 1);
        adminContainer.setConstraints(registerText, 1, 1);
        adminContainer.setConstraints(lastName, 0, 2);
        adminContainer.setConstraints(lastNameTxt, 1, 2);
        adminContainer.setConstraints(name, 0, 3);
        adminContainer.setConstraints(nameTxt, 1, 3);
        adminContainer.setConstraints(status, 0, 4);
        adminContainer.setConstraints(statusTxt, 1, 4);
        adminContainer.setConstraints(subject, 0, 5);
        adminContainer.setConstraints(subjectTxt, 1, 5);
        adminContainer.setConstraints(phoneNumber, 0, 6);
        adminContainer.setConstraints(phoneNumberTxt, 1, 6);
        adminContainer.setConstraints(email, 0, 7);
        adminContainer.setConstraints(emailTxt, 1, 7);
        adminContainer.setConstraints(social, 0, 8);
        adminContainer.setConstraints(socialText, 1, 8);
        adminContainer.setConstraints(address, 0, 9);
        adminContainer.setConstraints(addressTxt, 1, 9);
        adminContainer.setConstraints(username, 0, 10);
        adminContainer.setConstraints(userText, 1, 10);
        adminContainer.setConstraints(password, 0, 11);
        adminContainer.setConstraints(passText, 1, 11);
        adminContainer.setConstraints(deleteFlag, 0, 12);
        adminContainer.setConstraints(deleteFlagText, 1, 12);
        adminContainer.setConstraints(edit, 0, 13);
        adminContainer.setConstraints(delete, 1, 13);
        centerRightPart.getChildren().clear();
        centerRightPart.getChildren().addAll(imgview3, adminContainer, btnBox);

        if (Teacher.table.getSelectionModel().getSelectedItem() != null) {
            TeacherObj teacher = (TeacherObj) Teacher.table.getSelectionModel().getSelectedItem();
            userIdTxt.setText(teacher.getId());
            registerText.setText(teacher.getRegister());
            lastNameTxt.setText(teacher.getLastName());
            nameTxt.setText(teacher.getFirstName());
            subjectTxt.setText(teacher.getSubject());
            phoneNumberTxt.setText(teacher.getPhoneNum());
            addressTxt.setText(teacher.getAddress());
            socialText.setText(teacher.getSocial());
            emailTxt.setText(teacher.getEmail());
            statusTxt.setText(teacher.getStatus());
            deleteFlagText.setText(teacher.getDeleteFlag());
            userText.setText(teacher.getUsername());
            passText.setText(teacher.getPassword());
        }

        edit.setOnAction(ae -> {
            Stage editTeacherStage = new Stage();
            try {
                new EditTeacher().start(editTeacherStage, (TeacherObj) Teacher.table.getSelectionModel().getSelectedItem());
            } catch (Exception ex) {
                Logger.getLogger(Zarlalt.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        delete.setOnAction(ae -> {

            int Teacher_id = Integer.parseInt(((TeacherObj) Teacher.table.getSelectionModel().getSelectedItem()).getId());

            System.out.println("reqyest -->" + ServerConnection.RequestAjluulah("flagTeacher", "" + Teacher_id + "::1"));

            Teacher.data.remove(Teacher.rowIndex);

        });
        
        String olsonImgName = ServerConnection.RequestAjluulah("getTeacherImage", ((TeacherObj)Teacher.table.getSelectionModel().getSelectedItem()).getId()).toString();
        System.out.println(olsonImgName);
        Image img1 = new Image("file:///" + System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images\\" + olsonImgName);
        imgview3.setImage(img1);
        
        return this.centerRightPart;
    }

    public VBox getStudentContainer() {
        centerRightPart.setPrefWidth(360);
        adminContainer.getChildren().clear();
        adminContainer.getChildren().addAll(userId, userIdTxt, lastName, lastNameTxt, name, nameTxt,
        phoneNumber, phoneNumberTxt, address, addressTxt, email, emailTxt, status, statusTxt, classId, classTxt, computerId, computerTxt, edit, delete);
        
        propic = new Image("resource/images/2.png");
        imgview4 = new ImageView(propic);
        imgview4.setVisible(true);
        imgview4.setPreserveRatio(true);
        imgview4.setFitWidth(150);
        imgview4.setFitHeight(150);
        
        imageBox = new VBox();
        imageBox.setAlignment(Pos.CENTER);
        imageBox.getChildren().add(imgview4);

        adminContainer.setConstraints(userId, 0, 0);
        adminContainer.setConstraints(userIdTxt, 1, 0);
        adminContainer.setConstraints(lastName, 0, 1);
        adminContainer.setConstraints(lastNameTxt, 1, 1);
        adminContainer.setConstraints(name, 0, 2);
        adminContainer.setConstraints(nameTxt, 1, 2);
        adminContainer.setConstraints(phoneNumber, 0, 3);
        adminContainer.setConstraints(phoneNumberTxt, 1, 3);
        adminContainer.setConstraints(address, 0, 4);
        adminContainer.setConstraints(addressTxt, 1, 4);
        adminContainer.setConstraints(email, 0, 5);
        adminContainer.setConstraints(emailTxt, 1, 5);
        adminContainer.setConstraints(status, 0, 6);
        adminContainer.setConstraints(statusTxt, 1, 6);
        adminContainer.setConstraints(classId, 0, 7);
        adminContainer.setConstraints(classTxt, 1, 7);
        adminContainer.setConstraints(computerId, 0, 8);
        adminContainer.setConstraints(computerTxt, 1, 8);
        adminContainer.setConstraints(edit, 0, 9);
        adminContainer.setConstraints(delete, 1, 9);
        centerRightPart.getChildren().clear();
        centerRightPart.getChildren().addAll(imageBox, adminContainer, btnBox);

        if (Student.table.getSelectionModel().getSelectedItem() != null) {
            StudentObj student = (StudentObj) Student.table.getSelectionModel().getSelectedItem();
            userIdTxt.setText(student.getId());
            lastNameTxt.setText(student.getLastname());
            nameTxt.setText(student.getFirstname());
            phoneNumberTxt.setText(student.getPhonenum());
            addressTxt.setText(student.getAddress());
            emailTxt.setText(student.getEmail());
//            classTxt.setText(student.getClassname());
            computerTxt.setText(student.getComnum());
            statusTxt.setText(student.getStatus());
        }
        Image img = new Image("file:///" + System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images" + "\\" + ServerConnection.RequestAjluulah("getStudentImage", ((StudentObj)Student.table.getSelectionModel().getSelectedItem()).getId()));
        imgview4.setImage(img);

        edit.setOnAction(ae -> {
            Stage editStudentStage = new Stage();
            try {
                new EditStudent().start(editStudentStage, (StudentObj) Student.table.getSelectionModel().getSelectedItem());
            } catch (Exception ex) {
                Logger.getLogger(Zarlalt.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        delete.setOnAction(ae -> {
            int Student_id = Integer.parseInt(((StudentObj) Student.table.getSelectionModel().getSelectedItem()).getId());
            System.out.println("reqyest -->" + ServerConnection.RequestAjluulah("flagStudent", ""+Student_id+"::1"));
            Student.data.remove(Student.rowIndex);
        });

        return this.centerRightPart;
    }

    public VBox getImageContainer() {
        return this.imageBox;
    }
}
