package kit.develop.java.homeworks.sem_1.client;

import kit.develop.java.homeworks.sem_1.server.Server;

public class Client {
    private boolean connected;
    private String name;

    private final ClientView view;
    private final Server server;

    public Client(ClientView view, Server server) {
        this.view = view;
        this.server = server;
    }

    public boolean connect(String name) {
        this.name = name;
        if (server.connect(this)) {
            printToTextArea("Connection is established.\n");
            connected = true;
            String log = server.getHistory();
            if (log != null) {
                printToTextArea(log);
            }
            return true;
        } else {
            printToTextArea("Connecting to server ...");
            return false;
        }
    }

    public void disconnect() {
        if (connected) {
            connected = false;
            server.disconnect(this);
            printToTextArea("You are disconnected");
        }
    }

    public void serverResponse(String text) {
        printToTextArea(text);
    }

    public void sendMessage(String text) {
        if (connected) {
            if (!text.isEmpty()) {
                server.sendMessage(name + ": " + text);
            }
        } else {
            printToTextArea("Server is down ...");
        }
    }

    public String getName() {
        return name;
    }

    private void printToTextArea(String text) {
        view.printMessage(text + "\n");
    }

}
