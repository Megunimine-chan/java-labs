package task5.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter url:");
        String url = input.nextLine();

        System.out.println("How do you want to see tags count?");
        System.out.println("a - ordered by tag name");
        System.out.println("b - ordered by tag count");
        char order = input.next().charAt(0);
        input.nextLine();

        Map<String, Integer> tagCount = new TreeMap<>();
        StringBuilder pageBuilder = new StringBuilder();

        try (Reader urlReader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            int chCount;
            final int buffSize = 4096;
            char[] buff = new char[buffSize];

            while ((chCount = urlReader.read(buff)) != -1) {
                char[] newBuff = new char[chCount];
                System.arraycopy(buff, 0, newBuff, 0, chCount);
                pageBuilder.append(newBuff);
            }
        }

        String page = pageBuilder.toString();

        Pattern tagPattern = Pattern.compile("(?<=<)(?=.*>)[\\w-]+");

        Matcher tagMatcher = tagPattern.matcher(page);

        while (tagMatcher.find()) {
            tagCount.merge(tagMatcher.group(), 1, Integer::sum);
        }

        if (order == 'a') {
            for (Map.Entry<String, Integer> entry : tagCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else if (order == 'b') {
            Map<Integer, SortedSet<String>> newCountMap = new TreeMap<>();

            for (Map.Entry<String, Integer> entry : tagCount.entrySet()) {
                if (newCountMap.containsKey(entry.getValue())) {
                    newCountMap.get(entry.getValue()).add(entry.getKey());
                } else {
                    SortedSet<String> tagSet = new TreeSet<>();
                    tagSet.add(entry.getKey());
                    newCountMap.put(entry.getValue(), tagSet);
                }
            }

            for (Map.Entry<Integer, SortedSet<String>> entry : newCountMap.entrySet()) {
                for (String tag : entry.getValue()) {
                    System.out.println(tag + ": " + entry.getKey());
                }
            }
        } else {
            throw new InputMismatchException("Wrong ordering option!");
        }

        input.close();
    }
}
