package kit.develop.java.seminar_4_collections;

// 1. Создать коллекцию мужских и женских имен с помощью интерфейса List
// 2. Отсортировать коллекцию в алфавитном порядке
// 3. Отсортировать коллекцию по количеству букв в слове
// 4. Развернуть коллекцию

import java.util.*;

public class NamesList {

    public static void main(String[] args) {
        List<String> names = generator(10);
        for(String s : names) System.out.println(s);

        System.out.println();

        alphabetSort(names);
        for (String s : names) System.out.println(s);

        System.out.println();

        names = sortByLength(names);
        for (String s : names) System.out.println(s);

        System.out.println();

        names = reverseList(names);
        for (String s : names) System.out.println(s);

    }




    private static List<String> reverseList(List<String> list){
        return list.stream().sorted(Collections.reverseOrder()).toList();
    }

    private static List<String> sortByLength(List<String> list){
        return list.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    private static void alphabetSort(List<String> list){
        Collections.sort(list);
    }
    private static List<String> generator(int size){
        Random rnd = new Random();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            char[] word = new char[rnd.nextInt(8)+3];
            for(int j = 0; j < word.length; j++) {
                word[j] = (char)('a' + rnd.nextInt(26));
            }
            String string = new String(word);
            string = string.toUpperCase().charAt(0) + string.substring(1, string.length() - 1);
            result.add(string);
        }
        return result;
    }
}
