
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

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

//        post("/coin/return", (req, res) -> {
//            machine.coinReturn();
//            ObjectMapper mapper = new ObjectMapper();
//            String credit = mapper.writeValueAsString(machine.getAvailableCredit());
//            res.status(200);
//            res.body("credit: " + credit);
//            return credit;
//
//        } );


        post("/coin/:value", (req, res) -> {
            Map params = req.params();

            Object coinValue = params.get(":value");
            Integer value = (Integer)coinValue;
            machine.add(100);
            ObjectMapper mapper = new ObjectMapper();
            String availableCredit = mapper.writeValueAsString(machine.getAvailableCredit());
            res.body("credit: " + availableCredit);
            res.status(200);

            return availableCredit;

        } );




        post("/vend", (req, res) -> {
            ObjectMapper mapper = new ObjectMapper();
            String availableCredit = mapper.writeValueAsString(machine.getAvailableCredit());
            res.status(200);
            return availableCredit;

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