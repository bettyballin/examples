import spark.Spark;

public class Temp1088 {
    public static void main(String[] args) {
        Spark.before((request, response) -> {
            response.header("Cache-Control", "no-store, no-cache, must-revalidate, private");
            response.header("Pragma", "no-cache");
            response.header("Expires", "0");
        });

        Spark.get("/hello", (req, res) -> "Hello World");
    }
}