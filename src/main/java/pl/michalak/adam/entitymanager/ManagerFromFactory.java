package pl.michalak.adam.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class ManagerFromFactory implements EntityManagerCreator {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl.michalak.adam.movie_catalog");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
