package ManagerPac;

import Controller.ServerConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

public class AddAdmissions {

    private Label nameLbl;
    private Label descLbl;
    private Label startDateLbl;
    private Label endDateLbl;

    private TextField nameFld;
    private TextArea descArea;

    private DatePicker startPicker;
    private DatePicker endPicker;

    private String pattern = "yyyy-MM-dd";

    private Button addBtn;
    private Button cancelBtn;

    private String name;
    private String desc;
    private String end;
    private String start;
    private String insert;

    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        nameLbl = new Label("Элсэлтийн нэр");
        nameLbl.setPrefSize(150, 25);
        nameLbl.setFont(Font.font("Verdana", 14));
        nameLbl.setLayoutX(25);
        nameLbl.setLayoutY(30);

        descLbl = new Label("Тайлбар");
        descLbl.setPrefSize(150, 25);
        descLbl.setFont(Font.font("Verdana", 14));
        descLbl.setLayoutX(25);
        descLbl.setLayoutY(80);

        startDateLbl = new Label("Эхлэх огноо");
        startDateLbl.setPrefSize(150, 25);
        startDateLbl.setFont(Font.font("Verdana", 14));
        startDateLbl.setLayoutX(25);
        startDateLbl.setLayoutY(150);

        endDateLbl = new Label("Дуусах огноо");
        endDateLbl.setPrefSize(150, 25);
        endDateLbl.setFont(Font.font("Verdana", 14));
        endDateLbl.setLayoutX(25);
        endDateLbl.setLayoutY(200);

        nameFld = new TextField();
        nameFld.setPrefSize(150, 25);
        nameFld.setLayoutX(200);
        nameFld.setLayoutY(30);
        nameFld.setId("info");

        descArea = new TextArea();
        descArea.setPrefSize(150, 50);
        descArea.setLayoutX(200);
        descArea.setLayoutY(80);
        descArea.setWrapText(true);
        descArea.setId("info");

        /**
         * Creating date picker and converting date format "MM/DD/YYYY" to
         * "YYYY-MM-DD"
         */
        startPicker = new DatePicker(LocalDate.now());
        startPicker.setLayoutX(200);
        startPicker.setLayoutY(150);
        startPicker.setEditable(false);
        startPicker.setPrefSize(150, 25);
        startPicker.setPromptText(pattern.toLowerCase());
        startPicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

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
        });
        /**
         * Start date picker event
         */
        startPicker.setOnAction(ae -> {
            int year = startPicker.getValue().getYear();
            int month = startPicker.getValue().getMonthValue() + 4;
            if (month > 12) {
                year = year + 1;
                month = month - 12;
            }

            endPicker.setValue(LocalDate.of(year, month, startPicker.getValue().getDayOfMonth()));
        });

        /**
         * Creating date picker and converting date format "MM/DD/YYYY" to
         * "YYYY-MM-DD"
         */
        endPicker = new DatePicker(LocalDate.now());
        endPicker.setLayoutX(200);
        endPicker.setLayoutY(200);
        endPicker.setEditable(false);
        endPicker.setPrefSize(150, 25);
        endPicker.setPromptText(pattern.toLowerCase());
        endPicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

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
        });

        addBtn = new Button("Нэмэх");
        addBtn.setOnAction(ae -> {
            if (nameFld.getText().isEmpty()
                    || descArea.getText().isEmpty()) {
                Validation.textFieldValidation(nameFld);
                Validation.areaValidation(descArea);
            } else {
                int answer = JOptionPane.showConfirmDialog(null, "Нэмэх үү?");
                if (answer == JOptionPane.YES_OPTION) {
                    getAddInfo();
                    System.out.println(insert + " - admission inserted.");
                    ServerConnection.Request("insertElseltPlan", "" + insert + "");
                    ae.consume();
                    primaryStage.close();
                }
            }

            Launcher.getADMISSIONS().TableRefresh();
        });
        addBtn.setPrefSize(150, 30);
        addBtn.setLayoutX(25);
        addBtn.setLayoutY(260);
        addBtn.setId("iphone");

        cancelBtn = new Button("Болих");
        cancelBtn.setOnAction(ae -> {
            primaryStage.close();
        });
        cancelBtn.setPrefSize(150, 30);
        cancelBtn.setLayoutX(200);
        cancelBtn.setLayoutY(260);
        cancelBtn.setId("iphone");

        pane.getChildren().addAll(
                nameLbl,
                descLbl,
                startDateLbl,
                endDateLbl,
                nameFld,
                descArea,
                startPicker,
                endPicker,
                addBtn,
                cancelBtn
        );

        Image anotherIcon = new Image("ManagerPac/manager_32x32_white.png");
        primaryStage.getIcons().add(anotherIcon);

        Scene scene = new Scene(pane, 380, 320);
        scene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
        primaryStage.setTitle("Элсэлт нэмэх");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Getting user input information and returning it with string
     */
    public void getAddInfo() {
        name = nameFld.getText();
        desc = descArea.getText();
        start = startPicker.getValue().toString();
        end = endPicker.getValue().toString();
        insert = name + "::" + desc + "::" + start + "::" + end;
    }
}
