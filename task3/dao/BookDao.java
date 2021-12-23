package task3.dao;

import task3.model.*;

import java.util.List;

public interface BookDao {

    List<Book> getByAuthor(String author);
    List<Book> getByPublisher(String publisher);
    List<Book> getSinceYear(int year);
    List<Book> getAllSortedByPublisher();
}
