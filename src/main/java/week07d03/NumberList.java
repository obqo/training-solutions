package week07d03;

import java.util.Arrays;
import java.util.List;

public class NumberList {

    public static boolean isIncreasing(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("List is null");
        }
        if (numbers.size() ==1) {
            return true;
        }
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(isIncreasing(Arrays.asList(1, 2, 3, 3, 5)));
        System.out.println(isIncreasing(Arrays.asList(1, 2, 4, 3, 5)));
        System.out.println(isIncreasing(Arrays.asList(1, 2)));
        System.out.println(isIncreasing(Arrays.asList(1, -1)));
        System.out.println(isIncreasing(Arrays.asList(1)));
        System.out.println(isIncreasing(null));
    }
}