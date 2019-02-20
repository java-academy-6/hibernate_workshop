package pl.michalak.adam.entitymanager;

import javax.persistence.EntityManager;

interface EntityManagerCreator {
    EntityManager getEntityManager();
}
