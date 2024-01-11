package JavaCore.homework_sem3.Task1_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee implements Comparable<Employee> {
    protected String name;
    protected LocalDate birthday;
    protected double salary;

    public Employee(String name, String birthday, double salary) {
        this.name = name;
        this.setBirthday(birthday);
        this.salary = salary;
    }

    protected void setBirthday(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.birthday = LocalDate.parse(date, formatter);
        } catch (Exception e) {
            System.out.println("Не верный формат даты -->  'гггг-мм-дд");
        }
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public int compareTo(Employee e) {
        return this.birthday.compareTo(e.birthday);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, age: %d salary: %s", this.name, this.getAge(), this.getSalary());
    }
}