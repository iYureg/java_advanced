package kit.develop.java.lesson_5_threads.examp_1;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("Hello from MyThread " + Thread.currentThread());
    }
}
