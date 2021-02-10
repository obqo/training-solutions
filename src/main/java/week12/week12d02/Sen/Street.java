/*
A kerites.txt fájlban egy utca telek nyilvántartását találjuk. Minden sorban három adat található. Az első szám megadja, hogy a telek a páros (0)
vagy a páratlan (1) oldalán van az utcának; a második a telek szélességét adja meg méterben (egész szám, értéke 8 és 20 között lehet); a harmadik
pedig az utcafronti kerítés színét leíró karakter. A szín az angol ábécé nagybetűje. Ha a kerítést már elkészítették, de nem festették be, akkor a
„#” karakter, ha még nem készült el, akkor a „:” (kettőspont) karakter szerepel. Az utca hossza legfeljebb 1000 méter. Mindkét oldalon elkelt
legalább 3-3 telek. Amikor vásárolunk mindig csak az utojára eladott telek rákövetkezőjét vehetjük, vagy a másik oldalon utoljára eladott
rákövetkezőjét.

Példa:

0 10 P
1 8 K
1 10 :
1 9 S
0 10 P

Magyarázat: Az első telek a páros oldalon található, 10 méter széles, a kerítés kész és P színnel festették be. A harmadik telek a páratlan oldalon
van szintén 10 méter, a kerítés kész, de még nincs befestve. A házszámok a következők sorban: 2,1,3,5,4

Feladatok:
Olvasd be a fájl tartalmát a memóriába!
Az eddig eladott telkekből készítsünk egy sorrendet, méghozzá a méretük alapján!
Határozzuk meg a fájl utolsó sorában szereplő telek házszámát!
Írd ki egy fájlba, a páratlan oldal utcaképét!
Pl.: (1)KKKKKKKK(3)::::::::::(5)SSSSSSSSS
Magyarázat: A házszám zárójelben, majd annyi a kerítést leíró jellemző, amilyen hosszú a telek.
 */
package week12.week12d02.Sen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Street {

    private final List<Land> lands = new ArrayList<>();

    public void readFiles(String filename) {
        Path file = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            int even = 0;
            int odd = -1;
            int nr;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(" ");
                int side = Integer.parseInt(temp[0]);
                int length = Integer.parseInt(temp[1]);
                String color = temp[2];
                if (side == 0) {
                    even += 2;
                    nr = even;
                }
                else {
                    odd +=2;
                    nr = odd;
                }
                lands.add(new Land(Side.values()[side], length, color, nr));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public List<Land> sortListByLength() {
        List<Land> sortList = new ArrayList<>(lands);
        sortList.sort(new SortByLength());
        return sortList;
    }

    public void writeFiles(String filename) {
        Path file = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (Land land : lands) {
                if (land.getSide()==Side.ODD_SIDE) {
                    writer.write("(" + land.getNr() + ")");
                    writer.write((land.getColor().repeat(land.getLength())));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public static void main(String[] args) {
        Street street = new Street();
        street.readFiles("src/main/java/week12/week12d02/sen/kerites.txt");
        System.out.println(street.lands);
        //Az eddig eladott telkekből készítsünk egy sorrendet, méghozzá a méretük alapján!
        System.out.println(street.sortListByLength());
        //Határozzuk meg a fájl utolsó sorában szereplő telek házszámát!
        System.out.println(street.lands.get(street.lands.size() - 1).getNr());
        //Írd ki egy fájlba, a páratlan oldal utcaképét!
        street.writeFiles("src/main/java/week12/week12d02/sen/paratlan_oldal.txt");
    }
}