package kit.develop.java.homeworks.sem_1.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame implements ServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JButton btnStart, btnStop;
    JTextArea textArea;
    private Server server;


    public ServerWindow() {
        setting();
        createPanel();
        setVisible(true);
    }

    private void setting() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Server");
        setLocationRelativeTo(null);
        server = new Server(this, new ChatLog());
    }

    @Override
    public void printMessage(String msg) {
        textArea.append(msg);
    }

    public Server getConnection() {
        return server;
    }

    private void createPanel() {
        textArea = new JTextArea();
        add(textArea);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
            }
        });
        panelBottom.add(btnStart);
        panelBottom.add(btnStop);
        return panelBottom;
    }
}
