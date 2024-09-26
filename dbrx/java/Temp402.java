import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.DigestAuthContext;

public class Temp402 {
    public static void main(String[] args) {

        DatabaseClient client = DatabaseClientFactory.newClient(
            "localhost", 8000, // replace with MarkLogic server host and port
            new DigestAuthContext("username", "password".toCharArray())); // replace with actual username and password

        // Perform your operations here...

        // Release the client
        client.release();
    }
}