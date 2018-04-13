import java.util.HashMap;

public class CoinContainer {


    private HashMap<Coin, Integer> coins;
    private Coin[] acceptedCoinTypes;

    public CoinContainer() {

        this.acceptedCoinTypes = Coin.class.getEnumConstants();
        this.coins = new HashMap<>();
        //        TODO: Should the coins be filled with value = 0 for all possible keys at this stage?


    }

    public Integer getCashCount() {
        Integer value = 0;
        for (Coin coin : acceptedCoinTypes
             ) {
            value += getCount(coin) * coin.getValue();
        }
        return value;
    }

    public void add(Coin coin) {
        if (this.coins.containsKey(coin)) {
            this.coins.put(coin, coins.get(coin) + 1);
        } else {
            this.coins.put(coin, 1);
        }
    }

    public void add(Coin coin, int numberToAdd) {
        for (int i = 0; i < numberToAdd; i++){
            add(coin);
        }
    }

    public Integer getCount(Coin coin) {
        Integer count = 0;
        if (this.coins.containsKey(coin)) {
            count =  this.coins.get(coin);
        }
        return count;
    }

    public void remove(Coin coin) {
        if (this.coins.containsKey(coin) && getCount(coin) > 0) {
            this.coins.put(coin, coins.get(coin) - 1);
        }
    }

    public void remove(Coin coin, int numberToRemove) {
        for (int i = 0; i < numberToRemove; i++){
            remove(coin);
        }
    }


    public void resetFloat(int numberOfCoins) {
        for (Coin coin : acceptedCoinTypes) {
            this.coins.put(coin, numberOfCoins);
        }
    }


    public void transferCoins(CoinContainer alternateCoinContainer) {

        for (Coin coin: this.coins.keySet()) {
            alternateCoinContainer.add(coin, this.coins.get(coin));
        }

        this.coins = new HashMap<>();
    }


}


// For reference with BigDecimal
// https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html#multiply-java.math.BigDecimal-
