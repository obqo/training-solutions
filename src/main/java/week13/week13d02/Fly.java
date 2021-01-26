package week13.week13d02;

import java.time.LocalTime;

public class Fly {

    private String regNumber;
    private String type;
    private String city;
    private LocalTime time;

    public Fly(String regNumber, String type, String city, LocalTime time) {
        this.regNumber = regNumber;
        this.type = type;
        this.city = city;
        this.time = time;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return regNumber + " " + type + " " + city + " " + time;
    }
}