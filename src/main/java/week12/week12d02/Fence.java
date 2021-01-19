package week12.week12d02;

public enum Fence {
    PERFECT(0), NEED_UPGRADE(1), NO_FENCE(2);
    private int value;

    Fence(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}