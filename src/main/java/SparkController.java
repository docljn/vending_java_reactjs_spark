
import com.fasterxml.jackson.databind.ObjectMapper;

import static spark.Spark.*;

public class SparkController {

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();
        machine.service();

        get("/hello", (req, res) -> "Hello World");

        get("/test", (req, res) -> {
            return machine.getAvailableCredit();
        } );

        get("/items", (req, res) -> {
            ObjectMapper mapper = new ObjectMapper();

            String items = mapper.writeValueAsString(machine.stockedItems());

            return items;
        } );

        get("/coins", (req, res) -> {
            ObjectMapper mapper = new ObjectMapper();

            String coins = mapper.writeValueAsString(machine.acceptedCoins());

            return coins;
        } );
    }
}
