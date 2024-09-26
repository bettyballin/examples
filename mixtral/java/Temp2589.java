import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp2589 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2589.class, args);
    }

    // This will be executed first
    @Bean
    @Order(1)
    public SecurityFilterChain securityFilterChainOne(HttpSecurity http) throws Exception {
        // Configure your security settings here
        // Example:
        http
            .authorizeRequests()
                .antMatchers("/first/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin();
        return http.build();
    }

    // This will be executed second
    @Bean
    @Order(2)
    public SecurityFilterChain securityFilterChainTwo(HttpSecurity http) throws Exception {
        // Configure your security settings here
        // Example:
        http
            .authorizeRequests()
                .antMatchers("/second/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin();
        return http.build();
    }
}