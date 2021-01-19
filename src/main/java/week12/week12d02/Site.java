package week12.week12d02;

public class Site {
    private Side side;
    private int length;
    private Fence fence;
    private int houseNumber;

    public Site(Side side, int length, Fence fence) {
        this.side = side;
        this.length = length;
        this.fence = fence;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Side getSide() {
        return side;
    }

    public int getLength() {
        return length;
    }

    public Fence getFence() {
        return fence;
    }
}