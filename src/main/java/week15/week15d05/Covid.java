/*
Letölthetőek a COVID adatok a https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/data.csv címről.
Összegezd országonként az esetszámokat, és add vissza azt a három országot,
ahol az összes esetszám populációra arányosítva a legnagyobb.
 */
package week15.week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Covid {

    private final Map<String, Double> dataMap = new HashMap<>();

    public void readlines(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private void processLine(String line) {
        String[] splitLine = line.split(",");
        String country = splitLine[4];
        double cases_weekly = Double.parseDouble(splitLine[2]);
        int pos = country.contains("\"") ? 8 : 7;
        double population = splitLine[pos].isEmpty() ? 0.0 : Double.parseDouble(splitLine[pos]);
        double percent = cases_weekly / population;
        if (!dataMap.containsKey(country)) {
            dataMap.put(country, 0.0);
        }
        dataMap.put(country, dataMap.get(country) + percent);
    }

    public List<Data> sortedData() {
        List<Data> sortedList = new ArrayList<>();
        for (String key : dataMap.keySet()) {
            if (dataMap.get(key) > 0) {
                sortedList.add(new Data(key, dataMap.get(key)));
            }
        }
        sortedList.sort(Comparator.comparingDouble(Data::getPercent).reversed());
        return sortedList.subList(0, 3);
    }

    public static void main(String[] args) {
        Covid covid = new Covid();
        Path file = Path.of("src/main/java/week15/week15d05/data.csv");
        covid.readlines(file);
        System.out.println(covid.dataMap);
        System.out.println(covid.sortedData());
    }
}
