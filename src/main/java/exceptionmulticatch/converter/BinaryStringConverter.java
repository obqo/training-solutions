package exceptionmulticatch.converter;

import java.lang.reflect.Array;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String binaryString) {
        if (binaryString == null)
            throw new NullPointerException("binaryString null");
        boolean[] result = new boolean[binaryString.length()];
        for (int i =0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) != '0' && binaryString.charAt(i) != '1')
                throw new IllegalArgumentException("binaryString not valid");
            result[i] = binaryString.charAt(i) == '1';
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] booleanArray) {
        if (booleanArray == null)
            throw new NullPointerException("Boolean array is null");
        if (booleanArray.length == 0)
            throw new IllegalArgumentException("Boolean array size 0");
        StringBuilder result =new StringBuilder(booleanArray.length);
        for (boolean item : booleanArray) {
            if (item)
                result.append("1");
            else
                result.append("0");
        }
        return result.toString();
    }
}
