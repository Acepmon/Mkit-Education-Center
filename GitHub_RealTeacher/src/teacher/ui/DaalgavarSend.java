package teacher.ui;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private Label daalgavarname, zamzaah, tailbarbichih, svvliint, daalgavaryaw, garchiglbl;
    public static TextField toonii, zamfld, svvliinfld, garchig;
    public static TextArea tailbararea;
    private BorderPane rootNode;
    private Button zaah, onsar;
    public static DatePicker time1;
    FileChooser filechooser;
    File file;
    private final String pattern = "yyyy/MM/dd";

    public DaalgavarSend() {

        rootNode = new BorderPane();

        pnl = new GridPane();

        daalgavarname = new Label("Файлын нэр:");
        daalgavarname.setFont(new Font("Arial", 15));
        daalgavarname.setId("daalgavar_send_label");
        daalgavarname.setPadding(new Insets(5, 5, 5, 5));
        zamzaah = new Label("Файлын зам зааж өгөх:");
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

        garchiglbl = new Label("Гарчиг");
        garchiglbl.setFont(new Font("Arial", 15));
        garchiglbl.setPadding(new Insets(5, 5, 5, 5));

        daalgavaryaw = new Label("Даалгавар явуулах");
        daalgavaryaw.setAlignment(Pos.CENTER);
        daalgavaryaw.setPrefSize(740, 60);
        daalgavaryaw.setFont(javafx.scene.text.Font.font("Arial", 18));
        daalgavaryaw.setStyle("-fx-text-fill: #666666; -fx-background-color: #E6E6E6;");

        garchig = new TextField();
        garchig.setPromptText("Гарчиг");
        garchig.setId("daalgavar_send_textf");
        garchig.setMaxHeight(25);
        garchig.setMaxWidth(240);
        garchig.setStyle("-fx-background-insets: 0;");

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

        time1 = new DatePicker();
        time1.setValue(LocalDate.now());

        zaah = new Button("Заах");
        zaah.setId("btns1");
        zaah.setOnAction((ActionEvent arg) -> {
            try {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All files", "*.*");
                fileChooser.getExtensionFilters().addAll(allFilter);
                file = fileChooser.showOpenDialog(null);
                zamfld.setText("" + file.getPath());
                toonii.setText(file.getName());

            } catch (NullPointerException e) {
                System.out.println("NullPointer");
            }
        });

        DatePicker checkInDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());
        checkInDatePicker.setPrefSize(240, 20);
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

        pnl.add(new Label(""), 0, 0);
        pnl.add(new Label(""), 0, 1);
        pnl.add(garchiglbl, 0, 2);
        pnl.add(garchig, 0, 3);
        pnl.add(new Label(""), 0, 4);
        pnl.add(daalgavarname, 0, 5);
        pnl.add(toonii, 0, 6);
        pnl.add(new Label(""), 0, 7);
        pnl.add(zamzaah, 0, 8);
        pnl.add(zam, 0, 9);
        pnl.add(new Label(""), 0, 10);
        pnl.add(tailbarbichih, 0, 11);
        pnl.add(tailbararea, 0, 12);
        pnl.add(new Label(""), 0, 13);
        pnl.add(svvliint, 0, 14);
        pnl.add(onsar1, 0, 15);

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
