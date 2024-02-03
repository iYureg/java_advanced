package kit.develop.java.homeworks.sem_1.client;

import kit.develop.java.homeworks.sem_1.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientWindow extends JFrame implements ClientView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JTextArea textArea;
    JTextField textFieldIpAddress, textFieldPort, textFieldLogin, textFieldMessage;
    JPasswordField passwordField;
    JButton btnLogin, btnSend;
    JPanel panelTop;

    private Client client;


    public ClientWindow(ServerWindow server) {
        setting(server);
        createPanel();
        setVisible(true);
    }

    private void setting(ServerWindow server) {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Client");
        setLocation(server.getX() - 500, server.getY());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        client = new Client(this, server.getConnection());
    }

    @Override
    public void printMessage(String msg) {
        textArea.append(msg);
    }

    @Override
    public void disconnect() {
        hideTopPanel(true);
        client.disconnect();
    }

    public void hideTopPanel(boolean visible) {
        panelTop.setVisible(visible);
    }

    public void login() {
        if (client.connect(textFieldLogin.getText())) {
            panelTop.setVisible(false);
        }
    }

    private void message() {
        client.sendMessage(textFieldMessage.getText());
        textFieldMessage.setText("");
    }

    private void createPanel() {
        add(createTopPanel(), BorderLayout.NORTH);
        add(createTextArea());
        add(createBottomPanel(), BorderLayout.SOUTH);
    }

    private Component createTopPanel() {
        panelTop = new JPanel(new GridLayout(2, 3));
        textFieldIpAddress = new JTextField("127.0.0.1");
        textFieldPort = new JTextField("8189");
        textFieldLogin = new JTextField("Ivan Ivanovich");
        passwordField = new JPasswordField("123456");
        btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        panelTop.add(textFieldIpAddress);
        panelTop.add(textFieldPort);
        panelTop.add(new JPanel());
        panelTop.add(textFieldLogin);
        panelTop.add(passwordField);
        panelTop.add(btnLogin);

        return panelTop;
    }

    private Component createTextArea() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        return new JScrollPane(textArea);
    }

    private Component createBottomPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        textFieldMessage = new JTextField();
        textFieldMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    message();
                }
            }
        });
        btnSend = new JButton("send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });

        panel.add(textFieldMessage);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            disconnect();
        }
    }
}
