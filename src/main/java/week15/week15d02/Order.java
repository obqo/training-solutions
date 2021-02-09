package week15.week15d02;

public class Order {

    private final String courier;
    private final String address;
    private final String time;

    public Order(String courier, String address, String time) {
        this.courier = courier;
        this.address = address;
        this.time = time;
    }

    public String getCourier() {
        return courier;
    }

    public String getAddress() {
        return address;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return courier +  " " + address + " " + time;
    }
}
