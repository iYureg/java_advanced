package gb.junior.webinar_5_client_server.client;

import gb.junior.webinar_5_client_server.server.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;


public class Client {
    public static void main(String[] args) {
        try {
            Socket serverSocket = new Socket("localhost", Server.PORT);
            System.out.println("Установлено подключение к " + serverSocket.getInetAddress() + ": " + Server.PORT);

            Scanner serverIn = new Scanner(serverSocket.getInputStream());
            String input = serverIn.nextLine();
            System.out.println("Сообщение от сервера: " + input);

            new PrintWriter(serverSocket.getOutputStream(), true).println(UUID.randomUUID());

            new Thread(new ServerReader(serverSocket)).start();
            new Thread(new ServerWriter(serverSocket)).start();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось подключиться к серверу: " + e.getMessage(), e);
        }
    }
}
