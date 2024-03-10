package gb.junior.Lesson_1_lambda_and_stream_API.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Привет", "мир", "!", "я", "родился", "!");

        list.stream()
                .filter(str -> str.length() > 4)
                .filter(str -> str.contains("о"))
                .forEach(System.out::println);

        System.out.println();
//-------------------------------------------------------------

        Arrays.asList(1,10,5,0,7,5).stream()
                .sorted((o1, o2) -> o2 - o1)
                .distinct()
                .map(integer -> "integer: " + integer + ". square of integer - " +  integer*integer)
                .forEach(System.out::println);

        System.out.println();
//-------------------------------------------------------------

        System.out.println(
                Arrays.asList(1,10,5,0,7,5).stream()
                        .sorted((o1, o2) -> o2 - o1)
//                        .sorted()
                        .distinct()
                        .findFirst()
                        .get()
        );
    }

}
