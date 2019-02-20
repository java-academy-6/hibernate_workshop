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
        session.save(person);
        Person person1 = new Person("Marcin", 39, Plec.Mezczyzna);
        session.save(person1);
        Person person2 = new Person("Młody", 13, Plec.Mezczyzna);
        session.save(person2);
        Person person3 = new Person("Mariola", 21, Plec.Kobieta);
        session.save(person3);
        Person person4 = new Person("Java", 25, Plec.Nieznana);
        session.save(person4);

        Person load = session.load(Person.class, 1);

        System.out.println(load);

        session.close();
        sessionFactory.close();
    }
}
