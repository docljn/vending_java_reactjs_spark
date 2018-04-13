import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private CoinContainer coinSlot, coinHopper, changeHopper;
    private DisplayCabinet displayCabinet;

    public VendingMachine() {
        this.coinSlot = new CoinContainer();
        this.coinHopper = new CoinContainer();
        this.changeHopper = new CoinContainer();
        this.displayCabinet = new DisplayCabinet();
    }


    public Integer getAvailableCredit() {
        return this.coinSlot.getCashCount();
    }

    public Integer getCashCount() {
        return this.coinHopper.getCashCount();
    }

//    not sure if I need this, or just for testing purposes?
    public Integer getChangeCount() {
        return this.changeHopper.getCashCount();
    }


    public ArrayList<StockItem> getStockedItems() {
        return this.displayCabinet.getStockItemTypes();
    }

    public void setup() {
        this.changeHopper.resetFloat(100);
    }


//    TODO:
    public HashMap<StockItem,Integer> availableItems() {

        return null;
    }
}
