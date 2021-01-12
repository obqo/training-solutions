package week09.week09d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {

    private List<Person> people = new ArrayList<>();

    public SantaClaus(List<Person> people) {
        if (people == null)
            throw new IllegalArgumentException("List is null");
        this.people = people;
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }

    public void getThroughChimneys() {
        for (Person person : people) {
            person.setPresent();
        }
    }
}
