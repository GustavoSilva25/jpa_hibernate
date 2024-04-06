package com.gustavo.dao;

import com.gustavo.model.entities.Customer;

public interface CustomerDAO extends GenericDAO<Customer> {
    void update(Long id, Customer updateCustomer);

    void delete(Long id);
}
