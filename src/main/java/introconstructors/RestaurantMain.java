package introconstructors;

public class RestaurantMain {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("Étterem", 11);
        System.out.println(restaurant.getName() + " " + restaurant.getCapacity() + " " +restaurant.getMenu());
    }
}
