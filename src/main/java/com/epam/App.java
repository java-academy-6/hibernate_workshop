package com.epam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Pracownik pracownik = new Pracownik("John", 26, 3000);
        Pracodawca pracodawca = new Pracodawca("Jack", 39, 1);

        session.beginTransaction();
        session.persist(pracownik);
        session.persist(pracodawca);
        session.getTransaction().commit();

        List<Osoba> osoby = session.createQuery("FROM Osoba").list();
        osoby.forEach((x) -> System.out.printf("- %s%n", x));

        session.close();
        sessionFactory.close();
    }
}
