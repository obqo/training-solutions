package methodoverloading;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
        this.seconds = time.seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int timeInSecundes() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public boolean isEqual(Time time) {
        return timeInSecundes() == time.timeInSecundes();
    }
    public boolean isEqual(int hours, int minutes, int seconds) {
        //return timeInSecundes() == hours * 3600 + minutes * 60 + seconds;
        Time time = new Time(hours, minutes, seconds);
        return isEqual(time);
    }
    public boolean isEarlier(Time time) {
        return timeInSecundes() < time.timeInSecundes();
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        //return timeInSecundes() < hours * 3600 + minutes * 60 + seconds;
        Time time = new Time(hours, minutes, seconds);
        return isEarlier(time);
    }

}
