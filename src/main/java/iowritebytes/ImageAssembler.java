package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] image, Path folder) {
        Path file = folder.resolve("image.png");
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (byte[] line : image) {
                bufferedOutputStream.write(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }

    }
}
