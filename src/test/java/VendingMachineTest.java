import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class VendingMachineTest {

    VendingMachine machine, machineWithoutStock;

    @Before
    public void before(){
        machine = new VendingMachine();
        machine.service();

        machineWithoutStock = new VendingMachine();
    }


    @Test
    public void serviceFillsChangeHopperWith100OfEachCoin(){
        assertEquals((Integer)14000, machine.getChangeCount());
    }

    @Test
    public void machineAcceptsStatedCoins(){
        System.out.println(machine.acceptedCoins());
        assertEquals(4, machine.acceptedCoins().length);
    }

    @Test
    public void machineStocksStatedItems(){
        assertEquals(3, machine.stockedItems().length);
    }


    @Test
    public void serviceFillsDisplayCabinetWithTenOfEachOfThreeItems(){
        assertEquals(3, machine.availableItems().size());
        assertEquals(10, machine.getStockLevel(StockItem.A));
    }


    @Test
    public void serviceReturnsCoinsInOrderToEmptyCoinSlot(){
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
        machine.select(StockItem.A);
        assertEquals(StockItem.A, machine.getSelectedItem());
    }


    @Test
    public void selectSetsSelectedToNullIfNotInStock(){
        machineWithoutStock.select(StockItem.A);
        assertEquals(null, machine.getSelectedItem());
    }


    @Test
    public void selectReturnsItemPrice(){
        assertEquals((Integer)65, machine.select(StockItem.A));
    }


    @Test
    public void selectReturnsZeroIfItemNotInStock(){
        assertEquals((Integer)0, machineWithoutStock.select(StockItem.A));
    }


    @Test
    public void selectDisplaysOutOfStockMessage(){
        machineWithoutStock.select(StockItem.B);
        assertEquals("Out of Stock", machineWithoutStock.getMessage());
    }


    @Test
    public void selectDisplaysPriceIfInStock(){
        machine.select(StockItem.A);
        assertEquals("0.65", machine.getMessage());
    }


    @Test
    public void coinReturnResetsSelectedToNull(){
        machine.add(Coin.DOLLAR);
        machine.select(StockItem.A);
        machine.coinReturn();
        assertEquals(null, machine.getSelectedItem());
    }


    @Test
    public void vendTransfersCoinsFromSlotToHopper(){
        machine.add(Coin.DOLLAR);
        machine.select(StockItem.B);
        machine.vend();
        assertEquals((Integer)100, machine.getCashCount());
    }


    @Test
    public void vendDecreasesSelectedItemCount(){
        machine.add(Coin.DOLLAR);
        machine.select(StockItem.B);
        machine.vend();
        assertEquals(9, machine.getStockLevel(StockItem.B));
    }


    @Test
    public void vendResetsSelectedItemToNull(){
        machine.add(Coin.DOLLAR);
        machine.select(StockItem.B);
        machine.vend();
        assertNull(machine.getSelectedItem());
    }


    @Test
    public void vendDispensesCorrectChangeIfAvailable(){
        machineWithoutStock.testService();
        machineWithoutStock.add(Coin.DOLLAR);
        machineWithoutStock.add(Coin.DOLLAR);

        machineWithoutStock.select(StockItem.B);
        machineWithoutStock.vend();
        assertEquals((Integer)40, machineWithoutStock.getChangeCount());
    }


    @Test
    public void vendDispensesAvailableChangeOnlyIfInsufficientChange(){
        machineWithoutStock.testService();
        machineWithoutStock.add(Coin.DOLLAR);
        machineWithoutStock.add(Coin.NICKEL);
        machineWithoutStock.add(Coin.NICKEL);
        machineWithoutStock.add(Coin.DIME);
        machineWithoutStock.select(StockItem.B);
        machineWithoutStock.vend();
        assertEquals((Integer)125, machineWithoutStock.getChangeCount());
        // short changing is a feature of real life machines too
    }


    @Test
    public void vendLeavesCoinInSlotIfSelectedItemIsNull(){
        machine.add(Coin.DOLLAR);
        machine.vend();
        assertEquals((Integer)100, machine.getAvailableCredit());

    }


    @Test
    public void vendLeavesCoinsInSlotIfInsufficientFunds(){
        machine.select(StockItem.C);
        machine.add(Coin.DOLLAR);
        machine.vend();
        assertEquals((Integer)100, machine.getAvailableCredit());
    }


    @Test
    public void vendLeavesItemSelectedIfInsufficientFunds(){
        machine.select(StockItem.C);
        machine.add(Coin.DOLLAR);
        machine.vend();
        assertEquals(StockItem.C, machine.getSelectedItem());
    }


    @Test
    public void vendCausesInsertCoinsRequestIfInsufficientFunds(){
        machine.add(Coin.DOLLAR);
        machine.select(StockItem.C);
        machine.vend();
        assertEquals("Please insert coins", machine.getMessage());
    }


    @Test
    public void vendResetsMessageIfSuccessful(){
        machine.select(StockItem.B);
        machine.add(Coin.DOLLAR);
        machine.vend();
        assertEquals("", machine.getMessage());
    }

    @Test
    public void vendReturnsSelectedItem(){
        machine.select(StockItem.B);
        machine.add(Coin.DOLLAR);
        assertEquals(StockItem.B, machine.vend());
    }


    @Ignore("Need to clarify if warning on minimum coin count, or something else")
    @Test
    public void machineWillDisplayChangeWarningIfAnyCoinCountBelowFiveAfterVend(){

    }

    @Ignore("How to model coins being returned from the machine on coin return or change?")
    @Test
    public void machineCanReturnCoinsToUser(){
        // machine returns selected item, so how can I "return" change/coins too?
    }

    @Ignore("Spec suggests dollars are not returned from the machine")
    @Test
    public void machineDoesNotReturnDollars(){
        // query this
    }



}
