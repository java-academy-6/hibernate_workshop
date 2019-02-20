package pl.kk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(User.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(new User("Mikołaj"));
        session.save(new User("Kamil"));
        session.save(new User("Oskar"));
        session.save(new User("Oskar"));

        session.getTransaction().commit();

        zad1:{
            Query query = session.createQuery(""); //napisać kwerendę która znajdzie wszystkich użytkowników

            List<User> users = query.getResultList();
            for (User user : users) {
                System.out.println(user);
            }
            if(users.size()!=3) throw new Error();
        }

        zad2:{
            //używająć adnotacji @NamedQuery o nazwie find_user_by_id znaleźć użytkownika o id=2;
        }

        zad3:{
            //używająć adnotacji @NamedQuery o nazwie find_all_users znaleźć wszystkich użytkowników;
        }

        zad4:{
            //używająć adnotacji @SQLInsert dodać kolejnego użytkownika
        }

        zad5:{
            //używająć adnotacji @SQLUpdate zmienić login dodanego wcześniej użytkownika
        }

        zad6:{
            //używająć adnotacji @SQLDelete usunąć dodanego wcześniej użytkownika
        }


        session.close();
    }
}
