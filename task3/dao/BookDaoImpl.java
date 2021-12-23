package task3.dao;

import task3.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao {

    private final InMemoryDatabase database;

    public BookDaoImpl(InMemoryDatabase database) {

        this.database = database;
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return database.books.stream()
                .filter(i -> author.equals(i.getAuthor())).collect(Collectors.toList());
    }

    @Override
    public List<Book> getByPublisher(String publisher) {
        return database.books.stream()
                .filter(i -> publisher.equals(i.getPublishedBy())).collect(Collectors.toList());
    }

    @Override
    public List<Book> getSinceYear(int year) {
        return database.books.stream()
                .filter(i -> i.getPublicYear() >= year).collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllSortedByPublisher() {
        return database.books.stream().sorted().collect(Collectors.toList());
    }
}