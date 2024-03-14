package gb.junior.Webinar_1_lambda_and_stream_API;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;
import java.util.stream.Stream;

public class Lambdas {
    public static void main(String[] args) {
//        lambdasIntro();
//        comparatorDemo();
//        methodReferences();

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            integers.add(ThreadLocalRandom.current().nextInt(100));
        }

        // Все числа меньше 50 нужно умножить на 2 и распечатать на консоль
        integers.stream()
//                .parallel()
                .filter(x -> x < 50)
                .map(x -> x * 2)
//                .sequential()
                .forEach(System.out::println);

        // Создать стрим со случайными числами, взять первые 5 элементов и сохранить их в List
        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(100))
                .limit(5)
                .toList();

        Stream.concat(
                Stream.iterate(0, x -> x + 1).limit(10),
                Stream.iterate(10, x -> x - 1).limit(11)
        )
                .map(integer -> integer + " ")
                .forEach(System.out::print);
    }



    private static void methodReferences() {
        Function<String, Integer> stringLengthExtractor = String::length;
        System.out.println(stringLengthExtractor.apply("string"));
        System.out.println(stringLengthExtractor.apply("world"));
        System.out.println(stringLengthExtractor.apply("python"));
        System.out.println(stringLengthExtractor.apply("C++"));

        // Предикат, который сравнивает все входящие строки со строкой "Java"
        Predicate<String> javaTester = "Java"::equals; // str -> "Java".equals(str);
        System.out.println(javaTester.test("java"));
        System.out.println(javaTester.test("Java"));
        System.out.println(javaTester.test(""));
        System.out.println(javaTester.test("Python"));
        System.out.println(javaTester.test("123"));


        Supplier<ArrayList<Integer>> arrayListSupplier = ArrayList::new; // new ArrayList<>();
        IntFunction<ArrayList<Integer>> arrayListSupplierWithCapacity = ArrayList::new; // new ArrayList<>(int capacity);

        ArrayList<Integer> arrayList = arrayListSupplier.get(); // new ArrayList<>();
        ArrayList<Integer> arrayListWithCapacity =  arrayListSupplierWithCapacity.apply(100); // new ArrayList<>(100);
    }

    private static void comparatorDemo() {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        integers.add(5);
        integers.add(2);
        integers.add(10);
        integers.add(15);
        integers.add(23);
        integers.add(63);
        System.out.println(integers);

        // sort -> evens -> odd ( 2 4 6 1 3 5 )

//        Collections.sort(integers);
//        Collections.reverse(integers);
//        System.out.println(integers);


        // method reference (ссылка на метод)
        Collections.sort(integers, Lambdas::compareIntegers);
        System.out.println(integers);
    }

    private static int compareIntegers(int x, int y) {
        if (x % 2 == 0 && y % 2 != 0) {
            return -1;
        } else if (x % 2 != 0 && y % 2 == 0) {
            return 1;
        }
        return Integer.compare(x, y);
    }

    private static void lambdasIntro() {
        Foo foo = () -> System.out.println("Hello world!");
        foo.foo();

        // Лямбда, которая принимает целое число и возвращает его квадрат
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5));

        // Лямбда, которая принимает строку, возвращает ее длину
        Function<String, Integer> lengthExtractor = (s -> s.length());
        System.out.println(lengthExtractor.apply("String"));

        // Лямбда, которая принимает строку и печатает ее в консоль
        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("Hello, world!");

        // Лямбда, которая генерирует случайные целые числа в диапазоне от 0 до 100
        Supplier<Integer> randomer = () -> new Random().nextInt(101);
        System.out.println(randomer.get());

        // Лямбда, которая выводит в консоль случайные целые числа в диапазоне от 0 до 100
        Runnable printRandomInt = () -> printer.accept(String.valueOf(randomer.get()));
        printRandomInt.run();

        // Лямбда, для проверки числа на четность
        Predicate<Integer> checkEven = n -> n % 2 == 0;
        System.out.println(checkEven.test(5));
        System.out.println(checkEven.test(0));
        System.out.println(checkEven.test(10));
    }

    interface SquareInterface {
        int square(int x);
    }

    interface Foo {
        void foo();
    }
}
