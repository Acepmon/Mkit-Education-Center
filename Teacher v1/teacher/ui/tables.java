/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surgaltiin.alba.irts;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author JAVA M2
 */
public class tables {
    
    private SimpleStringProperty ners;

    private FlowPane pane = new FlowPane(new RadioButton());
    
    

    public tables(String ners, String pane) {
        this.ners = new SimpleStringProperty(ners);
        
    }

    public FlowPane getPane() {
        return pane;
    }

    public void setPane(FlowPane pane) {
        this.pane = pane;
    }

    public String getNers() {
        return ners.get();
    }

    public void setNers(SimpleStringProperty ners) {
        this.ners = ners;
    }
    
}
