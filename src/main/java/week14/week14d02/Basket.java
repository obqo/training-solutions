package week14.week14d02;

import java.util.List;

public class Basket {

    private final String id;
    private final String buyer;
    private final List<Product> products;

    public Basket(String id, String buyer, List<Product> products) {
        this.id = id;
        this.buyer = buyer;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public String getBuyer() {
        return buyer;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return id + " " + buyer + " " + products;
    }
}
