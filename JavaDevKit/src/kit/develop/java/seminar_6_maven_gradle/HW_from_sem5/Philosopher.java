package kit.develop.java.seminar_6_maven_gradle.HW_from_sem5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private String name;
    private int leftFork;
    private int rightFork;
    private int countEat;
    private Random random;
    private CountDownLatch cdl;
    private Table table;

    @Override
    public void run() {
        while (countEat < 3){
            try{
                thinking();
                eating();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println(name + " наелся до отвала");
        cdl.countDown();
    }

    public Philosopher(String name, Table table, int leftFork, int rightFork, CountDownLatch cdl) {
        this.name = name;
        this.table = table;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        random = new Random();
        countEat = 0;
    }

    private void eating() throws InterruptedException {
        if(table.tryGetForks(leftFork, rightFork)){
            System.out.println(name + " уплетает вермишель, используя вилки: " + leftFork + " и " + rightFork);
            sleep(random.nextLong(3000, 6000));
            table.putForks(leftFork, rightFork);
            System.out.println(name + " покушал, можно и помыслить. " +
                    " Не забыв при этом вернуть вилки " + leftFork + " и " + rightFork);
            countEat++;
        }
    }

    private void thinking() throws InterruptedException {
        sleep(random.nextLong(100, 2000));
    }
}
