package meetingrooms;

public class Product {
    private final String name;
    private final String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product prod) {
        return name.equals(prod.getName()) && Math.abs(code.length() - prod.getCode().length()) <= 1;
    }

    public static void main(String[] args) {
        Product product1 = new Product("alma", "00001");
        Product product2 = new Product("körte", "01");
        Product product3 = new Product("alma", "0120");


        System.out.println(product1.getName() + " és " + product2.getName() + " azonosak? " + product1.areTheyEqual(product2));
        System.out.println(product1.getName() + " és " + product3.getName() + " azonosak? " + product1.areTheyEqual(product3));

    }
}