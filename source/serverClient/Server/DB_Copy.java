package Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class Column {

    private String columnName;
    private ArrayList<Object> datas;
   

    public Column(String columnName) {
        this.columnName = columnName;
        this.datas = new ArrayList<>();
    }

    public String getColumnName() {
        return columnName;
    }

    public ArrayList<Object> getDatas() {
        return datas;
    }

    public void addData(Object data) {
        this.datas.add(data);
    }

    public Object getObject(int index) {
        return datas.get(index);
    }

}

class Table {

    private String tableName;
    private ArrayList<Column> datas;

    public Table(String tableName) {
        this.tableName = tableName;
        this.datas = new ArrayList<>();

    }

    public String getTableName() {
        return this.tableName;
    }

    public void setDatas(ArrayList<Column> datas) {
        this.datas = datas;
    }

    public ArrayList<Column> getDatas() {
        return this.datas;
    }


}

public  class DB_Copy {

    private static ArrayList<ArrayList<ArrayList<Object>>> tables;

    private static ArrayList<Table> newTables = new ArrayList<>();
    static ResultSet result;
    DatabaseTools db = new DatabaseTools();
    
    
    public DB_Copy() {

        String query = "show tables";
        ResultSet result  = db.runQuery(query);
        

        try {
            // Table name eer davtalt uusgeh
            while (result.next()) {
                String name = result.getString(1);
                Table table = new Table(name);

                ArrayList<Column> rs = new ArrayList<>();

                // **************************
                String q = "select * from " + name;
                ResultSet r = db.runQuery(q);

                ArrayList<Column> columns = new ArrayList<>();

                // Tuhain table iin moroor davtah
                for (int i = 1; i <= r.getMetaData().getColumnCount(); i++) {
                    columns.add(new Column(r.getMetaData().getColumnName(i)));
                }

                while (r.next()) {

                    for (int i = 1; i <= r.getMetaData().getColumnCount(); i++) {
                        if (columns.get(i - 1).getColumnName().equals(r.getMetaData().getColumnName(i))) {
                            columns.get(i - 1).addData(r.getObject(i));
                        }
                    }

                }

                // **************************
                table.setDatas(columns);
                newTables.add(table);
            }

            for (ArrayList<Object> datas : getDatas("login")) {
                for (Object obj : datas) {
                    System.out.println(obj + " ");
                }
            }
            System.out.println("*****************");
            
            for (Object obj : getDatas("login", "password")) {
                System.out.println(obj);
            }
            
            System.out.println("*****************");
         
            for (Object obj : getDatas("login",0)) {
                System.out.println(obj);
       
            }
//            System.out.println("*****************");
//         
//            Object obj =  getDatas("login", "password",1);
//                System.out.println(obj);
       
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList getDatas() {

        return tables;
    }

    public static ArrayList<ArrayList<Object>> getDatas(String tableName) {
        ArrayList<ArrayList<Object>> foundTable = new ArrayList<>();
        if (!tableName.equals("") && tableName != null) {
            for (Table table : newTables) {
                if (table.getTableName().equalsIgnoreCase(tableName)) {
                    ArrayList<Object> rows = new ArrayList<>();
                    for (int i = 0; i < table.getDatas().get(0).getDatas().size(); i++) {
                        for (Column col : table.getDatas()) {
                            rows.add(col.getObject(i));
                        }
                    }
                    foundTable.add(rows);
                }
            }
        }
        return foundTable;
    }

    public static ArrayList<Object> getDatas(String tableName, String columnName) {
        if (!tableName.equals("") && tableName != null && !columnName.equals("") && columnName != null) {
            for (Table table : newTables) {
                if (table.getTableName().equalsIgnoreCase(tableName)) {
                    for (Column column : table.getDatas()) {
                        if (column.getColumnName().equalsIgnoreCase(columnName)) {
                            return column.getDatas();
                        }
                    }
                }
            }
        }
        return null;
    }

    public static Object getDatas(String tableName, String columnName, int rowIndex) {
        Object foundData = null;
        if (!tableName.equals("") && tableName != null && !columnName.equals("") && columnName != null) {
            for (Table table : newTables) {
                if (table.getTableName().equalsIgnoreCase(tableName)) {
                    for (Column column : table.getDatas()) {
                        if (column.getColumnName().equalsIgnoreCase(columnName)) {
                            // End yumaa hii
                            
                       for (int i = 0; i < table.getDatas().size(); i++) {
                        foundData=table.getDatas().get(i).getDatas().get(rowIndex);
                    }
                            break;
                        }
                    }
                }
            }
        }
        return foundData;
    }

    public static ArrayList<Object> getDatas(String tableName, int rowIndex) {
        ArrayList<Object> foundRow = new ArrayList<>();
        if (!tableName.equals("") && tableName != null) {
            for (Table table : newTables) {
                if (table.getTableName().equalsIgnoreCase(tableName)) {                       
                    for (int i = 0; i < table.getDatas().size(); i++) {
                        foundRow.add(table.getDatas().get(i).getDatas().get(rowIndex));
                    }
                    
                }
            }
        }
        return foundRow;
    }

    public static void printNewTables() {
        for (Table table : newTables) {
            System.out.println("Table name : " + table.getTableName());
            for (Column column : table.getDatas()) {
                System.out.println("Column name : " + column.getColumnName());
                for (Object obj : column.getDatas()) {
                    System.out.println("Data: " + obj);
                }
            }
            System.out.println("\n\n");
        }
    }

    public static void main(String args[]) {
        new DB_Copy();
    }
}
