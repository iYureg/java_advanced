## Домашнее задание семинар 3. Классы и объекты

1. Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты, представленные в виде трёх чисел гггг-мм-дд, без использования условного оператора.

2. Опишите класс руководителя, наследник от сотрудника. Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей. В основной программе создайте руководителя и поместите его в общий массив сотрудников. Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.

3. **_Дополнительно_**: Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
   Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5, отсортированных по убыванию среднего балла.
   В решении не использовать циклы! Только StreamAPI

```Java
class Student {
    private String name;
    private List<Double> grades;
    private String specialty;

        public double getAverageGrade() {...}

        }
```

### Задача 1 и 2:

[код решения](./Task1_2/Main.java)

### Доп. Задача:

```Java
class Student {
    private String name;
    private List<Double> grades;
    private String specialty;

    public double getAverageGrade() {
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .sum() / grades.size();
    }

    public List<Student> ladder(List<Student> list){
        return list.stream()
                .filter(student -> student.specialty.equals("Информатика") && getAverageGrade() > 4.5)
                .sorted(Comparator.comparing(Student::getAverageGrade).reversed())
                .limit(5)
                .collect(Collectors.toList());
    };
}

```
