package com.gustavo.dao;

import java.util.List;

public interface GenericDAO<T> {
    void save(T entity);

    T findById(Long id);

    List<T> findAll(int limit, int offset);

}
