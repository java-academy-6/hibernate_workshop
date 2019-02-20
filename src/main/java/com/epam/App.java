package com.epam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Person person = new Person("Kamilek", 26);
        session.save(person);
        Person person1 = new Person("Marcin", 39);
        session.save(person1);
        Person person2 = new Person("Młody", 13);
        session.save(person2);

        Person load1 = session.load(Person.class, 1);
        Person load2 = session.load(Person.class, 2);
        Person load3 = session.load(Person.class, 3);

        session.close();
        sessionFactory.close();
    }
}
