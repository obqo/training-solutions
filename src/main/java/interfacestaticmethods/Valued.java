package interfacestaticmethods;

import java.util.List;

public interface Valued {

    static double sum(List<Valued> values) {
        double sum = 0;
        for (Valued value : values) {
            sum += value.getValue();
        }
        return sum;
    }

    double getValue();
}
