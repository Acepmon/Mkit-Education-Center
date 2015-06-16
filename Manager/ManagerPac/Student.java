package ManagerPac;

import Controller.ClientTest;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Student {
    private Pane studentPane;

    public Pane getStudentPane() {
        return studentPane;
    }

    public void setStudentPane(Pane studentPane) {
        this.studentPane = studentPane;
    }
    
    private TableView tableView;
    private Label studentLbl;
    private Label studentInfoLbl;
    private ComboBox<String> searchByCmBox;
    private TextField searchFld;
    private Label pictureLbl;
    private Label nameLbl;
    private Label classLbl;
    
    private Label idLbl;
    private Label lastNameLbl;
    private Label firstNameLbl;
    private Label mobileLbl;
    private Label emailLbl;
    private Label addressLbl;
    private Label statusLbl;
    private Label classNameLbl;
    
    private TextField idFld;
    private TextField lastNameFld;
    private TextField firstNameFld;
    private TextField mobileFld;
    private TextField emailFld;
    private TextField addressFld;
    
    
    
    private ComboBox classCmBox;
    
    private ComboBox statusCmBox;
    
    private Button editBtn;
    private Button searchBtn;
    private Button addBtn;
    private Button deleteBtn;
    
    private String id;
    private String idOld;
    private String lastName;
    private String firstName;
    private String mobile;
    private String email;
    private String address;
    private int classId;
    private int status;
    private String comNumber;
    private String update="";
    
    private TextField pictureFld;
    private Button browseBtn;
    
    FileChooser fileChooser;
    File file;
    
    ObservableList<StudentObj> data=FXCollections.observableArrayList();
    
    public Student() {
        studentPane=new Pane();
        
        TableRefresh();
        
        studentLbl=new Label("Оюутнууд");
        studentLbl.setPrefSize(150, 25);
        studentLbl.setFont(Font.font("Verdana", 20));
        studentLbl.setLayoutX(60);
        studentLbl.setLayoutY(40);
        
        tableView=new TableView();
        tableView.setPrefSize(330, 500);
        tableView.setLayoutX(60);
        tableView.setLayoutY(80);
        StudentData();
        tableView.setItems(data);
        
        ObservableList<String> types=FXCollections.observableArrayList(
                "Нийтээр нь хайх",
                "Кодоор", 
                "Нэрээр", 
                "Овгоор", 
                "Утасны дугаараар",
                "Ангиар"
        );
        searchByCmBox=new ComboBox<String> (types);
        searchByCmBox.setOnAction(ae-> {
            searchFilter();
        });
        searchByCmBox.setValue("Нийтээр нь хайх");
        searchByCmBox.setPrefSize(140, 25);
        searchByCmBox.setLayoutX(60);
        searchByCmBox.setLayoutY(610);
        
        searchFld=new TextField();
        searchFld.setPrefSize(130, 25);
        searchFld.setLayoutX(230);
        searchFld.setLayoutY(610);
        searchFld.setPromptText("Хайх үгээ оруул ..");
        searchFld.setOnKeyReleased(ae-> {
            searchFilter();
        });
        
        Image searchImg=new Image("ManagerPac/search-icon.png");
        ImageView searchIcon=new ImageView();
        searchIcon.setImage(searchImg);
        searchIcon.setFitHeight(14);
        searchIcon.setFitWidth(14);
        
        searchBtn=new Button("", searchIcon);
        searchBtn.setPrefSize(25, 25);
        searchBtn.setLayoutX(360);
        searchBtn.setLayoutY(610);
        
        studentInfoLbl=new Label("Оюутны мэдээлэл");
        studentInfoLbl.setPrefSize(200, 25);
        studentInfoLbl.setFont(Font.font("Verdana", 20));
        studentInfoLbl.setLayoutX(470);
        studentInfoLbl.setLayoutY(40);
        
        pictureLbl=new Label("Pic");
        pictureLbl.setPrefSize(80, 90);
        pictureLbl.setStyle("-fx-border-color:black");
        pictureLbl.setLayoutX(470);
        pictureLbl.setLayoutY(80);
        
        nameLbl=new Label("Нэр");
        nameLbl.setFont(Font.font("Verdana", 14));
        nameLbl.setPrefSize(150, 25);
        nameLbl.setLayoutX(570);
        nameLbl.setLayoutY(80);
        
        classLbl=new Label("Анги");
        classLbl.setFont(Font.font("Verdana", 14));
        classLbl.setPrefSize(150, 25);
        classLbl.setLayoutX(570);
        classLbl.setLayoutY(110);
        
        pictureFld=new TextField();
        pictureFld.setPrefSize(150, 25);
        pictureFld.setLayoutX(780);
        pictureFld.setLayoutY(90);
        pictureFld.setPromptText("Зурагийн нэр");
        
        browseBtn=new Button("Зураг оруулах");
        browseBtn.setFont(Font.font("Verdana", 14));
        browseBtn.setPrefSize(150, 30);
        browseBtn.setLayoutX(780);
        browseBtn.setLayoutY(140);
        browseBtn.setOnAction(ae-> {
            fileChooser=new FileChooser();
            FileChooser.ExtensionFilter allFilter=new FileChooser.ExtensionFilter("All files", "*.*");
            fileChooser.getExtensionFilters().addAll(allFilter);
            file=fileChooser.showOpenDialog(null);
            pictureFld.setText("" + file.getName());
        });
        
        idLbl=new Label("Код");
        idLbl.setFont(Font.font("Verdana", 14));
        idLbl.setPrefSize(150, 25);
        idLbl.setLayoutX(470);
        idLbl.setLayoutY(210);
        
        lastNameLbl=new Label("Овог");
        lastNameLbl.setFont(Font.font("Verdana", 14));
        lastNameLbl.setPrefSize(150, 25);
        lastNameLbl.setLayoutX(470);
        lastNameLbl.setLayoutY(260);
        
        firstNameLbl=new Label("Нэр");
        firstNameLbl.setFont(Font.font("Verdana", 14));
        firstNameLbl.setPrefSize(150, 25);
        firstNameLbl.setLayoutX(470);
        firstNameLbl.setLayoutY(310);
        
        mobileLbl=new Label("Утасны дугаар");
        mobileLbl.setFont(Font.font("Verdana", 14));
        mobileLbl.setPrefSize(150, 25);
        mobileLbl.setLayoutX(470);
        mobileLbl.setLayoutY(360);
        
        emailLbl=new Label("И-мэйл хаяг");
        emailLbl.setFont(Font.font("Verdana", 14));
        emailLbl.setPrefSize(150, 25);
        emailLbl.setLayoutX(470);
        emailLbl.setLayoutY(410);
        
        addressLbl=new Label("Гэрийн хаяг");
        addressLbl.setFont(Font.font("Verdana", 14));
        addressLbl.setPrefSize(150, 25);
        addressLbl.setLayoutX(470);
        addressLbl.setLayoutY(460);
        
        statusLbl=new Label("Статус");
        statusLbl.setFont(Font.font("Verdana", 14));
        statusLbl.setPrefSize(150, 25);
        statusLbl.setLayoutX(470);
        statusLbl.setLayoutY(560);
        
        classNameLbl=new Label("Анги");
        classNameLbl.setFont(Font.font("Verdana", 14));
        classNameLbl.setPrefSize(150, 25);
        classNameLbl.setLayoutX(470);
        classNameLbl.setLayoutY(510);
        
        idFld=new TextField();
        idFld.setId("info");
        idFld.setPrefSize(300, 25);
        idFld.setLayoutX(630);
        idFld.setLayoutY(210);
        idFld.setPromptText("Суралцагчийн код");
        idFld.setEditable(false);
        
        lastNameFld=new TextField();
        lastNameFld.setId("info");
        lastNameFld.setPrefSize(300, 25);
        lastNameFld.setLayoutX(630);
        lastNameFld.setLayoutY(260);
        lastNameFld.setPromptText("Эцэг эсвэл эхийн нэр");
        lastNameFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            String sag=lastNameFld.getText();
            if(!(((c >= 'a')||(c >= 'A')) && ((c <= 'z')||(c <= 'Z')) || ((c>='а') || (c>='А')) && ((c<='я') || (c<='Я')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        firstNameFld=new TextField();
        firstNameFld.setId("info");
        firstNameFld.setPrefSize(300, 25);
        firstNameFld.setLayoutX(630);
        firstNameFld.setLayoutY(310);
        firstNameFld.setPromptText("Суралцагчийн нэр");
        firstNameFld.setOnKeyTyped(ae-> {
            char c=new Character(ae.getCharacter().toCharArray()[0]);
            String sag=firstNameFld.getText();
            if(!(((c >= 'a')||(c >= 'A')) && ((c <= 'z')||(c <= 'Z')) || ((c>='а') || (c>='А')) && ((c<='я') || (c<='Я')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                ae.consume();
            }
        });
        
        mobileFld=new TextField();
        MobileField();
        
        emailFld=new TextField();
        emailFld.setId("info");
        emailFld.setPrefSize(300, 25);
        emailFld.setLayoutX(630);
        emailFld.setLayoutY(410);
        emailFld.setPromptText("Электрон шуудангийн хаяг");
        
        addressFld=new TextField();
        addressFld.setId("info");
        addressFld.setPrefSize(300, 25);
        addressFld.setLayoutX(630);
        addressFld.setLayoutY(460);
        addressFld.setPromptText("Одоо байрлаж буй хаяг");
        
        ObservableList<String> stat=FXCollections.observableArrayList(
                "Суралцаж байгаа", 
                "Төгссөн", 
                "Хүлээгдэж байгаа", 
                "Ажиллаж байгаа", 
                "Ажиллахаа больсон"
        );
        statusCmBox=new ComboBox<String>(stat);
        statusCmBox.setValue("Статус сонгох");
        statusCmBox.getSelectionModel().selectFirst();
        statusCmBox.setPrefSize(170, 25);
        statusCmBox.setLayoutX(630);
        statusCmBox.setLayoutY(560);
        
        ObservableList<String> classes=FXCollections.observableArrayList(
                "Java",
                "C#",
                "Үндсэн хэрэглээ"
        );
        classCmBox=new ComboBox<String>(classes);
        classCmBox.setValue("Анги сонгох");
        classCmBox.getSelectionModel().selectFirst();
        classCmBox.setPrefSize(120, 25);
        classCmBox.setLayoutX(630);
        classCmBox.setLayoutY(510);
        
        editBtn=new Button("Засах");
        editBtn.setPrefSize(100, 20);
        editBtn.setLayoutX(830);
        editBtn.setLayoutY(560);
        editBtn.setOnAction(ae-> {
            int answer=JOptionPane.showConfirmDialog(null, "Засах уу?");
            
            if(answer==JOptionPane.YES_OPTION) {
                getStudentInfo();
                ClientTest.RequestAjluulah("updateStudent", ""+update+"");
                TableRefresh();
            }
        });
        
        addBtn=new Button("Оюутан нэмэх");
        addBtn.setOnAction(ae-> {
            Stage addStudentStage=new Stage();
            AddStudent addStudent=new AddStudent();
            addStudent.start(addStudentStage);
        });
        addBtn.setPrefSize(150, 30);
        addBtn.setLayoutX(60);
        addBtn.setLayoutY(650);
        
        deleteBtn=new Button("Оюутан хасах");
        deleteBtn.setOnAction(ae-> {
            int answer=JOptionPane.showConfirmDialog(null, "Хасах уу?");
            if(answer==JOptionPane.YES_OPTION) {
                
                int delete=Integer.parseInt(((StudentObj) Launcher.getSTUDENT().tableView.getSelectionModel().getSelectedItem()).getId());
                
                ClientTest.RequestAjluulah("deleteFromStudent", delete);
                TableRefresh();
            }
        });
        deleteBtn.setPrefSize(150, 30);
        deleteBtn.setLayoutX(240);
        deleteBtn.setLayoutY(650);
        
        tableView.setOnMousePressed(ae -> {
            if (tableView.getSelectionModel().getSelectedItem() != null) {
                StudentObj student=(StudentObj) tableView.getSelectionModel().getSelectedItem();
                nameLbl.setText(student.getFirstName());
                classLbl.setText(student.getClassName());
                idFld.setText(student.getId());
                idOld=student.getId();
                lastNameFld.setText(student.getLastName());
                firstNameFld.setText(student.getFirstName());
                mobileFld.setText(student.getPhoneNum());
                emailFld.setText(student.getEmail());
                addressFld.setText(student.getAddress());
                statusCmBox.setValue(student.getStatus());
                classCmBox.setValue(student.getClassName());
                comNumber=student.getComNum();
            }
        });
        
        studentPane.getChildren().addAll(
                studentLbl, 
                studentInfoLbl,
                tableView, 
                searchByCmBox, 
                searchFld, 
                searchBtn,
                pictureLbl, 
                nameLbl, 
                classLbl,
                pictureFld,
                browseBtn,
                idLbl,
                lastNameLbl,
                firstNameLbl,
                mobileLbl,
                emailLbl,
                addressLbl,
                statusLbl,
                classNameLbl,
                idFld,
                lastNameFld,
                firstNameFld,
                mobileFld,
                emailFld,
                addressFld,
                statusCmBox,
                classCmBox,
                editBtn,
                addBtn,
                deleteBtn
        );
    }
    
    public void TableRefresh() {
        ArrayList<Object> arrayData=(ArrayList<Object>) ClientTest.RequestAjluulah("adminGetAllStudents", null);
        data.clear();
        
        for(int i=0; i<arrayData.size(); i++){
            String str=(String) arrayData.get(i);
            String[] cols=str.split("::");
            StudentObj studentObj=new StudentObj(cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], cols[7], cols[6], cols[8], cols[9]);
            data.add(studentObj);
        }
    }
    
    public void StudentData() {
        TableColumn idCol=new TableColumn("Код");
        idCol.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("id"));
        idCol.setMaxWidth(70);
        idCol.setMinWidth(70);
        idCol.setId("column");
        
        TableColumn nameCol=new TableColumn("Нэр");
        nameCol.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("firstName"));
        nameCol.setMaxWidth(90);
        nameCol.setMinWidth(90);
        
        TableColumn classCol=new TableColumn("Анги");
        classCol.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("className"));
        classCol.setMaxWidth(68);
        classCol.setMinWidth(68);
        classCol.setId("column");
        
        TableColumn computerCol=new TableColumn("Компьютер №");
        computerCol.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("comNum"));
        computerCol.setMaxWidth(100);
        computerCol.setMinWidth(100);
        computerCol.setId("column");
        
        tableView.getColumns().addAll(idCol, nameCol, classCol, computerCol);
    }
    
    private void MobileField() {
        final int limit=8;
        mobileFld.setId("info");
        mobileFld.setPrefSize(300, 25);
        mobileFld.setLayoutX(630);
        mobileFld.setLayoutY(360);
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
    }
    
    void searchFilter() {
        String cellValue="";
        ObservableList<StudentObj> tableItem=FXCollections.observableArrayList();
        for(int i=0; i<data.size(); i++) {
            StudentObj studentObj=data.get(i);
            switch(searchByCmBox.getValue()) {
                case "Кодоор":
                    cellValue=studentObj.getId().toLowerCase();
                    break;

                case "Нэрээр":
                    cellValue=studentObj.getFirstName().toLowerCase();
                    break;

                case "Овогоор":
                    cellValue=studentObj.getLastName().toLowerCase();
                    break;

                case "Утасны дугаараар":
                    cellValue=studentObj.getPhoneNum().toLowerCase();
                    break;

                case "Ангиар":
                    cellValue=studentObj.getClassName().toLowerCase();
                    break;
                    
                default:
                    cellValue=studentObj.getId().toLowerCase()+studentObj.getFirstName().toLowerCase()+studentObj.getLastName().toLowerCase()+studentObj.getPhoneNum().toLowerCase()+studentObj.getClassName().toLowerCase();
                    break;
            }
            
            if(cellValue.contains(searchFld.getText().toLowerCase())) {
                tableItem.add(studentObj);
            }
            
            tableView.setItems(tableItem);
        }
    }

    public void getStudentInfo() {
        id=idFld.getText();
        lastName=lastNameFld.getText();
        firstName=firstNameFld.getText();
        mobile=mobileFld.getText();
        email=emailFld.getText();
        address=addressFld.getText();
        classId=classCmBox.getSelectionModel().getSelectedIndex()+1;
        status=statusCmBox.getSelectionModel().getSelectedIndex()+1;
        update=id+"::"+lastName+"::"+firstName+"::"+mobile+"::"+address+"::"+email+"::"+comNumber+"::"+classId+"::"+status+"::"+"picture1.png"+"::"+idOld;
    }
}
