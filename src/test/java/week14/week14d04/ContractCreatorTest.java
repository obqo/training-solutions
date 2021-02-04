package week14.week14d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContractCreatorTest {

    @Test
    void create() {
        List<Integer> monthlyPrices = new ArrayList<>(List.of(150, 350, 550, 750, 950, 250, 450, 650, 850, 200, 400, 600));
        ContractCreator cc = new ContractCreator("Tom", monthlyPrices);
        //System.out.println(cc.getContract());
        assertEquals("Tom", cc.getContract().getClient());
        assertEquals(12, cc.getContract().getMonthlyPrices().size());
        assertEquals(600, cc.getContract().getMonthlyPrices().get(11));
        Contract newcc1 = cc.create("Tamás");
        assertEquals("Tamás", newcc1.getClient());
        assertEquals(12, newcc1.getMonthlyPrices().size());
        assertEquals(600, newcc1.getMonthlyPrices().get(11));
        newcc1.getMonthlyPrices().set(11, 123);
        assertEquals(123, newcc1.getMonthlyPrices().get(11));
        Contract newcc2 = cc.create("Tommy");
        //System.out.println(newcc2);
        assertEquals("Tommy", newcc2.getClient());
        assertEquals(12, newcc2.getMonthlyPrices().size());
        assertEquals(600, newcc2.getMonthlyPrices().get(11));
    }
}
