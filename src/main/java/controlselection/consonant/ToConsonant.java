package controlselection.consonant;

public class ToConsonant {

    public char convertToConsonant(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return (char) (ch + 1);
            default:
                return ch;
        }
    }
}
