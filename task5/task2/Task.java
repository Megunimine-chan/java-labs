package task5.task2;

import task5.task2.controller.*;
import task5.task2.dao.*;
import task5.task2.model.*;
import task5.task2.view.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.List.*;

public class Task {

    private final static BookDao bookDao;
    private final static View view = new BookConsoleAppView();
    private final static Scanner input = new Scanner(System.in);

    static {
        List<Book> books = of(
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
                    System.out.println("Enter file path to save:");
                    String filePath = input.nextLine();
                    saveInFile(mc.ProcessData(data, Commands.SORT_BY_PUBLISHERS), filePath);
                    break;
                case 6:
                    System.out.println("Enter file path to load:");
                    String path = input.nextLine();
                    System.out.println(loadFromFile(path));
                    break;
                case 7:
                    break appLoop;
                default:
                    view.displayInfo("Invalid number");
            }
            System.out.println(" ");
        }
        input.close();
    }

    public static void saveInFile(List<Book> books, String path) throws IOException {
        try (ObjectOutputStream output =
                     new ObjectOutputStream(new FileOutputStream(path))) {
            output.writeObject(books);
        }
    }

    public static List<Book> loadFromFile(String path) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Book>)inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
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
