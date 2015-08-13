package teacher.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Columns implements Serializable {
    
    private String columnName;
    private String columnType;
    private ArrayList<Object> data;

    public Columns(String columnName, ArrayList<Object> data) {
        this.columnName = columnName;
        this.data = data;
    }

    public Columns(String columnName, String columnType, ArrayList<Object> data) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.data = data;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ArrayList<Object> getData() {
        return data;
    }

    public void setData(ArrayList<Object> data) {
        this.data = data;
    }
    
}
