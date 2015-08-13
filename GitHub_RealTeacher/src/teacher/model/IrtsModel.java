package teacher.model;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class IrtsModel {
    
    private String name;
    private FlowPane day;
    
    private CheckBox check;
    private Label label;

    public IrtsModel(String name, String day) {
        check = new CheckBox();
        label = new Label(day);
        this.day = new FlowPane(check, label);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlowPane getDay() {
        return day;
    }

    public void setDay(FlowPane day) {
        this.day = day;
    }
    
}
