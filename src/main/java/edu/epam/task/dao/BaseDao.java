package edu.epam.task.dao;

import edu.epam.task.entity.Entity;
import edu.epam.task.exception.DaoException;

import java.util.List;
import java.util.function.Predicate;

public interface BaseDao<K, T extends Entity> {
    void create(T t) throws DaoException;

    void delete(T t) throws DaoException;

    void deleteByID(K id) throws DaoException;

    List<T> find(Predicate<T> predicate) throws DaoException;

    T findByID(K id) throws DaoException;

    List<T> findAll() throws DaoException;

    void updateByID(T t, K k) throws DaoException;
}
