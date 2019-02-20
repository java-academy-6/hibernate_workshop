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

        Employee employee = new Employee("John", 26, 3000);
        Employer employer = new Employer("Jack", 39, 1);

        session.beginTransaction();
        session.persist(employee);
        session.persist(employer);
        session.getTransaction().commit();

        List<Person> persons = session.createQuery("FROM Person").list();
        persons.forEach((x) -> System.out.printf("- %s%n", x));

        session.close();
        sessionFactory.close();
    }
}
