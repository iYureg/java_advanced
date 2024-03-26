package gb.junior.Lesson_5_client_server.examples;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExamp2 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket client = new Socket(address, 1300);

            System.out.println(client.getInetAddress());
            System.out.println(client.getLocalPort());

            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();
            DataInputStream dis = new DataInputStream(is);
            PrintStream ps = new PrintStream(os);

            ps.println("Привет!");
            System.out.println(dis.readLine());
            client.close();
        } catch (UnknownHostException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
