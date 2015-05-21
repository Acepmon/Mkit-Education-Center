package server;

import server.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChatServer {

    /**
     * The port that the server listens on.
     */
    private static final int PORT = 9001;
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private static ServerSocket listener;
   
    /**
     * The appplication main method, which just listens on a port and
     * spawns handler threads.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Сервэр ажиллаж эхэллээ.");
         listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    /**
     * A handler thread class.  Handlers are spawned from the listening
     * loop and are responsible for a dealing with a single client
     * and broadcasting its messages.
     */
    private static class Handler extends Thread {
        private Socket socket;
        String user;
        String pas;
        boolean boov;
        /**
         * Constructs a handler thread, squirreling away the socket.
         * All the interesting work is done in the run method.
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * Services this thread's client by repeatedly requesting a
         * screen name until a unique one has been submitted, then
         * acknowledges the name and registers the output stream for
         * the client in a global set, then repeatedly gets inputs and
         * broadcasts them.
         */
        public void run() {
            try {
                
        output = new ObjectOutputStream(socket.getOutputStream());
        output.flush();
        
        input = new ObjectInputStream(socket.getInputStream());
  
            
                try {
            user = input.readObject().toString();
            pas = input.readObject().toString();
            
            } catch (ClassNotFoundException ex) {
                }
            String query = "select*from login_user" ;
            ResultSet rs = DatabaseTools.runQuery(query);
                
            while (rs.next()) {
                if (user.equals(rs.getString("user_name")) && pas.equals(rs.getString("user_pass"))) {
                    
                    boov = true;
                    break;
                }
              }
            if (boov) {
                    output.writeObject("true");
                    System.out.println("Нэр нууц үг зөв байна хариу явуулсан");
                } else {
                output.writeObject("false");
                System.out.println("Нэр нууц үг буруу байна хариу явуулсан");
            }
                
               
            } catch (IOException e) {
                System.out.println(e);
            } catch (SQLException ex) {
                System.out.println("SQL Алдаа");
            } finally {
                
                // This client is going down!  Remove its name and its print
                // writer from the sets, and close its socket.
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}