package week15.week15d05;

public class Data {

    private final String country;
    private final double percent;

    public Data(String country, double percent) {
        this.country = country;
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return country + " " + percent;
    }
}
