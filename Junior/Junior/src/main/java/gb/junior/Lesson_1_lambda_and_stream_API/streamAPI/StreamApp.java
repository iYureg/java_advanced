package gb.junior.Lesson_1_lambda_and_stream_API.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.prefs.PreferencesFactory;
import java.util.stream.Stream;

public class StreamApp {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(list);

        // ----- filter & foreach ------
        list.stream()
                // filter -> implement Predicate
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 == 0;
                    }
                })
                // foreach -> implement Consumer
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });

        System.out.println("=".repeat(20) + " filter " + "=".repeat(20));
        list.stream()
                // filter -> implement Predicate
                .filter(i -> i % 2 == 0)
                // foreach -> implement Consumer
                .forEach(System.out::println); // ссылка на метод
        System.out.println();

        List<Integer> out = list.stream()
                .filter(i -> i % 2 == 0)
                .toList();

        System.out.println(out);
        System.out.println("=".repeat(20) + " map " + "=".repeat(20));

        // ----- map -----
        double sum = list.stream().
                // map -> implement Functional interface Function
                        map(new Function<Integer, Integer>() {

                    @Override
                    public Integer apply(Integer integer) {
                        return integer * 5;
                    }
                })
                .map(String::valueOf)
                .map(Integer::valueOf)
                .map(Double::valueOf)
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.println(sum + "\n");


        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        list2.stream()
                .map(z -> {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < z; i++) {
                        builder.append("A");
                    }
                    return builder.toString();
                })
                .forEach(System.out::println);
        System.out.println();

        // count
        System.out.println("=".repeat(20) + " count " + "=".repeat(20));
        System.out.println((list2.stream().count()) + "\n");

        // limit
        System.out.println("=".repeat(20) + " limit " + "=".repeat(20));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(5, 12, 3, 4, 2, 7, 11, 8, 9));
        list3.stream()
                .sorted()
                .limit(3)
                .forEach(System.out::println);
        System.out.println();

        // allMatch | anyMatch | nonMatch
        System.out.println("=".repeat(10) + " allMatch |anyMatch| nonMatch " + "=".repeat(10));

        System.out.println(list3.stream().allMatch(n -> n > 0));
        System.out.println(list3.stream().anyMatch(n -> n < 0));
        System.out.println(list3.stream().noneMatch(n -> n < 0) + "\n");


        // Optional (some container with entry or null)
        List<Integer> list4 = new ArrayList<>(Arrays.asList(5, 12, 3, 4, 12, 7, 11, 8, 9));
        System.out.println("=".repeat(20) + " Optional " + "=".repeat(20));
        Optional<Integer> opt = list4.stream()
                .filter(n -> n < 3)
                .findFirst();
        opt.ifPresent(System.out::println);
        System.out.println(opt.orElse(10));
//        opt.orElseThrow(()-> new RuntimeException("Something wrong"));


        // create stream
        System.out.println("=".repeat(20) + " create stream " + "=".repeat(20));
        List<String> listStream = new ArrayList<>(Arrays.asList("L", "I", "S", "T"));
        listStream.stream().forEach(System.out::print);
        System.out.println();

        String[] arr = {"A", "R", "R", "A", "Y"};
        Stream<String> arrayStream = Arrays.stream(arr);
        arrayStream.forEach(System.out::print);
        System.out.println();

        Stream<String> streamBuilder = Stream.of("B", "U", "I", "D", "E", "R");
        streamBuilder.forEach(System.out::print);
    }
}
