package newConnection;
//Bold-Erdene//
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/*
    CustomerLogin object үүсгэж байхад
    өөрийн зарлагдсан scene object-г
    getScene() функцээр авна.
*/
public class CustomerLogin {
    
   static private Scene myScene;
   TextField nerfld;
   PasswordField passfld;
   Pane pnl;
    public CustomerLogin() {
        
        Stage myStage = new Stage();
        myStage.setTitle("");
        Pane root =new Pane();
        FlowPane rootNode = new FlowPane(40, 20);
        rootNode.setAlignment(Pos.CENTER);
        myScene = new Scene(root, 1024, 768);
        rootNode.setMaxSize(400, 500);
        rootNode.setLayoutX((1024 - 400) / 2);
        rootNode.setLayoutY((768 - 500) / 2);
        root.setStyle("-fx-background-color: #fff");
        root.getChildren().add(rootNode);
        myStage.setScene(myScene);
        myStage.setResizable(false);

        /*Гарчиг*/
        Label lbl = new Label("Хэрэглэгчийн Нэвтрэх Хэсэг");
        lbl.setFont(new Font("Arial", 20));

        /*Хэрэглэгчийн нэрээ оруулах талбар*/
        nerfld = new TextField();
        nerfld.setPromptText("Хэрэглэгчийн Нэр/Username");
        nerfld.setPrefSize(230, 30);

        /*Хэрэглэгчийн нууц үгээ оруулах талбар*/
        passfld = new PasswordField();
        passfld.setPromptText("Хэрэглэгчийн Нууц үг/Password");
        passfld.setPrefSize(230, 30);

        /*Хэрэглэгчийн нэр, нууц үгийг санана*/
        CheckBox box1 = new CheckBox("Намайг cана/Remember Me");
        box1.setPrefSize(200, 30);

        /*Шууд нэвтэрнэ*/
        CheckBox box2 = new CheckBox("Шууд нэвтрэх/Auto Login");
        box2.setPrefSize(200, 30);

        /*Нууц үгээ мартсан хэсэг, хулганаар даралт хийхэд нэмэлт цонх гарж ирнэ*/
        Label lbl2 = new Label("Нууц үгээ мартсан/Forget Password");
        lbl2.setStyle("-fx-text-fill:Blue;");
        lbl2.setPrefSize(200, 30);
        lbl2.setOnMousePressed(ae -> {
            lbl2.setStyle("-fx-text-fill:white;");
            Stage stage = new Stage();
            new PasswordReset().start(stage);
        });
        lbl2.setOnMouseMoved(ae -> {
            lbl2.setStyle("-fx-text-fill:RED;");
            myScene.setCursor(Cursor.HAND);
        });
        lbl2.setOnMouseExited(ae -> {
            myScene.setCursor(Cursor.DEFAULT);
            lbl2.setStyle("-fx-text-fill:Blue;");
        });

        /*Нэвтрэх button дээр дархад нэр нууц үг буруу байна гэсэн бичиг гарж ирнэ*/
        pnl = new Pane();
        pnl.setVisible(false);
        pnl.setPrefSize(200, 30);
        Label aa = new Label("Username or Password Incorrect");
        aa.setStyle("-fx-text-fill: #F21624;");
        aa.setPadding(new Insets(5.5));
        pnl.getChildren().addAll(aa);

        /*Нэвтрэх button*/
        Button btn = new Button("Нэвтрэх");
        btn.setStyle("-fx-background-color: #2C53BF; -fx-text-fill: white;");
        btn.setPrefSize(200, 40);
        btn.setOnAction(ae -> {
            shalgah();
            System.out.println("Newtreh towch");
        
        });

        /*Болих button*/
        Button btn2 = new Button("Болих");
        btn2.setStyle("-fx-background-color: #2C53BF; -fx-text-fill: white;");
        btn2.setPrefSize(200, 40);
        btn2.setOnAction(ae -> {
            myStage.close();
            
        });

        rootNode.requestFocus();
        rootNode.setStyle("-fx-background-color: #fff");
        rootNode.getChildren().addAll(lbl, pnl, nerfld, passfld, box1, box2, lbl2, btn, btn2);
    }
    
    public Scene getScene() {
        return this.myScene;
    }
     public void shalgah(){
        
           String nerutga = nerfld.getText();
           String passutga = passfld.getText();
           
           ClientTest.shalgah();
            

       try {
    	   ClientTest.dos.writeObject(nerutga);
    	   ClientTest.dos.writeObject(passutga);
    	   
//           ClientTest.dos.writeUTF(nerutga);      
//           ClientTest.dos.writeUTF(passutga);
    	   
    	   String boov = null;
           try {
	           boov = ClientTest.dis.readObject().toString();
	           } 
           catch (ClassNotFoundException ex) {
           }
           
//           String boov = ClientTest.dis.readUTF();
       
           if(boov.equals("true")) {
               StudentAdd.studentnemeh();
           } else if (boov.equals("false")) {
               pnl.setVisible(true);
          }
               } catch (IOException ex) {
       }
    }
}

