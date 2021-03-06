package student.ui;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import student.login.CustomerLogin;

public class Homework {

    private Pane homeworkpane;
    FileChooser fileChooser;
    File file;
    String fileNames;
    TextField uploadfld;
    File myfiles;
    Socket sock = null;

    public Homework() {
        homeworkpane = new Pane();
        homeworkpane.setPadding(new Insets(25, 25, 25, 25));
        homeworkpane.setStyle("-fx-background:transparent");

        Label title = new Label("Файл илгээх");
        title.setStyle("-fx-text-fill :#009688");
        title.setFont(Font.font("Roboto-Regular", FontWeight.BOLD, 30));
        title.setPrefSize(240, 20);
        title.setLayoutY(25);
        title.setLayoutX(50);

        Label lbl = new Label("Файлын нэр");
        lbl.setStyle("-fx-font: 22 roboto;" + "-fx-text-fill: black;");
        lbl.setLayoutX(50);
        lbl.setLayoutY(140);

        TextField nerField = new TextField();
        nerField.setPrefSize(200, 35);
        nerField.setStyle("-fx-border-radius: 20px;" + "-fx-text-fill: black;");
        nerField.setLayoutX(420);
        nerField.setLayoutY(140);

        Label lbl2 = new Label("Хичээлийн төрөл");
        lbl2.setStyle("-fx-font: 22 roboto;" + "-fx-text-fill: black;");
        lbl2.setPrefSize(200, 20);
        lbl2.setLayoutX(50);
        lbl2.setLayoutY(200);

        ComboBox<String> myComboBox = new ComboBox<String>();
        myComboBox.getItems().addAll("Java", "Солонгос хэл", "C#");
        myComboBox.setStyle("-fx-font: 22 roboto;" + "-fx-text-fill: black;");
        myComboBox.setValue("Java");
        myComboBox.setLayoutX(420);
        myComboBox.setLayoutY(200);

        Label tailbarlbl = new Label("Тайлбар");
        tailbarlbl.setStyle("-fx-font: 22 roboto;" + "-fx-text-fill: black;");
        tailbarlbl.setLayoutX(50);
        tailbarlbl.setLayoutY(280);

        TextArea tailbar = new TextArea();
        tailbar.setPrefRowCount(10);
        tailbar.setPrefColumnCount(150);
        tailbar.setWrapText(true);
        tailbar.setEditable(true);
        tailbar.setPrefSize(400, 150);
        tailbar.setLayoutX(50);
        tailbar.setLayoutY(320);

        Button uploadbtn = new Button("Хуулах");
        uploadbtn.setPrefSize(150, 50);
        uploadbtn.setStyle("-fx-text-fill: black;");
        uploadbtn.setLayoutX(50);
        uploadbtn.setLayoutY(600);

        uploadfld = new TextField();
        uploadfld.setPrefSize(200, 35);
        uploadfld.setPrefColumnCount(10);
        uploadfld.setStyle("-fx-border-radius: 20px;" + "-fx-text-fill: black;");
        uploadfld.setLayoutX(50);
        uploadfld.setLayoutY(500);

        Button Choosebtn = new Button("Сонгох", new ImageView("student/resources/uploading18.png"));
        Choosebtn.setPrefSize(150, 35);
        Choosebtn.setStyle("-fx-background-color: transparent;");
        Choosebtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg) {
                fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("RAR files (*.rar)", "*.rar");
                FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All files", "*.*");
                fileChooser.getExtensionFilters().addAll(extFilter, allFilter);
                file = fileChooser.showOpenDialog(null);
                uploadfld.setText("" + file);
                nerField.setText(file.getName());
            }
        });
        Choosebtn.setLayoutX(290);
        Choosebtn.setLayoutY(500);

        Path path = new Path();
        path.getElements().add(new MoveTo(800.0f, 70.0f));
        path.getElements().add(new VLineTo(600.0f));
        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList("");
        list.setItems(items);
        list.setPrefSize(400, 500);
        list.setLayoutX(900);
        list.setLayoutY(120);
        Label lbl3 = new Label("    Өгсөн даалгаварууд");
        lbl3.setStyle("-fx-font: 22 roboto;" + "-fx-text-fill: black;");
        lbl3.setLayoutX(900);
        lbl3.setLayoutY(60);
        uploadbtn.setOnAction(ae -> {
            System.out.println(file.getName());
            try {
                Socket sk = new Socket("192.168.0.189", 4040);
                OutputStream output = sk.getOutputStream();
                OutputStreamWriter outputStream = new OutputStreamWriter(sk.getOutputStream());
                outputStream.write(file.getName() + "\n");
                outputStream.flush();
                BufferedReader inReader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                String serverStatus = inReader.readLine(); // Read the first line  
                if (serverStatus.equals("READY")) {
                    FileInputStream files = new FileInputStream(file);
                    byte[] buffer = new byte[sk.getSendBufferSize()];
                    int bytesRead = 0;
                    while ((bytesRead = files.read(buffer)) > 0) {
                        output.write(buffer, 0, bytesRead);
                    }
                    output.close();
                    files.close();
                    sk.close();
                    JOptionPane.showMessageDialog(null, "Transfer complete");
                }
            } catch (IOException | HeadlessException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        homeworkpane.getChildren().addAll(title, lbl, nerField, lbl2, myComboBox, tailbarlbl, tailbar, uploadbtn, uploadfld, Choosebtn, path, list, lbl3);
    }

    public Pane getHomeworkGridPane() {
        return this.homeworkpane;
    }

    public void receiveFileFromServer() throws ClassNotFoundException, IOException {
        String host = "192.168.0.189";
        int port = 5050;
        try {
            sock = new Socket(host,port);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Connection made (clientSide)");
        
        
        OutputStream os = sock.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        String fuck;
        fuck = ""+CustomerLogin.getFld().getText();
        bw.write(fuck);
        bw.flush();
        os.close();
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