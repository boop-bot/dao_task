package edu.epam.task.util.comparator;

import edu.epam.task.entity.Book;

import java.util.Comparator;

public class BindingTypeComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getBindingType().compareTo(o2.getBindingType());
    }
}
