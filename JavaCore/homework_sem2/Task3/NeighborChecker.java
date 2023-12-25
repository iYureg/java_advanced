package JavaCore.homework_sem2.Task3;

/**
 * Написать функцию, возвращающую истину, если в переданном массиве есть два
 * соседних элемента, с нулевым значением
 */
public class NeighborChecker {
    public static boolean chekZero(int[] arr) {
        if (arr.length < 2)
            return false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && arr[i + 1] == 0)
                return true;
        }
        return false;
    }
}