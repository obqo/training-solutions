package iofilestest.cheese;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheeseManagerTest {

    @TempDir
    Path tempDir;

    @Test
    public void testSave() throws IOException {
        Path file = tempDir.resolve("cheeselist.txt");
        List<Cheese> cheeseList = List.of(new Cheese("cheese1", 12.34),
                new Cheese("cheese2", 34.56),
                new Cheese("cheese1", 55));
        CheeseManager cheeseManager = new CheeseManager();
        cheeseManager.saveToFile(file, cheeseList);
        assertTrue(Files.exists(file));

        DataInputStream input = new DataInputStream(new BufferedInputStream(Files.newInputStream(file)));
        assertEquals("cheese1", input.readUTF());
        assertEquals(12.34, input.readDouble());
    }

    @Test
    public void testFind() throws IOException {
        Path file = tempDir.resolve("cheeselist.txt");
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)));
        output.writeUTF("cheese1");
        output.writeDouble(12.34);
        output.writeUTF("cheese2");
        output.writeDouble(34.56);
        output.writeUTF("cheese3");
        output.writeDouble(55);
        output.close();
        CheeseManager cheeseManager = new CheeseManager();
        assertEquals(34.56, cheeseManager.findCheese(file, "cheese2").getLactoseContent());
        assertEquals(null, cheeseManager.findCheese(file, "no"));

    }
}
