import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RestTemplate rest = new RestTemplate();
        String jwksUri = "https://login.microsoftonline.com/common/discover/v2.0/keys";
        ResponseEntity<Map> response = rest.exchange(jwksUri, HttpMethod.GET, null, Map.class);

        System.out.println(response.getBody());
    }
}