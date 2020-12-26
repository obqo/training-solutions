package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {

    public void newMark(Path file, int mark) {
        try {
            if (Files.exists(file)) {
                Files.writeString(file, mark + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(file, mark + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't open file", e);
        }
    }

    public void average(Path file) {
        try {
            List<String> list = Files.readAllLines(file);
            int sum = 0;
            for (String item : list) {
                sum += Integer.parseInt(item);
            }
            Files.writeString(file, "average: " + ((double) sum / list.size()), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("Can't open file", e);
        }
    }
}
