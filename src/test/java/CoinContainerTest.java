import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinContainerTest {

    CoinContainer hopper, hopperWithFloat;

    @Before
    public void before(){
        hopper = new CoinContainer();

        hopperWithFloat = new CoinContainer();
        hopperWithFloat.addCoin(Coin.NICKEL);
        hopperWithFloat.addCoin(Coin.DIME);
        hopperWithFloat.addCoin(Coin.QUARTER);
        hopperWithFloat.addCoin(Coin.DOLLAR);
    }

    @Test
    public void startsEmpty(){
        assertEquals(Integer.valueOf(0), hopper.getCashCount());
    }

    @Test
    public void canAddCoins(){
        hopper.addCoin(Coin.DIME);
        assertEquals((Integer)1, hopper.getCount(Coin.DIME));
    }

    @Test
    public void canAddMultipleCoins(){
        hopper.addCoin(Coin.NICKEL, 10);
        assertEquals((Integer)10, hopper.getCount(Coin.NICKEL));
    }

    @Test
    public void canCalculateTotalCashCount(){
        assertEquals((Integer)140, hopperWithFloat.getCashCount());
    }

    @Test
    public void canRemoveCoins(){
        hopperWithFloat.remove(Coin.DOLLAR);
        assertEquals((Integer)40, hopperWithFloat.getCashCount());
    }

    @Test
    public void cannotRemoveCoinNotPresent(){
        hopperWithFloat.remove(Coin.DOLLAR);
        hopperWithFloat.remove(Coin.DOLLAR);
        assertEquals((Integer)40, hopperWithFloat.getCashCount());
    }

    @Test
    public void resetFloatSetsFloatToSpecifiedLevels(){
        hopper.resetFloat(1);
        assertEquals((Integer)140, hopper.getCashCount());
    }
}