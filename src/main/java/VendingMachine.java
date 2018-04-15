import java.util.HashMap;
import java.util.stream.Collectors;

public class VendingMachine {

    private CoinContainer coinSlot, coinHopper, changeHopper;
    private DisplayCabinet displayCabinet;
    private StockItem selectedItem;

    public VendingMachine() {
        this.coinSlot = new CoinContainer();
        this.coinHopper = new CoinContainer();
        this.changeHopper = new CoinContainer();
        this.displayCabinet = new DisplayCabinet();
        this.selectedItem = null;
        //        TODO: may need to rethink this, or guard against null pointer exceptions

    }

    public void service() {
        this.changeHopper.resetFloat(100);
        this.displayCabinet.restock(10);
        coinReturn();
    }


    public Integer getAvailableCredit() {
        return this.coinSlot.getCashCount();
    }

    /*
    TODO: Unclear as to whether this method is needed or not
    public Integer getCashCount() {
    return this.coinHopper.getCashCount();
    }
    */

    public Integer getChangeCount() {
        return this.changeHopper.getCashCount();
    }



    public HashMap<StockItem,Integer> availableItems() {
        return this.displayCabinet.getAvailableItems();
    }

    public int getStockLevel(StockItem stockItem) {
        return this.displayCabinet.getItemCount(stockItem);
    }

    public void add(Coin coin) {
        this.coinSlot.add(coin);
    }

    public void coinReturn() {
//        I'm not modelling the purchaser, so the coins effectively vanish here
        this.coinSlot.transferAllCoins(new CoinContainer());
    }


    public void select(StockItem selectedItem) {
        this.selectedItem = null;
        if (this.displayCabinet.inStock(selectedItem)) {
            this.selectedItem = selectedItem;
        }
    }

    public StockItem getSelectedItem() {
        return this.selectedItem;
    }

    public Integer changeDueAmount() {
        return getAvailableCredit() - selectedItem.getPrice();
    }


//    public StockItem vend() {
//        StockItem toVend = getSelectedItem();
//        if (getAvailableCredit() >= toVend.getPrice()) {
//            this.selectedItem = null;
//            change = calculateChangeDueInCoins();
//            this.coinSlot.transferAllCoins(this.coinHopper);
//            this.changeHopper.remove(
//            return toVend;
//
//        }
////        TODO: this is going to cause problems!
//        else {
//
//        }
//        return toVend;
//    }
}
