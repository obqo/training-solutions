package collectionslist.collectionsarraylist;

import java.util.*;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        Set<Integer> winningNumbersSet = new HashSet<>();
        Random random = new Random();
        while (winningNumbersSet.size() < lotteryType) {
            winningNumbersSet.add(random.nextInt(ballCount) + 1);
        }
        List<Integer> winningNumbersList = new ArrayList<>(winningNumbersSet);
        Collections.sort(winningNumbersList);
        return winningNumbersList;
    }
}
