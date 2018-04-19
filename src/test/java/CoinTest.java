import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

        Coin coin;

        @Test
        public void testQuarterReturnsCentsValue() {
            assertEquals(25, coin.QUARTER.getValue());
        }

        @Test
        public void testNickelReturnsType(){
            assertEquals("nickel", Coin.NICKEL.getType());
        }
}
