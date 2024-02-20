package kit.develop.java.seminar_5_multithreading.example_4;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread{
    private String name;
    CountDownLatch countDownLatch;
    private Random rnd = new Random();

    public Runner (String name, CountDownLatch countDownLatch){
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    public void getReady() throws InterruptedException {
        System.out.println(name + " moving to start ");
        Thread.sleep(rnd.nextInt(3000, 5000));
        System.out.println(name + " ready: ");
        countDownLatch.countDown();
    }
    public void getFinished() throws InterruptedException {
        System.out.println(name + " is running: ");
        Thread.sleep(rnd.nextInt(5000, 10000));
        System.out.println(name + " finished");
    }
    @Override
    public void run() {
        try {
            getReady();
            countDownLatch.await();
            getFinished();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
