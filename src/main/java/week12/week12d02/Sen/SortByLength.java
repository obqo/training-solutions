package week12.week12d02.Sen;

import java.util.Comparator;

public class SortByLength implements Comparator<Land> {

    public int compare(Land a, Land b) {
        return a.getLength() - b.getLength();
    }
}
