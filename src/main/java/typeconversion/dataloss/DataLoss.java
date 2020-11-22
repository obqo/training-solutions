package typeconversion.dataloss;

public class DataLoss {

    public static final int LOOP = 3;

    public void dataLoss() {
        long nr = 1;
        for (int count = 0; count < LOOP;) {
            long convert = (long) (float) nr;
            if (nr != convert) {
                System.out.println("Original: " + nr + " binar: " + Long.toBinaryString(nr));
                System.out.println("Converted: " + convert + " binar " + Long.toBinaryString(convert) + "\n");
                count++;
            }
            nr++;
        }
    }

    public static void main(String[] args) {
        new DataLoss().dataLoss();
    }
}
