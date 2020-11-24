package week05d02;

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
