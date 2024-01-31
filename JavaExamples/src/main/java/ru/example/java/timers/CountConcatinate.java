package ru.example.java.timers;

public class CountConcatinate {
    public static void main(String[] args) {
        long timer = System.nanoTime();


        String s = "Example";
        long count = 200_000;

        for (int i = 0; i < count; i++) {
            s += i;
        }

        double deltatime = (System.nanoTime() - timer) * 0.000000001;

        System.out.println("String delta time (sec): " + deltatime);


        timer = System.nanoTime();
        StringBuilder sb = new StringBuilder("Example");
        for (int i = 0; i < count; i++) {
            sb.append(i);
        }

        deltatime = (System.nanoTime() - timer) * 0.000000001;
        System.out.println("StringBuilder delta time (sec): " + deltatime);

        System.out.println(s.equals(sb.toString()));
    }



}
