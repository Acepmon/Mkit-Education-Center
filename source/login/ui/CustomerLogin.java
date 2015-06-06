package login.ui;
//Bold-Erdene//

import homeworkcheckview.teacherMain;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import login.controller.ClientTest;
import login.model.LoginFeature;


/*
 CustomerLogin object үүсгэж байхад
 өөрийн зарлагдсан scene object-г
 getScene() функцээр авна.
 */
public class CustomerLogin {

    private Scene myScene;

    private static TextField fld;
    private static PasswordField fld2;

    private Label aa, bb, cc;
    
    private static CheckBox box1;
    
    private Pane pnl;
    
    private static String tmp_username = null, tmp_password = null;

    public CustomerLogin(Stage myStage) {
        myStage.setTitle("");
        Pane root = new Pane();
        FlowPane rootNode = new FlowPane(40, 20);
        rootNode.setAlignment(Pos.CENTER);
        myScene = new Scene(root, 1024, 768);
        rootNode.setMaxSize(400, 500);
        rootNode.setLayoutX((1024 - 400) / 2);
        rootNode.setLayoutY((768 - 500) / 2);
        root.setStyle("-fx-background-color: #fff");

        myStage.setScene(myScene);
        myStage.setResizable(false);


        /*Гарчиг*/
        Label lbl = new Label("Хэрэглэгчийн Нэвтрэх Хэсэг");
        lbl.setFont(new Font("Arial", 30));
        lbl.setStyle("-fx-text-fill: white;");

        Image wall = new Image("login/ui/wall5.jpg");
        ImageView wall2 = new ImageView(wall);
        wall2.setFitHeight(780);
        wall2.setFitWidth(1050);
        root.getChildren().add(wall2);
        root.getChildren().add(rootNode);

        /*Хэрэглэгчийн нэрээ оруулах талбар*/
        fld = new TextField();
        fld.setPromptText("Хэрэглэгчийн Нэр/Username");
        fld.setPrefSize(230, 30);

        /*Хэрэглэгчийн нууц үгээ оруулах талбар*/
        fld2 = new PasswordField();
        fld2.setPromptText("Хэрэглэгчийн Нууц үг/Password");
        fld2.setPrefSize(230, 30);


        /*Хэрэглэгчийн нэр, нууц үгийг санана*/
        box1 = new CheckBox("Намайг cана/Remember Me");
        box1.setStyle("-fx-text-fill: white;");
        box1.setPrefSize(200, 30);

        /*Шууд нэвтэрнэ*/
//        box2 = new CheckBox("Шууд нэвтрэх/Auto Login");
//        box2.setStyle("-fx-text-fill: white;");
//        box2.setPrefSize(200, 30);

        /*Нууц үгээ мартсан хэсэг, хулганаар даралт хийхэд нэмэлт цонх гарж ирнэ*/
//        Label lbl2 = new Label("Нууц үгээ мартсан/Forget Password");
//        lbl2.setStyle("-fx-text-fill: white;");
//        lbl2.setPrefSize(200, 30);
//        lbl2.setOnMousePressed(ae -> {
//            lbl2.setStyle("-fx-text-fill: #E0E0EB;");
//            Stage stage = new Stage();
//            new PasswordReset().start(stage);
//        });
//        lbl2.setOnMouseMoved(ae -> {
//            lbl2.setStyle("-fx-text-fill:#40AFFF;");
//            myScene.setCursor(Cursor.HAND);
//        });
//        lbl2.setOnMouseExited(ae -> {
//            myScene.setCursor(Cursor.DEFAULT);
//            lbl2.setStyle("-fx-text-fill: white;");
//        });

        /*Нэвтрэх button дээр дархад нэр нууц үг буруу байна гэсэн бичиг гарж ирнэ*/
        pnl = new Pane();
        pnl.setVisible(false);
        cc = new Label("Username or Password Incorrect");
        cc.setStyle("-fx-text-fill: #0AB2F5;");
        cc.setFont(new Font("Arial", 20));
        pnl.getChildren().addAll(cc);
        aa = new Label("XooCoH");
        aa.setStyle("-fx-text-fill: #0AB2F5;");
        aa.setVisible(false);

        bb = new Label("XooCoH");
        bb.setStyle("-fx-text-fill: #0AB2F5;");
        bb.setVisible(false);

        /*Нэвтрэх button*/
        Button btn = new Button("Нэвтрэх");
        btn.setStyle("-fx-background-color: #2C53BF; -fx-text-fill: white;");
        btn.setPrefSize(200, 40);
        btn.setOnAction(ae -> {
            Login();

        });

        /*Болих button*/
        Button btn2 = new Button("Болих");
        btn2.setStyle("-fx-background-color: #2C53BF; -fx-text-fill: white;");
        btn2.setPrefSize(200, 40);
        btn2.setOnAction(ae -> {
            myStage.close();

        });

        myScene.setOnKeyPressed(ae -> {
            KeyCode key = ae.getCode();
            if (key == KeyCode.ENTER) {
                Login();
            }
        });
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("login.txt"));
            String line = br.readLine();
            String[] arr = line.split("::");
            String remember = arr[0];
            if (remember.equals("true")) {
                String username = arr[1];
                String password = arr[2];
                fld.setText(username);
                fld2.setText(password);
                box1.setSelected(true);
            } else {
                box1.setSelected(false);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) { 
        }
        

        aa.setLayoutX(650);
        aa.setLayoutY(235);
        bb.setLayoutX(650);
        bb.setLayoutY(285);
        root.getChildren().addAll(aa, bb);
        rootNode.requestFocus();
        rootNode.getChildren().addAll(lbl, pnl, fld, fld2, box1, btn, btn2);
    }

    public Scene getScene() {
        return this.myScene;
    }

    public static CheckBox getBox1() {
        return box1;
    }

    public static String getTmp_username() {
        return tmp_username;
    }

    public static String getTmp_password() {
        return tmp_password;
    }

    public static TextField getFld() {
        return fld;
    }

    public static PasswordField getFld2() {
        return fld2;
    }

    private void Login() {
        if ((fld.getLength() <= 0) && (fld2.getLength() <= 0)) {
            aa.setVisible(true);
            bb.setVisible(true);
            pnl.setVisible(false);
        } else if ((fld2.getLength() > 0) && (fld.getLength() <= 0)) {
            bb.setVisible(false);
            aa.setVisible(true);
            pnl.setVisible(false);
        } else if ((fld.getLength() > 0) && (fld2.getLength() <= 0)) {
            bb.setVisible(true);
            aa.setVisible(false);
            pnl.setVisible(false);
        } else {
            String response = (String) ClientTest.RequestAjluulah("Account", fld.getText() + "::" + fld2.getText());
            String[] responseArr = response.split("::");
            String type = responseArr[0];
            String res = responseArr[1];

            if (res.equalsIgnoreCase("true")) {
                //test.Testing.setScene(new teacherMain().getScene());
                /*оюутан,админ,менежэр*/
                // "багш" гэсний оронд айл нэгийн бичэж өгнө үү
                if (type.equalsIgnoreCase("багш")) {
                    // Undsen mainframe enchee duudaj og
                    tmp_username = fld.getText();
                    tmp_password = fld2.getText();
                    test.Testing.setScene(new teacherMain().getScene());
                    LoginFeature loginFeature = new LoginFeature();
                } else {
//                  aa.setVisible(true);
                    aa.setVisible(false);
                    bb.setVisible(false);
                    pnl.setVisible(true);
                    ((Label) pnl.getChildren().get(0)).setText("Зөвхөн багш нэвтрэх ёстой!");
                }
            } else if (res.equalsIgnoreCase("false")) {
//                bb.setVisible(true);
                pnl.setVisible(true);
                ((Label) pnl.getChildren().get(0)).setText("Username or password Incorrect!");
                aa.setVisible(false);
                bb.setVisible(false);
            }

        }
    }
    
     
}
