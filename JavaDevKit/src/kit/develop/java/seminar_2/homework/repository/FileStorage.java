package kit.develop.java.seminar_2.homework.repository;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * FileStorage - класс, реализующий интерфейс Repository, предназначен для записи и хранения сообщений чата в файл.
 */
public class FileStorage implements Repository<String> {
    private static final String LOG_PATH = "JavaDevKit/src/kit/develop/java/seminar_2/homework/repository/history.txt";

    /**
     * Метод saveMessage сохраняет переданную строку text в файл, указанный в переменной LOG_PATH.
     * Создается экземпляр FileWriter, который открывается для записи в указанный файл с использованием true в качестве
     * второго аргумента. Если файл существует, его содержимое будет заменено.
     * Текст записывается в файл с помощью метода write(), после чего добавляется символ новой строки.
     *
     * @param text - сообщение в чате.
     */
    @Override
    public void saveMessage(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод readText предназначен для считывания текста из файла и его возврата в виде строки.
     * Создается объект StringBuilder для хранения считанных символов, а также экземпляр класса FileReader,
     * который используется для чтения содержимого файла. В цикле while считывается каждый символ из файла и добавляется
     * в StringBuilder. После того как все символы были прочитаны, удаляется последний символ,
     * который обычно является символом новой строки. Содержимое StringBuilder возвращается в виде строки.
     * Если возникает исключение, то выводится стек trace исключений и возвращается значение null.
     *
     * @return - текст, содержащийся в файле history.txt
     */
    @Override
    public String readText() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
