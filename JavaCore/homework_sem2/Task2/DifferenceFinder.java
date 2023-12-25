package JavaCore.homework_sem2.Task2;

/*
 * Написать функцию, возвращающую разницу между самым большим и самым ма- леньким элементами переданного не пустого массива.
 */
public class DifferenceFinder {

    public static int find(int[] arr) {

        if (arr.length <= 1)
            return 0;

        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        return max - min;
    }
}
