package iofilestest.cheese;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path file, List<Cheese> cheeseList) {
        try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            for (Cheese cheese : cheeseList) {
                output.writeUTF(cheese.getName());
                output.writeDouble(cheese.getLactoseContent());
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public Cheese findCheese(Path file, String cheese) {
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(Files.newInputStream(file)))) {
            while(input.available() > 0) {
                String cheeseName = input.readUTF();
                Double cheeseLactoseContent = input.readDouble();
                if (cheeseName.equals(cheese)) {
                    return new Cheese(cheeseName, cheeseLactoseContent);
                }
            }
            return null;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
