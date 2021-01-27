/*
A feladatokat (job) tetszés szerinti sorrendben felvisszük egy PriorityQueue típusú kollekcióba, és azt várjuk, hogy mindig a
soron következő legfontosabb feladatot adja ki. Írj egy JobDispatcher osztályt, amely tárolja és rendezi a Job típusú objektumokat.
A kollekció feltöltését a (Queue<Job> addJob(Job... jobs)) metódus végzi, amely egy (PriorityQueue<Job>) értéket ad vissza.
A soron következő feladatot a (Job dispatchNextJob(Queue<Job> jobs) throws NoJobException) metódus adja ki a queue-ból.
Hibakezelés
Üres queue dobjon NoJobException kivételt.
 */
package collectionsqueue.collectionspriorityqueue;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    public Queue<Job> addJob(Job... jobs) {
        return new PriorityQueue<>(Arrays.asList(jobs));
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.poll();
    }
}