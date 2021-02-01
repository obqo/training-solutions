package week13.week13d05;

public class MultipleLineWriter implements LineWriter{

    @Override
    public String writeLine(BillItem billItem) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%s%13d %5d %6d", billItem.getName(), " ".repeat(20 - billItem.getName().length()),
                billItem.getUnitPrice(), billItem.getNumber(), billItem.getNumber() * billItem.getUnitPrice()));
        return sb.toString();
    }
}
