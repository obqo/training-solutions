package searching;

public class Book implements Comparable<Book> {

    private int id;
    private final String author;
    private final String title;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book book) {
        if (author.compareTo(book.getAuthor()) == 0) {
            return title.compareTo(book.getTitle());
        }
        return author.compareTo(book.getAuthor());
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }
}