package lambdacomparator;

public class CloudStorage implements Comparable<CloudStorage>{

    private final String provider;
    private final int space;
    private PayPeriod period;
    private double price;

    public CloudStorage(String provider, int space, PayPeriod period, double price) {
        this.provider = provider;
        this.space = space;
        this.period = period;
        this.price = price;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(CloudStorage o) {
        double currentValue = this.period != null ? this.price * 12 / this.period.getLength() / this.space * 1000 : 0;
        double otherValue = o.period != null ? o.price * 12 / o.period.getLength() / o.space * 1000 : 0;
        return Double.compare(currentValue, otherValue);
    }
}
