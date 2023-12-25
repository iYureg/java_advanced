package JavaCore.homework_sem2.Task1;

public class EvensCounter {

    public static int count(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                count++;
        }
        return count;
    }
}