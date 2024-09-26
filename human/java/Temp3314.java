import org.springframework.http.HttpMethod;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.ServerWebExchange;

public class Temp3314 {
    public static void main(String[] args) {
        ServerWebExchangeMatchers.matchers(
            ServerWebExchangeMatchers.pathMatchers(HttpMethod.POST, "/**"),
            ServerWebExchangeMatchers.pathMatchers(HttpMethod.PUT, "/**"),
            ServerWebExchangeMatchers.pathMatchers(HttpMethod.DELETE, "/**")
        ).matches(new DummyServerWebExchange())
        .subscribe(matchResult -> {
            if (matchResult.isMatch()) {
                System.out.println("Matched");
            } else {
                System.out.println("Not Matched");
            }
        });
    }
}

class DummyServerWebExchange implements ServerWebExchange {
    // Implement all methods from ServerWebExchange here, for simplicity, we can leave them empty or return null/default values.
}