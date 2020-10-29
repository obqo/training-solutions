package classstructureattributes;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Client name:");
        client.name = scanner.nextLine();
        System.out.println("Client year of birth:");
        client.year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Client address:");
        client.address = scanner.nextLine();

        System.out.println("Client data: " + client.name + "\t" + client.year + "\t" + client.address);

    }
}
