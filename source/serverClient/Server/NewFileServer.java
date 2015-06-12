package Server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NewFileServer {

    private final int PORT = 5555;
    private final int PORT2 = 5102;

    private Thread fromClient;
    private Thread toClient;

    private boolean stop1 = false;

    private ServerSocket server;
    private Socket fromSocket, toSocket;
    
    private String clientIp;

    public NewFileServer() throws IOException {
        server = new ServerSocket(PORT);

        fromClient = new Thread(receiveFromClient());
        toClient = new Thread(sendToClient());

        fromClient.setDaemon(true);
        toClient.setDaemon(true);
        toClient.start();
        toClient.stop();
        fromClient.start();
        System.out.println("Waiting for client!");

        Scanner in = new Scanner(System.in);
        int choose;
        do {
            System.out.println("\n1. Send to Client");
            System.out.println("2. Shutdown Server");
            System.out.println("3. Exit");
            System.out.print(": ");
            choose = in.nextInt();
            switch (choose) {
                case 1:
                    
                    System.out.println("Enter ip address: ");
                    String ip = in.next();
                    clientIp = ip;
                    toClient.start();
                    
                    break;
                case 2:
                    System.out.println("\nShutting down...");
                    stop1 = true;

                    if (fromClient.isAlive()) {
                        System.out.println("Shutdown failed!");
                    } else {
                        System.out.println("Shutdown successful!");
                    }
                    break;
            }
        } while (choose != 3);

    }

    private Runnable receiveFromClient() {
        return () -> {
            while (!stop1) {
                try {
                    System.out.println("Waiting for client...");
                    fromSocket = server.accept();
                    System.out.println("Someone connected!");

                    BufferedReader inReader = new BufferedReader(new InputStreamReader(fromSocket.getInputStream()));
                    BufferedWriter outReader = new BufferedWriter(new OutputStreamWriter(fromSocket.getOutputStream()));
                    String filename = inReader.readLine();
                    if (!filename.equals("")) {
                        outReader.write("READY\n");
                        outReader.flush();
                    }
                    
                    System.out.println("Writing file...");
                    FileOutputStream wr = new FileOutputStream(new File("E://" + filename));
                    byte[] buffer = new byte[fromSocket.getReceiveBufferSize()];

                    int bytesReceived = 0;
                    while ((bytesReceived = fromSocket.getInputStream().read(buffer)) > 0) {
                        /* Write to the file */
                        wr.write(buffer, 0, bytesReceived);
                    }
                    System.out.println("Write complete...");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

    private Runnable sendToClient() {
        return () -> {
            while (true) {
                try {
                    System.out.println("Connecting to client...");
                //    fromSocket.close();
                  //  toSocket = new Socket(clientIp,PORT2);
                    toSocket = server.accept();
                    System.out.println("Before buffered output stream!");
                    BufferedOutputStream bos = new BufferedOutputStream(toSocket.getOutputStream());
                    System.out.println("Connection successful!\nChoose your file to send!");
                    FileChooser chooser = new FileChooser();
                    File file = chooser.showOpenDialog(new Stage());
                    FileInputStream fis = new FileInputStream(file);
                    System.out.println("Sending file...");
                    bos.write(fis.read());
                    bos.flush();
                    System.out.println("Send succesful!");
                    fis.close();
                    bos.close();
                    toSocket.close();
                    fromSocket = server.accept();
                    break;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {
        try {
            NewFileServer newFileServer = new NewFileServer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
