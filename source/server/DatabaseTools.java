package server; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DatabaseTools {
    public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public final static String DATABESE_URL = "jdbc:mysql://localhost/fitness?useUnicode = yes&characterEncoding = UTF-8";
    
    public static Connection connect(){
        Connection connection = null;
    
        
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABESE_URL, "root","");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Aмжилтгүй боллоо ");
        }
        return connection;
    }
    public static ResultSet runQuery (String query){
        Connection connection = connect();
        Statement statement;
        ResultSet result= null;
        
        try{
            statement = connection.createStatement();
            if (query.toLowerCase().startsWith("update")|| query.toLowerCase().startsWith("insert")||query.toLowerCase().startsWith("delete")){
            statement.executeUpdate(query);
        }else 
            result = statement.executeQuery(query);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Таны мэдээлэл алдаатай байна");
            
            
        }
        return result;
    }
}
