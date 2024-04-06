package com.gustavo.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends Person {
    @Column(nullable = false, length = 50)
    private String phone;
    @Column(nullable = false)
    private LocalDate BirthDate;

    public Customer() {
    }

    public Customer(String name, String cpf, Address address, String phone,
            LocalDate birthDate) {
        super(name, cpf, address);
        this.phone = phone;
        this.BirthDate = birthDate;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return this.BirthDate;
    }

    public void setBirthDate(LocalDate BirthDate) {
        this.BirthDate = BirthDate;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                " phone='" + getPhone() + "'" +
                ", BirthDate='" + getBirthDate() + "'" +
                "}";
    }
}
