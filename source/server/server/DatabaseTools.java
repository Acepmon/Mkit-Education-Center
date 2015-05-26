package server; 

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

public class DatabaseTools {
    
    public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    Properties props = new Properties();
    
    
    
    public Connection connect(){
        Connection connection = null;
        
        
        try {
            FileInputStream in = new FileInputStream("D:/db.properties");
            props.load(in);
            in.close();
            
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");
            
            
            Class.forName(JDBC_DRIVER);
            
            
            connection = DriverManager.getConnection(url, username,password);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Aмжилтгүй боллоо  ");
        }
        return connection;
    }
    public ResultSet runQuery (String query){
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
    public  void nevtreh() throws SQLException{
    	  String query = "select * from loginUser";
         // String query = "select * from login_user";
          ResultSet rs = this.runQuery(query);
              
          while (rs.next()) {
              if (SurgaltServer.user.equals(rs.getString("username")) && SurgaltServer.pas.equals(rs.getString("password"))) {
                  SurgaltServer.voov = true;
                  break;
              }
              SurgaltServer.voov = false;
         }
    }
    
    public DatabaseTools() {
    	
    }
}
