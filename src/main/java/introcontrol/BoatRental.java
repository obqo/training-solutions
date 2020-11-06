package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public static void main(String[] args) {

        int boat1 = 5;
        int boat2 = 3;
        int boat3 = 2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Személyek száma:");
        int number = scanner.nextInt();

        if (number > boat2) {
            System.out.println("Elvitték a(z) " + boat1 + " csónakot.");
            if (number > boat1) {
                number -= boat1;
            }
            else {
                number = 0;
            }
        }

        if (number > boat3) {
            System.out.println("Elvitték a(z) " + boat2 + " csónakot.");
            if (number > boat2) {
                number -= boat2;
            }
            else {
                number = 0;
            }
        }

        if (number > 0) {
            System.out.println("Elvitték a(z) " + boat3 + " csónakot.");
            if (number > boat3) {
                number -= boat3;
                System.out.println(number + " személy a parton maradt.");
            }
        }

    }
}
