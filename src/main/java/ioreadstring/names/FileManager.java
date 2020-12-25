package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private Path myFile;
    private List<Human> humans = new ArrayList<>();

    public FileManager(String path) {
        this.myFile = Path.of(path);
    }

    public void readFromFile() {
        try {
            List<String> content = Files.readAllLines(myFile);
            for (String str :  content) {
                String name[] = str.split(" ");
                humans.add(new Human(name[0], name[1]));
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public Path getMyFile() {
        return myFile;
    }

    public List<Human> getHumans() {
        return humans;
    }
}
