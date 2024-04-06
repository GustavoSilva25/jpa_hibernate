package com.gustavo.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends Person {
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;

    public Employee() {
    }

    public Employee(String name, String cpf, Address address, String login, String password) {
        super(name, cpf, address);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String longin) {
        this.login = longin;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                super.toString() +
                " login: '" + getLogin() + "'" +
                ", password: '" + getPassword() + "'" +
                "}";
    }

}
