package gb.junior.Webinar_1_lambda_and_stream_API;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class Optionals {
    public static void main(String[] args) {
        String s = "kldjslkfslkjdsfsdjsKLdLKDJKLDFLKJSkllsdf";

        String collect = s.chars() // IntStream
                .filter(it -> {
                    char symbol = (char) it;
                    String symbolStr = String.valueOf(symbol);
                    String symbolStrUpperCase = symbolStr.toUpperCase();
                    return symbolStr.equals(symbolStrUpperCase);
                })
                .mapToObj(it -> String.valueOf((char) it))
                .collect(Collectors.joining("-"));
        System.out.println(collect);


        List<String> langs = List.of("Java", "C++", "Python", "Kotlin", "Go");

        langs.stream()
                .filter(it -> it.length() < 3)
                .findFirst() // Optional<String> "Go"
                .map(String::toUpperCase) // Optional<String> "GO"
                .ifPresentOrElse(Optionals::saveToDB, () -> System.out.println("нет значения"));

//        String lang = first.orElse("Unknown");
//        System.out.println(lang);
//
//        first.ifPresent(System.out::println);
//        first.ifPresentOrElse(System.out::println, () -> System.out.println("No value present"));
//
//        String s2 = first.orElseThrow(() -> new IllegalStateException("нет значения, а оно должно быть"));
//
//        Optional<String> uppered = first.map(it -> it.toUpperCase());
//
//        String s1 = first.get();
//        System.out.println(s1);

    }


    private static void saveToDB(String langName){
        System.out.println(langName);
    }
}
