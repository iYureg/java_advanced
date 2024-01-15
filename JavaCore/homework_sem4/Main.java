import models.Employee;
import models.Manager;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Ivan", "2000-11-11", 1000, "ж"));
        employees.add(new Employee("Peter", "2005-08-16", 1000, "м"));
        employees.add(new Employee("Olga", "1991-01-01", 1000, "ж"));
        employees.add(new Employee("Yuriy", "1982-11-26", 1000, "м"));
        employees.add(new Employee("Elena", "1995-05-14", 1000, "Ж"));
        employees.add(new Employee("Svetlana", "1996-10-25", 1000, "f"));
        employees.add(new Employee("Dmitry", "1993-04-22", 1000, "m"));
        employees.add(new Employee("Ekaterina", "1980-10-03", 1000, "F"));
        employees.add(new Employee("Oleg", "1988-03-11", 1000, "M"));
        employees.add(new Employee("Anna", "1993-09-11", 1000, "Ж"));
        employees.add(new Employee("Maria", "1990-07-25", 1000, "f"));
        employees.add(new Manager("BOSS", "2006-11-11", 1000000, "m"));
        Collections.sort(employees, (e1, e2) -> e1.compareTo(e2));


        // task_1: внедрить Lombok
        for (Employee employee : employees)
            System.out.println(employee.toString());

        // task_2: поздравить сотрудников с праздниками
        LocalDate march8 = LocalDate.of(LocalDate.now().getYear(), Month.MARCH, 8); // сегодня 8 марта
        System.out.println(march8);
        congratulation(march8, employees);
        System.out.println("-".repeat(20));

        LocalDate february23 = LocalDate.of(LocalDate.now().getYear(), Month.FEBRUARY, 23); // сегодня 23 февраля
        congratulation(february23, employees);
        System.out.println("-".repeat(20));


        LocalDate newYear = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 1); // сегодня новый год
        congratulation(newYear, employees);

    }

    public static void congratulation(LocalDate date, List<Employee> emps) {

        if (date.getMonth().equals(Month.MARCH) && date.getDayOfMonth() == 8) {
            emps.stream().filter(e -> e.getGender().equals("Женьщина"))
                    .forEach(e -> System.out.println("С 8 марта " + e.getName() + "!"));
        }
        else if (date.getMonth().equals(Month.FEBRUARY) && date.getDayOfMonth() == 23) {
            emps.stream().filter(e -> e.getGender().equals("Мужчина"))
                    .forEach(e -> System.out.println("С днем защитника отечества " + e.getName() + "!"));
        }
        else if (date.getMonth().equals(Month.JANUARY) && date.getDayOfMonth() == 1) {
            emps.stream()
                    .forEach(e -> System.out.printf("С новым Годом %s\n", e.getName()));
        }
    }
}
