package JavaCore.homework_sem3.Task1_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Ivan", "2000-11-11", 1000));
        employees.add(new Employee("Peter", "2005-08-16", 1000));
        employees.add(new Employee("Olga", "1991-01-01", 1000));
        employees.add(new Employee("Yuriy", "1982-11-26", 1000));
        employees.add(new Employee("Elena", "1995-05-14", 1000));
        employees.add(new Employee("Svetlana", "1996-10-25", 1000));
        employees.add(new Employee("Dmitry", "1993-04-22", 1000));
        employees.add(new Employee("Ekaterina", "1980-10-03", 1000));
        employees.add(new Employee("Oleg", "1988-03-11", 1000));
        employees.add(new Employee("Anna", "1993-09-11", 1000));
        employees.add(new Employee("Maria", "1990-07-25", 1000));

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        System.out.println("=".repeat(30));

        // task_1: встроенный компаратор сортерует по возрасту сотрудника
        Collections.sort(employees, (e1, e2) -> e1.compareTo(e2));

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}
