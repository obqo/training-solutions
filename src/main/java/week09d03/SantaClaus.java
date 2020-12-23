package week09d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {

    private List<Person> persons = new ArrayList<>();

    public SantaClaus(List<Person> persons) {
        if (persons == null)
            throw new IllegalArgumentException("List is null");
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void getThroughChimneys() {
        for (Person person : persons) {
            person.setPresent();
        }
    }
}
