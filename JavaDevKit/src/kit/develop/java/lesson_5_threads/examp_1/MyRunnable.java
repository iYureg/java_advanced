package kit.develop.java.lesson_5_threads.examp_1;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from MyRunnable "+ Thread.currentThread());
    }
}
