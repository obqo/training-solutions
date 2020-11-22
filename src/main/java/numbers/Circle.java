package numbers;

public class Circle {

    private static final double PI = 3.14;
    private int diameter;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter() {
        return diameter * PI;
    }

    public double area() {
        return Math.pow(diameter, 2) * PI / 2;
    }
}
