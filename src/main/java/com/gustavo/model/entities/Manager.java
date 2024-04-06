package com.gustavo.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager extends Person {
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;

    public Manager() {
    }

    public Manager(String name, String cpf, Address address, String login, String password) {
        super(name, cpf, address);
        this.login = login;
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
