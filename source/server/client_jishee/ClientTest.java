package client_jishee;

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
        socket = new Socket("192.168.0.126", 9001);
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
}
    