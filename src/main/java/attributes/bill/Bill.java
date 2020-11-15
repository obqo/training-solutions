package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        double sum =0;
        for (Item item : items) {
            sum += item.getQuantity() * item.getPrice();
        }
        return sum;
    }
}
