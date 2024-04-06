package com.gustavo.dao;

import com.gustavo.model.entities.Employee;

public interface EmployeeDAO extends GenericDAO<Employee> {
    void update(Long id, Employee updateEmployee);

    void delete(Long id);
}
