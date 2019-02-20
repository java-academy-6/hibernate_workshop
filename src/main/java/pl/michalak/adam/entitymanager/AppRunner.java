package pl.michalak.adam.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

class AppRunner {


    void run(){
        DataBaseConnector dbConnector = new DataBaseConnector();
        EntityManager entityManagerFromFactory = new ManagerFromFactory().getEntityManager();
        dbConnector.saveMovie(entityManagerFromFactory, new Movie("Space Odyssey ", 1968, "English"));
        System.out.println(dbConnector.loadMovie(entityManagerFromFactory, 2));
    }
}
