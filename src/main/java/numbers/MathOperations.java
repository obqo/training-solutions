package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        double result = 3 / 8.0 + 7.0 / (8 - 2);
        System.out.println("Mi lesz az eredménye a 3 / 8 + 7 / (8 - 2) kifejezésnek?");
        System.out.println("Az eredményt négy tizedesjegy pontossággal kérem");

        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        if (Math.abs(result - input) < 0.0001) {
            System.out.println("Helyes az eredmény");
        }
        else {
            System.out.println("Nem helyes az eredmény");
        }
    }
}
