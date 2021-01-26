package week13.week13d02;

import java.util.ArrayList;
import java.util.List;

public class Competitor {

    private final String name;
    private final List<String> answers = new ArrayList<>();

    public Competitor(String name, String answer) {
        this.name = name;
        this.answers.add(answer);
    }

    public void addAnswer(String answer) {
        this.answers.add(answer);
    }

    public String getName() {
        return name;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int numberOfSkippedAnswer(String answer) {
        int result = 0;
        for (String item : answers) {
            if (item.equals(answer)) {
                result++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return name + " " + answers;
    }
}
