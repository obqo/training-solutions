package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List library) {
        if (library == null) {
            throw new NullPointerException("List is null");
        }
        if (library.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        Object book = library.get(0);
        if (!(book instanceof Book)) {
            throw new ClassCastException("Not a book");
        }
        return (Book) book;
    }
}
