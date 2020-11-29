package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    private int sumWithScanner(Scanner scanner) {
        int sum = 0;
        try {
            while (scanner.hasNext()) {
                sum += scanner.nextInt();
            }
        } catch (InputMismatchException ex) {
            throw new IllegalArgumentException("Incorrect parameter string!", ex);
        }
        return sum;
    }

    public int readAndSumValues(String intString, String delimiter) {
        try (Scanner scanner = new Scanner(intString)) {
            if (!isEmpty(delimiter)) {
                scanner.useDelimiter(delimiter);
            }
            return sumWithScanner(scanner);
        }
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, null);
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || word == null || "".equals(word)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        try (Scanner scanner = new Scanner(text)) {
            StringBuilder sb = new StringBuilder("");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(word)) {
                    sb.append(line).append("\n");
                }
            }
            return sb.toString().trim();
        }
    }

    public boolean isEmpty(String string) {
        return string == null || "".equals(string.trim());
    }
}
