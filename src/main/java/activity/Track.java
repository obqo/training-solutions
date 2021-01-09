package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint point) {
        trackPoints.add(point);
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public Coordinate findMinimumCoordinate() {
        double minLat = trackPoints.get(0).getCoordinate().getLatitude();
        double minLon = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint point : trackPoints) {
            if (point.getCoordinate().getLatitude() < minLat) {
                minLat = point.getCoordinate().getLatitude();
            }
            if (point.getCoordinate().getLongitude() < minLon) {
                minLon = point.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLat, minLon);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLat = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLon = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint point : trackPoints) {
            if (point.getCoordinate().getLatitude() > maxLat) {
                maxLat = point.getCoordinate().getLatitude();
            }
            if (point.getCoordinate().getLongitude() > maxLon) {
                maxLon = point.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLat, maxLon);
    }

    public double getRectangleArea() {
        double diffLat = findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude();
        double diffLon = findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude();
        return diffLat * diffLon;
    }

    public double getFullElevation() {
        double sumOfEvelation = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getElevation() > trackPoints.get(i - 1).getElevation()) {
                sumOfEvelation += trackPoints.get(i).getElevation() - trackPoints.get(i - 1).getElevation();
            }
        }
        return sumOfEvelation;
    }

    public double getFullDecrease() {
        double sumOfDecrease = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getElevation() < trackPoints.get(i - 1).getElevation()) {
                sumOfDecrease += trackPoints.get(i - 1).getElevation() - trackPoints.get(i).getElevation();
            }
        }
        return sumOfDecrease;
    }

    public double getDistance() {
        double sumOfDistance = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            sumOfDistance += trackPoints.get(i - 1).getDistanceFrom(trackPoints.get(i));
        }
        return sumOfDistance;
    }

    public void loadFromGpx(InputStream is){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            Coordinate coordinate = null;
            while ((line = reader.readLine()) != null) {
                line = line.strip();
                if (line.startsWith("<trkpt")) {
                    String[] temp = line.split(" ");
                    double lat = Double.parseDouble(temp[1].split("\"")[1]);
                    double lon = Double.parseDouble(temp[2].split("\"")[1]);
                    coordinate = new Coordinate(lat, lon);
                }
                if (line.startsWith("<ele>")) {
                    double ele = Double.parseDouble(line.substring(5, line.indexOf("</")));
                    TrackPoint point = new TrackPoint(coordinate, ele);
                    addTrackPoint(point);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file!");
        }
    }
}
