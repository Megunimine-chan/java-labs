package task5.task2.controller;

import task5.task2.dao.*;
import task5.task2.model.*;

import java.util.ArrayList;
import java.util.List;


public class MainController {
    private final BookDao bookdao;

    public MainController(BookDao bookdao) {
        this.bookdao = bookdao;
    }

    public List<Book> ProcessData(String data, Commands command){
        switch (command) {
            case GET_BY_AUTHOR: return bookdao.getByAuthor(data);
            case GET_BY_PUBLISHER: return bookdao.getByPublisher(data);
            case GET_SINCE_YEAR: return bookdao.getSinceYear(Integer.parseInt(data));
            case SORT_BY_PUBLISHERS: return bookdao.getAllSortedByPublisher();
            default: return new ArrayList<>();
        }
    }
}
