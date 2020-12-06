package edu.epam.task.dao.impl;

import edu.epam.task.dao.BookDao;
import edu.epam.task.entity.Book;
import edu.epam.task.storage.Library;
import edu.epam.task.exception.DaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BookDaoImpl implements BookDao {
    private static BookDaoImpl instance;
    private final Library library = Library.getInstance();

    private BookDaoImpl() {}

    public static BookDaoImpl getInstance() {
        if (instance == null) {
            instance = new BookDaoImpl();
        }
        return instance;
    }

    @Override
    public void create(Book book) throws DaoException {
        if (library.contains(book)) {
            throw new DaoException("Book already exists");
        }
        library.add(book);
    }

    @Override
    public void delete(Book book) throws DaoException {
        if (!library.contains(book)) {
            throw new DaoException("Book not found");
        }
        library.remove(book);
    }

    @Override
    public void deleteByID(Integer id) throws DaoException {
        Book book = findByID(id);
        library.remove(book);
    }

    @Override
    public void deleteByTitle(String title) throws DaoException {
        Book book = findByTitle(title);
        library.remove(book);
    }

    @Override
    public List<Book> find(Predicate<Book> predicate) throws DaoException {
        if (library.size() == 0) {
            throw new DaoException("Library is empty");
        }
        List<Book> bookList = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (predicate.test(book)) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    @Override
    public Book findByID(Integer id) throws DaoException {
        Book foundBook = new Book();
        boolean notFound = true;
        for (Book book : library.getBooks()) {
            if (book.getId() == id) {
                foundBook = book;
                notFound = false;
                break;
            }
        }
        if (notFound) {
            throw new DaoException("Book not found");
        }
        return foundBook;
    }

    @Override
    public Book findByTitle(String title) throws DaoException {
        Book foundBook = new Book();
        boolean notFound = true;
        for (Book book : library.getBooks()) {
            if (book.getTitle().equals(title)) {
                foundBook = book;
                notFound = false;
                break;
            }
        }
        if (notFound) {
            throw new DaoException("Book not found");
        }
        return foundBook;
    }

    @Override
    public List<Book> findAll() throws DaoException {
        if (library.size() == 0) {
            throw new DaoException("Library is empty");
        }
        return library.getBooks();
    }

    @Override
    public void updateByID(Book book, Integer id) throws DaoException {
        if (library.contains(book)) {
            throw new DaoException("Book already exists");
        }
        Book foundBook = findByID(id);
        int index = library.findIndex(foundBook);
        library.set(index, book);
    }

    @Override
    public void updateByTitle(Book book, String title) throws DaoException{
        if (library.contains(book)) {
            throw new DaoException("Book already exists");
        }
        Book foundBook = findByTitle(title);
        int index = library.findIndex(foundBook);
        library.set(index, book);
    }
}
