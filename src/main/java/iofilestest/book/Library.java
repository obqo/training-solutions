package iofilestest.book;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void add(Book ... books) {
        for (Book book : books) {
            if (!contains(this.books, book)) {
                this.books.add(book);
            }
        }
    }

    private boolean contains(List<Book> books, Book book) {
        for (Book item : books) {
            if (item.getTitle().equals(book.getTitle()) && item.getAuthor().equals(book.getAuthor())) {
                return true;
            }
        }
        return false;
    }

    public void saveBooks(Path path) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Book book : books) {
                dataOutputStream.writeUTF(book.getAuthor());
                dataOutputStream.writeUTF(book.getTitle());
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public void loadBooks(Path path) {
        books.clear();
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            while (dataInputStream.available() > 0) {
                add(new Book(dataInputStream.readUTF(), dataInputStream.readUTF()));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
