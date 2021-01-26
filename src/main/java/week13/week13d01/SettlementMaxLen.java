/*
A GitHubon a `examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv` fájl tartalmazza a magyar városok listáját.
Add vissza a leghosszabb nevű várost!
 */
package week13.week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SettlementMaxLen {

    public String maxLengthSettlement() {
        String result ="";
        InputStreamReader is = new InputStreamReader(SettlementMaxLen.class.getResourceAsStream("iranyitoszamok-varosok-2021.csv"));
        try (BufferedReader reader = new BufferedReader(is)) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(";");
                if (result.length() < temp[1].trim().length()) {
                    result = temp[1].trim();
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SettlementMaxLen().maxLengthSettlement());
    }
}
