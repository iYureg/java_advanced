package kit.develop.java.seminar_5_multithreading.example_2;

public class Main {
    public static void main(String[] args) {


        Friend friend1 = new Friend("Вася");

        Friend friend2 = new Friend("Петя");

        MyThread myThread1 = new MyThread(friend1, friend2);

        MyThread myThread2 = new MyThread(friend2, friend1);

        myThread1.start();
        myThread2.start();

        System.out.println("/// to be continued ...");
    }
}
