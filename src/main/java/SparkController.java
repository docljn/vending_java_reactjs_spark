
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