package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot{

    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();
    public final static long ALTITUDE = 5;

    public AstroBoy(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return position.getZ();
    }

    public void flyTo(Point position) {
        this.position = position;
        path.add(position);
    }

    @Override
    public void liftTo(long altitude) {
        Point newPosition = new Point(position.getX(), position.getY(), altitude);
        this.position = newPosition;
        path.add(position);
    }

    @Override
    public void moveTo(Point position) {
        walkTo(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        Point newFlyingPosition = new Point(position.getX(), position.getY(), ALTITUDE);
        liftTo(ALTITUDE);
        flyTo(newFlyingPosition);
        liftTo(0);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }

    public void walkTo(Point position) {
        this.position = position;
        path.add(position);
    }
}

/*
package interfaceextends.robot;

import java.util.*;

public class AstroBoy implements FlyableRobot{

    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();
    private final long ALTITUDE = 5;

    public AstroBoy(Point position) {
        this.position = position;
    }

    public void flyTo(Point position) {
        this.position = position;
    }
    public void liftTo(long altitude) {

    }

    public void moveTo(Point position) // delegálja a funkciót
    public void fastMoveTo(Point position) //komplex mozgás, felemelkedik, elrepül a célpont fölé, és leereszkedik
    public void rotate(int angle)

    public void walkTo(Point position) {
        this.position = position;
        path.add(position);
    }
}

 */
