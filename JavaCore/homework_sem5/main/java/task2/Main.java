package task2;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int[] stats = new int[9];
        for (int i = 0; i < stats.length; i++) {
            stats[i] = r.nextInt(4);
        }


        Game game = new Game(stats);
        try {
            game.write("game.txt");
            game.read("game.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        game.print();
    }
}
