package methodchain.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private int distance;
    private int azimut;
    private List<NavigationPoint> navigationPoints = new ArrayList<>();

    public Robot go(int meter) {
        this.distance += meter;
        return this;
    }

    public Robot rotate(int angle) {
        this.azimut += angle;
        return this;
    }

    public Robot registerNavigationPoint() {
        this.navigationPoints.add(new NavigationPoint(distance, azimut));
        return this;
    }

    public List<NavigationPoint> getNavigationList() {
        return navigationPoints;
    }

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }
}
