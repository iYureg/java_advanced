package gb.junior.webinar_4_hibernate.homework;


import gb.junior.webinar_4_hibernate.homework.controller.DBHandler;
import gb.junior.webinar_4_hibernate.homework.model.Student;

public class App {

    /**
     * 1. Создать сущность Student с полями:
     * 1.1 id - int
     * 1.2 firstName - string
     * 1.3 secondName - string
     * 1.4 age - int
     * 2. Подключить hibernate. Реализовать простые запросы: Find(by id), Persist, Merge, Remove
     * 3. Попробовать написать запрос поиска всех студентов старше 20 лет (session.createQuery)
     */

    public static void main(String[] args) {


        // create
        for (int i = 0; i < 10; i++) {
            DBHandler.add(new Student("name_" + i, "surname_" + i, 20 + i));
        }

        // read
        DBHandler.showTable();


        // update
//        DBHandler.updateById(5);

        // delete
        DBHandler.deleteById(5);
        DBHandler.deleteAll();
    }
}
