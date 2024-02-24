package gb.homework;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import lombok.Getter;

import java.util.Map;
import java.util.Random;


public class App {

    @Getter
    private static Random rnd = new Random();
    @Getter
    private static final int ITERATION = 1000;

    public static void main(String[] args) {
        int wins = 0;
        int loses = 0;



        for (Map.Entry<Integer, Boolean> entry : gameProcess().entries()) {
            if (entry.getValue())
                wins++;
            else
                loses++;

        }

        System.out.printf("Выигрышей при смене решения: %d\nПроигрышей при смене решения: %d\n", wins, loses);
        double winPercent = (double) (wins * 100) / getITERATION();
        double losePercent = (double) (loses * 100) / getITERATION();
        System.out.printf("выигрышных комбинаций: %s%%\nпроигрышных комбинаций: %s%%\n", winPercent, losePercent);
    }

    public static Multimap<Integer, Boolean> gameProcess() {

        Multimap<Integer, Boolean> result = HashMultimap.create();

        for (int i = 0; i < getITERATION(); i++) {

            int prise = rnd.nextInt(3);
            int player = 0; // первая дверь по умолчанию

            int empty = prise == 1 ? 2 : 1;

            // выбираем из двух оставшихся вариантов
            player = empty == 1 ? 2 : 1;

            // агрегируем результат
            result.put(i + 1, player == prise);
        }

        return result;
    }
}