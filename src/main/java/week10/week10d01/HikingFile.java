/*
Túrázás közben egy GPS eszköz rögzíti a pontokat. Eltárolja a GPS koordinátákat, valamint a magasságot (mindegyik lebegőpontos érték).
Ezt egy fájlba tárolja, melynek formátuma:
47.497913, 19.040236, 400
47.497912, 19.040232, 420
47.497916, 19.040236, 410
Írj a HikingFile osztályba egy getElevation() metódust, mely kap egy InputStream-et, és visszaadja
külön az ereszkedések, és külön az emelkedések összegét. Azaz pl. 10,20,15,18 esetén az emelkedés 13, ugyanis (20 - 10) + (18 - 15).
A 20 méterről 15 méterre ereszkedést pedig 5.
 */
package week10.week10d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HikingFile {

    public static HikingElevationData getElevation(String fileName) {
        HikingElevationData data = new HikingElevationData();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(HikingFile.class.getResourceAsStream(fileName)))) {
            String line;
            double prev = Double.parseDouble(reader.readLine().split(", ")[2]);
            while ((line = reader.readLine()) != null) {
                double actual = Double.parseDouble(line.split(", ")[2]);
                if (actual > prev) {
                    data.incAscent(actual - prev);
                } else {
                    data.incDescent(prev - actual);
                }
                prev = actual;
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return data;
    }
}
