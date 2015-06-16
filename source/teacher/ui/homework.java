package teacher.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import teacher.launch.Launcher;

public class Homework {
    
    private FlowPane rightFp;
        File myfiles;
    Socket sock = null;
    
    public Homework(){
        
        rightFp = new FlowPane(20,20);
        rightFp.setPrefSize(250, 708);
        rightFp.setStyle("-fx-background-color: #F6F6F7");
        rightFp.setAlignment(Pos.TOP_CENTER);
         
        Label nameLbl = new Label("Ирсэн даалгавар");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(270, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 5px;");
        nameLbl.setId("text");
  
        FlowPane textFp = new FlowPane(10,5);
        textFp.setPrefSize(200, 150);
        
        
        Label irtsLb = new Label("Даалгавар шалгах");
        irtsLb.setPrefSize(200, 20);
        irtsLb.setAlignment(Pos.CENTER);
        irtsLb.setId("btns");
        irtsLb.setOnMousePressed(ae -> {
//            TeacherMain.changeLeft(null);
            TeacherMain.changeRight(null);
            TeacherMain.changeLeft(Launcher.getHOMEWORK().getContainer());
            TeacherMain.changeCenter(Launcher.getCENTER().getContainer());
        });
        
        Label dunLb = new Label("Даалгавар илгээх");
        dunLb.setPrefSize(200, 20);
        dunLb.setAlignment(Pos.CENTER);
        dunLb.setId("btns");
        dunLb.setOnMousePressed(ae -> {
            TeacherMain.changeLeft(null);
            TeacherMain.changeCenter(Launcher.getDAALGAVARSEND().getContainer());
            TeacherMain.changeRight(Launcher.getNERS().getContainer());
        });
        
        rightFp.setId("border");
        textFp.getChildren().addAll(irtsLb,dunLb);
        rightFp.getChildren().addAll(nameLbl, new Inner_homework().getContainer(), textFp);
    }
    public FlowPane getContainer() {
        return this.rightFp;
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
        myfiles = (File) ois.readObject();
        System.out.println("AbsolutePath: " + myfiles.getAbsolutePath());
        System.out.println("FileName: " + myfiles.getName());
        System.out.println("length: " + myfiles.length());
        String targetFileName = "C:\\Users\\JAVA M2\\Desktop\\"+myfiles.getName();
        System.out.println(targetFileName);
        System.out.println("File will be saved to: " + targetFileName);
        copyBytes(myfiles, targetFileName);
        
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