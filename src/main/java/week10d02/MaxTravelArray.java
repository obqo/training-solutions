package week10d02;

import java.util.List;

public class MaxTravelArray {

    public int getMAxIndex(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("No list or empty");
        }
        int[] array = new int[30];
        for (int item : list) {
            array[item]++;
            }
        return counter(array);
    }

    private int counter(int[] array) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        MaxTravelArray maxTravel = new MaxTravelArray();
        System.out.println(maxTravel.getMAxIndex(List.of(12, 12,1,0,3,4,4)));
    }
}

