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
    
    public void setObject(int index, Object newObject) {
        this.datas.set(index, newObject);
    }
     public void removeAt(int index) {
        System.out.println("index: "+index);
        this.datas.remove(index);
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

/**
 * Host hiigdsen database iin buh table medeelel uudiig
 * huulan avch server oor deer hadgaldag.
 * @author JAVA M2
 */
public class DB_Copy {

    private static ArrayList<Table> newTables = new ArrayList<>();
    
    public DB_Copy() {
        
        String query = "show tables";
        ResultSet result = SurgaltServer.db.runQuery(query);

        try {
            // Table name eer davtalt uusgeh
            while (result.next()) {
                String name = result.getString(1);
                System.out.println(name);
                Table table = new Table(name);

                ArrayList<Column> rs = new ArrayList<>();

                // **************************
                String q = "select * from " + name;
                ResultSet r = SurgaltServer.db.runQuery(q);

                ArrayList<Column> columns = new ArrayList<>();

                // Tuhain table iin moroor davtah
                System.out.println(r.getMetaData().getColumnCount());
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
                System.out.println("END");
            }

//            for (ArrayList<Object> datas : getDatas("login")) {
//                for (Object obj : datas) {
//                    System.out.println(obj + " ");
//                }
//            }
//            System.out.println("*****************");
//            for (Object obj : getDatas("login", "password")) {
//                System.out.println(obj);
//            }
//            
//            System.out.println("*****************");
//         
//            for (Object obj : getDatas("login",0)) {
//                System.out.println(obj);
//       
//            }
//            System.out.println("*****************");
//         
//            Object obj =  getDatas("login", "password",1);
//                System.out.println(obj);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Hadgalagdsan medeeleluudees tuhain table iin nertei
     * medeeleliig ni shuuj avna
     * @param tableName <b>Table iin ner</b>
     * @return <b>Shuugdsen medeelel list eer irne.</b>
     */
    public static ArrayList<ArrayList<Object>> getDatas(String tableName) {
        ArrayList<ArrayList<Object>> foundTable = new ArrayList<>();
        if (!tableName.equals("") && tableName != null) {
            for (Table table : newTables) {
                if (table.getTableName().equalsIgnoreCase(tableName)) {
                    ArrayList<Object> rows = null;
                    for (int i = 0; i < table.getDatas().get(0).getDatas().size(); i++) {
                        rows = new ArrayList<>();
                        for (Column col : table.getDatas()) {
                            rows.add(col.getObject(i));
                        }
                        foundTable.add(rows);
                    }
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

                            for (int i = 0; i < table.getDatas().get(0).getDatas().size(); i++) {
                                if (i  == rowIndex){
                                    foundData = column.getDatas().get(rowIndex);
                                    break;
                                }
                            }
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

    public static void insertTable(Table table) {
        if (table != null) {
            newTables.add(table);
        }
    }

    public static void insertRow(String tableName, ArrayList<Object> datas) {
        if (tableName != null && datas != null) {
            System.out.println("Tableiin hemjee "+newTables.size());
            for (int i = 0; i < newTables.size(); i++) {
                System.out.println("table name -> "+newTables.get(i).getTableName() + " == " + tableName);
                if (newTables.get(i).getTableName().equals(tableName)) {
                    if (newTables.get(i).getDatas().size() == datas.size()) {
                        for (int j = 0; j < newTables.get(i).getDatas().size(); j++) {
                            newTables.get(i).getDatas().get(j).addData(datas.get(j));
                        }
                    } else {
                        System.out.println("-- insertRow -- \n Oruulj bui mor songogdson table iin bagantai tentsehgui baina.");
                        throw new NullPointerException();
                    }
                    break;
                }
            }
//            System.out.println("-- insertRow -- \n Tiim Table oldohgui baina.");
//            throw new NullPointerException();
        }
    }

    public static void insertColumn(String tableName, Column column) {
        if (tableName != null && column != null) {
            for (int i = 0; i < newTables.size(); i++) {
                if (newTables.get(i).getTableName().equals(tableName)) {
                    newTables.get(i).getDatas().add(column);
                    break;
                }
            }
            System.err.println("-- insertRow -- \n Tiim Table oldohgui baina.");
                    throw new NullPointerException();
        }
    }
    
    public static void updateCell(String tableName, String columnName, int index, Object newData) {
        if (!tableName.equals("") && tableName != null && !columnName.equals("") && columnName != null) {
            for (Table table : newTables) {
                if (table.getTableName().equalsIgnoreCase(tableName)) {
                    for (Column column : table.getDatas()) {
                        if (column.getColumnName().equalsIgnoreCase(columnName)) {
                            column.getDatas().set(index, newData);
                        }
                    }
                }
            }
        }
    }
    
    public static void updateRow(String tableName, int index, ArrayList<Object> newDatas) {
        if (!tableName.equals("") && tableName != null) {
            for (Table table : newTables) {
                if (table.getTableName().equalsIgnoreCase(tableName)) {
                    for (int i = 0; i < table.getDatas().size(); i++) {
                        table.getDatas().get(i).getDatas().set(index, newDatas.get(i));
                    }
                }
            }
        }
    }
    
    public static void updateColumn(String tableName, String columnName, ArrayList<Object> newDatas) {
        if (!tableName.equals("") && tableName != null && !columnName.equals("") && columnName != null) {
            for (Table table : newTables) {
                if (table.getTableName().equalsIgnoreCase(tableName)) {
                    for (int i = 0; i < table.getDatas().size(); i++) {
                        if (table.getDatas().get(i).getColumnName().equalsIgnoreCase(columnName)) {
                            table.getDatas().get(i).setObject(i, newTables.get(i));
                        }
                    }
                }
            }
        }
    }
    
    public static int searchFor(String tableName, String columnName, String keyword) {
        int index = 0;
        if (!tableName.equals("") && tableName != null && !columnName.equals("") && columnName != null) {
            for (Table table : newTables) {
                if (table.getTableName().equalsIgnoreCase(tableName)) {
                    for (int i = 0; i < table.getDatas().size(); i++) {
                        if (table.getDatas().get(i).getColumnName().equalsIgnoreCase(columnName)) {
                            if (table.getDatas().get(i).getObject(i).toString().equals(keyword)) {
                                index = i;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return index;
    }
    
    public static void removeAt(String tableName, int index) {
        System.out.println("1-index: "+ index);
        if (!tableName.equals("") && tableName != null) {
            for (int i = 0; i < newTables.size(); i++) {
                if (newTables.get(i).getTableName().equalsIgnoreCase(tableName)) {
                    for (int j = 0; j < newTables.get(i).getDatas().size(); j++) {
                        newTables.get(i).getDatas().get(j).removeAt(index);
                    }
                    break;
                }
            }
        }
    }
    
    public static void main(String args[]) {
        new DB_Copy();
    }
}







