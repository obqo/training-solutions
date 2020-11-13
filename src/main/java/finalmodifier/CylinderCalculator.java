package finalmodifier;

public class CylinderCalculator {

    public double calculateVolume(double r, double h) {
        return new CircleCalculator().PI * r * r * h;
    }

    public double calculateSurfaceArea(double r, double h) {
        return 2 * new CircleCalculator().PI * r * r + 2 * new CircleCalculator().PI * r * h;
    }
}
