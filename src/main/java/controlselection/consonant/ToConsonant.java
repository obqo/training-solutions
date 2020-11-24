package controlselection.consonant;

public class ToConsonant {

    public char nextChar(char ch) {
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

    public static void main(String[] args) {
        System.out.println(new ToConsonant().nextChar('a'));
        System.out.println(new ToConsonant().nextChar('e'));
        System.out.println(new ToConsonant().nextChar('i'));
        System.out.println(new ToConsonant().nextChar('o'));
        System.out.println(new ToConsonant().nextChar('u'));
        System.out.println(new ToConsonant().nextChar('b'));
        System.out.println(new ToConsonant().nextChar('z'));
    }
}
