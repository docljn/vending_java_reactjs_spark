
import com.fasterxml.jackson.databind.ObjectMapper;


import static spark.Spark.*;

public class SparkController {



    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();
        machine.service();

        get("/hello", (req, res) -> "Hello World");


        get("/items", (req, res) -> {
            ObjectMapper mapper = new ObjectMapper();
            String items = mapper.writeValueAsString(machine.stockedItems());
            System.out.println(machine.stockedItems());
            res.status(200);
            return items;

        } );

        get("/coins", (req, res) -> {
            ObjectMapper mapper = new ObjectMapper();
            String coins = mapper.writeValueAsString(machine.acceptedCoins());
            res.status(200);
            return coins;

        } );


        post("/coins/return", (req, res) -> {
            machine.coinReturn();
            ObjectMapper mapper = new ObjectMapper();
            String credit = mapper.writeValueAsString(machine.getAvailableCredit());
            res.status(200);
            System.out.println("CREDIT" + credit);
            res.body("credit: " + credit);
            return credit;

        } );


        post("/coin/:value", (req, res) -> {
            String coinValue = req.params(":value");

            Integer value = Integer.valueOf(coinValue);
            machine.add(value);
            ObjectMapper mapper = new ObjectMapper();
            String availableCredit = mapper.writeValueAsString(machine.getAvailableCredit());
            res.body("credit: " + availableCredit);
            res.status(200);

            return availableCredit;

        } );




        post("/vend", (req, res) -> {
            machine.vend();
            ObjectMapper mapper = new ObjectMapper();
            String availableCredit = mapper.writeValueAsString(machine.getAvailableCredit());
            System.out.println("availableCredit "+availableCredit);
            res.status(200);
            return availableCredit;
        } );


        post("/item/:itemSelector", (req, res) -> {
//            TODO: why doesn't it work with Integer price = machine.select(selector);
            String selector = req.params(":itemSelector");
            Integer price = 0;
            if (selector.equals("A")){
                price = machine.select("A");
            }
            if (selector.equals("B")){
                price = machine.select("B");

            }
            if (selector.equals("C")){
                price = machine.select("C");

            }

            ObjectMapper mapper = new ObjectMapper();
            String priceString = mapper.writeValueAsString(price);
            System.out.println("PRICE "+priceString);

            System.out.println("selected"+machine.getSelectedItem());
            res.body("selectedItem: " + machine.getSelectedItem());
            res.status(200);

            return priceString;

        } );





        options("/*", (request,response)->{

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if(accessControlRequestMethod != null){
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request,response)->{
            response.header("Access-Control-Allow-Origin", "*");
        });


    }
}


//Jackson Library:
//ObjectMapper.writeValueAsString() is used to serialize Object to JSON string.
//ObjectMapper.readValue() is used to deserialize JSON string to Java Object.


//    CORS header 'Access-Control-Allow-Origin'