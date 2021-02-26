package exam03retake02;

public class Todo {
    private final String text;
    private State state;
    private final int priority;

    public Todo(String text, int priority) {
        if (priority > 5 || priority < 1) {
            throw new IllegalArgumentException("Invalid priority!");
        }
        this.text = text;
        this.state = State.NON_COMPLETED;
        this.priority = priority;
    }

    public void complete() {
        this.state = State.COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }
}
