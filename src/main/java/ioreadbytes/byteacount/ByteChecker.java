package ioreadbytes.byteacount;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String fileName) {
        Path file = Path.of("src/main/resources/ioreadbytes/" + fileName);
        int count = 0;
        try (InputStream inputStream = Files.newInputStream(file)) {
            byte[] buffer = new byte[1000];
            int size;
            while ((size = inputStream.read(buffer)) > 0) {
                for (byte b : buffer) {
                    if (b == 97) {
                        count++;
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return count;
    }
}
