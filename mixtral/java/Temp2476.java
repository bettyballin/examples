import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Temp2476 {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
          .authorizeRequests(authorize -> authorize
            .anyRequest().authenticated()
          )
          .userDetailsService(this.userDetailsService);

        return http.build();
    }

    public static void main(String[] args) {
        // SpringApplication.run(Temp2476.class, args);
        // Main method typically used to launch the Spring Boot application.
    }
}