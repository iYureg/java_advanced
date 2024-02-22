package kit.develop.java.seminar_5_multithreading.homework.source;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Diner {
    private final int MEMBERS;
    private final List<Philosopher> philosophers;
    private final List<Fork> forks;

    @Getter
    private final ReentrantLock roundTable;


    public Diner(int members) {
        MEMBERS = members;
        this.roundTable = new ReentrantLock();
        this.philosophers = new ArrayList<>();
        this.forks = new ArrayList<>();

        for (int i = 0; i < MEMBERS; i++) forks.add(i, new Fork());

        for (int i = 0; i < MEMBERS; i++) {
            philosophers.add(new Philosopher("Философ_" + (i + 1), forks.get(i), forks.get((i + 1) % MEMBERS), getRoundTable()));
            new Thread(philosophers.get(i)).start();
        }

    }
}
