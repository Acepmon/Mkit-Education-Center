package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ReceiveFile {

    public ReceiveFile() {

        try {

            ServerSocket server = new ServerSocket(4040);
            System.out.println("Server running...");
            System.out.println("Waiting connection on 4040 port");
            MainClass.setOutputMessage("Server running...");
            MainClass.setOutputMessage("Waiting connection on 4040 port");
            while (true) {
                Socket sk = server.accept();
                System.out.println("Server accepted client");
                MainClass.setOutputMessage("Server accepted client");

                InputStream input = sk.getInputStream();
                BufferedReader inReader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                BufferedWriter outReader = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
                String filename = inReader.readLine();
                if (!filename.equals("")) {
                    outReader.write("READY\n");
                    outReader.flush();
                }
                System.out.println(filename);
                MainClass.setOutputMessage("" + filename);

                FileOutputStream wr = new FileOutputStream(new File("E://ServerFiles//images//" + filename));
                byte[] buffer = new byte[sk.getReceiveBufferSize()];
                int bytesReceived = 0;
                while ((bytesReceived = input.read(buffer)) > 0) {
                    wr.write(buffer, 0, bytesReceived);

                }
                MainClass.th3stop();
                wr.close();
                sk.close();

                System.out.println("Stopped thread!!!");
                System.out.println("Received file");
                MainClass.th3start();
                System.out.println("Started Thread!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Started thread!");

    }
}
