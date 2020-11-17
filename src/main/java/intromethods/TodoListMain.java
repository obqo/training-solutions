package intromethods;

import java.util.Arrays;

public class TodoListMain {

    public static void main(String[] args) {

        TodoList todoList = new TodoList();
        todoList.addList("1");
        todoList.addList("2");
        todoList.addList("3");
        todoList.addList("4");
        todoList.addList("5");
        System.out.println(todoList);
        todoList.finishTodos("3");
        System.out.println(todoList);
        todoList.finishAllTodos(Arrays.asList("1", "4"));
        System.out.println(todoList);
        System.out.println(todoList.todosToFinish());
        System.out.println(todoList.numberOfFinishedTodos());
    }
}
