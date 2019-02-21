package pl.michalak.adam.entitymanager;

import javax.persistence.EntityManager;

class AppRunner {


    void run(){
        DataBaseConnector dbConnector = new DataBaseConnector();
        ManagerFromFactoryCreator managerFromFactoryCreator = new ManagerFromFactoryCreator();
        EntityManager entityManagerFromFactory = managerFromFactoryCreator.getEntityManager();
        dbConnector.saveMovie(entityManagerFromFactory, new Movie("Space Odyssey ", 1968, "English"));
        System.out.println(dbConnector.loadMovie(entityManagerFromFactory, 2));
        entityManagerFromFactory.close();
        managerFromFactoryCreator.closeFactory();
    }
}
