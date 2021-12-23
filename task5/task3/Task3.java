package task5.task3;

import java.io.*;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a key character: ");
        char keyChar = input.next().charAt(0);
        input.nextLine();

        System.out.println("Enter file path to read from: ");
        String readFilePath = input.nextLine();

        System.out.println("Enter file path to write to: ");
        String writeFilePath = input.nextLine();

        try (Reader reader = new EncodedReader(new BufferedReader(new FileReader(readFilePath)), keyChar);
            Writer writer = new DecodedWriter(new BufferedWriter(new FileWriter(writeFilePath)), keyChar)) {
            int ch;

            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        input.close();
    }
}

