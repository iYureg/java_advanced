package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import sorces.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
    protected String name;
    protected LocalDate birthday;
    protected double salary;
    protected Gender gender;

    public Employee(String name, String birthday, double salary, String gender) {
        this.name = name;
        this.setBirthday(birthday);
        this.salary = salary;
        this.setGender(gender);
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

    public void riseSalary() {
        this.salary += this.salary / 10;
    }

    public void setGender(String gender) {
        if (gender.toLowerCase().equals("ж") || gender.toLowerCase().equals("f"))
            this.gender = Gender.FEMALE;
        else if (gender.toLowerCase().equals("м") || gender.toLowerCase().equals("m"))
            this.gender = Gender.MALE;
        else this.gender = null;
    }

    public String getGender() {
        return this.gender.getGender();
    }

    @Override
    public int compareTo(Employee e) {
        return this.birthday.compareTo(e.birthday);
    }

}