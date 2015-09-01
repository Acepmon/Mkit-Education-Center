package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SurgaltServer {

    /* Сервер энэ портоор сонсоно */
    private final int PORT = 3106;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket listener;
    public static DatabaseTools db;
    public static DB_Copy copy;
    /*
    Програмын Main функц , энэ нь зөвхөн порт сонсож мөн Handler Thread - үүдийг 
    үүсгэж байдаг
     */
    
    public void start() {
        try {
            MainClass.setOutputMessage("Сервэр ажиллаж эхэллээ.");
            db = new DatabaseTools();
            copy = new DB_Copy();
            ReqFilter.InitializeRequest();
            MainClass.setOutputMessage("Initializing requests...");
            System.out.println("Сервэр ажиллаж эхэллээ.");
            listener = new ServerSocket(PORT);
            try {
                while (true) {
                    new Handler(listener.accept()).start();
                }
            } finally {
                listener.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(SurgaltServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Handler thread класс, Handler нь Thread -ийг сонсох давталтын үед үүсдэг 
    бөгөөд энэ нь нэг клиентээс ирж буй мэссежийг хүлээн авч хариуцах үүрэгтэй
    байна
     */
    private class Handler extends Thread {

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
            try{
                
                input = null;
                output = new ObjectOutputStream(socket.getOutputStream());
                output.flush();

                input = new ObjectInputStream(socket.getInputStream());
                Object request = input.readObject();
                Object data = input.readObject();
                
                Object response = ReqFilter.ReqFilters(request.toString(), data);
                
                output.writeObject(response);
                System.out.println(request + " -- " + response);
                MainClass.setOutputMessage("" + request + " -- " + response);

            }catch(IOException e){
                e.printStackTrace();
                System.out.println("SQL Алдаа");
                MainClass.setOutputMessage("SQL алдаа");
            }catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }finally{
               // клиент унажийна. 
                try{
                    socket.close();
                    }catch (IOException e) {
                }
            }
        }
    }
    
    public void stop(){
        try {
            this.listener.close();
            this.input.close();
            this.output.close();
        } catch (IOException ex){
            Logger.getLogger(SurgaltServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        db = null;
        this.input = null;
        this.output = null;
        this.listener = null;
        this.copy = null;
    }
}
