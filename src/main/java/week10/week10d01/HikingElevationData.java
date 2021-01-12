package week10.week10d01;

public class HikingElevationData {

    private double ascent;
    private double descent;

    public double getAscent() {
        return ascent;
    }

    public double getDescent() {
        return descent;
    }

    public void incAscent(double value) {
        this.ascent += value;
    }

    public void incDescent(double value) {
        this.descent += value;
    }
}
