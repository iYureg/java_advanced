package ru.example.java.lombok;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private String name;
    private int age;
    private double salary;
    private Date birthday;


}
