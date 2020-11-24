package controlselection.accents;

public class WithoutAccents {

    public char getWithoutAccents (char ch) {
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

    public static void main(String[] args) {
        System.out.println(new WithoutAccents().getWithoutAccents('á'));
        System.out.println(new WithoutAccents().getWithoutAccents('é'));
        System.out.println(new WithoutAccents().getWithoutAccents('í'));
        System.out.println(new WithoutAccents().getWithoutAccents('ó'));
        System.out.println(new WithoutAccents().getWithoutAccents('ö'));
        System.out.println(new WithoutAccents().getWithoutAccents('ő'));
        System.out.println(new WithoutAccents().getWithoutAccents('ú'));
        System.out.println(new WithoutAccents().getWithoutAccents('ü'));
        System.out.println(new WithoutAccents().getWithoutAccents('ű'));
        System.out.println(new WithoutAccents().getWithoutAccents('e'));
        System.out.println(new WithoutAccents().getWithoutAccents('x'));

    }
}
