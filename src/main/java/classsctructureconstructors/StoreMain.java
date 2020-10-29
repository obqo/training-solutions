package classsctructureconstructors;

public class StoreMain {

    public static void main(String[] args) {
        Store store = new Store("book");
        System.out.println(store.getProduct());
        System.out.println(store.getStock());
        store.store(5);
        System.out.println(store.getStock());
        store.dispatch(10);
        System.out.println(store.getStock());

        Store anotherStore = new Store("milk");
        System.out.println(anotherStore.getProduct());
        System.out.println(anotherStore.getStock());
        anotherStore.dispatch(15);
        System.out.println(anotherStore.getStock());
        anotherStore.store(25);
        System.out.println(anotherStore.getStock());
    }
}
