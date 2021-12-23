package task3;

import task3.controller.Commands;
import task3.controller.MainController;
import task3.dao.BookDao;
import task3.dao.BookDaoImpl;
import task3.dao.InMemoryDatabase;
import task3.model.Book;
import task3.view.BookConsoleAppView;
import task3.view.View;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Task {

    private final static BookDao bookDao;
    private final static View view = new BookConsoleAppView();
    private final static Scanner input = new Scanner(System.in);

    static {
        List<Book> books = List.of(
                new Book("Кобзар", "Тарас Шевченко", "А-БА-БА-ГА-ЛА-МА-ГА", 2015, 500, 350),
                new Book("Буквар", "Василь Федієнко", "Видавничий дім \"Школа\"", 2017, 50, 100),
                new Book("Украдений цвіт", "Анна Лачина", "Видавничий дім \"Школа\"", 2018, 200, 200),
                new Book("Неймовірні пригоди Івана Сили", "Олександр Гаврош", "А-БА-БА-ГА-ЛА-МА-ГА", 2014, 150, 110),
                new Book("Задивляюсь у твої зіниці", "Василь Симоненко", "А-БА-БА-ГА-ЛА-МА-ГА", 2019, 160, 120),
                new Book("JavaScript для дітей. Веселий вступ до програмування", "Нік Морган", "Видавництво Старого Лева", 2018, 500, 280),
                new Book("Гітлер і Сталін. Тирани і Друга світова війна", "Лоренс Ріс", "Видавництво Лабораторія", 2020, 600, 350),
                new Book("Захар Беркут", "Іван Франко", "Наш Формат", 2015, 350, 30),
                new Book("Після війни. Історія Європи від 1945 року", "Тоні Джадт", "Наш Формат", 2020, 460, 500),
                new Book("1984", "Джордж Орвелл", "Видавництво Жупанського", 2015, 500, 120),
                new Book("Порожнє небо", "Радек Рак", "Видавництво Жупанського", 2021, 370, 220));

        InMemoryDatabase database = new InMemoryDatabase();
        database.addBooks(books);

        bookDao = new BookDaoImpl(database);
    }

    public static void main(String[] args) throws IOException {

        MainController mc = new MainController(bookDao);

        MainUI(mc);

    }

    public static void MainUI(MainController mc) throws IOException {
        String data = "";
        Scanner in = new Scanner(System.in);

        appLoop:
        while(true){
            view.display();
            switch (readChar(in)) {
                case 1:
                    data = readData("Author", in);
                    printRes(mc.ProcessData(data, Commands.GET_BY_AUTHOR));
                    break;
                case 2:
                    data = readData("Publisher", in);
                    printRes(mc.ProcessData(data, Commands.GET_BY_PUBLISHER));
                    break;
                case 3:
                    data = "" + readChar(in);
                    printRes(mc.ProcessData(data, Commands.GET_SINCE_YEAR));
                    break;
                case 4:
                    printRes(mc.ProcessData(data, Commands.SORT_BY_PUBLISHERS));
                    break;
                case 5:
                    break appLoop;
                default:
                    view.displayInfo("Invalid number");
            }
            System.out.println(" ");
        }
        input.close();
    }

    public static int readChar(Scanner in) throws IOException {
        System.out.print("Input a number: ");
        return in.nextInt();
    }


    public static String readData(String data, Scanner in) throws IOException {
        System.out.print("Input " + data +": ");
        in.nextLine();
        return in.nextLine();
    }

    public static void printRes(List<Book> books){
        if(books.isEmpty()){
            System.out.println("Nothing was found");
        }
        else{
            books.forEach(System.out::println);
        }
    }
}
