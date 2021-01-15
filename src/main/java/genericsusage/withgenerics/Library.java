package genericsusage.withgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List<Book> library) {
        if (library == null) {
            throw new NullPointerException("List is null");
        }
        if (library.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        return library.get(0);
    }
}
