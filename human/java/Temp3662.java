import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class Temp3662 {
    public static void main(String[] args) {
        // This is just an example class to demonstrate the Spring Security configuration.
        // It won't run as a standalone Java application since it requires a Spring Boot context.
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and().csrf().disable();
        return http.build();
    }
}