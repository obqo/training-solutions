package stringtype;

public class StringTypeMain {

    public static void main(String[] args) {

        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        System.out.println(message);

        message += 444;
        System.out.println(message);

        Boolean b = message.equals("Hello John Doe");
        Boolean c = message.equals("Hello John Doe444");

        System.out.println(b);
        System.out.println(c);

        String s1 = "", s2 = "";
        System.out.println(s1 + s2);
        System.out.println((s1 + s2).length());

        System.out.println("Abcde".length());
        System.out.println("Abcde".charAt(0) + "," + "Abcde".charAt(2));
        System.out.println("Abcde".substring(0, 3));

    }
}
