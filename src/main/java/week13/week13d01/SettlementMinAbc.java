/*
A GitHubon a `examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv` fájl tartalmazza a magyar városok listáját.
Add vissza az ábécésorrendben első város nevét és irányítószámát!
 */
package week13.week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SettlementMinAbc {

    public Settlement minAbcSettlement() {
        String name = "zzz";
        int postcode = 0;
        InputStreamReader is = new InputStreamReader(SettlementMaxLen.class.getResourceAsStream("iranyitoszamok-varosok-2021.csv"));
        try (BufferedReader reader = new BufferedReader(is)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(";");
                if (name.compareTo(temp[1]) > 0) {
                    name = temp[1];
                    postcode = Integer.parseInt(temp[0]);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
        return new Settlement(name, postcode);
    }

    public static void main(String[] args) {
        System.out.println(new SettlementMinAbc().minAbcSettlement());
    }
}

