package enumtype.unit;

import java.util.Arrays;

public class UnitConverterMain {

    public static void main(String[] args) {

        UnitConverter unitConverter = new UnitConverter();

        System.out.println(unitConverter.convert(1000, LengthUnit.CM, LengthUnit.CM));
        System.out.println(unitConverter.convert(10, LengthUnit.CM, LengthUnit.MM));
        System.out.println(unitConverter.convert(100, LengthUnit.CM, LengthUnit.M));
        System.out.println(unitConverter.convert(1, LengthUnit.FOOT, LengthUnit.M));
        System.out.println(unitConverter.convert(17, LengthUnit.INCH, LengthUnit.CM));

        System.out.println(Arrays.toString(LengthUnit.values()));
        System.out.println(unitConverter.siUnits());
    }
}
