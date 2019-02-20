package com.epam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        //transient
        Person person = new Person("Kamilek", 26);
        //persistent
        session.save(person);
//        person.setName("Buka");

        Person load = session.load(Person.class, 1);

        System.out.println();
        System.out.println(load);
        System.out.println();
        //detached
        session.close();

        person.setAge(112);

        Session nowaSesja = sessionFactory.openSession();
        //persistent
        Person nowyKamilek = nowaSesja.load(Person.class, 1);
        System.out.println(nowyKamilek);

        nowaSesja.close();

        //removed
        nowaSesja.delete(person);

        sessionFactory.close();
    }
}
