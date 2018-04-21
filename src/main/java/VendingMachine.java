import java.math.BigDecimal;
import java.util.HashMap;

public class VendingMachine {

    private CoinContainer coinSlot, coinHopper, changeHopper;
    private DisplayCabinet displayCabinet;
    private StockItem selectedItem;
    private String message;
    private String itemsToCollect;

    public VendingMachine() {
        this.coinSlot = new CoinContainer();
        this.coinHopper = new CoinContainer();
        this.changeHopper = new CoinContainer();
        this.displayCabinet = new DisplayCabinet();
        this.selectedItem = null;
        //        TODO: may need to rethink this, or guard against null pointer exceptions
        this.message = "";
        this.itemsToCollect = "";

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
//        I'm not modelling the purchaser, so the coins effectively vanish here and the machine resets
        this.coinSlot.transferAllCoins(new CoinContainer());
        this.selectedItem = null;
        this.message = "";
        this.itemsToCollect = "";
    }


    public void select(StockItem selectedItem) {
//        TODO: Consider how to handle out of stock situation: currently setting message
        if (this.displayCabinet.inStock(selectedItem)) {
            this.selectedItem = selectedItem;
            this.message = "Price is " +selectedItem.getPrice()+".";
        } else {
            this.message = "Out of Stock";
        }
    }


    public void select(String itemSelector) {
        for (StockItem item: stockedItems()) {
            if (item.getSelector().equals(itemSelector)){
                select(item);
            }
        }
    }

//      TODO: FOR CURRENCY FORMATTING:       this.message = (BigDecimal.valueOf(price)).divide(BigDecimal.valueOf(100)).toString();

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
                this.itemsToCollect = "Please collect " + itemToVend.getSelector() + ".";
                if (changeDueAmount > 0){
                    this.itemsToCollect += " Please collect change of " + changeDueAmount + ".";
                }
            } else {
                this.message = "Please insert coins.";
            }
        }
        return itemToVend;
    }

    public String getMessage() {

        return this.message;
    }


    public String getItemsToCollect() {
        return this.itemsToCollect;
    }

    public HashMap<String,String> getStatus() {
        HashMap<String, String> status = new HashMap<>();
        status.put("availableCredit", getAvailableCredit().toString());
        // guard against null pointer exception for getSelectedItem();
        String item = "";
        if (getSelectedItem() != null) {
            item = getSelectedItem().getSelector();
        }
        status.put("selectedItem", item);
        // end of guard
        status.put("message", getMessage());
        status.put("itemsToCollect", getItemsToCollect());
        return status;
    }
}
