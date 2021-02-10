package week12.week12d02.Sen;

public enum Side {
    EVEN_SIDE(0), ODD_SIDE(1);

    private final int value;

    Side(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
