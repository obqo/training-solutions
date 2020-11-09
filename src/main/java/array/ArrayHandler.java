package array;

import java.util.Arrays;

public class ArrayHandler {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6};
        ArrayHandler mem = new ArrayHandler();
        System.out.println(mem.contains(array, 2));
        System.out.println(mem.find(array, 2));
        System.out.println(mem.contains(array, 23));
        System.out.println(mem.find(array, 23));
    }

    public boolean contains(int[] source, int itemToFind) {

        for (int elem : source) {
            if (elem == itemToFind) {
                return true;
            }
        }
        return false;
    }

    public int find(int[] source, int itemToFind) {

        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                return i;
            }
        }
        return -1;
    }

}
