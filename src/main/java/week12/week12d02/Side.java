package week12.week12d02;

public enum Side {
    EVEN_SIDE(0), ODD_SIDE(1);

    private int value;

    Side(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}