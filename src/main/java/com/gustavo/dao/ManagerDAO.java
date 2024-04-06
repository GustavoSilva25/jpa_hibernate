package com.gustavo.dao;

import com.gustavo.model.entities.Manager;

public interface ManagerDAO extends GenericDAO<Manager> {
    void update(Long id, Manager updateManager);

    void delete(Long id);
}
