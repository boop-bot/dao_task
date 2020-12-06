package edu.epam.task.service.impl;

import edu.epam.task.dao.impl.BookDaoImpl;
import edu.epam.task.entity.Book;
import edu.epam.task.exception.BookServiceException;
import edu.epam.task.exception.DaoException;
import edu.epam.task.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class BookServiceImpl implements BookService<Book> {
    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);
    private static BookServiceImpl instance;
    private final BookDaoImpl bookDaoImpl = BookDaoImpl.getInstance();

    private BookServiceImpl() {}

    public static BookServiceImpl getInstance() {
        if (instance == null) {
            instance = new BookServiceImpl();
            logger.info("Book service created");
        }
        return instance;
    }

    @Override
    public void create(Book book) throws BookServiceException {
        try {
            bookDaoImpl.create(book);
        } catch (DaoException e) {
            logger.error(e);
            throw new BookServiceException("Could not connect with warehouse");
        }
        logger.info("Book created " + book);
    }

    @Override
    public void delete(Book book) throws BookServiceException {
        try {
            bookDaoImpl.delete(book);
        } catch (DaoException e) {
            logger.error(e);
            throw new BookServiceException("Could not connect with warehouse");
        }
        logger.info("Book deleted " + book);
    }

    @Override
    public void update(Book book) throws BookServiceException {
        try {
            bookDaoImpl.delete(book);
        } catch (DaoException e) {
            logger.error(e);
            throw new BookServiceException("Could not connect with warehouse");
        }
    }

    @Override
    public List<Book> findAll() throws BookServiceException {
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDaoImpl.findAll();
        } catch (DaoException e) {
            logger.error(e);
            throw new BookServiceException("Could not connect with warehouse");
        }
        logger.info("All books found in warehouse" + bookList);
        return bookList;
    }

    @Override
    public List<Book> find(Predicate<Book> predicate) throws BookServiceException {
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDaoImpl.find(predicate);
        } catch (DaoException e) {
            logger.error(e);
            throw new BookServiceException("Could not connect with warehouse");
        }
        logger.info("Books found in warehouse" + bookList);
        return bookList;
    }

    @Override
    public List<Book> sort(Comparator<Book> comparator) throws BookServiceException {
        List<Book> sortedBookList = new ArrayList<>();
        try {
            sortedBookList = bookDaoImpl.findAll();
            sortedBookList.sort(comparator);
        } catch (DaoException e) {
            logger.error(e);
            throw new BookServiceException("Could not connect with warehouse");
        }
        logger.info("Books sorted" + sortedBookList);
        return sortedBookList;
    }
}
