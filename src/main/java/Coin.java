import java.util.ArrayList;

public enum Coin {
    NICKEL (5),
    DIME (10),
    QUARTER (25),
    DOLLAR (100);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    private int value() { return value; }


    public int getValue() {
        return value();
    }



}

// reference: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
