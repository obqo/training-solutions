package operators;

public class OperatorsMain {

    public static void main(String[] args) {

        Operators operators = new Operators();
        System.out.println(operators.isEven(4) ? "páros" : "páratlan");
        System.out.println(operators.isEven(7) ? "páros" : "páratlan");

        System.out.println(13 + "*2^" + 3 + "=" + Integer.parseInt(Integer.toBinaryString(operators.multiplyByPowerOfTwo(13, 3)), 2));

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        //int j = Integer.parseInt(s, 2);
        int j = Long.valueOf(s, 2).intValue();
        System.out.println(j);
    }
}
