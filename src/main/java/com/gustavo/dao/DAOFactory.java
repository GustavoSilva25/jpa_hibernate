package com.gustavo.dao;

import com.gustavo.dao.impl.AddressDAOImpl;
import com.gustavo.dao.impl.CustomerDAOImpl;
import com.gustavo.dao.impl.EmployeeDAOImpl;
import com.gustavo.dao.impl.GenericDAOImpl;
import com.gustavo.dao.impl.ManagerDAOImpl;

public class DAOFactory {

    public static GenericDAO<Object> createGenericDAO() {
        return new GenericDAOImpl<>();
    }

    public static ManagerDAO createManagerDAO() {
        return new ManagerDAOImpl();
    }

    public static EmployeeDAO createEmployeeDAO() {
        return new EmployeeDAOImpl();
    }

    public static CustomerDAO createCustomerDAO() {
        return new CustomerDAOImpl();
    }

    public static AddressDAO createLocationDAO() {
        return new AddressDAOImpl();
    }
}
