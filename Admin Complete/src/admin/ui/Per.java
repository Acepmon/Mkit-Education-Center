package admin.ui;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class Per {

    private FlowPane cell, cell2, cell3, cell4, cell5;
    private CheckBox checkboxA, checkboxM, checkboxT, checkboxS;
    private Label label, label2, label3, label4, label5;

    private StringProperty permission;
    private SimpleBooleanProperty admin;
//        private SimpleBooleanProperty manager;
//        private SimpleBooleanProperty teacher;
//        private SimpleBooleanProperty student;
    private CheckBox checkbox1;

//        Per(String permission, boolean admin, boolean manager, boolean teacher, boolean student){
    Per(String permission) {
        this.permission = new SimpleStringProperty(permission);
        this.admin = new SimpleBooleanProperty(false);
//            this.manager = new SimpleBooleanProperty(manager);
//            this.teacher = new SimpleBooleanProperty(teacher);
//            this.student = new SimpleBooleanProperty(student);

        this.checkboxA = new CheckBox();
        this.checkboxA.setSelected(false);

//            this.checkboxM = new CheckBox();
//            this.checkboxM.setSelected(false);
//            
//            this.checkboxT = new CheckBox();
//            this.checkboxT.setSelected(false);
//            
//            this.checkboxS = new CheckBox();
//            this.checkboxS.setSelected(false);
        this.label = new Label("" + this.permission.getName().toString());
        this.cell = new FlowPane(label);

        this.label2 = new Label("");
        this.cell2 = new FlowPane(checkboxA, label2);

//            this.label3 = new Label("");
//            this.cell3 = new FlowPane(checkboxM, label3);
//            
//            this.label4 = new Label("");
//            this.cell4 = new FlowPane(checkboxT, label4);
//            
//            this.label5 = new Label("");
//            this.cell5 = new FlowPane(checkboxS, label5);
        cell.setAlignment(Pos.CENTER);
        cell2.setAlignment(Pos.CENTER);
//            cell3.setAlignment(Pos.CENTER);
//            cell4.setAlignment(Pos.CENTER);
//            cell5.setAlignment(Pos.CENTER);

    }

    ;

    public CheckBox getCheckboxA() {
        return checkboxA;
    }

    public void setCheckboxA(CheckBox checkboxA) {
        this.checkboxA = checkboxA;
    }

    public void setCell(FlowPane cell) {
        this.cell = cell;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public FlowPane getCell() {
        return this.cell;
    }

    public void setCell4(FlowPane cell4) {
        this.cell4 = cell4;
    }

    public void setCheckboxT(CheckBox checkT) {
        this.checkboxT = checkT;
    }

    public void setLabel4(Label label4) {
        this.label4 = label4;
    }

    public FlowPane getCell4() {
        return this.cell4;
    }

    public CheckBox getCheckboxT() {
        return this.checkboxT;
    }

    public void setCell5(FlowPane cell5) {
        this.cell5 = cell5;
    }

    public void setCheckboxS(CheckBox checkS) {
        this.checkboxS = checkS;
    }

    public void setLabel5(Label label5) {
        this.label5 = label5;
    }

    public FlowPane getCell5() {
        return this.cell5;
    }

    public CheckBox getCheckboxS() {
        return this.checkboxS;
    }

    public void setCell3(FlowPane cell3) {
        this.cell3 = cell3;
    }

    public void setCheckbox3(CheckBox check) {
        this.checkboxM = check;
    }

    public void setLabel3(Label label3) {
        this.label3 = label3;
    }

    public FlowPane getCell3() {
        return this.cell3;
    }

    public CheckBox getCheckboxM() {
        return this.checkboxM;
    }

    public void setCell2(FlowPane cell2) {
        this.cell2 = cell2;
    }

    public void setCheckboxF(CheckBox check1) {
        this.checkboxA = check1;
    }

    public void setLabel2(Label label2) {
        this.label2 = label2;
    }

    public FlowPane getCell2() {
        return this.cell2;
    }

    public CheckBox getCheckboxF() {
        return this.checkboxA;
    }

    public String getPermission() {
        return permission.get();
    }

    public void setPermission(StringProperty permission) {
        this.permission = permission;
    }

    public boolean getAdmin() {
        return this.admin.get();
    }

    public void setAdmin(SimpleBooleanProperty admin) {
        this.admin = admin;
    }

//    public boolean getManager() {
//        return this.manager.get();
//    }
//    
//    public void setManager(SimpleBooleanProperty manager) {
//        this.manager = manager;
//    }
//    
//    public boolean getTeacher() {
//        return this.teacher.get();
//    }
//    
//    public void setTeacher(SimpleBooleanProperty teacher) {
//        this.teacher = teacher;
//    }
//
//    public boolean getStudent() {
//        return this.student.get();
//    }
//    
//    public void setStudent(SimpleBooleanProperty student) {
//        this.student = student;
//    }
}
