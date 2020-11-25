package controladvanced.cars;

import java.util.ArrayList;
import java.util.List;

public class UsedCars {

    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line: lines) {
            String[] parts = line.split(";");
            if(parts.length != 4) {
                continue;
            }
            if (!parts[0].contains("-")) {
                continue;
            }
            if (Integer.parseInt(parts[1]) >= 2019 || Integer.parseInt(parts[1]) <= 1970) {
                continue;
            }
            validLines.add(line);
        }
        return validLines;
    }
}
