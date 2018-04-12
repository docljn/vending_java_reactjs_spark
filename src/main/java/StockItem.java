// currently assuming the price will not change without a manual reprogram of the machine

public enum StockItem {

    A (65, "A"),
    B (100, "B"),
    C (150, "C");

    private final int price;   // in cents
    private final String name;


    StockItem(int price, String name) {
        this.price = price;
        this.name = name;
    }
    private int price() { return price; }

    public int getPrice() {
        return price();
    }

    public String getName() {
        return name;
    }
}


// reference: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html