import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StockItemTest {

    StockItem stockItem;

    @Test
    public void testItemReturnsPrice() {
        assertEquals(65, stockItem.A.getPrice());
    }
}
