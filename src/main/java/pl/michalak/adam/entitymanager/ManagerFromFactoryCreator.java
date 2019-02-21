package pl.michalak.adam.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class ManagerFromFactoryCreator implements EntityManagerCreator {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("perzystancja");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    void closeFactory(){
        emf.close();
    }
}
