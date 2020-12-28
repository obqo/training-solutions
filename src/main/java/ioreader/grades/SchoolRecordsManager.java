package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void readGradesFromFile(String fileName) {
        Path file = Path.of("src/main/resources/ioreader/" + fileName);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(" ");
                List<Integer> grades = new ArrayList<>();
                for (int i = 1; i < temp.length; i++) {
                    grades.add(Integer.parseInt(temp[i]));
                }
                students.add(new Student(temp[0], grades));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public double classAverage() {
        double sum = 0;
        for (Student student : students) {
                sum += student.average();
        }
        return sum / students.size();
    }
}
