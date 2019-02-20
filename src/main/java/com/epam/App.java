package com.epam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Person person = new Person("Kamilek", 26, Plec.Mezczyzna);
        Person person1 = new Person("Marcin", 29, Plec.Mezczyzna);
        Person person2 = new Person("Młody", 13, Plec.Mezczyzna);
        Person person3 = new Person("Mariola", 21, Plec.Kobieta);
        Person person4 = new Person("Java", 25, Plec.Nieznana);


        session.beginTransaction();
        session.persist(person);
        session.persist(person1);
        session.persist(person2);
        session.persist(person3);
        session.persist(person4);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
