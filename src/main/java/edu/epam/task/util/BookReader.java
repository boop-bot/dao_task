package edu.epam.task.util;

import edu.epam.task.entity.Binding;
import edu.epam.task.entity.Book;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookReader {
    private static final Logger logger = LogManager.getLogger(BookReader.class);

    public List<Book> readFileBooks(String fileName) {
        List<Book> bookList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(fileName))){
            while (scanner.hasNextLine()) {
                String fileString = scanner.nextLine();
                String bookParts[] = fileString.split(";");
                bookList.add(new Book(Integer.parseInt(bookParts[0]), bookParts[1], bookParts[2], bookParts[3],
                        Integer.parseInt(bookParts[4]), Integer.parseInt(bookParts[5]), Integer.parseInt(bookParts[6]), Binding.valueOf(bookParts[7])));
            }
            logger.log(Level.INFO, "books red from file: " + bookList.toString());
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        return bookList;
    }
}
