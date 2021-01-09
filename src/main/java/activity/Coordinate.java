package activity;

public class Coordinate {

    private final double latitude;
    private final double longitude;

    public Coordinate(double latitude, double longitude) {
        if (-90 > latitude || latitude > 90) {
            throw new IllegalArgumentException("Invalid latitude!");
        }
        if (-180 > longitude || longitude > 180) {
            throw new IllegalArgumentException("Invalid longitude!");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
