package com.gustavo.dao.impl;

import com.gustavo.config.EntityManagerUtil;
import com.gustavo.dao.CustomerDAO;
import com.gustavo.model.entities.Customer;

import jakarta.persistence.EntityManager;

public class CustomerDAOImpl extends GenericDAOImpl<Customer> implements CustomerDAO {
    private EntityManager em;
    private GenericDAOImpl<Customer> genericDAOImpl;

    public CustomerDAOImpl() {
        super(Customer.class);
        em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
        genericDAOImpl = new GenericDAOImpl<>(Customer.class);
    }

    public Customer retrievedCustomerById(Long id) {
        return genericDAOImpl.findById(id);
    }

    @Override
    public void update(Long id, Customer updateCustomer) {
        em.getTransaction().begin();
        try {
            Customer existingCustomer = retrievedCustomerById(id);
            if (existingCustomer != null && updateCustomer != null) {
                if (updateCustomer.getName() != null) {
                    existingCustomer.setName(updateCustomer.getName());
                }
                if (updateCustomer.getCpf() != null) {
                    existingCustomer.setCpf(updateCustomer.getCpf());
                }
                if (updateCustomer.getPhone() != null) {
                    existingCustomer.setPhone(updateCustomer.getPhone());
                }
                if (updateCustomer.getBirthDate() != null) {
                    existingCustomer.setBirthDate(updateCustomer.getBirthDate());
                }
                em.merge(existingCustomer);
            } else {
                System.err.println("Erro ao atualizar Cliente com ID: " + id);
            }
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new IllegalArgumentException("Erro ao atualizar Cliente. " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        try {
            Customer retrievedCustomer = em.find(Customer.class, id);
            if (retrievedCustomer != null) {
                em.remove(retrievedCustomer);
            } else {
                System.err.println("Erro ao excluir cliente com ID: " + id);
            }
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new IllegalArgumentException("Erro ao excluir Cliente. " + e.getMessage());
        }
    }
}
