package kit.develop.java.lesson_5_threads.examp_1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //        System.out.println("Hello world!");
        //        System.out.println(Thread.currentThread().getName());

        // MyThread
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread();
            thread.start();

            // убиваем многопоточность
//            thread.join();
        }

        // MyRunnable
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();

            // убиваем многопоточность
//            thread.join();

        }

//        // anonymous
//        for (int i = 0; i < 5; i++) {
//          new  Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("Hello from anonymous " + Thread.currentThread());
//                }
//            }).start();
//        }
//
//        // lambda
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                System.out.println("Hello from lambda " + Thread.currentThread());
//            }).start();
//        }
    }
}
