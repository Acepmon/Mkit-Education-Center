package teacher.login.ui;
//Bold-Erdene//

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import teacher.controller.ServerConnection;
import teacher.login.model.LoginFeature;
import teacher.launch.Launcher;
import teacher.ui.Tailan_left_inner;
//import teacher.login.model.IPFeature;


/*
 CustomerLogin object үүсгэж байхад
 өөрийн зарлагдсан scene object-г
 getScene() функцээр авна.
 */
public class CustomerLogin {
    
     

    public static File LOGINFILE = new File("login.txt");
    public static File decFile = new File("decrypted.txt");
    public static final File IPFile = new File("ip.txt");

    public static Label aa, bb, cc, sett;

    private Scene myScene;

    private static TextField fld;
    private static PasswordField fld2;

    private static CheckBox box1;

   public static Pane pnl;

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

        Image anotherIcon = new Image("teacher/resource/32x32_green.png");
        myStage.getIcons().add(anotherIcon);

        /*Гарчиг*/
        Label lbl = new Label("Хэрэглэгчийн Нэвтрэх Хэсэг");
        lbl.setFont(new Font("Arial", 30));
        lbl.setStyle("-fx-text-fill: white;");

        Image wall = new Image("teacher/resource/wall5.jpg");
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

        /*Нэвтрэх button дээр дархад нэр нууц үг буруу байна гэсэн бичиг гарж ирнэ*/
        pnl = new Pane();
        pnl.setVisible(false);
        cc = new Label("Таны нэр эсвэл нууц үг буруу байна");
        cc.setStyle("-fx-text-fill: #F20A21;");
        cc.setFont(new Font("Arial", 20));
        pnl.getChildren().addAll(cc);
        aa = new Label("Xоосон");
        aa.setStyle("-fx-text-fill: #F20A21;");
        aa.setVisible(false);

        bb = new Label("Xоосон");
        bb.setStyle("-fx-text-fill: #F20A21;");
        bb.setVisible(false);

        /*Нэвтрэх button*/
        Button btn = new Button("Нэвтрэх");
        btn.setStyle("-fx-background-color: #2C53BF; -fx-text-fill: white;");
        btn.setPrefSize(200, 40);
        btn.setOnAction(ae -> {
            aa.setVisible(false);
            bb.setVisible(false);
            pnl.setVisible(false);

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

        LoginFeature.refreshEncFiles(2);
        CustomerLogin.decFile.delete();

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
            String response = (String) ServerConnection.RequestAjluulah("login", fld.getText() + "::" + fld2.getText()+"::teacher");
            String[] responseArr = response.split("::");
            String type = responseArr[0];
            String res = responseArr[1];

            if (res.equalsIgnoreCase("true")) {
                if (type.equalsIgnoreCase("teacher")) {
                    // Undsen mainframe enchee duudaj og
                    tmp_username = fld.getText();
                    tmp_password = fld2.getText();
                    LoginFeature.refreshEncFiles(1);
                    Launcher.initialize();
                    
                    Launcher.setScene(Launcher.getTEACHER().getScene());
                    
                    Tailan_left_inner.setDatas();
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
                ((Label) pnl.getChildren().get(0)).setText("Таны нэр эсвэл нууц үг буруу байна!");
                aa.setVisible(false);
                bb.setVisible(false);
            }
        }
    }
}
