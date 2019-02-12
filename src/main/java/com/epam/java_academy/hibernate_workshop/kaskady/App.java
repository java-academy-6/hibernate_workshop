package com.epam.java_academy.hibernate_workshop.kaskady;

import com.epam.java_academy.hibernate_workshop.kaskady.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        InputStream inputStream = App.class.getClassLoader().
                getResourceAsStream("hibernate.properties");
        Properties hibernateProperties = new Properties();
        configuration.setProperties(hibernateProperties);
        try {
            hibernateProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        configuration.setProperties(hibernateProperties);

        configuration.addAnnotatedClass(Book.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        // get session
        Session session = sessionFactory.openSession();
        System.out.println("Sesja do bazy danych otwarta: " + session.isConnected());

        session.beginTransaction();

        Book book1 = new Book();
        book1.setTitle("Krzyżacy");
        session.save(book1);
        System.out.println("Dodano pierwszą książkę.");

        Book book2 = new Book();
        book2.setTitle("Pan Tadeusz");
        session.save(book2);
        System.out.println("Dodano drugą książkę.");

        session.getTransaction().commit();
        System.out.println("Transakcja zakończona!");

        // close session
        session.close();
        System.out.println("Sesja do bazy danych otwarta: " +session.isConnected());
    }
}