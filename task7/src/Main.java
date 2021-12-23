import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a sequence of words:");

        String[] stringList = input.nextLine().split("\\s+");

        String stringWithMinDistinctChars = Objects.requireNonNull(Arrays.stream(stringList)
                .map(i -> new Tuple(i, countDistinctChars(i)))
                .sorted()
                .limit(1)
                .findFirst()
                .orElse(null)).getFirst();

        System.out.println("Word with minimum number of distinct characters:\n" + stringWithMinDistinctChars);

        input.close();
    }

    public static int countDistinctChars(String word) {
        return (int) word.chars().distinct().count();
    }
}
