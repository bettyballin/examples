import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TokenFetcher {

    public String getToken() {
        String grantType = "client_credentials";
        String clientId = "abcd";
        String clientSecret = "mpoo";
        String auth = clientId + ":" + clientSecret;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + encodedAuth;

        Form form = new Form();
        form.param("grant_type", grantType);

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:9001/oauth/token");

        Response response = webTarget.request()
                .header("Authorization", authHeader)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        String output = response.readEntity(String.class);
        response.close();

        return output;
    }
}