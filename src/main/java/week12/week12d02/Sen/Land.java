package week12.week12d02.Sen;

public class Land {

    private final Side side;
    private final int length;
    private final String color;
    private final int nr;

    public Land(Side side, int length, String color, int nr) {
        this.side = side;
        this.length = length;
        this.color = color;
        this.nr = nr;
    }

    public Side getSide() {
        return side;
    }

    public int getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }

    public int getNr() {
        return nr;
    }

    @Override
    public String toString() {
        return side +" " + length + " " + color + " " + nr;
    }
}
