import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    VendingMachine machine;

    @Before
    public void before(){
        machine = new VendingMachine();
    }


    @Test
    public void setupFillsChangeHopper(){
        machine.setup();
        assertEquals((Integer)14000, machine.getChangeCount());
    }


    @Test
    public void setupFillsDisplayCabinet(){
        machine.setup();
        assertEquals(3, machine.availableItems().size());
        assertEquals(10, machine.getStockLevel(StockItem.A));
    }

    @Test
    public void setupReturnsCoinsForEmptyCoinSlot(){
        machine.add(Coin.DIME);
        machine.setup();
        assertEquals((Integer)0, machine.getAvailableCredit());
    }

    @Test
    public void addingCoinsFillsCoinSlot(){
        machine.add(Coin.DOLLAR);
        assertEquals((Integer)100, machine.getAvailableCredit());
    }

    @Test
    public void coinReturnEmptiesCoinSlot(){
        machine.add(Coin.DOLLAR);
        machine.coinReturn();
        assertEquals((Integer)0, machine.getAvailableCredit());
    }

}
