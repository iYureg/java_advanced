package gb.junior.webinar_4_hibernate.homework.controller;

import gb.junior.webinar_4_hibernate.homework.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class DBHandler {

    public static void add(Student student) {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showTable() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {

            List<Student> students = session.createQuery("from Student ", Student.class).getResultList();
            students.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateById(int id) {
        Connector connector = new Connector();
        try (Session session = connector.getSession();
             Scanner scanner = new Scanner(System.in);
        ) {
            String hql = "from Student where id = :id";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("id", id);
            Student student = query.getSingleResultOrNull();
            System.out.println(student);
            if (student.getId() != null) {
                student.setFirstName(scanner.nextLine());
                student.setSecondName(scanner.nextLine());
                student.setAge(scanner.nextInt());
                session.beginTransaction();
                session.merge(student);
                session.getTransaction().commit();
            } else {
                System.out.println("student not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void deleteById(int id) {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            String hql = "from Student where id = :id";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("id", id);
            Student student = query.getSingleResult();
            System.out.println(student);
            session.beginTransaction();
            session.remove(student);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAll() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Transaction transaction = session.beginTransaction();
            List<Student> students = session.createQuery("FROM Student ", Student.class).getResultList();
            if (!students.isEmpty()) {
                students.forEach(session::remove);
                transaction.commit();
            } else {
                System.out.println("table students is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
