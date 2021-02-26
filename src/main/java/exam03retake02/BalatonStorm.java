/*
Balatoni viharjelzés
A https://vmonitor.rsoe.hu/api/mapApi/stations.php címen le lehet tölteni az aktuális balatoni viharjelzéseket.
Írj egy programot, mely kilistázza, hogy hol van vihar! Ábécésorrendbe rendezve!
A BalatonStorm osztály getStationsInStorm() metódusát implementáld! Paraméterként kap egy BufferedReader-t,
és visszaadja az állomások listáját. A fájl a következő formátumú.
[
  {
    "id": 5,
    "allomas": "Siófok (OMSZ)",
    "lat": "46.910647",
    "lng": "18.040237",
    "description": "A közforgalmú MAHART kikötőtől délnyugatra kb. 200 méterre",
    "level": 0,
    "groupId": "BE",
    "stationType": "LED"
  },
  {
    "id": 6,
    "allomas": "Siófok-H. Erzsébet",
    "lat": "46.91567",
    "lng": "18.06600000000003",
    "description": "Hotel Erzsébet szálló tetején.",
    "level": 0,
    "groupId": "BE",
    "stationType": "LED"
  }
]
Azokon az állomásokon van vihar, ahol a level értéke 3.
 */
package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        List<String> result = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("allomas")) {
                String allomas = line.split(": \"")[1].replace("\",", "");
                line = skipLine(reader, 4);
                if (line.split(": ")[1].equals("3,")) {
                    result.add(allomas);
                }
            }
        }
        Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
        return result;
    }

    private String skipLine(BufferedReader reader, int nr) throws IOException {
        String line = null;
        for (int i = 0; i < nr; i++) {
            line = reader.readLine();
        }
        return line;
    }
}
