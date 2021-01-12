package week08.week08d05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Plane {

    public static int maxOcean(String path) {
        int max = 0;
        try (FileInputStream fis = new FileInputStream(path)) {
            int input;
            int count = 0;
            while ((input = fis.read()) != -1) {
                if (input == 48) {
                    count++;
                } else {
                    if (max < count) {
                        max = count;
                    }
                    count = 0;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO fail");
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Plane.maxOcean("src/main/resources/map.txt"));
    }

}
