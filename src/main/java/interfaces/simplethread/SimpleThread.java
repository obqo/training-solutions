package interfaces.simplethread;

import java.util.List;

public class SimpleThread implements Runnable{

    private List<String> tasks;

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    public List<String> getTasks() {
        return tasks;
    }

    private boolean nextStep() {
        if (tasks != null && !tasks.isEmpty()) {
            tasks.remove(tasks.size() - 1);
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        while (nextStep()) {

        }
    }
}
