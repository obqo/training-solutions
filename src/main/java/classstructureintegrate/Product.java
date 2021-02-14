package classstructureintegrate;

import java.util.Scanner;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void increase(int price) {
        this.price += price;
    }

    public void decrease(int price) {
        this.price -= price;
    }

    public static void main(String[] args) {
        System.out.println("Product name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Product price:");
        int price = scanner.nextInt();

        Product product = new Product(name, price);
        System.out.println("Product data:\t" + product.getName() + "\t" + product.getPrice());

        System.out.println("Price increase with:");
        int change = scanner.nextInt();
        product.increase(change);
        System.out.println("Product data after increase price:\t" + product.getName() + "\t" + product.getPrice());

        System.out.println("Price decrease with:");
        change = scanner.nextInt();
        product.decrease(change);
        System.out.println("Product data after decrease price:\t" + product.getName() + "\t" + product.getPrice());

    }

}
