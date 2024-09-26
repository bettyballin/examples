import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class OAuthTokenInterceptor implements ClientHttpRequestInterceptor {
    private final TokenService tokenService;

    @NotNull
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add("Authorization", "Bearer " + tokenService.getRefreshedToken().getValue());
        return execution.execute(request, body);
    }

    public static void main(String[] args) {
        // Example usage (requires a proper implementation of TokenService)
        TokenService tokenService = new TokenService();
        OAuthTokenInterceptor interceptor = new OAuthTokenInterceptor(tokenService);

        // Add interceptor to RestTemplate or other HTTP client as needed
    }
}

// Dummy TokenService implementation for the sake of completeness
class TokenService {
    public Token getRefreshedToken() {
        return new Token("dummy_token_value");
    }
}

// Dummy Token class for the sake of completeness
class Token {
    private final String value;

    public Token(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}