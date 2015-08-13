package ManagerPac;

import Controller.ServerConnection;
import static ManagerPac.AddStudent.file;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UpdateTeacherImage {

    private ImageView imageView;
    private Image image;
    private Label browseLbl;

    private Label pictureNameLbl;
    private Label dot1;
    public static Label displayNameLbl;

    private Label picturePathLbl;
    private Label dot2;
    private Label displayPathLbl;

    private Button storeBtn;

    public void start(Stage stage) {
        Pane pane = new Pane();

        imageView = new ImageView();
        imageView.setFitHeight(90);
        imageView.setFitWidth(90);
        imageView.setLayoutX(25);
        imageView.setLayoutY(25);

        image = new Image("file:///" + System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Edu-Center\\Images" + "\\" + ServerConnection.Request("getTeacherImage", ((TeacherObj) Teacher.tableView.getSelectionModel().getSelectedItem()).getId()));
        imageView.setImage(image);

        browseLbl = new Label("Зураг сонгох");
        browseLbl.setFont(Font.font("Verdana", 10));
        browseLbl.setPrefSize(90, 25);
        browseLbl.setLayoutX(25);
        browseLbl.setLayoutY(115);
        browseLbl.setId("browseLbl");
        browseLbl.setOnMouseClicked(ae -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All files", "*.*");
            fileChooser.getExtensionFilters().addAll(allFilter);
            file = fileChooser.showOpenDialog(null);
            displayPathLbl.setText("" + file.toString());
            displayNameLbl.setText("" + file.getName());
            String stfile = "file:///" + file;
            displayNameLbl.setText(file.getName());
            imageView.setImage(new Image(stfile));
            Teacher.imageView.setImage(new Image(stfile));
        });

        pictureNameLbl = new Label("Зургийн нэр");
        pictureNameLbl.setFont(Font.font("Verdana", 15));
        pictureNameLbl.setLayoutX(130);
        pictureNameLbl.setLayoutY(35);

        dot1 = new Label(":");
        dot1.setFont(Font.font("Verdana", 15));
        dot1.setLayoutX(230);
        dot1.setLayoutY(35);

        storeBtn = new Button("Хадгалах");
        storeBtn.setOnAction(ae -> {
            try {
                Socket sk = new Socket(IPFeature.ip, 4040);
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

                }
            } catch (IOException | HeadlessException ex) {
                ex.printStackTrace();

            }

            try {
                Launcher.receiveFiles();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage.close();
        });
        storeBtn.setLayoutX(500);
        storeBtn.setLayoutY(120);
        storeBtn.setId("iphone");
        storeBtn.setPrefSize(100, 30);
        storeBtn.setFont(Font.font("Verdana", 15));

        displayNameLbl = new Label();
        displayNameLbl.setLayoutX(240);
        displayNameLbl.setLayoutY(37);

        picturePathLbl = new Label("Зургийн зам");
        picturePathLbl.setFont(Font.font("Verdana", 15));
        picturePathLbl.setLayoutX(130);
        picturePathLbl.setLayoutY(90);

        dot2 = new Label(":");
        dot2.setFont(Font.font("Verdana", 15));
        dot2.setLayoutX(230);
        dot2.setLayoutY(90);

        displayPathLbl = new Label();
        displayPathLbl.setLayoutX(240);
        displayPathLbl.setLayoutY(92);

        pane.getChildren().addAll(
                imageView,
                browseLbl,
                pictureNameLbl,
                dot1,
                displayNameLbl,
                picturePathLbl,
                dot2,
                displayPathLbl,
                storeBtn
        );

        Scene scene = new Scene(pane, 600, 150);
        scene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
        stage.setTitle("Зураг оруулах");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
