package gb.junior.Lesson_4_jdbc_hibernate.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class Connection {

    public static void deleteAll() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Transaction t = session.beginTransaction();
            List<Magic> magics = session.createQuery("FROM Magic ", Magic.class).getResultList();
            magics.forEach(session::delete);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {

            List<Magic> books = session.createQuery("FROM Magic ", Magic.class).getResultList();
            books.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateById(int id){
        Connector connector = new Connector();
        try (Session session = connector.getSession();
             Scanner scanner = new Scanner(System.in);
        ) {
            String hql = "from Magic where id = :id";
            Query<Magic> query = session.createQuery(hql, Magic.class);
            query.setParameter("id", id);
            Magic magic = query.getSingleResult();
            System.out.println(magic);
            magic.setName(scanner.nextLine());
            magic.setAttack(scanner.nextInt());
            magic.setDamage(scanner.nextInt());
            magic.setDefence(scanner.nextInt());
            session.beginTransaction();
            session.update(magic);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add(Magic magic) {
        Connector connector = new Connector();
        try (Session session = connector.getSession()){
            session.save(magic);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }

        //        Magic magic = new Magic("Волшебная стрела", 10, 0, 0); session.getTransaction();
//        session.save(magic);
//        magic = new Magic("Молния", 25, 0, 0); session.save(magic);
//        magic = new Magic("Каменная кожа", 0, 0, 6); session.save(magic);
//        magic = new Magic("Жажда крови", 0, 6, 0); session.save(magic);
//        magic = new Magic("Жажда крови", 0, 6, 0); session.save(magic);
//        magic = new Magic("Проклятие", 0, -3, 0); session.save(magic);
//        magic = new Magic("Лечение", -30, 0, 0); session.save(magic);
//        session.getTransaction();
//        session.close();
    }
}
