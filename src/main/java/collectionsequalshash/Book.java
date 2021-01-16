package collectionsequalshash;

import java.util.Objects;

public class Book {

    private String regNumber;
    private String title;
    private String author;

    public Book(String regNumber, String title, String author) {
        this.regNumber = regNumber;
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //1. szabály - reflexív
        if (o == null || getClass() != o.getClass()) return false; //5. szabály, és 2. szabály - szimmetrikus
        Book book = (Book) o;
        return  title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, title, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "regNumber='" + regNumber + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
