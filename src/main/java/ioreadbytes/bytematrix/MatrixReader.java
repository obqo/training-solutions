package ioreadbytes.bytematrix;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {

    private List<byte[]> myMatrix = new ArrayList<>();

    public List<byte[]> getMyMatrix() {
        return new ArrayList<>(myMatrix);
    }

    public void readBytesAndCreateMatrix(String fileName) {
        Path file = Path.of("src/main/resources/ioreadbytes/" + fileName);
        try (InputStream inputStream = Files.newInputStream(file)) {
            byte[] buffer = new byte[1000];
            int size;
            while ((size = inputStream.read(buffer)) > 0) {
                myMatrix.add(buffer);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            int countZero = 0;
            int countOne = 0;
            for (byte[] line : myMatrix) {
                if (line[i] == 48)
                    countZero++;
                else countOne++;
            }
            if (countZero > countOne)
                result++;
        }
        return result;
    }


}
