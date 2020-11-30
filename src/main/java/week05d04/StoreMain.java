package week05d04;

public class StoreMain {

    public static void main(String[] args) {

        Store store = new Store();
        store.addProduct(new Product("milk", 2020, 12, 1));
        store.addProduct(new Product("milk", 2020, 12, 2));
        store.addProduct(new Product("ham", 2020, 11, 25));
        store.addProduct(new Product("bread", 2020, 11, 27));
        System.out.println(store.productList.toString());
        System.out.println(store.getNumberOfExpired());
    }
}
