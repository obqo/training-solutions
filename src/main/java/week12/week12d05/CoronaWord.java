/*
Töltsd le az index.hu nyitólapját böngészőből, ez egy html állomány! Másold be a projektedbe (index.html) néven! Ez egy szöveges állomány.
Olvasd be, és számold meg, hány sorban szerepel a koronavírus szó!
 */
package week12.week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoronaWord {

    private static final String SEARCHED_WORD = "koronavírus";

    public int coronaCounter() {
        int count = 0;
        InputStreamReader is = new InputStreamReader(CoronaWord.class.getResourceAsStream("index.html"));
        try (BufferedReader reader = new BufferedReader(is)) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                if (line.contains(SEARCHED_WORD)) {
                    count++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file");
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CoronaWord().coronaCounter());
    }
}
