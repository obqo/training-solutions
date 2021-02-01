/*
Legyen egy BillItem osztály, mely tartalmazza a name, number, unitPrice attribútumokat.
Legyen egy BillWriter osztály, melynek van egy writeBills() metódusa.
Ennek a számlatételeket egymás alatt szövegesen vissza kell adnia.
Ennek első paramétere egy List<BillItem>, azaz megkapja a számlatételeket.
A második paraméterét neked kell kitalálni! A lényeg, hogy bármit át tudj adni, hogy egy
számla tételt, hogy lehet kiírni. Ugyanis van, hogy egymás után kell kiírni a 3 attribútumot,
van, hogy tabokkal elválasztva, van, hogy mögé kell írni az összes árat is. Szóval változhat,
gyakorlatilag a sor kiirásának algoritmusát kell paraméterül átadni.
A visszatérési értéke egy String.
Sem a BillItem, sem a BillWriter metódust nem módosíthatod, és a következő
kiírási formákat kell megvalósítanod:
3 kenyér, darabja 10 Ft
5 tej, darabja 20 Ft
Megnevezés (20 karakter) Egységár (Ft) Darab Összeg
kenyer                              10     3     30
tej                                 20     5    100
Egységár 13 karakteren jobbra igazítva. Darab 5 karakteren jobbra igazítva. Összeg, 6 karakteren jobbra igazítva.
kenyér 3 * 10 = 30
tej 5 * 20 = 100
 */
package week13.week13d05;

import java.util.List;

public class BillWriter {

    public String writeBills(List<BillItem> billItems, LineWriter lineWriter) {
        StringBuilder sb = new StringBuilder();
        for (BillItem billItem : billItems) {
            String line = lineWriter.writeLine(billItem);
            sb.append(line).append('\n');
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        BillWriter billWriter = new BillWriter();
        List<BillItem> billItems = List.of(
                new BillItem("kenyér", 3, 10),
                new BillItem("tej", 5, 20));
        String result = billWriter.writeBills(billItems, new SimpleLineWriter());
        System.out.println(result);
        result = "Megnevezés          Egységár (Ft) Darab Összeg\n";
        result += billWriter.writeBills(billItems, new MultipleLineWriter());
        System.out.println(result);
    }
}
