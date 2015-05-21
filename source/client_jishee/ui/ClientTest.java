package login.ui;

import login.ui.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientTest  {
    static Socket socket = new Socket();
    static ObjectOutputStream dos;
    static ObjectInputStream dis;
    
   public  static void shalgah(){
        
      
          
          try {
            socket = new Socket("192.168.0.119", 9001);
        
         dos = new ObjectOutputStream(socket.getOutputStream());
        dos.flush();
        
        dis = new ObjectInputStream(socket.getInputStream());
            
          } catch (IOException ex) {
              ex.printStackTrace();
        }
    }

}
          