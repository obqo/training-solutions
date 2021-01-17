package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {

    private List<Integer> createNumberPool(int maxNumber) {
        List<Integer> pool = new LinkedList<>();
        for (int i = 1; i <= maxNumber; i++) {
            pool.add(i);
        }
        Collections.shuffle(pool);
        return pool;
    }

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
        }
        Queue<Integer> numberPool = new LinkedList<>(createNumberPool(maxNumber));
        Queue<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < drawCount; i++) {
            numbers.add(numberPool.poll());
        }
        return new TreeSet<>(numbers);
    }
}
