package kit.develop.java.lesson_5_threads.examp_5;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class NewTask implements Runnable{
    @Getter
    private final AtomicInteger value;
    @Setter
    private CountDownLatch cdl;
    public NewTask(int value) {
        this.value = new AtomicInteger(value);
    }

    public void inc(){
        // [copy = value, copy + 1, value = copy] - 3 operations

        value.getAndIncrement();
//        synchronized (NewTask.class){
//            value++;
//        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            inc();
        }
        cdl.countDown();
    }

    @Override
    public String toString() {
        return String.format("(%s)", value);
    }
}
