package ru.tronin.DAO;

import java.util.List;

public interface iDAO<T, K>{

    boolean  create(T entity);
    boolean deleteById(K id);
    T getEntityById(K id);
    T update(T entity);
    List<T> getAll();



}
