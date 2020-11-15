package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {

    public static void main(String[] args) {

        new Book();
        System.out.println(new Book());

        Book emptyBook = null;
        System.out.println(emptyBook);
        System.out.println(emptyBook == null);

        Book book = emptyBook;
        System.out.println(book);
        book = null;
        System.out.println(book);
        book = new Book();
        System.out.println(book);

        Book anotherBook = new Book();
        System.out.println(book == anotherBook);
        anotherBook = book;
        System.out.println(anotherBook);
        System.out.println(book == anotherBook);
        System.out.println(anotherBook instanceof Book);

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = book1;
        Book book5 = book1;
        Book book6 = book3;
        Book book7 = null;
        book4 = book5;
        book5 = new Book();
        book6 = null;
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
        System.out.println(book5);
        System.out.println(book6);
        System.out.println(book7);

        Book[] bookArray = {new Book(), new Book(), new Book()};
        System.out.println(bookArray);

        List<Book> bookList = Arrays.asList(new Book(), new Book(), new Book());
        System.out.println(bookList);

        List<Book> anotherBookList = new ArrayList<>();
        anotherBookList.add(new Book());
        anotherBookList.add(new Book());
        anotherBookList.add(new Book());
        System.out.println(anotherBookList);
    }
}
