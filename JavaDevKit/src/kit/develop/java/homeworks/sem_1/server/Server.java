package kit.develop.java.homeworks.sem_1.server;

import kit.develop.java.homeworks.sem_1.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private boolean isRunning;

    private final ServerView view;
    private final LogInterface log;
    private final List<Client> clients;


    public Server(ServerView view, LogInterface chatLog) {
        this.view = view;
        this.log = chatLog;
        clients = new ArrayList<>();
    }

    public void start() {
        if (isRunning)
            printToTextArea("Server is already running.");
        else
            isRunning = true;
        printToTextArea("Running the server.");

    }

    public void stop() {
        if (!isRunning)
            printToTextArea("Server is not running.");
        else {
            isRunning = false;
            for (Client client : clients) {
                disconnect(client);
            }
            printToTextArea("Server stopped.");
        }
    }

    public boolean connect(Client client) {
        if (!isRunning)
            return false;

        clients.add(client);
        printToTextArea(client.getName() + " connected to chat.");
        return true;
    }

    public void disconnect(Client client) {
        clients.remove(client);
        if (client != null) {
            client.disconnect();
            printToTextArea(client.getName() + " disconnected from chat.");
        }
    }

    public void sendMessage(String text) {
        if (!isRunning)
            return;

        getHistory();
        sendAll(text);
        saveHistory(text);
    }

    private void sendAll(String text) {
        for (Client client : clients) {
            client.serverResponse(text);
        }
    }

    private void printToTextArea(String text) {
        view.printMessage(text + "\n");
    }

    public String getHistory() {
        return log.read().toString();
    }

    private void saveHistory(String text) {
        log.save(text);
    }
}