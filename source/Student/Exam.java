package StudentUI;

import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Exam {

    private GridPane grid;

    public Exam() {
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 45));
        grid.setStyle("-fx-background:transparent");

        Label title = new Label("Шалгалт өгөх");
        title.setStyle("-fx-text-fill :#009688");
        title.setFont(Font.font("Roboto-Regular", FontWeight.BOLD, 30));
        title.setPrefSize(200, 20);
        grid.add(title, 1, 0);

        Label hicheeliinNer = new Label("Хичээлийн нэр");
        hicheeliinNer.setStyle("-fx-font: 22 roboto; -fx-text-fill : black");
        grid.add(hicheeliinNer, 1, 5);

        ToggleGroup group = new ToggleGroup();
        RadioButton java = new RadioButton("Java");
        java.setStyle("-fx-font: 22 roboto;-fx-font: 22 roboto; -fx-text-fill : black");
        java.setToggleGroup(group);
        java.setSelected(true);
        grid.add(java, 8, 5);

        RadioButton c = new RadioButton("C#");
        c.setToggleGroup(group);
        c.setStyle("-fx-font: 22 roboto;-fx-text-fill:black");
        grid.add(c, 11, 5);

        RadioButton solongosHel = new RadioButton("Солонгос");
        solongosHel.setToggleGroup(group);
        solongosHel.setStyle("-fx-font: 22 roboto;-fx-font: 22 roboto; -fx-text-fill : black");
        grid.add(solongosHel, 14, 5);

        Label lbl2 = new Label("Идэвхитэй шалгалтын нэр");
        lbl2.setPrefSize(350, 20);
        lbl2.setStyle("-fx-font: 22 Roboto;-fx-font: 22 roboto; -fx-text-fill : black");
        grid.add(lbl2, 1, 8);

        ComboBox<String> myComboBox = new ComboBox<String>();
        myComboBox.getItems().addAll("JavaLesson1", "JavaLesson2", "JavaLesson3", "JavaLesson4", "JavaLesson5");
        myComboBox.setStyle("-fx-font: 22 Roboto;-fx-font: 22 roboto; -fx-text-fill : black-");
        myComboBox.setValue("JavaLesson1");
        grid.add(myComboBox, 8, 8);
        myComboBox.setVisible(true);
        ComboBox<String> myComboBox1 = new ComboBox<String>();
        myComboBox1.getItems().addAll("CchagtLesson1", "CchagtLesson2", "CchagtLesson3");
        myComboBox1.setStyle("-fx-font: 22 Roboto;-fx-font: 22 roboto; -fx-text-fill : black-");
        myComboBox1.setValue("CchagtLesson1");
        grid.add(myComboBox1, 8, 8);
        myComboBox1.setVisible(false);

        ComboBox<String> myComboBox2 = new ComboBox<String>();
        myComboBox2.getItems().addAll("KLanguageLesson1", "KLanguageLesson2", "KLanguageLesson3");
        myComboBox2.setStyle("-fx-font: 22 Roboto;-fx-font: 22 roboto; -fx-text-fill : black-");
        myComboBox2.setValue("KLanguageLesson1");
        grid.add(myComboBox2, 8, 8);
        myComboBox2.setVisible(false);
        Label sanamjlbl = new Label("Санамж");
        sanamjlbl.setStyle("-fx-font: 22 roboto;-fx-font: 22 roboto; -fx-text-fill : black");
        grid.add(sanamjlbl, 1, 11);
        c.setOnAction(ae -> {
            myComboBox.setVisible(false);
            myComboBox1.setVisible(true);
            myComboBox2.setVisible(false);
        });
        solongosHel.setOnAction(ae -> {
            myComboBox1.setVisible(false);
            myComboBox.setVisible(false);
            myComboBox2.setVisible(true);
        });
        java.setOnAction(ae -> {
            myComboBox.setVisible(true);
            myComboBox1.setVisible(false);
            myComboBox2.setVisible(false);
        });
        TextArea sanamj = new TextArea();
        sanamj.setPrefRowCount(10);
        sanamj.setPrefColumnCount(150);
        sanamj.setWrapText(true);
        sanamj.setEditable(false);
        sanamj.setPrefSize(400, 150);
        grid.add(sanamj, 1, 13);

        Button btn = new Button("Эхлэх");
        btn.setStyle("-fx-font: 22 roboto;-fx-font: 22 roboto; -fx-text-fill : black");
        btn.setPrefSize(150, 60);
        grid.add(btn, 1, 15);

        Scene scene = new Scene(grid, 1366, 688);

    }

    public GridPane getExamGridPane() {
        return this.grid;
    }
}
