package kit.develop.java.seminar_5_multithreading.example_1;

public class Main {
    //    В рамках выполнения задачи необходимо:
    //    Создать два класс ObjectA, ObjectB
    //    Реализовать класс в котором два потока при запуске провоцируют DeadLock для объектов ObjectA, ObjectB
    public static void main(String[] args) {
        ObjectA objectA = new ObjectA();
        ObjectB objectB = new ObjectB();

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectA) {
                    System.out.println(Thread.currentThread().getName() + ": object A is locked");
                    synchronized (objectB) {
                        System.out.println(Thread.currentThread().getName() + ": object B is locked");
                    }
                }
            }
        });

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectB) {
                    System.out.println(Thread.currentThread().getName() + ": object B is locked");
                    synchronized (objectA) {
                        System.out.println(Thread.currentThread().getName() + ": object A is locked");
                    }
                }
            }
        });

        firstThread.start();
        secondThread.start();

        System.out.println("Hello from Main");
    }
}
