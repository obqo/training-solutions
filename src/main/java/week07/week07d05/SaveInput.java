/*
Kérj be a felhasználótól három sort, majd a fájl nevét. Mentsd el a sorokat ebbe a fájlba. A SaveInput osztályba dolgozz!
 */
package week07.week07d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class SaveInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sor = new StringBuilder();
        System.out.println("1. sor:");
        sor.append(scanner.nextLine() + "\n");
        System.out.println("2. sor:");
        sor.append(scanner.nextLine() + "\n");
        System.out.println("3. sor:");
        sor.append(scanner.nextLine() + "\n");
        System.out.println("File name:");
        String name = scanner.nextLine();
        Path file = Path.of(name);
        try {
            Files.writeString(file, sor);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }
}
