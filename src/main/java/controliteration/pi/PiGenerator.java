package controliteration.pi;

public class PiGenerator {

    private static final String PI = "Nem a régi s durva közelítés,\n" +
            "Mi szótól szóig így kijön\n" +
            "Betűiket számlálva.\n" +
            "Ludolph eredménye már,\n" +
            "Ha itt végezzük húsz jegyen.\n" +
            "De rendre kijő még tíz pontosan,\n" +
            "Azt is bízvást ígérhetem.";

    public String getPi() {
        String pi = "";
        int count = 0;
        for (int i = 0; i < PI.length(); i++) {
            if (pi.length() == 1) {
                pi += ".";
            }
            if (Character.isAlphabetic(PI.charAt(i))) {
                count++;
            }
            else if (count != 0) {
                pi += count;
                count = 0;
            }
        }
        return pi;
    }
}
