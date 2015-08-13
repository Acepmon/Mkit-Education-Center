package teacher.launch;

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
import teacher.login.model.IPFeature;
import teacher.login.ui.CustomerLogin;
import teacher.ui.*;

public class Launcher extends Application implements teacher.config.Config {

    private static Scene defaultScene;
    private static Stage stage;

    private static TeacherMain TEACHER;

    private static Shalgah_left SHALGAH_LEFT;

    private static Shalgah_right SHALGAH_RIGHT;
    private static Shalgah_Center SHALGAH_CENTER;
    private static CustomerLogin LOGIN;
    private static HomeworkResived HOMEWORKRESIVED;
    private static DaalgavarSend DAALGAVARSEND;
    private static Homework HOMEWORK;
    private static Huvaari HUVAARI;
    private static Inner_homework INNER_HOMEWORK;
    private static Inner_huvaari INNER_HUVAARI;
    private static Idevhi IDEVHI;
    private static Medeelel MEDEELEL;
    private static Ners NERS;
    private static HomeworkLastResived HOMEWORKLASTRESIVED;
    private static Tailan_left TAILAN_LEFT;
    private static Tailan_left_inner TAILAN_LEFT_INNER;
    private static Tailan_medeelel TAILAN_MEDEELEL;
    private static Daalgavarshalgah DAALGAVARSHALGAH;
    private static IrtsBurtgel IRTSBURTGEL;
    private static Stage logoutStage;
    public static ShalgaltDunOruulah SHALGALT_DUN;
    public static Duntoosoolol DUNTOOSOOLOL;
    public static Duntoosoolol.Dunright DUNRIGHT;
    private static DunTootsooDaalgawar DUNTOOTSOO_DAALGAWAR;
    private static DunTootsooIdewhi DUNTOOTSOO_IDEWHI;
    private static DunTootsooIrts DUNTOOTSOO_IRTS;
    private static DunTootsooShalgalt DUNTOOTSOO_SHALGALT;
    public static TeacherProfile TEACHER_PROFILE;
    public static DaalgavarShalgahDun DAALGAVARSHALGAHDUN;
    public static DaalgavarShalgahDunOruulah DAALGAVARSHALGAHDUNORUULAH;
    public static final String dirPath = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images";

    @Override
    public void start(Stage primaryStage) {
        IPFeature.readFeature();
        stage = primaryStage;

        logoutStage = new Stage();

        LOGIN = new CustomerLogin(Launcher.getStage());
        defaultScene = LOGIN.getScene();

        stage.setTitle(STAGE_TITLE);
        stage.setResizable(RESIZABLE);
        stage.setMaximized(MAXIMIZABLE);
        stage.setScene(defaultScene);
        stage.show();
    }

    public static void initialize() {
        TEACHER_PROFILE = new TeacherProfile();
        DUNTOOTSOO_SHALGALT = new DunTootsooShalgalt();
        DUNTOOTSOO_IRTS = new DunTootsooIrts();
        DUNTOOTSOO_IDEWHI = new DunTootsooIdewhi();
        DUNTOOTSOO_DAALGAWAR = new DunTootsooDaalgawar();
        DUNRIGHT = new Duntoosoolol().dunright;
        DUNTOOSOOLOL = new Duntoosoolol();
        SHALGALT_DUN = new ShalgaltDunOruulah();
        DAALGAVARSHALGAHDUN = new DaalgavarShalgahDun();
        DAALGAVARSHALGAHDUNORUULAH = new DaalgavarShalgahDunOruulah();
        SHALGAH_LEFT = new Shalgah_left();
        SHALGAH_RIGHT = new Shalgah_right();
        SHALGAH_CENTER = new Shalgah_Center();
        DAALGAVARSHALGAH = new Daalgavarshalgah();
        IRTSBURTGEL = new IrtsBurtgel();
        TAILAN_MEDEELEL = new Tailan_medeelel();
        TAILAN_LEFT_INNER = new Tailan_left_inner();
        TAILAN_LEFT = new Tailan_left();
        INNER_HOMEWORK = new Inner_homework();
        INNER_HUVAARI = new Inner_huvaari();
        HOMEWORKRESIVED = new HomeworkResived();
        DAALGAVARSEND = new DaalgavarSend();
        HOMEWORK = new Homework();
        HUVAARI = new Huvaari();
        IDEVHI = new Idevhi();
        MEDEELEL = new Medeelel();
        NERS = new Ners();
        HOMEWORKLASTRESIVED = new HomeworkLastResived();
        TEACHER = new TeacherMain();
    }

    public static IrtsBurtgel getIRTSBURTGEL() {
        return IRTSBURTGEL;
    }

    public static DunTootsooDaalgawar getDUNTOOTSOO_DAALGAWAR() {
        return DUNTOOTSOO_DAALGAWAR;
    }

    public static DunTootsooIdewhi getDUNTOOTSOO_IDEWHI() {
        return DUNTOOTSOO_IDEWHI;
    }

    public static DunTootsooIrts getDUNTOOTSOO_IRTS() {
        return DUNTOOTSOO_IRTS;
    }

    public static DunTootsooShalgalt getDUNTOOTSOO_SHALGALT() {
        return DUNTOOTSOO_SHALGALT;
    }

    public static TeacherProfile getTEACHER_PROFILE() {
        return TEACHER_PROFILE;
    }

    public static Duntoosoolol.Dunright getDUNRIGHT() {
        return DUNRIGHT;
    }

    public static Idevhi getIDEVHI() {
        return IDEVHI;
    }

    public static Duntoosoolol getDUNTOOSOOLOL() {
        return DUNTOOSOOLOL;
    }

    public static ShalgaltDunOruulah getSHALGALT_DUN() {
        return SHALGALT_DUN;
    }

    public static void setLOGIN(CustomerLogin LOGIN) {
        Launcher.LOGIN = LOGIN;
    }

    public static Shalgah_right getSHALGAH_RIGHT() {
        return SHALGAH_RIGHT;
    }

    public static Shalgah_Center getSHALGAH_CENTER() {
        return SHALGAH_CENTER;
    }

    public static Shalgah_left getSHALGAH_LEFT() {
        return SHALGAH_LEFT;
    }

    public static Stage getLogoutStage() {
        return logoutStage;
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
        receiveFiles();
        launch(args);

    }

    public static void receiveFiles() throws IOException {
        String ip = IPFeature.ip;
        int port = 5050;
        File dir = new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\" + "Edu-Center\\Images");
        dir.mkdirs();
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

    public static Scene getDefaultScene() {
        return defaultScene;
    }

    public static Daalgavarshalgah getDAALGAVARSHALGAH() {
        return DAALGAVARSHALGAH;
    }

    public static DaalgavarShalgahDun getDAALGAVARSHALGAHDUN() {
        return DAALGAVARSHALGAHDUN;
    }

    public static DaalgavarShalgahDunOruulah DAALGAVARSHALGAHDUNORUULAH() {
        return DAALGAVARSHALGAHDUNORUULAH;
    }

    public static TeacherMain getTEACHER() {
        return TEACHER;
    }

    public static CustomerLogin getLOGIN() {
        return LOGIN;
    }

    public static HomeworkResived getHOMEWORKRESIVED() {
        return HOMEWORKRESIVED;
    }

    public static IrtsBurtgel getDUNORUULAH() {
        return IRTSBURTGEL;
    }

    public static DaalgavarSend getDAALGAVARSEND() {
        return DAALGAVARSEND;
    }

    public static Homework getHOMEWORK() {
        return HOMEWORK;
    }

    public static Huvaari getHUVAARI() {
        return HUVAARI;
    }

    public static Inner_homework getINNER_HOMEWORK() {
        return INNER_HOMEWORK;
    }

    public static Inner_huvaari getINNER_HUVAARI() {
        return INNER_HUVAARI;
    }

    public static Medeelel getMEDEELEL() {
        return MEDEELEL;
    }

    public static Ners getNERS() {
        return NERS;
    }

    public static HomeworkLastResived getHOMEWORKLASTRESIVED() {
        return HOMEWORKLASTRESIVED;
    }

    public static Tailan_left getTAILAN_LEFT() {
        return TAILAN_LEFT;
    }

    public static Tailan_left_inner getTAILAN_LEFT_INNER() {
        return TAILAN_LEFT_INNER;
    }

    public static Tailan_medeelel getTAILAN_MEDEELEL() {
        return TAILAN_MEDEELEL;
    }

}
