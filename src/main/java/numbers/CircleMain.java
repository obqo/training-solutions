package numbers;

import numbers.Circle;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("First circle diameter:");
        int diameter = scanner.nextInt();
        Circle circle = new Circle(diameter);
        System.out.println("Second circle diameter:");
        int diameter2 = scanner.nextInt();
        Circle circle2 = new Circle(diameter2);
        System.out.println("First circle perimeter: " + circle.perimeter());
        System.out.println("First circle area: " + circle.area());
        System.out.println("Second circle perimeter: " + circle2.perimeter());
        System.out.println("Second circle area: " + circle2.area());
    }
}
