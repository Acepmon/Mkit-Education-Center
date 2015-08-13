package admin.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;
import login.ui.ServerConnection;

public class Grade {
    private Pane pane;
    public static TableView table = new TableView();
    public static int rowIndex = -1;
    public static boolean studentDuudsan = false;
    
    private static ComboBox<String> cbSearch;
    private static ComboBox<String> typeBox;
    private static ComboBox<String> teacherBox;
    private static TextField filterField;
    ToggleGroup tg;
    static ObservableList<GradeObj> data = FXCollections.observableArrayList();
    
    private DatePicker checkInDatePicker;
    private DatePicker checkOutDatePicker;
    
    public Grade(){
        
        pane = new Pane();
        
        SplitPane centerPart = new SplitPane();
        centerPart.setPrefSize(824, 600);
        centerPart.setStyle("-fx-background-color: #E6FFFF");
        centerPart.setDividerPosition((int) 0.01f, 0.5f);
        centerPart.setMinSize(10, 10);
        
        BorderPane centerLeftPart = new BorderPane();
        centerLeftPart.setPrefSize(550, 600);
        centerLeftPart.setStyle("-fx-background-color: #E6FFFF");
        centerLeftPart.setMinWidth(0);
        
        Label label = new Label("ДҮНГИЙН МЭДЭЭЛЭЛ");
        label.setFont(Font.font(null, FontWeight.BOLD, 16));

        GridPane header = new GridPane();
        header.setPrefHeight(100);
        header.setPadding(new Insets(15, 15, 15, 15));
        header.setStyle("-fx-background-color:#E6FFFF;");
        
        Label lbl1 = new Label("Дүнгийн хэлбэр");
        lbl1.setFont(Font.font(null, FontWeight.BOLD, 12));      
        
        Label lbl2 = new Label("Хичээл");
        lbl2.setFont(Font.font(null, FontWeight.BOLD, 12));
        
        Label lbl3 = new Label("Багш");
        lbl3.setFont(Font.font(null, FontWeight.BOLD, 12));
        
        Label lbl4 = new Label("Эхлэх огноо");
        lbl4.setFont(Font.font(null, FontWeight.BOLD, 12)); 
        lbl4.setPrefSize(120, 20);
        
        checkInDatePicker = new DatePicker();        
        checkOutDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                    checkInDatePicker.getValue().plusDays(1))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
        checkOutDatePicker.setDayCellFactory(dayCellFactory);
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));  
        
        Label lbl5 = new Label("Төгсөх огноо");
        lbl5.setFont(Font.font(null, FontWeight.BOLD, 12));
        lbl5.setPrefSize(120, 20);
        
        ObservableList<String> formtype = FXCollections.observableArrayList("нэрээр", "овогоор", "id", "утасаар", "статусаар");
        ObservableList<String> lessonType = FXCollections.observableArrayList("нэрээр", "овогоор", "id", "утасаар");
        ObservableList<String> teacherType = FXCollections.observableArrayList("нэрээр", "овогоор", "id", "утасаар", "статусаар");
        
        typeBox = new ComboBox(lessonType);
        typeBox.setValue("Сонгох");
        typeBox.setPrefSize(100, 20);
        
        cbSearch = new ComboBox(formtype);
        cbSearch.setValue("Сонгох");
        
        teacherBox = new ComboBox(teacherType);
        teacherBox.setValue("Сонгох");
        
        RadioButton weekBtn = new RadioButton("Долоо хоног");
        weekBtn.setFont(Font.font(null, FontWeight.BOLD, 12));
        weekBtn.setPrefSize(140, 20);
        weekBtn.setToggleGroup(tg);
        weekBtn.setSelected(true);
        
        RadioButton monthBtn = new RadioButton("Сар");
        monthBtn.setFont(Font.font(null, FontWeight.BOLD, 12));
        monthBtn.setToggleGroup(tg);
        
        RadioButton totalBtn = new RadioButton("Нийт");
        totalBtn.setFont(Font.font(null, FontWeight.BOLD, 12));
        totalBtn.setToggleGroup(tg);     
        
        Button printBtn = new Button("Хэвлэх");
        printBtn.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");                 

        
        Button addBtn = new Button("Шинээр нэмэх");
        addBtn.setOnAction(ae -> {
            Stage AddStage = new Stage();
            try {
                new AddStudent().start(AddStage);
            } catch (Exception ex) {
                Logger.getLogger(AllAdd.class.getName()).log(Level.SEVERE, null, ex);
            }           
        });
        addBtn.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");  
        
        header.getChildren().addAll(lbl1,typeBox, weekBtn, lbl4, checkInDatePicker, lbl2, cbSearch, monthBtn, lbl5, checkOutDatePicker, lbl3, teacherBox, totalBtn, printBtn);
        
        header.setConstraints(lbl1, 0, 1);
        header.setConstraints(typeBox, 1, 1);
        header.setConstraints(weekBtn, 2, 1);
        header.setConstraints(lbl4, 3, 1);
        header.setConstraints(checkInDatePicker, 4, 1);
        
        header.setConstraints(lbl2, 0, 2);
        header.setConstraints(cbSearch, 1, 2);
        header.setConstraints(monthBtn, 2, 2);
        header.setConstraints(lbl5, 3, 2);
        header.setConstraints(checkOutDatePicker, 4, 2);
        
        header.setConstraints(lbl3, 0, 3);
        header.setConstraints(teacherBox, 1, 3);
        header.setConstraints(totalBtn, 2, 3);        
        header.setConstraints(printBtn, 4, 3);
        
        header.setVgap(15);
        header.setHgap(10);        
        
//        TableColumn idColumn = new TableColumn("Дугаар");
//        idColumn.setMinWidth(100);
//        idColumn.setCellValueFactory(new PropertyValueFactory<GradeObj, String>("id"));

        TableColumn lastNameColumn = new TableColumn("Нэр");
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<GradeObj, String>("lastname"));

        TableColumn firstNameColumn = new TableColumn("Овог");
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<GradeObj, String>("firstname"));

        table.getColumns().clear();
        table.getColumns().addAll(                
//                idColumn,
                lastNameColumn,
                firstNameColumn
        );

//        ArrayList<Object> responseData = (ArrayList<Object>) ClientTest.RequestAjluulah("adminGetAllStudents", null);              
//        System.out.println("---- student "+responseData);        
        data.clear();        
//        for(Object str : responseData) {
//            if (!str.equals("") && str != null) {
//            String[] col = str.toString().split("::");
//            data.add(new StudentObj(col[0], col[1], col[2], col[3], col[4], col[5], col[6], "", ""));
//            }
//        }
        
        final ObservableList<GradeObj> data = FXCollections.observableArrayList(
                new GradeObj("amar", "erdene"),
                new GradeObj("temuulen", "amar")
        );
        table.setItems(data);

        table.setOnMouseClicked(ae -> {
            int c = table.getSelectionModel().getSelectedIndex();
            System.out.println(c);
            rowIndex = c;
        });        
        
        Label east = new Label("     ");
        Label west = new Label("     ");
        Label bottom = new Label("     ");
        centerLeftPart.setLeft(east);
        centerLeftPart.setRight(west);
        centerLeftPart.setBottom(bottom);        
        
        header.getChildren().addAll(label);
        centerLeftPart.setTop(header);
        centerLeftPart.setCenter(table);
        centerPart.getItems().addAll(centerLeftPart);
        
        pane.getChildren().addAll(centerPart);
        pane.setVisible(true);
        
//        **************************************************************
        
        Label tseejZurag = new Label("Зураг");
        tseejZurag.setPrefSize(180, 150);
        tseejZurag.setPadding(new Insets(20, 60, 0, 60));
        
//        student1.setOnAction(st -> {
//            if (centerPart.getItems().size() > 1) {
//                centerPart.getItems().remove(1);
//            }
//            centerPart.getItems().add(new Zarlalt().getStudentContainer());
//            Admin.adminDuudsan = false;
//            Manager.managerDuudsan = false;
//            studentDuudsan = true;
//            Teacher.teacherDuudsan = false;
//        });
//        student1.setVisible(false);
//
//        table.setOnMousePressed(ae->{
//            if (centerPart.getItems().size() > 1) {
//                centerPart.getItems().remove(1);
//            }
//            centerPart.getItems().add(new Zarlalt().getStudentContainer());
//            Admin.adminDuudsan = false;
//            Manager.managerDuudsan = false;
//            studentDuudsan = true;
//            Teacher.teacherDuudsan = false;
//        });
    }
    
    public Pane getContainer() {
        return this.pane;
    }
        
}
