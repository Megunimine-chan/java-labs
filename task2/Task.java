package task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.function.Predicate;

public class Task {

    private static final Scanner input = new Scanner(System.in);
    private static final Predicate<String> StringContainsOnlyLettersPredicate = i -> i.matches("[A-Za-zА-Яа-яёЁїЇіІ]*");
    private static final Predicate<String> StringMatchesUkrainianPhonePredicate = i -> i.matches("\\+380\\d{9}");

    public static void main(String[] args) {
              Notes allNotes = new Notes();
              startProgramm(allNotes);
        }

    public static void startProgramm(Notes allNotes){
        appLoop:
        while (true) {
            printMenu();
            System.out.println();
            System.out.print("Enter option: ");
            switch (IntReader()) {
                case 1:
                    allNotes.addNote(generateNote());
                    break;
                case 2:
                    System.out.println(allNotes);
                    break;
                case 3:
                    break appLoop;
                default:
                    System.out.print("Option is not defined");
                    System.out.print("Try again");
                }
            }
    }

    public static int IntReader(){
        return input.nextInt();
    }

    public static String StringReader(){
        return input.next();
    }

    public static CuratorRegisterNote generateNote() {
        CuratorRegisterNote note = new CuratorRegisterNote();

        note.setFirstName(getInputStringByPredicate("Student first name: ",
                StringContainsOnlyLettersPredicate));

        note.setLastName(getInputStringByPredicate("Student last name: ",
                StringContainsOnlyLettersPredicate));

        note.setPhoneNumber(getInputStringByPredicate("Student phone number: ",
                StringMatchesUkrainianPhonePredicate));

        note.setAddress(getRawData("Student address: "));

        note.setBirthDate(getDate());

        return note;
    }

    public static String getInputStringByPredicate(String dataToShow, Predicate<String> validator){
        while (true) {
            String rawString = getRawData(dataToShow);

            if(validator.test(rawString)){
                return rawString;
            }

            else System.out.println("Invalid input, try again");
        }
    }

    public static LocalDate getDate(){
        String datePattern = "dd-MM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);


        while (true) {
            String date = getRawData("Student birth date ("+ datePattern +"): ");

            try{
                LocalDate localDate = LocalDate.parse(date, formatter);
                if(!localDate.isAfter(LocalDate.now())){
                    return localDate;
                }
                System.out.println("Invalid data, try again");
            }
            catch(DateTimeParseException e){
                System.out.println("Invalid data format, try again");
            }
        }
    }

    public static String getRawData(String dataToShow){
        System.out.print(dataToShow);
        return StringReader();
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("------Program-Menu------");
        System.out.println("input 1 to add new note ");
        System.out.println("input 2 to get all notes");
        System.out.println("input 3 to quit         ");
    }
}