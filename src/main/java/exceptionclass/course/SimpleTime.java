package exceptionclass.course;

public class SimpleTime {

    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        setTime(hour, minute);
    }

    public SimpleTime(String timeStr) {
        if (timeStr == null) {
            throw new InvalidTimeException("Time is null");
        }
        if (timeStr.length() != "hh:mm".length() || timeStr.charAt(2) != ':') {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        String[] time = timeStr.split(":");
        int hour;
        try {
            hour = Integer.parseInt(time[0]);
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        int minute;
        try {
            minute = Integer.parseInt(time[1]);
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        setTime(hour, minute);
    }

    private void setTime(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}
