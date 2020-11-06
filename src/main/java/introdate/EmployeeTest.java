package introdate;

import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Year of birth:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Month of birth:");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Day of birth:");
        int day = scanner.nextInt();
        scanner.nextLine();

        Employee employee = new Employee(year, month, day, name);
        System.out.println("Employeer data:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Date of birth: " + employee.getDateOfBirth());
        System.out.println("Begin of employment " + employee.getBeginEmployment());

        System.out.println("New name:");
        name = scanner.nextLine();
        employee.setName(name);

        System.out.println("New employeer data:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Date of birth: " + employee.getDateOfBirth());
        System.out.println("Begin of employment " + employee.getBeginEmployment());

    }
}
