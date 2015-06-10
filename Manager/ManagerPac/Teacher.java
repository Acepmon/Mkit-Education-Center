package ManagerPac;

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

public class Teacher {
    private Pane teacherPane;

    public Pane getTeacherPane() {
        return teacherPane;
    }

    public void setTeacherPane(Pane teacherPane) {
        this.teacherPane = teacherPane;
    }
    
    private TableView tableView;
    private Label teacherLbl;
    private Label teacherInfoLbl;
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
    
    private ObservableList<TeacherObj> data;
    
    public Teacher() {
        teacherPane=new Pane();
        
        teacherLbl=new Label("Багш нар");
        teacherLbl.setPrefSize(150, 25);
        teacherLbl.setFont(Font.font("Verdana", 20));
        teacherLbl.setLayoutX(30);
        teacherLbl.setLayoutY(40);
        
        teacherInfoLbl=new Label("Багшийн мэдээлэл");
        teacherInfoLbl.setPrefSize(200, 25);
        teacherInfoLbl.setFont(Font.font("Verdana", 20));
        teacherInfoLbl.setLayoutX(420);
        teacherInfoLbl.setLayoutY(40);
        
        tableView=new TableView();
        tableView.setPrefSize(330, 500);
        tableView.setLayoutX(30);
        tableView.setLayoutY(80);
        
        data = FXCollections.observableArrayList();
        
        ObservableList<String> responseData = FXCollections.observableArrayList();
        responseData.add("teach01::Surgagch::teachSur::12345678::fds@gmail.com::naranaas iregch::class01::java::2015-04-01");
        responseData.add("teaasdch01::Surgadaagch::teaadachSur::12345678::fds@gadadmail.com::naranaaadas ireadagch::clasadas01::jaadava::201ada5-04-01");
        for (String str : responseData) {
            String[] cols = str.split("::");
            TeacherObj teach01 = new TeacherObj(cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], cols[6], cols[7], cols[8]);
            data.add(teach01);
        }
        
        TableColumn idCol=new TableColumn("Код");
        idCol.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("id"));
        idCol.setMaxWidth(70);
        idCol.setMinWidth(70);
        idCol.setId("column");
        
        TableColumn nameCol=new TableColumn("Нэр");
        nameCol.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("name"));
        nameCol.setMaxWidth(90);
        nameCol.setMinWidth(90);
        
        TableColumn classCol=new TableColumn("Анги");
        classCol.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("className"));
        classCol.setMaxWidth(68);
        classCol.setMinWidth(68);
        classCol.setId("column");
        
        TableColumn mobileCol=new TableColumn("Утасны дугаар");
        mobileCol.setCellValueFactory(new PropertyValueFactory<TeacherObj, String>("phone"));
        mobileCol.setMaxWidth(100);
        mobileCol.setMinWidth(100);
        mobileCol.setId("column");
        
        tableView.getColumns().addAll(idCol, nameCol, classCol, mobileCol);
        
        tableView.setItems(data);
        
        ObservableList<String> types=FXCollections.observableArrayList(
                "Нийтээр нь хайх",
                "Кодоор", 
                "Нэрээр", 
                "Овогоор", 
                "Утасны дугаараар",
                "Ангиар"
        );
        searchByCmBox=new ComboBox<String> (types);
        searchByCmBox.setValue("Нийтээр нь хайх");
        searchByCmBox.setPrefSize(140, 25);
        searchByCmBox.setLayoutX(30);
        searchByCmBox.setLayoutY(610);
        
        searchFld=new TextField();
        searchFld.setPrefSize(130, 25);
        searchFld.setLayoutX(200);
        searchFld.setLayoutY(610);
        searchFld.setPromptText("Хайх үгээ оруул ....");
        
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
        editIdBtn.setOnAction(ae-> {
            
        });
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
        
        tableView.setOnMousePressed(ae -> {
            if (tableView.getSelectionModel().getSelectedItem() != null) {
                TeacherObj teacher = (TeacherObj) tableView.getSelectionModel().getSelectedItem();
                idFld.setText(teacher.getId());
                lastNameFld.setText(teacher.getSurname());
                firstNameFld.setText(teacher.getName());
                mobileFld.setText(teacher.getPhone());
                emailFld.setText(teacher.getEmail());
                addressFld.setText(teacher.getAddress());
                classIdFld.setText(teacher.getClassID());
                classNameFld.setText(teacher.getClassID());
                joinedFld.setText(teacher.getJoinedDate());
            }
        });
        
        teacherPane.getChildren().addAll(
                teacherLbl, 
                teacherInfoLbl,
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
                editJoinBtn
        );
    }
}
