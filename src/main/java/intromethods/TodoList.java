package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addList(String caption) {
        Todo todo = new Todo(caption);
        todos.add(todo);
    }

    public void finishTodos(String caption) {
        for (Todo todo : todos) {
            if (todo.getCaption().equals(caption)) {
                todo.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for (String todoToFinish : todosToFinish) {
            finishTodos(todoToFinish);
        }
    }

    public List<String> todosToFinish() {
        List<String> notFinished = new ArrayList<>();
        for (Todo todo : todos) {
            if (!todo.isFinished()) {
                notFinished.add(todo.getCaption());
            }
        }
        return notFinished;
    }

    public int numberOfFinishedTodos() {
        int count = 0;
        for (Todo todo :todos) {
            if (todo.isFinished()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return todos.toString();
    }
}
