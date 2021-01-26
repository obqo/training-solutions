/*
Egy internetes kvíz versenyen egy fájlba rögzitettük a versenyzők válaszait. A versenyzők egyszerre kezdtek és egyszerre egy
kérdésre válaszoltak meg. A fájlban az egyes versenyzők válaszai sorban szerepelnek, de a fájlban a sorok a beérkezett
válaszok sorrendjében találhatók.
PL.:
ABACD
AB123 A
AH2 B
BD452 A
AB123 B
GH1234 C

Magyarázat:A fájl első sora a helyes válaszokat tartalmazza egy sorban. (5 kérdés volt az elsőre a helyes válasz A a
másodikra B stb.) Ezek után a sor első eleme egy azonosító a második pedig egy a válasz betűjele. Minden kérdésnél négy
válaszlehetőség volt (A,B,C,D) és lehetett ugrani egy kérdést ekkor X szerepel a fájlban.
Tehát az AB123 azonosítóval rendelkező játékos első válasza A a második B. A többieknek csak az első kérdésre adott válaszuk
szerepel a példában.

Feladatok:
1. Olvasd be a fájl tartalmát a memóriába.
2. Legyen egy lekérdező metódus ami paraméterül vár egy kódot és egy számot és megmondja hogy az ileltő az adott kérdésre
helyesen vagy helytelenül válaszolt-e.
3. Legyen egy metódus ami visszaadja annak versenyzőnek a kódját, akinek a legtöbb X szerepel a válaszai között.
4. Adjuk vissza annak a versenyzőnek a kódját, aki a legtöbb pontot szerezte. Pont a helyes válaszért jár méghozzá annyi,
ahányadik kérdés volt a sorban. Az első kérdés egy pontos a második kettő stb.
 */
package week13.week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private String correct;
    private final List<Competitor> competitors = new ArrayList<>();

    public String getCorrect() {
        return correct;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void readFiles() {
        InputStreamReader is = new InputStreamReader(Quiz.class.getResourceAsStream("result.txt"));
        try (BufferedReader reader = new BufferedReader(is)) {
            correct = correctAnswer(reader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(" ");
                String name = splitLine[0];
                String answer = splitLine[1];
                addCompetitor(name, answer);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    public boolean isCorrectAnswer(String name, int question) {
        if (indexCompetitor(name) == -1) {
            throw new IllegalStateException("Can not find competitor!");
        }
        return getAnswer(name, question).equals(getCorrectAnswer(name, question));
    }

    public String mostSkippedAnswer() {
        Competitor maxSkipped = competitors.get(0);
        for (Competitor actual: competitors) {
            if (actual.numberOfSkippedAnswer("X") > maxSkipped.numberOfSkippedAnswer("X")) {
                maxSkipped = actual;
            }
        }
        return maxSkipped.getName();
    }

    public String winner() {
        Competitor winner = competitors.get(0);
        for (Competitor actual : competitors) {
            if (receivedPoints(winner) < receivedPoints(actual)) {
                winner = actual;
            }
        }
        return winner.getName();
    }

    private int receivedPoints(Competitor competitor) {
        int result = 0;
        for (int i = 0; i < correct.length(); i++) {
            if (competitor.getAnswers().get(i).equals(Character.toString(correct.charAt(i)))) {
                result += i + 1;
            }
        }
        return result;
    }

    private String getAnswer(String name, int question) {
        return competitors.get(indexCompetitor(name)).getAnswers().get(question - 1);
    }

    private String getCorrectAnswer(String name, int question) {
        return Character.toString(correct.charAt(question -1));
    }

    private void addCompetitor(String name, String answer) {
        if (competitors.size() == 0 || indexCompetitor(name) == -1) {
            competitors.add(new Competitor(name, answer));
        } else {
            competitors.get(indexCompetitor(name)).addAnswer(answer);
        }
    }

    private int indexCompetitor(String name) {
        for (int i = 0; i < competitors.size(); i++) {
            if (competitors.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private String correctAnswer(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.readFiles();
        System.out.println(quiz.competitors);
        System.out.println(quiz.isCorrectAnswer("AH2", 2));
        System.out.println(quiz.mostSkippedAnswer());
        System.out.println(quiz.winner());
    }
}
