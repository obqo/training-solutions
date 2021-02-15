/*
Magánhangzók
Írj egy VowelFilter.filterFowels(BufferedReader reader) metódust, mely beolvas egy fájlt soronként,
kiszűri belőle a magánhangzókat, és visszaadja egy String-ként.
Tehát a bemeneti fájl tartalma:
Aprócska
Kalapocska
Benne
Csacska
Macska
Mocska
Kimenet Stringként:
prcsk
Klpcsk
Bnn
Cscsk
Mcsk
Mcsk
 */
package week16.week16d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VowelFilter {

    private final static String VOWEL = "aáeéiíoóöőuúüű";

    public String filterVowels(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            for (char c : line.toCharArray()) {
                if (!VOWEL.contains(Character.toString(c).toLowerCase())) {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        VowelFilter vf = new VowelFilter();
        Path path = Path.of("src/main/java/week16/week16d01/words.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println(vf.filterVowels(reader));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }
}
