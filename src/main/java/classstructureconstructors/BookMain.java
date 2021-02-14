package classstructureconstructors;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("Agatha Christie", "Nemesis");
        book.register("AC-N");
        System.out.println(book.getAuthor());
        System.out.println(book.getTitle());
        System.out.println(book.getRegNumber());

    }
}
