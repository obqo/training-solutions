package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public String numberOfDaysAsString() {

        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public List<String> daysOfWeek() {

        return  Arrays.asList("Hétfő", "kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");
    }

    public String multiplicationTableAsString(int size) {

        int[][] mtable = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mtable[i][j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(mtable);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {

        return Arrays.equals(day, anotherDay);
    }

    private int min(int a, int b) {

        if (a < b) {
            return a;
        }
        else {
            return b;
        }
    }

    public boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {

        int min = min(day.length, anotherDay.length);
        double[] rangeOfDay = Arrays.copyOfRange(day, 0, min);
        double[] rangeOfDay2 = Arrays.copyOfRange(anotherDay, 0, min);
        return Arrays.equals(rangeOfDay, rangeOfDay2);
    }

    public boolean wonLottery(int[] array1, int[] array2) {

        int[] copy1 = Arrays.copyOf(array1, array1.length);
        int[] copy2 = Arrays.copyOf(array2, array2.length);
        Arrays.sort(copy1);
        Arrays.sort(copy2);
        return Arrays.equals(copy1, copy2);
    }

    public static void main(String[] args) {

        ArraysMain arraysMain = new ArraysMain();
        System.out.println(arraysMain.numberOfDaysAsString());

        System.out.println(arraysMain.daysOfWeek());

        System.out.println(arraysMain.multiplicationTableAsString(7));

        System.out.println(arraysMain.sameTempValues(new double[] {1, 2}, new double[] {1, 3}));
        System.out.println(arraysMain.sameTempValues(new double[] {1, 2}, new double[] {1, 2}));

        System.out.println(arraysMain.sameTempValuesDaylight(new double[] {1, 2}, new double[] {1, 2, 3}));
        System.out.println(arraysMain.sameTempValuesDaylight(new double[] {1, 3}, new double[] {1, 2, 3}));

        int[] array1 = {2, 1, 3};
        int[] array2 = {3, 2, 1};
        System.out.println(arraysMain.wonLottery(array1, array2));
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));


    }
}
