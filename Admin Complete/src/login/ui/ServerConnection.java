package login.ui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.model.IPFeature;

public class ServerConnection {

    static Socket socket;
    static ObjectInputStream dis;
    static ObjectOutputStream dos;


    public static void ClientAjluulah() {
        try {
            if (holboltUusgeh() && holboltAvah()) {
                System.out.println("Successfully connected");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Holbolt uusgehed aldaa garlaa");
        }
    }

    public static boolean holboltUusgeh() throws IOException {
        socket = new Socket(IPFeature.ip, 3106);
        return true;
    }

    public static boolean holboltAvah() throws IOException {
        dis = new ObjectInputStream(socket.getInputStream());
        dos = new ObjectOutputStream(socket.getOutputStream());
        dos.flush();
        return true;
    }

    public static void holboltHaah() throws IOException {
        dis.close();
        dos.close();
    }


    public static Object RequestAjluulah(Object request, Object data) {
        ClientAjluulah();
        Object returnValue = null;
        try {
            ServerConnection.dos.writeObject(request);
            ServerConnection.dos.writeObject(data);
            ServerConnection.dos.flush();
            returnValue = ServerConnection.dis.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                holboltHaah();
            } catch (IOException ex) {
                Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return returnValue;

    }

}
