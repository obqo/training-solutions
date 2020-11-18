package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {

        int rnd = new Random().nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipped:");
        int tipp = scanner.nextInt();
        while (tipp != rnd) {
            if (tipp > rnd) {
                System.out.println("Kisebbet kérek!");
            }
            else {
                System.out.println("Nagyobbat kérek!");
            }
            System.out.println("Tipped:");
            tipp = scanner.nextInt();
        }
        System.out.println("Talált!");


    }

}
