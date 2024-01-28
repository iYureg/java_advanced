package ru.example.java.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StruchkovExamplesStatelessMethods {
    public static void main(String[] args) {


        // ============= region Distinct ==============
        // пример удаления повторяющихся значений из потока  - ( distinct() )
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 1, 4, 5, 3, 5);

        List<Integer> uniqueNumbers = numbers.stream()
                .distinct() // фильтрация повторов
                .collect(Collectors.toList()); // возвращаем результат в List

        System.out.println(uniqueNumbers); // prints [1, 2, 3, 4, 5]
        // ============= end region ===============


        // ================ region Limit =============
        /**
         * Метод limit(n) возвращает новый поток, содержащий не более n элементов исходного потока.
         * Если исходный поток содержит меньше n элементов, новый поток будет содержать все элементы исходного потока.
         */
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> limitedNumbers = numbers2.stream()
                .limit(5) // задаем количество элементов
                .collect(Collectors.toList()); // терминальная команда возвращает результат выполнения потока

        System.out.println(limitedNumbers); // prints [1, 2, 3, 4, 5]
        // =============== end region =============

        // region Skip
        /**
         * Метод skip(n) возвращает новый поток, который содержит все элементы исходного потока,
         * исключая первые n элементов. Если исходный поток содержит меньше n элементов, новый поток будет пустым.
         */
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> skippedNumbers = numbers3.stream()
                .skip(5) // скипаем первые 5 элементов
                .collect(Collectors.toList()); // сохраняем результат в переменную skippedNumbers

        System.out.println(skippedNumbers); // prints [6, 7, 8, 9, 10]
        // end region

        // ============ region Sorted ============
        /**
         * Метод sorted() создает новый поток, содержащий элементы исходного потока, отсортированные в порядке возрастания.
         * При вызове метода sorted() возвращается новый поток, содержащий те же элементы, что и исходный поток, но в отсортированном порядке.
         *
         * !!! Если элементы исходного потока не реализуют интерфейс Comparable, может возникнуть исключение ClassCastException.
         * !!! Чтобы избежать этого, можно предоставить собственный компаратор в качестве аргумента метода sorted().
         */
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Andrey");

        List<String> sortedNames = names.stream()
                .sorted() // список строк отсортируется по алфавиту
                .collect(Collectors.toList());

        System.out.println(sortedNames); // prints ["Alice", "Andrey", "Bob", "Charlie", "David"]
        // ============== end region ==============

        // ============ region takeWhile ============
        /**
         * Метод takeWhile() создает новый поток, содержащий элементы исходного потока до тех пор,
         * пока они удовлетворяют указанному условию. Если первый элемент потока не соответствует предикату,
         * новый поток будет пустым.
         */
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> takenNumbers = numbers4.stream()
                .takeWhile(n -> n < 7)
                .collect(Collectors.toList());

        System.out.println(takenNumbers); // prints [1, 2, 3, 4, 5, 6]
        // ============== end region ==============



        // ============ region dropWhile ============
        /**
         * Метод dropWhile() возвращает новый поток, который включает все элементы исходного потока,
         * начиная с первого элемента, не удовлетворяющего указанному условию.
         * В момент, когда предикат возвращает false, все последующие элементы из исходного потока включаются в новый поток.
         */

        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> droppedNumbers = numbers5.stream()
                .dropWhile(n -> n < 5)
                .collect(Collectors.toList());

        System.out.println(droppedNumbers); // prints [5, 6, 7, 8, 9, 10]
        // ============== end region ==============



        // ============ region <> ============
        /**
         * Метод peek() создает новый поток, идентичный исходному, но с дополнительной операцией,
         * применяемой к каждому элементу при его прохождении по конвейеру потока.
         */
        List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 5);

        numbers6.stream()
                .peek(System.out::print)
                .collect(Collectors.toList());
        // ============== end region ==============

    }
}
