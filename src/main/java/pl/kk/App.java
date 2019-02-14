package pl.kk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
//        configuration.addAnnotatedClass(Osoba.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try {
            persist(sessionFactory);
            load(sessionFactory);
        } finally {
            sessionFactory.close();
        }
    }

    private static void load(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<Osoba> persons = session.createQuery("FROM Osoba").list();
        persons.forEach((x) -> System.out.printf("- %s%n", x));
        session.close();
    }

    private static void persist(SessionFactory sessionFactory) {
        Osoba p1 = new Osoba("Janek");
        Osoba p2 = new Osoba("Kurek");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(p1);
        session.persist(p2);
        session.getTransaction().commit();
    }
}
