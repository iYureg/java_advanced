package kit.develop.java.seminar_5_multithreading.example_5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread{

    private Random rnd;
    private String name;
    private double speed;
    private CountDownLatch cdl;

    public Runner(String name, CountDownLatch cdl){
        this.name = name;
        this.cdl = cdl;
        this.rnd = new Random();
        this.speed = rnd.nextDouble(2, 7);
    }

    @Override
    public void run(){
        try {
            goOnStart();
            synchronized (this) {
                wait();
            }
            goOnFinish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goOnStart() throws InterruptedException {
        System.out.println(name + " идет на старт");
        sleep(rnd.nextInt(2, 5) * 1000L);
        System.out.println(name + " пришел на старт");
        cdl.countDown();
    }

    private void goOnFinish() throws InterruptedException {
        System.out.println(name + " Running...");
        sleep((long) (speed * 1000));
        System.out.println(name + " финишировал");
    }

    public void go(){
        synchronized (this){
            notify();
        }
    }
}
