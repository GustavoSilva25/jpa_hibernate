package com.gustavo.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String neighborhood;
    @Column(nullable = false)
    private String city;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
    @JoinColumn(name = "state_id")
    private State state;

    public Address() {
    }

    public Address(String neighborhood, String city, State state) {
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Neighborhood: " + neighborhood
                + ", City: " + city + state;
    }

}
