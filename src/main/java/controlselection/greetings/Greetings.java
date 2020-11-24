package controlselection.greetings;

public class Greetings {

    public String Greeting(int hour, int min) {
        int time = hour * 60 + min;
        if (time > 5 * 60 && time < 9 * 60 ) {
            return "Good morning!";
        }
        else if (time >= 9 * 60 && time <= 18 * 60 + 30) {
            return "Godd day!";
        }
        else if (time > 18 * 60 + 30 && time < 20 * 60) {
            return "Good Evening!";
        }
        else {
            return "Good Night!";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Greetings().Greeting(5, 30));
        System.out.println(new Greetings().Greeting(9, 00));
        System.out.println(new Greetings().Greeting(11, 33));
        System.out.println(new Greetings().Greeting(18, 30));
        System.out.println(new Greetings().Greeting(19, 30));
        System.out.println(new Greetings().Greeting(20, 00));
        System.out.println(new Greetings().Greeting(20, 30));
    }
}
