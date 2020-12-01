package methodstructure.pendrives;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public void risePrice(int percent) {
        price += price * percent / 100;
    }

    public int comparePricePerCapacity(Pendrive other) {
        if ((double) price / capacity > (double) other.getPrice() / other.getCapacity()) {
            return 1;
        }
        if ((double) price / capacity < (double) other.getPrice() / other.getCapacity()) {
            return -1;
        }
        return 0;
    }

    public boolean cheaperThan(Pendrive other) {
        return price < other.getPrice();
    }
}
