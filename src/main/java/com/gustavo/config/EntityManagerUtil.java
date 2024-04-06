package com.gustavo.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class EntityManagerUtil {
    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("db_test");
        } catch (PersistenceException e) {
            System.err.println("Erro ao criar o 'EntityManager'. " + e.getMessage());
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

}
