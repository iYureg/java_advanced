package kit.develop.java.lesson_4.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrList {

    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1,2,3,4,5);
        ArrayList<Integer> list = new ArrayList<>(collection);

        // [] <- 1
        // [_], [1] <- 2
        // [1], [_ _], [1 _], [1 2] <- 3
        // [1 2], [_ _ _ _], [1 2 _ _], [1 2 3 _] <- 4 O(1)

        // [1 2 3 4 5] <- 7 (index 2) алгоритм вставки элемента O(n)
        // [_ _ _ _ _ _ _ _ _ _] 1. выделение памяти
        // [1 2 3 4 5 _ _ _ _ _] 2. копирование элементов
        // [1 2 3 3 4 5 _ _ _ _] 3. сдвиг элементов
        // [1 2 7 3 4 5 _ _ _ _] 4. вставка элемента

        // list.get(index) O(1)
        // list.set(index, element) O(1)
        // list.contains(element) O(n)
    }
}
