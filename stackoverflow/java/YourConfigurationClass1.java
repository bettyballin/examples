import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.JwtDecoderFactory;
import org.springframework.security.oauth2.core.ClientRegistration;

import java.util.LinkedHashMap;
import java.util.Map;

public class YourConfigurationClass1 {

    private static final String DECODING_ERROR_MESSAGE_TEMPLATE = "An error occurred while attempting to decode the Jwt: %s";

    @Bean
    public JwtDecoderFactory<ClientRegistration> jwtDecoderFactory() {
        return context -> new JwtDecoder() {

            @Override
            public Jwt decode(String token) throws JwtException {
                try {
                    // Your JWT parsing logic goes here
                    Map<String, Object> headers = new LinkedHashMap<>(); // Replace with actual header parsing
                    Map<String, Object> claims = new LinkedHashMap<>(); // Replace with actual claim parsing
                    return Jwt.withTokenValue(token)
                            .headers(h -> h.putAll(headers))
                            .claims(c -> c.putAll(claims))
                            .build();
                } catch (Exception ex) {
                    if (ex.getCause() instanceof ParseException) {
                        throw new JwtException(String.format(DECODING_ERROR_MESSAGE_TEMPLATE, "Malformed payload"));
                    } else {
                        throw new JwtException(String.format(DECODING_ERROR_MESSAGE_TEMPLATE, ex.getMessage()), ex);
                    }
                }
            }
        };
    }
}