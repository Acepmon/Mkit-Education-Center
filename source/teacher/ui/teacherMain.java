package teacher.ui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import teacher.config.Config;
import teacher.launch.Launcher;

public class TeacherMain {

  
    private static BorderPane rootNode;
    private Scene scene;
    private TextArea txtarea;
    private Label niitIrts, idevhiinDunOruulah, log, set, homework;

    public TeacherMain() {
        Pane root = new Pane();
        root.setMinSize(Config.STAGE_WIDTH, Config.STAGE_HEIGHT);

        rootNode = new BorderPane();
        rootNode.setMinSize(Config.STAGE_WIDTH, Config.STAGE_HEIGHT);
        scene = new Scene(root, Config.STAGE_WIDTH, Config.STAGE_HEIGHT);

        // **************************************
        StackPane main = new StackPane();
        scene.getStylesheets().add(getClass().getResource("style/mainStyle.css").toExternalForm());
        main.setStyle("-fx-background-color: #666666");
        main.setPrefHeight(60);

        FlowPane centerPro = new FlowPane();
        FlowPane centerFp = new FlowPane();
        //1///Багшын дропдавн мэню
        VBox dropdown = new VBox();
        dropdown.setAlignment(Pos.CENTER);
        dropdown.setPrefSize(150, 160);
        dropdown.setPadding(new Insets(0, 0, 10, 0));
        dropdown.setVisible(false);
//        dropdown.setLayoutX(teacher.config.Config.STAGE_WIDTH - 164);
        dropdown.setLayoutX(teacher.config.Config.STAGE_WIDTH - 149);
        dropdown.setLayoutY(60);
        dropdown.setStyle("-fx-background-color: #B3B3B3");

//        #B3B3B3
        DropShadow shdw = new DropShadow();
        shdw.setBlurType(BlurType.GAUSSIAN);
        shdw.setColor(Color.BLACK);
        shdw.setRadius(10);
        shdw.setSpread(0.12);
        shdw.setHeight(10);
        shdw.setWidth(10);
        dropdown.setEffect(shdw);

        /////1/////
//2//
        VBox dropdown2 = new VBox();
        dropdown2.setAlignment(Pos.CENTER_LEFT);
        dropdown2.setPrefSize(150, 100);
        dropdown2.setPadding(new Insets(8, 0, 10, 0));
        dropdown2.setVisible(false);
        dropdown2.setLayoutX(teacher.config.Config.STAGE_WIDTH - 784);
//        dropdown2.setLayoutX(teacher.config.Config.STAGE_WIDTH - 665);
        dropdown2.setLayoutY(60);
        dropdown2.setStyle("-fx-background-color: #B3B3B3 ");
//        #B3B3B3
        DropShadow shdw2 = new DropShadow();
        shdw2.setBlurType(BlurType.GAUSSIAN);
        shdw2.setColor(Color.BLACK);
        shdw2.setRadius(10);
        shdw2.setSpread(0.12);
        shdw2.setHeight(10);
        shdw2.setWidth(10);
        dropdown2.setEffect(shdw2);
//2//

        centerPro.setPrefSize(524, 708);
        Label Profile = new Label("Багшын мэдээлэл");
        Profile.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 18));
        Profile.setId("text");
        centerPro.getChildren().add(Profile);
        centerPro.setStyle("-fx-background-color: white");
        txtarea = new TextArea();
        txtarea.setPrefSize(524, 643);
        centerPro.getChildren().add(txtarea);

        FlowPane t = new FlowPane();
        t.setPrefSize(150, 60);

        Label teach = new Label("Багш ");
        teach.setPrefSize(150, 60);
//        teach.setTextFill(null);
        teach.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        teach.setAlignment(Pos.BASELINE_CENTER);
        teach.setId("btn");
        teach.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {                    
                    dropdown2.setVisible(false);
                }

            });
//        

        t.getChildren().add(teach);
//        t.setPadding(new Insets(0, 0, 0,260));
//        t.setPadding(new Insets(0, 0, 0, 364));
          t.setPadding(new Insets(0, 0, 0, 0));

        Label other = new Label(" Бусад");
        other.setPrefSize(150, 35);
        other.setFont(Font.font("Arial", 12));
        other.setStyle("-fx-text-fill:darkgrey");
        other.setId("downmenu");
//        other.setAlignment(Pos.CENTER_LEFT);
        other.setOnMouseExited(ae -> {
            dropdown.setCursor(Cursor.DEFAULT);
        });

        Label profile = new Label(" Мэдээлэл");
        profile.setPrefSize(150, 35);
        profile.setId("downmenu");
//      profile.setAlignment(Pos.BOTTOM_LEFT);
        profile.setFont(Font.font("Arial", 12));
        profile.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TeacherMain.changeLeft(Launcher.getHUVAARI().getContainer());
                rootNode.setCenter(new CenterPro().getContainer());
                TeacherMain.changeRight(new Tailan_left().getContainer());

                if (dropdown.isVisible()) {
                    dropdown.setVisible(false);
                }
            }
        });

        log = new Label(" Гарах");
        set = new Label(" Тохиргоо");
        homework = new Label(" Даалгавар");

        homework.setPrefSize(150, 35);
//          homework.setAlignment(Pos.CENTER_LEFT);
        homework.setFont(Font.font("Arial", 12));
        homework.setId("downmenu");
        homework.setOnMousePressed((MouseEvent event) -> {
            if (centerFp.isVisible()) {
                TeacherMain.changeLeft(Launcher.getHOMEWORK().getContainer());
                rootNode.setCenter(new DaalgavarSend().getContainer());
                TeacherMain.changeRight(new Tailan_left().getContainer());
                if (dropdown.isVisible()) {
                    dropdown.setVisible(false);
                }
            }
        });

        set.setPrefSize(150, 35);
        set.setAlignment(Pos.CENTER_LEFT);
        set.setFont(Font.font("Arial", 12));
        set.setId("downmenu");
        set.setOnMouseClicked((MouseEvent event) -> {
            Passwords sett = new Passwords(Launcher.getLogoutStage());
            if (dropdown.isVisible()) {
                dropdown.setVisible(false);
            }
        });

//          log.setAlignment(Pos.CENTER_LEFT);
        log.setFont(Font.font("Arial", 12));
        log.setPrefSize(150, 35);
//          log.setStyle("-fx-Background-color:#808080");
        log.setId("downmenu");
        log.setOnMouseClicked((MouseEvent event) -> {
            Logout log1 = new Logout(Launcher.getLogoutStage());
            if (dropdown.isVisible()) {
                dropdown.setVisible(false);
            }
        });

        dropdown.setCursor(Cursor.MOVE);
        dropdown.getChildren().addAll(other, homework, profile, set, log);

        teach.setOnMousePressed(ae -> {
            if (dropdown.isVisible()) {
                dropdown.setVisible(false);
            } else {
                dropdown.setVisible(true);
                dropdown.setOnMouseExited(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        dropdown.setVisible(false);

                    }
                });                              
                   
            }

        });

        ///2/// 
        Label irtsBurtgel = new Label(" Ирц Бүртгэл");
        irtsBurtgel.setPrefSize(150, 35);
        irtsBurtgel.setFont(Font.font("Arial", 12));
        irtsBurtgel.setId("downmenu");
//        other.setAlignment(Pos.CENTER_LEFT);
        irtsBurtgel.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                rootNode.setCenter(new Irts().getContainer());
                if (dropdown2.isVisible()) {
                    TeacherMain.changeLeft(null);
                    dropdown2.setVisible(false);
                }
            }
        });

        Label YvtsiinDunOruulah = new Label(" Явцын дүн оруулах");
        YvtsiinDunOruulah.setPrefSize(150, 35);
        YvtsiinDunOruulah.setId("downmenu");
//      profile.setAlignment(Pos.BOTTOM_LEFT);
        YvtsiinDunOruulah.setFont(Font.font("Arial", 12));
        YvtsiinDunOruulah.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                rootNode.setCenter(new DunOruulah().getContainer());
                if (dropdown2.isVisible()) {
                    TeacherMain.changeLeft(null);
                    dropdown2.setVisible(false);
                }
            }
        });

        niitIrts = new Label(" Нийт ирц");
        idevhiinDunOruulah = new Label(" Идэвхийн дүн оруулах");

        idevhiinDunOruulah.setPrefSize(150, 35);
        homework.setAlignment(Pos.CENTER_LEFT);
        idevhiinDunOruulah.setFont(Font.font("Arial", 12));
        idevhiinDunOruulah.setId("downmenu");
        idevhiinDunOruulah.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                rootNode.setCenter(new DunOruulah().getContainer());
                if (dropdown2.isVisible()) {
                    TeacherMain.changeLeft(null);
                    dropdown2.setVisible(false);
                }
            }
        });

//          log.setAlignment(Pos.CENTER_LEFT);
        niitIrts.setFont(Font.font("Arial", 12));
        niitIrts.setPrefSize(150, 35);
//          log.setStyle("-fx-Background-color:#808080");
        niitIrts.setId("downmenu");
        niitIrts.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                rootNode.setCenter(new Irts().getContainer());
                if (dropdown2.isVisible()) {
                    TeacherMain.changeLeft(null);
                    dropdown2.setVisible(false);
                }
            }
        });

        dropdown2.setCursor(Cursor.MOVE);
        dropdown2.getChildren().addAll(irtsBurtgel, idevhiinDunOruulah, YvtsiinDunOruulah, niitIrts);

        // **************************************
        FlowPane topFp = new FlowPane();
        scene.getStylesheets().add(getClass().getResource("style/mainStyle.css").toExternalForm());
        topFp.setStyle("-fx-background-color: #B3B3B3");
        topFp.setPrefHeight(60);

        ////Дээд талын хэсэг
        Label mainBtn = new Label("Үндсэн");
        mainBtn.setPrefSize(120, 60);
        mainBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        mainBtn.setAlignment(Pos.CENTER);
        mainBtn.setId("btn");
        mainBtn.setOnMousePressed(ae -> {
            TeacherMain.changeLeft(null);
            TeacherMain.changeCenter(new Medeelel().getContainer());
            TeacherMain.changeRight(new Homework().getContainer());
            
            
        });
        

        Label hwBtn = new Label("Даалгавар");
        hwBtn.setPrefSize(120, 60);
        hwBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        hwBtn.setAlignment(Pos.CENTER);
        hwBtn.setId("btn");
        hwBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    dropdown.setVisible(false);
                dropdown2.setVisible(false);
                }

            });
        hwBtn.setOnMousePressed(ae -> {
            TeacherMain.changeLeft(new Homework().getContainer());
//            TeacherMain.changeLeft(null);
            TeacherMain.changeCenter(new Daalgavarshalgah().getContainer());
            TeacherMain.changeRight(new Tree().getContainer());            
        });

//        Label examBtn = new Label("Шалгалт авах");
//        examBtn.setPrefSize(120, 60);
//        examBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
//        examBtn.setAlignment(Pos.CENTER);
//        examBtn.setId("btn");
        
        Label scoreBtn = new Label("Дүн оруулах");
//        scoreBtn.setPrefSize(120, 60);
        scoreBtn.setPrefSize(150, 60);

        scoreBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        scoreBtn.setAlignment(Pos.CENTER);
        scoreBtn.setId("btn");
        scoreBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    dropdown.setVisible(false);
              
                }

            });
        scoreBtn.setOnMousePressed(ae -> {
            if (dropdown2.isVisible()) {
                dropdown2.setVisible(false);
           
         
            } else {
                dropdown2.setVisible(true);
                dropdown2.setOnMouseExited(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        dropdown2.setVisible(false);
                    }
                });

            }
        });

        Label tailanBtn = new Label("Тайлан гаргах");
        tailanBtn.setPrefSize(120, 60);
        tailanBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        tailanBtn.setAlignment(Pos.CENTER);
        tailanBtn.setId("btn");
        tailanBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    dropdown.setVisible(false);
                    dropdown2.setVisible(false);
                }

            });
        tailanBtn.setOnMousePressed(ae -> {

            TeacherMain.changeLeft(Launcher.getTAILAN_LEFT().getContainer());
            TeacherMain.changeCenter(Launcher.getTAILAN_MEDEELEL().getContainer());
            TeacherMain.changeRight(null);        
        });
        
        Label hooson = new Label("");
        hooson.setPrefSize(364, 60);
        hooson.setFont(javafx.scene.text.Font.font("Arial", 12));
        hooson.setAlignment(Pos.CENTER);        
        hooson.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    dropdown.setVisible(false);
                    dropdown2.setVisible(false);
                }

            });

        topFp.getChildren().addAll(mainBtn, hwBtn, scoreBtn, tailanBtn,hooson, t);
//        topFp.getChildren().addAll(mainBtn, hwBtn, examBtn, scoreBtn, tailanBtn, t);        
        rootNode.setTop(topFp);
        //             TeacherMain.changeLeft(Launcher.getHUVAARI().getContainer());
        TeacherMain.changeLeft(null);
        rootNode.setCenter(Launcher.getMEDEELEL().getContainer());
        rootNode.setRight(Launcher.getHOMEWORK().getContainer());
        root.getChildren().addAll(rootNode, dropdown, dropdown2);


    }

    public static void changeTop(Node node) {
        TeacherMain.rootNode.setTop(node);
    }

    public static void changeBottom(Node node) {
        TeacherMain.rootNode.setBottom(node);
    }

    public static void changeCenter(Node node) {
        TeacherMain.rootNode.setCenter(node);
    }

    public static void changeLeft(Node node) {
        TeacherMain.rootNode.setLeft(node);
    }

    public static void changeRight(Node node) {
        TeacherMain.rootNode.setRight(node);
    }

    public Scene getScene() {
        return this.scene;
    }
}
