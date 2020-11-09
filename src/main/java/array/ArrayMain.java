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
            System.out.println(elem);
        }

        Boolean[] array = {false, true, false, true, false, true};
        for (Boolean elem : array) {
            System.out.println(elem);
        }
    }
}
