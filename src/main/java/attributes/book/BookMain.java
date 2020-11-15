package attributes.book;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("Egri csillagok");
        System.out.println(book.getTitle());
        book.setTitle("Édes Anna");
        System.out.println(book.getTitle());
    }

}
