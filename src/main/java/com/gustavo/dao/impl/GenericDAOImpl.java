package com.gustavo.dao.impl;

import java.util.List;

import com.gustavo.config.EntityManagerUtil;
import com.gustavo.dao.GenericDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class GenericDAOImpl<T> implements GenericDAO<T> {
    private EntityManager em;
    private Class<T> class1;

    public GenericDAOImpl() {
        this(null);
    }

    public GenericDAOImpl(Class<T> class1) {
        em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
        this.class1 = class1;
    }

    @Override
    public void save(T entity) {
        em.getTransaction().begin();
        try {
            if (entity != null) {
                em.persist(entity);
            }
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new IllegalArgumentException("Erro ao savar entidade. " + e.getMessage());
        }
    }

    @Override
    public T findById(Long id) {
        T entity = em.find(class1, id);
        if (entity != null) {
            return entity;
        } else {
            throw new IllegalArgumentException("Erro ao buscar pelo ID: " + id);
        }
    }

    @Override
    public List<T> findAll(int limit, int offset) {
        String jpql = "SELECT t FROM " + class1.getName() + " t";
        TypedQuery<T> query = em.createQuery(jpql, class1);
        query.setMaxResults(limit);
        query.setFirstResult(offset);
        return query.getResultList();
    }
}
