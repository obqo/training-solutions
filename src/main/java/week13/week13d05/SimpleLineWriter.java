package week13.week13d05;

public class SimpleLineWriter implements LineWriter {

    @Override
    public String writeLine(BillItem billItem) {
        return String.format("%d %s, darabja %d Ft", billItem.getNumber(), billItem.getName(), billItem.getUnitPrice());
    }
}
