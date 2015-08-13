package ManagerPac;

import java.util.Collections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * User data validation
 */
public class Validation {

    /**
     * TextField selection validation
     */
    public static void textFieldFocus(TextField textField) {
        textField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (oldValue) {
                textFieldProperty(textField);
            }
        });
    }

    /**
     * TextField property validation
     */
    public static void textFieldProperty(final TextField textField) {
        textField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            textFieldValidation(textField);
        });

        textFieldValidation(textField);
    }

    /**
     * TextField value validation
     */
    public static void textFieldValidation(TextField textField) {
        ObservableList<String> styleClass = textField.getStyleClass();
        if (textField.getText().trim().length() == 0) {
            if (!styleClass.contains("error")) {
                styleClass.add("error");
            }
        } else {
            styleClass.removeAll(Collections.singleton("error"));
        }
    }

    /**
     * TextArea selection validation
     */
    public static void textAreaFocus(TextArea area) {
        area.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (oldValue) {
                textAreaProperty(area);
            }
        });
    }

    /**
     * TextArea property validation
     */
    public static void textAreaProperty(final TextArea area) {
        area.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            areaValidation(area);
        });

        areaValidation(area);
    }

    /**
     * TextArea value validation
     */
    public static void areaValidation(TextArea area) {
        ObservableList<String> styleClass = area.getStyleClass();
        if (area.getText().trim().length() == 0) {
            if (!styleClass.contains("areaError")) {
                styleClass.add("areaError");
            }
        } else {
            styleClass.removeAll(Collections.singleton("areaError"));
        }
    }

    /**
     * ComboBox selection validation
     */
    public static void comboBoxFocus(ComboBox combo) {
        combo.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (oldValue) {
                comboBoxValue(combo);
            }
        });
    }

    /**
     * ComboBox property validation
     */
    public static void comboBoxValue(final ComboBox combo) {
        combo.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                comboValidation(combo);
            }
        });

        comboValidation(combo);
    }

    /**
     * ComboBox value validation
     */
    public static void comboValidation(ComboBox combo) {
        ObservableList<String> styleClass = combo.getStyleClass();
        if (combo.getSelectionModel().getSelectedIndex() < 0) {
            if (!styleClass.contains("comboError")) {
                styleClass.add("comboError");
            }
        } else {
            styleClass.removeAll(Collections.singleton("comboError"));
        }
    }
}
