import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class CoinHopper {


    private HashMap<Coin, Integer> coins;
    private ArrayList<Coin> coinTypes;

    public CoinHopper() {

//            TODO: Consider how to include all types of accepted coins at the start?
        this.coins = new HashMap<>();

    }

    public Integer getCashCount() {

        Integer value = 0;
//        can't do this in the constructor as it wouldn't update
        coinTypes = new ArrayList<>(this.coins.keySet());

        for (Coin coin : coinTypes
             ) {
            value += getCount(coin) * coin.getValue();
        }
        return value;
    }

    public void addCoin(Coin coin) {
        if (this.coins.containsKey(coin)) {
            this.coins.put(coin, coins.get(coin) + 1);
        } else {
            this.coins.put(coin, 1);
        }
    }

    public void addCoin(Coin coin, int numberToAdd) {
        for (int i = 0; i < numberToAdd; i++){
            addCoin(coin);
        }
    }

    public Integer getCount(Coin coin) {
        return this.coins.get(coin);
    }

    public void remove(Coin coin) {
        if (this.coins.containsKey(coin) && getCount(coin) > 0) {
            this.coins.put(coin, coins.get(coin) - 1);
        }
    }


}
