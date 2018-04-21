import java.util.HashMap;

public class CoinContainer {


    private HashMap<Coin, Integer> coins;
    private Coin[] acceptedCoinTypes;

    public CoinContainer() {

        this.acceptedCoinTypes = Coin.class.getEnumConstants();
        this.coins = new HashMap<>();

    }



    public Coin[] getAcceptedCoins() {
        return this.acceptedCoinTypes;
    }

    public Integer getCashCount() {
        Integer value = 0;
        for (Coin coin : acceptedCoinTypes
                ) {
            value += getCount(coin) * coin.getValue();
        }
        return value;
    }


    public HashMap<Coin,Integer> getCoinContents() {
        return this.coins;
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


    public void add(int coinValue) {
        for (Coin coin:getAcceptedCoins()
             ) {
            if (coin.getValue() == coinValue) {
                add(coin);
            }
        }
    }

    public Integer getCount(Coin coin) {
        Integer count = 0;
        if (this.coins.containsKey(coin)) {
            count =  this.coins.get(coin);
        }
        return count;
    }

    public boolean remove(Coin coin) {
        if (this.coins.containsKey(coin) && getCount(coin) > 0) {
            this.coins.put(coin, coins.get(coin) - 1);
            return true;
        }
        return false;
    }

    public boolean remove(Coin coin, int numberToRemove) {
        boolean success = false;
        for (int i = 0; i < numberToRemove; i++){
            success = remove(coin);
        }
        return success;
    }

    public boolean remove(HashMap<Coin,Integer> coinsToRemove) {
        boolean success = false;
        for (Coin coin: coinsToRemove.keySet()
             ) {
            success = remove(coin, coinsToRemove.get(coin));
        }
        return success;
    }


    public void resetFloat(int numberOfCoins) {
        for (Coin coin : acceptedCoinTypes) {
            this.coins.put(coin, numberOfCoins);
        }
    }


    public void transferAllCoins(CoinContainer alternateCoinContainer) {

        for (Coin coin: this.coins.keySet()) {
            alternateCoinContainer.add(coin, this.coins.get(coin));
        }

        this.coins = new HashMap<>();
    }



    public HashMap<Coin, Integer> coinEquivalent(Integer amount) {

        Integer runningTotal = amount;

        // set up the empty coin list
        HashMap<Coin, Integer> coinsRequired = new HashMap<>();
        for (int i = 0; i < getAcceptedCoins().length; i++) {
            coinsRequired.put(getAcceptedCoins()[i], 0);
        }

        // find largest available coin in available coins & loop...

        if (getCashCount() >= amount) {

            for (int index = getAcceptedCoins().length - 1; index >= 0; index--) {
                Coin currentLargestCoin = getAcceptedCoins()[index];

                while (runningTotal >= currentLargestCoin.getValue() && getCount(currentLargestCoin) > coinsRequired.get(currentLargestCoin)) {
                    runningTotal -= currentLargestCoin.getValue();
                    coinsRequired.put(currentLargestCoin, coinsRequired.get(currentLargestCoin) + 1);
                }
            }
            if (runningTotal != 0) {
                //something to say insufficient change available...;
            }
        }
        return coinsRequired;
    }


}


// For reference with BigDecimal
// https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html#multiply-java.math.BigDecimal-
