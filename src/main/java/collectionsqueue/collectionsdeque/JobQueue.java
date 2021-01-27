/*
A Deque interfész egy kettős végű sor szerkezetet ír le, ennek az egyik implementációja az ArrayDeque kollekció.
A feladatokat most kétféle minősítéssel látjuk el, fontos az, amelynek a prioritása kisebb, mint 5 a többi nem fontos.
Fontos feladatok a sor elejére (head) addFirst() a nem fontosak a végére kerülnek addLast().
A feltöltés a fentivel azonos módon működhet.
Hibakezelés
Üres queue dobjon NoJobException kivételt.
 */
package collectionsqueue.collectionsdeque;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {

    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> jobDeque = new ArrayDeque<>();
        for (Job item : jobs) {
            if (item.isUrgent()) {
                jobDeque.addFirst(item);
            } else {
                jobDeque.addLast(item);
            }
        }
        return jobDeque;
    }
    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getLast();
    }
}