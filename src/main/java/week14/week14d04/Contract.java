package week14.week14d04;

import java.util.ArrayList;
import java.util.List;

public class Contract {

    private final String client;
    private final List<Integer> monthlyPrices;

    public Contract(String client, List<Integer> monthlyPrices) {
        this.client = client;
        this.monthlyPrices = monthlyPrices;
    }

    public Contract(Contract c) {
        client = c.client;
        monthlyPrices = new ArrayList<>(c.monthlyPrices);
    }

    public String getClient() {
        return client;
    }

    public List<Integer> getMonthlyPrices() {
        return monthlyPrices;
    }

    @Override
    public String toString() {
        return client + " " + monthlyPrices;
    }
}
