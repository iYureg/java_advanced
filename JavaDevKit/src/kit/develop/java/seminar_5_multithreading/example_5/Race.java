package kit.develop.java.seminar_5_multithreading.example_5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race extends Thread {
    private List<Runner> runners;
    private CountDownLatch cdl;

    public Race() {
        cdl = new CountDownLatch(3);

        runners = new ArrayList<>(3);
        runners.add(new Runner("Вася", cdl));
        runners.add(new Runner("Петя", cdl));
        runners.add(new Runner("Саша", cdl));
    }

    @Override
    public void run() {

        try {
            goOnStart();
            cdl.await();
            goAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goAll() throws InterruptedException {
            sleep(1000);
        System.out.println("На старт");
        sleep(1000);
        System.out.println("Внимание");
        sleep(1000);
        System.out.println("Марш");

        for (int i = 0; i < 3; i++) {
            runners.get(i).go();
            
        }
    }

    private void goOnStart(){
        for(Runner runner : runners){
            runner.start();
        }
    }


}
