//A ChangeLetter osztályban írj meg egy String changeVowels(String) metódust, mely kicseréli a paraméterként átadott szövegben
// az angol magánhangzókat csillag karakterre. Írj hozzá teszteseteket is!
package week05.week05d02;

public class ChangeLetter {

    public static final String VOWELS = "AEIOU";

    public String changeVowels(String str) {
        String replace = "";
        for (int i = 0; i < str.length(); i++) {
            if (VOWELS.indexOf(str.toUpperCase().charAt(i)) > -1) {
                replace += "*";
            }
            else {
                replace += str.charAt(i);
            }
        }
        return replace;
    }
}
