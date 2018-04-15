import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DisplayCabinet {


    private HashMap<StockItem, Integer> availableItems;
    private StockItem[] stockItemTypes;


    public DisplayCabinet(){

        this.stockItemTypes = StockItem.class.getEnumConstants();
        this.availableItems = new HashMap<>();
    }


    public void add(StockItem stockItem) {
        if (inStock(stockItem)) {
            this.availableItems.put(stockItem, this.availableItems.get(stockItem)+1);
        } else {
            this.availableItems.put(stockItem, 1);
        }
    }

    public void add(StockItem stockItem, int numberToAdd) {
        for (int i = 0; i < numberToAdd; i++ ) {
            add(stockItem);
        }
    }

    public ArrayList<StockItem> getStockItemTypes() {
        return new ArrayList<>(Arrays.asList(this.stockItemTypes));
    }


    public boolean inStock(StockItem stockItem) {
        if (this.availableItems.containsKey(stockItem)) {
            return getItemCount(stockItem) > 0;
        } else {
            return false;
        }
    }


    public Integer getItemCount(StockItem stockItem) {
        if (this.availableItems.containsKey(stockItem)) {
            return this.availableItems.get(stockItem);
        } else {
            return 0;
        }
    }

    public Integer getItemCount() {
        Integer totalCount = 0;
        for (StockItem item: stockItemTypes) {
            totalCount += getItemCount(item);
        }
        return totalCount;
    }



    public void restock(Integer stockLevel) {

        for (StockItem stockItem: stockItemTypes) {
            this.availableItems.put(stockItem, stockLevel);
        }
    }


    public void remove(StockItem selectedItem) {
        if (inStock(selectedItem)) {
            this.availableItems.put(selectedItem, (this.availableItems.get(selectedItem) - 1));
        }
    }

    public StockItem select(String itemSelector) {
        for (StockItem item: getStockItemTypes()) {
            if (item.getSelector() == itemSelector){
                return item;
            }
        }
        return null;
//        TODO: may need to rethink this, or guard against null pointer exceptions
    }

    public HashMap<StockItem,Integer> getAvailableItems() {

        return this.availableItems;
    }
}
