
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import static spark.Spark.*;

public class SparkController {



    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();
        machine.service();
        Gson gson = new Gson();

        get("/hello", (req, res) -> "Hello World");


        get("/items", (req, res) -> {
            ObjectMapper mapper = new ObjectMapper();
            String items = mapper.writeValueAsString(machine.stockedItems());
            System.out.println(items);
            String gsonItems = gson.toJson(machine.stockedItems());
            System.out.println("GSON"+gsonItems);
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
            String machineStatus = gson.toJson(machine.getStatus());
            res.status(200);
            System.out.println("STATUS" + machineStatus);
            return machineStatus;
        } );


        post("/coin/:coinType", (req, res) -> {
            String coinType = req.params("coinType");
            machine.add(coinType);
            String machineStatus = gson.toJson(machine.getStatus());
            return machineStatus;
        } );


        post("/item/:itemSelector", (req, res) -> {
            String itemSelector = req.params("itemSelector");

            machine.select(itemSelector);
            String machineStatus = gson.toJson(machine.getStatus());
            res.status(200);
            return machineStatus;

        } );


        post("/vend", (req, res) -> {
            machine.vend();
            String machineStatus = gson.toJson(machine.getStatus());
            res.status(200);
            return machineStatus;
        } );

        post("/service", (req, res) -> {
            machine.service();
            String machineStatus = gson.toJson(machine.getStatus());
            res.status(200);
            return machineStatus;
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