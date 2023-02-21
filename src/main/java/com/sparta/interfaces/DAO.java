package com.sparta.interfaces;

import java.util.List;

public interface DAO<T> {
    void deleteById(int id);
    void updated(T update);
    int insert(T newRow);
    T findByID(int id);
    List<T> findAll();
}
