import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StockItemTypeTest {

    StockItem stockItem;

    @Test
    public void testTypeHasCost() {
        assertEquals("A", stockItem.getType());
    }
}
