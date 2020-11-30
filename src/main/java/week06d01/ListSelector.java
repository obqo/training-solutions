/*
Írj egy olyan metódust az week06d01.ListSelector osztályban, mely egy kapott listából minden második elemet kiválogat, és egy szövegként összerak,
szögletes zárójelek között. A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.
Ha üres a lista, akkor üres stringet adjunk vissza. Ha a paraméterül kapott lista null, akkor dobjunk IllegalArgumentExceptiont a metódusban.
Bónusz: A páros sorszámú elemek vesszővel elválasztva.
pl.: {"alma","körte","barack"} -> "[almabarack]"
 */
package week06d01;

import java.util.ArrayList;
import java.util.List;

public class ListSelector {

    public String selectorBonus(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException("Empty list!");
        }
        List<String> newStrings = new ArrayList<>();
        for (int i = 0; i < strings.size(); i+=2) {
            newStrings.add(strings.get(i));
        }
        if (newStrings.toString() == "[]") {
            return "";
        }
        return newStrings.toString().replace(", ", ",");
    }

    public String selector(List<String> strings) {
        return selectorBonus(strings).replace(",", "");
    }
}
