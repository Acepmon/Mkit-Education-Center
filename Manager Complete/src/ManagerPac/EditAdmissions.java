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

public class EditAdmissions {

    private Label nameLbl;
    private Label descLbl;
    private Label startDateLbl;
    private Label endDateLbl;

    private TextField nameFld;
    private TextArea descArea;

    private DatePicker startPicker;
    private DatePicker endPicker;

    private Button editBtn;
    private Button cancelBtn;

    private String id;
    private String name;
    private String desc;
    private String end;
    private String start;
    private String update;

    private String pattern = "yyyy-MM-dd";

    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        nameLbl = new Label("Хөтөлбөрийн нэр");
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
        nameFld.setText(Launcher.getADMISSIONS().getSelect().getName());
        nameFld.setId("info");

        descArea = new TextArea();
        descArea.setPrefSize(150, 50);
        descArea.setLayoutX(200);
        descArea.setLayoutY(80);
        descArea.setWrapText(true);
        descArea.setText(Launcher.getADMISSIONS().getSelect().getDescription());
        descArea.setId("info");

        /**
         * Creating date picker and converting date format "MM/DD/YYYY" to
         * "YYYY-MM-DD"
         */
        startPicker = new DatePicker();
        startPicker.setPrefSize(150, 25);
        startPicker.setLayoutX(200);
        startPicker.setEditable(false);
        startPicker.setLayoutY(150);
        LocalDate startDate = LocalDate.parse(Launcher.getADMISSIONS().getSelect().getStartDate());
        startPicker.setValue(startDate);
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
        endPicker = new DatePicker();
        endPicker.setPrefSize(150, 25);
        endPicker.setLayoutX(200);
        endPicker.setEditable(false);
        endPicker.setLayoutY(200);
        LocalDate endDate = LocalDate.parse(Launcher.getADMISSIONS().getSelect().getEndDate());
        endPicker.setValue(endDate);
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

        editBtn = new Button("Засах");
        editBtn.setOnAction(ae -> {
            int answer = JOptionPane.showConfirmDialog(null, "Засах уу?");
            if (answer == JOptionPane.YES_OPTION) {
                getEditInfo();
                ServerConnection.Request("updateElseltPlan", "" + update + "");
                ae.consume();
                primaryStage.close();
            }

            Launcher.getADMISSIONS().TableRefresh();
        });
        editBtn.setPrefSize(150, 30);
        editBtn.setLayoutX(25);
        editBtn.setLayoutY(260);
        editBtn.setId("iphone");

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
                editBtn,
                cancelBtn
        );

        Image anotherIcon = new Image("ManagerPac/manager_32x32_white.png");
        primaryStage.getIcons().add(anotherIcon);

        Scene scene = new Scene(pane, 380, 320);
        scene.getStylesheets().add(getClass().getResource("managerStyle.css").toExternalForm());
        primaryStage.setTitle("Хөтөлбөр засах");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Getting user input information
     */
    public void getEditInfo() {
        id = Launcher.getADMISSIONS().getSelect().getId();
        name = nameFld.getText();
        desc = descArea.getText();
        start = startPicker.getValue().toString();
        end = endPicker.getValue().toString();
        update = id + "::" + name + "::" + desc + "::" + start + "::" + end;
    }
}
