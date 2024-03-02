package kit.develop.java.lesson_5_threads.examp_3;

import java.util.Scanner;

public class StatsHelper {
    private static int cnt = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread readThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            // пока существует возможность ввода и поток не прерван
            while (scanner.hasNextLine() && !Thread.interrupted()){
                String line = scanner.nextLine();
                cnt++;
            }
        });
        readThread.setDaemon(true);
        readThread.start();

        // прирывание потока
        readThread.interrupt();

        while (true){
            System.out.println(cnt + " messages inputted by user");
            Thread.sleep(1000);
        }
    }
}
