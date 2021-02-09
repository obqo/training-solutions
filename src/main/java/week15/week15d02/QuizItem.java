package week15.week15d02;

public class QuizItem {

    private final String question;
    private final String answer;
    private final int point;
    private final String theme;

    public QuizItem(String question, String answer, int point, String theme) {
        this.question = question;
        this.answer = answer;
        this.point = point;
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public int getPoint() {
        return point;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return question +" " + answer +" " + point +" " +theme;
    }
}
