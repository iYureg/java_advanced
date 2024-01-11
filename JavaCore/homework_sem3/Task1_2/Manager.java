package JavaCore.homework_sem3.Task1_2;

// Опишите класс руководителя, наследник от сотрудника. Перенесите статический
// метод повышения зарплаты в класс руководителя,
// модифицируйте метод таким образом, чтобы он мог поднять заработную плату
// всем, кроме руководителей.
// В основной программе создайте руководителя и поместите его в общий массив
// сотрудников.
// Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя
// не повысилась.
public class Manager extends Employee {
    public Manager(String name, String birthday, double salary) {
        super(name, birthday, salary);
    }

    @Override
    public void riseSalary() {
        // if (!super.getClass().equals(Manager.class)) {
        // super.riseSalary();
        // }

        // xD
    }
}
