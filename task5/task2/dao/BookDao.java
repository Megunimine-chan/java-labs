package task5.task2.dao;

import task5.task2.model.*;

import java.util.List;

public interface BookDao {

    List<Book> getByAuthor(String author);
    List<Book> getByPublisher(String publisher);
    List<Book> getSinceYear(int year);
    List<Book> getAllSortedByPublisher();
}
