package controlselection.accents;

public class WithoutAccents {

    /*
    public char convertToCharWithoutAccents (char ch) {
        switch (ch) {
            case 'á':
                return 'a';
            case 'é':
                return 'e';
            case 'í':
                return  'i';
            case 'ó':
            case 'ö':
            case 'ő':
                return 'o';
            case 'ú':
            case 'ü':
            case 'ű':
                return 'u';
            default:
                return ch;
        }
    }
   */

    public static final String LETTERS_WITH_ACCENTS = "áéíóöőúüűÁÉÍÓÖŐÚÜŰ";

    public static final String LETTERS_WITHOUT_ACCENTS = "aeiooouuuAEIOOOUUU";

    public char convertToCharWithoutAccents(char c) {
        int index = LETTERS_WITH_ACCENTS.indexOf(c);
        if (index >= 0) {
            return LETTERS_WITHOUT_ACCENTS.charAt(index);
        }
        else {
            return c;
        }
    }
}
