package edu.epam.task.service;

import edu.epam.task.entity.Book;
import edu.epam.task.entity.Entity;
import edu.epam.task.exception.BookServiceException;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface BookService<K, T extends Entity> {
    void create(T t) throws BookServiceException;

    void delete(T t) throws BookServiceException;

    void deleteByID(K id) throws BookServiceException;

    void deleteByTitle(String title) throws BookServiceException;

    List<T> find(Predicate<T> predicate) throws BookServiceException;

    T findByID(K id) throws BookServiceException;

    Book findByTitle(String title) throws BookServiceException;

    List<T> findAll() throws BookServiceException;

    void updateByID(T t, K k) throws BookServiceException;

    void updateByTitle(Book book, String title) throws BookServiceException;

    List<T> sort(Comparator<T> comparator) throws BookServiceException;
}
