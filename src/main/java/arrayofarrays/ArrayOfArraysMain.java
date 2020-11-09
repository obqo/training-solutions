package arrayofarrays;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size) {

        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    public void printArrayOfArrays(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] triangularMatrix(int size) {

        int[][] table = new int[size][];
        for (int i = 0; i < table.length; i++) {
            table[i] = new int[i+1];
            for (int j = 0; j < i + 1; j++) {
                table[i][j] = i;
            }
        }
        return table;
    }

    public int[][] getValues() {

        int[][] months = new int[12][];
        for (int i = 0; i< months.length; i++) {
            int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            months[i] = new int[days[i]];
        }
        return months;
    }

    public void printArrayOfArraysBonus(int[][] a) {

        for (int[] i : a) {
            for (int j : i) {
                System.out.print(" ".repeat(3 - String.valueOf(j).length()) + j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();
        System.out.println("Szorzótábla");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(4));
        System.out.println("Háromszögmátrix");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.triangularMatrix(4));
        System.out.println("Napi mért értékek");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.getValues());
        System.out.println("Bónusz kiíratás");
        arrayOfArraysMain.printArrayOfArraysBonus(arrayOfArraysMain.multiplicationTable(11));
    }
}
