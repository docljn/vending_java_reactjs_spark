public enum StockItem {

    A (65),
    B (100),
    C (150);

    private final int price;   // in cents
    StockItem(int price) {
        this.price = price;
    }
    private int price() { return price; }

    public int getPrice() {
        return price();
    }
}
