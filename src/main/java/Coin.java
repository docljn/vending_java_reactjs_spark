import com.fasterxml.jackson.annotation.JsonFormat;

// Coins must be declared in ascending order for this to work: largest coin is last in list....
// Jackson library used for json here as Gson does not offer easy enum serialization
@JsonFormat(shape = JsonFormat.Shape.OBJECT)

public enum Coin {
    NICKEL (5, "nickel"),
    DIME (10, "dime"),
    QUARTER (25, "quarter"),
    DOLLAR (100, "dollar");

    private final int value;
    private final String type;

    Coin(int value, String type) {
        this.value = value;
        this.type = type;
    }



    public int getValue() {
        return value;
    }


    public String getType() {
        return type;
    }
}

// reference: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
