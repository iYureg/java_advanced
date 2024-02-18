package kit.develop.java.seminar_4_collections.homework;

import java.util.*;

public class Company {

    public static void main(String[] args) {
        Set<Employee> employees = employeesGenerator((short) 10);
        Employee nataha = new Employee(228, "Натаха");
        nataha.addPhoneNumber(12345);
        nataha.addPhoneNumber(54321);
        nataha.setExperience(7);

        Employee antoha = new Employee(321, "Антоха");
        antoha.addPhoneNumber(67890);
        antoha.addPhoneNumber(98765);
        antoha.setExperience(5);

        employees.add(antoha);
        employees.add(nataha);

        System.out.println("=".repeat(20) + " by experience " + "=".repeat(20));
        List<Employee> empByExp = findByExperience(employees, 7);
        for (Employee e : empByExp) System.out.println(e.getName() + " - Exp: " + e.getExperience());


        System.out.println("=".repeat(20) + " phone numbers by name " + "=".repeat(20));
        List<Integer> phones = findPhonesByName(employees, "Натаха");
        System.out.println(phones);

        System.out.println("=".repeat(20) + " find by UID " + "=".repeat(20));
        Employee employeeByUID = findByUID(employees, 228);
        System.out.println(employeeByUID);

        System.out.println("=".repeat(20) + " add employee " + "=".repeat(20));
        System.out.println(addNewEmployee(employees, 228, "Натаха"));
        System.out.println(addNewEmployee(employees, 321, "Антоха"));
        System.out.println(addNewEmployee(employees, 315920, "Серёжа"));
    }

    //    Добавить метод, который ищет сотрудника по стажу (может быть список)
    public static List<Employee> findByExperience(Set<Employee> employees, int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) if (emp.getExperience() == experience) result.add(emp);
        return result;
    }

    //    Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
    public static List<Integer> findPhonesByName(Set<Employee> employees, String name) {
        List<Integer> result = new ArrayList<>();
        for (Employee emp : employees) if (emp.getName().equals(name)) result = emp.getPhones();
        return result;
    }
    //    Добавить метод, который ищет сотрудника по табельному номеру
    public static Employee findByUID(Set<Employee> employees, int uid){
        Employee result = null;
        for (Employee emp : employees)
            if(emp.getUid() == uid)
                result = emp;
        return result;
    }

    //    Добавить метод добавление нового сотрудника в справочник
    public static boolean addNewEmployee(Set<Employee> employees, int uid, String name){
        for (Employee emp : employees){
            if(emp.getUid() == uid && emp.getName().equals(name)){
                return false;
            }
        }
        employees.add(new Employee(uid, name));
        return true;
    }

    // генератор сотрудников
    public static Set<Employee> employeesGenerator(short size) {
        Random rnd = new Random();
        Set<Employee> employees = new HashSet<>();
        for (short i = 0; i < size; i++) {
            Employee employee = new Employee(i, "Name_" + i);
            employee.setExperience(rnd.nextInt(1, 10));
            employee.setPhones(Collections.singletonList(rnd.nextInt(1_000_000_000, Integer.MAX_VALUE)));
            employees.add(employee);
        }
        return employees;
    }
}
