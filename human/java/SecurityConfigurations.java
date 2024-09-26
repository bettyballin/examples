import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Configuration
    @Order(1)
    public static class NoAuth extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http.requestMatcher(r -> r.getRequestURL().toString().startsWith("http://localhost:8081"))
                    .authorizeRequests()
                    .anyRequest().permitAll();
        }
    }

    @Configuration
    @Order(2)
    public static class Auth extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            final byte[] salt = "random".getBytes(StandardCharsets.UTF_8);
            KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 256);
            SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
            System.out.println(Base64.getEncoder().encodeToString(key.getEncoded()));

            http.authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .oauth2ResourceServer()
                    .jwt()
                    .decoder(NimbusJwtDecoder.withSecretKey(key).build());
        }
    }
}