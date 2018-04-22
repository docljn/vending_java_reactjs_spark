import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyDisplayTest {

    Coin coin;
    @Test
    public void CurrencyDisplayFormatDollarsReturnsDecimalFormatString() {
        assertEquals("$0.25", CurrencyDisplay.formatDollars(coin.QUARTER.getValue()));
    }

    @Test
    public void test100returnsOneDollar(){
        assertEquals("$1.00", CurrencyDisplay.formatDollars(100));
    }


}
