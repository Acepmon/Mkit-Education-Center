package Server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SendFiles {

    private static File[] files;
    static String directory = "E:\\ServerFiles\\images";

    public SendFiles() throws IOException {
        File dir = new File("E:\\ServerFiles\\images");
        dir.mkdirs();
        files = new File(directory).listFiles();
        File s = new File("E:\\ServerFiles\\images\\notnull.jpg");
        s.createNewFile();

        System.out.println("SendFile: Total Files inside E:\\ServerFiles\\images = " + dir.list().length);
        MainClass.setOutputMessage("SendFile: Total Files inside E:\\ServerFiles\\images = " + dir.list().length);

        System.out.println("SendFile: Server Started!");
        MainClass.setOutputMessage("SendFile: Server Started!");
        while (true) {
            System.out.println("SendFile: Total Files inside E:\\ServerFiles\\images = " + dir.list().length);
            try {
                System.out.println("/*************************************************************************/");
                System.out.println("SendFile: Waiting connection on 5050 port ...");
                MainClass.setOutputMessage("SendFile: Waiting connection on 5050 port ...");
                Socket socket = MainClass.bigsocket.accept();
                System.out.println("SendFile: Someone connected from " + socket.getInetAddress());
                MainClass.setOutputMessage("SendFile: Someone connected from " + socket.getInetAddress());
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                DataOutputStream dos = new DataOutputStream(bos);
                dos.writeInt(files.length);
                for (File file : files) {
                    long length = file.length();
                    dos.writeLong(length);
                    String name = file.getName();
                    dos.writeUTF(name);
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    int theByte = 0;
                    byte[] buffer = new byte[socket.getSendBufferSize()];
                    while ((theByte = bis.read(buffer)) > -1) {
                        bos.write(buffer, 0, theByte);
                    }
                    bis.close();
                }
                System.out.println("SendFile: Files will be saved to Client's '...\\Temp\\Edu-Center\\Images\\' Folder! ");
                MainClass.setOutputMessage("SendFile: Files will be saved to Client's '...\\Temp\\Edu-Center\\Images\\' Folder! ");
                dos.close();
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}
