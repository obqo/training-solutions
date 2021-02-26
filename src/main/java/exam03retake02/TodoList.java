/*
Tennivalólista
Írj egy tennivaló osztályt (Todo), melynek attribútumai: text, state és priority, rendre String, State és int típusú.
A State egy saját enum COMPLETED és NON_COMPLETED értékekkel. A prioritás 1 és 5 közötti egész szám.
Ha nem ilyet kap, akkor kivételt dob. Konstuktorban csak a szövegét és a prioritását kell megadni,
alapértelmezetten NON_COMPLETED állapottal jön létre. Legyen egy complete() metódusa, mely átállítja az állapotát!
Legyen egy TodoList osztály, mely több tennivalót tartalmaz! Egy List<Todo> attribútumban tartalmazza a tennivalókat.
Metódusai:
getNumberOfItemsLeft() - visszaadja a még el nem készült tennivalók számát
getMostImportantTodosText() - visszaadja a legyfontosabb tennivalókat. Nem feltétlen van 1-es prioritású.
deleteCompleted() - a listából kitörli az elvégzetteket
 */
package exam03retake02;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public int getNumberOfItemsLeft() {
        int count = 0;
        for (Todo todo : todos) {
            if (todo.getState().equals(State.NON_COMPLETED)) {
                count++;
            }
        }
        return count;
    }

    public List<String> getMostImportantTodosText() {
        List<String> result = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getPriority() == minPriority()) {
                result.add(todo.getText());
            }
        }
        return result;
    }

    private int minPriority() {
        int min = todos.get(0).getPriority();
        for (Todo todo : todos) {
            if (todo.getPriority() < min) {
                min = todo.getPriority();
            }
        }
        return min;
    }

    public void deleteCompleted() {
        List<Todo> deletedCompleted = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getState().equals(State.NON_COMPLETED)) {
                deletedCompleted.add(todo);
            }
        }
        todos = deletedCompleted;
    }

    public List<Todo> getTodos() {
        return todos;
    }
}
