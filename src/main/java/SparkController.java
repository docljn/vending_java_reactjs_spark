import static spark.Spark.*;

public class SparkController {

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();
        machine.service();

        get("/hello", (req, res) -> "Hello World");

        get("/", (req, res) -> {
            return "";
        } );
    }
}

