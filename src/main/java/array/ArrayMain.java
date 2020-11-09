package array;

public class ArrayMain {

    public static void main(String[] args) {
        String[] week = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        System.out.println(week[1]);
        System.out.println(week.length);

        int[] power = new int[5];
        for (int i = 0; i < power.length; i++) {
            power[i] = (int) Math.pow(2, i);
        }
        for (int elem : power) {
            System.out.print(elem + " ");
        }
        System.out.println();

        boolean[] array = new boolean[6];
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1];
        }
        for (boolean elem : array) {
            System.out.print(elem + " ");
        }
    }
}
