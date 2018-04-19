// currently assuming the price will not change without a manual reprogram of the machine


public enum StockItem {

    A (65, "A"),
    B (100, "B"),
    C (150, "C");

    private final Integer price;   // in cents
    private final String selector;


    StockItem(int price, String selector) {
        this.price = price;
        this.selector = selector;
    }

    public Integer getPrice() {
        return this.price;
    }

    public String getSelector() {
        return this.selector;
    }
}


// reference: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html