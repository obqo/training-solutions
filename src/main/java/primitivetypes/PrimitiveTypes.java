package primitivetypes;

public class PrimitiveTypes {

    public static final int bit = 32;

    public String toBinaryString(int n) {
        String binary = "";
        while (n > 0) {
            binary = n % 2 + binary;
            n = n / 2;
        }
        return "0".repeat(bit - binary.length()) + binary;
    }
}
