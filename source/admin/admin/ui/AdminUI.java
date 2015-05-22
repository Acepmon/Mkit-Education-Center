package admin.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.StyleableStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import test.Tester;

public class AdminUI {

    private Scene myScene;
    Student student2 = new Student();
    Admin adminObject = new Admin();
    Manager managerObject = new Manager();
    Teacher teacherObject = new Teacher();
    Student studentObject = new Student();
    Active activeObject = new Active();

    public AdminUI() {
        FlowPane main = new FlowPane();

        Pane mainMain = new Pane();

        main.setLayoutX(0);
        main.setLayoutY(0);

        myScene = new Scene(mainMain, conf.Config.STAGE_WIDTH, conf.Config.STAGE_HEIGHT);
        myScene.getStylesheets().add(getClass().getResource("css1.css").toExternalForm());

        SplitMenuButton smtbn = new SplitMenuButton();
        MenuItem op1 = new MenuItem("");
        smtbn.getItems().add(op1);
        smtbn.setText("menibtn");
        
        HBox hbox = new HBox();
        hbox.setPrefSize(1024, 100);
        hbox.setStyle("-fx-background-color: #356CA3");

        FlowPane topPart = new FlowPane(50, 10);
        topPart.setPrefSize(824, 100);
        
//        File f1 = new File("resource/images/2.png");
        Image logo = new Image("resource/images/2.png");
        ImageView logoIV = new ImageView(logo);
        logoIV.setVisible(true);
        logoIV.setPreserveRatio(true);
        logoIV.setFitWidth(200);
        
        Label lbl = new Label("          ADMIN PANEL");
        lbl.setId("lbl");
//        lbl.setFont(Font.font("Verdana", 40));
//        lbl.setStyle("-fx-border-color:pink;-fx-border-radius:4em;");
        
        topPart.getChildren().addAll(logoIV,lbl);
        topPart.setAlignment(Pos.CENTER_LEFT);
        topPart.setPadding(new Insets(0, 0, 0, 50));

        GridPane leftPart = new GridPane();
        leftPart.setAlignment(Pos.CENTER);
        leftPart.setStyle("-fx-background-color: #69BCE6");
        leftPart.setPrefSize(200, 600);
        
        Pane centerPart = new Pane();
        centerPart.setPrefSize(824, 600);
        centerPart.setStyle("-fx-background-color: #E6FFFF");

        Button adminBtn = new Button("Админ");
        adminBtn.setPrefSize(190, 70);
        GridPane.setConstraints(adminBtn, 0, 1);
        adminBtn.setId("btn");

        Button managerBtn = new Button("Менежер");
        managerBtn.setPrefSize(190, 70);
        GridPane.setConstraints(managerBtn, 0, 2);
        managerBtn.setId("btn");

        Button teacherBtn = new Button("Багш");
        teacherBtn.setPrefSize(190, 70);
        GridPane.setConstraints(teacherBtn, 0, 3);
        teacherBtn.setId("btn");

        Button studentBtn = new Button("Оюутан");
        studentBtn.setPrefSize(190, 70);
        GridPane.setConstraints(studentBtn, 0, 4);
        studentBtn.setId("btn");

        Button activeBtn = new Button("Идэвхтэй хэрэглэгчид");
        activeBtn.setPrefSize(190, 70);
        GridPane.setConstraints(activeBtn, 0, 5);
        activeBtn.setId("btn");
        
         Button addBtn = new Button("Шинээр Бүртгэх");
        addBtn.setPrefSize(190, 70);
        GridPane.setConstraints(addBtn, 0, 35);
        addBtn.setId("btn");
        
        Button permBtn = new Button("Хэрэглэгчидийн эрх");
        permBtn.setPrefSize(190, 70);
        GridPane.setConstraints(permBtn, 0, 36);
        permBtn.setId("btn");
        permBtn.setOnAction(ae->{
            Stage stage = new Stage();
            new Permission_UI().start(stage);
        });
        
        
//        leftPart.setHgap(50);
        leftPart.setVgap(3);
        leftPart.setAlignment(Pos.TOP_CENTER);
//******************ImageButton*************************************************
        
        Image image = new Image("resource/images/pb2.png");
        Image image2 = new Image("resource/images/pb2b.png");
        ImageView imageIV = new ImageView(image);
        imageIV.setFitWidth(70);
        imageIV.setPreserveRatio(true);
        imageIV.setCache(true);
        imageIV.setSmooth(true);
        Button off = new Button("", imageIV);
        off.setPrefSize(20,20);
        off.setBorder(Border.EMPTY);
        off.setId("shutdown_button");
        FadeTransition fadeOff = new FadeTransition(Duration.minutes(1), off);
        fadeOff.play();
        off.setOnAction(ae->{
            if(imageIV.getImage().equals(image)) {
                imageIV.setImage(image2);
            } else if (imageIV.getImage().equals(image2)) {
                imageIV.setImage(image);
            }
        });
        
        
        
        off.setStyle("-fx-right:4;");

        leftPart.getChildren().addAll(adminBtn, managerBtn, teacherBtn, studentBtn, activeBtn,addBtn,permBtn);
        
        Pane pane = new Pane();
        
        Label lll = new Label("dada");
        pane.getChildren().add(lll);
        
        adminBtn.setOnAction(q -> {
            centerPart.getChildren().clear();
            centerPart.getChildren().addAll(adminObject.getContainer()
            );
        });

        FlowPane managerPane = new FlowPane();
        managerPane.setAlignment(Pos.CENTER);

        Label label1 = new Label("Менежер");
        Button manager1 = new Button("Менежер жишээ");

        managerPane.getChildren().addAll(label1, manager1);
        managerPane.setStyle("-fx-background-color: white");

        managerBtn.setOnAction(q -> {
            centerPart.getChildren().clear();
            centerPart.getChildren().addAll(managerObject.getContainer());
        });
        
        Label tseejZurag = new Label("Зураг");
        tseejZurag.setPrefSize(180, 150);
        tseejZurag.setPadding(new Insets(20, 60, 0, 60));


        FlowPane teacherPane = new FlowPane();
        teacherPane.setAlignment(Pos.CENTER);

        Label label3 = new Label("Багш");
        Button teacher1 = new Button("Багш жишээ");
        teacherPane.getChildren().addAll(label3, teacher1);
        teacherPane.setStyle("-fx-background-color: purple");

        FlowPane activePane = new FlowPane();
        activePane.setAlignment(Pos.CENTER);

        Label label4 = new Label("Active");
        Button active1 = new Button("Active жишээ");

        activePane.getChildren().addAll(label4, active1);
        activePane.setStyle("-fx-background-color: blue");

        activeBtn.setOnAction(q -> {
            centerPart.getChildren().clear();
            centerPart.getChildren().add(activeObject.getContainer());
        });

        Label test = new Label("testing box");


//***************MouseHover*********************************************************
        FlowPane testP = new FlowPane();
        System.out.println(testP.getLayoutX());
        System.out.println(testP.getLayoutY());
        
        testP.setStyle("-fx-background-color: red;");
        testP.setVisible(false);
        testP.setMinSize(50, 50);
        testP.setLayoutX(470);
        testP.setLayoutY(70);
        testP.getChildren().add(new Label("adas"));
                
        test.setOnMouseEntered(ae -> {
            System.out.println("sadas");
            test.setStyle("-fx-background-color: red");
            testP.setVisible(true);
        });
        test.setOnMouseExited(ae -> {
            System.out.println("sadagfhjkls");
            test.setStyle("-fx-background-color: white");
            testP.setVisible(false);
        });
//        *********Footer****************************************************
        FlowPane footer = new FlowPane();
        footer.setAlignment(Pos.CENTER);
        footer.setPrefWidth(1024);
        footer.setPrefHeight(70);
        footer.setLayoutY(700);
        footer.setStyle("-fx-background-color:#356CA3;");
        Button addStudentBtn = new Button("Add New Student");
        addStudentBtn.setPrefSize(200, 50);
        Button addTeacherBtn = new Button("Add New Teacher");
        addTeacherBtn.setPrefSize(200, 50);
//        footer.getChildren().add(addBtn);
        
        
        
        
        
        
        
//        ***************************************
//        topPart.getChildren().addAll(test);
        FlowPane offCont = new FlowPane(off);
        offCont.setAlignment(Pos.CENTER_RIGHT);
        offCont.setPrefSize(200, 100);
        offCont.setPadding(new Insets(0, 15, 0, 0));
        hbox.getChildren().addAll(topPart, offCont);
        main.getChildren().addAll(hbox, leftPart ,centerPart);
        mainMain.getChildren().addAll(main, testP, footer);

        studentBtn.setOnAction(ae -> {
            centerPart.getChildren().clear();
            centerPart.getChildren().add(studentObject.getContainer());
//            if(studentBtn.isFocused()){footer.getChildren().clear();
//            footer.getChildren().add(addStudentBtn);}
//            else
//            {footer.getChildren().clear();}   
            
        });
        
        teacherBtn.setOnAction(q -> {
            centerPart.getChildren().clear();
            centerPart.getChildren().addAll(teacherObject.getContainer());
//            if(teacherBtn.isFocused()){footer.getChildren().clear();
//            footer.getChildren().add(addTeacherBtn);}
//            else
//            {footer.getChildren().clear();} 
        });
        
    }

    public Scene getScene() {
        return this.myScene;
    }

}
