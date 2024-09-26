import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class Temp3566 {

    public static void main(String[] args) {
        SpringApplication.run(Temp3566.class, args);
    }

    @Bean
    public SecurityFilterChain swaggerFilterChain(HttpSecurity http) throws Exception {

        http
                .requestMatchers().antMatchers("/swagger-ui/index.html", "/v3/api-docs/", "/v3/api-docs")
                .and()
                .authenticationProvider(authenticationProvider())
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        // Provide your custom authentication provider implementation here
        return null;
    }
}