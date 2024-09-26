import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {
        return new CustomFeignConfig();
    }

}

class CustomFeignConfig implements RequestInterceptor {

    private final String AUTHORIZATION_HEADER = "Authorization";

    // Get the JWT token from your authentication service or wherever you store it.
    private Optional<String> getJwtToken() {
        // Replace this with the actual method to retrieve the JWT token
        // For example, return Optional.of("your-jwt-token");
        return Optional.of("your-jwt-token");
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Optional<String> optionalToken = getJwtToken();

        if (optionalToken.isPresent()){
            String jwtToken = "Bearer ".concat(optionalToken.get());

            // Add the JWT token to each Feign client's request header
            requestTemplate.header(AUTHORIZATION_HEADER, jwtToken);
        }
    }

}