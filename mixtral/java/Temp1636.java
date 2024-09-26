import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import kong.unirest.Unirest;

public class Temp1636 {
    public static void main(String[] args) {
        // Mocking asJson.getHeaders().get("Set-Cookie") for demonstration purposes.
        // In a real scenario, replace this with your actual implementation to get headers.
        List<String> jSessionId = List.of("JSESSIONID=12345; Path=/; HttpOnly", "OtherCookie=67890; Path=/; HttpOnly");

        if (jSessionId != null) {
            String cookieValue = jSessionId
                .stream()
                .filter(cookie -> cookie.contains("JSESSIONID"))
                .findFirst()
                .map(cookie -> cookie.split(";")[0])
                .orElse("");

            Unirest.setDefaultHeader("Cookie", cookieValue);
        }
        
        // For demonstration purposes, print the default headers to verify the result.
        System.out.println(Unirest.config().getDefaultHeaders());
    }
}