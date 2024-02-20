package kit.develop.java.seminar_5_multithreading.example_4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    //    В рамках выполнения задачи необходимо:
//    3 бегуна должны прийти к старту гонки
//    Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
//    Программа должна отсчитать “На старт”, “Внимание”, “Марш”
//    Программа должна завершиться когда все участники закончат гонку.
//    Подумайте об использовании примитива синхронизации


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);

        Runner runner1 = new Runner("Bjondaalleenn", countDownLatch);
        Runner runner2 = new Runner("Spartak", countDownLatch);
        Runner runner3 = new Runner("Dinamo", countDownLatch);

        runner1.start();
        runner2.start();
        runner3.start();

        while (countDownLatch.getCount() != 1) {
            Thread.sleep(100);
        }

        System.out.println("На старт");
        Thread.sleep(1000);
        System.out.println("Внимание");
        Thread.sleep(1000);
        System.out.println("Марш!!!");

        countDownLatch.countDown();
    }
}
