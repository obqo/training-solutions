/*
Írj egy sablonkezelő rendszert! Hozz létre egy TemplateEngine nevezetű osztályt, benne egy
void merge(BufferedReader reader, Map<String, Object>, BufferedWriter writer) metódussal. Az első paraméter a sablon,
a második paraméter pedig az értékek, melyeket ki kell cserélni a sablonban.
Képzeljük el, hogy ez a sablon:
Kedves {nev}!
Megküldjük önnek a következő esedékes számláját {datum} dátummal,
melynek összege: {osszeg} Ft!
A fizetési határidő {hatarido}.
Üdvözlettel,
Ügyfélszolgálat
A metódus második paraméterként egy Map-ben kapja az értékeket:
{"nev" = "John Doe", "datum" = LocalDate}
A feladat, hogy a writer-be ki kell írni a levelet, de már kicserélve az értékeket.
 */
package week13.week13d04;

import java.io.*;
import java.time.LocalDate;
import java.util.Map;

public class TemplateEngine {

    public void merge(BufferedReader reader, Map<String, Object> values, BufferedWriter writer) {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String merge = merge(line, values);
                writer.write(merge);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private String merge(String line, Map<String, Object> values) {
        int index = 0;
        String result = line;
        while (result.indexOf("{", index) > 0) {
            int indexOpen = result.indexOf("{", index);
            int indexClose = result.indexOf("}", index);
            String key = result.substring(indexOpen + 1, indexClose);
            String value = values.get(key).toString();
            result = line.replace("{" + key + "}", value);
            index = indexClose;
        }
        return result + "\n";
    }

    public static void main(String[] args) {
        TemplateEngine te = new TemplateEngine();
        BufferedReader reader = new BufferedReader(new InputStreamReader(TemplateMerger.class.getResourceAsStream("invoiceformat.txt")));
        Map<String, Object> values = Map.of(
                "nev", "John Doe",
                "datum", LocalDate.of(2021, 1, 2),
                "osszeg", 543.21,
                "hatarido", LocalDate.of(2021, 2, 2));
        StringWriter sw = new StringWriter();
        try (BufferedWriter writer = new BufferedWriter(sw);) {
            te.merge(reader, values, writer);
        } catch (IOException ioe) {
            throw new IllegalStateException("Somthing wrong!", ioe);
        }
        System.out.println(sw.toString());
    }
}
