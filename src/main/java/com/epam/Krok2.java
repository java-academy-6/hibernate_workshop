package com.epam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Krok2 {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();


        Person person = new Person("SQL", 125, Plec.Nieznana);


        session.beginTransaction();
        session.persist(person);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}