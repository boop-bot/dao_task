package edu.epam.task.service.impl;

import edu.epam.task.entity.Binding;
import edu.epam.task.entity.Book;
import edu.epam.task.exception.BookServiceException;
import edu.epam.task.service.BookService;
import edu.epam.task.util.BookReader;
import edu.epam.task.util.comparator.AuthorComparator;
import edu.epam.task.util.comparator.PriceComparator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.*;

public class BookServiceImplTest {

    public final String FILE_NAME = "data/input.txt";
    private BookReader bookReader;
    private List<Book> books;
    private BookService<Book> bookService;

    @BeforeMethod
    public void setUp() throws BookServiceException {
        bookReader = new BookReader();
        books = bookReader.readFileBooks(FILE_NAME);
        bookService = BookServiceImpl.getInstance();
        for (Book item : books) {
            bookService.create(item);
        }
    }

    @Test
    public void testSortPrice() throws BookServiceException{
        List<Book> expected = Arrays.asList( new Book(102, "Harry Potter", "Rowling", "EKSMO",
                1997, 400, 15, Binding.COMB),
                new Book(100, "1984", "Orwell", "AST",
                1948, 200, 20, Binding.PERFECT),
                new Book(104, "Game of thrones", "Martin", "Alpha",
                        1996, 550, 25, Binding.SADDLE),
                new Book(101, "Master and Margarita", "Bulgakov", "Paris",
                1967, 300, 30, Binding.CASE),
                new Book(103, "Lord of the rings", "Tolkien", "ROSMEN",
                1954, 400, 40, Binding.COIL));
        Comparator<Book> priceComparator = new PriceComparator();
        List<Book> actual = bookService.sort(priceComparator);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        bookReader = null;
        books = null;
        bookService = null;
    }
}