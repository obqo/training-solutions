package iofilestest.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {

    @TempDir
    Path tempDir;

    @Test
    public void testSave() throws IOException {
        Path file = tempDir.resolve("library.txt");
        Library library = new Library();
        library.add(new Book("Author 1", "Title 1"),
                new Book("Author 2", "Title 2"),
                new Book("Author 3", "Title 3"));
        library.saveBooks(file);
        assertTrue(Files.exists(file));

        DataInputStream input = new DataInputStream(new BufferedInputStream(Files.newInputStream(file)));
        assertEquals("Author 1", input.readUTF());
        assertEquals("Title 1", input.readUTF());
    }

    @Test
    public void testLoad() throws IOException {
        Path file = tempDir.resolve("library.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)));
        dataOutputStream.writeUTF("Author 1");
        dataOutputStream.writeUTF("Title 1");
        dataOutputStream.writeUTF("Author 2");
        dataOutputStream.writeUTF("Title 2");
        dataOutputStream.writeUTF("Author 3");
        dataOutputStream.writeUTF("Title 3");
        dataOutputStream.writeUTF("Author 3");
        dataOutputStream.writeUTF("Title 3");
        dataOutputStream.close();

        Library library = new Library();
        library.loadBooks(file);
        assertEquals(3, library.getBooks().size());
        assertEquals("Author 2", library.getBooks().get(1).getAuthor());
        assertEquals("Title 2", library.getBooks().get(1).getTitle());
    }

}
