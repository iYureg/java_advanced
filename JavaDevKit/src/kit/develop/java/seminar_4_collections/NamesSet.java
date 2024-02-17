package kit.develop.java.seminar_4_collections;

import java.util.*;
import java.util.stream.Collectors;


// Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
// Получите уникальный список Set на основании List
// Определите наименьший элемент (алфавитный порядок)
// Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
// Удалите все элементы содержащие букву ‘A’
public class NamesSet {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>() {{
            add("Дмитрий");
            add("Дмитрий");
            add("Дмитрий");
            add("Ольга");
            add("Екатерина");
            add("Иван");
            add("Ольга");
            add("Татьяна");
        }};
        Set<String> uniqueNames = getUnique(names);
        System.out.println(uniqueNames);

        System.out.println(getMin(uniqueNames));
        System.out.println(getMax(uniqueNames));
        System.out.println(uniqueNames);
//        System.out.println(deleteSomeLoop(uniqueNames));
//        System.out.println(deleteSomeFilter(uniqueNames));
        deleteSome(uniqueNames);
        System.out.println(uniqueNames);
    }

    public static Set<String> getUnique(List<String> values){
        return new HashSet<>(values);
    }

    public static String getMin(Set<String> names) {
        return names.stream().max(Comparator.naturalOrder()).orElse(null);
    }

    public static String getMax(Set<String> names) {
        return names.stream().min(Comparator.comparing(String::length)).orElse(null);
    }

    public static void deleteSome(Set<String> names) {
        names.removeIf(x -> x.contains("А") || x.contains("а"));
    }

    public static Set<String> deleteSomeFilter(Set<String> names) {
        return names.stream().filter(x -> !x.contains("А") && !x.contains("а")).collect(Collectors.toSet());
    }

    public static Set<String> deleteSomeLoop(Set<String> names) {
        Set<String> result = new HashSet<>();
        for (String s : names) {
            if (!s.contains("А") && !s.contains("а")) result.add(s);
        }
        return result;
    }
}
