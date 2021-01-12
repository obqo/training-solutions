package week11.week11d02;

public class Ride {

    private final int day;
    private final int index;
    private final int distance;

    public Ride(int day, int index, int distance) {
        this.day = day;
        this.index = index;
        this.distance = distance;
    }

    public int getDay() {
        return day;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
}
