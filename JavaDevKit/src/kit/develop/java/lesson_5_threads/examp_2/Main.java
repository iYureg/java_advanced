package kit.develop.java.lesson_5_threads.examp_2;

import kit.develop.java.lesson_5_threads.examp_2.TicTac;

public class Main {
    public static void main(String[] args) {
        Thread tic = new Thread(new TicTac("["));
        Thread tac = new Thread(new TicTac("]"));
        // tic.setDaemon(true);
        // tac.setDaemon(true);
        tic.start();
        tac.start();
    }
}
