import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Temp1527 {
    public static void main(String[] args) {
        // Testing the interface
        ServiceCoreClient client = new ServiceCoreClientImpl();
        Data data = new Data("Example data");
        client.insertData("exampleToken", data);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface RequestLine {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Headers {
    String[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Param {
    String value();
}

class Data {
    private String content;

    public Data(String content) {
        this.content = content;
    }

    // Getters and setters (if needed)
}

interface ServiceCoreClient {

    @RequestLine("POST /insert-data")
    @Headers({"Content-Type: application/json {jwtToken}"})
    void insertData(@Param("jwtToken") String jwtToken, Data data);
}

class ServiceCoreClientImpl implements ServiceCoreClient {
    @Override
    public void insertData(String jwtToken, Data data) {
        // Implementation for demonstration purposes
        System.out.println("JWT Token: " + jwtToken);
        System.out.println("Data: " + data);
    }
}