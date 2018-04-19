import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DisplayCabinetTest {

    DisplayCabinet displayCabinet, displayCabinetWithStock;

    @Before
    public void before(){
        displayCabinet = new DisplayCabinet();

        displayCabinetWithStock = new DisplayCabinet();
        displayCabinetWithStock.add(StockItem.A);
        displayCabinetWithStock.add(StockItem.B);
        displayCabinetWithStock.add(StockItem.C);
    }



    @Test
    public void startsEmpty(){
        assertEquals(Integer.valueOf(0), displayCabinet.getItemCount());
    }

    @Test
    public void canAcceptSingleStockItem(){
        displayCabinet.add(StockItem.A);
        assertEquals(Integer.valueOf(1), displayCabinet.getItemCount(StockItem.A));
    }

    @Test
    public void canAcceptMultipleStockItems(){
        displayCabinet.add(StockItem.A, 10);
        assertEquals(Integer.valueOf(10), displayCabinet.getItemCount(StockItem.A));
    }

//    TODO: Check if this method is needed for functionality
    @Test
    public void canReturnItemsStocked(){
        StockItem[] stockedItems = displayCabinet.getStockItemTypes();
        assertEquals(3, stockedItems.length);
    }

    @Test
    public void canBeRestocked(){
        displayCabinetWithStock.restock(10);

        assertEquals(Integer.valueOf(10), displayCabinetWithStock.getItemCount(StockItem.A));
        assertEquals(Integer.valueOf(10), displayCabinetWithStock.getItemCount(StockItem.B));
        assertEquals(Integer.valueOf(10), displayCabinetWithStock.getItemCount(StockItem.C));

    }

    @Test
    public void canRemoveItem(){
        displayCabinetWithStock.remove(StockItem.A);
        assertEquals(Integer.valueOf(0), displayCabinetWithStock.getItemCount(StockItem.A));
    }

    @Test
    public void cannotRemoveItemNotForSale(){
        displayCabinet.remove(StockItem.A);
        assertEquals(Integer.valueOf(0), displayCabinet.getItemCount(StockItem.A));
    }


    @Test
    public void cannotRemoveOutOfStockItem(){
        displayCabinetWithStock.remove(StockItem.A);
        displayCabinetWithStock.remove(StockItem.A);
        assertEquals(Integer.valueOf(0), displayCabinetWithStock.getItemCount(StockItem.A));
    }


//    TODO: may not need this method?
    @Test
    public void canSelectItemBySelector(){
        assertEquals(StockItem.B, displayCabinetWithStock.select("B"));
    }

    @Test
    public void canReturnContents(){
        HashMap<StockItem, Integer> expected = new HashMap<>();
        expected.put(StockItem.A, 1);
        displayCabinet.add(StockItem.A);
        assertEquals(expected, displayCabinet.getAvailableItems());
    }

    @Test
    public void canDetermineIfItemInStock() {
        displayCabinet.add(StockItem.A);
        assertTrue(displayCabinet.inStock(StockItem.A));
        assertFalse(displayCabinet.inStock(StockItem.C));
    }


}
