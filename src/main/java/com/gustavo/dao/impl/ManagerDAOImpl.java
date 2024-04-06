package com.gustavo.dao.impl;

import com.gustavo.config.EntityManagerUtil;
import com.gustavo.dao.ManagerDAO;
import com.gustavo.model.entities.Manager;

import jakarta.persistence.EntityManager;

public class ManagerDAOImpl extends GenericDAOImpl<Manager> implements ManagerDAO {
    private EntityManager em;
    private GenericDAOImpl<Manager> genericDAOImpl;

    public ManagerDAOImpl() {
        super(Manager.class);
        em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
        genericDAOImpl = new GenericDAOImpl<>(Manager.class);
    }

    public GenericDAOImpl<Manager> getGenericDAOImpl() {
        return genericDAOImpl;
    }

    @Override
    public void update(Long id, Manager updateManager) {
        em.getTransaction().begin();
        try {
            Manager existingManager = em.find(Manager.class, id);
            if (updateManager != null && existingManager != null) {
                if (updateManager.getName() != null) {
                    existingManager.setName(updateManager.getName());
                }
                if (updateManager.getCpf() != null) {
                    existingManager.setCpf(updateManager.getCpf());
                }
                if (updateManager.getLogin() != null) {
                    existingManager.setLogin(updateManager.getLogin());
                }
                if (updateManager.getPassword() != null) {
                    existingManager.setPassword(updateManager.getPassword());
                }
                em.merge(existingManager);
            } else {
                System.err.println("Não foi possivel encontrar o gerente com ID: " + id);
            }
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new IllegalArgumentException("Erro ao atualizar Gerente. " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Manager retrievedManager = em.find(Manager.class, id);
        try {
            if (retrievedManager != null) {
                em.remove(retrievedManager);
                em.getTransaction().commit();
            } else {
                System.err.println("Erro ao deletar gerente com ID: " + id);
            }
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new IllegalArgumentException("Erro ao deletar Gerente. " + e.getMessage());
        }
    }
}
