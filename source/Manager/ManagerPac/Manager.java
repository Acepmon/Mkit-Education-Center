package ManagerPac;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Manager {

    File myFiles;
    Socket sock=null;

    private Scene scene;
    
    MenuBar menuBar;
    Menu managerMenu;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Manager() {
        Pane pane = new Pane();
        scene = new Scene(pane, 1024, 768, Color.WHITE);
        HBox hbox = addHBox();
        hbox.setLayoutX(720);
        hbox.setLayoutY(5);

        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(1024, 768);

        Tab tabProgram = new Tab("Хөтөлбөр");
        tabProgram.setId("program_tab");
        tabProgram.setOnSelectionChanged(ae -> {
            tabProgram.setContent(Launcher.getPROGRAM().getProgramPane());
        });

        Tab tabTeacher = new Tab("Багш");
        tabTeacher.setId("teacher_tab");
        tabTeacher.setOnSelectionChanged(ae -> {
            tabTeacher.setContent(Launcher.getTEACHER().getTeacherPane());
        });

        Tab tabStudent = new Tab("Оюутан");
        tabStudent.setId("student_tab");
        tabStudent.setOnSelectionChanged(ae -> {
            tabStudent.setContent(Launcher.getSTUDENT().getStudentPane());
        });

        Tab tabReport = new Tab("Тайлан");
        tabReport.setId("report_tab");
        tabReport.setOnSelectionChanged(ae -> {
            tabReport.setContent(Launcher.getREPORT().getReportPane());
        });

        tabProgram.setClosable(false);
        tabTeacher.setClosable(false);
        tabStudent.setClosable(false);
        tabReport.setClosable(false);

        tabPane.getTabs().addAll(tabProgram, tabTeacher, tabStudent, tabReport);

        pane.getChildren().addAll(tabPane, hbox);

        scene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(0, 5, 0, 3));
        
        Label managerNameLbl = new Label("Менежерийн нэр :");
        managerNameLbl.setPrefSize(120, 25);
        
        menuBar=new MenuBar();
        menuBar.setPrefSize(110, 25);
        
        managerMenu=new Menu();
        managerMenu.setText("");
        
        MenuItem settings=new MenuItem("Хувийн мэдээлэл");
        settings.setOnAction(ae-> {
            Stage managerStage=new Stage();
            ManagerProfile managerProfile=new ManagerProfile();
            managerProfile.start(managerStage);
        });
        
        MenuItem other=new MenuItem("Бусад");
        other.setOnAction(ae-> {
            
        });
        
        MenuItem exit=new MenuItem("Гарах");
        exit.setOnAction(ae-> {
            int answer=JOptionPane.showConfirmDialog(null, "Гарах уу?");
            if(answer==JOptionPane.YES_OPTION) {
                Launcher.getStage().close();
            }
        });
        
        managerMenu.getItems().addAll(settings, other, exit);
        
        menuBar.getMenus().add(managerMenu);
        
        hbox.getChildren().addAll(managerNameLbl, menuBar);
        return hbox;
    }
    
    public void changeUsernameOfMenu(String str) {
        this.managerMenu.setText(str);
    }
    
    public void receiveFileFromServer() throws ClassNotFoundException, IOException {
        String host = "192.168.0.189";
        int port = 5050;
        try {
            sock = new Socket(host, port);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Connection made (clientSide)");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(sock.getInputStream());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        myFiles = (File) ois.readObject();
        System.out.println("AbsolutePath: " + myFiles.getAbsolutePath());
        System.out.println("FileName: " + myFiles.getName());
        System.out.println("length: " + myFiles.length());
        String targetFileName = "C:\\Users\\JAVA M2\\Desktop\\"+myFiles.getName();
        System.out.println(targetFileName);
        System.out.println("File will be saved to: " + targetFileName);
        copyBytes(myFiles, targetFileName);
        
    }
    private void copyBytes(File originalFile, String targetFileName) throws IOException {
        InputStream in;
        FileOutputStream out;
        in = sock.getInputStream();
        out = new FileOutputStream(targetFileName);
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        out.close();
        in.close();
    }
}
