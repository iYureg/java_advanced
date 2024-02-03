package kit.develop.java.homeworks.sem_1.server;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChatLog implements LogInterface<String> {
    private static final String LOG_PATH = "JavaDevKit/src/kit/develop/java/homeworks/sem_1/server/log.txt";

    @Override
    public void save(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        StringBuilder sb = new StringBuilder("");
        try (FileReader reader = new FileReader(LOG_PATH)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            sb.delete(sb.length() - 1, sb.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
