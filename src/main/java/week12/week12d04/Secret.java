/*
Töltsd le a példa bináris állomány a
https://github.com/Training360/strukturavalto-java-public/raw/master/examples/week12d04/src/main/resources/secret.dat címről!
Ez bájtokat tartalmaz, egy szöveg van titkosítva benne. Olvasd be bájtonként, és mindegyik bájthoz adjál hozzá tízet! Ez valójában egy
karakterkód, ezt alakítsd át `char` típusú értékké!
Majd egymás után írd ki ezeket a konzolra! Ne használj közöttük sortörést! Aki lelövi a poént, azt én lövöm le!
 */
package week12.week12d04;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Secret {

    private final static int KEY = 10;

    public String decodingAllData(String fileName) {
        StringBuilder sb = new StringBuilder();
        Path file = Path.of("src/main/resources/week12/week12d04/" + fileName);
        try (InputStream inputStream = Files.newInputStream(file)) {
                for (byte b : inputStream.readAllBytes()) {
                    sb.append((char)(b + KEY));
                }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return sb.toString();
    }

    public String decodingWithBuffer(String fileName) {
        StringBuilder sb = new StringBuilder();
        Path file = Path.of("src/main/resources/week12/week12d04/" + fileName);
        try (InputStream inputStream = Files.newInputStream(file)) {
            byte[] buffer = new byte[1000];
            while (inputStream.read(buffer) > 0) {
                for (byte b : buffer) {
                    sb.append((char)(b + KEY));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return sb.substring(0, sb.indexOf("\n\n")).toString();
    }
    public static void main(String[] args) {
        Secret secret = new Secret();
        System.out.println(secret.decodingAllData("secret.dat"));
        System.out.println(secret.decodingWithBuffer("secret.dat"));
    }
}