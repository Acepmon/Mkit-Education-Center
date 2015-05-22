package admin.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Zarlalt {
    
    private Label tseejZurag = new Label("Зураг");
    private Label userId = new Label("Хэрэглэгчийн дугаар:");
    private Label userIdTxt = new Label("..............");
    private Label lastName = new Label("Овог:");
    private Label lastNameTxt = new Label("..............");
    private Label name = new Label("Нэр:");
    private Label nameTxt = new Label("..............");
    private Label phoneNumber = new Label("Утасны дугаар:");
    private Label phoneNumberTxt = new Label("..............");
    private Label address = new Label("Гэрийн хаяг:");
    private Label addressTxt = new Label("..............");
    private Label email = new Label("И-мэйл хаяг:");
    private Label emailTxt = new Label("..............");
    private Label status = new Label("Статус:");
    private Label statusTxt = new Label("..............");
    private Label degree = new Label("Зэрэг, цол:");
    private Label degreeTxt = new Label("..............");
    private Label classId = new Label("Анги:");
    private Label classTxt = new Label("..............");
    private Label computerId = new Label("Компьютерийн дугаар:");
    private Label computerTxt = new Label("..............");
    private Button edit = new Button("Edit");
    private Button delete = new Button("Delete");
    
    public static VBox centerRightPart;
    private VBox centerRightPart1;
    
    private VBox imageBox;
    private VBox btnBox;
    private GridPane adminContainer;
    private GridPane managerContainer;
    private GridPane teacherContainer;
    private GridPane studentContainer;
    
    Button add;

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
        
        imageBox = new VBox();
        imageBox.setAlignment(Pos.CENTER);
        imageBox.getChildren().addAll(tseejZurag);
        
        btnBox = new VBox();
        btnBox.setAlignment(Pos.CENTER);
        
        add = new Button();
        add.setAlignment(Pos.CENTER);
        add.setPrefSize(250, 40);
        btnBox.setPrefSize(270, 100);
        btnBox.setStyle("-fx-background-color:transparent;");
        btnBox.getChildren().add(add);
        
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
        add.setId("btn");
    }
   
    public VBox getAdminContainer() {
        
        adminContainer.getChildren().clear();
        adminContainer.getChildren().addAll(userId, userIdTxt, lastName, lastNameTxt, name, nameTxt,
        phoneNumber, phoneNumberTxt, address, addressTxt, email, emailTxt, status, statusTxt, classId, classTxt, computerId, computerTxt,edit,delete);
        
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
        add.setText("Check This Admin Permission");
        centerRightPart.getChildren().clear();
        centerRightPart.getChildren().addAll(imageBox,adminContainer,btnBox);
        return this.centerRightPart;
    }
    public VBox getManagerContainer() {
        
        managerContainer.getChildren().clear();
        managerContainer.getChildren().addAll(userId, userIdTxt, lastName, lastNameTxt, name, nameTxt,
        phoneNumber, phoneNumberTxt, address, addressTxt, email, emailTxt, status, statusTxt,edit,delete);
        
        managerContainer.setConstraints(userId, 0, 0);
        managerContainer.setConstraints(userIdTxt, 1, 0);
        managerContainer.setConstraints(lastName, 0, 1);
        managerContainer.setConstraints(lastNameTxt, 1, 1);
        managerContainer.setConstraints(name, 0, 2);
        managerContainer.setConstraints(nameTxt, 1, 2);
        managerContainer.setConstraints(phoneNumber, 0, 3);
        managerContainer.setConstraints(phoneNumberTxt, 1, 3);
        managerContainer.setConstraints(address, 0, 4);
        managerContainer.setConstraints(addressTxt, 1, 4);
        managerContainer.setConstraints(email, 0, 5);
        managerContainer.setConstraints(emailTxt, 1, 5);
        managerContainer.setConstraints(status, 0, 6);
        managerContainer.setConstraints(statusTxt, 1, 6);
        managerContainer.setConstraints(edit, 0, 7);
        managerContainer.setConstraints(delete, 1, 7);
        add.setText("Check This Manager Permission");
        centerRightPart.getChildren().clear();
        centerRightPart.getChildren().addAll(imageBox,managerContainer,btnBox);
        return this.centerRightPart;
    }
    public VBox getTeacherContainer() {
        
        adminContainer.getChildren().clear();
        adminContainer.getChildren().addAll(userId, userIdTxt, lastName, lastNameTxt, name, nameTxt,
        phoneNumber, phoneNumberTxt, address, addressTxt, email, emailTxt, status, statusTxt, classId, classTxt,edit,delete);
        
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
        adminContainer.setConstraints(edit, 0, 8);
        adminContainer.setConstraints(delete, 1, 8);
        add.setText("Check This Teacher Permission");
        add.setPadding(new Insets(15, 15, 15, 15));
        centerRightPart.getChildren().clear();
        centerRightPart.getChildren().addAll(imageBox,adminContainer,btnBox);
        return this.centerRightPart;
    }
    public VBox getStudentContainer() {
        centerRightPart.setPrefWidth(360);
        adminContainer.getChildren().clear();
        adminContainer.getChildren().addAll(userId, userIdTxt, lastName, lastNameTxt, name, nameTxt,
        phoneNumber, phoneNumberTxt, address, addressTxt, email, emailTxt, status, statusTxt, classId, classTxt, computerId, computerTxt,edit,delete);
        
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
        add.setText("Check This Student Permission");
        centerRightPart.getChildren().clear();
        centerRightPart.getChildren().addAll(imageBox,adminContainer,btnBox);
        return this.centerRightPart;
    }
     public VBox getImageContainer()
    {
        return this.imageBox;
    }
}
