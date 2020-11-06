package introcontrol;

public class IntroControlMain {

    public static void main(String[] args) {

        IntroControl introControl = new IntroControl();

        System.out.println(introControl.substractTenIfGreaterThanTen(10));
        System.out.println(introControl.substractTenIfGreaterThanTen(15));
        System.out.println(introControl.substractTenIfGreaterThanTen(5));

        System.out.println(introControl.describeNumber(0));
        System.out.println(introControl.describeNumber(12));

        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("Jack"));

        System.out.println(introControl.calculateBonus(2_000_000));
        System.out.println(introControl.calculateBonus(500_000));

        System.out.println(introControl.calculateConsumption(234, 666));
        System.out.println(introControl.calculateConsumption(53, 6789));

        introControl.printNumbers(13);

        introControl.printNumbersBetween(3, 11);

        introControl.printNumbersBetweenAnyDirection(-3, 7);
        introControl.printNumbersBetweenAnyDirection(9, -2);

        introControl.printOddNumbers(11);
        introControl.printOddNumbers(12);

    }
}
