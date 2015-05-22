package admin.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Student {
    private Pane pane;
    TableView table = new TableView();
    
    public Student(){
        
        pane = new Pane();
        
        SplitPane centerPart = new SplitPane();
        centerPart.setPrefSize(824, 600);
        centerPart.setStyle("-fx-background-color: #E6FFFF");
        centerPart.setDividerPosition((int) 0.01f, 0.5f);
        centerPart.setMinSize(10, 10);
        
        BorderPane centerLeftPart = new BorderPane();
//        centerLeftPart.setAlignment(Pos.CENTER);
        centerLeftPart.setPrefSize(550, 600);
        centerLeftPart.setStyle("-fx-background-color: #E6FFFF");
        centerLeftPart.setMinWidth(0);
        Label label = new Label("STUDENT");
        Button student1 = new Button("Student Example");
        
        GridPane header = new GridPane();
        header.setPrefHeight(100);
        header.setPadding(new Insets(15, 15, 15, 15));
        header.setStyle("-fx-background-color:#E6FFFF;");
        
        Label lbl1 = new Label("Compact");
        CheckBox cb1 = new CheckBox();
        Label lbl2 = new Label("Search");
        ComboBox searchtype = new ComboBox();
        searchtype.getItems().add("ByName");
        searchtype.getItems().add("ByID");
        searchtype.getItems().add("option3");
        searchtype.getItems().add("option4");
        searchtype.getSelectionModel().selectFirst();
        TextField tf1 = new TextField();
        tf1.setPromptText("Type here...");
        
        header.getChildren().addAll(lbl1,cb1,lbl2,searchtype,tf1);
        
        header.setConstraints(lbl1, 0, 1);
        header.setConstraints(cb1, 1, 1);
        header.setConstraints(lbl2, 0, 2);
        header.setConstraints(searchtype, 1, 2);
        header.setConstraints(tf1, 2, 2);
        header.setConstraints(student1, 3, 2);
        
        header.setVgap(15);
        header.setHgap(10);
        
        
        TableColumn idColumn = new TableColumn("Дугаар");
        TableColumn lastNameColumn = new TableColumn("Овог");
        TableColumn firstNameColumn = new TableColumn("Нэр");
        TableColumn phoneNumColumn = new TableColumn("Утас");
        TableColumn addressColumn = new TableColumn("Хаяг");
        TableColumn emailColumn = new TableColumn("Цахим шуудан");
        TableColumn classColumn = new TableColumn("Анги");
        TableColumn comNumColumn = new TableColumn("Комны дугаар");
        TableColumn statusColumn = new TableColumn("Статус");
        table.getColumns().addAll(idColumn,lastNameColumn,firstNameColumn);
        table.setPrefSize(400, 400);
        cb1.setSelected(true);
        cb1.setOnAction(ae->{
            if(cb1.isSelected()){
                table.getColumns().clear();
                table.getColumns().addAll(idColumn,lastNameColumn,firstNameColumn);
            }else{
                table.getColumns().clear();
                table.getColumns().addAll(idColumn,lastNameColumn,firstNameColumn,
                                  phoneNumColumn,addressColumn,emailColumn,
                                  classColumn,comNumColumn,statusColumn);}
        });
        
        Label east = new Label("     ");
        Label west = new Label("     ");
        Label bottom = new Label("     ");
        centerLeftPart.setLeft(east);
        centerLeftPart.setRight(west);
        centerLeftPart.setBottom(bottom);
        
        
        header.getChildren().addAll(label,student1);
        centerLeftPart.setTop(header);
        centerLeftPart.setCenter(table);
//        centerLeftPart.getChildren().addAll(label0,admin1,table);
        centerPart.getItems().addAll(centerLeftPart);
        
        pane.getChildren().addAll(centerPart);
        pane.setVisible(true);
        
//        ***********************************************************************************************
        
        Label tseejZurag = new Label("Зураг");
        tseejZurag.setPrefSize(180, 150);
        tseejZurag.setPadding(new Insets(20, 60, 0, 60));
        
        student1.setOnAction(st -> {
            if (centerPart.getItems().size() > 1) {
                centerPart.getItems().remove(1);
            }
            centerPart.getItems().add(new Zarlalt().getStudentContainer());
        });
        
    }
    
    public Pane getContainer() {
        return this.pane;
    }
    
}
