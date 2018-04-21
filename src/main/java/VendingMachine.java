import java.math.BigDecimal;
import java.util.HashMap;

public class VendingMachine {

    private CoinContainer coinSlot, coinHopper, changeHopper;
    private DisplayCabinet displayCabinet;
    private StockItem selectedItem;
    private String message;

    public VendingMachine() {
        this.coinSlot = new CoinContainer();
        this.coinHopper = new CoinContainer();
        this.changeHopper = new CoinContainer();
        this.displayCabinet = new DisplayCabinet();
        this.selectedItem = null;
        this.message = "";
        //        TODO: may need to rethink this, or guard against null pointer exceptions

    }

    public void service() {
        this.changeHopper.resetFloat(100);
        this.displayCabinet.restock(10);
        coinReturn();
    }

    public void testService() {
        this.changeHopper.resetFloat(1);
        this.displayCabinet.restock(1);
        coinReturn();
    }

    public Coin[] acceptedCoins() {
        return this.coinSlot.getAcceptedCoins();
    }

    public Integer getAvailableCredit() {
        return this.coinSlot.getCashCount();
    }

    public Integer getCashCount() {
        return this.coinHopper.getCashCount();
    }

    public Integer getChangeCount() {
        return this.changeHopper.getCashCount();
    }

    public StockItem[] stockedItems() {
        return this.displayCabinet.getStockItemTypes();
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


    public void add(int coinValue) {
        this.coinSlot.add(coinValue);
    }

    public void coinReturn() {
//        I'm not modelling the purchaser, so the coins effectively vanish here
        this.coinSlot.transferAllCoins(new CoinContainer());
        this.selectedItem = null;
    }


    public void select(StockItem selectedItem) {
//        TODO: Consider how to handle out of stock situation: currently setting message
        if (this.displayCabinet.inStock(selectedItem)) {
            this.selectedItem = selectedItem;
            this.message = (BigDecimal.valueOf(selectedItem.getPrice())).divide(BigDecimal.valueOf(100)).toString();
        } else {
            this.message = "Out of Stock";
        }
    }


    public void select(String itemSelector) {
        for (StockItem item: stockedItems()) {
            if (item.getSelector() == itemSelector){
                select(item);
            }
        }
    }

//             this.message = (BigDecimal.valueOf(price)).divide(BigDecimal.valueOf(100)).toString();

    public StockItem getSelectedItem() {
        return this.selectedItem;
    }


    public StockItem vend() {
        StockItem itemToVend = getSelectedItem();
        if (itemToVend != null) {
            Integer changeDueAmount = getAvailableCredit() - itemToVend.getPrice();
            if (changeDueAmount >= 0) {
                HashMap<Coin, Integer> coinChange = this.changeHopper.coinEquivalent(changeDueAmount);

                this.coinSlot.transferAllCoins(coinHopper);
                this.displayCabinet.remove(itemToVend);  // you can't select something that isn't in stock
                this.selectedItem = null;
                this.changeHopper.remove(coinChange); // returns false if insufficient change
                this.message = "";
            } else {
                this.message = "Please insert coins";
            }
        }
        return itemToVend;
    }

    public String getMessage() {

        return this.message;
    }


}
