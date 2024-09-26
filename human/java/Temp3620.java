import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class Temp3620 {
    public static void main(String[] args) {
        // Main method implementation
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .oauth2Client()
            .and()
            .logout()
            .and()
            .oauth2Login()
            .redirectionEndpoint().baseUri("/login/oauth2/code/cognito");

        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer().jwt();

        return http.build();
    }
}