package edu.epam.task.service;

import edu.epam.task.entity.Entity;
import edu.epam.task.exception.BookServiceException;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface BookService<T extends Entity> {
    void create(T t) throws BookServiceException;
    void delete(T t) throws BookServiceException;
    void update(T t) throws BookServiceException;
    List<T> findAll() throws BookServiceException;
    List<T> find(Predicate<T> predicate) throws BookServiceException;
    List<T> sort(Comparator<T> comparator) throws BookServiceException;
}
