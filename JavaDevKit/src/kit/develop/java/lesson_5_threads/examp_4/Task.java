package kit.develop.java.lesson_5_threads.examp_4;

public class Task implements Runnable{

    private int value;

    public Task(int left) {
        this.value = left;
    }

    public void inc(){
        // [copy = value, copy + 1, value = copy] - 3 operations
        value++;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void run() {
        System.out.println(value);
    }

    @Override
    public String toString() {
        return String.format("(%s)", value);
    }
}
