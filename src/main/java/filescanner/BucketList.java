package filescanner;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BucketList {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(BucketList.class.getResourceAsStream("/bucketlist.txt"))) {
        //try (Scanner scanner = new Scanner(Path.of("bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
