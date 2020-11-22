package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(List<Mark> marks, String name) {
        if(isEmpty(name)) {
            throw new NullPointerException("Student name must not be empty!");
        }
        this.marks = marks;
        this.name = name;
    }

    public Student(String name) {
        if(isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // érdemjegy rögzítése
    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    // teljes átlag számolása
    public double calculateAverage() {
        double sum = 0;
        for (Mark mark : marks) {
            sum += mark.getMarkType().getValue();
        }
        return marks.size() > 0 ? (double) Math.round(sum / marks.size() * 100) / 100 : 0;
    }

    // tantárgyhoz tartozó átlag számítása
    public double calculateSubjectAverage(Subject subject) {
        double sum = 0;
        int count = 0;
        for (Mark mark : marks) {
            if (mark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sum += mark.getMarkType().getValue();
                count++;
            }
        }
        return count > 0 ? (double) Math.round(sum / count * 100) / 100 : 0;
    }

    // diák szöveges reprezentációja

    @Override
    public String toString() {
        String s = name +" marks: ";
        for (Mark mark : marks) {
            s += mark.getSubject().getSubjectName() + ": " + mark.toString();
        }
        return s;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
