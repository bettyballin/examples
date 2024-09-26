import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Temp2543 {
    public static void main(String[] args) {
        // This main method is not required for Spring Security configuration
    }

    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
        // Token-based security
        return http
            .requestMatcher((request) -> request.getHeader("Authorization") != null)
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .oauth2ResourceServer()
                    .jwt()
            .and().build();
    }

    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
        // Interactive/web users authentication
        return http
            .authorizeRequests().anyRequest().authenticated()
            .and()
                .oauth2Client()
            .and()
                .logout()
            .and()
                .oauth2Login()
            .and()
                .csrf().disable();
    }
}