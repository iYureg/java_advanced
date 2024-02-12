package kit.develop.java.seminar_2.homework.client;


import kit.develop.java.seminar_2.homework.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Класс ClientWindow наследует класс JFrame и реализует интерфейс ClientView.
 * Предназначен для создания окна "Chat client" с установленными параметрами и кнопками.
 */

public class ClientWindow extends JFrame implements ClientView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JTextArea log;
    JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    JPasswordField password;
    JButton btnLogin, btnSend;
    JPanel headerPanel;

    private Client client;

    /**
     * ClientWindow - метод запуска процесса формирования окна ""Chat client".
     **/
    public ClientWindow(ServerWindow server) {
        setting(server);
        createPanel();
        setVisible(true);
    }

    /**
     * Метод setting устанавливает свойства для окна приложения.
     * Методы setSize() и setResizable() устанавливают размеры окна и возможность его изменения пользователем.
     * Метод setTitle() изменяет заголовок окна, а setLocation() размещает окно относительно экрана.
     * Метод setDefaultCloseOperation() обеспечивает сокрытие окна при работающей программе.
     * Создается экземпляр класса Client с передачей текущего окна в качестве аргумента,
     * а также server.getConnection().
     **/
    private void setting(ServerWindow server) {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        setLocation(server.getX() - 500, server.getY());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        client = new Client(this, server.getConnection());
    }

    /**
     * showMessage реализует метод, объявленные в интерфейсе ClientView, по выводу сообщения.
     */
    @Override
    public void showMessage(String msg) {
        log.append(msg);
    }

    /**
     * disconnectFromServer реализует метод, объявленные в интерфейсе ClientView, по отключению от сервера.
     */
    @Override
    public void disconnectFromServer() {
        hideHeaderPanel(true);
        client.disconnectFromServer();
    }

    /**
     * Метод hideHeaderPanel изменяет видимость панели заголовка, делая ее видимой или невидимой
     * в зависимости от переданного параметра.
     *
     * @param visible значение видимости панели (да или нет).
     */
    public void hideHeaderPanel(boolean visible) {
        headerPanel.setVisible(visible);
    }

    /**
     * Метод login выполняет вход в систему. Он проверяет, успешно ли произошло соединение с сервером,
     * используя введенный пользователем текст в качестве логина. Если соединение успешно,
     * то панель headerPanel скрывается.
     */
    public void login() {
        if (client.connectToServer(tfLogin.getText())) {
            headerPanel.setVisible(false);
        }
    }

    /**
     * Метод message отправляет сообщение на сервер: принимает введенный пользователем текст и передает его
     * методу message() клиента. Затем очищает текстовое поле для следующего сообщения.
     */
    private void message() {
        client.sendMessage(tfMessage.getText());
        tfMessage.setText("");
    }

    /**
     * Метод createPanel создает панели пользовательского интерфейса и добавляет на форму.
     * Панель headerPanel добавляется в верхнюю часть формы, log - в середину, а панель footer - в нижнюю часть формы.
     */
    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    /**
     * Метод createHeaderPanel добавляет окна на панель "Клиент", располагая их в две строки и три столбца.
     * Верхняя строка содержит IP-адресс, и № порта, нижняя - ФИО, пароль и кнопку регистрации.
     */
    private Component createHeaderPanel() {
        headerPanel = new JPanel(new GridLayout(2, 3));
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("Ivan Ivanovich");
        password = new JPasswordField("123456");
        btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        headerPanel.add(tfIPAddress);
        headerPanel.add(tfPort);
        headerPanel.add(new JPanel());
        headerPanel.add(tfLogin);
        headerPanel.add(password);
        headerPanel.add(btnLogin);

        return headerPanel;
    }

    /**
     * Метод createLog создает текстовую область панели Клиент, которая будет использоваться для отображения сообщений.
     * Область не является редактируемой, чтобы предотвратить возможность изменения текста пользователем.
     * Затем эта область добавляется в панель, использующую скроллинг для просмотра всего текста.
     *
     * @return - текстовая область панели Клиент.
     */
    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    /**
     * Метод createFooter создает нижнюю строку панели Клиент.
     * Слева размещается поле для ввода сообщений, справа - кнопка отправить сообщение - Send.
     *
     * @return - нижняя строка панели Клиент.
     */
    private Component createFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
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

        panel.add(tfMessage);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    /**
     * Метод обрабатывает события окна: скрывает окно или удаляет его, как указано
     * в параметре свойства defaultCloseOperation.
     * При закрытии окна отключает клиента от сервера.
     *
     * @param e the window event.
     */
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            disconnectFromServer();
        }
    }
}
