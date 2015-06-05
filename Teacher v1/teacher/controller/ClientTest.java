package teacher.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientTest {

    static Socket socket;
    static ObjectInputStream dis;
    static ObjectOutputStream dos;

    public static void ClientAjluulah() {
        try {
            holboltUusgeh();
            holboltAvah();
        } catch (IOException ex) {
            Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void holboltUusgeh() throws IOException {
        socket = new Socket("192.168.0.123", 3106);
    }

    public static void holboltAvah() throws IOException {
        dis = new ObjectInputStream(socket.getInputStream());
        dos = new ObjectOutputStream(socket.getOutputStream());
        dos.flush();
    }

    public static void holboltHaah() throws IOException {

        dis.close();
        dos.close();
        socket.close();
    }

    public static Object RequestAjluulah(Object request, Object data) {
        ClientAjluulah();
        Object returnValue = null;
        try {
            ClientTest.dos.writeObject(request);
            ClientTest.dos.writeObject(data);
            ClientTest.dos.flush();
            returnValue = ClientTest.dis.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return returnValue;
    }
}

