package edu.epam.task.storage;

import edu.epam.task.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private static Library instance;
    private List<Book> books = new ArrayList<>();

    private Library() {}

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books.stream().collect(Collectors.toList());
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void remove(Book book) {
        books.remove(book);
    }

    public boolean contains(Book book) {
        return books.contains(book);
    }

    public void add(Book book) {
        books.add(book);
    }

    public int findIndex(Book book) {
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(book)) {
                index = i;
            }
        }
        return index;
    }

    public void set(int index, Book book) {
        books.set(index, book);
    }

    public int size() {
        return books.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        return books.equals(library.books);
    }

    @Override
    public int hashCode() {
        return books.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Library");
        sb.append("books=").append(books.toString()).append('}');
        return sb.toString();
    }
}
