package kit.develop.java.seminar_5_multithreading.example_3;

public class Main {
    //    В рамках выполнения задачи необходимо:
    //    Создайте два потока A и B.
    //    Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд
    //            (true в состояние false и наоборот).
    //    Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет от 100
    //    с задержкой 100 миллисекунд и приостанавливает свое действие, как только поток A переключит switche
    //    в состояние false.
    //    Условием завершения работы потоков является достижение отсчета нулевой отметки.


    private static volatile boolean switcher = true;
    private static volatile boolean work = true;
    // private static final AtomicBoolean switcher = new AtomicBoolean(true);
    // private static boolean switcher = true;
    static Thread changer = new Thread(new Runnable() {
        @Override
        public void run() {
            while (work) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                switcher = !switcher;
                System.out.println(switcher);
//                switcher.set(!switcher.get());
//                System.out.println(switcher.get());
            }
        }
    });
    static Thread counter = new Thread(new Runnable() {
        @Override
        public void run() {
            int count = 100;
            while (count > 0) {
//                if (switcher.get()) {
                if (switcher) {
                    System.out.println(count--);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                work = false;
//                System.out.println();  // bla bla bla
            }
        }
    });

    public static void main(String[] args) {

        changer.start();
        counter.start();

    }
}
