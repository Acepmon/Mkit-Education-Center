package teacher.ui;

import java.util.ArrayList;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import teacher.controller.ServerConnection;
import teacher.login.ui.CustomerLogin;

public class Ners {

    private FlowPane rigthFp, listname;
    private Button send, edit;
    public static final ObservableList<FlowPane> outan = FXCollections.observableArrayList();

    public Ners() {

////////////////////////////ObservableList oruulsan
        ArrayList<String> StudentName = (ArrayList<String>) ServerConnection.RequestAjluulah("getTeacherStudentProfile", CustomerLogin.getTmp_username());
        rigthFp = new FlowPane();
        rigthFp.setPrefSize(270, 708);
        rigthFp.setHgap(20);
        rigthFp.setAlignment(Pos.TOP_CENTER);
        rigthFp.setStyle("-fx-background-color: white; -fx-border-color: #B3B3B3; -fx-border-image-width: 2px;");
        rigthFp.setPadding(new Insets(0, 10, 10, 0));

        send = new Button("Илгээх");
        send.setPrefSize(80, 20);
        send.setFont(javafx.scene.text.Font.font("Arial", 12));
        send.setId("btns1");

        edit = new Button("Засах");
        edit.setPrefSize(80, 20);
        edit.setFont(javafx.scene.text.Font.font("Arial", 12));
        edit.setId("btns1");

        FlowPane hoyr = new FlowPane(send);
        hoyr.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 5px;");
        hoyr.setPrefSize(300, 60);
        hoyr.setAlignment(Pos.CENTER);
        hoyr.setVgap(20);
        hoyr.setHgap(20);
        hoyr.setId("text");

        listname = new FlowPane(0, 10);
//        listname.setHgap();
        listname.setPrefSize(250, 600);
        listname.setId("panel");
        listname.setAlignment(Pos.CENTER);
        listname.setMargin(edit, new Insets(10, 10, 10, 10));
        listname.setStyle("-fx-background-insets: 0; -fx-border-style: none; -fx-border-color: transparent; -fx-outline: none;");
        listname.setPadding(new Insets(0, 10, 10, 10));

        ListView listView = new ListView(outan);
        listView.setEditable(false);
        listView.setPrefSize(230, 500);
        listView.setStyle("-fx-background-insets: 0; -fx-border-style: none; -fx-border-color: black; -fx-outline: none;");

        Label ners = new Label("Нэрс");
        ners.setFont(javafx.scene.text.Font.font("Arial", 14));
        ners.setStyle("-fx-text-fill: black");
        ners.setPrefSize(120, 20);
        ners.setPadding(new Insets(5, 15, 10, 0));
        ners.setAlignment(Pos.CENTER);

        ObservableList<String> nersn = FXCollections.observableArrayList();
        ArrayList<String> names = resdneesNerSalgah(StudentName);
        ArrayList<String> emails = resdneesEmailSalgah(StudentName);
        for (int i = 0; i < names.size(); i++) {
            nersn.add(names.get(i));
            FlowPane flowpane = new FlowPane();

            CheckBox check = new CheckBox();
            Label label = new Label(names.get(i));

            label.setOnMousePressed(ae -> {
                if (check.isSelected()) {
                    check.setSelected(false);
                } else {
                    check.setSelected(true);
                }
            });
            Label emailL = new Label(emails.get(i));
            emailL.setPrefSize(0, 0);
            emailL.setVisible(false);

            flowpane.getChildren().addAll(check, label, emailL);
            flowpane.setPrefWidth(40);
            flowpane.setAlignment(Pos.CENTER_LEFT);
            flowpane.setPadding(new Insets(3, 3, 3, 3));
            flowpane.setStyle("-fx-background-color: #E6E6E6; -fx-border-width: 0px 7px 0px 7px; -fx-border-color: #99CC66; -fx-border-radius: 0px");
            outan.add(flowpane);
        }

        Label all = new Label("Бүгдийг сонгох");
        all.setPrefSize(150, 20);

        CheckBox c = new CheckBox();
        c.setOnAction(ae -> {
            for (int i = 0; i < outan.size(); i++) {

                if (c.isSelected()) {
                    ((CheckBox) outan.get(i).getChildren().get(0)).setSelected(true);
                } else {
                    ((CheckBox) outan.get(i).getChildren().get(0)).setSelected(false);
                }
            }

        });
        send.setOnAction(ae -> {
            String selected = "";
            for (FlowPane flow : outan) {
                if (((CheckBox) flow.getChildren().get(0)).isSelected()) {
                    String name = ((Label) flow.getChildren().get(1)).getText();
                    String email = ((Label) flow.getChildren().get(2)).getText();
                    System.out.println("\nName : " + name + "\nEmail : " + email + "\n\n");
                    selected += email + ",";

                }
            }

            selected = selected.substring(0, selected.lastIndexOf(","));
            System.out.println("\n" + selected);
            String body = DaalgavarSend.tailbararea.getText() + "\n Сүүлийн хугацаа: " + DaalgavarSend.time1.getValue();
            SendMail(DaalgavarSend.toonii.getText(), DaalgavarSend.zamfld.getText(), DaalgavarSend.garchig.getText(), body, selected);
        });

///////////////////////////////ObservableList oruulsan
        listname.getChildren().add(ners);
        listname.getChildren().addAll(listView, new Label(" "), c, all);

        rigthFp.getChildren().add(hoyr);
        rigthFp.getChildren().add(listname);

    }

    public FlowPane getContainer() {
        return this.rigthFp;
    }

    private ArrayList<String> resdneesNerSalgah(ArrayList<String> StudentName) {
        ArrayList<String> nersn = new ArrayList<>();
        for (String res : StudentName) {
            String[] split = res.split("::");
            nersn.add(split[3]);
        }
        return nersn;
    }

    private ArrayList<String> resdneesEmailSalgah(ArrayList<String> StudentName) {
        ArrayList<String> nersn = new ArrayList<>();
        for (String res : StudentName) {
            String[] split = res.split("::");
            nersn.add(split[6]);
        }
        return nersn;
    }

    public void SendMail(String filename, String filepath, String subject, String body, String toCC) {

        final String username = "teachers.mkit@gmail.com";
        final String password = "MKiTteachers20140401";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("teachers.mkit@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toCC));
            message.setSubject(subject);

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filepath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            messageBodyPart.setText(body);
            messageBodyPart.setHeader(body, "");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Alert alerts = new Alert(Alert.AlertType.INFORMATION);
            Transport.send(message);
            alerts.setHeaderText("Successfully Sent!");
            alerts.show();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
