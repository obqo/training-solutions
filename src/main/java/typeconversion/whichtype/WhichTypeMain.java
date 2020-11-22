package typeconversion.whichtype;

public class WhichTypeMain {

    public static void main(String[] args) {

        WhichType whichType = new WhichType();
        long nr = Long.MAX_VALUE;
        System.out.println(whichType.whichType(Long.toString(nr)));
        nr = Integer.MAX_VALUE;
        System.out.println(whichType.whichType(Long.toString(nr)));
        nr = Short.MAX_VALUE;
        System.out.println(whichType.whichType(Long.toString(nr)));
        nr = Byte.MAX_VALUE;
        System.out.println(whichType.whichType(Long.toString(nr)));
        nr = Long.MAX_VALUE;
        System.out.println(whichType.whichType(Long.toString(nr)));
        nr = Integer.MIN_VALUE;
        System.out.println(whichType.whichType(Long.toString(nr)));
        nr = Short.MIN_VALUE;
        System.out.println(whichType.whichType(Long.toString(nr)));
        nr = Byte.MIN_VALUE;
        System.out.println(whichType.whichType(Long.toString(nr)));

    }
}
