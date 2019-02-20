package com.epam.table_per_concrete_class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure("table_per_concrete_class.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Person person = new Employee("John", 26, 3000);
        Person person1 = new Employer("Jack", 39, 1);

        session.beginTransaction();
        session.persist(person);
        session.persist(person1);
        session.getTransaction().commit();

        List<Person> persons = session.createQuery("FROM Person").list();
        persons.forEach((x) -> System.out.printf("- %s%n", x));

        session.close();
        sessionFactory.close();
    }
}
