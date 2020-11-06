package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        UserValidator userValidator = new UserValidator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println(userValidator.isValidUsername(username) ? "Username is valid" : "Username is not valid");

        System.out.println("Password1:");
        String password1 = scanner.nextLine();
        System.out.println("Password2:");
        String password2 = scanner.nextLine();
        System.out.println(userValidator.isValidPassword(password1, password2) ? "Password is valid" : "Password is not valid");

        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println(userValidator.isValidEmail(email) ? "Email is valid" : "Email is not valid");
        Boolean b = email.indexOf("@") > 0 && email.indexOf(".") < email.length() - 1 && email.indexOf("@") < email.indexOf(".") + 1;

    }
}
