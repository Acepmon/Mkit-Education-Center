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
import javafx.scene.layout.GridPane;
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
    
    private ObservableList<TeacherObj> data=FXCollections.observableArrayList();
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
    
    private Label idInfoLbl;
    private Label lastInfoLbl;
    private Label firstInfoLbl;
    private Label mobileInfoLbl;
    private Label emailInfoLbl;
    private Label addressInfoLbl;
    private Label classIdInfoLbl;
    private Label classInfoLbl;
    private Label joinedInfoLbl;
    
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
        teacherInfoLbl.setLayoutX(400);
        teacherInfoLbl.setLayoutY(40);
        
        tableView=new TableView();
        tableView.setPrefSize(310, 400);
        tableView.setLayoutX(30);
        tableView.setLayoutY(80);
        TeacherData();
        
        ObservableList<String> types=FXCollections.observableArrayList(
                "Нийтээр нь хайх",
                "Кодоор", 
                "Нэрээр", 
                "Овгоор", 
                "Утасны дугаараар",
                "Ангиар"
        );
        searchByCmBox=new ComboBox<String> (types);
        searchByCmBox.setValue("Нийтээр нь хайх");
        searchByCmBox.setPrefSize(140, 25);
        searchByCmBox.setLayoutX(30);
        searchByCmBox.setLayoutY(500);
        
        searchFld=new TextField();
        searchFld.setPrefSize(130, 25);
        searchFld.setLayoutX(180);
        searchFld.setLayoutY(500);
        searchFld.setPromptText("Хайх үгээ оруул ..");
        
        Image searchImg=new Image("ManagerPac/search-icon.png");
        ImageView searchIcon=new ImageView();
        searchIcon.setImage(searchImg);
        searchIcon.setFitHeight(14);
        searchIcon.setFitWidth(14);
        
        searchBtn=new Button("", searchIcon);
        searchBtn.setPrefSize(25, 25);
        searchBtn.setLayoutX(310);
        searchBtn.setLayoutY(500);
        
        pictureLbl=new Label("Pic");
        pictureLbl.setPrefSize(80, 90);
        pictureLbl.setStyle("-fx-border-color:black");
        pictureLbl.setLayoutX(400);
        pictureLbl.setLayoutY(80);
        
        nameLbl=new Label("Нэр");
        nameLbl.setFont(Font.font("Verdana", 14));
        nameLbl.setPrefSize(50, 25);
        nameLbl.setLayoutX(500);
        nameLbl.setLayoutY(80);
        
        classLbl=new Label("Анги");
        classLbl.setFont(Font.font("Verdana", 14));
        classLbl.setPrefSize(50, 25);
        classLbl.setLayoutX(500);
        classLbl.setLayoutY(110);
        
        joinDateLbl=new Label("Элссэн огноо");
        joinDateLbl.setFont(Font.font("Verdana", 14));
        joinDateLbl.setPrefSize(120, 25);
        joinDateLbl.setLayoutX(500);
        joinDateLbl.setLayoutY(140);
        
        idLbl=new Label("Код");
        idLbl.setFont(Font.font("Verdana", 14));
        idLbl.setPrefSize(150, 25);
        idLbl.setLayoutX(400);
        idLbl.setLayoutY(180);
        
        idInfoLbl=new Label("Description");
        idInfoLbl.setId("info");
        idInfoLbl.setFont(Font.font("Verdana", 14));
        idInfoLbl.setPrefSize(300, 25);
        idInfoLbl.setLayoutX(560);
        idInfoLbl.setLayoutY(180);
        
        lastNameLbl=new Label("Овог");
        lastNameLbl.setFont(Font.font("Verdana", 14));
        lastNameLbl.setPrefSize(150, 25);
        lastNameLbl.setLayoutX(400);
        lastNameLbl.setLayoutY(220);
        
        lastInfoLbl=new Label("Description");
        lastInfoLbl.setId("info");
        lastInfoLbl.setFont(Font.font("Verdana", 14));
        lastInfoLbl.setPrefSize(300, 25);
        lastInfoLbl.setLayoutX(560);
        lastInfoLbl.setLayoutY(220);
        
        firstNameLbl=new Label("Нэр");
        firstNameLbl.setFont(Font.font("Verdana", 14));
        firstNameLbl.setPrefSize(150, 25);
        firstNameLbl.setLayoutX(400);
        firstNameLbl.setLayoutY(260);
        
        firstInfoLbl=new Label("Description");
        firstInfoLbl.setId("info");
        firstInfoLbl.setFont(Font.font("Verdana", 14));
        firstInfoLbl.setPrefSize(300, 25);
        firstInfoLbl.setLayoutX(560);
        firstInfoLbl.setLayoutY(260);
        
        mobileLbl=new Label("Утасны дугаар");
        mobileLbl.setFont(Font.font("Verdana", 14));
        mobileLbl.setPrefSize(150, 25);
        mobileLbl.setLayoutX(400);
        mobileLbl.setLayoutY(300);
        
        mobileInfoLbl=new Label("Description");
        mobileInfoLbl.setId("info");
        mobileInfoLbl.setFont(Font.font("Verdana", 14));
        mobileInfoLbl.setPrefSize(300, 25);
        mobileInfoLbl.setLayoutX(560);
        mobileInfoLbl.setLayoutY(300);
        
        emailLbl=new Label("И-мэйл хаяг");
        emailLbl.setFont(Font.font("Verdana", 14));
        emailLbl.setPrefSize(150, 25);
        emailLbl.setLayoutX(400);
        emailLbl.setLayoutY(340);
        
        emailInfoLbl=new Label("Description");
        emailInfoLbl.setId("info");
        emailInfoLbl.setFont(Font.font("Verdana", 14));
        emailInfoLbl.setPrefSize(300, 25);
        emailInfoLbl.setLayoutX(560);
        emailInfoLbl.setLayoutY(340);
        
        addressLbl=new Label("Гэрийн хаяг");
        addressLbl.setFont(Font.font("Verdana", 14));
        addressLbl.setPrefSize(150, 25);
        addressLbl.setLayoutX(400);
        addressLbl.setLayoutY(380);
        
        addressInfoLbl=new Label("Description");
        addressInfoLbl.setId("info");
        addressInfoLbl.setFont(Font.font("Verdana", 14));
        addressInfoLbl.setPrefSize(300, 25);
        addressInfoLbl.setLayoutX(560);
        addressInfoLbl.setLayoutY(380);
        
        classIdLbl=new Label("Ангийн код");
        classIdLbl.setFont(Font.font("Verdana", 14));
        classIdLbl.setPrefSize(150, 25);
        classIdLbl.setLayoutX(400);
        classIdLbl.setLayoutY(420);
        
        classIdInfoLbl=new Label("Description");
        classIdInfoLbl.setId("info");
        classIdInfoLbl.setFont(Font.font("Verdana", 14));
        classIdInfoLbl.setPrefSize(300, 25);
        classIdInfoLbl.setLayoutX(560);
        classIdInfoLbl.setLayoutY(420);
        
        classNameLbl=new Label("Анги");
        classNameLbl.setFont(Font.font("Verdana", 14));
        classNameLbl.setPrefSize(150, 25);
        classNameLbl.setLayoutX(400);
        classNameLbl.setLayoutY(460);
        
        classInfoLbl=new Label("Description");
        classInfoLbl.setId("info");
        classInfoLbl.setFont(Font.font("Verdana", 14));
        classInfoLbl.setPrefSize(300, 25);
        classInfoLbl.setLayoutX(560);
        classInfoLbl.setLayoutY(460);
        
        joinedLbl=new Label("Элссэн огноо");
        joinedLbl.setFont(Font.font("Verdana", 14));
        joinedLbl.setPrefSize(150, 25);
        joinedLbl.setLayoutX(400);
        joinedLbl.setLayoutY(500);
        
        joinedInfoLbl=new Label("Description");
        joinedInfoLbl.setId("info");
        joinedInfoLbl.setFont(Font.font("Verdana", 14));
        joinedInfoLbl.setPrefSize(300, 25);
        joinedInfoLbl.setLayoutX(560);
        joinedInfoLbl.setLayoutY(500);
        
        editIdBtn=new Button("Засах");
        editIdBtn.setFont(Font.font("Verdana", 14));
        editIdBtn.setPrefSize(80, 25);
        editIdBtn.setLayoutX(870);
        editIdBtn.setLayoutY(178);
        
        editLastBtn=new Button("Засах");
        editLastBtn.setFont(Font.font("Verdana", 14));
        editLastBtn.setPrefSize(80, 25);
        editLastBtn.setLayoutX(870);
        editLastBtn.setLayoutY(218);
        
        editFirstBtn=new Button("Засах");
        editFirstBtn.setFont(Font.font("Verdana", 14));
        editFirstBtn.setPrefSize(80, 25);
        editFirstBtn.setLayoutX(870);
        editFirstBtn.setLayoutY(258);
        
        editMobiBtn=new Button("Засах");
        editMobiBtn.setFont(Font.font("Verdana", 14));
        editMobiBtn.setPrefSize(80, 25);
        editMobiBtn.setLayoutX(870);
        editMobiBtn.setLayoutY(298);
        
        editEmailBtn=new Button("Засах");
        editEmailBtn.setFont(Font.font("Verdana", 14));
        editEmailBtn.setPrefSize(80, 25);
        editEmailBtn.setLayoutX(870);
        editEmailBtn.setLayoutY(338);
        
        editAddressBtn=new Button("Засах");
        editAddressBtn.setFont(Font.font("Verdana", 14));
        editAddressBtn.setPrefSize(80, 25);
        editAddressBtn.setLayoutX(870);
        editAddressBtn.setLayoutY(378);
        
        editClassIdBtn=new Button("Засах");
        editClassIdBtn.setFont(Font.font("Verdana", 14));
        editClassIdBtn.setPrefSize(80, 25);
        editClassIdBtn.setLayoutX(870);
        editClassIdBtn.setLayoutY(418);
        
        editClassBtn=new Button("Засах");
        editClassBtn.setFont(Font.font("Verdana", 14));
        editClassBtn.setPrefSize(80, 25);
        editClassBtn.setLayoutX(870);
        editClassBtn.setLayoutY(458);
        
        editJoinBtn=new Button("Засах");
        editJoinBtn.setFont(Font.font("Verdana", 14));
        editJoinBtn.setPrefSize(80, 25);
        editJoinBtn.setLayoutX(870);
        editJoinBtn.setLayoutY(498);
        
        
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
                idInfoLbl,
                lastNameLbl,
                lastInfoLbl,
                firstNameLbl,
                firstInfoLbl,
                mobileLbl,
                mobileInfoLbl,
                emailLbl,
                emailInfoLbl,
                addressLbl,
                addressInfoLbl,
                classIdLbl,
                classIdInfoLbl,
                classNameLbl,
                classInfoLbl,
                joinedLbl,
                joinedInfoLbl,
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
    
    public void TeacherData() {
        TableColumn idCol=new TableColumn("Код");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setMaxWidth(50);
        idCol.setMinWidth(50);
        
        TableColumn nameCol=new TableColumn("Нэр");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        nameCol.setMaxWidth(90);
        nameCol.setMinWidth(90);
        
        TableColumn classCol=new TableColumn("Анги");
        classCol.setCellValueFactory(new PropertyValueFactory<>("className"));
        classCol.setMaxWidth(70);
        classCol.setMinWidth(70);
        
        TableColumn mobileCol=new TableColumn("Утасны дугаар");
        mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        mobileCol.setMaxWidth(100);
        mobileCol.setMinWidth(100);
        
        tableView.getColumns().addAll(idCol, nameCol, classCol, mobileCol);
        tableView.setItems(data);
        
    }
}
