package kit.develop.java.seminar_5_multithreading.homework.source;

import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable{

    @Getter
    private String name;
    private Fork left, right;

    @Getter
    private int meals;

    private ReentrantLock roundTable;

    public Philosopher(String name, Fork left, Fork right, ReentrantLock roundTable) {
        this.name = name;
        this.left = left;
        this.right = right;
        meals = 0;
        this.roundTable = roundTable;
    }

    @Override
    public void run(){
        while (meals < 3) {
             roundTable.lock();
            try {
                left.pickUp();
                right.pickUp();
                eat();
                right.putDown();
                left.putDown();
            } finally {
                roundTable.unlock();
            }
            think();
        }
    }

    private void eat() {
        System.out.println(getName() + " - кушает.");
        meals++;
        System.out.println(getName() + " - покушал " + getMeals() + " раз");
    }

    private void think() {
        System.out.println(getName() + " - размышляет");
    }

}
