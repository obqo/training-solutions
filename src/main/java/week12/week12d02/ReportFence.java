package week12.week12d02;

public class ReportFence {
    private Fence fenceType;
    private int count;

    public ReportFence(Fence fenceType, int count) {
        this.fenceType = fenceType;
        this.count = count;
    }

    public Fence getFenceType() {
        return fenceType;
    }

    public int getCount() {
        return count;
    }
}