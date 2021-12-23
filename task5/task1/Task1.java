package task5.task1;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            label:
            while (true) {
                System.out.println("Enter a file path to read from: ");
                String filePath = input.nextLine();


                try (Scanner file = new Scanner(new BufferedReader(new FileReader(filePath)))) {
                    if (!file.hasNext()) {
                        throw new IllegalStateException("File is empty!");
                    }

                    String longestLine = file.nextLine();

                    while (file.hasNext()) {
                        String newLine = file.nextLine();
                        longestLine = newLine.split(" ").length > longestLine.split(" ").length
                                ? newLine : longestLine;
                    }

                    System.out.println();
                    System.out.println("Longest line in this file is: " + longestLine);

                } catch (FileNotFoundException e) {
                    System.out.println("Can't find file to read from!");
                    continue;
                }
                System.out.println();
                System.out.println("Do you want to continue?(1 - yes, 2 - no)");
                int continueApp = input.nextInt();
                input.nextLine();

                switch (continueApp) {
                    case 1:
                        continue;
                    case 2:
                        break label;
                    default:
                        throw new InputMismatchException("No such option available! Closing...");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
