package ru.example.java.primitiveTypes;

public class ExamDouble {
    static Double num = 10.0;
    static Float fNum = 10.0f;

    public static void main(String[] args) {
        System.out.printf("round: %d real: %s",Math.round(num / 3), Double.toString(num / 3));
        System.out.println();
        System.out.printf("round: %d real: %s",Math.round(fNum / 3), Float.toString(fNum / 3));
    }


}
