package com.epam.java_academy.hibernate_workshop.kaskady;

import com.epam.java_academy.hibernate_workshop.kaskady.models.Author;
import com.epam.java_academy.hibernate_workshop.kaskady.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class CascadeAnnotationExample {

    public static void main(String[] args) {

        //Reading the hibernate configuration file
        Configuration configuration = new Configuration();
        InputStream inputStream = CascadeAnnotationExample.class.getClassLoader().
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
        configuration.addAnnotatedClass(Author.class);

        //Create SessionFactory
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        //Create Session from SessionFactory
        Session session = sessionFactory.openSession();
        System.out.println("Sesja do bazy danych otwarta: " + session.isConnected());

        //Begin the transaction
        session.beginTransaction();
        System.out.println("Rozpoczęto pierwszą transakcję!");

        //Create first Author Object
        Author author1 = new Author();
        author1.setAuthorName("Adam Mickiewicz");
        System.out.println("Stworzono pierwszego autora.");

        //Create first Book Object
        Book book1 = new Book();
        book1.setTitle("Pan Tadeusz, czyli ostatni Zajazd na Litwie");
        book1.setAuthor(author1);
        System.out.println("Stworzono pierwszą książkę.");

        //Create second Book Object
        Book book2 = new Book();
        book2.setTitle("Konrad Wallenrod");
        book2.setAuthor(author1);
        System.out.println("Stworzono drugą książkę.");

        //Adding first and second book to the firstAuthorSet
        createBooksSet(author1, book1, book2);
        /**
         *  method of the session object will persist the author object into the database.
         *  It in-turn saves book1 and book2 as we annotated field books in {@code Author}
         *  with CascadeType.ALL
         **/
        session.save(author1);
        System.out.println("Zapisano książki pierwszego autora w bazie.");

        //Create second Author Object
        Author author2 = new Author();
        author2.setAuthorName("Henryk Sienkiewicz");
        System.out.println("Stworzono drugiego autora.");

        //Create third Book Object
        Book book3 = new Book();
        book3.setTitle("Krzyżacy");
        book3.setAuthor(author2);
        System.out.println("Stworzono trzecią książkę.");

        //Create fourth Book Object
        Book book4 = new Book();
        book4.setTitle("Quo vadis");
        book4.setAuthor(author2);
        System.out.println("Stworzono czwartą książkę.");

        //Adding third and fourth book to the secondAuthorSet
        createBooksSet(author2, book3, book4);
        /**
         *  method of the session object will persist the author object into the database.
         *  It in-turn saves book3 and book4 as we annotated field books in {@code Author}
         *  with CascadeType.ALL
         **/
        session.save(author2);
        System.out.println("Zapisano książki drugiego autora w bazie");

        //Commit the changes
        session.getTransaction().commit();
        System.out.println("Pierwsza transakcja zakończona!");

        System.out.println("Spójrz teraz na bazę danych, potem wpisz cokolwiek i naciśnij 'Enter'" +
                " a program usunie z bazy pierwszego autora i tym samym jego książki" +
                " z powodu kaskadowej propagacji wszystkich operacji.");
        Scanner input = new Scanner(System.in);
        input.nextLine();

        //Begin the transaction
        session.beginTransaction();
        System.out.println("Rozpoczęto drugą transakcję!");

        /**
         *  method of the session object will delete the author object into the database.
         *  It in-turn removes his books (book1 and book2) as we annotated field books in {@code Author}
         *  with CascadeType.ALL
         **/
        session.delete(author1);

        //Commit the changes
        session.getTransaction().commit();
        System.out.println("Druga transakcja zakończona!");

        //Close the session
        session.close();
        System.out.println("Sesja do bazy danych otwarta: " + session.isConnected());
    }

    private static void createBooksSet(Author author, Book... books) {
        Set<Book> booksSet = new HashSet<>();
        booksSet.addAll(Arrays.asList(books));
        author.setBooks(booksSet);
    }
}