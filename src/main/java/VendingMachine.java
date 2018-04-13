import java.util.HashMap;

public class VendingMachine {

    private CoinContainer coinSlot, coinHopper, changeHopper;
    private DisplayCabinet displayCabinet;

    public VendingMachine() {
        this.coinSlot = new CoinContainer();
        this.coinHopper = new CoinContainer();
        this.changeHopper = new CoinContainer();
        this.displayCabinet = new DisplayCabinet();
    }

    public void setup() {
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
        this.coinSlot.transferCoins(new CoinContainer());
    }
}
