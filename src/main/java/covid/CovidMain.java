package covid;

import java.util.List;
import java.util.Scanner;

import static covid.Person.*;

public class CovidMain {

    public void menu(CovidDao covidDao) {
        String choice = printMenu();
        if (!choice.equalsIgnoreCase("x")) {
            switch (choice) {
                case "1" -> covidDao.insertRegisteredCitizens(List.of(getRegisteredData(covidDao)));
                case "2" -> insertRegisteredPeopleFromFile(covidDao);
                case "3" -> generatePeopleByZip(covidDao);
                case "4" -> vaccinationBySsn(covidDao);
                case "5" -> failedVaccinationBySsn(covidDao);
                case "6" -> covidDao.saveReport();
            }
            System.out.println("~~~~~~~~~~~~~\nVégrehajtva\n~~~~~~~~~~~~~");
            menu(covidDao);
        }
    }

    private String printMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "1. Regisztráció\n" +
                        "2. Tömeges regisztráció\n" +
                        "3. Generálás\n" +
                        "4. Oltás\n" +
                        "5. Oltás meghiúsulás\n" +
                        "6. Riport\n" +
                        "_____________\n" +
                        "x Vége\n\n" +
                        "Választásod: ");
        return scanner.nextLine();
    }

    //1. Regisztráció
    private Person getRegisteredData(CovidDao covidDao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem a regisztrált személy adatait");
        String name = getRegisteredName(scanner);
        String zip = getRegisteredZip(scanner, covidDao);
        int age = getRegisteredAge(scanner);
        String email;
        String email2;
        do {
            email = getRegisteredEmail(scanner, "először");
            email2 = getRegisteredEmail(scanner, "másodjára");
            if (!email.equals(email2)) {
                System.out.println("Eltérő email címek, kérem újból!");
            }
        } while (!email.equals(email2));
        String ssn = getRegisteredSsn(scanner);
        return new Person(name, zip, age, email, ssn);
    }

    private String getRegisteredSsn(Scanner scanner) {
        System.out.print("A személy TAJ száma: ");
        String ssn;
        while (isNotValidSsn(ssn = scanner.nextLine())) {
            System.out.println("Hibás TAJ szám!");
            System.out.print("A személy TAJ száma: ");
        }
        return ssn;
    }

    private String getRegisteredEmail(Scanner scanner, String nr) {
        System.out.print("A személy email címe (" + nr + "): ");
        String email;
        while (isNotValidEmail(email = scanner.nextLine())) {
            System.out.println("Hibás email cím!");
            System.out.print("A személy email címe (" + nr + "): ");
        }
        return email;
    }

    private int getRegisteredAge(Scanner scanner) {
        System.out.print("A személy életkora: ");
        int age;
        while (isNotValidAge(age = scanner.nextInt())) {
            System.out.println("Az életkor > 10 és < 150!");
            System.out.print("A személy életkora: ");
        }
        scanner.nextLine();
        return age;
    }

    private String getRegisteredZip(Scanner scanner, CovidDao covidDao) {
        System.out.print("A település irányítószáma: ");
        String zip;
        while (isNotValidNameZip(zip = scanner.nextLine())) {
            System.out.println("Az irányítószám nem lehet üres!");
            System.out.print("A település irányítószáma: ");
        }
        System.out.println("Az irányítószámhoz tartozó település(ek): " + covidDao.getCityByZip(zip));
        return zip;
    }

    private String getRegisteredName(Scanner scanner) {
        System.out.print("A személy neve: ");
        String name;
        while (isNotValidNameZip(name = scanner.nextLine())) {
            System.out.println("A név nem lehet üres!");
            System.out.print("A személy neve: ");
        }
        return name;
    }

    //2. Tömeges regisztráció
    private void insertRegisteredPeopleFromFile(CovidDao covidDao) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem a tömeges regisztrációhoz a fájl elérési útvonalát (pl. src/main/java/covid/registered_persons.csv): ");
        String filename = scanner.nextLine();
        covidDao.insertRegisteredCitizens(covidDao.getRegisteredPersonsFromFile(filename));
    }

    //3. Generálás
    private void generatePeopleByZip(CovidDao covidDao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A holnapi napra legeneráljuk a megadott irányíószámhoz az oltásra várókat");
        String zip = getRegisteredZip(scanner, covidDao);
        covidDao.savePeopleWaitingToBeVaccinatedByZip(zip);
    }

    //4. Oltás
    private void vaccinationBySsn(CovidDao covidDao) {
        Scanner scanner = new Scanner(System.in);
        String ssn = getRegisteredSsn(scanner);
        covidDao.vaccinationBySsn(ssn);
    }

    //5. Oltás meghiúsulás
    private void failedVaccinationBySsn(CovidDao covidDao) {
        Scanner scanner = new Scanner(System.in);
        String ssn = getRegisteredSsn(scanner);
        covidDao.failedVaccination(ssn);
    }

    //6. Riport

    public static void main(String[] args) {
        CovidMain cm = new CovidMain();
        CovidDao covidDao = new CovidDao();

        covidDao.initFlyway();

        cm.menu(covidDao);
    }
}
