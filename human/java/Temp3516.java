import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.WebTarget;

public class Temp3516 {
    public static void main(String[] args) {
        String client_id = "your_client_id";
        String client_secret = "your_client_secret";

        String credentials = client_id + ":" + client_secret;
        String base64 = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));

        Client client = ClientBuilder.newClient();
        WebTarget jerseyWebTarget = client.target("your_api_endpoint");

        Form form = new Form();
        // Add form parameters here
        // form.param("key", "value");

        Response res = jerseyWebTarget.request()
                .header(HttpHeaders.AUTHORIZATION, "Basic " + base64)
                .post(Entity.form(form));

        System.out.println("Response: " + res.getStatus());
        System.out.println("Response body: " + res.readEntity(String.class));

        res.close();
        client.close();
    }
}