import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DisplayCabinetTest {

    DisplayCabinet displayCabinet, displayCabinetWithStock;

    @Before
    public void before(){
        displayCabinet = new DisplayCabinet();

        displayCabinetWithStock = new DisplayCabinet();
        displayCabinetWithStock.add(StockItem.A, 1);
        displayCabinetWithStock.add(StockItem.B, 1);
        displayCabinetWithStock.add(StockItem.C, 1);
    }



    @Test
    public void startsEmpty(){
        assertEquals(0, displayCabinet.getItemCount(StockItem.A));
    }

    @Test
    public void canAcceptSingleStockItem(){
        displayCabinet.add(StockItem.A);
        assertEquals(1, displayCabinet.getItemCount(StockItem.A));
    }

    @Test
    public void canAcceptMultipleStockItems(){
        displayCabinet.add(StockItem.A, 10);
        assertEquals(10, displayCabinet.getItemCount(StockItem.A));
    }

    @Test
    public void canReturnItemsStocked(){
        ArrayList<StockItem> stockedItems = displayCabinetWithStock.getStockedItems();
        assertEquals(StockItem.A, stockedItems.get(0));
        assertEquals(3, stockedItems.size());
    }

    @Ignore
    @Test
    public void canBeRestocked(){
        displayCabinetWithStock.restock(10);

        assertEquals(10, displayCabinet.getItemCount(StockItem.A));
    }

    @Ignore
    @Test
    public void canVendItem(){
//        displayCabinet
    }


//        assertEquals(1, displayCabinet.getStockCount(StockItem.A));
}
