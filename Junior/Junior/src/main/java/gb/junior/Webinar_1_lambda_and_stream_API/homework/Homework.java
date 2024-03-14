package gb.junior.Webinar_1_lambda_and_stream_API.homework;


import gb.junior.Webinar_1_lambda_and_stream_API.Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Homework {

    /**
     * Реалзиовать методы, описанные ниже:
     */

    public static void main(String[] args) {

        List<Streams.Department> departments = Stream.generate(() -> new Streams.Department("Department #" + ThreadLocalRandom.current().nextInt(1, 11)))
                .limit(10)
                .toList();

        List<Streams.Person> persons = Stream.generate(() -> new Streams.Person(
                        "Person #" + ThreadLocalRandom.current().nextInt(100),
                        ThreadLocalRandom.current().nextInt(20, 65),
                        ThreadLocalRandom.current().nextInt(20_000, 100_000) * 1.0,
                        departments.get(ThreadLocalRandom.current().nextInt(departments.size()))))
                .limit(100)
                .toList();


        // #1
        System.out.println("=".repeat(10) + " #1 " + "=".repeat(10) + "\n");
        printNamesOrdered(persons);

        // #2
        System.out.println("=".repeat(10) + " #2 " + "=".repeat(10) + "\n");
        printDepartmentOldestPerson(persons).forEach((k, v) -> System.out.printf("%s - Name: %s age: %d\n", k.getName(), v.getName(), v.getAge()));

//        for (var entry : printDepartmentOldestPerson(persons).entrySet())
//            System.out.println(entry.getKey().getName() + " Name: " + entry.getValue().getName() + " age: " + entry.getValue().getAge());


        // #3
        System.out.println("=".repeat(10) + " #3 " + "=".repeat(10) + "\n");
        findFirstPersons(persons).forEach(person -> System.out.printf("%s Salary: %s\n", person.getName(), person.getSalary()));

        // #4
        System.out.println("=".repeat(10) + " #4 " + "=".repeat(10) + "\n");
        System.out.println(findTopDepartment(persons));

    }


    /**
     * Вывести на консоль отсортированные (по алфавиту) имена персонов
     */
    public static void printNamesOrdered(List<Streams.Person> persons) {
        // ...
        persons.stream()
                .map(p -> p.getName())
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * В каждом департаменте найти самого взрослого сотрудника.
     * Вывести на консоль мапипнг department -> personName
     * Map<Department, Person>
     */
    public static Map<Streams.Department, Streams.Person> printDepartmentOldestPerson(List<Streams.Person> persons) {
        Comparator<Streams.Person> compareByAge = Comparator.comparing(Streams.Person::getAge);
        return persons.stream()
                .collect(Collectors.toMap(Streams.Person::getDepartment, Function.identity(), (o1, o2) -> {
                    if (compareByAge.compare(o1, o2) > 0) {
                        return o1;
                    }
                    return o2;
                }));
    }

    /**
     * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
     */
    public static List<Streams.Person> findFirstPersons(List<Streams.Person> persons) {
        return persons.stream()
                .filter(person -> person.getAge() < 30)
                .filter(person -> person.getSalary() > 50_000)
                .limit(10)
                .toList();
    }

    /**
     * Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
     */
    public static Optional<Streams.Department> findTopDepartment(List<Streams.Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(
                        Streams.Person::getDepartment,
                        Collectors.averagingDouble(Streams.Person::getSalary)
                ))
                .entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
