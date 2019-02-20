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

        Person person = new Person("Kamilek", 26);
        Person person1 = new Person("Marcin", 39);
        Person person2 = new Person("Młody", 13);

        session.beginTransaction();
        session.persist(person);
        session.persist(person1);
        session.persist(person2);
        session.getTransaction().commit();

        List<Person> persons = session.createQuery("FROM Person").list();
        persons.forEach((x) -> System.out.printf("- %s%n", x));

        session.close();
        sessionFactory.close();
    }
}
