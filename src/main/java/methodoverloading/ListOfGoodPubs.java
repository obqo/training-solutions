package methodoverloading;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {

    List<Pub> goodPubs = new ArrayList<>();

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.isEmpty()) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }
    public Pub findTheBest() {
        Pub bestPub = goodPubs.get(0);
        for (Pub pub : goodPubs) {
            if (pub.getOpenFrom().isEarlier(bestPub.getOpenFrom())) {
                bestPub = pub;
            }
        }
        return bestPub;
    }
}
