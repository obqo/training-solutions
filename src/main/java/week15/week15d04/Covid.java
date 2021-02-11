/*
Letölthetőek a koronavírus adatok innen: https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/data.csv
Melyik három héten volt Magyarországon a legtöbb esetszám?
 */
package week15.week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Covid {

    private final List<Data> dataList = new ArrayList<>();

    public void readlines(Path file, String country) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line, country);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private void processLine(String line, String country) {
        if (line.contains(country)) {
            String[] splitLine = line.split(",");
            dataList.add(new Data(Integer.parseInt(splitLine[2]), splitLine[1]));
        }
    }

    public List<String> topList(int nr) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(nr, sortListByCase().size()); i++) {
            result.add(sortListByCase().get(i).getYear_week());
        }
        return result;
    }

    private List<Data> sortListByCase() {
        if (dataList.size() == 0) {
            throw new IllegalArgumentException("Wrong country!");
        }
        List<Data> copyDataList = new ArrayList<>(dataList);
        copyDataList.sort(Comparator.comparingInt(Data::getCases_weekly).reversed());
        return copyDataList;
    }


    public static void main(String[] args) {
        Covid covid = new Covid();
        Path file = Path.of("src/main/java/week15/week15d04/data.csv");
        covid.readlines(file, "Hungary");
        System.out.println(covid.dataList);
        System.out.println(covid.topList(3));
    }
}
