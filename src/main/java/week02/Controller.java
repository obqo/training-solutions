package week02;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Controller {

    private Office office;

    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
    }

    public void readOffice() {

        office = new Office();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem a tárgyalók darabszámát:");
        int number = scanner.nextInt();
        scanner.nextLine();

        String name;
        int length, width;
        for (int i = 0; i < number; i++) {
            System.out.println(i + 1 + ". tárgyaló neve:");
            name = scanner.nextLine();

            System.out.println(i + 1 + ". tárgyaló hosszúsága méterben:");
            length = scanner.nextInt();
            scanner.nextLine();

            System.out.println(i + 1 + ". tárgyaló szélessége méterben:");
            width = scanner.nextInt();
            scanner.nextLine();

            office.addMeetingRoom(new MeetingRoom(name, length, width));
        }
    }

    public void printMenu() {

        System.out.println("1. Tárgyalók sorrendben\n" +
                "2. Tárgyalók visszafele sorrendben\n" +
                "3. Minden második tárgyaló\n" +
                "4. Területek\n" +
                "5. Keresés pontos név alapján\n" +
                "6. Keresés névtöredék alapján\n" +
                "7. Keresés terület alapján\n\n" +
                "Kilépés minden más esetben\n");
    }

    public void runMenu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Választásod");
        String choice = scanner.nextLine();
        while ("1234567".contains(choice)){
            if ("1".equals(choice)) {
                System.out.println("Tárgyalók sorrendben");
                office.printNames();
            }
            if ("2".equals(choice)) {
                System.out.println("Tárgyalók visszafele sorrendben");
                office.printNamesReverse();
            }
            if ("3".equals(choice)) {
                System.out.println("Minden második tárgyaló");
                office.printEventNames();
            }
            if ("4".equals(choice)) {
                System.out.println("Területek");
                office.printAreas();
            }
            if ("5".equals(choice)) {
                System.out.println("Keresés pontos név alapján");
                System.out.println("Melyik tárgyalóra vagy kiváncsi?");
                office.printMeetingRoomsWithName(scanner.nextLine());
            }
            if ("6".equals(choice)) {
                System.out.println("Keresés névtöredék  alapján");
                System.out.println("Melyik tárgyalóra (névtöredék) vagy kiváncsi?");
                office.printMeetingRoomsContains(scanner.nextLine());
            }
            if ("7".equals(choice)) {
                System.out.println("Keresés terület alapján");
                System.out.println("Mekkora területnél nagyobb tárgyalókra vagy kiváncsi?");
                office.printAreasLargerThan(scanner.nextInt());
                scanner.nextLine();
            }
            printMenu();
            System.out.println("Választásod");
            choice = scanner.nextLine();
        }
    }
}
