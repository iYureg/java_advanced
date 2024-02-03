package kit.develop.java.homeworks.sem_1;

import kit.develop.java.homeworks.sem_1.client.ClientWindow;
import kit.develop.java.homeworks.sem_1.server.ServerWindow;

public class App {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientWindow(serverWindow);
        new ClientWindow(serverWindow);
    }
}
