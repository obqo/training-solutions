/*
Hozzunk létre egy Job osztályt, a következők szerint: Legyen 3 final attribútuma:

int priority // 1 - 10 skálán osztályozzuk a prioritást
String jobDescription
boolean urgent // minden olyan job esetén true, ahol a prioritás < 5
Legyen egy public Job(int priority, String jobDescription) konstruktora. Implementálja a Comparable interfészt,
a kisebb számértékű prioritás van előbb a sorban.
 */
package collectionsqueue.job;

public class Job implements Comparable<Job> {

    private final int priority;
    private final String jobDescription;
    private final boolean urgent;

    public Job(int priority, String jobDescription) {
        this.priority = priority;
        this.jobDescription = jobDescription;
        this.urgent = priority < 5;
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }

    @Override
    public int compareTo(Job o) {
        return this.priority - o.priority;
    }
}