package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SurgaltServer {

    /* Сервер энэ портоор сонсоно */
    private static final int PORT = 3106;
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private static ServerSocket listener;
    public static String user;
    public static String pas;
    public static boolean voov;
    public static DatabaseTools db;

    /*
    Програмын Main функц , энэ нь зөвхөн порт сонсож мөн Handler Thread - үүдийг 
    үүсгэж байдаг
     */
    public static void main(String[] args) throws Exception {
        db = new DatabaseTools();
        DB_Copy copy = new DB_Copy();
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
    
      /*  public static void main(String[] args) throws Exception {
        db = new DatabaseTools();
        DB_Copy copy = new DB_Copy();
        System.out.println("Сервэр ажиллаж эхэллээ.");
        listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }*/
    /*
    Handler thread класс, Handler нь Thread -ийг сонсох давталтын үед үүсдэг 
    бөгөөд энэ нь нэг клиентээс ирж буй мэссежийг хүлээн авч хариуцах үүрэгтэй
    байна
     */
    private static class Handler extends Thread {

        private final Socket socket;
        /*
        Энд уг сокетийг хадгалах Handler Thread -ийг үүсгэж  байна
        Хийгдэх ёстой үйлдлүүд ихэвчлэн Run method дотор байрлана.
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }
        /*
        Энэ thread -ийн клиент-д нь түүний зөвхөн нэг хүсэлтийг хүлээн авах 
        хүртэл хүсэлтүүд явуулж үйлчилдэг. Клиентээс хүсэлт ирэх бүрд түүнийг
        хүлээн авч түүний output stream -ийг бүртгэж авдаг output streameer 
        утгаа дамжуулах ба клиентээс ирсэн хүсэлтүүдийг дахин дахин хүлээн 
        авч мөн хариулах үүрэгтэй байна. 
         */
        @Override
        public void run() {
            try {
                
                input = null;
                output = new ObjectOutputStream(socket.getOutputStream());
                output.flush();

                input = new ObjectInputStream(socket.getInputStream());
                Object request = input.readObject();
                Object data = input.readObject();
                
                Object response = RequestFilter.Request(request.toString(), data);
                
                output.writeObject(response);
                System.out.println(request + " -- " + response);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("SQL Алдаа");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } finally {
               // клиент унажийна. 
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
