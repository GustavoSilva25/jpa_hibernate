package com.gustavo.application;

import com.gustavo.dao.DAOFactory;
import com.gustavo.dao.EmployeeDAO;
import com.gustavo.dao.GenericDAO;
import com.gustavo.model.entities.Employee;

public class Main {
        public static void main(String[] args) {
                GenericDAO<Object> genericDAO = DAOFactory.createGenericDAO();

                // // Inserindo Gerente.

                // State state1 = new State("Santa Catarina", "SC");
                // Address address1 = new Address("Morro Alto", "Piçarras", state1);
                // Manager manager1 = new Manager("Gustavo Silva", "244.334.223-23",
                // address1, "gustavo233", "12345");

                // genericDAO.save(state1);
                // genericDAO.save(address1);
                // genericDAO.save(manager1);

                // // Inserindo Funcionario.

                // State state2 = new State("Paraná", "PR");
                // Address address2 = new Address("Batel", "Curitiba", state2);
                // Employee employee = new Employee("Priscila Machado", "255.232.232-23",
                // address2, "Priscila23555", "12345");

                // genericDAO.save(state2);
                // genericDAO.save(address2);
                // genericDAO.save(employee);

                // // Inserindo Cliente.

                // State state3 = new State("São paulo", "SP");
                // Address address3 = new Address("Ibirapuera", "São paulo", state3);
                // Customer customer = new Customer("Maria", "333.232.222-23",
                // address3, "11 9900-0000", LocalDate.now());

                // genericDAO.save(state3);
                // genericDAO.save(address3);
                // genericDAO.save(customer);

                // Realizando consultas

                EmployeeDAO employeeDAO = DAOFactory.createEmployeeDAO();

                for (Employee emp : employeeDAO.findAll(5, 0)) {
                        System.out.println(emp);
                }

                Employee findByIdEmp = employeeDAO.findById(1L);
                System.out.println(findByIdEmp);

                // // Realizando atualizações

                // ManagerDAO managerDAO = DAOFactory.createManagerDAO();

                // Manager updateManager = new Manager("Gustavo Henrique", null, null, null,
                // null);
                // managerDAO.update(1L, updateManager);
                // System.out.println(managerDAO.findById(1L));

                // AddressDAO addressDAO = DAOFactory.createLocationDAO();

                // State updateState = new State("Paraná", "PR");
                // Address updateAddress = new Address("Centro", "Curitiba", updateState);
                // addressDAO.update(1L, updateAddress);
                // System.out.println(addressDAO.findById(1L));

                // // Realizando exclusão

                // CustomerDAO customerDAO = DAOFactory.createCustomerDAO();

                // System.out.print(customerDAO.findById(1L));
                // customerDAO.delete(1L);

        }
}
