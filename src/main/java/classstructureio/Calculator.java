package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First number:");
        int nr1 = scanner.nextInt();

        System.out.println("Second number:");
        int nr2 = scanner.nextInt();

        System.out.println(nr1 + "+" + nr2);
        System.out.println(nr1 + nr2);
    }
}
