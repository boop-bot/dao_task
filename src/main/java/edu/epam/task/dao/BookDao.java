package edu.epam.task.dao;

import edu.epam.task.entity.Book;
import edu.epam.task.exception.DaoException;

public interface BookDao extends BaseDao<Integer, Book> {
    void deleteByTitle(String title) throws DaoException;

    Book findByTitle(String title) throws DaoException;

    void updateByTitle(Book book, String title) throws DaoException;
}
