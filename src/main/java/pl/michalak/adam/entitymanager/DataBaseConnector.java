package pl.michalak.adam.entitymanager;

import javax.persistence.EntityManager;

class DataBaseConnector {

    void saveMovie(EntityManager entityManager, Movie movie) {
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();
    }

    Movie loadMovie(EntityManager entityManager, long movieId) {
        Movie movie = entityManager.find(Movie.class, movieId);
        entityManager.detach(movie);
        return movie;
    }
}
