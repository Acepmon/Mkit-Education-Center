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
import javax.swing.JOptionPane;

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
    
    private Button searchBtn;
    private Button editBtn;
    
    private TextField pictureFld;
    private Button browseBtn;
    
    FileChooser fileChooser;
    File file;
    
    private String id;
    private String idOld;
    private String lastName;
    private String firstName;
    private String mobile;
    private String email;
    private String address;
    private int classId;
    private int status;
    private String update="";
    
    private ObservableList<TeacherObj> data=FXCollections.observableArrayList();
    
    public Teacher() {
        teacherPane=new Pane();
        
        TableRefresh();
        
        teacherLbl=new Label("Багш нар");
        teacherLbl.setPrefSize(150, 25);
        teacherLbl.setFont(Font.font("Verdana", 20));
        teacherLbl.setLayoutX(60);
        teacherLbl.setLayoutY(40);
        
        tableView=new TableView();
        tableView.setPrefSize(330, 500);
        tableView.setLayoutX(60);
        tableView.setLayoutY(80);
        TeacherDate();
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
        searchFld.setPromptText("Хайх үгээ оруул ....");
        searchFld.setOnKeyReleased(ae-> {
            searchFilter();
        });
        
        Image searchImg=new Image("ManagerPac/search-icon.png");
        ImageView searchIcon=new ImageView();
        searchIcon.setImage(searchImg);
        searchIcon.setFitHeight(14);
        searchIcon.setFitWidth(14);
        
        searchBtn=new Button("", searchIcon);
        searchBtn.setOnAction(ae-> {
        });
        searchBtn.setPrefSize(25, 25);
        searchBtn.setLayoutX(360);
        searchBtn.setLayoutY(610);
        
        teacherInfoLbl=new Label("Багшийн мэдээлэл");
        teacherInfoLbl.setPrefSize(200, 25);
        teacherInfoLbl.setFont(Font.font("Verdana", 20));
        teacherInfoLbl.setLayoutX(470);
        teacherInfoLbl.setLayoutY(40);
        
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
            pictureFld.setText(""+file.getName());
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
        idFld.setPromptText("Багшийн код");
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
        firstNameFld.setPromptText("Багшийн нэр");
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
        
        ObservableList<String> stat=FXCollections.observableArrayList("Суралцаж байгаа", "Төгссөн", "Хүлээгдэж байгаа", "Ажиллаж байгаа", "Ажиллахаа больсон");
        statusCmBox=new ComboBox<String>(stat);
        statusCmBox.setValue("Статус сонгох");
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
        classCmBox.setPrefSize(120, 25);
        classCmBox.setLayoutX(630);
        classCmBox.setLayoutY(510);
        
        editBtn = new Button("Засах");
        editBtn.setPrefSize(100, 20);
        editBtn.setLayoutX(830);
        editBtn.setLayoutY(560);
        editBtn.setOnAction(ae-> {
            int answer=JOptionPane.showConfirmDialog(null, "Засах уу?");
            
            if(answer==JOptionPane.YES_OPTION) {
                getTeacherInfo();
                ClientTest.RequestAjluulah("updateTeacher", ""+update+"");
                TableRefresh();
            }
        });
        
        tableView.setOnMousePressed(ae -> {
            if (tableView.getSelectionModel().getSelectedItem() != null) {
                TeacherObj teacher = (TeacherObj) tableView.getSelectionModel().getSelectedItem();
                nameLbl.setText(teacher.getName());
                classLbl.setText(teacher.getClassName());
                idFld.setText(teacher.getId());
                idOld=teacher.getId();
                lastNameFld.setText(teacher.getSurname());
                firstNameFld.setText(teacher.getName());
                mobileFld.setText(teacher.getPhone());
                emailFld.setText(teacher.getEmail());
                addressFld.setText(teacher.getAddress());
                classCmBox.setValue(teacher.getClassName());
                statusCmBox.setValue(teacher.getStatus());
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
                editBtn
        );
    }
    
    public void TableRefresh() {
        ArrayList<Object> arrayData=(ArrayList<Object>) ClientTest.RequestAjluulah("adminGetAllTeachers", null);
        
        data.clear();
        
        for (int i=0; i<arrayData.size(); i++) {
            String str=(String) arrayData.get(i);
            String[] cols=str.split("::");
            TeacherObj teacherObj=new TeacherObj(cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], "", "", "");
            data.add(teacherObj);
        }
    }
    
    public void TeacherDate() {
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
        ObservableList<TeacherObj> tableItem=FXCollections.observableArrayList();
        for(int i=0; i<data.size(); i++) {
            TeacherObj teacherObj=data.get(i);
            switch(searchByCmBox.getValue()) {
                case "Кодоор":
                    cellValue=teacherObj.getId().toLowerCase();
                    break;

                case "Нэрээр":
                    cellValue=teacherObj.getName().toLowerCase();
                    break;

                case "Овогоор":
                    cellValue=teacherObj.getSurname().toLowerCase();
                    break;

                case "Утасны дугаараар":
                    cellValue=teacherObj.getPhone().toLowerCase();
                    break;

                case "Ангиар":
                    cellValue=teacherObj.getClassName().toLowerCase();
                    break;
                    
                default:
                    cellValue=teacherObj.getId().toLowerCase()+teacherObj.getName().toLowerCase()+teacherObj.getSurname().toLowerCase()+teacherObj.getPhone().toLowerCase()+teacherObj.getClassName().toLowerCase();
            }
            
            if(cellValue.contains(searchFld.getText().toLowerCase())) {
                tableItem.add(teacherObj);
            }
            
            tableView.setItems(tableItem);
        }
    }
    
    public void getTeacherInfo() {
        id=idFld.getText();
        lastName=lastNameFld.getText();
        firstName=firstNameFld.getText();
        mobile=mobileFld.getText();
        email=emailFld.getText();
        address=addressFld.getText();
        classId=classCmBox.getSelectionModel().getSelectedIndex()+1;
        status=statusCmBox.getSelectionModel().getSelectedIndex()+1;
        System.out.println(status+" status");
        update=id+"::"+lastName+"::"+firstName+"::"+mobile+"::"+address+"::"+email+"::"+status+"::"+"Picture2.jpg"+"::"+idOld;
    }
}
