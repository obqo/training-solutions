/*
Töltsd le a példa bináris állomány a
https://github.com/Training360/strukturavalto-java-public/raw/master/examples/week12d04/src/main/resources/secret.dat címről!
Ez bájtokat tartalmaz, egy szöveg van titkosítva benne. Olvasd be bájtonként, és mindegyik bájthoz adjál hozzá tízet! Ez valójában egy
karakterkód, ezt alakítsd át `char` típusú értékké!
Majd egymás után írd ki ezeket a konzolra! Ne használj közöttük sortörést! Aki lelövi a poént, azt én lövöm le!
 */
package week12.week12d04;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class Secret {

    private final static int KEY = 10;

    public String decodingAllData(Path source, Path destination) {
        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = Files.newInputStream(source);
             Writer writer = Files.newBufferedWriter(destination)) {
            for (byte b : inputStream.readAllBytes()) {
                sb.append((char) (b + KEY));
                writer.write((char) (b + KEY));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file!", e);
        }
        return sb.toString();
    }

    public String decodingWithBuffer(Path source) {
        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = Files.newInputStream(source)) {
            byte[] buffer = new byte[1000];
            int size;
            while ((size = inputStream.read(buffer)) > 0) {
                for (int i = 0; i < size; i++) {
                    sb.append((char) (buffer[i] + KEY));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Path source = Path.of("src/main/resources/week12/week12d04/secret.dat");
        Path destination = Path.of("src/main/resources/week12/week12d04/decoding.txt");
        System.out.println(new Secret().decodingAllData(source, destination));
        System.out.println(new Secret().decodingWithBuffer(source));
    }
}