package week03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    public void TestCreate() {

        Operation operation = new Operation("123+56");
        assertEquals(179, operation.getResult());
    }
}
