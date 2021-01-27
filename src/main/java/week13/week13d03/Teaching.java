/*
Adott a következő szerkezetű fájl, beosztas.txt:
Albatrosz Aladin
biologia
9.a
2
Albatrosz Aladin
osztalyfonoki
9.a
1
Csincsilla Csilla
matematika
9.b
2
A fájl tantárgyfelosztást tartalmaz. A tanttárgyfelosztást 4-es blokkokban adjuk meg. Első sor a tanár neve,
majd a tantárgy, majd az osztály ahol tanítja és végül az, hogy heti hány órában. Írj egy metódust, ami paraméterül
várja egy tanár nevét, és kiírja, hogy hány órája van egy héten.
 */
package week13.week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teaching {

    private final static int NUMBER_OF_SKIP_LINE = 2;

    public int hoursPerWeek(String teacher) {
        if (teacher == null || teacher.isEmpty()) {
            throw new IllegalArgumentException("Not given teacher name!");
        }
        int sumOfHours = 0;
        InputStreamReader is = new InputStreamReader(Teaching.class.getResourceAsStream("beosztas.txt"));
        try (BufferedReader reader = new BufferedReader(is)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sumOfHours += searchedTeacherHours(reader, line, teacher);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
        return sumOfHours;
    }

    private int searchedTeacherHours(BufferedReader reader, String line, String teacher) throws IOException {
        if (line.equals(teacher)) {
            skippedLines(reader, NUMBER_OF_SKIP_LINE);
            return Integer.parseInt(reader.readLine());
        } else {
            skippedLines(reader, NUMBER_OF_SKIP_LINE + 1);
            return 0;
        }
    }

    private void skippedLines(BufferedReader reader, int numberOfLine) throws IOException {
        for (int i = 0; i < numberOfLine; i++) {
            reader.readLine();
        }
    }
}
