package kit.develop.java.lesson_5_threads.examp_5;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        NewTask newTask = new NewTask(0);
        CountDownLatch cdl = new CountDownLatch(3);
        newTask.setCdl(cdl);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(newTask);
            thread.start();
        }
        cdl.await();
        System.out.println(newTask.getValue());
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms.");
    }
}
