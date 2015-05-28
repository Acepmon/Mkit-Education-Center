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
    
    private SimpleStringProperty id;
    private SimpleStringProperty ovog;
    private SimpleStringProperty name;
    private SimpleStringProperty gender;
    private SimpleStringProperty number;
    private SimpleStringProperty type;
    private SimpleStringProperty payment;
    private SimpleStringProperty allPayment;
    private SimpleStringProperty time;
    private FlowPane pane = new FlowPane(new RadioButton(), new Label("asdasd"));

    public tables(String id, String ovog, String name, String gender, String number, String type, String payment, String allPayment, String time) {
        this.id = new SimpleStringProperty(id);
        this.ovog = new SimpleStringProperty(ovog);
        this.name = new SimpleStringProperty(name);
        this.gender = new SimpleStringProperty(gender);
        this.number = new SimpleStringProperty(number);
        this.type = new SimpleStringProperty(type);
        this.payment = new SimpleStringProperty(payment);
        this.allPayment = new SimpleStringProperty(allPayment);
        this.time = new SimpleStringProperty(time);
    }

    public FlowPane getPane() {
        return pane;
    }

    public void setPane(FlowPane pane) {
        this.pane = pane;
    }

    public String getId() {
        return id.get();
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public String getOvog() {
        return ovog.get();
    }

    public void setOvog(SimpleStringProperty Ovog) {
        this.ovog = Ovog;
    }

    public String getName() {
        return name.get();
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public String getGender() {
        return gender.get();
    }
    
    public void setGender(SimpleStringProperty gender) {
        this.gender = gender;
        
    }
    
    public void setNumber(SimpleStringProperty number) {
        this.number = number;
    }

    public String getNumber() {
        return number.get();
    }
    
    public void setType(SimpleStringProperty type) {
        this.type = type;
    }

    public String getType() {
        return type.get();
    }
    
    public void setPayment(SimpleStringProperty payment) {
        this.payment = payment;
    }

    public String getPayment() {
        return payment.get();
    }
    
    public void setAllPayment(SimpleStringProperty allPayment) {
        this.allPayment = allPayment;
    }

    public String getAllPayment() {
        return allPayment.get();
    }

    public void setTime(SimpleStringProperty time) {
        this.time = time;
    }

    public String getTime() {
        return time.get();
    }  
}
