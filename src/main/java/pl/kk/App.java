package pl.kk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(User.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(new User("Dżawa_Trzy_Tysiące"));
        session.getTransaction().commit();

        session.close();
    }
}
