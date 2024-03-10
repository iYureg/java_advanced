package gb.junior.Lesson_1_lambda_and_stream_API.functional_interface;

import lombok.Data;

@Data
public class Main {

    public static void main(String[] args) {
        PlainInterface1 plainInterface1 = new PlainInterface1() {
            @Override
            public String action(int x, int y) {
                return String.valueOf(x + y);
            }
        };

        PlainInterface1 plainInterface2 = (n1, n2) -> String.valueOf(n1 + n2);
        PlainInterface1 plainInterface3 = (x, y) -> String.valueOf(Integer.compare(x, y));

        System.out.println(plainInterface1.action(10, 11) + " - " + plainInterface1.getClass().getName() + "  <--- Main$1\n\n");
        System.out.println(plainInterface2.action(1, 11) + " - " + plainInterface2.getClass().getName() + "  <--- Main$$Lambda$1\n\n");
        System.out.println(plainInterface3.action(2, 1) + " - " + plainInterface3.getClass().getName() + "  <--- Main$$Lambda$2\n\n");


        PlainInterface2 plainInterface4 = Integer::compare;
        System.out.println(plainInterface4.action(1, 2));

        PlainInterface2 plainInterface5 = Integer::sum;
        System.out.println(plainInterface5.action(3, 3));

        //---------------------------------------------------
        Runnable obj = new Runnable() {  // Runnable obj = new Main$1();
            @Override
            public void run() {

            }
        };
        // public class Main$1 implements Runnable {
        //      @Override
        //      public void run() {
        //      ...
        //      }
        // }
        System.out.println(obj.getClass().getName() + "  <--- Main$2\n\n");

        //-----------------------------------------------------
        new Thread(
//                new Runnable() {
//            @Override
//            public void run
                ()
                        ->
                {

                }
//        }
        ).start();

        Runnable r1 = () -> {
            System.out.println("r1");
        };

        Runnable r2 = () -> {
            System.out.println("r2");
        };

        new Thread(() -> {
            new Thread(r1).start();
            new Thread(r2).start();
        }).start();

    }
}