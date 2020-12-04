package methodparam.measuring;

import java.util.ArrayList;
import java.util.List;

public class Measurement {

    private double[] measurements;

    public Measurement(double[] measurements) {
        this.measurements = measurements;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < measurements.length; i++) {
            if (measurements[i] > lower && measurements[i] < upper) {
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double min = measurements[0];
        for (double measurement : measurements) {
            if (min > measurement) {
                min = measurement;
            }
        }
        return min;
    }

    public double maximum() {
        double max = measurements[0];
        for (double measurement : measurements) {
            if (max < measurement) {
                max = measurement;
            }
        }
        return max;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }
}
