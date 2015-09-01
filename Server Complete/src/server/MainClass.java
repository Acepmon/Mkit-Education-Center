package Server;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

//Сервер дээр болж буй явцыг textArea-д харуулж ажиллуулах гол үндсэн функц
public class MainClass {

    public static final int ports = 5050;
    private static SurgaltServer server = new SurgaltServer();
    private static ReceiveFile fileServer;
    public static SendFiles fsrs;

    private static String surServ = "Асаах товчийг дарна уу!";

    private static JTextArea area;

    public static Thread th, th2, th3;
    public static ServerSocket bigsocket;

    public static void main(String[] args) throws IOException {
        bigsocket = new ServerSocket(5050);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        JPanel panelRight = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        JPanel panelLeft = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        JFrame frame = new JFrame();
        frame.setTitle("Surgalt Server");
        frame.setContentPane(panel);
        area = new JTextArea(surServ);
        area.setLineWrap(true);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(500, 450));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JButton on = new JButton("Асаах");
        JButton restart = new JButton("Дахин эхлүүлэх");
        panelLeft.add(scroll);
        panel.add(panelLeft);
        panel.add(panelRight);

        JLabel zai = new JLabel();
        zai.setPreferredSize(new Dimension(150, 150));
        panelRight.add(zai);
        panelRight.add(on);
        panelRight.add(restart);
        on.setPreferredSize(new Dimension(150, 30));
        restart.setPreferredSize(new Dimension(150, 30));
        panelRight.setPreferredSize(new Dimension(200, 500));
        panel.setPreferredSize(new Dimension(800, 500));

        on.addActionListener(e -> {
            on();

        });

        restart.addActionListener(e -> {
            off();
            on();
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    //текстийг дэлгэцэнд нэмж буй функц
    public static void setOutputMessage(String message) {
        area.setText(area.getText() + message + "\n\n");
        //   area.setCaretPosition(area.getDocument().getLength());
        area.select(area.getDocument().getLength(), -1);
    }

    //function that turns on the server
    private static void on() {

        th = new Thread(() -> {
            server.start();
        });
        th2 = new Thread(() -> {
            fileServer = new ReceiveFile();
        });

        th3 = new Thread(() -> {
            try {
                fsrs = new SendFiles();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        th.setDaemon(true);
        th2.setDaemon(true);
        th3.setDaemon(true);

        th.start();
        th2.start();
        th3.start();
    }

    //function that turns off the server
    private static void off() {
        server.stop();
        server = null;
        fileServer = null;

        th.interrupt();
        th2.interrupt();
        th3.interrupt();
        th = null;
        th2 = null;
        th3 = null;
    }

    public static void th3start() {
        th3 = new Thread(() -> {
            try {
                fsrs = new SendFiles();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        th3.start();
    }

    public static void th3stop() {
        th3.interrupt();
        th3 = null;
    }
}
