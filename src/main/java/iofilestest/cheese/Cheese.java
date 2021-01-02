package iofilestest.cheese;

public class Cheese {

    private final String name;
    private final double lactoseContent;

    public Cheese(String name, double lactoseContent) {
        this.name = name;
        this.lactoseContent = lactoseContent;
    }

    public String getName() {
        return name;
    }

    public double getLactoseContent() {
        return lactoseContent;
    }
}
