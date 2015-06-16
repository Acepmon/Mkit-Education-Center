package ManagerPac;

import java.util.ArrayList;

public class ReportColumnObj {
    private String column;
    private String type;
    private ArrayList<Object> value;

    public ReportColumnObj(String column, String type, ArrayList<Object> value) {
        this.column = column;
        this.type = type;
        this.value = value;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Object> getValue() {
        return value;
    }

    public void setValue(ArrayList<Object> value) {
        this.value = value;
    }
    
    
}
