package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    private List<State> states = new ArrayList<>();

    public void readStatesFromFile(String fileName) {
        Path file = Path.of("src/main/resources/ioreader/" + fileName);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                states.add(new State(line.split("-")[0], line.split("-")[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public String findCapitalByStateName(String stateName) {
        for (State state : states) {
            if (state.getStateName().equals(stateName)) {
                return state.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }
}
