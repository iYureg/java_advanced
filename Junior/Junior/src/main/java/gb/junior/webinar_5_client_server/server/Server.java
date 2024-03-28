package gb.junior.webinar_5_client_server.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Server {
    public static final int PORT = 8181;

    public static void main(String[] args) {
        Map<String, ClientHandler> clients = new ConcurrentHashMap<>();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Подключился новый клиент: " + client);

                PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true);
                clientOut.println("Новое подключение. Введите ваш идентификатор");

                Scanner clientIn = new Scanner(client.getInputStream());
                String clientId = clientIn.nextLine();
                System.out.println("Идентификатор клиента " + client + ": " + clientId);

                String allClients = clients.entrySet().stream()
                        .map(it -> "id = " + it.getKey() + ", client = " + it.getValue().getClientSocket())
                        .collect(Collectors.joining("\n"));
                clientOut.println("Список клиентов: \n" + allClients);

                ClientHandler clientHandler = new ClientHandler(client, clients);
                new Thread(clientHandler).start();

                for (ClientHandler entry : clients.values()) {
                    entry.send("Подключился новый клиент: " + client + ", id = " + clientId);
                }
                clients.put(clientId, clientHandler);
            }
        } catch (IOException e) {
            throw new RuntimeException(PORT + " порт занят ", e);
        }
    }
}
