package ManagerPac;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    private static Scene defaultScene;
    private static Stage stage;
    private static Socket socket;
    private static AddStudent ADDSTUDENT;
    private static CustomerLogin LOGIN;
    private static Manager MANAGER;
    private static Admissions ADMISSIONS;
    private static Report REPORT;
    private static Student STUDENT;
    private static Teacher TEACHER;
    private static PasswordReset RESET;
    public static String dirPath;

    @Override
    public void start(Stage primaryStage) throws Exception {
        IPFeature.readFeature();
        stage = primaryStage;

        LOGIN = new CustomerLogin(Launcher.getStage());
        defaultScene = LOGIN.getScene();

        stage.setScene(defaultScene);
        stage.setResizable(false);
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setTitle("Менежер");
        stage.show();

        ADDSTUDENT = new AddStudent();
        STUDENT = new Student();
        REPORT = new Report();
        TEACHER = new Teacher();
        ADMISSIONS = new Admissions();
        MANAGER = new Manager();
    }

    public static void setScene(Scene scene) {
        if (scene != null) {
            stage.setScene(scene);
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(IPFeature.ip);
        receiveFiles();
        launch(args);

    }

    public static void receiveFiles() throws IOException {
        String ip = "" + IPFeature.ip;
        int port = 5050;
        File dir = new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\" + "Edu-Center\\Images");
        dir.mkdirs();
        dirPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images";
        socket = new Socket(ip, port);
        System.out.println(dirPath);
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

    public static Scene getDefaultScene() {
        return defaultScene;
    }

    public static Manager getMANAGER() {
        return MANAGER;
    }

    public static CustomerLogin getLOGIN() {
        return LOGIN;
    }

    public static PasswordReset getRESET() {
        return RESET;
    }

    public static Admissions getADMISSIONS() {
        return ADMISSIONS;
    }

    public static Teacher getTEACHER() {
        return TEACHER;
    }

    public static Student getSTUDENT() {
        return STUDENT;
    }

    public static AddStudent getADDSTUDENT() {
        return ADDSTUDENT;
    }

    public static Report getREPORT() {
        return REPORT;
    }
}
