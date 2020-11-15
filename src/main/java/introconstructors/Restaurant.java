package introconstructors;

import java.util.Arrays;
import java.util.List;

public class Restaurant {

    private List<String> menu;
    private String name;
    private int capacity;

    public List<String> menus() {
        return Arrays.asList("Pizza", "Hot dog");

    }

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = numberOfTables * 4;
        this.menu = menus();
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
