package kit.develop.java.seminar_5_multithreading.homework.source;

import java.util.concurrent.Semaphore;

public class Fork {
    private final Semaphore semaphore = new Semaphore(1);
    public void pickUp() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void putDown() {
        semaphore.release();
    }
}
