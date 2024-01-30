package ru.example.java.referenceTypes;

import java.util.ArrayList;

public class ArrList {
    public static void main(String[] args) {

        showArrListAddWithTwoParams();

        // months region
        months.add("January");
        months.add("February");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("October");
        months.add("November");
        months.add("December");

        months.add(5, "September");
        months.add(2, "April");
        months.add(6, "August");
        months.add(2, "March");

        System.out.println(months);
        // months region
    }

    /**
     * Use method add with two params,
     * demonstration of index replacement
     */
    public static void showArrListAddWithTwoParams(){
        ArrayList<String> weekdays;
        weekdays = new ArrayList<String>(5);
        weekdays.add("Monday");
        weekdays.add("Tuesday");
        weekdays.add("Thursday");
        weekdays.add("Friday");
        System.out.println(weekdays);
        for( String elem : weekdays) System.out.printf("value: %s index: %d\n", elem, weekdays.indexOf(elem));

        //Add at index 2 (3rd place) the String "Wednesday"
        weekdays.add(2, "Wednesday");
        System.out.println(weekdays);
        for( String elem : weekdays) System.out.printf("value: %s index: %d\n", elem, weekdays.indexOf(elem));
    }
    static ArrayList<String> months = new ArrayList<>(12);

}
