/*
Készíts egy diák (`Student`) osztályt melyben egy diák jegyeit tárolod egy Map-ben. A map kulcsa a tantárgy,
értéke pedig az adott tantárgy jegyeinek listája. Ezen felül a diáknak legyen neve, melyet konstruktorban kap meg.
Legyen benne egy metódus, ami paraméterül vár egy tantárgyat és egy jegyet, és beírja a jegyet a megfelelő tantárgyhoz.
Készítsd el a `ClassNotebook` nevű osztályt melyben diákok listája található.
Készíts egy lekérdező metódust a `ClassNoteBook` osztályban, legyen a neve `sortNotebook`
mely a diákok listáját ABC sorrendben adja vissza.
 */
package week14.week14d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassNotebook {

    private final List<Student> students;

    public ClassNotebook(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<Student> sortNoteBook() {
        List<Student> sorted = new ArrayList<>(students);
        Collections.sort(sorted, new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return sorted;
    }
}
