package ManagerPac;

import java.util.ArrayList;

public class ReportRowObj {
    private String row;
    private ArrayList value;

    public ReportRowObj(String row, ArrayList value) {
        this.row = row;
        this.value = value;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public ArrayList getValue() {
        return value;
    }

    public void setValue(ArrayList value) {
        this.value = value;
    }
}
