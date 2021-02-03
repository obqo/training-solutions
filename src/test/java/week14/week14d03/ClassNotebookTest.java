package week14.week14d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    @Test
    void sortNoteBook() {
        Student student1 = new Student("Nagy Anna");
        student1.addSubjectEval("matematika", 5);
        student1.addSubjectEval("matematika", 3);
        student1.addSubjectEval("angol", 5);
        student1.addSubjectEval("angol", 4);
        student1.addSubjectEval("info", 3);
        student1.addSubjectEval("info", 5);
        Student student2 = new Student("Kiss Béla");
        student2.addSubjectEval("matematika", 4);
        student2.addSubjectEval("matematika", 5);
        student2.addSubjectEval("matematika", 5);
        student2.addSubjectEval("angol", 5);
        student2.addSubjectEval("angol", 3);
        student2.addSubjectEval("info", 5);
        Student student3 = new Student("Lang Péter");
        student3.addSubjectEval("matematika", 5);
        student3.addSubjectEval("matematika", 4);
        student3.addSubjectEval("matematika", 5);
        student3.addSubjectEval("angol", 5);
        student3.addSubjectEval("angol", 4);
        student3.addSubjectEval("angol", 4);
        student3.addSubjectEval("info", 5);
        student3.addSubjectEval("info", 5);
        student3.addSubjectEval("info", 5);
        ClassNotebook classNotebook = new ClassNotebook(new ArrayList<>(List.of(student1, student2, student3)));
        List<Student> result = classNotebook.sortNoteBook();
        assertEquals("Nagy Anna", classNotebook.getStudents().get(0).getName());
        assertEquals("Lang Péter", classNotebook.getStudents().get(2).getName());
        assertEquals("Kiss Béla", result.get(0).getName());
        assertEquals("Nagy Anna", result.get(2).getName());

        result.add(new Student("Jack"));
        assertEquals(3, classNotebook.getStudents().size());

        result.get(0).addSubjectEval("biológia", 1);
        assertEquals(3, classNotebook.getStudents().size());
        System.out.println(result.get(0));
        assertEquals(3, classNotebook.getStudents().get(1).getSubjectEvalMap().size());
     }
}