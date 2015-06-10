package ManagerPac;

import java.util.ArrayList;
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
    private Label joinDateLbl;
    
    private Label idLbl;
    private Label lastNameLbl;
    private Label firstNameLbl;
    private Label mobileLbl;
    private Label emailLbl;
    private Label addressLbl;
    private Label classIdLbl;
    private Label classNameLbl;
    private Label joinedLbl;
    
    private TextField idFld;
    private TextField lastNameFld;
    private TextField firstNameFld;
    private TextField mobileFld;
    private TextField emailFld;
    private TextField addressFld;
    private TextField classIdFld;
    private TextField classNameFld;
    private TextField joinedFld;
    
    private Button editIdBtn;
    private Button editLastBtn;
    private Button editFirstBtn;
    private Button editMobiBtn;
    private Button editEmailBtn;
    private Button editAddressBtn;
    private Button editClassIdBtn;
    private Button editClassBtn;
    private Button editJoinBtn;
    private Button searchBtn;
    private Button addBtn;
    private Button deleteBtn;
    
    ObservableList<StudentObj> data=FXCollections.observableArrayList();
    
    public Student() {
        studentPane=new Pane();
        
        ArrayList<Object> arrayData=new ArrayList<>();
        ObservableList<String> responseData = FXCollections.observableArrayList();
        
        responseData.add("stu01::sLastName::sFirst::88998899::stu1@gmail.com::stu1 address::java::lesID1::com1::stu1join");
        responseData.add("stu02::2LastName::2First::88998899::stu2@gmail.com::stu2 address::c#::lesID2::com2::stu2join");
        arrayData.addAll(responseData);
        
        for(int i=0; i<arrayData.size(); i++){
            String str=(String) arrayData.get(i);
            String[] cols = str.split("::");
            StudentObj studentObj=new StudentObj(cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], cols[6], cols[7], cols[8], cols[9]);
            data.add(studentObj);
        }
        
        studentLbl=new Label("Оюутнууд");
        studentLbl.setPrefSize(150, 25);
        studentLbl.setFont(Font.font("Verdana", 20));
        studentLbl.setLayoutX(30);
        studentLbl.setLayoutY(40);
        
        studentInfoLbl=new Label("Оюутны мэдээлэл");
        studentInfoLbl.setPrefSize(200, 25);
        studentInfoLbl.setFont(Font.font("Verdana", 20));
        studentInfoLbl.setLayoutX(420);
        studentInfoLbl.setLayoutY(40);
        
        tableView=new TableView();
        tableView.setPrefSize(330, 500);
        tableView.setLayoutX(30);
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
        searchByCmBox.setLayoutX(30);
        searchByCmBox.setLayoutY(610);
        
        searchFld=new TextField();
        searchFld.setPrefSize(130, 25);
        searchFld.setLayoutX(200);
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
        searchBtn.setLayoutX(330);
        searchBtn.setLayoutY(610);
        
        pictureLbl=new Label("Pic");
        pictureLbl.setPrefSize(80, 90);
        pictureLbl.setStyle("-fx-border-color:black");
        pictureLbl.setLayoutX(420);
        pictureLbl.setLayoutY(80);
        
        nameLbl=new Label("Нэр");
        nameLbl.setFont(Font.font("Verdana", 14));
        nameLbl.setPrefSize(50, 25);
        nameLbl.setLayoutX(520);
        nameLbl.setLayoutY(80);
        
        classLbl=new Label("Анги");
        classLbl.setFont(Font.font("Verdana", 14));
        classLbl.setPrefSize(50, 25);
        classLbl.setLayoutX(520);
        classLbl.setLayoutY(110);
        
        joinDateLbl=new Label("Элссэн огноо");
        joinDateLbl.setFont(Font.font("Verdana", 14));
        joinDateLbl.setPrefSize(120, 25);
        joinDateLbl.setLayoutX(520);
        joinDateLbl.setLayoutY(140);
        
        idLbl=new Label("Код");
        idLbl.setFont(Font.font("Verdana", 14));
        idLbl.setPrefSize(150, 25);
        idLbl.setLayoutX(420);
        idLbl.setLayoutY(210);
        
        lastNameLbl=new Label("Овог");
        lastNameLbl.setFont(Font.font("Verdana", 14));
        lastNameLbl.setPrefSize(150, 25);
        lastNameLbl.setLayoutX(420);
        lastNameLbl.setLayoutY(260);
        
        firstNameLbl=new Label("Нэр");
        firstNameLbl.setFont(Font.font("Verdana", 14));
        firstNameLbl.setPrefSize(150, 25);
        firstNameLbl.setLayoutX(420);
        firstNameLbl.setLayoutY(310);
        
        mobileLbl=new Label("Утасны дугаар");
        mobileLbl.setFont(Font.font("Verdana", 14));
        mobileLbl.setPrefSize(150, 25);
        mobileLbl.setLayoutX(420);
        mobileLbl.setLayoutY(360);
        
        emailLbl=new Label("И-мэйл хаяг");
        emailLbl.setFont(Font.font("Verdana", 14));
        emailLbl.setPrefSize(150, 25);
        emailLbl.setLayoutX(420);
        emailLbl.setLayoutY(410);
        
        addressLbl=new Label("Гэрийн хаяг");
        addressLbl.setFont(Font.font("Verdana", 14));
        addressLbl.setPrefSize(150, 25);
        addressLbl.setLayoutX(420);
        addressLbl.setLayoutY(460);
        
        classIdLbl=new Label("Ангийн код");
        classIdLbl.setFont(Font.font("Verdana", 14));
        classIdLbl.setPrefSize(150, 25);
        classIdLbl.setLayoutX(420);
        classIdLbl.setLayoutY(510);
        
        classNameLbl=new Label("Анги");
        classNameLbl.setFont(Font.font("Verdana", 14));
        classNameLbl.setPrefSize(150, 25);
        classNameLbl.setLayoutX(420);
        classNameLbl.setLayoutY(560);
        
        joinedLbl=new Label("Элссэн огноо");
        joinedLbl.setFont(Font.font("Verdana", 14));
        joinedLbl.setPrefSize(150, 25);
        joinedLbl.setLayoutX(420);
        joinedLbl.setLayoutY(610);
        
        idFld=new TextField();
        idFld.setId("info");
        idFld.setPrefSize(300, 25);
        idFld.setLayoutX(580);
        idFld.setLayoutY(210);
        
        lastNameFld=new TextField();
        lastNameFld.setId("info");
        lastNameFld.setPrefSize(300, 25);
        lastNameFld.setLayoutX(580);
        lastNameFld.setLayoutY(260);
        
        firstNameFld=new TextField();
        firstNameFld.setId("info");
        firstNameFld.setPrefSize(300, 25);
        firstNameFld.setLayoutX(580);
        firstNameFld.setLayoutY(310);
        
        mobileFld=new TextField();
        mobileFld.setId("info");
        mobileFld.setPrefSize(300, 25);
        mobileFld.setLayoutX(580);
        mobileFld.setLayoutY(360);
        
        emailFld=new TextField();
        emailFld.setId("info");
        emailFld.setPrefSize(300, 25);
        emailFld.setLayoutX(580);
        emailFld.setLayoutY(410);
        
        addressFld=new TextField();
        addressFld.setId("info");
        addressFld.setPrefSize(300, 25);
        addressFld.setLayoutX(580);
        addressFld.setLayoutY(460);
        
        classIdFld=new TextField();
        classIdFld.setId("info");
        classIdFld.setPrefSize(300, 25);
        classIdFld.setLayoutX(580);
        classIdFld.setLayoutY(510);
        
        classNameFld=new TextField();
        classNameFld.setId("info");
        classNameFld.setPrefSize(300, 25);
        classNameFld.setLayoutX(580);
        classNameFld.setLayoutY(560);
        
        joinedFld=new TextField();
        joinedFld.setId("info");
        joinedFld.setPrefSize(300, 25);
        joinedFld.setLayoutX(580);
        joinedFld.setLayoutY(610);
        
        editIdBtn=new Button("Засах");
        editIdBtn.setFont(Font.font("Verdana", 14));
        editIdBtn.setPrefSize(80, 25);
        editIdBtn.setLayoutX(890);
        editIdBtn.setLayoutY(208);
        
        editLastBtn=new Button("Засах");
        editLastBtn.setFont(Font.font("Verdana", 14));
        editLastBtn.setPrefSize(80, 25);
        editLastBtn.setLayoutX(890);
        editLastBtn.setLayoutY(258);
        
        editFirstBtn=new Button("Засах");
        editFirstBtn.setFont(Font.font("Verdana", 14));
        editFirstBtn.setPrefSize(80, 25);
        editFirstBtn.setLayoutX(890);
        editFirstBtn.setLayoutY(308);
        
        editMobiBtn=new Button("Засах");
        editMobiBtn.setFont(Font.font("Verdana", 14));
        editMobiBtn.setPrefSize(80, 25);
        editMobiBtn.setLayoutX(890);
        editMobiBtn.setLayoutY(358);
        
        editEmailBtn=new Button("Засах");
        editEmailBtn.setFont(Font.font("Verdana", 14));
        editEmailBtn.setPrefSize(80, 25);
        editEmailBtn.setLayoutX(890);
        editEmailBtn.setLayoutY(408);
        
        editAddressBtn=new Button("Засах");
        editAddressBtn.setFont(Font.font("Verdana", 14));
        editAddressBtn.setPrefSize(80, 25);
        editAddressBtn.setLayoutX(890);
        editAddressBtn.setLayoutY(458);
        
        editClassIdBtn=new Button("Засах");
        editClassIdBtn.setFont(Font.font("Verdana", 14));
        editClassIdBtn.setPrefSize(80, 25);
        editClassIdBtn.setLayoutX(890);
        editClassIdBtn.setLayoutY(508);
        
        editClassBtn=new Button("Засах");
        editClassBtn.setFont(Font.font("Verdana", 14));
        editClassBtn.setPrefSize(80, 25);
        editClassBtn.setLayoutX(890);
        editClassBtn.setLayoutY(558);
        
        editJoinBtn=new Button("Засах");
        editJoinBtn.setFont(Font.font("Verdana", 14));
        editJoinBtn.setPrefSize(80, 25);
        editJoinBtn.setLayoutX(890);
        editJoinBtn.setLayoutY(608);
        
        addBtn=new Button("Оюутан нэмэх");
        addBtn.setOnAction(ae-> {
            Stage addStudentStage=new Stage();
            AddStudent addStudent=new AddStudent();
            addStudent.start(addStudentStage);
        });
        addBtn.setPrefSize(150, 30);
        addBtn.setLayoutX(30);
        addBtn.setLayoutY(650);
        
        deleteBtn=new Button("Оюутан хасах");
        deleteBtn.setOnAction(ae-> {
            int answer=JOptionPane.showConfirmDialog(null, "Хасах уу?");
            if(answer==JOptionPane.YES_OPTION) {
                String select=((StudentObj) tableView.getSelectionModel().getSelectedItem()).getId();
                
                tableView.getSelectionModel().clearSelection();
                
            }
        });
        deleteBtn.setPrefSize(150, 30);
        deleteBtn.setLayoutX(210);
        deleteBtn.setLayoutY(650);
        
        tableView.setOnMousePressed(ae -> {
            if (tableView.getSelectionModel().getSelectedItem() != null) {
                StudentObj student = (StudentObj) tableView.getSelectionModel().getSelectedItem();
                idFld.setText(student.getId());
                lastNameFld.setText(student.getLastName());
                firstNameFld.setText(student.getFirstName());
                mobileFld.setText(student.getMobile());
                emailFld.setText(student.getEmail());
                addressFld.setText(student.getAddress());
                classIdFld.setText(student.getClassId());
                classNameFld.setText(student.getClassName());
                joinedFld.setText(student.getJoined());
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
                joinDateLbl,
                idLbl,
                lastNameLbl,
                firstNameLbl,
                mobileLbl,
                emailLbl,
                addressLbl,
                classIdLbl,
                classNameLbl,
                joinedLbl,
                idFld,
                lastNameFld,
                firstNameFld,
                mobileFld,
                emailFld,
                addressFld,
                classIdFld,
                classNameFld,
                joinedFld,
                editIdBtn,
                editLastBtn,
                editFirstBtn,
                editMobiBtn,
                editEmailBtn,
                editAddressBtn,
                editClassIdBtn,
                editClassBtn,
                editJoinBtn,
                addBtn,
                deleteBtn
        );
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
        computerCol.setCellValueFactory(new PropertyValueFactory<StudentObj, String>("computer"));
        computerCol.setMaxWidth(100);
        computerCol.setMinWidth(100);
        computerCol.setId("column");
        
        tableView.getColumns().addAll(idCol, nameCol, classCol, computerCol);
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
                    cellValue=studentObj.getMobile().toLowerCase();
                    break;

                case "Ангиар":
                    cellValue=studentObj.getClassName().toLowerCase();
                    break;
                    
                default:
                    cellValue=studentObj.getId().toLowerCase()+studentObj.getFirstName().toLowerCase()+studentObj.getLastName().toLowerCase()+studentObj.getMobile().toLowerCase()+studentObj.getClassName().toLowerCase();
            }
            
            if(cellValue.contains(searchFld.getText().toLowerCase())) {
                tableItem.add(studentObj);
            }
            
            tableView.setItems(tableItem);
        }
    }
}
