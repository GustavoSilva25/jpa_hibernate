package com.gustavo.dao.impl;

import com.gustavo.config.EntityManagerUtil;
import com.gustavo.dao.EmployeeDAO;
import com.gustavo.model.entities.Employee;

import jakarta.persistence.EntityManager;

public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements EmployeeDAO {
    private EntityManager em;
    private GenericDAOImpl<Employee> genericDAOImpl = new GenericDAOImpl<>();

    public EmployeeDAOImpl() {
        super(Employee.class);
        em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
        genericDAOImpl = new GenericDAOImpl<>(Employee.class);
    }

    private Employee retrievedEmployeeById(Long id) {
        return genericDAOImpl.findById(id);
    }

    @Override
    public void update(Long id, Employee updateEmployee) {
        em.getTransaction().begin();
        try {
            Employee existingEmployee = retrievedEmployeeById(id);
            if (updateEmployee != null && existingEmployee != null) {
                if (updateEmployee.getName() != null) {
                    existingEmployee.setName(updateEmployee.getName());
                }
                if (updateEmployee.getCpf() != null) {
                    existingEmployee.setCpf(updateEmployee.getCpf());
                }
                if (updateEmployee.getLogin() != null) {
                    existingEmployee.setLogin(updateEmployee.getLogin());
                }
                if (updateEmployee.getPassword() != null) {
                    existingEmployee.setPassword(updateEmployee.getPassword());
                }
                em.merge(existingEmployee);
            } else {
                System.err.println("Erro ao atualizar o funcionario com o ID: " + id);
            }
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao atualizar funcionario. " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        try {
            Employee retrievedEmployee = retrievedEmployeeById(id);
            if (retrievedEmployee != null) {
                em.remove(retrievedEmployee);
            } else {
                System.err.println("Erro ao remover funcionario com o ID: " + id);
            }
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new IllegalArgumentException("Erro ao remover Funcionario. " + e.getMessage());
        }
    }

}
