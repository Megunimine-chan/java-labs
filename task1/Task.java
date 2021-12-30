package task1;

import java.util.Scanner;

public class Task {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a sequence of words:");
        String[] words = input.nextLine().split("\\s+");

        String resultWord = words[0];

        for (String word : words) {
            if (countDistinctChars(word) < countDistinctChars(resultWord)) {
                resultWord = word;
            }
        }

        System.out.println("Word with minimum number of distinct characters:\n" + resultWord);

        input.close();
    }

    public static int countDistinctChars(String word) {
        return (int) word.chars().distinct().count();
    }
}
