import static spark.Spark.*;

public class SparkRoutes {

    public static void main(String[] args) {

        get("/hello", (req, res) -> "Hello World");

        get("/", (req, res) -> {
            return "";
        } );
    }
}

