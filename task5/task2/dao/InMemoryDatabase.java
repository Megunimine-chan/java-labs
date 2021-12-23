package task5.task2.dao;

import task5.task2.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InMemoryDatabase {

    public final List<Book> books = new ArrayList<>();

    public void addBooks(Collection<Book> books) {
        this.books.addAll(books);
    }
}
