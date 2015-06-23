package com.github.jozijug;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 */
public class CdiConfig {

    @PersistenceUnit(unitName = "customerdb")
    private EntityManagerFactory emf;

    @Produces
    public EntityManager create() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}
