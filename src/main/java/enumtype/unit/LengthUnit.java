package enumtype.unit;

public enum LengthUnit {

    MM(1, true), CM(10, true), M(1000, true), YARD(914.4, false), FOOT(304.8, false), INCH(25.4, false);

    private final double inMM;

    private final boolean isSI;

    LengthUnit(double inMM, boolean isSI) {
        this.inMM = inMM;
        this.isSI = isSI;
    }

    public double getInMM() {
        return inMM;
    }

    public boolean isSI() {
        return isSI;
    }
}
