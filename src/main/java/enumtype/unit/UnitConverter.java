package enumtype.unit;

import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

    private static final int decimals = 4;

    public double convert(double length, LengthUnit source, LengthUnit target) {
        double power = Math.pow(10.0, decimals);
        return Math.round(length * source.getInMM() / target.getInMM() * power) / power;
    }

    public List<LengthUnit> siUnits() {
        List<LengthUnit> lengthUnits = new ArrayList<>();
        /*
        for (int i = 0; i < LengthUnit.values().length; i++) {
            if (LengthUnit.values()[i].isSI()) {
                lengthUnits.add(LengthUnit.values()[i]);
            }
        }
        */
        for (LengthUnit unit: LengthUnit.values()) {
            if (unit.isSI()) {
                lengthUnits.add(unit);
            }
        }
        return lengthUnits;
    }
}
