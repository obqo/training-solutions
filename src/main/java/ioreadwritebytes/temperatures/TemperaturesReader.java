package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString) {
        Path file = Path.of(pathString);
        try {
            Temperatures data = new Temperatures(Files.readAllBytes(file));
            return data;
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }
}
