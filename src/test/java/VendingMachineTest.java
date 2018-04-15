import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    VendingMachine machine;

    @Before
    public void before(){
        machine = new VendingMachine();
    }


    @Test
    public void serviceFillsChangeHopper(){
        machine.service();
        assertEquals((Integer)14000, machine.getChangeCount());
    }


    @Test
    public void serviceFillsDisplayCabinet(){
        machine.service();
        assertEquals(3, machine.availableItems().size());
        assertEquals(10, machine.getStockLevel(StockItem.A));
    }

    @Test
    public void serviceReturnsCoinsForEmptyCoinSlot(){
        machine.add(Coin.DIME);
        machine.service();
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

    @Test
    public void selectSetsStockItemToSelected(){
        machine.service();
        machine.select(StockItem.A);
        assertEquals(StockItem.A, machine.getSelectedItem());
    }

    @Test
    public void selectSetsSelectedToNullIfNotInStock(){
        machine.select(StockItem.A);
        assertEquals(null, machine.getSelectedItem());
    }


    @Test
    public void selectReturnsChangeWarningIfInsufficientChange(){

    }


    @Test
    public void selectReturnsItemPriceAndInsertCoinsRequestIfInsufficientFunds(){

    }



}
