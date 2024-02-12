package kit.develop.java.seminar_3.fruits;

public class Apple implements Fruit {
    public static final float WEIGHT = 1.0f;

    @Override
    public float getWeight(){
        return WEIGHT;
    }

    @Override
    public String toString(){
        return "Apple";
    }
}
