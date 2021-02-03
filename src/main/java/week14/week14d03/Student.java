package week14.week14d03;

import java.util.*;

public class Student {

    private final String name;
    private Map<String, List<Integer>> subjectEvalMap = new TreeMap<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(Student s) {
        name = s.name;
        subjectEvalMap = new TreeMap<>(s.subjectEvalMap);
    }

    public void addSubjectEval(String subject, int evaluation) {
        if (!subjectEvalMap.containsKey(subject)) {
            subjectEvalMap.put(subject, new ArrayList<>());
        }
        subjectEvalMap.get(subject).add(evaluation);
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Integer>> getSubjectEvalMap() {
        return subjectEvalMap;
    }

    @Override
    public String toString() {
        return name + " " + subjectEvalMap;
    }
}
