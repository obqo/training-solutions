/*
Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját megkapjuk egy Map-ben.
A map kulcsa az x koordináta értéke pedig az y koordináta. Döntsük el, hogy a kapott pontok küzül,
hol van a függvénynek maximum helye és ott mennyi az értéke.
 */
package week15.week15d01;

import java.util.*;

public class Function {

    public Map<Double, Double> maxValue(Map<Double, Double> points) {
        if (points == null || points.size() == 0) {
            throw new IllegalArgumentException("Not given values!");
        }
        Map<Double, Double> result = new HashMap<>();
        double maxValueFromMap = Collections.max(points.values());
        for (Double key : points.keySet()) {
            if (points.get(key) == maxValueFromMap) {
                result.put(key, points.get(key));
            }
        }
        return result;
    }
}
