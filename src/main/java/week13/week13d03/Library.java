/*
Legyen egy Book osztály, melynek van egy String author, String title és int numberOfPages attribútuma.
Írj egy másik osztályban egy olyan metódust, mely visszaadja a legtöbb oldalt
író szerzőt! Figyelj arra, hogy hatékony legyen az algoritmus!
 */
package week13.week13d03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    public String findAuthorWithMAxPages(List<Book> bookList) {
        if (bookList.isEmpty()) {
            throw new IllegalArgumentException("No book");
        }
        Map<String, Integer> authorsWithPages = new HashMap<>();
        for (Book book : bookList) {
            String author = book.getAuthor();
            if (!authorsWithPages.containsKey(author)) {
                authorsWithPages.put(author, book.getNumberOfPages());
            }
            else {
                int sum = authorsWithPages.get(author);
                sum += book.getNumberOfPages();
                authorsWithPages.put(author, sum);
            }
        }
        int maxNumberOfPages = 0;
        String author = null;
        for (Map.Entry<String, Integer> entry : authorsWithPages.entrySet()) {
            if (entry.getValue() > maxNumberOfPages) {
                maxNumberOfPages = entry.getValue();
                author = entry.getKey();
            }
        }
        return author;
    }

    public static void main(String[] args) {
        System.out.println(new Library().findAuthorWithMAxPages(List.of(
                new Book("x1", "t1", 10),
                new Book("x2", "t2", 20),
                new Book("x1", "t1", 5))));
    }
}
