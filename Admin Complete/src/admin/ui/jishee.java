package checkboxtablecelltest;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author reegan
 */
public class jishee extends Application {

    @Override   
    public void start(Stage primaryStage) {
        final TableView<Person> tableView = new TableView<Person>();
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setItems(FXCollections.observableArrayList(
                new Person("Robert", "Plant"),
                new Person("Neil", "Young"),
                new Person("Willie", "Nelson"),
                new Person("Natalie", "Merchant")));
//        tableView.getItems().get(3).setVegetarian(true);
        final TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("First Name");
        final TableColumn<Person, String> lastNameCol = new TableColumn<Person, String>("Last Name");
        final TableColumn<Person, Boolean> vegetarianCol = new TableColumn<Person, Boolean>("Vegetarian");
        tableView.getColumns().addAll(firstNameCol, lastNameCol, vegetarianCol);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        vegetarianCol.setCellValueFactory(new PropertyValueFactory<Person, Boolean>("vegetarian"));
    vegetarianCol.setCellFactory(CheckBoxTableCell.forTableColumn(vegetarianCol));
        vegetarianCol.setEditable(true);
        tableView.setEditable(true);

        final BorderPane root = new BorderPane();
        root.setCenter(tableView);

        final HBox controls = new HBox(5);
        final Button infoButton = new Button("Show details");
        infoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Person p : tableView.getItems()) {
                    System.out.printf("%s %s (%svegetarian)%n", p.getFirstName(),
                            p.getLastName(), p.isVegetarian() ? "" : "not ");
                            System.out.println(tableView.getSelectionModel().getSelectedItems());
                }
                System.out.println();
            }
        });
        controls.getChildren().add(infoButton);
        root.setBottom(controls);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Person {

        private StringProperty firstName;
        private StringProperty lastName;
        private BooleanProperty vegetarian;

        public Person(String firstName, String lastName) {
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.vegetarian = new SimpleBooleanProperty(false);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public String getLastName() {
            return lastName.get();
        }

        public boolean isVegetarian() {
            return vegetarian.get();
        }

        public void setFirstName(String firstName) {
            this.firstName.set(firstName);
        }

        public void setLastName(String lastName) {
            this.lastName.set(lastName);
        }

        public void setVegetarian(boolean vegetarian) {
            this.vegetarian.set(vegetarian);
        }

        public StringProperty firstNameProperty() {
            return firstName;
        }

        public StringProperty lastNameProperty() {
            return lastName;
        }

        public BooleanProperty vegetarianProperty() {
            return vegetarian;
        }
    }
}