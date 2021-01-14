/*
Adott az aktuális könyvtárban több, fájl, melynek a nevei: number00.txt, number03.txt, number20.txt, egészen 99-ig.
Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az állományból a benne lévő
számot, és ezt összegezd! Használd a Files.isRegularFile() metódust arra, hogy megnézd, létezik-e a fájl!
Használd a Files.readString() metódust a fájl beolvasására! A FilesSum osztály int sumNumbers() metódusába dolgozz!
 */
package week11.week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    private int readFile(Path path) {
        int number = 0;
        if (Files.isRegularFile(path)) {
            try {
                String content = Files.readString(path);
                try {
                    number = Integer.parseInt(content);
                } catch (NumberFormatException nfe) {
                }
            } catch (IOException ioe) {
                throw new IllegalStateException("Can not read file!");
            }
        }
        return number;
    }

    public int sumNumbers(String path) {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            String numberStr = String.format("%02d", i);
            Path file = Path.of(path + "number" + numberStr + ".txt");
            if (Files.isRegularFile(file)) {
                sum += readFile(file);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new FilesSum().sumNumbers("src/main/resources/week11/week11d04/"));
    }
}
