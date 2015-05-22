package newConnection;

//import java.io.DataInputStream;
//import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientTest  {
    static Socket socket = new Socket();
    static ObjectInputStream dis;
    static ObjectOutputStream dos;
    
//    static DataInputStream dis ;
//    static DataOutputStream dos;
    
   public  static void shalgah(){
        
          try {
            socket = new Socket("192.168.0.115", 9001);
        
            // ene dis dos huwisagchaar damjij servertei holbogdoj bga
            
            dis  = new ObjectInputStream(socket.getInputStream());
            
            dos = new ObjectOutputStream(socket.getOutputStream());
            dos.flush();
            
//            dis = new DataInputStream(socket.getInputStream());
//            dos = new DataOutputStream(socket.getOutputStream());
            
          } catch (IOException ex) {
              ex.printStackTrace();
        }
    }

}
          