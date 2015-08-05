package teacher.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import teacher.login.model.IPFeature;

public class ServerConnection {

    static Socket socket;
    static ObjectInputStream dis;
    static ObjectOutputStream dos;
//    static Thread thread;
    static ArrayList<Thread> list = new ArrayList<>();
    static ArrayList<Object> responses = new ArrayList<>();
    static Object synlock = new Object();
    static Properties property = new Properties();
    static String line;

    static class Singleton {

        private static Singleton instance;
        private ArrayList<Object> responses;

        public static Singleton get() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

        private Singleton() {
            responses = new ArrayList<>();
            responses.add(null);
        }

        public ArrayList<Thread> getList() {
            return list;
        }

        public ArrayList<Object> getResponses() {
            return responses;
        }

    }

    public static void ClientAjluulah() {
        try {
            holboltUusgeh();
            holboltAvah();
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
        socket.close();
    }

    public static Object Request(Object request, Object data) {
        Singleton single = Singleton.get();
//        int a = 0;
//        final int id = a;
        Thread thread = new Thread(() -> {
            Singleton.get().getResponses().add(ServerConnection.RequestAjluulah(request, data));
        });
        thread.setDaemon(true);
        thread.start();
//        a++;
        System.out.println(thread.isAlive());
//        Singleton.get().getList().add(thread);
        try {
            Thread.sleep(15);
        } catch (InterruptedException ex) {
            System.err.println("Sleep interrupted!");
        }
        System.out.println(Singleton.get().getResponses().size());
        return Singleton.get().getResponses().get(Singleton.get().getResponses().size() - 1);
//        return null;
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
        }
        return returnValue;

    }

}
