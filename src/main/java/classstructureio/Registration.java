package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your name:");
        String name = scanner.nextLine();

        System.out.println("Your email:");
        String email = scanner.nextLine();

        System.out.println("Your registration data: " + name + "\t" + email);
    }
}
