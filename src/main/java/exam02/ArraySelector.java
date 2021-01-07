package exam02;

//import a.A;

import java.util.ArrayList;
import java.util.List;

public class ArraySelector {

    public String selectEvens(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        List<Integer> evenIndexList = new ArrayList<>();
        for (int i = 0; i < array.length; i = i + 2) {
            evenIndexList.add(array[i]);
        }
        if (evenIndexList.toString() == "[]") {
            return "";
        }
        return evenIndexList.toString();
    }

//    public static void main(String[] args) {
//        A a = new A();
//        int[] array = {123, 21, 11, 15};
//        System.out.println(a.evenArrayElements(array));
//    }
}