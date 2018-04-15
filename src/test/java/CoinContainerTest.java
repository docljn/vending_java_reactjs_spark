import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CoinContainerTest {

    CoinContainer hopper, hopperWithFloat;

    @Before
    public void before(){
        hopper = new CoinContainer();

        hopperWithFloat = new CoinContainer();
        hopperWithFloat.add(Coin.NICKEL);
        hopperWithFloat.add(Coin.DIME);
        hopperWithFloat.add(Coin.QUARTER);
        hopperWithFloat.add(Coin.DOLLAR);
    }

    @Test
    public void startsEmpty(){
        assertEquals(Integer.valueOf(0), hopper.getCashCount());
    }


    @Test
    public void canReturnAcceptedCoinList(){
        Coin[] expected = Coin.class.getEnumConstants();
        assertEquals(expected, hopper.getAcceptedCoins());
    }

    @Test
    public void canAddCoins(){
        hopper.add(Coin.DIME);
        assertEquals((Integer)1, hopper.getCount(Coin.DIME));
    }

    @Test
    public void canAddMultipleCoins(){
        hopper.add(Coin.NICKEL, 10);
        assertEquals((Integer)10, hopper.getCount(Coin.NICKEL));
    }

    @Test
    public void canCalculateTotalCashCount(){
        assertEquals((Integer)140, hopperWithFloat.getCashCount());
    }

    @Test
    public void canReturnCoinContents() {
        HashMap<Coin, Integer> expected = new HashMap<>();
        expected.put(Coin.NICKEL, 1);
        expected.put(Coin.DIME, 1);
        expected.put(Coin.QUARTER, 1);
        expected.put(Coin.DOLLAR, 1);
        assertEquals(expected, hopperWithFloat.getCoinContents());
    }

    @Test
    public void canRemoveCoin(){
        hopperWithFloat.remove(Coin.DOLLAR);
        assertEquals((Integer)40, hopperWithFloat.getCashCount());
    }

    @Test
    public void canRemoveMultipleCoins(){
        hopper.add(Coin.DOLLAR, 3);
        hopper.remove(Coin.DOLLAR, 2);
        assertEquals((Integer)100, hopper.getCashCount());
    }

    @Test
    public void cannotRemoveCoinNotPresent(){
        hopperWithFloat.remove(Coin.DOLLAR);
        hopperWithFloat.remove(Coin.DOLLAR);
        assertEquals((Integer)40, hopperWithFloat.getCashCount());
    }

    @Test
    public void removingCoinSuccessfullyReturnsTrue(){
        assertTrue(hopperWithFloat.remove(Coin.DOLLAR));
    }

    @Test
    public void cannotRemoveMultipleCoinsIfNotPresent(){
        hopper.add(Coin.DOLLAR, 2);
        hopper.remove(Coin.DOLLAR, 3);
        assertEquals((Integer)0, hopper.getCashCount());
    }

    @Ignore("Error handling needs to be worked on")
    @Test
    public void shouldRaiseErrorIfAttemptToRemoveMoreCoinsThanPresent(){
//        NO IDEA HOW TO DO THIS!
        assertTrue(false);
    }

    @Test
    public void resetFloatSetsFloatToSpecifiedLevels(){
        hopper.resetFloat(1);
        assertEquals((Integer)140, hopper.getCashCount());
    }

    @Test
    public void transferAddsAllCoinsToAlternativeContainer(){
        hopperWithFloat.transferAllCoins(hopper);
        assertEquals((Integer)140, hopper.getCashCount());
    }

    @Test
    public void transferRemovesAllCoinsFromContainer(){
        hopperWithFloat.transferAllCoins(hopper);
        assertEquals((Integer)0, hopperWithFloat.getCashCount());
    }

    @Test
    public void canReturnCoinListEquivalentToStatedAmount(){
        HashMap<Coin, Integer> expected = new HashMap<>();
        expected.put(Coin.DOLLAR, 1);
        expected.put(Coin.QUARTER, 1);
        expected.put(Coin.DIME, 0);
        expected.put(Coin.NICKEL, 0);
        assertEquals(expected, hopperWithFloat.coinEquivalent(125));
    }

    @Test
    public void canReturnCoinListEquivalentIfCoinsMissing(){
        HashMap<Coin, Integer> expected = new HashMap<>();
        expected.put(Coin.DOLLAR, 0);
        expected.put(Coin.QUARTER, 0);
        expected.put(Coin.DIME, 2);
        expected.put(Coin.NICKEL, 1);

        hopper.add(Coin.DIME);
        hopper.add(Coin.DIME);
        hopper.add(Coin.DIME);
        hopper.add(Coin.NICKEL);
        hopper.add(Coin.NICKEL);
        hopper.add(Coin.NICKEL);
        assertEquals(expected, hopper.coinEquivalent(25));
    }

    @Test
    public void canReturnCoinListEquivalentIfRunOutOfCoins(){
        hopperWithFloat.add(Coin.DIME);

        HashMap<Coin, Integer> expected = new HashMap<>();
        expected.put(Coin.DOLLAR, 1);
        expected.put(Coin.QUARTER, 1);
        expected.put(Coin.DIME, 2);
        expected.put(Coin.NICKEL, 1);

        assertEquals(expected, hopperWithFloat.coinEquivalent(150));

    }
}
