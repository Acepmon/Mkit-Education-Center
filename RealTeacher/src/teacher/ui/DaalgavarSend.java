package teacher.ui;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;

public class DaalgavarSend {

    private GridPane pnl;
    private FlowPane flowp;
    private Label daalgavarname, zamzaah, tailbarbichih, svvliint, daalgavaryaw;
    private TextField toonii, zamfld, svvliinfld;
    private TextArea tailbararea;
    private BorderPane rootNode;
    private Button zaah, onsar;
    private DatePicker time1;
    FileChooser filechooser;
    File file;
    private final String pattern = "yyyy/MM/dd";

    public DaalgavarSend() {

        rootNode = new BorderPane();
        pnl = new GridPane();

        daalgavarname = new Label("Даалгаврын нэр:");
        daalgavarname.setFont(new Font("Arial", 15));
        daalgavarname.setId("daalgavar_send_label");
        daalgavarname.setPadding(new Insets(5, 5, 5, 5));
        zamzaah = new Label("Даалгаврын замыг зааж өгөх:");
        zamzaah.setFont(new Font("Arial", 15));
        zamzaah.setId("daalgavar_send_label");
        zamzaah.setPadding(new Insets(5, 5, 5, 5));
        tailbarbichih = new Label("Тайлбар бичих:");
        tailbarbichih.setFont(new Font("Arial", 15));
        tailbarbichih.setId("daalgavar_send_label");
        tailbarbichih.setPadding(new Insets(5, 5, 5, 5));
        svvliint = new Label("Сүүлийн хугацаа:");
        svvliint.setFont(new Font("Arial", 15));
        svvliint.setId("daalgavar_send_label");
        svvliint.setPadding(new Insets(5, 5, 5, 5));

        daalgavaryaw = new Label("Даалгавар явуулах");
        daalgavaryaw.setAlignment(Pos.CENTER);
        daalgavaryaw.setPrefSize(740, 60);
        daalgavaryaw.setFont(javafx.scene.text.Font.font("Arial", 18));
        daalgavaryaw.setStyle("-fx-text-fill: #666666; -fx-background-color: #E6E6E6;");

        toonii = new TextField();
        toonii.setPromptText("Тооны машин");
        toonii.setId("daalgavar_send_textf");
        toonii.setMaxHeight(25);
        toonii.setMaxWidth(240);
        toonii.setStyle("-fx-background-insets: 0;");

        zamfld = new TextField();
        zamfld.setId("daalgavar_send_textf");
        zamfld.setPrefSize(200, 60);
        zamfld.setStyle("-fx-background-insets: 0;");
        zamfld.setMaxHeight(25);

        tailbararea = new TextArea();
        tailbararea.setId("daalgavar_send_textf");
        tailbararea.setMaxWidth(240);
        tailbararea.setStyle("-fx-background-insets: 0;");
        svvliinfld = new TextField();
        svvliinfld.setPromptText("---- оны -- сарын -- өдөр дуусна.");
        svvliinfld.setId("daalgavar_send_textf");
        svvliinfld.setStyle("-fx-background-insets: 0;");
        svvliinfld.setMaxHeight(25);

        Image img = new Image("teacher/resource/true.png", true);
        ImageView image = new ImageView();
        image.setImage(img);
        image.setSmooth(true);
        image.setPreserveRatio(true);
        image.setFitHeight(20);

        HBox pictureRegion = new HBox(image);
        pictureRegion.setId("daalgavar_send_image");

        Image img1 = new Image("teacher/resource/true.png", true);
        ImageView image1 = new ImageView();
        image1.setImage(img1);
        image1.setSmooth(true);
        image1.setPreserveRatio(true);
        image1.setFitHeight(20);

        HBox pictureRegion1 = new HBox();
        pictureRegion1.getChildren().add(image1);
        pictureRegion1.setId("daalgavar_send_image");

        Image img2 = new Image("teacher/resource/false.png", true);
        ImageView image2 = new ImageView();
        image2.setImage(img2);
        image2.setSmooth(true);
        image2.setPreserveRatio(true);
        image2.setFitHeight(20);

        HBox pictureRegion2 = new HBox();
        pictureRegion2.getChildren().add(image2);
        pictureRegion2.setId("daalgavar_send_image");

        Image img3 = new Image("teacher/resource/true.png", true);
        ImageView image3 = new ImageView();
        image3.setImage(img3);
        image3.setSmooth(true);
        image3.setPreserveRatio(true);
        image3.setFitHeight(20);

        HBox pictureRegion3 = new HBox();
        pictureRegion3.getChildren().add(image3);
        pictureRegion3.setId("daalgavar_send_image");

        time1 = new DatePicker();
        time1.setValue(LocalDate.now());

        zaah = new Button("Заах");
        zaah.setId("btns1");
        zaah.setOnAction((ActionEvent arg) -> {
            try {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("RAR files (*.rar)", "*.rar");
                FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All files", "*.*");
                fileChooser.getExtensionFilters().addAll(extFilter, allFilter);
                file = fileChooser.showOpenDialog(null);
                zamfld.setText("" + file);
                zamfld.setText(file.getName());

            } catch (NullPointerException e) {
                System.out.println("NullPointer");
            }
        });

        DatePicker checkInDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter
                    = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        checkInDatePicker.setConverter(converter);
        checkInDatePicker.setPromptText(pattern.toLowerCase());

        onsar = new Button("Он сар өдөр");
        onsar.setId("btns1");
        onsar.setOnMousePressed(ae -> {



        });

        FlowPane zam = new FlowPane(zamfld, zaah);
        zam.setMaxWidth(250);
        FlowPane onsar1 = new FlowPane(checkInDatePicker);
        onsar1.setMaxWidth(250);

//        pnl.add(daalgavaryaw, 0, 0, 2, 1);
        pnl.add(daalgavarname, 0, 1);
        pnl.add(toonii, 0, 2);
        pnl.add(zamzaah, 0, 3);
        pnl.add(zam, 0, 4);
        pnl.add(tailbarbichih, 0, 5);
        pnl.add(tailbararea, 0, 6);
        pnl.add(svvliint, 0, 7);
        pnl.add(onsar1, 0, 8);
        pnl.add(pictureRegion, 1, 2);
        pnl.add(pictureRegion1, 1, 4);
        pnl.add(pictureRegion2, 1, 6);
        pnl.add(pictureRegion3, 1, 8);

//        pnl.add(zaah, 1, 3);
//        pnl.add(onsar, 1, 7);
        pnl.setPadding(new Insets(0, 10, 10, 30));
        pnl.setPrefSize(510, 708);
        tailbararea.setWrapText(true);

        FlowPane flowp = new FlowPane();
        flowp.setPadding(new Insets(0, 0, 5, 0));
        flowp.getChildren().addAll(daalgavaryaw, pnl);
        flowp.setAlignment(Pos.CENTER);
        flowp.setStyle("-fx-background-color: white");
        flowp.setId("border");

        rootNode.setTop(flowp);
        pnl.setStyle("-fx-background-color: white;");
    }

    public BorderPane getContainer() {
        return this.rootNode;
    }

}
