package test;

import admin.ui.AdminUI;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.ui.CustomerLogin;
import login.model.IPFeature;

public class Tester extends Application {

    public static double stage_x;
    public static double stage_y;

    private static Stage stage;
    public static admin.ui.AdminUI admin;
    public static CustomerLogin login;

    @Override
    public void start(Stage primaryStage) throws Exception {
        IPFeature.readFeature();
        stage = primaryStage;
        login = new CustomerLogin(stage);
        admin = new AdminUI();
        stage_x = stage.getX();
        stage_y = stage.getY();

        stage.setScene(login.getScene());
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        receiveFiles();
        launch(args);
    }

    public static void setScene(Scene scene) {
        stage.setScene(scene);
    }

    public static void receiveFiles() throws IOException {
        String ip = IPFeature.ip;
        int port = 5050;
        File dir = new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\" + "Edu-Center\\Images");
        dir.mkdirs();
        String dirPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images";
        Socket socket = new Socket(ip, port);
        System.out.println("Successfully connected to Server!");
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        DataInputStream dis = new DataInputStream(bis);
        int filesCount = dis.readInt();
        File[] files = new File[filesCount];
        for (int i = 0; i < filesCount; i++) {
            long fileLength = dis.readLong();
            String fileName = dis.readUTF();
            files[i] = new File(dirPath + "\\" + fileName);
            FileOutputStream fos = new FileOutputStream(files[i]);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            for (int j = 0; j < fileLength; j++) {
                bos.write(bis.read());
            }
            bos.close();
        }
        System.out.println("Files will be saved to: " + dirPath);
        dis.close();
    }
}
