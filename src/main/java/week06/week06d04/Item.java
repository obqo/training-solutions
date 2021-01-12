package week06.week06d04;

public class Item {

    private int price;
    private int month;
    private String name;

    public Item(int price, int month, String name) {
        if (1 > month || month > 12) {
            throw new IllegalArgumentException(("Wrong month!"));
        }
        if (price < 0) {
            throw new IllegalArgumentException(("Wrong price!"));
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(("Wrong name!"));
        }
        this.price = price;
        this.month = month;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getMonth() {
        return month;
    }

    public String getName() {
        return name;
    }
}
