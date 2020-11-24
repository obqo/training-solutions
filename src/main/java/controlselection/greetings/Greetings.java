package controlselection.greetings;

public class Greetings {

    public String greet(int hour, int min) {
        int time = hour * 60 + min;
        if (time > 5 * 60 && time <= 9 * 60 ) {
            return "jó reggelt";
        }
        else if (time > 9 * 60 && time <= 18 * 60 + 30) {
            return "jó napot";
        }
        else if (time > 18 * 60 + 30 && time <= 20 * 60) {
            return "jó estét";
        }
        else {
            return "jó éjt";
        }
    }
}
