package com.gustavo.dao;

import com.gustavo.model.entities.Address;

public interface AddressDAO extends GenericDAO<Address> {
    void update(Long id, Address updateAddress);

    void delete(Long id);
}
