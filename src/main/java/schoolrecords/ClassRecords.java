package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public List<Student> getStudents() {
        return students;
    }

    // felvesz egy diákot az osztályba
    public boolean addStudent(Student student) {
        for (Student stud : students) {
            if (stud.getName().equals(student.getName())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    //kivesz egy diákot az osztályból
    public boolean removeStudent(Student student) {
        for (Student stud : students) {
            if (stud.getName().equals(student.getName())) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    //osztályátlagot számol, minden diákot figyelembe véve
    public double calculateClassAverage() {
        double sum = 0;
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        for (Student student : students) {
            sum += student.calculateAverage();
        }
        if (sum == 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return (double) Math.round(sum / students.size() * 100) / 100;
    }

    //tantárgy szerinti osztályátlagot számol, kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye
    public double calculateClassAverageBySubject(Subject subject) {
        double sum = 0;
        int count = 0;
        for (Student student : students) {
            if (student.calculateSubjectAverage(subject) > 0) {
                sum += student.calculateSubjectAverage(subject);
                count++;
            }
        }
        return count > 0 ? (double) Math.round(sum / count * 100) / 100 : 0;
    }

    // név szerint megkeres egy diákot az osztályban
    public Student findStudentByName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        }
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    //felelethez a listából random módon kiválaszt egy diákot
    public Student repetition() {
        if (students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));
    }

    //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi, és azok listáját adja vissza
    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        for (Student student : students) {
            studyResultByNames.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }
        return studyResultByNames;
    }

    //kilistázza a diákok neveit, vesszővel elválasztva
    public String listStudentNames() {
        List<String> studentNames = new ArrayList<>();
        for (Student student : students) {
            studentNames.add(student.getName());
        }
        return String.join(", ", studentNames);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
