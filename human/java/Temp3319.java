import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoderFactory;
import org.springframework.security.oauth2.jwt.JwtException;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;

import lombok.SneakyThrows;

public class Temp3319 {
    private static final String DECODING_ERROR_MESSAGE_TEMPLATE = "Error decoding JWT: %s";

    public static void main(String[] args) {
        Temp3319 temp = new Temp3319();
        JwtDecoderFactory<ClientRegistration> factory = temp.jwtDecoderFactory();
        // Testing with a dummy ClientRegistration and token
        ClientRegistration registration = ClientRegistration.withRegistrationId("dummy").build();
        JwtDecoder decoder = factory.createDecoder(registration);
        try {
            Jwt jwt = decoder.decode("dummyToken");
            System.out.println("Decoded JWT: " + jwt);
        } catch (JwtException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Bean
    public JwtDecoderFactory<ClientRegistration> jwtDecoderFactory() {
        final JwtDecoder decoder = new JwtDecoder() {

            @SneakyThrows
            @Override
            public Jwt decode(String token) throws JwtException {
                JWT jwt = JWTParser.parse(token);
                return createJwt(token, jwt);
            }

            private Jwt createJwt(String token, JWT parsedJwt) {
                try {
                    Map<String, Object> headers = new LinkedHashMap<>(parsedJwt.getHeader().toJSONObject());
                    Map<String, Object> claims = parsedJwt.getJWTClaimsSet().getClaims();
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
        return context -> decoder;
    }
}