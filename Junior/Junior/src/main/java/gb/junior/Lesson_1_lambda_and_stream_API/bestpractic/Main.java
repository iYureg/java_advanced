package gb.junior.Lesson_1_lambda_and_stream_API.bestpractic;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static class Employee{
        private String name;
        private String position;
        private int age;

        public Employee(String name, String position, int age) {
            this.name = name;
            this.position = position;
            this.age = age;
        }
    }


    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Bob1", "Engineer", 25),
                new Employee("Bob2", "Manager", 37),
                new Employee("Bob3", "Manager", 31),
                new Employee("Bob4", "Engineer", 34),
                new Employee("Bob5", "Engineer", 44),
                new Employee("Bob6", "CEO", 50)
        );
        // region Employees
        /////// spaghetti code
        List<Employee> engineers = new ArrayList<>();
        for (Employee emp : employees){
            if(emp.position.equals("Engineer")){
                engineers.add(emp);
            }
        }
        Collections.sort(engineers, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.age - o2.age;
            }
        });
        List<String> engineersName = new ArrayList<>();
        for(Employee emp : engineers){
            engineersName.add(emp.name);
        }
        System.out.println(engineersName);

        ///// stream
        List<String> engNames = employees.stream()
                .filter(e -> e.position.equals("Engineer"))
                .sorted((o1, o2) -> o1.age - o2.age)
                .map(e -> e.name)
                .toList();

        System.out.println(engNames + "\n\n");
        // end region

        // region Users
        List<User> users = Arrays.asList(
                new User("Павел", 25),
                new User("Аркадий", 40),
                new User("Валера", 30)
        );

        users.stream()
                .map(user -> new User(user.name, user.age - 5))
                .filter(user -> user.age <= 25)
                .forEach(System.out::println);
        // end region
    }
}
