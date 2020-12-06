package edu.epam.task.util.comparator;

import edu.epam.task.entity.Book;

import java.util.Comparator;

public class PublishingHouseComparator  implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPublishingHouse().compareTo(o2.getPublishingHouse());
    }
}
