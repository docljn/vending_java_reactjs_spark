import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockItemTest {

    StockItem stockItem;

    @Test
    public void testItemReturnsPrice() {
        assertEquals(Integer.valueOf(65), stockItem.A.getPrice());
    }

    @Test
    public void testItemReturnsName() { assertEquals("B", stockItem.B.getName()); }
}
