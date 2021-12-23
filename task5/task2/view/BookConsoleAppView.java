package task5.task2.view;

public class BookConsoleAppView implements View {

    @Override
    public void display() {
        System.out.println("1 - See all books by author");
        System.out.println("2 - See all books published by");
        System.out.println("3 - See all books published after");
        System.out.println("4 - See all books sorted by publisher");
        System.out.println("5 - Save all books in file");
        System.out.println("6 - Export data from file");
        System.out.println("7 - Exit");
    }

    @Override
    public void displayInfo(String message) {
        System.out.println(message);
    }
}
