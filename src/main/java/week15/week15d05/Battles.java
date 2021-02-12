package week15.week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Battles {

    private final Map<String, Integer> dataMap = new HashMap<>();

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
        String[] splitLine = replaceQuoted(line).split(",");
        Set<String> participants = new HashSet<>(Arrays.asList(splitLine).subList(5, 13));
        for (String house : participants) {
            if (!house.isEmpty()) {
                putMap(house);
            }
        }
    }

    private String replaceQuoted(String line) {
        while (line.contains("\"")) {
            int first = line.indexOf("\"");
            int last = line.substring(first + 1).indexOf("\"") + first;
            String result = line.substring(first, last + 2);
            String change = result.replace(",", "_").replace("\"", "");
            line = line.replace(result, change);
        }
        return line;
    }

    private void putMap(String house) {
        if (!dataMap.containsKey(house)) {
            dataMap.put(house, 0);
        }
        dataMap.put(house, dataMap.get(house) + 1);
    }

    public String sortedData() {
        TreeSet<Battle> sortedList = new TreeSet<>(Comparator.comparingDouble(Battle::getNr).reversed());
        for (String key : dataMap.keySet()) {
            sortedList.add(new Battle(key, dataMap.get(key)));
        }
        return sortedList.iterator().next().getHouse();
    }

    /*
        public String sortedData() {
        List<Battle> sortedList = new ArrayList<>();
        for (String key : dataMap.keySet()) {
            sortedList.add(new Battle(key, dataMap.get(key)));
        }
        sortedList.sort(Comparator.comparingDouble(Battle::getNr).reversed());
        return sortedList.get(0).getHouse();
    }
     */

    public Map<String, Integer> getDataMap() {
        return new HashMap<>(dataMap);
    }

    public static void main(String[] args) {
        Battles battles = new Battles();
        Path file = Path.of("src/main/java/week15/week15d05/battles.csv");
        battles.readlines(file);
        System.out.println(battles.getDataMap());
        System.out.println(battles.sortedData());
    }
}
