package com.gustavo.dao.impl;

import com.gustavo.config.EntityManagerUtil;
import com.gustavo.dao.AddressDAO;
import com.gustavo.model.entities.Address;

import jakarta.persistence.EntityManager;

public class AddressDAOImpl extends GenericDAOImpl<Address> implements AddressDAO {
    private EntityManager em;
    private GenericDAOImpl<Address> genericDAOImpl;

    public AddressDAOImpl() {
        super(Address.class);
        em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
        genericDAOImpl = new GenericDAOImpl<>(Address.class);
    }

    @Override
    public void update(Long id, Address updateAddress) {
        em.getTransaction().begin();
        try {
            Address existingAddress = genericDAOImpl.findById(id);
            if (updateAddress != null && existingAddress != null) {
                if (updateAddress.getNeighborhood() != null) {
                    existingAddress.setNeighborhood(updateAddress.getNeighborhood());
                }
                if (updateAddress.getCity() != null) {
                    existingAddress.setCity(updateAddress.getCity());
                }
                if (updateAddress.getState().getName() != null) {
                    existingAddress.getState().setName(updateAddress.getState().getName());
                }
                if (updateAddress.getState().getAbbreviation() != null) {
                    existingAddress.getState().setAbbreviation(updateAddress.getState().getAbbreviation());
                }
                em.merge(existingAddress);
            } else {
                System.err.println("Erro ao atualizar o Endereço com ID: " + id);
            }
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new IllegalArgumentException("Erro ao atualizar Endereço. " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        try {
            Address retrievedAddress = genericDAOImpl.findById(id);
            if (retrievedAddress != null) {
                em.remove(retrievedAddress);
            } else {
                System.err.println("Erro ao remover Endereço com ID: " + id);
            }
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new IllegalArgumentException("Erro ao remover Endereço." + e.getMessage());
        }
    }

}
