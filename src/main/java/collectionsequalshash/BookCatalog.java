package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        Book book = new Book(title, author);
        if (!books.contains(book)) {
                return null;
            }
        return books.get(books.indexOf(book));
    }

    public Book findBook(List<Book> books, Book book) {
            if (!books.contains(book)) {
                return null;
            }
        return books.get(books.indexOf(book));
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> bookSet = new HashSet<>();
        for (Book book : books) {
            bookSet.add(book);
        }
        return bookSet;
    }
}
