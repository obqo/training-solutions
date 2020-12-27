package ioreadwritebytes.temperatures;

public class Temperatures {

    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double sum = 0;
        for (byte item : data) {
            sum += item;
        }
        return sum / data.length;
    }

    public double getMonthAverage() {
        double sum = 0;
        for (int i = 0; i < 30; i++) {
            sum += data[data.length - 1 - i];
        }
        return sum / 30;
    }
}
