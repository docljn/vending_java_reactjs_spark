import java.util.ArrayList;
import java.util.HashMap;

public class DisplayCabinet {


    private HashMap<StockItem,Integer> items;

    public DisplayCabinet(){
        this.items = new HashMap<>();
    }



    public int getItemCount(StockItem stockItem) {
        if (inStock(stockItem)) {
            return this.items.get(stockItem);
        } else {
            return 0;
        }
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

    private boolean inStock(StockItem stockItem) {
        return getStockedItems().contains(stockItem);
    }


}
