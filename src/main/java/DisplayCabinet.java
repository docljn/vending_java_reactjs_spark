import java.util.ArrayList;
import java.util.HashMap;

public class DisplayCabinet {


    private HashMap<StockItem, Integer> items;

    public DisplayCabinet(){
        this.items = new HashMap<>();
    }






    public void add(StockItem stockItem) {
        if (inStock(stockItem)) {
            this.items.put(stockItem, this.items.get(stockItem)+1);
        } else {
            this.items.put(stockItem, 1);
        }
    }

    public void add(StockItem stockItem, int numberToAdd) {

        for (int i = 0; i < numberToAdd; i++ ) {
            add(stockItem);
        }
    }


    public ArrayList<StockItem> getStockedItems() {
        return new ArrayList<>(this.items.keySet());
    }

    public Integer getItemCount(StockItem stockItem) {
        if (sells(stockItem)) {
            return this.items.get(stockItem);
        } else {
            return 0;
        }
    }

    public void restock(Integer stockLevel) {

        for (StockItem stockItem: getStockedItems()) {
            this.items.put(stockItem, stockLevel);
        }
    }


    public void remove(StockItem selectedItem) {
        if (sells(selectedItem) && inStock(selectedItem)) {
            this.items.put(selectedItem, this.items.get(selectedItem) - 1);
        }
    }

    // PRIVATE METHODS
    private boolean sells(StockItem stockItem) {
       return getStockedItems().contains(stockItem);
    }

    private boolean inStock(StockItem stockItem) {
        return getItemCount(stockItem) > 0;
    }
}
