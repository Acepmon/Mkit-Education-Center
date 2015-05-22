package ManagerPac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Database {
    public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    public final static String DATABASE_URL="jdbc:mysql://localhost:3306/example?useUnicode = yes&characterEncoding=UTF-8";
    
    public static Connection connect() {
        Connection connection=null;
        
        try {
            Class.forName(JDBC_DRIVER);
            connection=DriverManager.getConnection(DATABASE_URL, "root", "1234");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Can't connect to the Database !!");
        }
        
        return connection;
    }
    
    public static ResultSet runQuery(String query) {
        Connection connection=connect();
        Statement statement;
        ResultSet result=null;
        
        try {
            statement=connection.createStatement();
            if(query.toLowerCase().startsWith("update")||query.toLowerCase().startsWith("insert")||query.toLowerCase().startsWith("delete")) {
                statement.executeUpdate(query);
            }
            else
                result=statement.executeQuery(query);
            
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error!!!");
        }
        
        
        return result;
    }
}
