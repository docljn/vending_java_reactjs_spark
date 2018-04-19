import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

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
            Gson gson = new Gson();
//            TypeToken<HashMap<StockItem, Integer>> stockItems = new TypeToken<HashMap<StockItem, Integer>>(){};
            for (StockItem item:machine.stockedItems()) {

            }

            String items = gson.toJson(machine.stockedItems());
            System.out.println("availableItems " + items);

            return items;
        } );
    }
}

