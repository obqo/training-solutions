package finalmodifier;

public class TaxCalculator {

    public static final double AFA = 0.27;

    public double tax(double price) {
        return price * AFA;
    }

    public double priceWithTax(double price) {
        return price + new TaxCalculator().tax(price);
    }

    public static void main(String[] args) {
        System.out.println(new TaxCalculator().tax(100));
        System.out.println(new TaxCalculator().priceWithTax(100));
    }
}
