package kit.develop.java.seminar_3.swap;

import java.util.Arrays;

public class Main {
    public static void swap(Object[] obj, int from, int to){
        Object temp = obj[from];
        obj[from] = obj[to];
        obj[to] = temp;
    }

    public static void main(String[] args) {
        try {

            Object[] arr = {1, 2.0f, "Hello"};
            System.out.println(Arrays.toString(arr));
//            swap(arr, 0, 4);
            swap(arr, 0, 2);
            System.out.println(Arrays.toString(arr));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
