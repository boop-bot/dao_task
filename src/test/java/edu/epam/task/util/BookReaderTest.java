package edu.epam.task.util;

import edu.epam.task.entity.Binding;
import edu.epam.task.entity.Book;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class BookReaderTest {
    public final String FILE_NAME = "data/input.txt";
    private BookReader bookReader;

    @BeforeClass
    public void setUp() {
        bookReader = new BookReader();
    }

    @Test
    public void testReadFile() {
        List<Book> actual = Arrays.asList( new Book(100, "1984", "Orwell", "AST",
                        1948, 200, 20, Binding.PERFECT),
                new Book(101, "Master and Margarita", "Bulgakov", "Paris",
                        1967, 300, 30, Binding.CASE),
                new Book(102, "Harry Potter", "Rowling", "EKSMO",
                        1997, 400, 15, Binding.COMB),
                new Book(103, "Lord of the rings", "Tolkien", "ROSMEN",
                        1954, 400, 40, Binding.COIL),
                new Book(104, "Game of thrones", "Martin", "Alpha",
                        1996, 550, 25, Binding.SADDLE));
        List<Book> expected = bookReader.readFileBooks(FILE_NAME);
        assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        bookReader = null;
    }
}