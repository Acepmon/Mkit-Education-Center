package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class FileServerReceiveFromClient {
private static boolean a = true;
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(4040);
        System.out.println("Server running...");
        System.out.println("Waiting connection on 4040 port");
        while(true) {
        Socket sk = server.accept();
        System.out.println("Server accepted client");
        InputStream input = sk.getInputStream();
        BufferedReader inReader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        BufferedWriter outReader = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
        String filename = inReader.readLine();
        if (!filename.equals("")) {
            outReader.write("READY\n");
            outReader.flush();
        }
        System.out.println(filename);
        FileOutputStream wr = new FileOutputStream(new File("E://" + filename));
        byte[] buffer = new byte[sk.getReceiveBufferSize()];
        int bytesReceived = 0;
        while ((bytesReceived = input.read(buffer)) > 0) {
            wr.write(buffer, 0, bytesReceived);
        }
        wr.close();
        }
        
    }

}
