/*
Írj egy a TemplateMerger osztályba egy public String merge(Path file, List<Employee> employees)
metódust, ami felolvassa a fájlt, melynek tartalma:
Az alkalmazott neve: {nev}, születési éve: {ev}
Nyugodtan beolvashatod egy utasítással!
Majd a visszatérési értékként add vissza soronként az alkalmazottakat, abban a formátumban,
mint ahogy a fájlban van, azaz:
Az alkalmazott neve: John Doe, születési éve: 1980
Az alkalmazott neve: Jack Doe, születési éve: 1990
(Persze ehhez kell egy Employee osztály is a megfelelő attribútumokkal.
 */
package week13.week13d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public String merge(Path file, List<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = reader.readLine();
            for (Employee employee : employees) {
                sb.append(replaceData(line, employee));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return sb.toString();
    }

    private String replaceData(String line, Employee employee) {
        line = line.replace(findFormat(line), employee.getName());
        line = line.replace(findFormat(line), Integer.toString(employee.getYearOfBirth()));
        return line + "\n";
    }

    private String findFormat(String line) {
        int startIndex = line.indexOf("{");
        int endIndex = line.indexOf("}");
        return line.substring(startIndex, endIndex + 1);
    }
}