import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp2622 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2622.class, args);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        return http
            .authorizeRequests((requests) -> requests
                .antMatchers("/api/**").authenticated()
            )
            .build();
        // @formatter:on
    }
}