import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp2588 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2588.class, args);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((authz) -> authz
                .requestMatchers("/api/core/**").permitAll()
                .requestMatchers("/api/module2/**").permitAll()
                .anyRequest().authenticated());

        return http.build();
    }
}