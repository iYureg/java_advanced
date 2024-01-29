package ru.example.java.lombok;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            Employee employee = new Employee();

            employee.setName("Yuriy");
            employee.setBirthday(new Date(1982, Calendar.NOVEMBER, 26));
            employee.setSalary(50_000.0);
            employee.setAge(new Date().getYear() - employee.getBirthday().getYear());


            System.out.println(employee.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
