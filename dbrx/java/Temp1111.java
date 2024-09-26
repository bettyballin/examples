import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class Temp1111 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1111.class, args);
    }

    @EnableWebSecurity
    public static class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.x509()
                .and()
                .authorizeRequests(auth -> auth
                    .antMatchers(HttpMethod.POST, "/customers").hasRole("USER")
                    // Add more antMatchers for other methods and resources here...
                    .anyRequest().authenticated()
                );

            return http.build();
        }
    }
}