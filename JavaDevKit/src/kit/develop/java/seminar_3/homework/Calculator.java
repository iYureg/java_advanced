package kit.develop.java.seminar_3.homework;

public class Calculator {
    public static  <T extends Number> Number sum(T first, T second){
        return first.floatValue() + second.floatValue();
    }

    public static  <T extends Number> Number mul(T first, T second){
        return first.floatValue() * second.floatValue();
    }

    public static  <T extends Number> Number div(T first, T second){
        return first.floatValue() / second.floatValue();
    }

    public static  <T extends Number> Number sbt(T first, T second){
        return first.floatValue() - second.floatValue();
    }
}
