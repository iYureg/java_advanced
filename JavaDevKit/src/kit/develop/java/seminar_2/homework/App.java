package kit.develop.java.seminar_2.homework;


import kit.develop.java.seminar_2.homework.client.ClientWindow;
import kit.develop.java.seminar_2.homework.server.ServerWindow;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientWindow(serverWindow);
        new ClientWindow(serverWindow);
    }
}
